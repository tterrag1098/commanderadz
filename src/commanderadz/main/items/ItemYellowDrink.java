package commanderadz.main.items;

import java.util.List;

import commanderadz.main.registry.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemYellowDrink extends Item {
    public ItemYellowDrink(int id){
        super(id);
        setUnlocalizedName("yellowdrink");
        setCreativeTab(CreativeTabs.tabBlock);
}
    
    @Override
	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        if (!par3EntityPlayer.capabilities.isCreativeMode)
        {
            --par1ItemStack.stackSize;
        }

        if (!par2World.isRemote)
        {
            par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.heal.id, 20, 5, true));
            par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.field_76443_y.id, 20, 5, true));
        }

        return par1ItemStack.stackSize <= 0 ? new ItemStack(Item.glassBottle) : par1ItemStack;
    }

    @Override
	public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 32;
    }

    @Override
	public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.drink;
    }

    @Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        return par1ItemStack;
    }

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List dataList, boolean bool){
		dataList.add("\u00a7bNice and Clean");
	}
	
@Override
@SideOnly(Side.CLIENT)
public void registerIcons(IconRegister reg){
        this.itemIcon = reg.registerIcon(Reference.MOD_TEXTUREPATH + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
}
}
