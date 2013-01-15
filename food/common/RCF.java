package Reactioncraft.food.common;

import Reactioncraft.food.common.ClientProxy;
import Reactioncraft.food.common.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.Configuration;
import Reactioncraft.base.common.RCB;
import Reactioncraft.basic.common.BlockBasicCake;
import Reactioncraft.basic.common.ItemBasic;
import Reactioncraft.basic.common.ItemBasicFood;
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

@Mod( modid = "RCF", name="Reactioncraft Food", version="[1.4.5] Reactioncraft Version 5.0")
@NetworkMod(channels = { "RCF" }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)

public class RCF
{
	//@SidedProxy(clientSide = "ClientProxy", serverSide = "CommonProxy")
	@SidedProxy(clientSide = "Reactioncraft.food.common.ClientProxy", serverSide = "Reactioncraft.food.common.CommonProxy")
	
	public static CommonProxy proxy;
	@Instance("RCF")
	public static RCF instance;
	
	//config
//	public static int ChoclateCakeID;
//	public static int carrotcakeID;
//	public static int cciIID;
//	public static int uncookedccIID;
//	public static int CakepanIID;
//	public static int CakeMBIID;
//	public static int uncookedbreadIID;
//	public static int IceBucketIID;
//	public static int saltedFishIID;
//	public static int fishonstickIID;
//	public static int JellyfishIID;
//	public static int JellyfishonstickIID;
//	public static int bowlofeggsIID;
//	public static int OmletIID;
//	public static int whitechoclatebarIID;
//	public static int choclatebarIID;
//	public static int darkchoclatebarIID;
//	public static int choclatebarmouldIID;
//	public static int CoconutcakeIID;
//	public static int BaconIID;
//	public static int BaconRawIID;
//	public static int ChickenNuggetsIID;
//	public static int RawNuggetsIID;
//	public static int SlicedBreadIID;
//	public static int SteakSandwichIID;
//	public static int FishSandwichIID;
//	public static int HamSandwichIID;
//	public static int HamIID;
//	public static int SlicedCheeseIID;
//	public static int HamandCheeseSandwichIID;
//	public static int HoneybunIID;
//	public static int twinkieIID;
//	public static int ChoclateCakeItemIID;
//	public static int UncookedChoclateCakeIID;
//	public static int whitechoclateMilkIID;
//	public static int ChoclateMilkIID;
//	public static int BlueberryIID;
//	public static int RaspberryIID;
//	public static int blueberrypieIID;
//	public static int raspberrypieIID;
//	public static int applepieIID;
//	public static int WizimsurpriseIID;
//	public static int uncookedwizimsurpriseIID;
//	public static int FriesIID;
//	public static int MashedPotatoesIID;
//	public static int PancakemixIID;
//	public static int BlueberrypancakeIID;
//	public static int FriedEggsIID;
//	public static int BowlofeggsIID;
//	public static int scrambledeggsIID;
//	public static int PizzaIID;
//	public static int PizzaSliceIID;
//	public static int ShishkabobIID;
//	public static int ChickenonastickIID;
//	public static int NoodlesIID;
//	public static int bowlofnoodlesIID;
//	public static int VanillaPlantIID;
//	public static int ChoclateCakeIID;
//	public static int WizimSurpiseIID;
	
	//Implemented
	public static int EdibleFleshIID;
	public static int knifeIID;

//	public static Item Jellyfishonstick;
//	public static Item bowlofeggs;
//	public static Item whitechoclatebar;
//	public static Item choclatebar;
//	public static Item darkchoclatebar;
//	public static Item choclatebarmould;
//	public static Item Coconutcake;
//	public static Item Bacon;
//	public static Item BaconRaw;
//	public static Item ChickenNuggets;
//	public static Item RawNuggets;
//	public static Item SlicedBread;
//	public static Item SteakSandwich;
//	public static Item FishSandwich;
//	public static Item HamSandwich;
//	public static Item Ham;
//	public static Item SlicedCheese;
//	public static Item HamandCheeseSandwich;
//	public static Item Honeybun;
//	public static Item twinkie;
//	public static Item ChoclateCakeItem;
//	public static Item UncookedChoclateCake;
//	public static Item whitechoclateMilk;
//	public static Item ChoclateMilk;
//	public static Item Blueberry;
//	public static Item Raspberry;
//	public static Item blueberrypie;
//	public static Item raspberrypie;
//	public static Item applepie;
//	public static Item Wizimsurprise;
//	public static Item uncookedwizimsurprise;
//	public static Item Fries;
//	public static Item MashedPotatoes;
//	public static Item Pancakemix;
//	public static Item Blueberrypancake;
//	public static Item FriedEggs;
//	public static Item Bowlofeggs;
//	public static Item Omlet;
//	public static Item scrambledeggs;
//	public static Item Pizza;
//	public static Item PizzaSlice;
//	public static Item Shishkabob;
//	public static Item Chickenonastick;
//	public static Item Noodles;
//	public static Item bowlofnoodles;	
//	public static Item ccItem;
//	public static Item uncookedcc;
	
