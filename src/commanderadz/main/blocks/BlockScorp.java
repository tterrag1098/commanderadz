package commanderadz.main.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import commanderadz.main.registry.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockScorp extends Block{

        public BlockScorp(int id){
                super(id, Material.rock);
                setUnlocalizedName("scorp");
                setCreativeTab(CreativeTabs.tabBlock);
                setHardness(3);
        }
        @SideOnly(Side.CLIENT)
        private Icon side, bottom, top, front;
        
        @Override
		@SideOnly(Side.CLIENT)
        public void registerIcons(IconRegister reg){
                this.side = reg.registerIcon(Reference.MOD_TEXTUREPATH + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1) + "front");
                this.bottom = reg.registerIcon(Reference.MOD_TEXTUREPATH + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1) + "bottom");
                this.top = reg.registerIcon(Reference.MOD_TEXTUREPATH + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1) + "top");
                this.front = reg.registerIcon(Reference.MOD_TEXTUREPATH + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1) + "front");
        }
        
        @SideOnly(Side.CLIENT)
    @Override
    public Icon getIcon(int side, int metadata){
                if (side == 1) return this.top;
                else if (side == 0) return this.top;
                else if (metadata == 2 && side == 2) return this.front;
              else if (metadata == 3 && side == 5) return this.front;
              else if (metadata == 0 && side == 3) return this.front;
              else if (metadata == 1 && side == 4) return this.front;
              else return this.side;
        
                
        }
        
        @Override
		public void onBlockPlacedBy(World par1World, int x, int y, int z, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
    {
        int whichDirectionFacing = MathHelper.floor_double(par5EntityLivingBase.rotationYaw * 4.0F / 360.0F + 2.5D) & 3;
        par1World.setBlockMetadataWithNotify(x, y, z, whichDirectionFacing, 2);
    }
}