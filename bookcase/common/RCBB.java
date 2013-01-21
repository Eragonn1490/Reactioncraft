package Reactioncraft.bookcase.common;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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


@Mod( modid = "RCBB", name="Reactioncraft Better Bookcases Mod", version="[1.4.6] Reactioncraft Version 6.0.0")
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
	public static int WoodenBookcasedoorBlockID;
	public static int IronBookcasedoorBlockID;
	public static int WoodenBookcasedoorIID;
	public static int IronBookcasedoorIID;

	//Block Code
	public static Block bookcasemeta;
	public static Block Bookcasechest;
	public static Block WoodenBookcasedoorBlock;
	public static Block IronBookcasedoorBlock;

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

		//Blocks
		bookcasemetaID = config.getBlock("Metadata BookShelfs", 3000).getInt();
		BookcasechestID = config.getBlock("BookShelf Chest", 3001).getInt();
		WoodenBookcasedoorBlockID = config.getBlock("Wooden BookShelf Door", 3002).getInt();
		IronBookcasedoorBlockID = config.getBlock("Iron BookShelf Door", 3003).getInt();

		//Items
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
	}

	public void blockRegistry() 
	{
		GameRegistry.registerBlock(bookcasemeta, ItemMulti.class, "bookcasemeta");
		GameRegistry.registerBlock(Bookcasechest, "Bookcasechest");
		GameRegistry.registerBlock(WoodenBookcasedoorBlock, "WoodenBookcasedoorBlock");
		GameRegistry.registerBlock(IronBookcasedoorBlock, "IronBookcasedoorBlock");
		GameRegistry.registerItem(WoodenBookcasedoor, "WoodenBookcasedoorBlock");
		GameRegistry.registerItem(IronBookcasedoor, "Iron Bookcase Door");
	}

	public void items() 
	{
		WoodenBookcasedoor = (new ItemBookcaseDoor(WoodenBookcasedoorIID, Material.wood)).setIconCoord(115, 0).setItemName("WoodenBookcasedoor");
		IronBookcasedoor = (new ItemBookcaseDoor(IronBookcasedoorIID, Material.iron)).setIconCoord(115, 0).setItemName("IronBookcasedoor");
	}

	public void blocks() 
	{
		bookcasemeta = new BlockBookcaseMulti(bookcasemetaID, Material.rock).setHardness(3.0F).setBlockName("bookcasemeta");
		WoodenBookcasedoorBlock = new BlockBookcasedoor(WoodenBookcasedoorBlockID, Material.wood).setHardness(3.0F).setBlockName("WoodenBookcasedoorBlock").setRequiresSelfNotify();;
		IronBookcasedoorBlock = new BlockBookcasedoor(IronBookcasedoorBlockID, Material.iron).setHardness(3.0F).setBlockName("IronBookcasedoorBlock").setRequiresSelfNotify();;
		Bookcasechest = (new Blockbookshelfchest(BookcasechestID)).setHardness(1.0F).setResistance(1.0F).setBlockName("Bookcasechest");
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
