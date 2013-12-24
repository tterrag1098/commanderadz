package commanderadz.main.blocks;

import commanderadz.main.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;

public class ItemWhiteBucket extends ItemBucket {
    public ItemWhiteBucket(int id){
        super(id, id);
        setUnlocalizedName("itemwhitebucket");
        setCreativeTab(CreativeTabs.tabBlock);
}

@Override
@SideOnly(Side.CLIENT)
public void registerIcons(IconRegister reg){
        this.itemIcon = reg.registerIcon(Reference.MOD_TEXTUREPATH + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 5));
}
}