	//Blocks
//	public static Block carrotcake;
//	public static Block ChoclateCake;
	
	//Implemented Items
	public static Item Knfie;
	public static Item EdibleFlesh;
	 
	 @PreInit
	 public void preInit(FMLPreInitializationEvent evt)
	 {
	 //This is new! put stuff here that you want to happen before the mods are loaded
		 Configuration config = new Configuration(evt.getSuggestedConfigurationFile());

         config.load();
         
         //Block Ids 3121 - 3200
//         carrotcakeID = config.getBlock("Carrot Cake", 3121).getInt();	
//         ChoclateCakeID = config.getBlock("Chocolate Cake", 3122).getInt();
//
         //Claimed Item IDS 10601 - 10800
//         cciIID = config.getItem("Carrot Cake Item", 10602).getInt();
//         uncookedccIID = config.getItem("Uncooked Carrot Cake", 10603).getInt();
//         BaconRawIID = config.getItem("Raw Bacon", 10604).getInt();
//         CakepanIID = config.getItem("Cake Pan", 10607).getInt();
//         CakeMBIID = config.getItem("idk what this is..", 10608).getInt();
//         uncookedbreadIID = config.getItem("Uncooked Bread", 10609).getInt();
//         saltedFishIID = config.getItem("Salted Fish", 10610).getInt();
//         fishonstickIID = config.getItem("Fish on a stick", 10611).getInt();
//         JellyfishIID = config.getItem("Raw Jellyfish", 10612).getInt();
//         JellyfishonstickIID = config.getItem("Jellyfish on a stick", 10613).getInt();
//         bowlofeggsIID = config.getItem("Bowl of eggs", 13614).getInt();
//         OmletIID = config.getItem("Omlet", 10615).getInt();
//         whitechoclatebarIID = config.getItem("White Chocolate Bar", 10616).getInt();
//         choclatebarIID = config.getItem("Chocolate Bar", 10617).getInt();
//         darkchoclatebarIID = config.getItem("Dark Chocolate Bar", 10618).getInt();
//         choclatebarmouldIID = config.getItem("Chocolate bar mould", 10619).getInt();
//         CoconutcakeIID = config.getItem("Coconut Cake", 10620).getInt();
//         BaconIID = config.getItem("Bacon", 10621).getInt();
//         ChickenNuggetsIID = config.getItem("Chicken Nuggets", 10622).getInt();
//         RawNuggetsIID = config.getItem("Raw Nuggets", 10623).getInt();
//         SlicedBreadIID = config.getItem("Sliced Bread", 10624).getInt();
//         SteakSandwichIID = config.getItem("Steak Sandwich", 10625).getInt();
//         FishSandwichIID = config.getItem("Fish Sandwich", 10626).getInt();
//         HamSandwichIID = config.getItem("Ham Sandwich", 10627).getInt();
//         HamIID = config.getItem("Ham", 10628).getInt();
//         SlicedCheeseIID = config.getItem("Sliced Cheese", 10629).getInt();
//         HamandCheeseSandwichIID = config.getItem("Ham and Cheese Sandwich", 10630).getInt();
//         HoneybunIID = config.getItem("Honey Bun", 10631).getInt();
//         twinkieIID = config.getItem("Twinkie", 10632).getInt();
//         ChoclateCakeItemIID = config.getItem("Chocolate Cake", 10633).getInt();
//         UncookedChoclateCakeIID = config.getItem("Uncooked Chocolate Cake", 10634).getInt();
//         whitechoclateMilkIID = config.getItem("White Chocolate Milk", 10635).getInt();
//         ChoclateMilkIID = config.getItem("Chocolate Milk", 10636).getInt();
//         BlueberryIID = config.getItem("Blueberry", 10637).getInt();
//         RaspberryIID = config.getItem("Raspberry", 10638).getInt();
//         blueberrypieIID = config.getItem("Blueberry Pie", 10639).getInt();
//         raspberrypieIID = config.getItem("Raspberry Pie", 10640).getInt();
//         applepieIID = config.getItem("Apple Pie", 10641).getInt();
//         WizimsurpriseIID = config.getItem("Wizim Surpise", 10642).getInt();
//         uncookedwizimsurpriseIID = config.getItem("Uncooked Wizim Surprise", 10643).getInt();
//         FriesIID = config.getItem("Fries", 10644).getInt();
//         MashedPotatoesIID = config.getItem("Mashed Potatoes", 10645).getInt();
//         PancakemixIID = config.getItem("Pancake Mix", 10646).getInt();
//         BlueberrypancakeIID = config.getItem("Blueberry pancake", 10647).getInt();
//         FriedEggsIID = config.getItem("Fried Eggs", 10648).getInt();
//         scrambledeggsIID = config.getItem("Scrambled Eggs", 10650).getInt();
//         PizzaIID = config.getItem("Pizza", 10651).getInt();
//         PizzaSliceIID = config.getItem("Pizza Slice", 10652).getInt();
//         ShishkabobIID = config.getItem("Shish-k-bob", 10653).getInt();
//         ChickenonastickIID = config.getItem("Chicken on a stick", 10654).getInt();
//         NoodlesIID = config.getItem("Noodles", 10655).getInt();
//         bowlofnoodlesIID = config.getItem("Bowl of noodles", 10656).getInt();
//         VanillaPlantIID = config.getItem("Vanilla Plant", 10657).getInt();
         knifeIID = config.getItem("Knife", 10658).getInt();
         EdibleFleshIID = config.getItem("Edible Flesh", 10601).getInt();

         config.save();
	 }
	 
	 
	 @Init
	 public void load(FMLInitializationEvent event)
	 {
	 	//the meat of the mod
		//Claimed Block Ids 3038 - 3055
		//Claimed Item Ids 10075 - 10150
		ClientProxy.registerRenderInformation();
		
		//Cake / Pie Blocks
//		carrotcake = new BlockBasicCake(carrotcakeID, 0).setHardness(1.0F).setResistance(1.0F).setBlockName("carrotcake");
//		ChoclateCake = new BlockBasicCake(ChoclateCakeID, 0).setHardness(1.0F).setResistance(1.0F).setBlockName("Choclatecake");
//		
//		//Cake / Pie placer Items
//		ccItem = new BlockCakePlacerItem(cciIID, carrotcake).setIconCoord(120, 0).setItemName("ccItem");
//		uncookedcc = (new ItemFoodMod(uncookedccIID, 0, false).setIconCoord(58, 0).setItemName("uncookedcc"));
//		
//		
//		//Uncooked Regular Foods
//		BaconRaw = new ItemFoodMod(BaconRawIID, 0, false).setPotionEffect(Potion.hunger.id, 30, 0, 0.8F).setIconCoord(109, 0).setItemName("BaconRaw");
//		RawNuggets = new ItemFoodMod(RawNuggetsIID, 0, false).setPotionEffect(Potion.hunger.id, 30, 0, 0.8F).setIconCoord(109, 0).setItemName("RawNuggets");
//		UncookedChoclateCake= new ItemFoodMod(UncookedChoclateCakeIID, 0, false).setPotionEffect(Potion.hunger.id, 30, 0, 0.8F).setIconCoord(109, 0).setItemName("UncookedChoclateCake");
//		uncookedwizimsurprise= new ItemFoodMod(uncookedwizimsurpriseIID, 0, false).setPotionEffect(Potion.hunger.id, 30, 0, 0.8F).setIconCoord(109, 0).setItemName("uncookedwizimsurprise");
//		Bowlofeggs= new ItemFoodMod(BowlofeggsIID, 0, false).setPotionEffect(Potion.hunger.id, 30, 0, 0.8F).setIconCoord(109, 0).setItemName("Bowlofeggs");
//		
//		
//		//Cooked Regular Foods
//		Jellyfishonstick = new ItemFoodMod(JellyfishonstickIID, 0, false).setIconCoord(109, 0).setItemName("Jellyfishonstick").setContainerItem(Item.stick);
//		whitechoclatebar = new ItemFoodMod(whitechoclatebarIID, 0, false).setIconCoord(109, 0).setItemName("whitechoclatebar");
//		choclatebar = new ItemFoodMod(choclatebarIID, 0, false).setIconCoord(109, 0).setItemName("choclatebar");
//		darkchoclatebar = new ItemFoodMod(darkchoclatebarIID, 0, false).setIconCoord(109, 0).setItemName("darkchoclatebar");
//		choclatebarmould = new ItemFoodMod(choclatebarmouldIID, 0, false).setIconCoord(109, 0).setItemName(" choclatebarmould");
//		Coconutcake = new ItemFoodMod(CoconutcakeIID, 0, false).setIconCoord(109, 0).setItemName("Coconutcake");
//		Bacon = new ItemFoodMod(BaconIID, 0, false).setIconCoord(109, 0).setItemName("Bacon");
//		ChickenNuggets = new ItemFoodMod(ChickenNuggetsIID, 0, false).setIconCoord(109, 0).setItemName("ChickenNuggets");
//		SlicedBread = new ItemFoodMod(SlicedBreadIID, 0, false).setIconCoord(109, 0).setItemName("SlicedBread");
//		SteakSandwich = new ItemFoodMod(SteakSandwichIID, 0, false).setIconCoord(109, 0).setItemName("SteakSandwich");
//		FishSandwich = new ItemFoodMod(FishSandwichIID, 0, false).setIconCoord(109, 0).setItemName("FishSandwich");
//		HamSandwich = new ItemFoodMod(HamSandwichIID, 0, false).setIconCoord(109, 0).setItemName("HamSandwich");
//		Ham = new ItemFoodMod(HamIID, 0, false).setIconCoord(109, 0).setItemName("Ham");
//		SlicedCheese= new ItemFoodMod(SlicedCheeseIID, 0, false).setIconCoord(109, 0).setItemName("SlicedCheese");
//		HamandCheeseSandwich= new ItemFoodMod(HamandCheeseSandwichIID, 0, false).setIconCoord(109, 0).setItemName("HamandCheeseSandwich");
//	 	Honeybun= new ItemFoodMod(HoneybunIID, 0, false).setIconCoord(109, 0).setItemName("Honeybun");
//	 	twinkie= new ItemFoodMod(twinkieIID, 0, false).setIconCoord(109, 0).setItemName("twinkie");
//	 	ChoclateCakeItem= new BlockCakePlacerItem(ChoclateCakeItemIID, ChoclateCake).setIconCoord(109, 0).setItemName("ChoclateCakeItem");
//	 	whitechoclateMilk= new ItemFoodMod(whitechoclateMilkIID, 0, false).setIconCoord(109, 0).setItemName("whitechoclateMilk");
//		ChoclateMilk= new ItemFoodMod(ChoclateMilkIID, 0, false).setIconCoord(109, 0).setItemName("ChoclateMilk").setContainerItem(Item.bucketEmpty);
//		Blueberry= new ItemFoodMod(BlueberryIID, 0, false).setIconCoord(109, 0).setItemName("Blueberry");
//		Raspberry= new ItemFoodMod(RaspberryIID, 0, false).setIconCoord(109, 0).setItemName("Raspberry");
//		blueberrypie= new ItemFoodMod(blueberrypieIID, 0, false).setIconCoord(109, 0).setItemName(" blueberrypie");
//		raspberrypie= new ItemFoodMod(raspberrypieIID, 0, false).setIconCoord(109, 0).setItemName("raspberrypie");
//		applepie= new ItemFoodMod(applepieIID, 0, false).setIconCoord(109, 0).setItemName("applepie");
//		Wizimsurprise= new ItemFoodMod(WizimsurpriseIID, 0, false).setIconCoord(109, 0).setItemName("Wizimsurprise");
//		Fries= new ItemFoodMod(FriesIID, 0, false).setIconCoord(109, 0).setItemName("Fries");
//		MashedPotatoes= new ItemFoodMod(MashedPotatoesIID, 0, false).setIconCoord(109, 0).setItemName("MashedPotatoes");
//		Pancakemix= new ItemFoodMod(PancakemixIID, 0, false).setIconCoord(109, 0).setItemName("Pancakemix");
//		Blueberrypancake = new ItemFoodMod(BlueberrypancakeIID, 0, false).setIconCoord(109, 0).setItemName("Blueberrypancake");
//		FriedEggs= new ItemFoodMod(FriedEggsIID, 0, false).setIconCoord(109, 0).setItemName("FriedEggs").setContainerItem(Item.bowlEmpty);
//		Omlet= new ItemFoodMod(OmletIID, 0, false).setIconCoord(109, 0).setItemName("Omlet").setContainerItem(Item.bowlEmpty);
//		scrambledeggs= new ItemFoodMod(scrambledeggsIID, 0, false).setIconCoord(109, 0).setItemName("scrambledeggs").setContainerItem(Item.bowlEmpty);
//		Pizza= new ItemFoodMod(PizzaIID, 0, false).setIconCoord(109, 0).setItemName("Pizza");
//		PizzaSlice= new ItemFoodMod(PizzaSliceIID, 0, false).setIconCoord(109, 0).setItemName("PizzaSlice");
//		Shishkabob= new ItemFoodMod(ShishkabobIID, 0, false).setIconCoord(109, 0).setItemName("Shishkabob").setContainerItem(Item.stick);
//		Chickenonastick= new ItemFoodMod(ChickenonastickIID, 0, false).setIconCoord(109, 0).setItemName("Chickenonastick").setContainerItem(Item.stick);
//		Noodles= new ItemFoodMod(NoodlesIID, 0, false).setIconCoord(109, 0).setItemName("Noodles");
//		bowlofnoodles = new ItemFoodMod(bowlofnoodlesIID, 0, false).setIconCoord(109, 0).setItemName("bowlofnoodlesNoodles").setContainerItem(Item.bowlEmpty);
		
		
		//Goes Into Reactioncraft Main Tab
		EdibleFlesh= new ItemBasicFood(EdibleFleshIID, 6, true).setIconCoord(175, 0).setItemName("EdibleFlesh").setCreativeTab(RCB.Reactioncraft);
		Knfie = (new ItemBasic(knifeIID)).setIconCoord(123, 0).setItemName("Knfie").setContainerItem(Knfie).setCreativeTab(RCB.Reactioncraft);
		
		//.setContainerItem(bucketEmpty)
		registry();
		langRegistry();
		recipes();
		furnaceRecipes();
		}
	
