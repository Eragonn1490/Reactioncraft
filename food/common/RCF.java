package Reactioncraft.food.common;

import Reactioncraft.food.common.ClientProxy;
import Reactioncraft.food.common.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.oredict.ShapedOreRecipe;
import Reactioncraft.base.common.RCB;
import Reactioncraft.basic.common.BlockBasicCake;
import Reactioncraft.basic.common.ItemBasic;
import Reactioncraft.basic.common.ItemBasicFood;
import cpw.mods.fml.common.FMLLog;
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

@Mod( modid = "RCF", name="Reactioncraft Food", version="[1.4.7] Reactioncraft Version 7.0")
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
//	public static int SteakSandwichIID;
//	public static int FishSandwichIID;
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
	
	public static int UnwrappedCornIID;
	public static int cookedCornIID;
    public static int popcornseedsIID;
    public static int bagofpopcornIID;
    public static int poppedbagofpopcornIID;
    public static int rawcornIID;
	public static int ChickenNuggetsIID;
	public static int RawNuggetsIID;
	public static int SlicedBreadIID;
	public static int HamSandwichIID;
	
	//Items
//	public static Item Jellyfishonstick;
//	public static Item bowlofeggs;
//	public static Item whitechoclatebar;
//	public static Item choclatebar;
//	public static Item darkchoclatebar;
//	public static Item choclatebarmould;
//	public static Item Coconutcake;
//	public static Item Bacon;
//	public static Item BaconRaw;
//	public static Item SteakSandwich;
//	public static Item FishSandwich;
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
	
	public static Item cookedCorn;
    public static Item popcornseeds;
    public static Item bagofpopcorn;
    public static Item poppedbagofpopcorn;
    public static Item UnwrappedCorn;
	public static Item rawcorn;
	public static Item ChickenNuggets;
	public static Item RawNuggets;
	public static Item SlicedBread;
	public static Item HamSandwich;
	
	 @PreInit
	 public void preInit(FMLPreInitializationEvent evt)
	 {
	 //This is new! put stuff here that you want to happen before the mods are loaded
		 Configuration config = new Configuration(evt.getSuggestedConfigurationFile());

         config.load();
         
         //Block Ids 3061 - 3200
//         carrotcakeID = config.getBlock("Carrot Cake", 3061).getInt();	
//         ChoclateCakeID = config.getBlock("Chocolate Cake", 3062).getInt();
//
         //Claimed Item IDS 10221 - 10800
//         cciIID = config.getItem("Carrot Cake Item", 10221).getInt();
//         uncookedccIID = config.getItem("Uncooked Carrot Cake", 10222).getInt();
//         BaconRawIID = config.getItem("Raw Bacon", 10223).getInt();
//         CakepanIID = config.getItem("Cake Pan", 10224).getInt();
//         CakeMBIID = config.getItem("idk what this is..", 10225).getInt();
//         uncookedbreadIID = config.getItem("Uncooked Bread", 10226).getInt();
//         saltedFishIID = config.getItem("Salted Fish", 10227).getInt();
//         fishonstickIID = config.getItem("Fish on a stick", 10228).getInt();
//         JellyfishIID = config.getItem("Raw Jellyfish", 10229).getInt();
//         JellyfishonstickIID = config.getItem("Jellyfish on a stick", 10230).getInt();
//         bowlofeggsIID = config.getItem("Bowl of eggs", 10231).getInt();
//         OmletIID = config.getItem("Omlet", 10231).getInt();
//         whitechoclatebarIID = config.getItem("White Chocolate Bar", 10232).getInt();
//         choclatebarIID = config.getItem("Chocolate Bar", 10233).getInt();
//         darkchoclatebarIID = config.getItem("Dark Chocolate Bar", 10234).getInt();
//         choclatebarmouldIID = config.getItem("Chocolate bar mould", 10235).getInt();
//         CoconutcakeIID = config.getItem("Coconut Cake", 10236).getInt();
//         BaconIID = config.getItem("Bacon", 10237).getInt();
//         SteakSandwichIID = config.getItem("Steak Sandwich", 10238).getInt();
//         FishSandwichIID = config.getItem("Fish Sandwich", 10239).getInt();
//         HamIID = config.getItem("Ham", 10240).getInt();
//         SlicedCheeseIID = config.getItem("Sliced Cheese", 10241).getInt();
//         HamandCheeseSandwichIID = config.getItem("Ham and Cheese Sandwich", 10242).getInt();
//         HoneybunIID = config.getItem("Honey Bun", 10243).getInt();
//         twinkieIID = config.getItem("Twinkie", 10244).getInt();
//         ChoclateCakeItemIID = config.getItem("Chocolate Cake", 10245).getInt();
//         UncookedChoclateCakeIID = config.getItem("Uncooked Chocolate Cake", 10246).getInt();
//         whitechoclateMilkIID = config.getItem("White Chocolate Milk", 10247).getInt();
//         ChoclateMilkIID = config.getItem("Chocolate Milk", 10248).getInt();
//         BlueberryIID = config.getItem("Blueberry", 10249).getInt();
//         RaspberryIID = config.getItem("Raspberry", 10250).getInt();
//         blueberrypieIID = config.getItem("Blueberry Pie", 10251).getInt();
//         raspberrypieIID = config.getItem("Raspberry Pie", 10252).getInt();
//         applepieIID = config.getItem("Apple Pie", 10253).getInt();
//         WizimsurpriseIID = config.getItem("Wizim Surpise", 10254).getInt();
//         uncookedwizimsurpriseIID = config.getItem("Uncooked Wizim Surprise", 10255).getInt();
//         FriesIID = config.getItem("Fries", 10256).getInt();
//         MashedPotatoesIID = config.getItem("Mashed Potatoes", 10257).getInt();
//         PancakemixIID = config.getItem("Pancake Mix", 10258).getInt();
//         BlueberrypancakeIID = config.getItem("Blueberry pancake", 10259).getInt();
//         FriedEggsIID = config.getItem("Fried Eggs", 10260).getInt();
//         scrambledeggsIID = config.getItem("Scrambled Eggs", 10261).getInt();
//         PizzaIID = config.getItem("Pizza", 10262).getInt();
//         PizzaSliceIID = config.getItem("Pizza Slice", 10263).getInt();
//         ShishkabobIID = config.getItem("Shish-k-bob", 10264).getInt();
//         ChickenonastickIID = config.getItem("Chicken on a stick", 10265).getInt();
//         NoodlesIID = config.getItem("Noodles", 10266).getInt();
//         bowlofnoodlesIID = config.getItem("Bowl of noodles", 10267).getInt();
//         VanillaPlantIID = config.getItem("Vanilla Plant", 10268).getInt();
         knifeIID = config.getItem("Knife", 10269).getInt();
         EdibleFleshIID = config.getItem("Edible Flesh", 10270).getInt();
         
         cookedCornIID = config.getItem("Cooked Corn", 10271).getInt();
         popcornseedsIID = config.getItem("Popcorn Seeds", 10272).getInt();
         bagofpopcornIID = config.getItem("Bag of Popcorn", 10273).getInt();
         poppedbagofpopcornIID = config.getItem("Popped bag of Popcorn", 10274).getInt();
         rawcornIID = config.getItem("Raw Corn", 10275).getInt();
         UnwrappedCornIID = config.getItem("Unwrapped Corn", 10276).getInt();
         RawNuggetsIID = config.getItem("Raw Nuggets", 10278).getInt();
         ChickenNuggetsIID = config.getItem("Chicken Nuggets", 10279).getInt();
         SlicedBreadIID = config.getItem("Sliced Bread", 10280).getInt();
         HamSandwichIID = config.getItem("Ham Sandwich", 10281).getInt();

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
//		SteakSandwich = new ItemFoodMod(SteakSandwichIID, 0, false).setIconCoord(109, 0).setItemName("SteakSandwich");
//		FishSandwich = new ItemFoodMod(FishSandwichIID, 0, false).setIconCoord(109, 0).setItemName("FishSandwich");
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
		
		cookedCorn = new ItemFoodMod(cookedCornIID, 8, false).setIconCoord(243, 0).setItemName("cookedCorn").setCreativeTab(RCB.Reactioncraftfood);
        popcornseeds = new ItemBasic(popcornseedsIID).setIconCoord(247, 0).setItemName("popcornseeds").setCreativeTab(RCB.Reactioncraftfood);
        bagofpopcorn = new ItemBasic(bagofpopcornIID).setIconCoord(246, 0).setItemName("bagofpopcorn").setCreativeTab(RCB.Reactioncraftfood);
        poppedbagofpopcorn = new ItemFoodMod(poppedbagofpopcornIID, 10, true).setIconCoord(245, 0).setItemName("poppedbagofpopcorn").setCreativeTab(RCB.Reactioncraftfood);
        rawcorn = new ItemFoodMod(rawcornIID, 7, false).setIconCoord(243, 0).setItemName("rawcorn").setCreativeTab(RCB.Reactioncraftfood);
        UnwrappedCorn = new ItemFoodMod(UnwrappedCornIID, 6, false).setIconCoord(248, 0).setItemName("UnwrappedCorn").setCreativeTab(RCB.Reactioncraftfood);
        RawNuggets = new ItemFoodMod(RawNuggetsIID, 5, true).setPotionEffect(Potion.hunger.id, 30, 0, 0.8F).setIconCoord(127, 0).setItemName("RawNuggets").setCreativeTab(RCB.Reactioncraftfood);
        ChickenNuggets = new ItemFoodMod(ChickenNuggetsIID, 8, true).setIconCoord(122, 0).setItemName("ChickenNuggets").setCreativeTab(RCB.Reactioncraftfood);
		SlicedBread = new ItemFoodMod(SlicedBreadIID, 4, false).setIconCoord(124, 0).setItemName("SlicedBread").setCreativeTab(RCB.Reactioncraftfood);
		HamSandwich = new ItemFoodMod(HamSandwichIID, 12, false).setIconCoord(213, 0).setItemName("HamSandwich").setCreativeTab(RCB.Reactioncraftfood);
		
		//Goes Into Reactioncraft Main Creative Tab
		EdibleFlesh= new ItemBasicFood(EdibleFleshIID, 6, true).setIconCoord(175, 0).setItemName("EdibleFlesh").setCreativeTab(RCB.Reactioncraft);
		Knfie = (new ItemKnife(knifeIID, EnumToolMaterial.IRON)).setIconCoord(123, 0).setItemName("Knfie").setContainerItem(Knfie).setCreativeTab(RCB.Reactioncraft);
		
		//.setContainerItem(bucketEmpty)
		registry();
		langRegistry();
		recipes();
		furnaceRecipes();
		Handlers();
		}
	
	 	private void Handlers()
	 	{
	 		GameRegistry.registerCraftingHandler(new CraftingHandler());
	 	}


		public void furnaceRecipes() 
		{
      	  //GameRegistry.addSmelting(uncookedcc.shiftedIndex, new ItemStack(ccItem), 0.5F); 
			
			//Rotten Flesh to Edible Flesh
			GameRegistry.addSmelting(Item.rottenFlesh.itemID, new ItemStack(EdibleFlesh), 0.5F); 
			
			//Cooking Chicken Nuggets
			GameRegistry.addSmelting(RCF.RawNuggets.itemID, new ItemStack(RCF.ChickenNuggets), 0.5F);
			
			//Corn Recipes
			GameRegistry.addSmelting(RCF.bagofpopcorn.itemID, new ItemStack(poppedbagofpopcorn), 0.5F);
			GameRegistry.addSmelting(RCF.rawcorn.itemID, new ItemStack(cookedCorn), 0.5F);
		}
	 	
	 	private void recipes() 
	 	{
	 		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(RCF.UnwrappedCorn), true, new Object[]{"   ", " Y ", "   ", Character.valueOf('Y'), "wrappedCorn"}));
	 		
	 		GameRegistry.addShapelessRecipe(new ItemStack(RCF.rawcorn, 1), new Object[]{RCF.UnwrappedCorn});
	 		GameRegistry.addShapelessRecipe(new ItemStack(RCF.popcornseeds, 5), new Object[]{RCF.rawcorn});
	 		GameRegistry.addRecipe(new ItemStack(bagofpopcorn, 1), new Object[] {"AAA", "BBB", "AAA", 'A', Item.paper, 'B', RCF.popcornseeds});
	 		GameRegistry.addShapelessRecipe(new ItemStack(RawNuggets, 5), new Object[] {Item.chickenRaw, new ItemStack(RCF.Knfie,1,-1)});
	 		GameRegistry.addShapelessRecipe(new ItemStack(SlicedBread, 6), new Object[] {Item.bread, new ItemStack(RCF.Knfie,1,-1)});
	 		GameRegistry.addRecipe(new ItemStack(HamSandwich, 1), new Object[] {" A ", " C ", " A ", 'A', RCF.SlicedBread, 'B', Item.porkRaw});
	 		
	 		GameRegistry.addRecipe(new ItemStack(Knfie, 1), new Object[] {"   ", " B ", " A ", 'A', Item.stick, 'B', Item.ingotIron});
	 		
	 		
	 		//not used yet
