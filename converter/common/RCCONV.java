package Reactioncraft.converter.common;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import Reactioncraft.basic.common.ClientProxy;
import Reactioncraft.basic.common.CommonProxy;
import Reactioncraft.basic.common.ItemBasic;
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
//import Reactioncraft.base.common.CommonProxy;
//import Reactioncraft.base.common.ClientProxy;

@Mod( modid = "RCCONV", name="Reactioncraft Converter Mod", version="[1.4.5] Reactioncraft Version 5.0")
@NetworkMod(channels = { "RCHRM" }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)

public class RCCONV
{
	//@SidedProxy(clientSide = "Reactioncraft.base.common.ClientProxy", serverSide = "Reactioncraft.base.common.CommonProxy")
	@SidedProxy(clientSide = "Reactioncraft.basic.common.ClientProxy", serverSide = "Reactioncraft.basic.common.CommonProxy")
	
	public static CommonProxy proxy;
	@Instance("RCCONV")
	
	public static RCCONV instance;
	
	//Config Code
	public static int ingotSilverIID;
	public static int ingotBloodstoneIID;
	public static int ingotObsidianIID;
	public static int ingotBronzeIID;
	public static int ingotCopperIID;
	public static int ingotTinIID;
	public static int ingotSteelIID;
	public static int ingotTitanumIID;
	
	
	//Item code
	public static Item ingotSilver;
	public static Item ingotBloodstone;
	public static Item ingotObsidian;
	public static Item ingotBronze;
	public static Item ingotCopper;
	public static Item ingotTin;
	public static Item ingotSteel;
	public static Item ingotTitanum;
	
	
	@PreInit
	 public void preInit(FMLPreInitializationEvent evt)
	 {
		 Configuration config = new Configuration(evt.getSuggestedConfigurationFile());
		 config.load();
		 
		 //Items
		 //Reserved 10061 - 10080 
		 ingotSilverIID = config.getItem("Silver Ingot", 10061).getInt();
	     ingotBloodstoneIID = config.getItem("Bloodstone Ingot", 10062).getInt();
	     ingotObsidianIID = config.getItem("Obsidian Ingot", 10063).getInt();
	     ingotBronzeIID = config.getItem("Bronze Ingot", 10064).getInt();
	     ingotCopperIID = config.getItem("Copper Ingot", 10065).getInt();
	     ingotTinIID = config.getItem("Tin Ingot", 10066).getInt();
	     ingotSteelIID = config.getItem("Steel Ingot", 10067).getInt();
	     ingotTitanumIID = config.getItem("Titanum Ingot", 10068).getInt();
		 
		 config.save();
	 }
	
	 @Init 
	 public void load(FMLInitializationEvent event)
	 {
		ClientProxy.registerRenderInformation();
		ItemCode();
		addNames();
		ingotRegistry();
		recipes();
	 }

	public void ItemCode() 
	 {
		 ingotSilver = new ItemBasic(ingotSilverIID).setIconCoord(61, 0).setItemName("ingotSilver");
		 ingotBloodstone = new ItemBasic(ingotBloodstoneIID).setIconCoord(6, 0).setItemName("ingotBloodstone");
		 ingotObsidian = new ItemBasic(ingotObsidianIID).setIconCoord(23, 0).setItemName("ingotObsidian");
		 ingotBronze = (new ItemBasic(ingotBronzeIID)).setIconCoord(60, 0).setItemName("ingotBronze");
		 ingotCopper = (new ItemBasic(ingotCopperIID)).setIconCoord(254, 0).setItemName("ingotCopper");
		 ingotTin = (new ItemBasic(ingotTinIID)).setIconCoord(29, 0).setItemName("ingotTin");
		 ingotSteel = (new ItemBasic(ingotSteelIID)).setIconCoord(16, 0).setItemName("ingotSteel");
		 ingotTitanum = (new ItemBasic(ingotTitanumIID)).setIconCoord(10, 0).setItemName("ingotTitanum");
	 }

	public void addNames() 
	{
		LanguageRegistry.addName(ingotSilver, "Silver Ingot");
		LanguageRegistry.addName(ingotBloodstone, "Bloodstone Ingot");
		LanguageRegistry.addName(ingotObsidian, "Obsidian Ingot");
		LanguageRegistry.addName(ingotTitanum, "Titanium Ingot");
		LanguageRegistry.addName(ingotTin, "Tin Ingot");
		LanguageRegistry.addName(ingotSteel, "Steel Ingot");
		LanguageRegistry.addName(ingotCopper, "Copper Ingot");	
		LanguageRegistry.addName(ingotBronze, "Bronze Ingot");
		}
	
	
	public void ingotRegistry() 
	 {
		 OreDictionary.registerOre("ingotSilver", new ItemStack(ingotSilver));
		 OreDictionary.registerOre("ingotBloodstone", new ItemStack(ingotBloodstone));
		 OreDictionary.registerOre("ingotObsidian", new ItemStack(ingotObsidian));
		 OreDictionary.registerOre("ingotBronze", new ItemStack(ingotBronze));
		 OreDictionary.registerOre("ingotTitanum", new ItemStack(ingotTitanum));
		 OreDictionary.registerOre("ingotTin", new ItemStack(ingotTin));
		 OreDictionary.registerOre("ingotSteel", new ItemStack(ingotSteel));
		 OreDictionary.registerOre("ingotCopper", new ItemStack(ingotCopper));
	 }
	
	
	public void recipes() 
	 {
		 CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ingotSilver, new Object[]{"ingotSilver",}));
		 CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ingotBloodstone, new Object[]{"ingotBloodstone",}));
		 CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ingotObsidian, new Object[]{"ingotObsidian",}));
		 CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ingotBronze, new Object[]{"ingotBronze",}));
		 CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ingotCopper, new Object[]{"ingotCopper",}));
		 CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ingotTin, new Object[]{"ingotTin",}));
		 CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ingotSteel, new Object[]{"ingotSteel",}));
		 CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(ingotTitanum, new Object[]{"ingotTitanum",}));
	 }
	

	@PostInit
	 public void modsLoaded(FMLPostInitializationEvent evt)
	 {
	 
	 }
	 
	 
}

