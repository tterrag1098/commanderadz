package commanderadz.main.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBucket;

import commanderadz.main.registry.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemRedBucket extends ItemBucket {
    public ItemRedBucket(int id, int lid){
        super(id, lid);
        setUnlocalizedName("itemredbucket");
        setCreativeTab(CreativeTabs.tabBlock);
}

@Override
@SideOnly(Side.CLIENT)
public void registerIcons(IconRegister reg){
        this.itemIcon = reg.registerIcon(Reference.MOD_TEXTUREPATH + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 5));
}
}
