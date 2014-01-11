package commanderadz.main;

import java.io.IOException;
import java.util.Arrays;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.liquids.LiquidDictionary;
import commanderadz.main.blocks.BlockBottler;
import commanderadz.main.blocks.BlockCommanderAdz;
import commanderadz.main.blocks.BlockHandScanner;
import commanderadz.main.blocks.BlockMixer;
import commanderadz.main.blocks.BlockScorp;
import commanderadz.main.blocks.BlockWasher;
import commanderadz.main.fluid.BlockFluidLiquid;
import commanderadz.main.handler.BucketHandler;
import commanderadz.main.handler.GuiHandler;
import commanderadz.main.handler.PacketHandler;
import commanderadz.main.items.ItemFilter;
import commanderadz.main.items.ItemGreenBucket;
import commanderadz.main.items.ItemGreenDrink;
import commanderadz.main.items.ItemGreenDrinkDirty;
import commanderadz.main.items.ItemGreenRod;
import commanderadz.main.items.ItemPurpleBucket;
import commanderadz.main.items.ItemPurpleDrink;
import commanderadz.main.items.ItemPurpleDrinkDirty;
import commanderadz.main.items.ItemPurplePowder;
import commanderadz.main.items.ItemRedBucket;
import commanderadz.main.items.ItemRedDrink;
import commanderadz.main.items.ItemRedDrinkDirty;
import commanderadz.main.items.ItemRedRod;
import commanderadz.main.items.ItemTurquoiseBucket;
import commanderadz.main.items.ItemTurquoiseDrink;
import commanderadz.main.items.ItemTurquoiseDrinkDirty;
import commanderadz.main.items.ItemWhiteBucket;
import commanderadz.main.items.ItemWhiteDrink;
import commanderadz.main.items.ItemWhiteDrinkDirty;
import commanderadz.main.items.ItemWhiteRod;
import commanderadz.main.items.ItemYellowBucket;
import commanderadz.main.items.ItemYellowDrink;
import commanderadz.main.items.ItemYellowDrinkDirty;
import commanderadz.main.registry.Reference;
import commanderadz.main.tileentity.HandScannerTile;
import commanderadz.main.tileentity.TileBottler;
import commanderadz.main.tileentity.TileMixer;
import commanderadz.main.tileentity.TileWasher;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)
@NetworkMod(clientSideRequired=true, serverSideRequired=false, channels={"handscanner"}, packetHandler = PacketHandler.class)
public class CommanderAdz {
        @Instance(Reference.MOD_ID)
        public static CommanderAdz instance;
        private GuiHandler guiHandler = new GuiHandler();
        
        int commanderAdzID;
        int scorpBlockID;
        int handScannerID;
        int liquidMixerID;
        int liquidWasherID;
        int liquidBottlerID;
        
        int whiteBucketID;
        int greenBucketID;
        int purpleBucketID;
        int redBucketID;
        int turquoiseBucketID;
        int yellowBucketID;
        
        int whiteDrinkID;
        int greenDrinkID;
        int purpleDrinkID;
        int redDrinkID;
        int turquoiseDrinkID;
        int yellowDrinkID;
        
        int whitedirtDrinkID;
        int greendirtDrinkID;
        int purpledirtDrinkID;
        int reddirtDrinkID;
        int turquoisedirtDrinkID;
        int yellowdirtDrinkID;
        
        int whiteRodID;
        int greenRodID;
        int purpleRodID;
        int redRodID;
        int turquoiseRodID;
        int yellowRodID;
        
        int purplePowderID;
        int fluidFilterID;
        
        int whiteFluidID;
        int greenFluidID;
        int purpleFluidID;
        int redFluidID;
        int turquoiseFluidID;
        int yellowFluidID;
        
        public static Block blockcommanderAdz;
        public static Block blockscorpBlock;
        public static Block blockhandScanner;
        public static Block blockliquidMixer;
        public static Block blockliquidWasher;
        public static Block blockliquidBottler;
        
        public static Block blockwhiteFluid;
        public static Block blockgreenFluid;
        public static Block blockpurpleFluid;
        public static Block blockredFluid;
        public static Block blockturquoiseFluid;
        public static Block blockyellowFluid;
        
        public static Item itemwhiteBucket;
        public static Item itemgreenBucket;
        public static Item itempurpleBucket;
        public static Item itemredBucket;
        public static Item itemturquoiseBucket;
        public static Item itemyellowBucket;
        
        public static Item itemwhitedirtDrink;
        public static Item itemgreendirtDrink;
        public static Item itempurpledirtDrink;
        public static Item itemreddirtDrink;
        public static Item itemturquoisedirtDrink;
        public static Item itemyellowdirtDrink;
        
