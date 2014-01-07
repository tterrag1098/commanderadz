package commanderadz.main.items;

import commanderadz.main.registry.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;

public class ItemPurplePowder extends Item {
    public ItemPurplePowder(int id){
        super(id);
        setUnlocalizedName("itempurplepowder");
        setCreativeTab(CreativeTabs.tabBlock);
}

@Override
@SideOnly(Side.CLIENT)
public void registerIcons(IconRegister reg){
        this.itemIcon = reg.registerIcon(Reference.MOD_TEXTUREPATH + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 5));
}
}
