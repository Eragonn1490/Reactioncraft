package Reactioncraft.Desert.common;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import Reactioncraft.basic.common.CommonProxy;
import Reactioncraft.basic.common.ItemMulti;
import Reactioncraft.basic.common.PacketHandler;
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
//import Reactioncraft.ores.common.ClientProxy;
//import Reactioncraft.ores.common.CommonProxy;

@Mod( modid = "RCBDM", name="Reactioncraft Better Desert Mod", version="[1.4.5] Reactioncraft Version 5.0")
@NetworkMod(channels = { "RCBDM" }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)

public class RCBDM
{
	@SidedProxy(clientSide = "Reactioncraft.basic.common.ClientProxy", serverSide = "Reactioncraft.basic.common.CommonProxy")
	public static CommonProxy proxy;
	
	@Instance("RCBDM")
	public static RCBDM instance;
	
	public static int RcDesertBID;
	
	public static int DarkSandID;
	public static int HireoBlocksIID;
	public static int DesertBlocksIID;
	public static int ColumnBlockID;
	public static int DesertBlockMultiID;
	public static int CactusMultiID;
	public static int CherryTreeLeavesID;
	public static int CherrywoodID;
	public static int CherryTreeSaplingID;
	
	public static Block DarkSand;
	public static Block DarkSandstone;
	public static Block HireoMulti;
	public static Block DesertMulti;
	public static Block ColumnMulti;
	public static Block DesertBlockMulti;
	public static Block CactusMulti;
	public static Block CherryTreeLeaves;
	public static Block Cherrywood;
	public static Block CherryTreeSapling;
	
	public static Item GoldChisel;
	public static Item FlintChisel;
	public static Item LBDesertGem; //uncut
	public static Item LBDesertGem1; //cut
	public static Item DBDesertGem; //uncut
	public static Item DBDesertGem1; //cut
	
	@PreInit
	 public void preInit(FMLPreInitializationEvent evt)
	 {
		Configuration config = new Configuration(evt.getSuggestedConfigurationFile());

		MinecraftForge.EVENT_BUS.register(new RCCBonemealProvider());
		
        config.load();
        
        //3031 - 3040
        CherrywoodID = config.getBlock("Cherry Tree Wood", 3022).getInt();
        CherryTreeLeavesID = config.getBlock("Cherry Tree Leaves", 3023).getInt();
        CherryTreeSaplingID = config.getBlock("Cherry Tree Sapling", 3024).getInt();
        DarkSandID = config.getBlock("Dark Sand", 240).getInt();
        HireoBlocksIID = config.getBlock("Hireoglyphics", 3031).getInt();
        DesertBlocksIID = config.getBlock("Dark Sandstone Blocks", 3032).getInt();
        ColumnBlockID = config.getBlock("Column Blocks", 3033).getInt();
        DesertBlockMultiID = config.getBlock("Desert Blocks", 3034).getInt();
        CactusMultiID = config.getBlock("Cactus Blocks", 3035).getInt();
        
        //Items... 10101 - 10200
        
        config.save();
	 }
	
	@Init
	 public void load(FMLInitializationEvent event)
	 {
		blockCode();
		itemCode();
		registerHandlers();
		registerBlocks();
		addNames();
		addRecipes();
		addBiomes();        
	 }
	
		
	
