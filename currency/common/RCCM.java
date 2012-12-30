package Reactioncraft.currency.common;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.src.ModLoader;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import Reactioncraft.base.common.RCB;
import Reactioncraft.basic.common.ItemBasic;
import Reactioncraft.basic.common.ItemContainer;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "RCCM", name="Reactioncraft Currency", version="[1.4.5] Reactioncraft Version 5.0")
@NetworkMod(channels = { "RCCM" }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)

public class RCCM
{
	@SidedProxy(clientSide = "Reactioncraft.currency.common.ClientProxy", serverSide = "Reactioncraft.currency.common.CommonProxy")
	//@SidedProxy(clientSide = "Reactioncraft.currency.common.ClientProxy", serverSide = "Reactioncraft.currency.common.CommonProxy")
	
	public static CommonProxy proxy;
	@Instance("RCCM")
	public static RCCM instance;
	
	//Config
	public static int MetadatacoinIID;
	public static int Metadatacoin2IID;
	public static int CrownIID;
	public static int KinglyChestIID;
	public static int KinglyLegsIID;
	public static int KinglyBootsIID;	
	public static int BagIID;
	public static int SackIID;
	public static int StrawIID;
	public static int CoinMouldIID;
	public static int CoinMould2IID;
	
	
	//Items
	public static Item Metadatacoin;
	public static Item Metadatacoin2;
	public static Item Crown;
	public static Item KinglyChest;
	public static Item KinglyLegs;
	public static Item KinglyBoots;	
	public static Item Bag;
	public static Item Sack;
	public static Item Straw;
	public static Item CoinMould;
	public static Item CoinMould2;
	
	private int renderSilver;
	
	@PreInit
	 public void preInit(FMLPreInitializationEvent evt)
	 {
		 Configuration config = new Configuration(evt.getSuggestedConfigurationFile());

        config.load();
        
        //Items... 10081 - 10120
        CrownIID = config.getItem("Crown", 10097).getInt();
        KinglyChestIID = config.getItem("King Chest", 10098).getInt();
        KinglyLegsIID = config.getItem("King Legs", 10099).getInt();
        KinglyBootsIID = config.getItem("King Boots", 10100).getInt();	
        BagIID = config.getItem("Bag", 10101).getInt();
        SackIID = config.getItem("Sack", 10102).getInt();
        StrawIID = config.getItem("Straw", 10103).getInt();
        CoinMouldIID = config.getItem("Coin Mould 1", 10106).getInt();
        CoinMould2IID = config.getItem("Coin Mould 2", 10115).getInt();
        MetadatacoinIID = config.getItem("Metadata Coin", 10119).getInt();
        Metadatacoin2IID = config.getItem("Second Metadata Coin", 10120).getInt();

        config.save();
	 }	
	
	
	public void furnaceRecipes() 
	{
		GameRegistry.addSmelting(RCCM.Crown.shiftedIndex, new ItemStack(RCCM.Metadatacoin,5,2), 0.5F);
		GameRegistry.addSmelting(Block.tallGrass.blockID, new ItemStack(Straw), 0.5F); 
		GameRegistry.addSmelting(Item.ingotGold.shiftedIndex, new ItemStack(RCCM.Metadatacoin,1,2), 0.5F); 
		
		//Metadata Smelting Recipes
		FurnaceRecipes.smelting().addSmelting(RCCM.Metadatacoin.shiftedIndex,11, new ItemStack(RCCM.Metadatacoin,1,2), 0.5F);
		FurnaceRecipes.smelting().addSmelting(RCCM.Metadatacoin2.shiftedIndex,0, new ItemStack(RCCM.Metadatacoin,1,0), 0.5F);
		FurnaceRecipes.smelting().addSmelting(RCCM.Metadatacoin2.shiftedIndex,5, new ItemStack(RCCM.Metadatacoin,1,1), 0.5F);
		
		FurnaceRecipes.smelting().addSmelting(RCCM.Metadatacoin.shiftedIndex,7, new ItemStack(RCCM.Metadatacoin,1,3), 0.5F);
		FurnaceRecipes.smelting().addSmelting(RCCM.Metadatacoin.shiftedIndex,8, new ItemStack(RCCM.Metadatacoin,1,4), 0.5F);
		FurnaceRecipes.smelting().addSmelting(RCCM.Metadatacoin.shiftedIndex,9, new ItemStack(RCCM.Metadatacoin,1,5), 0.5F);
		FurnaceRecipes.smelting().addSmelting(RCCM.Metadatacoin.shiftedIndex,10, new ItemStack(RCCM.Metadatacoin,1,6), 0.5F);
	}
	

