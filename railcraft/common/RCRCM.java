package Reactioncraft.railcraft.common;

import net.minecraft.item.Item;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.oredict.ShapedOreRecipe;
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
import cpw.mods.fml.common.registry.LanguageRegistry;
//import Reactioncraft.basic.common.ClientProxy;
//import Reactioncraft.basic.common.CommonProxy;

@Mod( modid = "RCRCM", name="Reactioncraft: Railcraft Addon", version="[1.4.7] Reactioncraft Version 7.0")
@NetworkMod(channels = { "RCRCM" }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)

public class RCRCM
{
		@SidedProxy(clientSide = "Reactioncraft.railcraft.common.ClientProxy", serverSide = "Reactioncraft.railcraft.common.CommonProxy")
		//@SidedProxy(clientSide = "Reactioncraft.basic.common.ClientProxy", serverSide = "Reactioncraft.basic.common.CommonProxy")
		
		public static CommonProxy proxy;
	
		@Instance("RCRCM")
		public static RCRCM instance;
		
		//config		
		//Items
		public static int BlackdiamondboreIID;
		public static int BloodstoneboreIID;
	
		
		//Items
		public static Item Blackdiamondbore;
		public static Item Bloodstonebore;
		
		 
		@PreInit
		 public void preInit(FMLPreInitializationEvent evt)
		 {
			//This is new! put stuff here that you want to happen before the mods are loaded
			 Configuration config = new Configuration(evt.getSuggestedConfigurationFile());

	        config.load();
	        
	    	BlackdiamondboreIID = config.getItem("Black Diamond Bore", 10501).getInt();
	    	BloodstoneboreIID = config.getItem("Bloodstone Bore", 10502).getInt();
	    	//Claimed Item IDS 10501 - 10525

	        config.save();
		 } 
	     	

		 @Init
		 public void load(FMLInitializationEvent event)
		 {
		 		//the meat of the mod
			 	//Claimed Block Ids 3000 - 3050 
			 	ClientProxy.registerRenderInformation();
		
				itemcode();
				addnames();
				recipes();
		 	}
		 
		 public void itemcode()
		 {
			 Blackdiamondbore = new IBlackDiamondBH(BlackdiamondboreIID).setIconCoord(196, 0).setItemName("Blackdiamondbore");
			 Bloodstonebore = new IBloodstoneBH(BloodstoneboreIID).setIconCoord(195, 0).setItemName("Bloodstonebore");			
		 }
		 
		 public void recipes()
		 {
			 CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Bloodstonebore, true, new Object[]{
			         "XXX", "X#X", "XXX", Character.valueOf('X'), "ingotSteel", Character.valueOf('#'), "ingotBloodstone"}));
			 CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(Blackdiamondbore, true, new Object[]{
			         "XXX", "X#X", "XXX", Character.valueOf('X'), "ingotSteel", Character.valueOf('#'), "diamondBlack"}));
		 }
		 
		 public void addnames() 
		 {
			 //LanguageRegistry.addName(Blackdiamondbore, "Black Diamond Bore");
			 LanguageRegistry.addName(Blackdiamondbore, "Black Diamond Bore");
			 //LanguageRegistry.addName(Bloodstonebore, "Bloodstone Bore");
			 LanguageRegistry.addName(Bloodstonebore, "Bloodstone Bore");
		 }

		 
		 @PostInit
		 public void modsLoaded(FMLPostInitializationEvent evt)
		 {
		 //new as well! How about that stuff after the mods are loaded/initialized?
		 }
}