package commanderadz.main.handler;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import commanderadz.main.tileentity.HandScannerTile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class PacketHandler implements IPacketHandler{
	
	@Override
	public void onPacketData(INetworkManager manager,Packet250CustomPayload packet, Player player){
		if (packet.channel.equals("handscanner"))
			handScanner(packet,(EntityPlayer) player);
	}

	private void handScanner(Packet250CustomPayload packet, EntityPlayer player) {
		DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));
		@SuppressWarnings("unused")
		World world = player.worldObj;
		String name;
		int xx;
		int yy;
		int zz;
		HandScannerTile tile;
		try{
			xx = inputStream.readInt();
			yy = inputStream.readInt();
			zz = inputStream.readInt();
			name = inputStream.readUTF();
			tile = (HandScannerTile) player.worldObj.getBlockTileEntity(xx, yy, zz);
			tile.oName = name;
		} catch (IOException e){
			e.printStackTrace();
			return;
		}
	 
	}
	
	
	

}
