package Reactioncraft.fences.common;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import Reactioncraft.basic.common.BlockTerrain;
import Reactioncraft.basic.common.ClientProxy;
import Reactioncraft.basic.common.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
//import Reactioncraft.fences.common.CommonProxy;
//import Reactioncraft.fences.common.ClientProxy;

@Mod( modid = "RCXF", name="Reactioncraft Extra Fences", version="[1.4.7] Reactioncraft Version 7.0")
@NetworkMod(channels = { "RCCXF" }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)

public class RCXF
{
	//@SidedProxy(clientSide = "Reactioncraft.fences.common.ClientProxy", serverSide = "Reactioncraft.fences.common.CommonProxy")
	@SidedProxy(clientSide = "Reactioncraft.basic.common.ClientProxy", serverSide = "Reactioncraft.basic.common.CommonProxy")
	
	public static CommonProxy proxy;
	@Instance("RCXF")
	public static RCXF instance;
	
	//config
	public static int stonewallID;
	public static int stonebrickwallID;
	public static int crackedbrickwallID;
	public static int mossbrickwallID;
	public static int brickwallID;
	public static int LapiswallID;
	public static int woodenwallID;
	public static int sandstonewallID;
	public static int Stonebrick1ID;
	public static int Stonebrick2ID;
	public static int Stonebrick3ID;
	public static int Stonebrick4ID;
	public static int netherbrickID;
//	public static int BloodstonebrickID;
	
	//Blocks
	public static Block stonewall;
	public static Block stonebrickwall;
	public static Block crackedbrickwall;
	public static Block mossbrickwall;
	public static Block brickwall;
	public static Block lapiswall;
	public static Block woodenwall;
	public static Block sandstonewall;
	public static Block Stonebrick1;
	public static Block Stonebrick2;
	public static Block Stonebrick3;
	public static Block Stonebrick4;
	public static Block Netherbrickwall;
//	public static Block Bloodstonebrickwall;
	
	//Items
	//public static Item Scroll;
	
	public static boolean RCBDM() throws ClassNotFoundException 
	 {
			try
			{
				Class.forName("Reactioncraft.Desert.common.RCBDM");
			}
			catch (NoClassDefFoundError ex) 
			{
				return false ;
			}
			return true ;
	 }
	
	@PreInit
	 public void preInit(FMLPreInitializationEvent evt)
	 {
	 //This is new! put stuff here that you want to happen before the mods are loaded
		 Configuration config = new Configuration(evt.getSuggestedConfigurationFile());

        config.load();
        
         //Block Ids 3041 - 3060
         stonewallID = config.getBlock("Cobblestone Wall", 3041).getInt();
    	 stonebrickwallID = config.getBlock("Stonebrick Wall", 3042).getInt();
    	 crackedbrickwallID = config.getBlock("Cracked Stonebrick Wall", 3043).getInt();
    	 mossbrickwallID = config.getBlock("Mossy Stonebrick Wall", 3044).getInt();
    	 brickwallID = config.getBlock("Brick Wall", 3045).getInt();
    	 LapiswallID = config.getBlock("Lapis Wall", 3046).getInt();
    	 woodenwallID = config.getBlock("Wooden Wall", 3047).getInt();
    	 sandstonewallID = config.getBlock("Sandstone Wall", 3048).getInt();
    	 Stonebrick1ID = config.getBlock("Used for Texture 1", 3049).getInt();
    	 Stonebrick2ID = config.getBlock("Used for Texture 2", 3050).getInt();
    	 Stonebrick3ID = config.getBlock("Used for Texture 3", 3051).getInt();
    	 Stonebrick4ID = config.getBlock("Used for Texture  4", 3052).getInt();
    	 netherbrickID = config.getBlock("Nether Brick Wall", 3053).getInt();
//    	 BloodstonebrickID = config.getBlock("Bloodstone brick Wall", 3054).getInt();

        config.save(); 
	 }

