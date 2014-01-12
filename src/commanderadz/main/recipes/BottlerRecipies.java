package commanderadz.main.recipes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import commanderadz.main.CommanderAdz;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BottlerRecipies
{
	private Map<ArrayList<Integer>, ItemStack> bottlerList = new HashMap<ArrayList<Integer>, ItemStack>();
	private Map<Integer, Float> bottlerExperience = new HashMap<Integer, Float>();
	private static final BottlerRecipies bottlerBase = new BottlerRecipies();

	public static final BottlerRecipies instance()
	{
		return bottlerBase;
	}

	public ItemStack getRecipeResult(int id1, int id2)
	{
		ArrayList<Integer> array1 = new ArrayList<Integer>(), array2 = new ArrayList<Integer>();
		
		array1.add(id1);
		array1.add(id2);
		
		array2.add(id2);
		array2.add(id1);
		
		return bottlerList.get(array1) == null ? bottlerList.get(array2) : bottlerList.get(array1);
	}

	public void addBottlerRecipe(int id1, int id2, ItemStack itemStack, float experience)
	{
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(id1);
		array.add(id2);
		
		bottlerList.put(array, itemStack);
		this.bottlerExperience.put(Integer.valueOf(itemStack.itemID), Float.valueOf(experience));
	}

	public float getExperience(int par1)
	{
		return this.bottlerExperience.containsKey(Integer.valueOf(par1)) ? ((Float) this.bottlerExperience.get(Integer.valueOf(par1))).floatValue() : 0.0F;
	}

	private BottlerRecipies()
	{
		addBottlerRecipe(Item.glassBottle.itemID, CommanderAdz.itemwhiteBucket.itemID, new ItemStack(CommanderAdz.itemwhitedirtDrink, 1, 0), 0.7F);
	}
}