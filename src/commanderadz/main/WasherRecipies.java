package commanderadz.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import net.minecraft.item.Item;
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
		return this.washerExperience.containsKey(Integer.valueOf(par1)) ? ((Float) this.washerExperience.get(Integer.valueOf(par1))).floatValue() : 0.0F;
	}

	private WasherRecipies()
	{
		addWasherRecipe(Item.ingotGold.itemID, Item.bucketWater.itemID, new ItemStack(CommanderAdz.itemyellowBucket, 1, 0), 0.7F);
	}
}