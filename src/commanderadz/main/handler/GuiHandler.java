package commanderadz.main.handler;

import commanderadz.main.container.ContainerMixer;
import commanderadz.main.container.ContainerWasher;
import commanderadz.main.gui.GuiMixer;
import commanderadz.main.gui.GuiWasher;
import commanderadz.main.tileentity.TileMixer;
import commanderadz.main.tileentity.TileWasher;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{

        @Override
        public Object getServerGuiElement(int ID, EntityPlayer player, World world,
                        int x, int y, int z) {
                // TODO Auto-generated method stub
                 TileEntity tile_entity = world.getBlockTileEntity(x, y, z);
                  if(tile_entity != null)
                {
                switch(ID)
                {
                //The case is equivalent to the id passed with EntityPlayer.openGui(ModInstance, id, World, xCoord, yCoord, zCoord);
                case 0: return new ContainerMixer((TileMixer) tile_entity, player.inventory);
                case 1: return new ContainerWasher((TileWasher) tile_entity, player.inventory);
                //For more clear-cut usage, you can change these to constants such as:
                //case OtherGuiID: return new ContainerYetAnotherTile(player.inventory, (TileEntityYetAnotherTile)tile_entity);
                //}
                //}
                // Returns null if the TileEntity it null
                //return null;
                }}
                return null;
        }

        @Override
        public Object getClientGuiElement(int ID, EntityPlayer player, World world,
                        int x, int y, int z) {
                // TODO Auto-generated method stub
                 TileEntity tile_entity = world.getBlockTileEntity(x, y, z);
                  if(tile_entity != null)
                {
                switch(ID)
                {
                //The case is equivalent to the id passed with EntityPlayer.openGui(ModInstance, id, World, xCoord, yCoord, zCoord);
                case 0: return new GuiMixer(player.inventory, (TileMixer) tile_entity);
                case 1: return new GuiWasher(player.inventory, (TileWasher) tile_entity);
               
                //For more clear-cut usage, you can change these to constants such as:
                //case OtherGuiID: return new ContainerYetAnotherTile(player.inventory, (TileEntityYetAnotherTile)tile_entity);
                //}
                //}
                // Returns null if the TileEntity it null
                //return null;
                }}
                return null;
        }

}