	 @Init
	 public void load(FMLInitializationEvent event)
	 {
	 	//the meat of the mod
		//Claimed Block Ids 3000 - 3050 
		ClientProxy.registerRenderInformation();
		
//		stonewall = new BlockWalls(3251, 1).setHardness(1.0F).setResistance(1.0F).setBlockName("ScrollShelf");
//		stonebrickwall = new BlockWalls(3252, 54).setHardness(1.0F).setResistance(1.0F).setBlockName("ScrollShelf");
//		crackedbrickwall = new BlockWalls(3253, 101).setHardness(1.0F).setResistance(1.0F).setBlockName("ScrollShelf");
//		mossbrickwall = new BlockWalls(3254, 100).setHardness(1.0F).setResistance(1.0F).setBlockName("ScrollShelf");
//		brickwall = new BlockWalls(3255, 7).setHardness(1.0F).setResistance(1.0F).setBlockName("ScrollShelf");
//		lapiswall = new BlockWalls(3256, 144).setHardness(1.0F).setResistance(1.0F).setBlockName("ScrollShelf");
//		woodenwall = new BlockWalls(3257, 4).setHardness(1.0F).setResistance(1.0F).setBlockName("ScrollShelf");
//		sandstonewall = new BlockWalls(3258, 175).setHardness(1.0F).setResistance(1.0F).setBlockName("ScrollShelf");
		
		
		Stonebrick1 = new BlockTerrain(Stonebrick1ID, 1).setHardness(1.0F).setResistance(1.0F).setBlockName("Stonebrick1");
		Stonebrick2 = new BlockTerrain(Stonebrick2ID, 54).setHardness(1.0F).setResistance(1.0F).setBlockName("Stonebrick1");
		Stonebrick3 = new BlockTerrain(Stonebrick3ID, 101).setHardness(1.0F).setResistance(1.0F).setBlockName("Stonebrick1");
		Stonebrick4 = new BlockTerrain(Stonebrick4ID, 100).setHardness(1.0F).setResistance(1.0F).setBlockName("Stonebrick1");
		
		stonewall = new BlockWalls(stonewallID, Stonebrick1).setHardness(1.0F).setResistance(1.0F).setBlockName("stonewall");
		stonebrickwall = new BlockWalls(stonebrickwallID, Stonebrick2).setHardness(1.0F).setResistance(1.0F).setBlockName("stonebrickwall");
		crackedbrickwall = new BlockWalls(crackedbrickwallID, Stonebrick3).setHardness(1.0F).setResistance(1.0F).setBlockName("crackedbrickwall");
		mossbrickwall = new BlockWalls(mossbrickwallID, Stonebrick4).setHardness(1.0F).setResistance(1.0F).setBlockName("mossbrickwall");
		brickwall = new BlockWalls(brickwallID, Block.brick).setHardness(1.0F).setResistance(1.0F).setBlockName("brickwall");
		lapiswall = new BlockWalls(LapiswallID, Block.blockLapis).setHardness(1.0F).setResistance(1.0F).setBlockName("lapiswall");
		woodenwall = new BlockWalls(woodenwallID, Block.planks).setHardness(1.0F).setResistance(1.0F).setBlockName("woodenwall");
		sandstonewall = new BlockWalls(sandstonewallID, Block.sandStone).setHardness(1.0F).setResistance(1.0F).setBlockName("sandstonewall");
		Netherbrickwall = new BlockWalls(netherbrickID, Block.netherBrick).setHardness(1.0F).setResistance(1.0F).setBlockName("Netherbrickwall");
		
		addNames();
		registerBlocks();
		addRecipes();
		
		//Reactioncraft integration
		try 
		{
			if(RCBDM())
			{
				Integration.loadReactioncraft();
				System.out.println("Reactioncraft Chisel Mod enabled");
			}
		}
		catch (ClassNotFoundException e)	
		{
			System.out.println(" Reactioncraft Walls'N'Fences did not find Reactioncraft Better Desert Mod, recipes disabled");
		}
	 }
	 

