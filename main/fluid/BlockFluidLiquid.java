package commanderadz.main.fluid;

import commanderadz.main.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class BlockFluidLiquid extends BlockFluidClassic{
	
    @SideOnly(Side.CLIENT)
    public Icon stillIcon;
    @SideOnly(Side.CLIENT)
    public Icon flowingIcon;
	
	public BlockFluidLiquid(int id, Fluid fluid){
		super(id, fluid, Material.water);
		setCreativeTab(CreativeTabs.tabBlock);
		
	}
	
    @Override
    public Icon getIcon(int side, int meta) {
            return (side == 0 || side == 1)? stillIcon : flowingIcon;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IconRegister register) {
            stillIcon = register.registerIcon(Reference.MOD_TEXTUREPATH + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
            flowingIcon = register.registerIcon(Reference.MOD_TEXTUREPATH + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }
    
    @Override
    public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
            if (world.getBlockMaterial(x,  y,  z).isLiquid()) return false;
            return super.canDisplace(world, x, y, z);
    }
    
    @Override
    public boolean displaceIfPossible(World world, int x, int y, int z) {
            if (world.getBlockMaterial(x,  y,  z).isLiquid()) return false;
            return super.displaceIfPossible(world, x, y, z);
    }

}