	@Init
	public void load(FMLInitializationEvent event)
	{
		proxy.registerRenderInformation();
		
		//Metadata coin..
		Metadatacoin = (new CoinMetaItem(MetadatacoinIID));
		Metadatacoin2 = (new CoinMetaItem2(Metadatacoin2IID));
		
		//Leave be
		Bag = (new ItemBasic(BagIID).setIconCoord(145, 0).setItemName("Bag"));
		Sack = (new ItemBasic(SackIID).setIconCoord(64, 0).setItemName("Sack"));
		Straw = (new ItemBasic(StrawIID).setIconCoord(67, 0).setItemName("Straw"));
		CoinMould2 = new ItemContainer(CoinMould2IID).setMaxStackSize(1).setIconCoord(253, 0).setItemName("CoinMould");
		CoinMould = new ItemBasic(CoinMouldIID).setIconCoord(253, 0).setMaxStackSize(1).setItemName("CoinMould").setContainerItem(RCCM.CoinMould2);
		Crown = (new CurrencyArmor(CrownIID, EnumArmorMaterial.IRON, renderSilver, 0)).setIconCoord(186, 0).setItemName("Crown").setCreativeTab(RCB.Reactioncraft);
		KinglyChest = (new CurrencyArmor(KinglyChestIID, EnumArmorMaterial.IRON, renderSilver, 1)).setIconCoord(187, 0).setItemName("KinglyChest").setCreativeTab(RCB.Reactioncraft);
		KinglyLegs = (new CurrencyArmor(KinglyLegsIID, EnumArmorMaterial.IRON, renderSilver, 2)).setIconCoord(188, 0).setItemName("KinglyLegs").setCreativeTab(RCB.Reactioncraft);
		KinglyBoots = (new CurrencyArmor(KinglyBootsIID, EnumArmorMaterial.IRON, renderSilver, 3).setIconCoord(189, 0).setItemName("KinglyBoots").setCreativeTab(RCB.Reactioncraft));		
		
		
		//Rewrite as metadata
		//put into CoinMetaItem
//		SilverIngot = new ItemBasic(SilverIngotIID).setIconCoord(61, 0).setItemName("SilverIngot");//replace with one thats nessicary
//		BronzeIngot = (new ItemBasic(BronzeIngotIID)).setIconCoord(60, 0).setItemName("BronzeIngot");
//		RefinedGIngot = (new ItemBasic(RefinedGIngotIID)).setIconCoord(62, 0).setItemName("RefinedGIngot");
//		MoltenGold = new ItemBasic(MoltenGoldIID).setIconCoord(252, 0).setItemName("MoltenGold");
//		MoltenSilver = new ItemBasic(MoltenSilverIID).setIconCoord(251, 0).setItemName("MoltenSilver").setContainerItem(Item.bucketEmpty);
//		MoltenBronze = new ItemBasic(MoltenBronzeIID).setIconCoord(250, 0).setItemName("MoltenBronze").setContainerItem(Item.bucketEmpty);
//		MoltenCopper = new ItemBasic(MoltenCopperIID).setIconCoord(249, 0).setItemName("MoltenCopper").setContainerItem(Item.bucketEmpty);
//		Goldingotbucket = new ItemBasic(GoldingotbucketIID).setIconCoord(248, 0).setItemName("Goldingotbucket");
//		Silveringotbucket = new ItemBasic(SilveringotbucketIID).setIconCoord(247, 0).setItemName("Goldingotbucket");
//		Bronzeingotbucket = new ItemBasic(BronzeingotIID).setIconCoord(246, 0).setItemName("Goldingotbucket");
//		Copperingotbucket = new ItemBasic(CopperingotbucketIID).setIconCoord(245, 0).setItemName("Goldingotbucket");
//		GoldCoin = (new ItemBasic(GoldCoinIID).setIconCoord(58, 0).setItemName("GoldCoin"));
//		GoldCoins = (new ItemBasic(GoldCoinsIID).setIconCoord(171, 0).setItemName("GoldCoins"));
//		GoldStack = (new ItemBasic(GoldStackIID).setIconCoord(53, 0).setItemName("GoldStack"));
//		GoldSack = (new ItemBasic(GoldSackIID).setIconCoord(50, 0).setItemName("GoldSack")).setContainerItem(Sack);
//		GoldBag = (new ItemBasic(GoldBagIID).setIconCoord(140, 0).setItemName("GoldBag")).setContainerItem(Bag);
		
		//put in CoinMetaItem2
//		SilverCoin = (new ItemBasic(SilverCoinIID).setIconCoord(57, 0).setItemName("SilverCoin"));
//		SilverCoins = (new ItemBasic(SilverCoinsIID).setIconCoord(172, 0).setItemName("SilverCoins"));
//		SilverStack = (new ItemBasic(SilverStackIID).setIconCoord(54, 0).setItemName("SilverStack"));
//		SilverSack = (new ItemBasic(SilverSackIID).setIconCoord(49, 0).setItemName("SilverSack")).setContainerItem(Sack);
//		SilverBag = (new ItemBasic(SilverBagIID).setIconCoord(143, 0).setItemName("SilverBag")).setContainerItem(Bag);
//		BronzeCoin = (new ItemBasic(BronzeCoinIID).setIconCoord(56, 0).setItemName("BronzeCoin"));
//		BronzeCoins = (new ItemBasic(BronzeCoinsIID).setIconCoord(173, 0).setItemName("BronzeCoins"));
//		BronzeStack = (new ItemBasic(BronzeStackIID).setIconCoord(55, 0).setItemName("BronzeStack"));
//		BronzeSack = (new ItemBasic(BronzeSackIID).setIconCoord(48, 0).setItemName("BronzeSack")).setContainerItem(Sack);
//		BronzeBag = (new ItemBasic(BronzeBagIID).setIconCoord(139, 0).setItemName("BronzeBag")).setContainerItem(Bag);
//		CopperCoin = (new ItemBasic(CopperCoinIID).setIconCoord(174, 0).setItemName("CopperCoin"));

		
		addNames();
		furnaceRecipes();
		addRecipes();
	}
	
