package commanderadz.main.tileentity;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import cpw.mods.fml.common.network.PacketDispatcher;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

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
	
	/*public Packet packet(){
		if(oName != null){
		ByteArrayOutputStream bos = new ByteArrayOutputStream(8);
		DataOutputStream outputStream = new DataOutputStream(bos);
		try{
			outputStream.writeInt(this.xCoord);
			outputStream.writeInt(this.yCoord);
			outputStream.writeInt(this.zCoord);
			outputStream.writeUTF(oName);
		}catch (Exception ex){
			ex.printStackTrace();
		}
		Packet250CustomPayload packet = new Packet250CustomPayload();
		packet.channel = "handscanner";
		packet.data = bos.toByteArray();
		packet.length = bos.size();
		PacketDispatcher.sendPacketToAllPlayers(packet);
		return packet;
	}
		return null;
		
	}*/
    


}
