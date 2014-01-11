package commanderadz.main.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemGreenRod extends Item{

	public ItemGreenRod(int id) {
		super(id);
		setUnlocalizedName("greenrod");
		setCreativeTab(CreativeTabs.tabBlock);
	}
	
	public void onUpdate(ItemStack itemstack, World world, Entity entity, int i, boolean flag)
	{
	EntityPlayer Player = (EntityPlayer) entity;
	if(Player.getCurrentEquippedItem() !=null && Player.getCurrentEquippedItem().itemID == this.itemID)
	{
		Player.addPotionEffect(new PotionEffect(Potion.heal.id, 1, 2, true));
        Player.addPotionEffect(new PotionEffect(Potion.resistance.id, 1, 2, true));
        Player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 1, 2, true));
        Player.addPotionEffect(new PotionEffect(Potion.field_76443_y.id, 1, 2, true));
	}
	else
	{
	Player.curePotionEffects(itemstack);
	}
	}
}
