package commanderadz.main;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MixerRecipies {
        private Map mixerList = new HashMap();
        private Map mixerExperience = new HashMap();
        private static final MixerRecipies mixerBase = new MixerRecipies();
        
        public static final MixerRecipies press()
        {
        return mixerBase;
        }
        public ItemStack getPressResult(int id)
        {
        return (ItemStack)mixerList.get(Integer.valueOf(id));
        }
        
        public void addSmelting(int id, ItemStack itemStack, float experience)
        {
                mixerList.put(Integer.valueOf(id), itemStack);
        this.mixerExperience.put(Integer.valueOf(itemStack.itemID), Float.valueOf(experience));
        }
        public float getExperience(int par1)
        {
        return this.mixerExperience.containsKey(Integer.valueOf(par1)) ? ((Float)this.mixerExperience.get(Integer.valueOf(par1))).floatValue() : 0.0F;
        }
        
        private MixerRecipies()
        {
        addSmelting(Item.bucketWater.itemID, new ItemStack(Item.bucketEmpty, 1, 0), 0.7F);
        }
}