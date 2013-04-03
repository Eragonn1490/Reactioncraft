package Reactioncraft.plants.common;

import Reactioncraft.basic.common.ClientProxy;
import Reactioncraft.basic.common.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.BlockReed;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemReed;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import Reactioncraft.base.common.RCB;
import Reactioncraft.basic.common.*;
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


@Mod( modid = "RCPM", name="Reactioncraft Plants", version="[1.4.7] Reactioncraft Version 7.0")
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
	public static int sugarcaneBlockID;
	public static int cornStalkID;
	public static int HayBaleID;

	//config for items
	public static int AncientFruitIID;
	public static int AncientSeedsIID;
	public static int CocoSeedIID;
	public static int CocoBeanIID;
	public static int VanillaSeedIID;
	public static int VanillaBeanIID;
	public static int sugarcaneItemIID;
	public static int cornBlockID;
	public static int AncientFlowerIID;
	public static int WrappedcornIID;
	public static int CornSeedIID;
	public static int stalksItemIID;
	
	
	//Blocks
	public static Block CocoCrop;
	public static Block AncientPlant;
	public static Block sugarcaneBlock;
	public static Block cornBlock;
	public static Block cornStalk;
	public static Block HayBale;
	
	//Items
	public static Item AncientFruit;
	public static Item CocoBean;
	public static Item VanillaBean;
	public static Item AncientFlower;
	public static Item Wrappedcorn;
	
	//Seeds
    public static Item AncientSeeds;
    public static Item CocoSeed;
    public static Item VanillaSeed;
    public static Item sugarcaneItem;
    public static Item CornSeed;
    public static Item stalksItem;
    
    
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
        sugarcaneBlockID = config.getBlock("Sugar Cane", 3083).getInt();
        cornBlockID = config.getBlock("corn Block", 3084).getInt();
        cornStalkID = config.getBlock("corn Stalk", 3085).getInt();
        HayBaleID = config.getBlock("Hay Bale", 3086).getInt();
        
        
        //10861 - 10880
        AncientSeedsIID = config.getItem("Ancient Seeds", 10861).getInt();
        AncientFruitIID = config.getItem("Ancient Fruit", 10862).getInt();
        CocoSeedIID = config.getItem("Coco Seed", 10863).getInt();
        CocoBeanIID = config.getItem("Coco Bean", 10864).getInt();
        VanillaSeedIID = config.getItem("Vanilla Seed", 10865).getInt();
        VanillaBeanIID = config.getItem("Vanilla Bean", 10866).getInt();
        sugarcaneItemIID = config.getItem("Sugar Cane Item", 10967).getInt();
        WrappedcornIID = config.getItem("Wrapped Corn", 10868).getInt();
        CornSeedIID = config.getItem("Corn Seed", 10869).getInt();
        stalksItemIID = config.getItem("stalksItem", 10870).getInt();
        AncientFlowerIID = config.getItem("Ancient Flower", 10871).getInt();
        
        //Claimed Item ids 10301 - 10400 
        
        config.save();
	 }
    

	 @Init
	 public void load(FMLInitializationEvent event)
	 {
	 	//the meat of the mod
		//Claimed Block Ids 3081 - 3099
		proxy.registerRenderInformation();
		
		//Blocks
		CocoCrop = new BlockCocoPlant(CocoCropID, 225).setHardness(0.0F).setResistance(1.0F).setBlockName("CocoCrop");
		AncientPlant = new BlockAncientPlant(AncientPlantID, 0).setHardness(0.0F).setResistance(1.0F).setBlockName("AncientPlant");
		sugarcaneBlock = (new BlockReed1(sugarcaneBlockID, 73)).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setBlockName("sugarcaneBlock");
		cornBlock = new BlockCorn(cornBlockID, 40).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setBlockName("sugarcaneBlock");
		cornStalk = new BlockCornStalk(cornStalkID, 24).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setBlockName("cornStalk");
		HayBale = new BlockHayBale(HayBaleID, 24).setHardness(0.5F).setStepSound(Block.soundGrassFootstep).setBlockName("HayBale");
		
		
		//Items
		AncientFlower = new ItemBasic(AncientFlowerIID).setIconCoord(238, 0).setItemName("AncientFlower").setCreativeTab(RCB.Reactioncraft);
		CornSeed = new ItemBasicSeed(CornSeedIID, RCPM.cornStalk.blockID, Block.tilledField.blockID).setIconCoord(247, 0).setItemName("CornSeed");
		AncientSeeds = new ItemBasicSeed(AncientSeedsIID, RCPM.AncientPlant.blockID, Block.tilledField.blockID).setIconCoord(133, 0).setItemName("AncientSeeds");
		AncientFruit = new ItemBasicFood(AncientFruitIID, 8, true).setIconCoord(100, 0).setItemName("AncientFruit");
		CocoSeed = new ItemBasicSeed(CocoSeedIID, RCPM.CocoCrop.blockID, Block.tilledField.blockID).setIconCoord(255, 0).setItemName("CocoSeed");
		CocoBean = new ItemBasic(CocoBeanIID).setIconCoord(255, 0).setItemName("CocoBean");
		VanillaSeed= new ItemBasic(VanillaSeedIID).setIconCoord(109, 0).setItemName("VanillaSeed");
		VanillaBean= new ItemBasic(VanillaBeanIID).setIconCoord(109, 0).setItemName("VanillaBean");
		sugarcaneItem = (new Itemsugarcane(sugarcaneItemIID, RCPM.sugarcaneBlock)).setIconCoord(27, 0).setItemName("sugarcaneItem").setCreativeTab(RCB.Reactioncraftfood);
		stalksItem = (new ItemStalks(stalksItemIID, RCPM.cornBlock)).setIconCoord(244, 0).setItemName("Stalks").setCreativeTab(RCB.Reactioncraft);
		Wrappedcorn = new ItemBasic(WrappedcornIID).setIconCoord(239, 0).setItemName("Wrappedcorn").setCreativeTab(RCB.Reactioncraftfood);
		
		
		
		//Registry Code
		GameRegistry.registerBlock(cornStalk, "cornStalk");
		GameRegistry.registerBlock(HayBale, "Hay Bale");
		GameRegistry.registerBlock(cornBlock, "Corn Block");
		GameRegistry.registerBlock(CocoCrop, "CocoCrop");
		GameRegistry.registerBlock(AncientPlant, "AncientPlant");
		GameRegistry.registerBlock(sugarcaneBlock, "SugarcaneBlock");
		GameRegistry.registerItem(sugarcaneItem, "sugarcaneItem");
		
		
		GameRegistry.addSmelting(CocoSeed.itemID, new ItemStack(CocoBean), 0.1F); 
		
		//Block Code
		LanguageRegistry.addName(cornBlock, "Corn Plant");
		LanguageRegistry.addName(cornStalk, "Corn Stalk");
		
		
		//Item Code
		LanguageRegistry.addName(CornSeed, "Corn Seed");
		LanguageRegistry.addName(AncientSeeds, "Ancient Seeds");
		LanguageRegistry.addName(AncientFruit, "Ancient Fruit");
		LanguageRegistry.addName(CocoSeed, "Coco Seed");
		LanguageRegistry.addName(CocoBean, "Coco Bean");
		LanguageRegistry.addName(sugarcaneItem, "Sugar Cane");
		LanguageRegistry.addName(AncientFlower, "Ancient Flower");
		LanguageRegistry.addName(Wrappedcorn, "Corn");
		LanguageRegistry.addName(stalksItem, "Corn Stalks");
		
		//MY Taller Sugarcane to Paper & sugar
		GameRegistry.addRecipe(new ItemStack(Item.paper, 3), new Object[] {"###", '#', RCPM.sugarcaneItem});
		GameRegistry.addRecipe(new ItemStack(Item.sugar, 1), new Object[] {"#", '#', RCPM.sugarcaneItem});
		
		//How to get mutated sugarcane
		GameRegistry.addShapelessRecipe(new ItemStack(sugarcaneItem, 2), new Object[] {AncientFlower, Item.reed});
		
		//Hay Bale Recipe and Downgrade Recipe
		GameRegistry.addRecipe(new ItemStack(RCPM.HayBale, 1), new Object[]{ "###", "###", "###", Character.valueOf('#'), Item.wheat});	
		GameRegistry.addShapelessRecipe(new ItemStack(Item.wheat, 9), new Object[]{HayBale});
		
		//Mojang coco bean to ours... Cooked one to ours (Rewriting this)
		GameRegistry.addShapelessRecipe(new ItemStack(AncientSeeds, 1), new Object[] {AncientFlower});
		GameRegistry.addShapelessRecipe(new ItemStack(AncientSeeds, 2), new Object[] {AncientFruit});
		GameRegistry.addRecipe(new ItemStack(CocoSeed, 1), new Object[]{ "   ", " # ", "   ", Character.valueOf('#'), CocoBean});
		GameRegistry.addRecipe(new ItemStack(CocoSeed, 1), new Object[]{ "   ", " # ", "   ", Character.valueOf('#'), new ItemStack(Item.dyePowder, 1, 3)});
		GameRegistry.addRecipe(new ItemStack(Item.cookie, 12), new Object[]{ "   ", "   ", "D#D", Character.valueOf('#'), CocoBean, Character.valueOf('D'), Item.wheat});
		
		//Ore Dict
		OreDictionary.registerOre("cocoBean", new ItemStack(CocoBean));
		OreDictionary.registerOre("wrappedCorn", new ItemStack(Wrappedcorn));
		
		//To aquire ancient plant seeds
		//ChestGenHooks.addItem(ChestGenHooks.VILLAGE_BLACKSMITH, new WeightedRandomChestContent(lootStack, minStackSize, maxStackSize, chance));
		ChestGenHooks.addItem(ChestGenHooks.BONUS_CHEST, new WeightedRandomChestContent(new ItemStack(RCPM.AncientFruit), 1, 2, 5));
		ChestGenHooks.addItem(ChestGenHooks.MINESHAFT_CORRIDOR, new WeightedRandomChestContent(new ItemStack(RCPM.AncientFruit), 1, 5, 15));
		ChestGenHooks.addItem(ChestGenHooks.PYRAMID_JUNGLE_CHEST, new WeightedRandomChestContent(new ItemStack(RCPM.AncientFruit), 1, 5, 15));
		
		//Ancient Flower
		ChestGenHooks.addItem(ChestGenHooks.BONUS_CHEST, new WeightedRandomChestContent(new ItemStack(RCPM.AncientFlower), 1, 2, 5));
		ChestGenHooks.addItem(ChestGenHooks.MINESHAFT_CORRIDOR, new WeightedRandomChestContent(new ItemStack(RCPM.AncientFlower), 1, 5, 15));
		ChestGenHooks.addItem(ChestGenHooks.PYRAMID_JUNGLE_CHEST, new WeightedRandomChestContent(new ItemStack(RCPM.AncientFlower), 1, 5, 15));
		
		//Corn
		MinecraftForge.addGrassSeed(new ItemStack(RCPM.CornSeed), 90);
		ChestGenHooks.addItem(ChestGenHooks.BONUS_CHEST, new WeightedRandomChestContent(new ItemStack(RCPM.CornSeed), 1, 2, 5));
		ChestGenHooks.addItem(ChestGenHooks.MINESHAFT_CORRIDOR, new WeightedRandomChestContent(new ItemStack(RCPM.CornSeed), 1, 5, 15));
		ChestGenHooks.addItem(ChestGenHooks.PYRAMID_JUNGLE_CHEST, new WeightedRandomChestContent(new ItemStack(RCPM.CornSeed), 1, 5, 15));
	 
		//Sugarcane
		ChestGenHooks.addItem(ChestGenHooks.BONUS_CHEST, new WeightedRandomChestContent(new ItemStack(RCPM.sugarcaneItem), 1, 2, 5));
		ChestGenHooks.addItem(ChestGenHooks.MINESHAFT_CORRIDOR, new WeightedRandomChestContent(new ItemStack(RCPM.sugarcaneItem), 1, 5, 15));
		ChestGenHooks.addItem(ChestGenHooks.PYRAMID_JUNGLE_CHEST, new WeightedRandomChestContent(new ItemStack(RCPM.sugarcaneItem), 1, 5, 15));
	 }
	 

	 @PostInit
	 public void modsLoaded(FMLPostInitializationEvent evt)
	 {
		 //new as well! How about that stuff after the mods are loaded/initialized?
	 }
	 
	 
}
