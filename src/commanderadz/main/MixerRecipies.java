package commanderadz.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MixerRecipies
{
	private Map<ArrayList<Integer>, ItemStack> mixerList = new HashMap<ArrayList<Integer>, ItemStack>();
	private Map<Integer, Float> mixerExperience = new HashMap<Integer, Float>();
	private static final MixerRecipies mixerBase = new MixerRecipies();

	public static final MixerRecipies instance()
	{
		return mixerBase;
	}

	public ItemStack getRecipeResult(int id1, int id2)
	{
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(id1);
		array.add(id2);
		
		return (ItemStack) mixerList.get(array);
	}

	public void addMixerRecipe(int id1, int id2, ItemStack itemStack, float experience)
	{
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(id1);
		array.add(id2);
		
		mixerList.put(array, itemStack);
		this.mixerExperience.put(Integer.valueOf(itemStack.itemID), Float.valueOf(experience));
	}

	public float getExperience(int par1)
	{
		return this.mixerExperience.containsKey(Integer.valueOf(par1)) ? ((Float) this.mixerExperience.get(Integer.valueOf(par1))).floatValue() : 0.0F;
	}

	private MixerRecipies()
	{
		addMixerRecipe(Item.appleRed.itemID, Item.bucketWater.itemID, new ItemStack(Item.bucketEmpty.itemID, 1, 0), 0.7F);
		addMixerRecipe(Item.ingotGold.itemID, Item.bucketWater.itemID, new ItemStack(CommanderAdz.itemyellowBucket, 1, 0), 0.7F);
	}
}