	public void addRecipes() 
	 {
//			GameRegistry.addShapelessRecipe(new ItemStack(LBDesertGem1), new Object[] {
//				GoldChisel, LBDesertGem
//    		});
//			GameRegistry.addShapelessRecipe(new ItemStack(DBDesertGem1),  new Object[] {
//				GoldChisel, DBDesertGem
//    		});
//			GameRegistry.addShapelessRecipe(new ItemStack(LBDesertGem1), new Object[] {
//				FlintChisel, LBDesertGem
//    		});
//			GameRegistry.addShapelessRecipe(new ItemStack(DBDesertGem1),  new Object[] {
//    			FlintChisel, DBDesertGem
//    		});
//		
//			//Flint Based Regular Hireoglyphics
//	        GameRegistry.addRecipe(new ItemStack(HireoMulti, 1), new Object[] {
//	                "###", " X ", "   ", Character.valueOf('#'), FlintChisel, Character.valueOf('X'), new ItemStack(DesertMulti, 1, 4)
//	                });
//	       
//	        GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 1), new Object[] {
//	                "###", "#X ", "   ", Character.valueOf('#'), FlintChisel, Character.valueOf('X'), new ItemStack(DesertMulti, 1, 4)
//	                });
//	       
//	        GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 2), new Object[] {
//	                "###", "#X#", "   ", Character.valueOf('#'), FlintChisel, Character.valueOf('X'), new ItemStack(DesertMulti, 1, 4)
//	                });
//	        //Gold Based Regular Hireoglyphics
//	        GameRegistry.addRecipe(new ItemStack(HireoMulti, 1), new Object[] {
//	            	"###", " X ", "   ", Character.valueOf('#'), GoldChisel, Character.valueOf('X'), new ItemStack(DesertMulti, 1, 4)
//	            	});
//	   
//	        GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 1), new Object[] {
//	            	"###", "#X ", "   ", Character.valueOf('#'), GoldChisel, Character.valueOf('X'), new ItemStack(DesertMulti, 1, 4)
//	            	});
//	   
//	        GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 2), new Object[] {
//	            	"###", "#X#", "   ", Character.valueOf('#'), GoldChisel, Character.valueOf('X'), new ItemStack(DesertMulti, 1, 4)
//	            	});
//	        	
//	        //flint based Lightblue Hireoglyphics
//	        GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 3), new Object[] {
//	                "###", " X ", " @ ", Character.valueOf('#'), FlintChisel, Character.valueOf('@'), LBDesertGem1, Character.valueOf('X'), HireoMulti
//	                });
//	       
//	        GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 4), new Object[] {
//	                "###", " X ", "#@ ", Character.valueOf('#'), FlintChisel, Character.valueOf('@'), LBDesertGem1, Character.valueOf('X'), new ItemStack(HireoMulti, 1, 1)
//	                });
//	       
//	        GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 5), new Object[] {
//	                "###", " X ", "#@#", Character.valueOf('#'), FlintChisel, Character.valueOf('@'),LBDesertGem1, Character.valueOf('X'), new ItemStack(HireoMulti, 1, 2)
//	                });
//	       
//	        //gold based Lightblue Hireoglyphics
//	        GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 3), new Object[] {
//	            	"###", " X ", " @ ", Character.valueOf('#'), GoldChisel, Character.valueOf('@'), LBDesertGem1, Character.valueOf('X'), HireoMulti
//	            	});
//	   
//	        GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 4), new Object[] {
//	            	"###", " X ", "#@ ", Character.valueOf('#'), GoldChisel, Character.valueOf('@'), LBDesertGem1, Character.valueOf('X'), new ItemStack(HireoMulti, 1, 1)
//	            	});
//	   
//	        GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 5), new Object[] {
//	            	"###", " X ", "#@#", Character.valueOf('#'), GoldChisel, Character.valueOf('@'),LBDesertGem1, Character.valueOf('X'), new ItemStack(HireoMulti, 1, 2)
//	        		});
//	        
//	        //flint based Darkblue Hireoglyphics
//	        GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 6), new Object[] {
//	        		"###", " X ", " @ ", Character.valueOf('#'), FlintChisel, Character.valueOf('@'), DBDesertGem1, Character.valueOf('X'), HireoMulti
//	        		});
//
//	        GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 7), new Object[] {
//	        		"###", " X ", "#@ ", Character.valueOf('#'), FlintChisel, Character.valueOf('@'), DBDesertGem1, Character.valueOf('X'), new ItemStack(HireoMulti, 1, 1)
//	        		});
//
//	        GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 8), new Object[] {
//	        		"###", " X ", "#@#", Character.valueOf('#'), FlintChisel, Character.valueOf('@'), DBDesertGem1, Character.valueOf('X'), new ItemStack(HireoMulti, 1, 2)
//	    			});
//	        
//	        //gold Based Darkblue Hireoglyphics
//	        GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 6), new Object[] {
//	    			"###", " X ", " @ ", Character.valueOf('#'), GoldChisel, Character.valueOf('@'), DBDesertGem1, Character.valueOf('X'), HireoMulti
//	    		});
//
//	        GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 7), new Object[] {
//	    			"###", " X ", "#@ ", Character.valueOf('#'), GoldChisel, Character.valueOf('@'), DBDesertGem1, Character.valueOf('X'), new ItemStack(HireoMulti, 1, 1)
//	    		});
//
//	        GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 8), new Object[] {
//	    			"###", " X ", "#@#", Character.valueOf('#'), GoldChisel, Character.valueOf('@'), DBDesertGem1, Character.valueOf('X'), new ItemStack(HireoMulti, 1, 2)
//	 			});
	 }

