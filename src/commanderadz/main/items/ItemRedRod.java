package commanderadz.main.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemRedRod extends Item{

	public ItemRedRod(int id) {
		super(id);
		setUnlocalizedName("redrod");
		setCreativeTab(CreativeTabs.tabBlock);
	}
	
	@Override
	public void onUpdate(ItemStack itemstack, World world, Entity entity, int i, boolean flag)
	{
	EntityPlayer Player = (EntityPlayer) entity;
	if(Player.getCurrentEquippedItem() !=null && Player.getCurrentEquippedItem().itemID == this.itemID)
	{
		 Player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 1, 1, true));
	}
	else
	{
	Player.curePotionEffects(itemstack);
	}
	}
}