	public void addNames()
	{
		LanguageRegistry.addName(CoinMould, "Coin Mould");
		LanguageRegistry.addName(Crown, "Crown");
		LanguageRegistry.addName(KinglyChest, "Kingly Chestplate");
		LanguageRegistry.addName(KinglyLegs, "Kingly Legplate");
		LanguageRegistry.addName(KinglyBoots, "Kingly Boots");
		LanguageRegistry.addName(Bag, "bag");
		LanguageRegistry.addName(Sack, "sack");
		LanguageRegistry.addName(Straw, "Straw");

		LanguageRegistry.addName(new ItemStack(RCCM.Metadatacoin, 1, 0), "Silver Ingot");
		LanguageRegistry.addName(new ItemStack(RCCM.Metadatacoin, 1, 1), "Bronze Ingot");
		LanguageRegistry.addName(new ItemStack(RCCM.Metadatacoin, 1, 2), "Refined Gold Ingot");
		LanguageRegistry.addName(new ItemStack(RCCM.Metadatacoin, 1, 3), "Molten Gold");
		LanguageRegistry.addName(new ItemStack(RCCM.Metadatacoin, 1, 4), "Molten Silver");
		LanguageRegistry.addName(new ItemStack(RCCM.Metadatacoin, 1, 5), "Molten Bronze");
		LanguageRegistry.addName(new ItemStack(RCCM.Metadatacoin, 1, 6), "Molten Copper");
		LanguageRegistry.addName(new ItemStack(RCCM.Metadatacoin, 1, 7), "Bucket with Gold Ingot");
		LanguageRegistry.addName(new ItemStack(RCCM.Metadatacoin, 1, 8), "Bucket with Silver Ingot");
		LanguageRegistry.addName(new ItemStack(RCCM.Metadatacoin, 1, 9), "Bucket with Bronze Ingot");
		LanguageRegistry.addName(new ItemStack(RCCM.Metadatacoin, 1, 10), "Bucket with Copper Ingot");
		LanguageRegistry.addName(new ItemStack(RCCM.Metadatacoin, 1, 11), "Gold Coin");
		LanguageRegistry.addName(new ItemStack(RCCM.Metadatacoin, 1, 12), "Gold Coins");
		LanguageRegistry.addName(new ItemStack(RCCM.Metadatacoin, 1, 13), "Gold Stack");
		LanguageRegistry.addName(new ItemStack(RCCM.Metadatacoin, 1, 14), "Gold Sack");
		LanguageRegistry.addName(new ItemStack(RCCM.Metadatacoin, 1, 15), "Gold Bag");
		
		LanguageRegistry.addName(new ItemStack(RCCM.Metadatacoin2, 1, 0), "Silver Coin");
		LanguageRegistry.addName(new ItemStack(RCCM.Metadatacoin2, 1, 1), "Silver Coins");
		LanguageRegistry.addName(new ItemStack(RCCM.Metadatacoin2, 1, 2), "Silver Stack");
		LanguageRegistry.addName(new ItemStack(RCCM.Metadatacoin2, 1, 3), "Silver Sack");
		LanguageRegistry.addName(new ItemStack(RCCM.Metadatacoin2, 1, 4), "Silver Bag");
		LanguageRegistry.addName(new ItemStack(RCCM.Metadatacoin2, 1, 5), "Bronze Coin");
		LanguageRegistry.addName(new ItemStack(RCCM.Metadatacoin2, 1, 6), "Bronze Coins");
		LanguageRegistry.addName(new ItemStack(RCCM.Metadatacoin2, 1, 7), "Bronze Stack");
		LanguageRegistry.addName(new ItemStack(RCCM.Metadatacoin2, 1, 8), "Bronze Sack");
		LanguageRegistry.addName(new ItemStack(RCCM.Metadatacoin2, 1, 9), "Bronze Bag");
		LanguageRegistry.addName(new ItemStack(RCCM.Metadatacoin2, 1, 10), "Copper Coin");
//		LanguageRegistry.addName(new ItemStack(RCCM.Metadatacoin2, 1, 11), "Ingot Bucket"); VOIDED
//		LanguageRegistry.addName(new ItemStack(RCCM.Metadatacoin2, 1, 12), "Ingot Bucket"); VOIDED
//		LanguageRegistry.addName(new ItemStack(RCCM.Metadatacoin2, 1, 13), "Ingot Bucket"); VOIDED
//		LanguageRegistry.addName(new ItemStack(RCCM.Metadatacoin2, 1, 14), "Ingot Bucket"); VOIDED
//		LanguageRegistry.addName(new ItemStack(RCCM.Metadatacoin2, 1, 15), "Ingot Bucket"); VOIDED
	}
	
