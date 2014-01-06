package commanderadz.main;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MixerRecipies
{
	private Map<Integer[], ItemStack> mixerList = new HashMap<Integer[], ItemStack>();
	private Map<Integer, Float> mixerExperience = new HashMap<Integer, Float>();
	private static final MixerRecipies mixerBase = new MixerRecipies();

	public static final MixerRecipies instance()
	{
		return mixerBase;
	}

	public ItemStack getRecipeResult(int id1, int id2)
	{
		return (ItemStack) mixerList.get(new Integer[]{id1, id2});
	}

	public void addSmelting(int id1, int id2, ItemStack itemStack, float experience)
	{
		mixerList.put(new Integer[]{id1, id2}, itemStack);
		this.mixerExperience.put(Integer.valueOf(itemStack.itemID), Float.valueOf(experience));
	}

	public float getExperience(int par1)
	{
		return this.mixerExperience.containsKey(Integer.valueOf(par1)) ? ((Float) this.mixerExperience.get(Integer.valueOf(par1))).floatValue() : 0.0F;
	}

	private MixerRecipies()
	{
		addSmelting(Item.appleRed.itemID, Item.bucketWater.itemID, new ItemStack(Item.bucketEmpty.itemID, 1, 0), 0.7F);
	}
}