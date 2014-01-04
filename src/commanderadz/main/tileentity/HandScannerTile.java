package commanderadz.main.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class HandScannerTile extends TileEntity {
	
	public String oName;
	public String readName;

	@Override
	public void writeToNBT(NBTTagCompound nbt){
		super.writeToNBT(nbt);
		nbt.setString("oName", oName);
		System.out.println("Written NBT");
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt){
		super.readFromNBT(nbt);
		oName = nbt.getString("oName");
		System.out.println("Read NBT");
		System.out.println(oName);
	}

	public void setName(String name)
	{
		this.oName = name;
	}
}
