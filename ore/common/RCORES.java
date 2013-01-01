package Reactioncraft.ore.common;

import ic2.api.Ic2Recipes;
import ic2.api.Items;
import Reactioncraft.base.common.RCB;
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
	 public static int magmaflintIID;
	 
	 public static Block surfaceOres;
	 public static Block netherOres;
	 public static Block endOres;
	 
	 public static Item OreItems;
	 public static Item magmaflint;
	 
	 public static boolean IC2() throws ClassNotFoundException 
	 {
		 try{
			 Class.forName("ic2.core.IC2");
		 }
		 catch (NoClassDefFoundError ex) {
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

         //Claimed Block IDs 3071 - 3080
         surfaceOresID = config.getBlock("Surface Ores", 3071).getInt();
         netherOresID = config.getBlock("Nether Ores", 3072).getInt();
       	 endOresID = config.getBlock("End Ores", 3073).getInt();
       	 
       	 
       	 //Item Ids
       	 OreItemsIID = config.getItem("Ore Items", 10255).getInt();
       	 magmaflintIID = config.getItem("magmaflint", 10256).getInt() ;

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
	    	magmaflint = new ItemBasic(magmaflintIID).setIconCoord(138, 0).setItemName("magmaflint").setCreativeTab(RCB.Reactioncraft);
	    	
	    	
	    	GameRegistry.addRecipe(new ItemStack(OreItems, 1, 0), new Object[]{ "   ", " D ", " D ", Character.valueOf('D'), Item.ingotGold});
	    	GameRegistry.addRecipe(new ItemStack(Item.flintAndSteel, 1), new Object[] {"A ", " B", 'A', Item.ingotIron, 'B', RCORES.magmaflint});
	    	GameRegistry.addRecipe(new ItemStack(Item.arrow, 12), new Object[] {"X", "#", "Y", 'Y', Item.feather, 'X', RCORES.magmaflint, '#', Item.stick});
	    	
	    	//Ore Registration
	    	GameRegistry.registerBlock(surfaceOres, ItemMulti.class);
			GameRegistry.registerBlock(netherOres, ItemMulti.class);
		    GameRegistry.registerBlock(endOres, ItemMulti.class);
	    	
	    	
	    	//Ore Items
		    LanguageRegistry.addName(magmaflint, "Magma Flint");
		    
	    	LanguageRegistry.addName(new ItemStack(RCORES.OreItems,1,0), "Golden Rod"); 
	    	LanguageRegistry.addName(new ItemStack(RCORES.OreItems,1,1), "Obsidian Ingot"); 
	    	LanguageRegistry.addName(new ItemStack(RCORES.OreItems,1,2), "Black Diamond"); 
	    	LanguageRegistry.addName(new ItemStack(RCORES.OreItems,1,3), "Bloodstone Ingot"); 
	    	LanguageRegistry.addName(new ItemStack(RCORES.OreItems,1,4), "Silver Ingot"); 
	    	LanguageRegistry.addName(new ItemStack(RCORES.OreItems,1,5), "End Gem");
	    	LanguageRegistry.addName(new ItemStack(RCORES.OreItems,1,6), "Bloodstone Dust");  
	    	LanguageRegistry.addName(new ItemStack(RCORES.OreItems,1,7), "Dragonstone Shard");
	    	LanguageRegistry.addName(new ItemStack(RCORES.OreItems,1,8), "Carved Dragonstone");
	    	LanguageRegistry.addName(new ItemStack(RCORES.OreItems,1,9), "Superheated Iron Ingot"); 
	    	LanguageRegistry.addName(new ItemStack(RCORES.OreItems,1,10), "Iron Dust");
	    	 
	    	LanguageRegistry.addName(new ItemStack(RCORES.OreItems,1,11), "null"); 
	    	LanguageRegistry.addName(new ItemStack(RCORES.OreItems,1,13), "null"); 
	    	LanguageRegistry.addName(new ItemStack(RCORES.OreItems,1,14), "null"); 
	    	LanguageRegistry.addName(new ItemStack(RCORES.OreItems,1,15), "null"); 
	    	
	    	
	    	//Surface Ores
	    	LanguageRegistry.addName(new ItemStack(RCORES.surfaceOres, 1, 0), "Silver");
	    	LanguageRegistry.addName(new ItemStack(RCORES.surfaceOres, 1, 1), "Magma");
	    	
	    	
	    	//Nether Ores
	    	LanguageRegistry.addName(new ItemStack(RCORES.netherOres, 1, 0), "Bloodstone");
	    	LanguageRegistry.addName(new ItemStack(RCORES.netherOres, 1, 1), "Black Diamond");
	    	LanguageRegistry.addName(new ItemStack(RCORES.netherOres, 1, 2), "Dragonstone");
	    	
	    	//End Ores
	    	LanguageRegistry.addName(new ItemStack(RCORES.endOres, 1, 0), "Wizimite");
		    
		    
		    //Ore Dictionary
		    //Items
		    OreDictionary.registerOre("goldRod", new ItemStack(OreItems,1, 0));
		    OreDictionary.registerOre("ingotObsidian", new ItemStack(OreItems,1, 1));
		    OreDictionary.registerOre("diamondBlack", new ItemStack(OreItems,1, 2));
		    OreDictionary.registerOre("ingotBloodstone", new ItemStack(OreItems,1, 3));
		    OreDictionary.registerOre("ingotSilver", new ItemStack(OreItems,1, 4));
		    OreDictionary.registerOre("ingotSuperheatediron", new ItemStack(OreItems,1, 9));
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
    
		   //Iron Dust to Superheated Iron
		   FurnaceRecipes.smelting().addSmelting(RCORES.OreItems.shiftedIndex, 10, new ItemStack(RCORES.OreItems.shiftedIndex, 1, 9), 0.5F);
		    
		    
		    //World Gen Handlers
		    GameRegistry.registerWorldGenerator(new WorldGenHandler());
		    
		    
		    //IC2 integration
			try 
			{
				if(IC2())
				{
					Integration.loadIndustrialCraft();
					System.out.println("IC2 macerator recipe enabled");
				}
			}
			catch (ClassNotFoundException e)	
			{
				System.out.println(" did not find IC2, macerator recipe disabled");
			}
	 }

	  @PostInit
	  public void modsLoaded(FMLPostInitializationEvent evt)
	  {
		  //new as well! How about that stuff after the mods are loaded/initialized?
	  } 
}