	 	public void furnaceRecipes() 
		{
//			GameRegistry.addSmelting(uncookedcc.shiftedIndex, new ItemStack(ccItem), 0.5F); 
			GameRegistry.addSmelting(Item.rottenFlesh.itemID, new ItemStack(EdibleFlesh), 0.5F); 
			//GameRegistry.addSmelting(Item.ingotGold.shiftedIndex, new ItemStack(RefinedGIngot), 0.5F); 
		}
	 	
	 	private void recipes() 
	 	{
//	 		GameRegistry.addShapelessRecipe(new ItemStack(SlicedBread, 1), new Object[] {
//	            Item.bread, Knfie
//	             });
//	 		GameRegistry.addShapelessRecipe(new ItemStack(SteakSandwich, 1), new Object[] {
//	            Item.beefRaw, SlicedBread, SlicedBread
//	             });
//	 		GameRegistry.addShapelessRecipe(new ItemStack(RawNuggets, 4), new Object[] {
//	            Item.chickenRaw, Knfie 
//	             });
//	 		GameRegistry.addShapelessRecipe(new ItemStack(BaconRaw, 4), new Object[] {
//	        	Item.porkRaw, Knfie
//	         	});
	 		//GameRegistry.addShapelessRecipe(new ItemStack(Flour, 1), new Object[] {"AAA", "BEB", "CCC", 'A', Item.bucketMilk, 'B', Item.sugar, 'C', Item.wheat, 'E', Item.egg});
	 		//GameRegistry.addRecipe(new ItemStack(carrotcake, 1), new Object[] {"AAA", "BEB", "CCC", 'A', Item.carrot, 'B', Item.sugar, 'C', Item.wheat, 'E', Item.egg});
	 		//CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(uncookedcc, true, new Object[]{Item.carrot, Item.Carrot,}));
	 		//CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(CopperCoin, true, new Object[]{"   ", " X ", "   ", Character.valueOf('X'), "ingotCopper"}));
	 	}


