package commanderadz.main.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;

import commanderadz.main.registry.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCommanderAdz extends Block{
    
    public BlockCommanderAdz(int id){
            super(id, Material.rock);
            setUnlocalizedName("commanderadz");
            setCreativeTab(CreativeTabs.tabBlock);
            setHardness(3);
    }
    
    @SideOnly(Side.CLIENT)
    public static Icon topIcon;
    @SideOnly(Side.CLIENT)
    public static Icon bottomIcon;
    @SideOnly(Side.CLIENT)
    public static Icon sideIcon;
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister reg){
            sideIcon = reg.registerIcon(Reference.MOD_TEXTUREPATH + ":" + this.getUnlocalizedName().substring(5) + "side");
            topIcon = reg.registerIcon(Reference.MOD_TEXTUREPATH + ":" + this.getUnlocalizedName().substring(5) + "top");
            bottomIcon = reg.registerIcon(Reference.MOD_TEXTUREPATH + ":" + this.getUnlocalizedName().substring(5) + "bottom");
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIcon(int side, int metadata){
    	if(side == 0){
    		return bottomIcon;
    	}else if(side == 1){
    		return topIcon;
    	}else{
    		return sideIcon;
    	}
    }
 

}