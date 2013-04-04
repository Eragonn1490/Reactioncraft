package Reactioncraft.bookcase.common;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLever;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import Reactioncraft.basic.common.ItemMulti;
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


@Mod( modid = "RCBB", name="Reactioncraft Better Bookcases Mod", version="[1.4.7] Reactioncraft Version 7.0")
@NetworkMod(channels = { "RCBB" }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)

public class RCBB
{
	@SidedProxy(clientSide = "Reactioncraft.bookcase.common.ClientProxy", serverSide = "Reactioncraft.bookcase.common.CommonProxy")

	public static CommonProxy proxy;

	@Instance("RCBB")
	public static RCBB instance;

	//Config Code
	public static int bookcasemetaID;
	public static int BookcasechestID;
	public static int leverbookcaseID;
	public static int WoodenBookcasedoorBlockID;
	public static int IronBookcasedoorBlockID;
	public static int WoodenBookcasedoorIID;
	public static int IronBookcasedoorIID;

	//Block Code
	public static Block bookcasemeta;
	public static Block Bookcasechest;
	public static Block WoodenBookcasedoorBlock;
	public static Block IronBookcasedoorBlock;
	public static Block leverbookcase;

	//Item Code
	public static Item WoodenBookcasedoor;
	public static Item IronBookcasedoor;

	public static RCBB instance()
	{
		return instance;
	}

	@PreInit
	public void preInit(FMLPreInitializationEvent evt)
	{
		instance = this;
		Configuration config = new Configuration(evt.getSuggestedConfigurationFile());
		config.load();

		//Blocks 3000 - 3007
		bookcasemetaID = config.getBlock("Metadata BookShelfs", 3000).getInt();
		BookcasechestID = config.getBlock("BookShelf Chest", 3001).getInt();
		WoodenBookcasedoorBlockID = config.getBlock("Wooden BookShelf Door", 3002).getInt();
		IronBookcasedoorBlockID = config.getBlock("Iron BookShelf Door", 3003).getInt();
		leverbookcaseID = config.getBlock("leverbookcase", 3004).getInt();

		//Items 10001 - 10040
		WoodenBookcasedoorIID = config.getItem("Wooden Bookcase Door", 10001).getInt();
		IronBookcasedoorIID = config.getItem("Iron Bookcase Door", 10002).getInt();

		MinecraftForge.EVENT_BUS.register(this);

		config.save();
	}

	@Init 
	public void load(FMLInitializationEvent event)
	{
		ClientProxy.registerRenderInformation();

		blocks();
		items();
		recipes();
		fuelHandler();
		tileentities();
		blockRegistry();
		languageRegistry();
		worldgen();
		HarvestLevel();
	}

	public void HarvestLevel() 
	{
		  //Setting Harvest Level
	    MinecraftForge.setBlockHarvestLevel(RCBB.Bookcasechest,     "axe", 0);
	    MinecraftForge.setBlockHarvestLevel(RCBB.bookcasemeta, 0,   "axe", 0);
	    MinecraftForge.setBlockHarvestLevel(RCBB.bookcasemeta, 1,   "axe", 0);
	    MinecraftForge.setBlockHarvestLevel(RCBB.bookcasemeta, 2,   "axe", 0);
	    MinecraftForge.setBlockHarvestLevel(RCBB.bookcasemeta, 3,   "axe", 0);
	    MinecraftForge.setBlockHarvestLevel(RCBB.leverbookcase,     "axe", 0);
	}

	public void fuelHandler() 
	{
		GameRegistry.registerFuelHandler(new FuelHandler());
	}

