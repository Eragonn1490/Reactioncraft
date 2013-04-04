package Reactioncraft.Desert.common;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import Reactioncraft.base.common.RCB;
import Reactioncraft.basic.common.*;
import Reactioncraft.core.common.RCC;
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
//import Reactioncraft.ores.common.ClientProxy;
//import Reactioncraft.ores.common.CommonProxy;

@Mod( modid = "RCBDM", name="Reactioncraft Better Desert Mod", version="[1.4.7] Reactioncraft Version 7.0")
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
	public static int Cactus2ID;
	public static int Cactus1ID;
	public static int CherryTreeLeavesID;
	public static int CherrywoodID;
	public static int CherryTreeSaplingID;
	public static int GoldChiselIID;
	public static int FlintChiselIID;
	public static int BloodstoneChiselIID;
	public static int DiamondChiselIID;
	public static int CopperChiselIID;
	public static int UncutLBGemIID; //uncut
	public static int CutLBGemIID; //cut
	public static int UncutDBGemIID; //uncut
	public static int CutDBGemIID; //cut
	public static int BloodstoneBrickID;
	public static int SandStonePasteIID;
	//public static int CarvedDarkStoneWallID;
	
	//public static Block CarvedDarkStoneWall;
	public static Block DarkSand;
	public static Block DarkSandstone;
	public static Block HireoMulti;
	public static Block DesertMulti;
	public static Block ColumnMulti;
	public static Block DesertBlockMulti;
	public static Block Cactus1;
	public static Block Cactus2;
	public static Block CherryTreeLeaves;
	public static Block Cherrywood;
	public static Block CherryTreeSapling;
	public static Block BloodstoneBrick;
	
	public static Item GoldChisel;
	public static Item FlintChisel;
	public static Item DiamondChisel;
	public static Item BloodstoneChisel;
	public static Item CopperChisel;
	public static Item UncutLBGem; //uncut
	public static Item CutLBGem; //cut
	public static Item UncutDBGem; //uncut
	public static Item CutDBGem; //cut
	public static Item SandStonePaste;
	
	//Biomes
	public static BiomeGenBase RcDesert;
	
	@PreInit
	 public void preInit(FMLPreInitializationEvent evt)
	 {		
		Configuration config = new Configuration(evt.getSuggestedConfigurationFile());

		MinecraftForge.EVENT_BUS.register(new RCCBonemealProvider());
		
        config.load();
        
        //3027 - 3040
        CherrywoodID = config.getBlock("Cherry Tree Wood", 3027).getInt();
        CherryTreeLeavesID = config.getBlock("Cherry Tree Leaves", 3028).getInt();
        CherryTreeSaplingID = config.getBlock("Cherry Tree Sapling", 3029).getInt();
        DarkSandID = config.getBlock("Dark Sand", 240).getInt();
        HireoBlocksIID = config.getBlock("Hireoglyphics", 3030).getInt();
        DesertBlocksIID = config.getBlock("Dark Sandstone Blocks", 3031).getInt();
        ColumnBlockID = config.getBlock("Column Blocks", 3032).getInt();
        DesertBlockMultiID = config.getBlock("Desert Blocks", 3033).getInt();
        BloodstoneBrickID = config.getBlock("Bloodstone Brick", 3034).getInt();
        Cactus1ID = config.getBlock("Cactus Block 1", 3035).getInt();
        Cactus2ID = config.getBlock("Cactus Block 2", 3036).getInt();
        //CarvedDarkStoneWallID = config.getBlock("Darkstone Wall", 3037).getInt();
        
        //Items... 10121 - 10220
        FlintChiselIID = config.getItem("Flint Chisel", 10121).getInt();
        GoldChiselIID = config.getItem("Gold Chisel", 10122).getInt();
        DiamondChiselIID = config.getItem("Diamond Chisel", 10123).getInt();
        BloodstoneChiselIID = config.getItem("Bloodstone Chisel", 10124).getInt();
        CopperChiselIID = config.getItem("Copper Chisel", 10125).getInt();
        UncutLBGemIID = config.getItem("Uncut Light Blue Gem", 10126).getInt();
        CutLBGemIID = config.getItem("Cut Light Blue Gem", 10127).getInt();
        UncutDBGemIID = config.getItem("Uncut Dark Blue Gem", 10128).getInt();
        CutDBGemIID = config.getItem("Cut Dark Blue Gem", 10129).getInt();
        SandStonePasteIID = config.getItem("Sandstone Paste", 10130).getInt();
        
        config.save();
	 }
	
	@Init
	 public void load(FMLInitializationEvent event)
	 {
		blockCode();
		registerBlocks();
		itemCode();
		registerHandlers();
		addNames();
		oreDictionary();
		HarvestLevel();
		addSmelting();
		addRecipes();
		setHarvestinglevel();
		initBiomes();
		addBiomes(); 
	 }
	
		
	
	public void setHarvestinglevel() 
	{
		MinecraftForge.setBlockHarvestLevel(RCBDM.DesertBlockMulti, 0,   "pickaxe", 0);
		MinecraftForge.setBlockHarvestLevel(RCBDM.DesertBlockMulti, 1,   "pickaxe", 0);
		MinecraftForge.setBlockHarvestLevel(RCBDM.DesertBlockMulti, 2,   "pickaxe", 0);
		MinecraftForge.setBlockHarvestLevel(RCBDM.DesertBlockMulti, 3,   "pickaxe", 0);
		MinecraftForge.setBlockHarvestLevel(RCBDM.DesertBlockMulti, 4,   "pickaxe", 0);
		MinecraftForge.setBlockHarvestLevel(RCBDM.DesertBlockMulti, 5,   "pickaxe", 0);
	}

	public void addSmelting() 
	{
		 GameRegistry.addSmelting(RCBDM.DarkSand.blockID, new ItemStack(Block.glass.blockID, 1, 1), 0.5F);
		 GameRegistry.addSmelting(RCBDM.SandStonePaste.itemID, new ItemStack(RCBDM.DesertBlockMulti.blockID, 1, 2), 0.5F);
	}

	public void HarvestLevel() 
	{
		MinecraftForge.setBlockHarvestLevel(RCBDM.DarkSand,     "shovel", 1);
	}

	public void initBiomes() 
	{
		RcDesert = (new BiomeGenRcDesert(30)).setBiomeName("Darksand Desert").setDisableRain().setMinMaxHeight(0.1F, 0.2F).setColor(230609);
	}

	public void oreDictionary() 
	{
		OreDictionary.registerOre("BloodstoneBrick", new ItemStack(RCBDM.BloodstoneBrick));
	}
	
	public void addRecipes() 
	 {
		
		/**chisel Recipes**/
		//Flint
		GameRegistry.addRecipe(new ItemStack(FlintChisel, 1), new Object[]{"   ", " G ", " I ", Character.valueOf('G'), Item.flint, Character.valueOf('I'), Item.stick});
		//Copper
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(CopperChisel, true, new Object[]{"   ", " I ", " X ", Character.valueOf('I'), "ingotCopper", Character.valueOf('X'), Item.stick}));
		//Gold
		GameRegistry.addRecipe(new ItemStack(GoldChisel, 1), new Object[]{"   ", " G ", " I ", Character.valueOf('G'), Item.ingotGold, Character.valueOf('I'), Item.stick});
		//Diamond
		GameRegistry.addRecipe(new ItemStack(DiamondChisel, 1), new Object[]{"   ", " G ", " I ", Character.valueOf('G'), Item.diamond, Character.valueOf('I'), Item.stick});
		//Bloodstone
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(BloodstoneChisel, true, new Object[]{"   ", " I ", " X ", Character.valueOf('I'), "ingotBloodstone", Character.valueOf('X'), Item.stick}));


		/**Bloodstone brick recipe**/
		CraftingManager.getInstance().getRecipeList().add(new ShapelessOreRecipe(new ItemStack(RCBDM.BloodstoneBrick,4,4), new Object[]{"oreBloodstone", "oreBloodstone", "oreBloodstone", "oreBloodstone"}));

		/**Chisels Cutting the Gems into Cut form.**/
		GameRegistry.addShapelessRecipe(new ItemStack(RCBDM.CutLBGem,1,1), new Object[]{RCBDM.UncutLBGem, new ItemStack(RCBDM.FlintChisel,1,-1)});
		GameRegistry.addShapelessRecipe(new ItemStack(RCBDM.CutLBGem,1,1), new Object[]{RCBDM.UncutLBGem, new ItemStack(RCBDM.GoldChisel,1,-1)});
		GameRegistry.addShapelessRecipe(new ItemStack(RCBDM.CutLBGem,1,1), new Object[]{RCBDM.UncutLBGem, new ItemStack(RCBDM.CopperChisel,1,-1)});
		GameRegistry.addShapelessRecipe(new ItemStack(RCBDM.CutLBGem,1,1), new Object[]{RCBDM.UncutLBGem, new ItemStack(RCBDM.DiamondChisel,1,-1)});
		GameRegistry.addShapelessRecipe(new ItemStack(RCBDM.CutLBGem,1,1), new Object[]{RCBDM.UncutLBGem, new ItemStack(RCBDM.BloodstoneChisel,1,-1)});

		GameRegistry.addShapelessRecipe(new ItemStack(RCBDM.CutDBGem,1,1), RCBDM.UncutDBGem, new ItemStack(RCBDM.FlintChisel,1,-1));
		GameRegistry.addShapelessRecipe(new ItemStack(RCBDM.CutDBGem,1,1), RCBDM.UncutDBGem, new ItemStack(RCBDM.GoldChisel,1,-1));
		GameRegistry.addShapelessRecipe(new ItemStack(RCBDM.CutDBGem,1,1), RCBDM.UncutDBGem, new ItemStack(RCBDM.CopperChisel,1,-1));
		GameRegistry.addShapelessRecipe(new ItemStack(RCBDM.CutDBGem,1,1), RCBDM.UncutDBGem, new ItemStack(RCBDM.DiamondChisel,1,-1));
		GameRegistry.addShapelessRecipe(new ItemStack(RCBDM.CutDBGem,1,1), RCBDM.UncutDBGem, new ItemStack(RCBDM.BloodstoneChisel,1,-1));

		//Chisels Cutting Columns

		//Dark Sandstone Column
		GameRegistry.addRecipe(new ItemStack(ColumnMulti, 1, 0), new Object[]{"X  ","XY ", "X  ", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 3), Character.valueOf('Y'), new ItemStack(RCBDM.FlintChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(ColumnMulti, 1, 0), new Object[]{"X  ","XY ", "X  ", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 3), Character.valueOf('Y'), new ItemStack(RCBDM.GoldChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(ColumnMulti, 1, 0), new Object[]{"X  ","XY ", "X  ", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 3), Character.valueOf('Y'), new ItemStack(RCBDM.CopperChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(ColumnMulti, 1, 0), new Object[]{"X  ","XY ", "X  ", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 3), Character.valueOf('Y'), new ItemStack(RCBDM.DiamondChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(ColumnMulti, 1, 0), new Object[]{"X  ","XY ", "X  ", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 3), Character.valueOf('Y'), new ItemStack(RCBDM.BloodstoneChisel,1,-1)});

		//stone Column
		GameRegistry.addRecipe(new ItemStack(ColumnMulti, 1, 3), new Object[]{"X  ","XY ", "X  ", Character.valueOf('X'), Block.stone, Character.valueOf('Y'), new ItemStack(RCBDM.FlintChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(ColumnMulti, 1, 3), new Object[]{"X  ","XY ", "X  ", Character.valueOf('X'), Block.stone, Character.valueOf('Y'), new ItemStack(RCBDM.GoldChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(ColumnMulti, 1, 3), new Object[]{"X  ","XY ", "X  ", Character.valueOf('X'), Block.stone, Character.valueOf('Y'), new ItemStack(RCBDM.CopperChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(ColumnMulti, 1, 3), new Object[]{"X  ","XY ", "X  ", Character.valueOf('X'), Block.stone, Character.valueOf('Y'), new ItemStack(RCBDM.DiamondChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(ColumnMulti, 1, 3), new Object[]{"X  ","XY ", "X  ", Character.valueOf('X'), Block.stone, Character.valueOf('Y'), new ItemStack(RCBDM.BloodstoneChisel,1,-1)});

		//Cobblestone Column
		GameRegistry.addRecipe(new ItemStack(ColumnMulti, 1, 4), new Object[]{"X  ","XY ", "X  ", Character.valueOf('X'), Block.cobblestone, Character.valueOf('Y'), new ItemStack(RCBDM.FlintChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(ColumnMulti, 1, 4), new Object[]{"X  ","XY ", "X  ", Character.valueOf('X'), Block.cobblestone, Character.valueOf('Y'), new ItemStack(RCBDM.GoldChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(ColumnMulti, 1, 4), new Object[]{"X  ","XY ", "X  ", Character.valueOf('X'), Block.cobblestone, Character.valueOf('Y'), new ItemStack(RCBDM.CopperChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(ColumnMulti, 1, 4), new Object[]{"X  ","XY ", "X  ", Character.valueOf('X'), Block.cobblestone, Character.valueOf('Y'), new ItemStack(RCBDM.DiamondChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(ColumnMulti, 1, 4), new Object[]{"X  ","XY ", "X  ", Character.valueOf('X'), Block.cobblestone, Character.valueOf('Y'), new ItemStack(RCBDM.BloodstoneChisel,1,-1)});


		//Gold Column
		GameRegistry.addRecipe(new ItemStack(ColumnMulti, 1, 5), new Object[]{"X  ","XY ", "X  ", Character.valueOf('X'), Block.blockGold, Character.valueOf('Y'), new ItemStack(RCBDM.CopperChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(ColumnMulti, 1, 5), new Object[]{"X  ","XY ", "X  ", Character.valueOf('X'), Block.blockGold, Character.valueOf('Y'), new ItemStack(RCBDM.DiamondChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(ColumnMulti, 1, 5), new Object[]{"X  ","XY ", "X  ", Character.valueOf('X'), Block.blockGold, Character.valueOf('Y'), new ItemStack(RCBDM.BloodstoneChisel,1,-1)});

		//Diamond Column
		GameRegistry.addRecipe(new ItemStack(ColumnMulti, 1, 6), new Object[]{"X  ","XY ", "X  ", Character.valueOf('X'), Block.blockDiamond, Character.valueOf('Y'), new ItemStack(RCBDM.DiamondChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(ColumnMulti, 1, 6), new Object[]{"X  ","XY ", "X  ", Character.valueOf('X'), Block.blockDiamond, Character.valueOf('Y'), new ItemStack(RCBDM.BloodstoneChisel,1,-1)});

		//Stone Brick Column
		GameRegistry.addRecipe(new ItemStack(ColumnMulti, 1, 7), new Object[]{"X  ","XY ", "X  ", Character.valueOf('X'), Block.stoneBrick, Character.valueOf('Y'), new ItemStack(RCBDM.FlintChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(ColumnMulti, 1, 7), new Object[]{"X  ","XY ", "X  ", Character.valueOf('X'), Block.stoneBrick, Character.valueOf('Y'), new ItemStack(RCBDM.GoldChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(ColumnMulti, 1, 7), new Object[]{"X  ","XY ", "X  ", Character.valueOf('X'), Block.stoneBrick, Character.valueOf('Y'), new ItemStack(RCBDM.CopperChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(ColumnMulti, 1, 7), new Object[]{"X  ","XY ", "X  ", Character.valueOf('X'), Block.stoneBrick, Character.valueOf('Y'), new ItemStack(RCBDM.DiamondChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(ColumnMulti, 1, 7), new Object[]{"X  ","XY ", "X  ", Character.valueOf('X'), Block.stoneBrick, Character.valueOf('Y'), new ItemStack(RCBDM.BloodstoneChisel,1,-1)});

		//Bloodstone Column (Requires RCC (RCC is being renamed or repurposed...))
		GameRegistry.addRecipe(new ItemStack(ColumnMulti, 1, 2), new Object[]{"X  ","XY ", "X  ", Character.valueOf('X'), RCBDM.BloodstoneBrick, Character.valueOf('Y'), new ItemStack(RCBDM.BloodstoneChisel,1,-1)});

		//DarkSand Clay
		GameRegistry.addShapelessRecipe(new ItemStack(RCBDM.SandStonePaste, 2,2), RCBDM.DarkSand, Item.bucketWater);

		//Carved Dark Sandstone
		GameRegistry.addRecipe(new ItemStack(DesertBlockMulti, 1, 0), new Object[]{"   ","XY ", "   ", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 2), Character.valueOf('Y'), new ItemStack(RCBDM.FlintChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(DesertBlockMulti, 1, 0), new Object[]{"   ","XY ", "   ", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 2), Character.valueOf('Y'), new ItemStack(RCBDM.GoldChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(DesertBlockMulti, 1, 0), new Object[]{"   ","XY ", "   ", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 2), Character.valueOf('Y'), new ItemStack(RCBDM.CopperChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(DesertBlockMulti, 1, 0), new Object[]{"   ","XY ", "   ", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 2), Character.valueOf('Y'), new ItemStack(RCBDM.DiamondChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(DesertBlockMulti, 1, 0), new Object[]{"   ","XY ", "   ", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 2), Character.valueOf('Y'), new ItemStack(RCBDM.BloodstoneChisel,1,-1)});

		//Cracked Dark Sandstone to Carved Dark Sandstone
		GameRegistry.addShapelessRecipe(new ItemStack(DesertBlockMulti, 1, 0), new ItemStack(DesertBlockMulti, 1, 1), new ItemStack(RCBDM.FlintChisel,1,-1));
		GameRegistry.addShapelessRecipe(new ItemStack(DesertBlockMulti, 1, 0), new ItemStack(DesertBlockMulti, 1, 1), new ItemStack(RCBDM.GoldChisel,1,-1));
		GameRegistry.addShapelessRecipe(new ItemStack(DesertBlockMulti, 1, 0), new ItemStack(DesertBlockMulti, 1, 1), new ItemStack(RCBDM.CopperChisel,1,-1));
		GameRegistry.addShapelessRecipe(new ItemStack(DesertBlockMulti, 1, 0), new ItemStack(DesertBlockMulti, 1, 1), new ItemStack(RCBDM.DiamondChisel,1,-1));
		GameRegistry.addShapelessRecipe(new ItemStack(DesertBlockMulti, 1, 0), new ItemStack(DesertBlockMulti, 1, 1), new ItemStack(RCBDM.BloodstoneChisel,1,-1));

		//Dark Sandstone Brick
		GameRegistry.addRecipe(new ItemStack(DesertBlockMulti, 1, 3), new Object[]{"XX ","XX ", "   ", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 0)});

		//Multi Colored Sandstone Brick
		GameRegistry.addRecipe(new ItemStack(DesertBlockMulti, 2, 5), new Object[]{"XYX","YXY", "XYX", Character.valueOf('Y'), new ItemStack(DesertBlockMulti, 1, 3), Character.valueOf('X'), new ItemStack(RCBDM.SandStonePaste)});

		/**
        LanguageRegistry.addName(new ItemStack(ColumnMulti, 1, 1), "Marble Column");
		 **/


		//Cracked Darkstone Brick to Darkstone Brick
		GameRegistry.addRecipe(new ItemStack(DesertBlockMulti, 1, 3), new Object[]{" Y "," X ", "   ", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 4), Character.valueOf('Y'), new ItemStack(RCBDM.FlintChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(DesertBlockMulti, 1, 3), new Object[]{" Y "," X ", "   ", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 4), Character.valueOf('Y'), new ItemStack(RCBDM.GoldChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(DesertBlockMulti, 1, 3), new Object[]{" Y "," X ", "   ", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 4), Character.valueOf('Y'), new ItemStack(RCBDM.CopperChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(DesertBlockMulti, 1, 3), new Object[]{" Y "," X ", "   ", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 4), Character.valueOf('Y'), new ItemStack(RCBDM.DiamondChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(DesertBlockMulti, 1, 3), new Object[]{" Y "," X ", "   ", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 4), Character.valueOf('Y'), new ItemStack(RCBDM.BloodstoneChisel,1,-1)});


		//Weather Hireoglyphics to Carved Dark Stone
		GameRegistry.addShapelessRecipe(new ItemStack(DesertBlockMulti, 1, 0), new ItemStack(HireoMulti, 1, 11), new ItemStack(RCBDM.FlintChisel,1,-1));
		GameRegistry.addShapelessRecipe(new ItemStack(DesertBlockMulti, 1, 0), new ItemStack(HireoMulti, 1, 11), new ItemStack(RCBDM.GoldChisel,1,-1));
		GameRegistry.addShapelessRecipe(new ItemStack(DesertBlockMulti, 1, 0), new ItemStack(HireoMulti, 1, 11), new ItemStack(RCBDM.CopperChisel,1,-1));
		GameRegistry.addShapelessRecipe(new ItemStack(DesertBlockMulti, 1, 0), new ItemStack(HireoMulti, 1, 11), new ItemStack(RCBDM.DiamondChisel,1,-1));
		GameRegistry.addShapelessRecipe(new ItemStack(DesertBlockMulti, 1, 0), new ItemStack(HireoMulti, 1, 11), new ItemStack(RCBDM.BloodstoneChisel,1,-1));


		/** Regular Hireoglyphics **/
		//Flint Chisel
		GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 0), new Object[]{"YYY", " X ", "   ", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 0), Character.valueOf('Y'), new ItemStack(RCBDM.FlintChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 1), new Object[]{"YYY", "YX ", "   ", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 0), Character.valueOf('Y'), new ItemStack(RCBDM.FlintChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 2), new Object[]{"YYY", "YXY", "   ", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 0), Character.valueOf('Y'), new ItemStack(RCBDM.FlintChisel,1,-1)});
		//Copper Chisel
		GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 0), new Object[]{"YYY", " X ", "   ", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 0), Character.valueOf('Y'), new ItemStack(RCBDM.CopperChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 1), new Object[]{"YYY", "YX ", "   ", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 0), Character.valueOf('Y'), new ItemStack(RCBDM.CopperChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 2), new Object[]{"YYY", "YXY", "   ", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 0), Character.valueOf('Y'), new ItemStack(RCBDM.CopperChisel,1,-1)});
		//Gold Chisel
		GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 0), new Object[]{"YYY", " X ", "   ", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 0), Character.valueOf('Y'), new ItemStack(RCBDM.GoldChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 1), new Object[]{"YYY", "YX ", "   ", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 0), Character.valueOf('Y'), new ItemStack(RCBDM.GoldChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 2), new Object[]{"YYY", "YXY", "   ", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 0), Character.valueOf('Y'), new ItemStack(RCBDM.GoldChisel,1,-1)});
		//Diamond Chisel
		GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 0), new Object[]{"YYY", " X ", "   ", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 0), Character.valueOf('Y'), new ItemStack(RCBDM.DiamondChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 1), new Object[]{"YYY", "YX ", "   ", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 0), Character.valueOf('Y'), new ItemStack(RCBDM.DiamondChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 2), new Object[]{"YYY", "YXY", "   ", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 0), Character.valueOf('Y'), new ItemStack(RCBDM.DiamondChisel,1,-1)});
		//Bloodstone Chisel
		GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 0), new Object[]{"YYY", " X ", "   ", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 0), Character.valueOf('Y'), new ItemStack(RCBDM.BloodstoneChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 1), new Object[]{"YYY", "YX ", "   ", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 0), Character.valueOf('Y'), new ItemStack(RCBDM.BloodstoneChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 2), new Object[]{"YYY", "YXY", "   ", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 0), Character.valueOf('Y'), new ItemStack(RCBDM.BloodstoneChisel,1,-1)});
		
		/** Lightblue Hireoglyphics **/
		//Flint
		GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 3), new Object[]{"YYY", " X ", " @ ", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 0), Character.valueOf('@'), CutLBGem, Character.valueOf('Y'), new ItemStack(RCBDM.FlintChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 4), new Object[]{"YYY", "YX ", "Y@ ", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 0), Character.valueOf('@'), CutLBGem, Character.valueOf('Y'), new ItemStack(RCBDM.FlintChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 5), new Object[]{"YYY", "YXY", "Y@Y", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 0), Character.valueOf('@'), CutLBGem, Character.valueOf('Y'), new ItemStack(RCBDM.FlintChisel,1,-1)});
		//Copper
		GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 3), new Object[]{"YYY", " X ", " @ ", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 0), Character.valueOf('@'), CutLBGem, Character.valueOf('Y'), new ItemStack(RCBDM.CopperChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 4), new Object[]{"YYY", "YX ", "Y@ ", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 0), Character.valueOf('@'), CutLBGem, Character.valueOf('Y'), new ItemStack(RCBDM.CopperChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 5), new Object[]{"YYY", "YXY", "Y@Y", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 0), Character.valueOf('@'), CutLBGem, Character.valueOf('Y'), new ItemStack(RCBDM.CopperChisel,1,-1)});
		//Gold
		GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 3), new Object[]{"YYY", " X ", " @ ", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 0), Character.valueOf('@'), CutLBGem, Character.valueOf('Y'), new ItemStack(RCBDM.GoldChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 4), new Object[]{"YYY", "YX ", "Y@ ", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 0), Character.valueOf('@'), CutLBGem, Character.valueOf('Y'), new ItemStack(RCBDM.GoldChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 5), new Object[]{"YYY", "YXY", "Y@Y", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 0), Character.valueOf('@'), CutLBGem, Character.valueOf('Y'), new ItemStack(RCBDM.GoldChisel,1,-1)});
		//Diamond Based Lightblue Hireoglyphics
		GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 3), new Object[]{"YYY", " X ", " @ ", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 0), Character.valueOf('@'), CutLBGem, Character.valueOf('Y'), new ItemStack(RCBDM.DiamondChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 4), new Object[]{"YYY", "YX ", "Y@ ", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 0), Character.valueOf('@'), CutLBGem, Character.valueOf('Y'), new ItemStack(RCBDM.DiamondChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 5), new Object[]{"YYY", "YXY", "Y@Y", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 0), Character.valueOf('@'), CutLBGem, Character.valueOf('Y'), new ItemStack(RCBDM.DiamondChisel,1,-1)});
		//Bloodstone Based Lightblue Hireoglyphics
		GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 3), new Object[]{"YYY", " X ", " @ ", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 0), Character.valueOf('@'), CutLBGem, Character.valueOf('Y'), new ItemStack(RCBDM.BloodstoneChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 4), new Object[]{"YYY", "YX ", "Y@ ", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 0), Character.valueOf('@'), CutLBGem, Character.valueOf('Y'), new ItemStack(RCBDM.BloodstoneChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 5), new Object[]{"YYY", "YXY", "Y@Y", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 0), Character.valueOf('@'), CutLBGem, Character.valueOf('Y'), new ItemStack(RCBDM.BloodstoneChisel,1,-1)});

		/** Darkblue Hireoglyphics **/
		//Flint
		GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 6), new Object[]{"YYY", " X ", " @ ", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 0), Character.valueOf('@'), CutDBGem, Character.valueOf('Y'), new ItemStack(RCBDM.FlintChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 7), new Object[]{"YYY", "YX ", "Y@ ", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 0), Character.valueOf('@'), CutDBGem, Character.valueOf('Y'), new ItemStack(RCBDM.FlintChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 8), new Object[]{"YYY", "YXY", "Y@Y", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 0), Character.valueOf('@'), CutDBGem, Character.valueOf('Y'), new ItemStack(RCBDM.FlintChisel,1,-1)});
		//Copper 
		GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 6), new Object[]{"YYY", " X ", " @ ", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 0), Character.valueOf('@'), CutDBGem, Character.valueOf('Y'), new ItemStack(RCBDM.CopperChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 7), new Object[]{"YYY", "YX ", "Y@ ", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 0), Character.valueOf('@'), CutDBGem, Character.valueOf('Y'), new ItemStack(RCBDM.CopperChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 8), new Object[]{"YYY", "YXY", "Y@Y", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 0), Character.valueOf('@'), CutDBGem, Character.valueOf('Y'), new ItemStack(RCBDM.CopperChisel,1,-1)});
		//Gold
		GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 6), new Object[]{"YYY", " X ", " @ ", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 0), Character.valueOf('@'), CutDBGem, Character.valueOf('Y'), new ItemStack(RCBDM.GoldChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 7), new Object[]{"YYY", "YX ", "Y@ ", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 0), Character.valueOf('@'), CutDBGem, Character.valueOf('Y'), new ItemStack(RCBDM.GoldChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 8), new Object[]{"YYY", "YXY", "Y@Y", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 0), Character.valueOf('@'), CutDBGem, Character.valueOf('Y'), new ItemStack(RCBDM.GoldChisel,1,-1)});
		//Diamond
		GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 6), new Object[]{"YYY", " X ", " @ ", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 0), Character.valueOf('@'), CutDBGem, Character.valueOf('Y'), new ItemStack(RCBDM.DiamondChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 7), new Object[]{"YYY", "YX ", "Y@ ", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 0), Character.valueOf('@'), CutDBGem, Character.valueOf('Y'), new ItemStack(RCBDM.DiamondChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 8), new Object[]{"YYY", "YXY", "Y@Y", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 0), Character.valueOf('@'), CutDBGem, Character.valueOf('Y'), new ItemStack(RCBDM.DiamondChisel,1,-1)});
		//Bloodstone Based Darkblue Hireoglyphics
		GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 6), new Object[]{"YYY", " X ", " @ ", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 0), Character.valueOf('@'), CutDBGem, Character.valueOf('Y'), new ItemStack(RCBDM.BloodstoneChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 7), new Object[]{"YYY", "YX ", "Y@ ", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 0), Character.valueOf('@'), CutDBGem, Character.valueOf('Y'), new ItemStack(RCBDM.BloodstoneChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 8), new Object[]{"YYY", "YXY", "Y@Y", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 0), Character.valueOf('@'), CutDBGem, Character.valueOf('Y'), new ItemStack(RCBDM.BloodstoneChisel,1,-1)});

		/** Gold Hireoglyphics **/
		GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 13), new Object[]{"YYY", " X ", " @ ", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 0), Character.valueOf('@'), Item.ingotGold, Character.valueOf('Y'), new ItemStack(RCBDM.FlintChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 14), new Object[]{"YYY", "YX ", "Y@ ", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 0), Character.valueOf('@'), Item.ingotGold, Character.valueOf('Y'), new ItemStack(RCBDM.FlintChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 15), new Object[]{"YYY", "YXY", "Y@Y", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 0), Character.valueOf('@'), Item.ingotGold, Character.valueOf('Y'), new ItemStack(RCBDM.FlintChisel,1,-1)});
		//Copper Based DarkBlue Hireoglyphics
		GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 13), new Object[]{"YYY", " X ", " @ ", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 0), Character.valueOf('@'), Item.ingotGold, Character.valueOf('Y'), new ItemStack(RCBDM.CopperChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 14), new Object[]{"YYY", "YX ", "Y@ ", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 0), Character.valueOf('@'), Item.ingotGold, Character.valueOf('Y'), new ItemStack(RCBDM.CopperChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 15), new Object[]{"YYY", "YXY", "Y@Y", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 0), Character.valueOf('@'), Item.ingotGold, Character.valueOf('Y'), new ItemStack(RCBDM.CopperChisel,1,-1)});
		//gold Based Darkblue Hireoglyphics
		GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 13), new Object[]{"YYY", " X ", " @ ", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 0), Character.valueOf('@'), Item.ingotGold, Character.valueOf('Y'), new ItemStack(RCBDM.GoldChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 14), new Object[]{"YYY", "YX ", "Y@ ", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 0), Character.valueOf('@'), Item.ingotGold, Character.valueOf('Y'), new ItemStack(RCBDM.GoldChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 15), new Object[]{"YYY", "YXY", "Y@Y", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 0), Character.valueOf('@'), Item.ingotGold, Character.valueOf('Y'), new ItemStack(RCBDM.GoldChisel,1,-1)});
		//Diamond Based Darkblue Hireoglyphics
		GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 13), new Object[]{"YYY", " X ", " @ ", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 0), Character.valueOf('@'), Item.ingotGold, Character.valueOf('Y'), new ItemStack(RCBDM.DiamondChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 14), new Object[]{"YYY", "YX ", "Y@ ", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 0), Character.valueOf('@'), Item.ingotGold, Character.valueOf('Y'), new ItemStack(RCBDM.DiamondChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 15), new Object[]{"YYY", "YXY", "Y@Y", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 0), Character.valueOf('@'), Item.ingotGold, Character.valueOf('Y'), new ItemStack(RCBDM.DiamondChisel,1,-1)});
		//Bloodstone Based Darkblue Hireoglyphics
		GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 13), new Object[]{"YYY", " X ", " @ ", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 0), Character.valueOf('@'), Item.ingotGold, Character.valueOf('Y'), new ItemStack(RCBDM.BloodstoneChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 14), new Object[]{"YYY", "YX ", "Y@ ", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 0), Character.valueOf('@'), Item.ingotGold, Character.valueOf('Y'), new ItemStack(RCBDM.BloodstoneChisel,1,-1)});
		GameRegistry.addRecipe(new ItemStack(HireoMulti, 1, 15), new Object[]{"YYY", "YXY", "Y@Y", Character.valueOf('X'), new ItemStack(DesertBlockMulti, 1, 0), Character.valueOf('@'), Item.ingotGold, Character.valueOf('Y'), new ItemStack(RCBDM.BloodstoneChisel,1,-1)});
	 }

	public void itemCode() 
	 {
		 FlintChisel =      (new ItemChisel(FlintChiselIID).setIconCoord(110, 0).setItemName("Flintchisel"));
         GoldChisel =       (new ItemChisel2(GoldChiselIID)).setIconCoord(113, 0).setItemName("Goldchisel");
         CopperChisel =     (new ItemChisel3(CopperChiselIID).setIconCoord(168,0).setItemName("Copperchisel"));
         DiamondChisel =    (new ItemChisel4(DiamondChiselIID)).setIconCoord(170, 0).setItemName("Diamondchisel");
         BloodstoneChisel = (new ItemChisel5(BloodstoneChiselIID)).setIconCoord(169, 0).setItemName("Bloodstonechisel");
         UncutLBGem = (new ItemBasic(UncutLBGemIID)).setIconCoord(131, 0).setItemName("UncutLBGem");
         CutLBGem = (new ItemBasic(CutLBGemIID)).setIconCoord(130, 0).setItemName("CutLBGem");
         UncutDBGem = (new ItemBasic(UncutDBGemIID)).setIconCoord(132, 0).setItemName("UncutDBGem");
         CutDBGem = (new ItemBasic(CutDBGemIID)).setIconCoord(129, 0).setItemName("CutDBGem");
         SandStonePaste = (new ItemBasic(SandStonePasteIID)).setIconCoord(119, 0).setItemName("SandStonePaste");
   	 }

	public void blockCode() 
	{
		//CarvedDarkStoneWall = new BlockWall(CarvedDarkStoneWallID).setHardness(1.0F).setResistance(1.0F).setBlockName("CarvedDarkStoneWall");
		BloodstoneBrick = new BlockBasic(BloodstoneBrickID, 84).setHardness(120.0F).setResistance(2000.0F).setLightValue(0.10F).setStepSound(Block.soundStoneFootstep).setBlockName("BloodstoneBrick").setCreativeTab(RCB.Reactioncraft);
		Cherrywood = new BlockCherryTreeLog(CherrywoodID, 244).setHardness(0.2F).setResistance(0.5F).setBlockName("Cherrywood");
		CherryTreeLeaves = new BlockCherryTreeLeaves(CherryTreeLeavesID, 43).setHardness(0.2F).setResistance(0.5F).setBlockName("CherryTreeLeaves");
		CherryTreeSapling = new BlockCherryTreeSapling(CherryTreeSaplingID, 44).setHardness(0.2F).setResistance(0.5F).setBlockName("CherryTreeSapling");
		DarkSand = new BlockSandRc(DarkSandID, 136).setHardness(0.5F).setResistance(5.0F).setStepSound(Block.soundSandFootstep).setBlockName("DarkSand");
		HireoMulti = new BlockHireoMulti(HireoBlocksIID, Material.rock).setHardness(3.0F).setBlockName("HireoMulti");
		ColumnMulti = new BlockColumnMulti(ColumnBlockID, Material.rock).setHardness(3.0F).setBlockName("ColumnMulti");
		DesertBlockMulti = new BlockDesertMulti(DesertBlockMultiID, Material.rock).setHardness(3.0F).setBlockName("DesertBlockMulti");
		Cactus1 = (new DesertFlower(Cactus1ID, 46)).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setBlockName("Cactus1").setRequiresSelfNotify();
		Cactus2 = (new DesertFlower(Cactus2ID, 45)).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setBlockName("Cactus2").setRequiresSelfNotify();
	}

	public void addBiomes() 
	{
		GameRegistry.addBiome(RcDesert);
	}

	public void addNames() 
	{
		//
		//LanguageRegistry.addName(CarvedDarkStoneWall, "Carved Darkstone Wall");
		
		//Sandstone Paste
		LanguageRegistry.addName(SandStonePaste, "Dark Sand Clay");
		
		//Bloodstone Brick
		LanguageRegistry.addName(BloodstoneBrick, "Bloodstone Brick");
		
		//Gems
		LanguageRegistry.addName(UncutLBGem, "Uncut Light Blue Gem");
		LanguageRegistry.addName(CutLBGem, "Light Blue Gem");
		LanguageRegistry.addName(UncutDBGem, "Uncut Dark Blue Gem");
		LanguageRegistry.addName(CutDBGem, "Dark Blue Gem");
		
		//Chisel's
		LanguageRegistry.addName(GoldChisel, "Gold Chisel");
		LanguageRegistry.addName(FlintChisel, "Flint Chisel");
		LanguageRegistry.addName(CopperChisel, "Copper Chisel");
		LanguageRegistry.addName(DiamondChisel, "Diamond Chisel");
		LanguageRegistry.addName(BloodstoneChisel, "Bloodstone Chisel");
		
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
        
        //Cactus's
        LanguageRegistry.addName(Cactus1, "Cactus");
        LanguageRegistry.addName(Cactus2, "Cactus");
	}

	public void registerBlocks() 
	{
		GameRegistry.registerBlock(DesertBlockMulti, ItemMulti.class,"DesertBlockMulti");
		GameRegistry.registerBlock(ColumnMulti, ItemMulti.class);
		GameRegistry.registerBlock(HireoMulti, ItemMulti.class);
		GameRegistry.registerBlock(Cactus1, "Cactus1");
		GameRegistry.registerBlock(Cactus2, "Cactus2");
		GameRegistry.registerBlock(DarkSand, "DarkSand");
		GameRegistry.registerBlock(CherryTreeLeaves);
		GameRegistry.registerBlock(Cherrywood);
		GameRegistry.registerBlock(CherryTreeSapling);
		GameRegistry.registerBlock(BloodstoneBrick, "BloodstoneBrick");
		//GameRegistry.registerBlock(CarvedDarkStoneWall, "CarvedDarkstoneWall");
	}

	public void registerHandlers() 
	{
		GameRegistry.registerCraftingHandler(new CraftingHandler());
		GameRegistry.registerWorldGenerator(new WorldGenHandler());	
	}

	@PostInit
	 public void modsLoaded(FMLPostInitializationEvent evt)
	 {
		FMLLog.info("Time to find the Lost Eragonian Temples!"); 
	 }
}