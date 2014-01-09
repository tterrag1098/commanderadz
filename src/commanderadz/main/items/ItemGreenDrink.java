package commanderadz.main.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

public class ItemGreenDrink extends ItemFood {

	public ItemGreenDrink(int id, int foodAmount, float sat, boolean isWolfMeat){
		super(id, foodAmount, sat, isWolfMeat);
		 setUnlocalizedName("itemgreendrink");
	        setCreativeTab(CreativeTabs.tabBlock);
	}
	


}
