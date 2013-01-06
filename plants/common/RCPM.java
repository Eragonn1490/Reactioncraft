package Reactioncraft.plants.common;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import Reactioncraft.basic.common.CommonProxy;
import Reactioncraft.basic.common.ItemBasic;
import Reactioncraft.basic.common.ItemBasicFood;
import Reactioncraft.basic.common.ItemBasicSeed;
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
//import Reactioncraft.plants.common.ClientProxy;
//import Reactioncraft.plants.common.CommonProxy;


@Mod( modid = "RCPM", name="Reactioncraft Plants", version="[1.4.5] Reactioncraft Version 5.0")
@NetworkMod(channels = { "RCPM" }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)

public class RCPM
{
	//@SidedProxy(clientSide = "Reactioncraft.plants.common.ClientProxy", serverSide = "Reactioncraft.plants.common.CommonProxy")
	@SidedProxy(clientSide = "Reactioncraft.basic.common.ClientProxy", serverSide = "Reactioncraft.basic.common.CommonProxy")
	
	public static CommonProxy proxy;
	
	@Instance("RCPM")
	public static RCPM instance;
	
	//config for blocks
	public static int CocoCropID;
	public static int AncientPlantID;
	//public static int sugarcaneID;

	//config for items
	public static int AncientFruitIID;
	public static int AncientSeedsIID;
	public static int CocoSeedIID;
	public static int CocoBeanIID;
	public static int VanillaSeedIID;
	public static int VanillaBeanIID;
	
	
	//Blocks
	public static Block CocoCrop;
	public static Block AncientPlant;
	//public static Block sugarcane;
	
	//Items
	public static Item AncientFruit;
	public static Item CocoBean;
	public static Item VanillaBean;
	
	//Seeds
    public static Item AncientSeeds;
    public static Item CocoSeed;
    public static Item VanillaSeed;
    	
    
    @PreInit
	 public void preInit(FMLPreInitializationEvent evt)
	 {
	 //This is new! put stuff here that you want to happen before the mods are loaded
		 System.out.println("Loaded");
		 
		 MinecraftForge.EVENT_BUS.register(new RCPMBonemealProvider());
		 
		 Configuration config = new Configuration(evt.getSuggestedConfigurationFile());

        config.load();
        
        //Claimed IDs 3081 - 3090
        CocoCropID = config.getBlock("Coco Crop", 3081).getInt();
        AncientPlantID = config.getBlock("Ancient Plant", 3082).getInt();
        //sugarcaneID = config.getBlock("Sugar Cane", 3083).getInt();
        
        AncientSeedsIID = config.getItem("Ancient Seeds", 10301).getInt();
        AncientFruitIID = config.getItem("Ancient Fruit", 10302).getInt();
        CocoSeedIID = config.getItem("Coco Seed", 10303).getInt();
        CocoBeanIID = config.getItem("Coco Bean", 10304).getInt();
        VanillaSeedIID = config.getItem("Vanilla Seed", 10305).getInt();
        VanillaBeanIID = config.getItem("Vanilla Bean", 10306).getInt();
        
        //Claimed Item ids 10301 - 10400 
        
        config.save();
	 }
    

	 @Init
	 public void load(FMLInitializationEvent event)
	 {
	 	//the meat of the mod
		//Claimed Block Ids 3081 - 3099
		proxy.registerRenderInformation();
		
		CocoCrop = new BlockCocoPlant(CocoCropID, 225).setHardness(0.0F).setResistance(1.0F).setBlockName("CocoCrop");
		AncientPlant = new BlockAncientPlant(AncientPlantID, 0).setHardness(0.0F).setResistance(1.0F).setBlockName("AncientPlant");
		
		AncientSeeds = new ItemBasicSeed(AncientSeedsIID, RCPM.AncientPlant.blockID, Block.tilledField.blockID).setIconCoord(133, 0).setItemName("AncientSeeds");
		AncientFruit = new ItemBasicFood(AncientFruitIID, 8, true).setIconCoord(100, 0).setItemName("AncientFruit");
		CocoSeed = new ItemBasicSeed(CocoSeedIID, RCPM.CocoCrop.blockID, Block.tilledField.blockID).setIconCoord(255, 0).setItemName("CocoSeed");
		CocoBean = new ItemBasic(CocoBeanIID).setIconCoord(255, 0).setItemName("CocoBean");
		VanillaSeed= new ItemBasic(VanillaSeedIID).setIconCoord(109, 0).setItemName("VanillaSeed");
		VanillaBean= new ItemBasic(VanillaBeanIID).setIconCoord(109, 0).setItemName("VanillaBean");
		
		//Registry Code
		GameRegistry.registerBlock(CocoCrop);
		GameRegistry.registerBlock(AncientPlant);
		
		GameRegistry.addSmelting(CocoSeed.shiftedIndex, new ItemStack(CocoBean), 0.1F); 
		
		//Item Code
		LanguageRegistry.addName(AncientSeeds, "Ancient Seeds");
		LanguageRegistry.addName(AncientFruit, "Ancient Fruit");
		LanguageRegistry.addName(CocoSeed, "Coco Seed");
		LanguageRegistry.addName(CocoBean, "Coco Bean");
		
		
		//Mojang coco bean to ours... Cooked one to ours
		GameRegistry.addShapelessRecipe(new ItemStack(AncientSeeds, 3), new Object[] {AncientFruit,});
		GameRegistry.addRecipe(new ItemStack(CocoSeed, 1), new Object[]{ "   ", " # ", "   ", Character.valueOf('#'), CocoBean});
		GameRegistry.addRecipe(new ItemStack(CocoSeed, 1), new Object[]{ "   ", " # ", "   ", Character.valueOf('#'), new ItemStack(Item.dyePowder, 1, 3)});
		GameRegistry.addRecipe(new ItemStack(Item.cookie, 12), new Object[]{ "   ", "   ", "D#D", Character.valueOf('#'), CocoBean, Character.valueOf('D'), Item.wheat});
		
		//Ore Dict
		OreDictionary.registerOre("cocoBean", new ItemStack(CocoBean));
		
		//To aquire ancient plant seeds
		//ChestGenHooks.addItem(ChestGenHooks.VILLAGE_BLACKSMITH, new WeightedRandomChestContent(lootStack, minStackSize, maxStackSize, chance));
		ChestGenHooks.addItem(ChestGenHooks.BONUS_CHEST, new WeightedRandomChestContent(new ItemStack(RCPM.AncientFruit), 1, 2, 5));
		ChestGenHooks.addItem(ChestGenHooks. MINESHAFT_CORRIDOR, new WeightedRandomChestContent(new ItemStack(RCPM.AncientFruit), 1, 5, 15));
	 }
	 

	 @PostInit
	 public void modsLoaded(FMLPostInitializationEvent evt)
	 {
	 //new as well! How about that stuff after the mods are loaded/initialized?
	 }
	 
	 
}