	public void recipes() 
	{
		//Empty Chest
		GameRegistry.addRecipe(new ItemStack(bookcasemeta, 1, 0), new Object[]{"###", "   ", "###", Character.valueOf('#'), Block.planks});

		//Bookcase Chest
		GameRegistry.addRecipe(new ItemStack(Bookcasechest, 1), new Object[]{"###", "BGB", "###", Character.valueOf('#'), Block.planks, Character.valueOf('G'), Block.chest, Character.valueOf('B'), Item.book});
		
		//Lever Bookcase
		GameRegistry.addRecipe(new ItemStack(RCBB.leverbookcase, 1), new Object[]{"###", "BLB", "###", Character.valueOf('#'), Block.planks, Character.valueOf('G'), Block.lever, Character.valueOf('B'), Item.book});

		//Bookcase Doors
		GameRegistry.addRecipe(new ItemStack(WoodenBookcasedoor, 1), new Object[]{"## ", "## ", "## ", Character.valueOf('#'), Block.bookShelf});
		GameRegistry.addRecipe(new ItemStack(IronBookcasedoor, 1), new Object[]{"   ", " # ", "III", Character.valueOf('#'), WoodenBookcasedoor, Character.valueOf('I'), Item.ingotIron});


		//Recipes that make Regular Bookcases
		GameRegistry.addRecipe(new ItemStack(Block.bookShelf, 1), new Object[]{ "BBB", " # ", Character.valueOf('#'), new ItemStack(bookcasemeta, 1, 0), Character.valueOf('B'), Item.book});
		GameRegistry.addRecipe(new ItemStack(Block.bookShelf, 1), new Object[]{ "## ", "## ", "## ", Character.valueOf('#'), new ItemStack(RCBB.bookcasemeta, 1, 1)});
		GameRegistry.addRecipe(new ItemStack(Block.bookShelf, 1), new Object[]{ "## ", "## ", "## ", Character.valueOf('#'), new ItemStack(RCBB.bookcasemeta, 1, 2)});
	}

	public void worldgen() 
	{
		GameRegistry.registerWorldGenerator(new WorldGenHandler());
	}


	public void languageRegistry() 
	{
		LanguageRegistry.addName(WoodenBookcasedoor, "Wooden Bookcase Door");
		LanguageRegistry.addName(IronBookcasedoor, "Iron Bookcase Door");

		LanguageRegistry.addName(Bookcasechest, "Bookshelf");

		//Door Blocks
		LanguageRegistry.addName(WoodenBookcasedoorBlock, "WoodenBookcasedoorBlock");
		LanguageRegistry.addName(IronBookcasedoorBlock, "IronBookcasedoorBlock");

		//Metadata Bookshelfs
		LanguageRegistry.addName(new ItemStack(bookcasemeta, 1, 0), "Empty Bookshelf");
		LanguageRegistry.addName(new ItemStack(bookcasemeta, 1, 1), "Webbed Bookshelf");
		LanguageRegistry.addName(new ItemStack(bookcasemeta, 1, 2), "Webbed Bookshelf");
		
		//Lever Bookcase
		LanguageRegistry.addName(leverbookcase, "Lever Bookshelf");
	}

	public void blockRegistry() 
	{
		GameRegistry.registerBlock(bookcasemeta, ItemMulti.class, "bookcasemeta");
		GameRegistry.registerBlock(Bookcasechest, "Bookcasechest");
		GameRegistry.registerBlock(WoodenBookcasedoorBlock, "WoodenBookcasedoorBlock");
		GameRegistry.registerBlock(IronBookcasedoorBlock, "IronBookcasedoorBlock");
		GameRegistry.registerBlock(leverbookcase, "leverbookcase");
	}

	public void items() 
	{
		WoodenBookcasedoor = (new ItemBookcaseDoor(WoodenBookcasedoorIID, Material.wood)).setIconCoord(115, 0).setItemName("WoodenBookcasedoor");
		IronBookcasedoor = (new ItemBookcaseDoor(IronBookcasedoorIID, Material.iron)).setIconCoord(115, 0).setItemName("IronBookcasedoor");
	}

	public void blocks() 
	{
		leverbookcase = (new BlockLeverBookcase(leverbookcaseID, 35)).setHardness(1.5F).setStepSound(Block.soundWoodFootstep).setBlockName("leverbookcase").setRequiresSelfNotify();
		bookcasemeta = new BlockBookcaseMulti(bookcasemetaID, Material.rock).setHardness(1.5F).setBlockName("bookcasemeta");
		WoodenBookcasedoorBlock = new BlockBookcasedoor(WoodenBookcasedoorBlockID, Material.wood).setHardness(1.5F).setBlockName("WoodenBookcasedoorBlock").setRequiresSelfNotify();;
		IronBookcasedoorBlock = new BlockBookcasedoor(IronBookcasedoorBlockID, Material.iron).setHardness(1.5F).setBlockName("IronBookcasedoorBlock").setRequiresSelfNotify();;
		Bookcasechest = (new Blockbookshelfchest(BookcasechestID)).setHardness(1.5F).setResistance(1.0F).setBlockName("Bookcasechest");
	}

	public void tileentities() 
	{ 
		//Tile Entities
		GameRegistry.registerTileEntity(TileEntityBookcaseChest.class, "Bookcasechest");
	}

	public void addDungeonLoot(ItemStack item, int rarity)
	{

	}

	@PostInit
	public void modsLoaded(FMLPostInitializationEvent evt)
	{

	}
}
