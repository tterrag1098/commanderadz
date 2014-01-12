package commanderadz.main.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import commanderadz.main.container.ContainerBottler;
import commanderadz.main.registry.DefaultProps;
import commanderadz.main.tileentity.TileBottler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GuiBottler extends GuiContainer
{
	private TileBottler bottlerTile;
	public int var9 = 0;
	World world;
	int xx;
	int yy;
	int var5;
	int var6;
	int x;
	int y;
	int zz;
	int progress;

	public GuiBottler(InventoryPlayer inventory, TileBottler tile)
	{
		super(new ContainerBottler(tile, inventory));
		bottlerTile = tile;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2)
	{
		fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, (ySize - 96) + 2, 4210752);
		this.fontRenderer.drawString("Bottler", 66, 6, 4210752);
	}

	/**
	 * Draw the background layer for the GuiContainer (everything behind the
	 * items)
	 */
	@Override
	@SideOnly(Side.CLIENT)
	@SuppressWarnings("unused")
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
	{
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.bindTexture(DefaultProps.MIXER_GUI);
		var5 = (this.width - this.xSize) / 2;
		var6 = (this.height - this.ySize) / 2;

		this.drawTexturedModalRect(var5, var6, 0, 0, this.xSize, this.ySize);
		int var7 = 0;
		if (this.bottlerTile.canPress())
		{
			System.out.println(this.bottlerTile.abc);
			x = (this.width - this.xSize) / 2 + 61;
			y = (this.height - this.ySize) / 2 + 19;
			progress = (int) (0.59 * this.bottlerTile.abc);
			this.drawTexturedModalRect(this.x, this.y, 177, 2, this.progress, 46);
		}
	}

}