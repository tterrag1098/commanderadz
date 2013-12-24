package commanderadz.main.tileentity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class HandScannerTile extends TileEntity {
	
	public  String oName;
	public String readName;

	@Override
	public void writeToNBT(NBTTagCompound nbt){
		super.writeToNBT(nbt);
		nbt.setString("oName", oName);
	}
	
	public void readFromNBT(NBTTagCompound nbt2){
		super.readFromNBT(nbt2);
		oName = nbt2.getString("oName");
	}
    


}
