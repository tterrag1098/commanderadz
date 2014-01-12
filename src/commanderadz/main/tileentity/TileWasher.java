package commanderadz.main.tileentity;

import commanderadz.main.CommanderAdz;
import commanderadz.main.recipes.WasherRecipies;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileWasher extends TileEntity implements IInventory
{
	private ItemStack[] inventory;
	public int pressTime = 0;
	public int abc = 1;

	public TileWasher()
	{
		this.inventory = new ItemStack[3];
	}

	@Override
	public int getSizeInventory()
	{
		return this.inventory.length;
	}

	@Override
	public ItemStack getStackInSlot(int i)
	{
		return this.inventory[i];
	}

	@Override
	public ItemStack decrStackSize(int slotIndex, int amount)
	{
		ItemStack stack = getStackInSlot(slotIndex);

		if (stack != null)
		{

			if (stack.stackSize <= amount)
			{
				setInventorySlotContents(slotIndex, null);
			}
			else
			{
				stack = stack.splitStack(amount);
				if (stack.stackSize == 0)
				{
					setInventorySlotContents(slotIndex, null);
				}
			}
		}
		return stack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slotIndex)
	{
		ItemStack stack = getStackInSlot(slotIndex);

		if (stack != null)
		{
			setInventorySlotContents(slotIndex, null);
		}

		return stack;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack)
	{
		this.inventory[slot] = stack;

		if (stack != null && stack.stackSize > getInventoryStackLimit())
		{
			stack.stackSize = getInventoryStackLimit();
		}

	}

	@Override
	public String getInvName()
	{
		return "Coin Press";
	}

	@Override
	public boolean isInvNameLocalized()
	{
		return false;
	}

	@Override
	public int getInventoryStackLimit()
	{
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer)
	{
		return worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) == this && entityplayer.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
	}

	@Override
	public void openChest()
	{
	}

	@Override
	public void closeChest()
	{
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack)
	{
		return false;
	}

	@Override
	public void readFromNBT(NBTTagCompound tagCompound)
	{
		super.readFromNBT(tagCompound);

		NBTTagList tagList = tagCompound.getTagList("Inventory");

		for (int i = 0; i < tagList.tagCount(); i++)
		{
			NBTTagCompound tag = (NBTTagCompound) tagList.tagAt(i);

			byte slot = tag.getByte("Slot");

			if (slot >= 0 && slot < inventory.length)
			{
				inventory[slot] = ItemStack.loadItemStackFromNBT(tag);
			}
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound tagCompound)
	{
		super.writeToNBT(tagCompound);

		NBTTagList itemList = new NBTTagList();

		for (int i = 0; i < inventory.length; i++)
		{
			ItemStack stack = inventory[i];

			if (stack != null)
			{
				NBTTagCompound tag = new NBTTagCompound();

				tag.setByte("Slot", (byte) i);
				stack.writeToNBT(tag);
				itemList.appendTag(tag);
			}
		}

		tagCompound.setTag("Inventory", itemList);
	}

	public void pressItem()
	{
		if (this.inventory[0] != null && this.inventory[1] != null)
		{
			ItemStack var1 = WasherRecipies.instance().getRecipeResult(this.inventory[0].getItem().itemID, this.inventory[1].getItem().itemID);
			if (this.inventory[2] == null)
			{
				this.inventory[2] = var1.copy();
			}
			else if (this.inventory[2].itemID == var1.itemID)
			{
				System.out.println("2");
				++this.inventory[2].stackSize;
			}
			this.inventory[0].getItem().setContainerItem(null);
			this.inventory[1].getItem().setContainerItem(null);
			this.inventory[getFilterSlot()].setItemDamage(inventory[getFilterSlot()].getItemDamage() + 1);
			this.inventory[getNotFilterSlot()].stackSize--;
			if (inventory[getFilterSlot()].getItemDamage() >= 10)
				inventory[getFilterSlot()].stackSize--;
			
			if (this.inventory[0].stackSize == 0)
			{
				Item var2 = this.inventory[0].getItem().getContainerItem();
				this.inventory[0] = var2 == null ? null : new ItemStack(var2);
			}
			
			
			if (this.inventory[1].stackSize == 0)
			{
				Item var2 = this.inventory[1].getItem().getContainerItem();
				this.inventory[1] = var2 == null ? null : new ItemStack(var2);
			}
		}

	}

	public boolean canPress()
	{
		if (inventory[0] == null || inventory[1] == null)
		{
			abc = 0;
			return false;
		}

		ItemStack itemstack = WasherRecipies.instance().getRecipeResult(inventory[0].getItem().itemID, inventory[1].getItem().itemID);

		if (itemstack == null)
		{
			return false;
		}

		if (inventory[2] == null)
		{

			return true;
		}

		if (!inventory[2].isItemEqual(itemstack))
		{

			return false;
		}

		if (inventory[2].stackSize < getInventoryStackLimit() && inventory[1].stackSize < inventory[1].getMaxStackSize())
		{

			return true;
		}

		return inventory[2].stackSize < itemstack.getMaxStackSize();
	}

	@Override
	public void updateEntity()
	{
		if (canPress() && abc == 0)
			abc = 1;
		
		if (abc >= 100)
		{
			if (canPress())
			{
				pressItem();
				System.out.println("Its 100: " + abc);
			}
			abc = 0;
		}
		else if (abc > 0)
		{
			abc++;
		}
		this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
	}

	public int getCookProgressScaled(int par1)
	{
		return this.abc * par1 / 50;
	}
	
	public int getFilterSlot()
	{
		return inventory[0].getItem() == CommanderAdz.itemfluidFilter ? 0 : 1;
	}
	
	public int getNotFilterSlot()
	{
		return getFilterSlot() == 0 ? 1 : 0;
	}

}