	 public void addRecipes() 
	 {
		 //Custom Blocks Needed for Textures
		 GameRegistry.addRecipe(new ItemStack(stonewall, 9), new Object[]{ "   ", "###", "###", Character.valueOf('#'), RCXF.Stonebrick1});		 
		 GameRegistry.addRecipe(new ItemStack(stonebrickwall, 9), new Object[]{ "   ", "###", "###", Character.valueOf('#'), RCXF.Stonebrick2});
		 GameRegistry.addRecipe(new ItemStack(crackedbrickwall, 9), new Object[]{ "   ", "###", "###", Character.valueOf('#'), RCXF.Stonebrick3});
		 GameRegistry.addRecipe(new ItemStack(mossbrickwall, 9), new Object[]{ "   ", "###", "###", Character.valueOf('#'), RCXF.Stonebrick4});
		 /**
		  * 
		  **/
		 //Custom Blocks needex for textures above and used in recipes to be simi useful
		 GameRegistry.addRecipe(new ItemStack(RCXF.Stonebrick1, 1), new Object[]{ "   ", " # ", "   ", Character.valueOf('#'), Block.stone});		 
		 GameRegistry.addRecipe(new ItemStack(RCXF.Stonebrick2, 1), new Object[]{ "   ", " # ", "   ", Character.valueOf('#'), Block.stoneBrick});		 
		 GameRegistry.addRecipe(new ItemStack(RCXF.Stonebrick3, 1), new Object[]{ "   ", " # ", "   ", Character.valueOf('#'), new ItemStack(Block.stoneBrick, 1, 2)});		 
		 GameRegistry.addRecipe(new ItemStack(RCXF.Stonebrick4, 1), new Object[]{ "   ", " # ", "   ", Character.valueOf('#'), new ItemStack(Block.stoneBrick, 1, 1)});		 
		 
		 //uses vanilla blocks
		 GameRegistry.addRecipe(new ItemStack(Netherbrickwall, 6), new Object[]{ "   ", "###", "###", Character.valueOf('#'), Block.netherBrick});
		 GameRegistry.addRecipe(new ItemStack(brickwall, 6), new Object[]{ "   ", "###", "###", Character.valueOf('#'), Block.brick});
		 GameRegistry.addRecipe(new ItemStack(lapiswall, 6), new Object[]{ "   ", "###", "###", Character.valueOf('#'), Block.blockLapis});
		 GameRegistry.addRecipe(new ItemStack(woodenwall, 6), new Object[]{ "   ", "S#S", "###", Character.valueOf('#'), Block.planks, Character.valueOf('S'), Item.stick});
		 GameRegistry.addRecipe(new ItemStack(sandstonewall, 6), new Object[]{ "   ", "###", "###", Character.valueOf('#'), Block.sandStone});
	 }


	public void registerBlocks() 
	 {
		GameRegistry.registerBlock(stonewall);
		GameRegistry.registerBlock(stonebrickwall);
		GameRegistry.registerBlock(crackedbrickwall);
		GameRegistry.registerBlock(mossbrickwall);
		GameRegistry.registerBlock(brickwall);
		GameRegistry.registerBlock(lapiswall);
		GameRegistry.registerBlock(woodenwall);
		GameRegistry.registerBlock(sandstonewall);
		GameRegistry.registerBlock(Stonebrick1);
		GameRegistry.registerBlock(Stonebrick2);
		GameRegistry.registerBlock(Stonebrick3);
		GameRegistry.registerBlock(Stonebrick4);
		GameRegistry.registerBlock(Netherbrickwall);
	 }


	public void addNames() 
	 {
		LanguageRegistry.addName(stonewall, "Stone Wall");
		LanguageRegistry.addName(stonebrickwall, "Stonebrick Wall");
		LanguageRegistry.addName(crackedbrickwall, "Cracked Stonebrick Wall");
		LanguageRegistry.addName(mossbrickwall, "Moss Stonebrick Wall");
		LanguageRegistry.addName(brickwall, "Brick Wall");
		LanguageRegistry.addName(lapiswall, "Lapis Lazuli Wall");
		LanguageRegistry.addName(woodenwall, "Wooden Wall");
		LanguageRegistry.addName(sandstonewall, "Sandstone Wall");
		LanguageRegistry.addName(Stonebrick1, "Stone Brick");
		LanguageRegistry.addName(Netherbrickwall, "Netherbrick Wall");
	 }
	

	 @PostInit
	 public void modsLoaded(FMLPostInitializationEvent evt)
	 {
	 //new as well! How about that stuff after the mods are loaded/initialized?
	 }
	 
	 
}
