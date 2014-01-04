package commanderadz.main;

import java.io.IOException;
import java.util.Arrays;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import commanderadz.main.blocks.BlockCommanderAdz;
import commanderadz.main.blocks.BlockHandScanner;
import commanderadz.main.PacketHandler;
import commanderadz.main.fluid.BlockFluidLiquid;
import commanderadz.main.items.ItemWhiteBucket;
import commanderadz.main.registry.Reference;
import commanderadz.main.tileentity.HandScannerTile;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)
@NetworkMod(clientSideRequired=true, serverSideRequired=false, channels={"handscanner"}, packetHandler = PacketHandler.class)
public class CommanderAdz {
        @Instance(Reference.MOD_ID)
        public static CommanderAdz instance;
        
        int commanderAdzID;
        int handScannerID;
        
        int whiteBucketID;
        
        int whiteFluidID;
        int greenFluidID;
        int purpleFluidID;
        int redFluidID;
        int turquoiseFluidID;
        int yellowFluidID;
        
        public static Block blockcommanderAdz;
        public static Block blockhandScanner;
        
        public static Block blockwhiteFluid;
        public static Block blockgreenFluid;
        public static Block blockpurpleFluid;
        public static Block blockredFluid;
        public static Block blockturquoiseFluid;
        public static Block blockyellowFluid;
        
        public static Item itemwhiteBucket;
        
        public static Fluid fluidWhite;
        public static Fluid fluidGreen;
        public static Fluid fluidPurple;
        public static Fluid fluidRed;
        public static Fluid fluidTurquoise;
        public static Fluid fluidYellow;
        
        @EventHandler
        public void preInit(FMLPreInitializationEvent event)throws IOException{
                ModMetadata data = event.getModMetadata();
                  data.name = Reference.MOD_NAME;
          data.version = Reference.MOD_VERSION;
          data.authorList = Arrays.asList(new String[] {"Scorp"});
          data.description = Reference.MOD_DESCRIPTION;
          data.autogenerated = false;
          
          Configuration config = new Configuration(event.getSuggestedConfigurationFile());
          config.load();
          
          commanderAdzID = config.get("Block IDs", "CommanderAdz ID", 800).getInt();
          handScannerID = config.get("Block IDs", "Hand Scanner ID", 801).getInt();
          
          whiteFluidID = config.get("Fluid IDs", "White Fluid ID", 900).getInt();
          greenFluidID = config.get("Fluid IDs", "Green Fluid ID", 901).getInt();
          purpleFluidID = config.get("Fluid IDs", "Purple Fluid ID", 902).getInt();
          redFluidID = config.get("Fluid IDs", "Red Fluid ID", 903).getInt();
          turquoiseFluidID = config.get("Fluid IDs", "Turquoise Fluid ID", 904).getInt();
          yellowFluidID = config.get("Fluid IDs", "Yellow Fluid ID", 905).getInt();
          
          whiteBucketID = config.get("Bucket IDs", "White Fluid Bucket ID", 1000).getInt();
          
          fluidWhite = new Fluid("white").setBlockID(whiteFluidID);
          fluidGreen = new Fluid("Green").setBlockID(greenFluidID);
          fluidPurple = new Fluid("Purple").setBlockID(purpleFluidID);
          fluidRed = new Fluid("Red").setBlockID(redFluidID);
          fluidTurquoise = new Fluid("Turquoise").setBlockID(turquoiseFluidID);
          fluidYellow = new Fluid("Yellow").setBlockID(yellowFluidID);
          
          FluidRegistry.registerFluid(fluidWhite);
          FluidRegistry.registerFluid(fluidGreen);
          FluidRegistry.registerFluid(fluidPurple);
          FluidRegistry.registerFluid(fluidRed);
          FluidRegistry.registerFluid(fluidTurquoise);
          FluidRegistry.registerFluid(fluidYellow);
          
          blockwhiteFluid = new BlockFluidLiquid(whiteFluidID, fluidWhite).setUnlocalizedName("fluidwhite").setTextureName("commanderadz:fluidwhite");
          blockgreenFluid = new BlockFluidLiquid(greenFluidID, fluidGreen).setUnlocalizedName("fluidgreen").setTextureName("commanderadz:fluidgreen");
          blockpurpleFluid = new BlockFluidLiquid(purpleFluidID, fluidPurple).setUnlocalizedName("fluidpurple").setTextureName("commanderadz:fluidpurple");
          blockredFluid = new BlockFluidLiquid(redFluidID, fluidRed).setUnlocalizedName("fluidred").setTextureName("commanderadz:fluidred");
          blockturquoiseFluid = new BlockFluidLiquid(turquoiseFluidID, fluidTurquoise).setUnlocalizedName("fluidturquoise").setTextureName("commanderadz:fluidturquoise");
          blockyellowFluid = new BlockFluidLiquid(yellowFluidID, fluidYellow).setUnlocalizedName("fluidyellow").setTextureName("commanderadz:fluidyellow");
          
          registerBlock(blockwhiteFluid, "White Fluid", blockwhiteFluid.getUnlocalizedName());
          registerBlock(blockgreenFluid, "Green Fluid", blockgreenFluid.getUnlocalizedName());
          registerBlock(blockpurpleFluid, "Purple Fluid", blockpurpleFluid.getUnlocalizedName());
          registerBlock(blockredFluid, "Red Fluid", blockredFluid.getUnlocalizedName());
          registerBlock(blockturquoiseFluid, "Turquoise Fluid", blockturquoiseFluid.getUnlocalizedName());
          registerBlock(blockyellowFluid, "Yellow Fluid", blockyellowFluid.getUnlocalizedName());
          
          BucketHandler.INSTANCE.buckets.put(blockwhiteFluid, itemwhiteBucket);
          MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);
        }
        
        @ForgeSubscribe
        public void postStitch(TextureStitchEvent.Post event)
        {
            fluidWhite.setIcons(blockwhiteFluid.getBlockTextureFromSide(0), blockwhiteFluid.getBlockTextureFromSide(1));
        }
        
        @EventHandler
        public void load(FMLInitializationEvent event){
                
                
                blockcommanderAdz = new BlockCommanderAdz(commanderAdzID);
                registerBlock(blockcommanderAdz,"Commander Adz Block", blockcommanderAdz.getUnlocalizedName());
                blockhandScanner = new BlockHandScanner(handScannerID);
                registerBlock(blockhandScanner, "Hand Scanner", blockhandScanner.getUnlocalizedName());
                itemwhiteBucket = new ItemWhiteBucket(whiteBucketID, whiteFluidID);
                registerItem(itemwhiteBucket, "White Bucket", itemwhiteBucket.getUnlocalizedName());
                
                
                
                
                FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("white", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(CommanderAdz.itemwhiteBucket), new ItemStack(Item.bucketEmpty));
                
                GameRegistry.registerTileEntity(HandScannerTile.class, "HandScannerTile");
        }
        
    public static void registerBlock(Block block, String name, String unlocalizedName){
        GameRegistry.registerBlock(block, Reference.MOD_ID + unlocalizedName);
        LanguageRegistry.addName(block, name);
}
        public static void registerItem(Item item, String name, String unlocalizedName){
        GameRegistry.registerItem(item, Reference.MOD_ID + unlocalizedName);
        LanguageRegistry.addName(item, name);
        
}
        

}