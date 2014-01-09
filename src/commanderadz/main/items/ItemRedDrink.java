package commanderadz.main.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;

public class ItemRedDrink extends ItemFood {

	public ItemRedDrink(int id, int foodAmount, float sat, boolean isWolfMeat){
		super(id, foodAmount, sat, isWolfMeat);
		setUnlocalizedName("itemreddrink");
	    setCreativeTab(CreativeTabs.tabBlock);
	}
	


}
