package commanderadz.main.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import commanderadz.main.tileentity.TileMixer;

public class ContainerMixer extends Container
{
	private class SlotMixer extends Slot
	{
		public SlotMixer(IInventory par1iInventory, int par2, int par3, int par4)
		{
			super(par1iInventory, par2, par3, par4);
		}
		
		@Override
		public boolean isItemValid(ItemStack stack)
		{
			return false;
		}
	}
	
	protected TileMixer tile_entity;

	public ContainerMixer(TileMixer tile_entity, InventoryPlayer player_inventory)
	{
		this.tile_entity = tile_entity;

		addSlotToContainer(new Slot(tile_entity, 0, 36, 35));
		addSlotToContainer(new Slot(tile_entity, 1, 56, 35));
		addSlotToContainer(new SlotMixer(tile_entity, 2, 116, 35));

		bindPlayerInventory(player_inventory);
	}

	private void bindPlayerInventory(InventoryPlayer player_inventory)
	{
		// TODO Auto-generated method stub
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				addSlotToContainer(new Slot(player_inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));

			}
		}

		for (int i = 0; i < 9; i++)
		{
			addSlotToContainer(new Slot(player_inventory, i, 8 + i * 18, 142));

		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer)
	{
		return tile_entity.isUseableByPlayer(entityplayer);
	}

	public ItemStack transferStackInSlot(EntityPlayer player, int slot)
	{
		ItemStack itemstack1 = null;
		Slot slotObj = (Slot) this.inventorySlots.get(slot);

		if (slotObj != null && slotObj.getHasStack())
		{
			itemstack1 = slotObj.getStack();
			if (slot < 3)
			{
				if (!this.mergeItemStack(itemstack1, 30, 39, false))
				{
					if (!this.mergeItemStack(itemstack1, 3, 27, false))
						return null;
				}
				slotObj.onSlotChange(itemstack1, itemstack1);
			}
			else if (slot > 2)
			{
				if (slot < 30)
				{
					if (!this.mergeItemStack(itemstack1, 0, 2, false))
						if (!this.mergeItemStack(itemstack1, 30, 39, false))
							return null;
					slotObj.onSlotChange(itemstack1, itemstack1);
				}
				else if (slot > 29)
				{
					if (!this.mergeItemStack(itemstack1, 0, 2, false))
						if (!this.mergeItemStack(itemstack1, 3, 29, false))
							return null;
					slotObj.onSlotChange(itemstack1, itemstack1);
				}
			}

			if (itemstack1.stackSize == 0)
			{
				slotObj.putStack((ItemStack) null);
			}
			else
			{
				slotObj.onSlotChanged();
			}
			if (itemstack1.stackSize == itemstack1.stackSize)
			{
				return null;
			}
			slotObj.onPickupFromSlot(player, itemstack1);
			if (itemstack1.stackSize == 0)
			{
				slotObj.putStack(null);
				return null;
			}
		}
		return itemstack1;
	}
}