package commanderadz.main.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

public class ItemPurpleDrink extends ItemFood {

	public ItemPurpleDrink(int id, int foodAmount, float sat, boolean isWolfMeat){
		super(id, foodAmount, sat, isWolfMeat);
		setUnlocalizedName("itempurpledrink");
	    setCreativeTab(CreativeTabs.tabBlock);
	}
	
	
	


}
