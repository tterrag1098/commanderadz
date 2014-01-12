package commanderadz.main.items;

import java.util.List;

import commanderadz.main.registry.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;

public class ItemGreenDrinkDirty extends Item {
    public ItemGreenDrinkDirty(int id){
        super(id);
        setUnlocalizedName("greendrinkdirty");
        setCreativeTab(CreativeTabs.tabBlock);
}
    
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List dataList, boolean bool){
		dataList.add("\u00a7bDirty - Try Washing It");
	}

@Override
@SideOnly(Side.CLIENT)
public void registerIcons(IconRegister reg){
        this.itemIcon = reg.registerIcon(Reference.MOD_TEXTUREPATH + ":" + "greendrink");
}
}