	public void itemCode() 
	 {

   	 }

	public void blockCode() 
	{
		Cherrywood = new BlockCherryTreeLog(CherrywoodID, 244).setHardness(0.2F).setResistance(0.5F).setBlockName("Cherrywood");
		CherryTreeLeaves = new BlockCherryTreeLeaves(CherryTreeLeavesID, 43).setHardness(0.2F).setResistance(0.5F).setBlockName("CherryTreeLeaves");
		CherryTreeSapling = new BlockCherryTreeSapling(CherryTreeSaplingID, 44).setHardness(0.2F).setResistance(0.5F).setBlockName("CherryTreeSapling");
		DarkSand = new BlockSandRc(DarkSandID, 136).setHardness(0.5F).setResistance(5.0F).setStepSound(Block.soundSandFootstep).setBlockName("DarkSand");
		HireoMulti = new BlockHireoMulti(HireoBlocksIID, Material.rock).setHardness(3.0F).setBlockName("HireoMulti");
		ColumnMulti = new BlockColumnMulti(ColumnBlockID, Material.rock).setHardness(3.0F).setBlockName("ColumnMulti");
		DesertBlockMulti = new BlockDesertMulti(DesertBlockMultiID, Material.rock).setHardness(3.0F).setBlockName("DesertBlockMulti");
		CactusMulti = new BlockCactusMulti(CactusMultiID, Material.rock).setHardness(0.10F).setResistance(0.1F).setStepSound(Block.soundStoneFootstep).setBlockName("CactusMulti").setRequiresSelfNotify();
	}

	public void addBiomes() 
	{
		
	}

