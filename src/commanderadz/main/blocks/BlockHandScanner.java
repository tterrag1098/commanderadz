package commanderadz.main.blocks;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.lwjgl.opengl.KHRDebugCallback.Handler;

import commanderadz.main.PacketHandler;
import commanderadz.main.registry.Reference;
import commanderadz.main.tileentity.HandScannerTile;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockHandScanner extends BlockContainer{

	private String name;
	public int power;
	public int status;
	private String nbtname;



	public BlockHandScanner(int id){
		super(id, Material.rock);
		setUnlocalizedName("handscanner");
		setCreativeTab(CreativeTabs.tabBlock);
		setHardness(3);
	}

	@SideOnly(Side.CLIENT)
	private Icon side, bottom, top, front;

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister reg){
		this.side = reg.registerIcon(Reference.MOD_TEXTUREPATH + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1) + "side");
		this.bottom = reg.registerIcon(Reference.MOD_TEXTUREPATH + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1) + "side");
		this.top = reg.registerIcon(Reference.MOD_TEXTUREPATH + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1) + "side");
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
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack par6ItemStack) {
		int whichDirectionFacing = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
		world.setBlockMetadataWithNotify(x, y, z, whichDirectionFacing, 2);
		EntityPlayer player = (EntityPlayer) entity;
		if(!world.isRemote)player.addChatMessage("Hand print set");
		if (entity instanceof EntityPlayer) {
			name = player.username;
			HandScannerTile tileEntity = (HandScannerTile) world.getBlockTileEntity(x, y, z);
			tileEntity.oName = name;
		}
	}

	public boolean onBlockActivated(World par1World, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
	{
		HandScannerTile tileEntity = (HandScannerTile) par1World.getBlockTileEntity(x, y, z);
		par1World.notifyBlocksOfNeighborChange(x, y, z, this.blockID);
		if(par1World.isRemote)tileEntity.packet();

		nbtname = tileEntity.oName;
		name = player.username;
		if(par1World.isRemote)System.out.println("client" + name);
		if(par1World.isRemote)System.out.println("client" + tileEntity.oName);
		if(par1World.isRemote)System.out.println("client" + nbtname);
		if(!par1World.isRemote)System.out.println("server" + name);
		if(!par1World.isRemote)System.out.println("server" + tileEntity.oName);
		if(!par1World.isRemote)System.out.println("server" + nbtname);
		System.out.println(tileEntity.readName);
		if(!par1World.isRemote){
			if(nbtname.equals(name)){
				if(status == 0){
					power = 15;
					status = 1;
					par1World.notifyBlocksOfNeighborChange(x, y, z, this.blockID);
				}else if(status == 1){
					power = 0;
					status = 0;
					par1World.notifyBlocksOfNeighborChange(x, y, z, this.blockID);
				}
				return true;
			}
		}
		else if(par1World.isRemote){
			player.addChatMessage("Hand print not recognised");
		}
		else{
			return true;
		}
		return true;

	}

	@Override
	public TileEntity createNewTileEntity(World world){
		return new HandScannerTile();
	}

	public boolean canProvidePower()
	{
		return true;
	}

	public int isProvidingWeakPower(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
	{
		return power;
	}



}