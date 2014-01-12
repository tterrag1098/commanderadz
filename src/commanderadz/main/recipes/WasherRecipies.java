package commanderadz.main.recipes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import commanderadz.main.CommanderAdz;

import net.minecraft.item.ItemStack;

public class WasherRecipies
{
	private Map<ArrayList<Integer>, ItemStack> washerList = new HashMap<ArrayList<Integer>, ItemStack>();
	private Map<Integer, Float> washerExperience = new HashMap<Integer, Float>();
	private static final WasherRecipies washerBase = new WasherRecipies();

	public static final WasherRecipies instance()
	{
		return washerBase;
	}

	public ItemStack getRecipeResult(int id1, int id2)
	{
		ArrayList<Integer> array1 = new ArrayList<Integer>(), array2 = new ArrayList<Integer>();
		
		array1.add(id1);
		array1.add(id2);
		
		array2.add(id2);
		array2.add(id1);
		
		return washerList.get(array1) == null ? washerList.get(array2) : washerList.get(array1);
	}

	public void addWasherRecipe(int id1, int id2, ItemStack itemStack, float experience)
	{
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(id1);
		array.add(id2);
		
		washerList.put(array, itemStack);
		this.washerExperience.put(Integer.valueOf(itemStack.itemID), Float.valueOf(experience));
	}

	public float getExperience(int par1)
	{
		return this.washerExperience.containsKey(Integer.valueOf(par1)) ? this.washerExperience.get(Integer.valueOf(par1)).floatValue() : 0.0F;
	}

	private WasherRecipies()
	{
		addWasherRecipe(CommanderAdz.itemfluidFilter.itemID, CommanderAdz.itemwhitedirtDrink.itemID, new ItemStack(CommanderAdz.itemwhiteDrink, 1, 0), 0.7F);
		addWasherRecipe(CommanderAdz.itemfluidFilter.itemID, CommanderAdz.itemgreendirtDrink.itemID, new ItemStack(CommanderAdz.itemgreenDrink, 1, 0), 0.7F);
		addWasherRecipe(CommanderAdz.itemfluidFilter.itemID, CommanderAdz.itemreddirtDrink.itemID, new ItemStack(CommanderAdz.itemredDrink, 1, 0), 0.7F);
		addWasherRecipe(CommanderAdz.itemfluidFilter.itemID, CommanderAdz.itempurpledirtDrink.itemID, new ItemStack(CommanderAdz.itempurpleDrink, 1, 0), 0.7F);
		addWasherRecipe(CommanderAdz.itemfluidFilter.itemID, CommanderAdz.itemturquoisedirtDrink.itemID, new ItemStack(CommanderAdz.itemturquoiseDrink, 1, 0), 0.7F);
		addWasherRecipe(CommanderAdz.itemfluidFilter.itemID, CommanderAdz.itemyellowdirtDrink.itemID, new ItemStack(CommanderAdz.itemyellowDrink, 1, 0), 0.7F);
	}
}