		private void langRegistry() 
	 	{
//			LanguageRegistry.addName(carrotcake, "Carrot Cake");
//	 		LanguageRegistry.addName(ccItem, "Carrot Cake");
//	 		LanguageRegistry.addName(uncookedcc, "Uncooked Carrot Cake");
//			LanguageRegistry.addName(Jellyfishonstick, "Jellyfish on stick");
//			//LanguageRegistry.addName(bowlofeggs, "bowl of eggs");
//			LanguageRegistry.addName(whitechoclatebar, "white chocolate bar");
//			LanguageRegistry.addName(choclatebar, "chocolate bar");
//			LanguageRegistry.addName(darkchoclatebar, "dark chocolate bar");
//	 		LanguageRegistry.addName(choclatebarmould, "chocolate bar mould");
//			LanguageRegistry.addName(Coconutcake, "Coconut cake");
//			LanguageRegistry.addName(Bacon, " Bacon");
//			LanguageRegistry.addName(BaconRaw, "Raw Bacon");
//			LanguageRegistry.addName(ChickenNuggets, "Chicken Nuggets");
//	 		LanguageRegistry.addName(RawNuggets, "Raw Nuggets");
//			LanguageRegistry.addName(SlicedBread, "sliced bread");
//			LanguageRegistry.addName(SteakSandwich, "Uncooked Carrot Cake");
//			LanguageRegistry.addName(FishSandwich, "Uncooked Carrot Cake");
//			LanguageRegistry.addName(HamSandwich, "Uncooked Carrot Cake");
//			LanguageRegistry.addName(Ham, "Carrot Cake");
//	 		LanguageRegistry.addName(SlicedCheese, "Uncooked Carrot Cake");
//			LanguageRegistry.addName(HamandCheeseSandwich, "Uncooked Carrot Cake");
//			LanguageRegistry.addName(Honeybun, "honeybun");
//			LanguageRegistry.addName(twinkie, "twinkie");
//			LanguageRegistry.addName(ChoclateCakeItem, "Chocolate Cake");
//			LanguageRegistry.addName(ccItem, "Carrot Cake");
//	 		LanguageRegistry.addName(uncookedcc, "Uncooked Carrot Cake");
//			LanguageRegistry.addName(uncookedcc, "Uncooked Carrot Cake");
//			LanguageRegistry.addName(uncookedcc, "Uncooked Carrot Cake");
//			LanguageRegistry.addName(uncookedcc, "Uncooked Carrot Cake");
//			LanguageRegistry.addName(uncookedcc, "Uncooked Carrot Cake");
//			LanguageRegistry.addName(ccItem, "Carrot Cake");
//	 		LanguageRegistry.addName(uncookedcc, "Uncooked Carrot Cake");
//			LanguageRegistry.addName(uncookedcc, "Uncooked Carrot Cake");
//			LanguageRegistry.addName(uncookedcc, "Uncooked Carrot Cake");
//			LanguageRegistry.addName(uncookedcc, "Uncooked Carrot Cake");
//			LanguageRegistry.addName(uncookedcc, "Uncooked Carrot Cake");
//			LanguageRegistry.addName(ccItem, "Carrot Cake");
//	 		LanguageRegistry.addName(uncookedcc, "Uncooked Carrot Cake");
//			LanguageRegistry.addName(uncookedcc, "Uncooked Carrot Cake");
//			LanguageRegistry.addName(uncookedcc, "Uncooked Carrot Cake");
//			LanguageRegistry.addName(uncookedcc, "Uncooked Carrot Cake");
//			LanguageRegistry.addName(uncookedcc, "Uncooked Carrot Cake");
//			LanguageRegistry.addName(ccItem, "Carrot Cake");
	 		LanguageRegistry.addName(Knfie, "Knife");
	 		LanguageRegistry.addName(EdibleFlesh, "Edible Flesh");		
	 	}
			

		private void registry() 
	 	{
	 		//GameRegistry.registerBlock(carrotcake);
	 	}


		@PostInit
	 	public void modsLoaded(FMLPostInitializationEvent evt)
	 	{
	 		//new as well! How about that stuff after the mods are loaded/initialized?
	 	}	 
}