	public void addRecipes()
	{
		GameRegistry.addRecipe(new ItemStack(RCCM.Bag,1), new Object[]{
            "TTT","T T","TTT",'T', Straw
		});
		GameRegistry.addRecipe(new ItemStack(RCCM.Sack,1), new Object[]{
            "   ","TTT","TTT",'T', Straw
		});
		GameRegistry.addRecipe(new ItemStack(RCCM.Crown,1), new Object[]{
            "T T","TTT","   ",'T', Item.ingotGold
		});
		GameRegistry.addRecipe(new ItemStack(RCCM.KinglyChest,1), new Object[]{
            "TTT","TTT","T T",'T', Block.cloth
		});            
		GameRegistry.addRecipe(new ItemStack(RCCM.KinglyLegs,1), new Object[]{
            "TTT","T T","T T",'T', Block.cloth
		});            
		GameRegistry.addRecipe(new ItemStack(RCCM.KinglyBoots,1), new Object[]{
            "   ","T T","T T",'T', Block.cloth
		});
		
		//Coin Downgrade Recipes - Crafting
		GameRegistry.addShapelessRecipe(new ItemStack(RCCM.Metadatacoin, 6, 11), new Object[]{new ItemStack(RCCM.Metadatacoin, 1, 12),});
		GameRegistry.addShapelessRecipe(new ItemStack(RCCM.Metadatacoin, 18, 11), new Object[]{new ItemStack(RCCM.Metadatacoin,1,13),});
		GameRegistry.addShapelessRecipe(new ItemStack(RCCM.Metadatacoin, 6, 13), new Object[]{new ItemStack(RCCM.Metadatacoin, 1, 14),});
		GameRegistry.addShapelessRecipe(new ItemStack(RCCM.Metadatacoin, 54, 13), new Object[]{new ItemStack(RCCM.Metadatacoin, 1, 15),});
		
		GameRegistry.addShapelessRecipe(new ItemStack(RCCM.Metadatacoin2, 6, 0), new Object[]{new ItemStack(RCCM.Metadatacoin2, 1, 1),});
		GameRegistry.addShapelessRecipe(new ItemStack(RCCM.Metadatacoin2, 18, 0), new Object[]{new ItemStack(RCCM.Metadatacoin2, 1, 2),});
		GameRegistry.addShapelessRecipe(new ItemStack(RCCM.Metadatacoin2, 6, 2), new Object[]{new ItemStack(RCCM.Metadatacoin2,1,3),});
		GameRegistry.addShapelessRecipe(new ItemStack(RCCM.Metadatacoin2, 54, 2), new Object[]{new ItemStack(RCCM.Metadatacoin2,1,4),});
		
		GameRegistry.addShapelessRecipe(new ItemStack(RCCM.Metadatacoin2, 6,6), new Object[]{new ItemStack(RCCM.Metadatacoin2,1,5),});
		GameRegistry.addShapelessRecipe(new ItemStack(RCCM.Metadatacoin2, 18,6), new Object[]{new ItemStack(RCCM.Metadatacoin2,1,7),});
		GameRegistry.addShapelessRecipe(new ItemStack(RCCM.Metadatacoin2, 6,7), new Object[]{new ItemStack(RCCM.Metadatacoin2,1,8),});
		GameRegistry.addShapelessRecipe(new ItemStack(RCCM.Metadatacoin2, 54,7), new Object[]{new ItemStack(RCCM.Metadatacoin2,1,9),});
		
		
		//Coin Crafting Recipes
		//Gold
		GameRegistry.addShapelessRecipe(new ItemStack(RCCM.Metadatacoin, 2,11), new Object[]{new ItemStack(RCCM.Metadatacoin,1,3), CoinMould,});
		GameRegistry.addShapelessRecipe(new ItemStack(RCCM.Metadatacoin, 2,11), new Object[]{new ItemStack(RCCM.Metadatacoin,1,3), CoinMould2,});
		GameRegistry.addRecipe(new ItemStack(RCCM.Metadatacoin, 1, 12), new Object[]{ "###", "###", "###", Character.valueOf('#'), new ItemStack(RCCM.Metadatacoin, 2,11),});
		GameRegistry.addRecipe(new ItemStack(RCCM.Metadatacoin, 1, 13), new Object[]{ "   ", "DDD", "   ", Character.valueOf('D'), new ItemStack(RCCM.Metadatacoin, 2,12),});
		GameRegistry.addRecipe(new ItemStack(RCCM.Metadatacoin, 1, 14), new Object[]{ "###", "###", " D ", Character.valueOf('#'), new ItemStack(RCCM.Metadatacoin, 2,13), Character.valueOf('D'), Sack});
		GameRegistry.addRecipe(new ItemStack(RCCM.Metadatacoin, 1, 15), new Object[]{ "   ", "###", " D ", Character.valueOf('#'), new ItemStack(RCCM.Metadatacoin, 2,14), Character.valueOf('D'), Bag});
		
		//Silver
		GameRegistry.addShapelessRecipe(new ItemStack(RCCM.Metadatacoin2, 2, 0), new Object[]{new ItemStack(RCCM.Metadatacoin,1,4), CoinMould,});
		GameRegistry.addShapelessRecipe(new ItemStack(RCCM.Metadatacoin2, 2, 0), new Object[]{new ItemStack(RCCM.Metadatacoin,1,4), CoinMould2,});
		GameRegistry.addRecipe(new ItemStack(RCCM.Metadatacoin2, 1, 1), new Object[]{ "###", "###", "###", Character.valueOf('#'), new ItemStack(RCCM.Metadatacoin2, 1, 0),});
		GameRegistry.addRecipe(new ItemStack(RCCM.Metadatacoin2, 1,2), new Object[]{ "   ", "DDD", "   ", Character.valueOf('D'), new ItemStack(RCCM.Metadatacoin2, 1, 1)});
		GameRegistry.addRecipe(new ItemStack(RCCM.Metadatacoin2, 1,3), new Object[]{ "###", "###", " D ", Character.valueOf('#'), new ItemStack(RCCM.Metadatacoin2, 1, 2), Character.valueOf('D'), Sack});
		GameRegistry.addRecipe(new ItemStack(RCCM.Metadatacoin2, 1,4), new Object[]{ "   ", "###", " D ", Character.valueOf('#'), new ItemStack(RCCM.Metadatacoin2, 1, 3), Character.valueOf('D'), Bag});
		
		//Bronze
		GameRegistry.addShapelessRecipe(new ItemStack(RCCM.Metadatacoin2, 2, 5), new Object[]{new ItemStack(RCCM.Metadatacoin,1,5), CoinMould,});
		GameRegistry.addShapelessRecipe(new ItemStack(RCCM.Metadatacoin2, 2, 5), new Object[]{new ItemStack(RCCM.Metadatacoin,1,5), CoinMould2,});
		GameRegistry.addRecipe(new ItemStack(RCCM.Metadatacoin2, 1, 6), new Object[]{ "###", "###", "###", Character.valueOf('#'), new ItemStack(RCCM.Metadatacoin2,1,5),});
		GameRegistry.addRecipe(new ItemStack(RCCM.Metadatacoin2, 1, 7), new Object[]{ "   ", "DDD", "   ", Character.valueOf('D'), new ItemStack(RCCM.Metadatacoin2,1,6),});
		GameRegistry.addRecipe(new ItemStack(RCCM.Metadatacoin2, 1, 8), new Object[]{ "###", "###", " D ", Character.valueOf('#'), new ItemStack(RCCM.Metadatacoin2,1,7), Character.valueOf('D'), Sack});
		GameRegistry.addRecipe(new ItemStack(RCCM.Metadatacoin2, 1, 9), new Object[]{ "   ", "###", " D ", Character.valueOf('#'), new ItemStack(RCCM.Metadatacoin2,1,8), Character.valueOf('D'), Bag});
		
		//Copper
		GameRegistry.addShapelessRecipe(new ItemStack(RCCM.Metadatacoin2, 2, 10), new Object[]{new ItemStack(RCCM.Metadatacoin,1,6), CoinMould,});
		GameRegistry.addShapelessRecipe(new ItemStack(RCCM.Metadatacoin2, 2, 10), new Object[]{new ItemStack(RCCM.Metadatacoin,1,6), CoinMould2,});
		
	
		
		//Bronze Ingot
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(RCCM.Metadatacoin,1,1), true, new Object[]{
		         "XY ", "YX ", "   ", Character.valueOf('X'), "ingotCopper", Character.valueOf('Y'), "ingotTin"}));
		
		
		//Compatability Items
		GameRegistry.addShapelessRecipe(new ItemStack(RCCM.Metadatacoin, 1,7), new Object[]{new ItemStack(RCCM.Metadatacoin,1,2), Item.bucketEmpty,});
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(RCCM.Metadatacoin,1,8), true, new Object[]{" Y ", " X ", "   ", Character.valueOf('X'), Item.bucketEmpty, Character.valueOf('Y'), "ingotSilver"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(RCCM.Metadatacoin,1,9), true, new Object[]{" Y ", " X ", "   ", Character.valueOf('X'), Item.bucketEmpty, Character.valueOf('Y'), "ingotBronze"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(RCCM.Metadatacoin,1,10), true, new Object[]{" Y ", " X ", "   ", Character.valueOf('X'), Item.bucketEmpty, Character.valueOf('Y'), "ingotCopper"}));
		
		//To Share
		OreDictionary.registerOre("ingotBronze", new ItemStack(RCCM.Metadatacoin, 1, 1));
		OreDictionary.registerOre("ingotSilver", new ItemStack(RCCM.Metadatacoin, 1, 0));
		
		//to fix null naming crash
		LanguageRegistry.addName(CoinMould, "Coin Mould");
	}
	
	