        public static Item itemwhiteDrink;
        public static Item itemgreenDrink;
        public static Item itempurpleDrink;
        public static Item itemredDrink;
        public static Item itemturquoiseDrink;
        public static Item itemyellowDrink;
        
        public static Item itemwhiteRod;
        public static Item itemgreenRod;
        public static Item itempurpleRod;
        public static Item itemredRod;
        public static Item itemturquoiseRod;
        public static Item itemyellowRod;
        
        public static Item itempurplePowder;
        public static Item itemfluidFilter;
        
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
          
          scorpBlockID = config.get("Block IDs", "Scorp Block ID", 799).getInt();
          commanderAdzID = config.get("Block IDs", "CommanderAdz ID", 800).getInt();
          handScannerID = config.get("Block IDs", "Hand Scanner ID", 801).getInt();
          liquidMixerID = config.get("Block IDs", "Liquid Mixer ID", 802).getInt();
          liquidWasherID = config.get("Block IDs", "Liquid Washer ID", 803).getInt();
          liquidBottlerID = config.get("Block IDs", "Liquid Bottler", 804).getInt();
          
          whiteFluidID = config.get("Fluid IDs", "White Fluid ID", 900).getInt();
          greenFluidID = config.get("Fluid IDs", "Green Fluid ID", 901).getInt();
          purpleFluidID = config.get("Fluid IDs", "Purple Fluid ID", 902).getInt();
          redFluidID = config.get("Fluid IDs", "Red Fluid ID", 903).getInt();
          turquoiseFluidID = config.get("Fluid IDs", "Turquoise Fluid ID", 904).getInt();
          yellowFluidID = config.get("Fluid IDs", "Yellow Fluid ID", 905).getInt();
          
          whiteRodID = config.get("Item IDs", "White Rod", 951).getInt();
          greenRodID = config.get("Item IDs", "Green Rod", 952).getInt();
          purpleRodID = config.get("Item IDs", "Purple Rod", 953).getInt();
          redRodID = config.get("Item IDs", "Red Rod", 954).getInt();
          turquoiseRodID = config.get("Item IDs", "Turquoise Rod", 955).getInt();
          yellowRodID = config.get("Item IDs", "Yellow Rod", 956).getInt();
          
          whiteBucketID = config.get("Bucket IDs", "White Fluid Bucket ID", 1000).getInt();
          greenBucketID = config.get("Bucket IDs", "Green Fluid Bucket ID", 1001).getInt();
          purpleBucketID = config.get("Bucket IDs", "Purple Fluid Bucket ID", 1002).getInt();
          redBucketID = config.get("Bucket IDs", "Red Fluid Bucket ID", 1003).getInt();
          turquoiseBucketID = config.get("Bucket IDs", "Turquoise Fluid Bucket ID", 1004).getInt();
          yellowBucketID = config.get("Bucket IDs", "Yellow Fluid Bucket ID", 1005).getInt();
          
          whiteDrinkID = config.get("Drink IDs", "White Drink ID", 990).getInt();
          greenDrinkID = config.get("Drink IDs", "Green Drink ID", 991).getInt();
          purpleDrinkID = config.get("Drink IDs", "Purple Drink ID", 992).getInt();
          redDrinkID = config.get("Drink IDs", "Red Drink ID", 993).getInt();
          turquoiseDrinkID = config.get("Drink IDs", "Turquoise Drink ID", 994).getInt();
          yellowDrinkID = config.get("Drink IDs", "Yellow Drink ID", 995).getInt();
          
          whitedirtDrinkID = config.get("Drink IDs", "White Dirt Drink", 910).getInt();
          greendirtDrinkID = config.get("Drink IDs", "Green Dirt Drink ID", 911).getInt();
          purpledirtDrinkID = config.get("Drink IDs", "Purple Dirt Drink ID", 912).getInt();
          reddirtDrinkID = config.get("Drink IDs", "Red Dirt Drink ID", 913).getInt();
          turquoisedirtDrinkID = config.get("Drink IDs", "Turquoise Dirt Drink ID", 914).getInt();
          yellowdirtDrinkID = config.get("Drink IDs", "Yellow Dirt Drink ID", 915).getInt();
          
          purplePowderID = config.get("Item IDs", "Purple Powder", 1010).getInt();
          fluidFilterID = config.get("Item IDs", "Filter ID", 1011).getInt();
          
          MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);
        }
        
       
        
        @EventHandler
        public void load(FMLInitializationEvent event){
                
                blockscorpBlock = new BlockScorp(scorpBlockID);
                registerBlock(blockscorpBlock, "Scorp Block", blockscorpBlock.getUnlocalizedName());
                
                blockcommanderAdz = new BlockCommanderAdz(commanderAdzID);
                registerBlock(blockcommanderAdz,"Commander Adz Block", blockcommanderAdz.getUnlocalizedName());
                
                blockhandScanner = new BlockHandScanner(handScannerID);
                registerBlock(blockhandScanner, "Hand Scanner", blockhandScanner.getUnlocalizedName());
               
                blockliquidMixer = new BlockMixer(liquidMixerID);
                registerBlock(blockliquidMixer, "Liquid Mixer", blockliquidMixer.getUnlocalizedName());
                
                blockliquidWasher = new BlockWasher(liquidWasherID);
                registerBlock(blockliquidWasher, "Liquid Washer", blockliquidWasher.getUnlocalizedName());
                
                blockliquidBottler = new BlockBottler(liquidBottlerID);
                registerBlock(blockliquidBottler, "Bottler", blockliquidBottler.getUnlocalizedName());
                
                itempurplePowder = new ItemPurplePowder(purplePowderID);
                registerItem(itempurplePowder, "Purple Powder", itempurplePowder.getUnlocalizedName());
                
                itemfluidFilter = new ItemFilter(fluidFilterID);
                registerItem(itemfluidFilter, "Fluid Filter", itemfluidFilter.getUnlocalizedName());
                
                itemwhiteBucket = new ItemWhiteBucket(whiteBucketID, whiteFluidID);
                registerItem(itemwhiteBucket, "White Bucket", itemwhiteBucket.getUnlocalizedName());
               
                itemgreenBucket = new ItemGreenBucket(greenBucketID, greenFluidID);
                registerItem(itemgreenBucket, "Green Bucket", itemgreenBucket.getUnlocalizedName());
                
                itempurpleBucket = new ItemPurpleBucket(purpleBucketID, purpleFluidID);
                registerItem(itempurpleBucket, "Purple Bucket", itempurpleBucket.getUnlocalizedName());
               
                itemredBucket = new ItemRedBucket(redBucketID, redFluidID);
                registerItem(itemredBucket, "Red Bucket", itemredBucket.getUnlocalizedName());
               
                itemturquoiseBucket = new ItemTurquoiseBucket(turquoiseBucketID, turquoiseFluidID);
                registerItem(itemturquoiseBucket, "Turquoise Bucket", itemturquoiseBucket.getUnlocalizedName());
               
                itemyellowBucket = new ItemYellowBucket(yellowBucketID, yellowFluidID);
                registerItem(itemyellowBucket, "Yellow Bucket", itemyellowBucket.getUnlocalizedName());
                
                //DRINKS
                itemwhiteDrink = new ItemWhiteDrink(whiteDrinkID);
                registerItem(itemwhiteDrink, "White Drink", itemwhiteDrink.getUnlocalizedName());
               
                itemgreenDrink = new ItemGreenDrink(greenDrinkID);
                registerItem(itemgreenDrink, "Green Drink", itemgreenDrink.getUnlocalizedName());
                
                itempurpleDrink = new ItemPurpleDrink(purpleDrinkID);
                registerItem(itempurpleDrink, "Purple Drink", itempurpleDrink.getUnlocalizedName());
               
                itemredDrink = new ItemRedDrink(redDrinkID);
                registerItem(itemredDrink, "Red Drink", itemredDrink.getUnlocalizedName());
               
                itemturquoiseDrink = new ItemTurquoiseDrink(turquoiseDrinkID);
                registerItem(itemturquoiseDrink, "Turquoise Drink", itemturquoiseDrink.getUnlocalizedName());
               
                itemyellowDrink = new ItemYellowDrink(yellowDrinkID);
                registerItem(itemyellowDrink, "Yellow Drink", itemyellowDrink.getUnlocalizedName());
                
                //DIRT DRINKS
                itemwhitedirtDrink = new ItemWhiteDrinkDirty(whitedirtDrinkID);
                registerItem(itemwhitedirtDrink, "White Drink", itemwhitedirtDrink.getUnlocalizedName());
                
                itemgreendirtDrink = new ItemGreenDrinkDirty(greendirtDrinkID);
                registerItem(itemgreendirtDrink, "Green Drink", itemgreendirtDrink.getUnlocalizedName());
                
                itempurpledirtDrink = new ItemPurpleDrinkDirty(purpledirtDrinkID);
                registerItem(itempurpledirtDrink, "Purple Drink", itempurpledirtDrink.getUnlocalizedName());
                
                itemreddirtDrink = new ItemRedDrinkDirty(reddirtDrinkID);
                registerItem(itemreddirtDrink, "Red Drink", itemreddirtDrink.getUnlocalizedName());
                
                itemturquoisedirtDrink = new ItemTurquoiseDrinkDirty(turquoisedirtDrinkID);
                registerItem(itemturquoisedirtDrink, "Turquoise Drink", itemturquoisedirtDrink.getUnlocalizedName());
                
                itemyellowdirtDrink = new ItemYellowDrinkDirty(yellowdirtDrinkID);
                registerItem(itemyellowdirtDrink, "Yellow Drink", itemyellowdirtDrink.getUnlocalizedName());
                
                //Rods
                
                itemwhiteRod = new ItemWhiteRod(whiteRodID);
                registerItem(itemwhiteRod, "White Rod", itemwhiteRod.getUnlocalizedName());
                
                itemgreenRod = new ItemGreenRod(greenRodID);
                registerItem(itemgreenRod, "Green Rod", itemgreenRod.getUnlocalizedName());
                
                itemredRod = new ItemRedRod(redRodID);
                registerItem(itemredRod, "Red Rod", itemredRod.getUnlocalizedName());
                
               
                GameRegistry.registerTileEntity(HandScannerTile.class, "HandScannerTile");
                GameRegistry.registerTileEntity(TileMixer.class, "TileMixer");
                GameRegistry.registerTileEntity(TileWasher.class, "TileWasher");
                GameRegistry.registerTileEntity(TileBottler.class, "TileBottler");
                GameRegistry.addShapelessRecipe(new ItemStack(CommanderAdz.itempurplePowder, 1), new ItemStack(Item.dyePowder, 0, 5), new ItemStack(Item.sugar));
                GameRegistry.addRecipe(new ItemStack(CommanderAdz.itemfluidFilter, 16),
                		" s ", "sgs", " s ",
                		's', Item.stick,
                		'g', Block.thinGlass);
                networkRegisters();
                
                //Liquid
                
                fluidWhite = new Fluid("white").setBlockID(whiteFluidID);
                fluidGreen = new Fluid("green").setBlockID(greenFluidID);
                fluidPurple = new Fluid("purple").setBlockID(purpleFluidID);
                fluidRed = new Fluid("red").setBlockID(redFluidID);
                fluidTurquoise = new Fluid("turquoise").setBlockID(turquoiseFluidID);
                fluidYellow = new Fluid("yellow").setBlockID(yellowFluidID);
                
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
               
               BucketHandler.INSTANCE.buckets.put(CommanderAdz.blockwhiteFluid, CommanderAdz.itemwhiteBucket);
               BucketHandler.INSTANCE.buckets.put(CommanderAdz.blockgreenFluid, CommanderAdz.itemgreenBucket);
               BucketHandler.INSTANCE.buckets.put(CommanderAdz.blockpurpleFluid, CommanderAdz.itempurpleBucket);
               BucketHandler.INSTANCE.buckets.put(CommanderAdz.blockredFluid, CommanderAdz.itemredBucket);
               BucketHandler.INSTANCE.buckets.put(CommanderAdz.blockturquoiseFluid, CommanderAdz.itemturquoiseBucket);
               BucketHandler.INSTANCE.buckets.put(CommanderAdz.blockyellowFluid, CommanderAdz.itemyellowBucket);
              
               FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("white", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(CommanderAdz.itemwhiteBucket), new ItemStack(Item.bucketEmpty));
               FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("green", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(CommanderAdz.itemgreenBucket), new ItemStack(Item.bucketEmpty));
               FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("purple", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(CommanderAdz.itempurpleBucket), new ItemStack(Item.bucketEmpty));
               FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("red", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(CommanderAdz.itemredBucket), new ItemStack(Item.bucketEmpty));
               FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("turquoise", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(CommanderAdz.itemturquoiseBucket), new ItemStack(Item.bucketEmpty));
               FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("yellow", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(CommanderAdz.itemyellowBucket), new ItemStack(Item.bucketEmpty));
        }
        
    public static void registerBlock(Block block, String name, String unlocalizedName){
        GameRegistry.registerBlock(block, Reference.MOD_ID + unlocalizedName);
        LanguageRegistry.addName(block, name);
}
        public static void registerItem(Item item, String name, String unlocalizedName){
        GameRegistry.registerItem(item, Reference.MOD_ID + unlocalizedName);
        LanguageRegistry.addName(item, name);
        
}
        
        public void networkRegisters(){
        NetworkRegistry.instance().registerGuiHandler(instance, guiHandler);
}
        

}