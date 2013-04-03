package Reactioncraft.machines.common;

import railcraft.common.api.crafting.RailcraftCraftingManager;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFurnace;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import Reactioncraft.base.common.RCB;
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
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


@Mod( modid = "RCMM", name="Reactioncraft Mobs Mod", version="[1.4.7] Reactioncraft Version 7.0")
@NetworkMod(channels = { "RCMM" }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)

public class RCMM
{
	//@SidedProxy(clientSide = "Reactioncraft.base.common.ClientProxy", serverSide = "Reactioncraft.base.common.CommonProxy")
	@SidedProxy(clientSide = "Reactioncraft.machines.common.ClientProxy", serverSide = "Reactioncraft.machines.common.CommonProxy")

	public static CommonProxy proxy;
	@Instance("RCMM")
	public static RCMM instance;

	//Config Code
	public static int FreezerActiveID;
	public static int FreezerIdleID;
	public static int IceBucketIID;
	public static int ObsidianBucketIID;

	//Block code
	public static Block FreezerActive;
	public static Block FreezerIdle;


	//Item Code
	public static Item IceBucket;
	public static Item ObsidianBucket;


	public static RCMM instance()
	{
		return instance;
	}
	
	public static boolean Railcraft() throws ClassNotFoundException 
	{
		try{
			Class.forName("railcraft.common.core.Railcraft");
		}
		catch (NoClassDefFoundError ex) 
		{
			return false ;
		}
		return true ;
	}

	@PreInit
	public void preInit(FMLPreInitializationEvent evt)
	{
		instance = this;
		Configuration config = new Configuration(evt.getSuggestedConfigurationFile());
		config.load();

		MinecraftForge.EVENT_BUS.register(this);
		
		//3066- 3070
		FreezerActiveID = config.getBlock("Freezer Active", 3066).getInt();
		FreezerIdleID   = config.getBlock("Freezer Idle", 3067).getInt();
		
		//10801 - 10820
		IceBucketIID = config.getItem("Ice Bucket", 10801).getInt();
		ObsidianBucketIID = config.getItem("Obsidian Bucket", 10802).getInt();


		config.save();
	}

	@Init 
	public void load(FMLInitializationEvent event)
	{
		ClientProxy.registerRenderInformation();
		BlockCode();
		ItemCode();
		NetworkRegistry.instance().registerGuiHandler(this, proxy);
		GameRegistry();
		LanguageRegistry();
		FreezerRecipes();
		OreDictionary();
		
		//railcraft integration
		try
		{
			if(Railcraft())
			{
				Integration.loadRailCraft();
				System.out.println("Railcraft integration loaded !");
			}
		}
		catch (ClassNotFoundException e)
		{
			System.out.println("Reactioncraft Machines did not find railcraft, all integration disabled");
		}
	}

	private void ItemCode() 
	{
		IceBucket = (new ItemBasic(IceBucketIID)).setIconCoord(202, 0).setMaxStackSize(1).setItemName("IceBucket").setContainerItem(Item.bucketEmpty);
		ObsidianBucket = (new ItemBasic(ObsidianBucketIID)).setIconCoord(205, 0).setMaxStackSize(1).setItemName("ObsidianBucket").setContainerItem(Item.bucketEmpty);

	}

	private void BlockCode() 
	{
		FreezerIdle = (new BlockFreezer(FreezerActiveID, false)).setHardness(3.5F).setBlockName("FreezerIdle").setRequiresSelfNotify().setCreativeTab(RCB.Reactioncraft);
		FreezerActive = (new BlockFreezer(FreezerIdleID, true)).setHardness(3.5F).setLightValue(0.875F).setBlockName("FreezerActive").setRequiresSelfNotify();
	}

	private void LanguageRegistry() 
	{
		LanguageRegistry.addName(FreezerIdle, "Freezer");
		LanguageRegistry.addName(ObsidianBucket, "Bucket Of Obsidian");
		LanguageRegistry.addName(IceBucket, "\u00a79Bucket Of Ice");
	}

	private void GameRegistry() 
	{
		GameRegistry.registerBlock(FreezerActive, "FreezerActive");
		GameRegistry.registerBlock(FreezerIdle, "FreezerIdle");
		GameRegistry.addSmelting(RCMM.IceBucket.itemID, new ItemStack(Item.bucketWater, 1), 0.5F);
		GameRegistry.registerTileEntity(TileEntityFreezer.class, "Freezer");
		GameRegistry.addRecipe(new ItemStack(FreezerIdle, 1), new Object[]{"RSR", "LOW", "RSR",  Character.valueOf('W'), Item.bucketWater ,Character.valueOf('L'), Block.lever ,Character.valueOf('S'), Block.blockSteel ,Character.valueOf('O'), Block.stoneOvenIdle, Character.valueOf('R'), Item.redstone});
		GameRegistry.addShapelessRecipe(new ItemStack(Block.ice, 1), new Object[]{IceBucket,});
		GameRegistry.addShapelessRecipe(new ItemStack(Block.obsidian, 1), new Object[]{ObsidianBucket,});
	}

	private void FreezerRecipes() 
	{
		FreezerRecipes.smelting().addSmelting(Item.bucketLava.itemID , new ItemStack(ObsidianBucket, 1, 0), 0.5F);
		FreezerRecipes.smelting().addSmelting(Item.bucketWater.itemID, new ItemStack(IceBucket), 0.5F);
	}

	private void OreDictionary() 
	{
		//For Future IC2 / BC Compatable Freezer and Reactioncraft Mods
		OreDictionary.registerOre("bucketICE", new ItemStack(IceBucket));
	}

	@PostInit
	public void modsLoaded(FMLPostInitializationEvent evt)
	{

	}
}