//	 		GameRegistry.addShapelessRecipe(new ItemStack(SteakSandwich, 1), new Object[] {
//	            Item.beefRaw, SlicedBread, SlicedBread
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
//			LanguageRegistry.addName(SteakSandwich, "Uncooked Carrot Cake");
//			LanguageRegistry.addName(FishSandwich, "Uncooked Carrot Cake");
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
	 		
	 		LanguageRegistry.addName(cookedCorn, "Cooked Corn");
	 		LanguageRegistry.addName(popcornseeds, "Popcorn Kernals");
	 		LanguageRegistry.addName(bagofpopcorn, "Unpopped Bag of Popcorn");
	 		LanguageRegistry.addName(poppedbagofpopcorn, "Bag of Popcorn");
	 		LanguageRegistry.addName(rawcorn, "Uncooked Corn");
	 		LanguageRegistry.addName(UnwrappedCorn, "Corn");
			LanguageRegistry.addName(ChickenNuggets, "Chicken Nuggets");
			LanguageRegistry.addName(RawNuggets, "Raw Nuggets");
			LanguageRegistry.addName(SlicedBread, "sliced bread");
			LanguageRegistry.addName(HamSandwich, "Ham Sandwich");
	 	}
			

		private void registry() 
	 	{
	 		//GameRegistry.registerBlock(carrotcake);
	 	}


		@PostInit
	 	public void modsLoaded(FMLPostInitializationEvent evt)
	 	{
	 		FMLLog.info("Were Cookin Tonight..");
	 	}	 
}
