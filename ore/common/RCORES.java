package Reactioncraft.ore.common;

import ic2.api.Ic2Recipes;
import ic2.api.Items;
import Reactioncraft.basic.common.ClientProxy;
import Reactioncraft.basic.common.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.oredict.OreDictionary;
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
import Reactioncraft.basic.common.*;

@Mod( modid = "RCORES", name="Reactioncraft ORES", version="[1.4.5] Reactioncraft Version 5.0")
@NetworkMod(channels = { "RCORES" }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)

public class RCORES
{
	//@SidedProxy(clientSide = "Reactioncraft.basic.common.ClientProxy", serverSide = "Reactioncraft.basic.common.CommonProxy")
	@SidedProxy(clientSide = "Reactioncraft.basic.common.ClientProxy", serverSide = "Reactioncraft.basic.common.CommonProxy")
	
	public static CommonProxy proxy;
	
	 @Instance("RCORES")
	 public static RCORES instance;
	 
	 //Config
	 public static int surfaceOresID;
	 public static int netherOresID;
	 public static int endOresID;
	 public static int OreItemsIID;
	 
	 public static Block surfaceOres;
	 public static Block netherOres;
	 public static Block endOres;
	 
	 public static Item OreItems;
	 
	
	 @PreInit
	 public void preInit(FMLPreInitializationEvent evt)
	 {
		 //This is new! put stuff here that you want to happen before the mods are loaded
		 Configuration config = new Configuration(evt.getSuggestedConfigurationFile());

         config.load();

         //Claimed Block IDs 3071 - 3080
         surfaceOresID = config.getBlock("Surface Ores", 3071).getInt();
         netherOresID = config.getBlock("Nether Ores", 3072).getInt();
       	 endOresID = config.getBlock("End Ores", 3073).getInt();
       	 
       	 
       	 //Item Ids
       	 OreItemsIID = config.getItem("Ore Items", 10255).getInt();

         config.save();
	 }
	 

	 @Init
	 public void load(FMLInitializationEvent event)
	 {
		    ClientProxy.registerRenderInformation();
		 
		 	surfaceOres = new BlockSOMulti(surfaceOresID, Material.rock).setHardness(1.0F).setResistance(1.0F).setBlockName("surfaceOres");
			netherOres = new BlockNOMulti(netherOresID, Material.rock).setHardness(80.0F).setResistance(2000.0F).setBlockName("netherOres");
	    	endOres = new BlockEOMulti(endOresID, Material.rock).setHardness(1.0F).setResistance(1.0F).setBlockName("endOres");
	    	
	    	OreItems = new ItemOreMulti(OreItemsIID);
	    	
	    	
	    	GameRegistry.addRecipe(new ItemStack(OreItems, 1, 0), new Object[]{ "   ", " D ", " D ", Character.valueOf('D'), Item.ingotGold});
	    	
	    	
	    	//Ore Registration
	    	GameRegistry.registerBlock(surfaceOres, ItemMulti.class);
			GameRegistry.registerBlock(netherOres, ItemMulti.class);
		    GameRegistry.registerBlock(endOres, ItemMulti.class);
	    	
	    	
	    	//Ore Items
	    	LanguageRegistry.addName(new ItemStack(RCORES.OreItems,1,0), "Golden Rod"); 
	    	LanguageRegistry.addName(new ItemStack(RCORES.OreItems,1,1), "Obsidian Ingot"); 
	    	LanguageRegistry.addName(new ItemStack(RCORES.OreItems,1,2), "Black Diamond"); 
	    	LanguageRegistry.addName(new ItemStack(RCORES.OreItems,1,3), "Bloodstone Ingot"); 
	    	LanguageRegistry.addName(new ItemStack(RCORES.OreItems,1,4), "Silver Ingot"); 
	    	LanguageRegistry.addName(new ItemStack(RCORES.OreItems,1,5), "End Gem");
	    	LanguageRegistry.addName(new ItemStack(RCORES.OreItems,1,6), "Bloodstone Dust");  
	    	LanguageRegistry.addName(new ItemStack(RCORES.OreItems,1,7), "Dragonstone Shard");
	    	
	    	LanguageRegistry.addName(new ItemStack(RCORES.OreItems,1,8), "null"); 
	    	LanguageRegistry.addName(new ItemStack(RCORES.OreItems,1,9), "null"); 
	    	LanguageRegistry.addName(new ItemStack(RCORES.OreItems,1,10), "null"); 
	    	LanguageRegistry.addName(new ItemStack(RCORES.OreItems,1,11), "null"); 
	    	LanguageRegistry.addName(new ItemStack(RCORES.OreItems,1,13), "null"); 
	    	LanguageRegistry.addName(new ItemStack(RCORES.OreItems,1,14), "null"); 
	    	LanguageRegistry.addName(new ItemStack(RCORES.OreItems,1,15), "null"); 
	    	
	    	
	    	//Surface Ores
	    	LanguageRegistry.addName(new ItemStack(RCORES.surfaceOres, 1, 0), "Silver");
	    	
	    	
	    	//Nether Ores
	    	LanguageRegistry.addName(new ItemStack(RCORES.netherOres, 1, 0), "Bloodstone");
	    	LanguageRegistry.addName(new ItemStack(RCORES.netherOres, 1, 1), "Black Diamond");
	    	
	    	
	    	//End Ores
	    	LanguageRegistry.addName(new ItemStack(RCORES.endOres, 1, 0), "Wizimite");
		    
		    
		    //Ore Dictionary
		    //Items
		    OreDictionary.registerOre("goldRod", new ItemStack(OreItems,1, 0));
		    OreDictionary.registerOre("ingotObsidian", new ItemStack(OreItems,1, 1));
		    OreDictionary.registerOre("diamondBlack", new ItemStack(OreItems,1, 2));
		    OreDictionary.registerOre("ingotBloodstone", new ItemStack(OreItems,1, 3));
		    OreDictionary.registerOre("ingotSilver", new ItemStack(OreItems,1, 4));
		    OreDictionary.registerOre("gemWizimite", new ItemStack(OreItems,1, 5));
		    
		    
		    //Blocks
		    OreDictionary.registerOre("oreBloodstone", new ItemStack(RCORES.netherOres, 1, 0));
		    
		    
		    //Furnace stuff 
		    
		    //Gold rod to gold ingot
		    FurnaceRecipes.smelting().addSmelting(RCORES.OreItems.shiftedIndex, new ItemStack(Item.ingotGold.shiftedIndex, 1, 0), 0.5F);
		    
		    //Bloodstone dust to bloodstone ingot
		    FurnaceRecipes.smelting().addSmelting(RCORES.OreItems.shiftedIndex, 6, new ItemStack(RCORES.OreItems.shiftedIndex, 1, 3), 0.5F);
		    
		    //Obsidian to obsidian ingot
		    GameRegistry.addSmelting(Block.obsidian.blockID, new ItemStack(RCORES.OreItems.shiftedIndex, 1, 1), 0.5F);
		    
		    
		    //World Gen Handlers
		    GameRegistry.registerWorldGenerator(new WorldGenHandler());
	 }
	 
	 public static void loadIndustrialCraft()
	 {
		//IC2 SUPPORT :D  Bloodstone block to bloodstone dust
		Ic2Recipes.addMaceratorRecipe(new ItemStack(RCORES.netherOres, 1, 0), new ItemStack(RCORES.OreItems, 3, 6));
	 }

	  @PostInit
	  public void modsLoaded(FMLPostInitializationEvent evt)
	  {
		  //new as well! How about that stuff after the mods are loaded/initialized?
	  } 
}