//	//public void takenFromCrafting(EntityPlayer entityplayer, ItemStack itemstack, IInventory iinventory) 
//	  public void doesContainerItemLeaveCraftingGrid(EntityPlayer entityplayer, ItemStack itemstack, IInventory iinventory)
//		{
//		for (int i = 0; i < iinventory.getSizeInventory(); i++) {
//			ItemStack item = iinventory.getStackInSlot(i);
//			// You can do other checks to make sure it's the right recipe if you have other recipes in which the item is not damaged but is used as normal.
//			if (item != null && item.getItem() == RCCM.CoinMould) {
//				// Damage the item.
//				item.setItemDamage(item.getItemDamage() + 1);
//				// Dirty hack to keep one in there, you should set your items max stack size to 1 as damaged items in stacks all items in the stack are damaged not just one.
//				item.stackSize = 2;
//				// Dirty hack to compensate for some weird glitch where only half the items are created when shift clicking.
//				if (itemstack.stackSize == 0 && item.getItemDamage() % 2 == 0) {
//					ItemStack newItem = itemstack.copy();
//					newItem.stackSize = 1;
//					entityplayer.inventory.addItemStackToInventory(newItem);
//				}
//				// Debug. As you'll notice that the itemstack that is introduced is actually what you clicked on the crafting result with plus that item.
//				// When shift clicking the itemstack has a stack size of 0 for some reason.
//				System.out.println("It worked with " + item.getItemDamage() + " damage and resulted in " + itemstack);
//			}
//		}
//		// This isn't needed I don't think, but just in case :3
//		//super.takenFromCrafting(entityplayer, itemstack, iinventory);
//	}
}
