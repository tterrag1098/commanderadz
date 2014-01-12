package commanderadz.main.items;

import commanderadz.main.registry.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemFilter extends Item {
    public ItemFilter(int id){
        super(id);
        setUnlocalizedName("filter");
        setCreativeTab(CreativeTabs.tabBlock);
        maxStackSize = 1;
        this.setMaxDamage(10);
    }
    
@Override
@SideOnly(Side.CLIENT)
public void registerIcons(IconRegister reg){
        this.itemIcon = reg.registerIcon(Reference.MOD_TEXTUREPATH + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
}
}
