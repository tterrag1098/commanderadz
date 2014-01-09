package commanderadz.main.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

public class ItemTurquoiseDrink extends ItemFood {

	public ItemTurquoiseDrink(int id, int foodAmount, float sat, boolean isWolfMeat){
		super(id, foodAmount, sat, isWolfMeat);
		setUnlocalizedName("itemturquoisedrink");
	    setCreativeTab(CreativeTabs.tabBlock);
	}
	


}