	public void addNames() 
	{
		//Dark Sand
		LanguageRegistry.addName(DarkSand, "Dark Sand");
		
		
		//Desert Blocks
		LanguageRegistry.addName(new ItemStack(DesertBlockMulti, 1),    "Carved Dark Stone");
		LanguageRegistry.addName(new ItemStack(DesertBlockMulti, 1, 1), "Cracked Dark Stone");
		LanguageRegistry.addName(new ItemStack(DesertBlockMulti, 1, 2), "Dark Stone");
		LanguageRegistry.addName(new ItemStack(DesertBlockMulti, 1, 3), "Dark Stone Brick");
		LanguageRegistry.addName(new ItemStack(DesertBlockMulti, 1, 4), "Cracked Dark Stone Brick");
		LanguageRegistry.addName(new ItemStack(DesertBlockMulti, 1, 5), "Sandstone Bricks");
//		LanguageRegistry.addName(new ItemStack(DesertBlockMulti, 1, 6), "");
//		LanguageRegistry.addName(new ItemStack(DesertBlockMulti, 1, 7), "");
//		LanguageRegistry.addName(new ItemStack(DesertBlockMulti, 1, 8), "");
		
		
		//Hireoglyphics
		LanguageRegistry.addName(new ItemStack(HireoMulti, 1, 0),   "Hireoglyphics");
		LanguageRegistry.addName(new ItemStack(HireoMulti, 1, 1), 	"Hireoglyphics");
		LanguageRegistry.addName(new ItemStack(HireoMulti, 1, 2), 	"Hireoglyphics");
		LanguageRegistry.addName(new ItemStack(HireoMulti, 1, 3), 	"Hireoglyphics");
	    LanguageRegistry.addName(new ItemStack(HireoMulti, 1, 4), 	"Hireoglyphics");
		LanguageRegistry.addName(new ItemStack(HireoMulti, 1, 5), 	"Hireoglyphics");        
		LanguageRegistry.addName(new ItemStack(HireoMulti, 1, 6), 	"Hireoglyphics");
		LanguageRegistry.addName(new ItemStack(HireoMulti, 1, 7), 	"Hireoglyphics");
		LanguageRegistry.addName(new ItemStack(HireoMulti, 1, 8), 	"Hireoglyphics");
		LanguageRegistry.addName(new ItemStack(HireoMulti, 1, 9), 	"Column Top");
		LanguageRegistry.addName(new ItemStack(HireoMulti, 1, 10),  "Column Base");		       
		LanguageRegistry.addName(new ItemStack(HireoMulti, 1, 11),  "Weathered Hireoglyph");
        LanguageRegistry.addName(new ItemStack(HireoMulti, 1, 12),  "Marble");
        LanguageRegistry.addName(new ItemStack(HireoMulti, 1, 13),  "Hireoglyphics");  
        LanguageRegistry.addName(new ItemStack(HireoMulti, 1, 14),  "Hireoglyphics");  
        LanguageRegistry.addName(new ItemStack(HireoMulti, 1, 15),  "Hireoglyphics"); 
        
        
        LanguageRegistry.addName(new ItemStack(ColumnMulti, 1, 0), "Dark Sandstone Column");
        LanguageRegistry.addName(new ItemStack(ColumnMulti, 1, 1), "Marble Column");
        LanguageRegistry.addName(new ItemStack(ColumnMulti, 1, 2), "Bloodstone Column");
        LanguageRegistry.addName(new ItemStack(ColumnMulti, 1, 3), "Stone Column");
        LanguageRegistry.addName(new ItemStack(ColumnMulti, 1, 4), "Cobblestone Column");
        LanguageRegistry.addName(new ItemStack(ColumnMulti, 1, 5), "Gold Column");
        LanguageRegistry.addName(new ItemStack(ColumnMulti, 1, 6), "Diamond Column");
        LanguageRegistry.addName(new ItemStack(ColumnMulti, 1, 7), "Stonebrick Column");
        
        LanguageRegistry.addName(new ItemStack(CactusMulti, 1, 0), "Cactus");
        LanguageRegistry.addName(new ItemStack(CactusMulti, 1, 1), "Cactus");
	}

	public void registerBlocks() 
	{
		GameRegistry.registerBlock(DesertBlockMulti, ItemMulti.class);
		GameRegistry.registerBlock(ColumnMulti, ItemMulti.class);
		GameRegistry.registerBlock(HireoMulti, ItemMulti.class);
		GameRegistry.registerBlock(CactusMulti, ItemMulti.class);
		GameRegistry.registerBlock(DarkSand);
		GameRegistry.registerBlock(CherryTreeLeaves);
		GameRegistry.registerBlock(Cherrywood);
		GameRegistry.registerBlock(CherryTreeSapling);
	}

	public void registerHandlers() 
	{
		GameRegistry.registerWorldGenerator(new WorldGenHandler());	
	}

	@PostInit
	 public void modsLoaded(FMLPostInitializationEvent evt)
	 {
		 
	 }
}