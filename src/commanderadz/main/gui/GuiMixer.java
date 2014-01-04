package commanderadz.main.gui;

import org.lwjgl.opengl.GL11;

import commanderadz.main.container.ContainerMixer;
import commanderadz.main.registry.DefaultProps;
import commanderadz.main.tileentity.TileMixer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class GuiMixer extends GuiContainer{
        private TileMixer mixerTile;
        public int var9=0;
        World world;
        int xx;
        int yy;
        int var5;
        int var6;
        int x;
        int y;
        int zz;
        int progress;
        public GuiMixer(InventoryPlayer inventory,TileMixer tile) {
                super(new ContainerMixer(tile,inventory));
                mixerTile = tile;
        }

          protected void drawGuiContainerForegroundLayer(int par1, int par2)
      {
               fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, (ySize - 96) + 2, 4210752);
               this.fontRenderer.drawString("Coin Press", 66, 6, 4210752);
      }

      /**
               * Draw the background layer for the GuiContainer (everything behind the items)
               */
      protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
      {
                       int k = (this.width - this.xSize) / 2;
                       int l = (this.height - this.ySize) / 2;
                 GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                 this.mc.renderEngine.bindTexture(DefaultProps.MIXER_GUI);
                 var5 = (this.width - this.xSize) / 2;
                 var6 = (this.height - this.ySize) / 2;

                 this.drawTexturedModalRect(var5, var6, 0, 0, this.xSize, this.ySize);
                 int var7=0;
           if(this.mixerTile.canPress()){
                   System.out.println(this.mixerTile.abc);
                   x = (this.width - this.xSize) /2 + 80;
                   y = (this.height - this.ySize) /2 + 35;
                   progress = (int) (0.26*this.mixerTile.abc);
                   this.drawTexturedModalRect(this.x, this.y, 176, 14, this.progress, 16);
           }
      }
      
}