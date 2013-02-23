package Reactioncraft.core.common;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.oredict.ShapedOreRecipe;
import Reactioncraft.basic.common.BlockBasic;
import Reactioncraft.basic.common.ClientProxy;
import Reactioncraft.basic.common.CommonProxy;
import Reactioncraft.basic.common.ItemBasic;
import Reactioncraft.basic.common.ItemContainer;
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
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
//import Reactioncraft.base.common.CommonProxy;
//import Reactioncraft.base.common.ClientProxy;

@Mod( modid = "RCC", name="Reactioncraft Core", version="[1.4.7] Reactioncraft Version 7.0")
@NetworkMod(channels = { "RCC" }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)

public class RCC
{
	//@SidedProxy(clientSide = "Reactioncraft.base.common.ClientProxy", serverSide = "Reactioncraft.base.common.CommonProxy")
	@SidedProxy(clientSide = "Reactioncraft.basic.common.ClientProxy", serverSide = "Reactioncraft.basic.common.CommonProxy")
	
	public static CommonProxy proxy;
	@Instance("RCC")
	
	public static RCC instance;
	
	//Config Code
	public static int extrapaintingsIID;
	public static int redstoneBlockID;
	public static int snowblockBlockID;
	public static int chainladderID;
	public static int ChainLoopIID;
	public static int HammerIID;
	
	//block code
	public static Block redstoneBlock;
	public static Block snowblock;
	public static Block chainladder;
	
	
	//Item code
	public static Item extrapaintings;
	public static Item ChainLoop;
	public static Item Hammer;
	
	
	@PreInit
	 public void preInit(FMLPreInitializationEvent evt)
	 {
		 Configuration config = new Configuration(evt.getSuggestedConfigurationFile());
		 config.load();
		 
		 
		 //Block
		 redstoneBlockID = config.getBlock("Redstone Block", 2999).getInt();
		 snowblockBlockID = config.getBlock("Snow Block", 2998).getInt();
		 chainladderID = config.getBlock("chain ladder", 2997).getInt();
		 
		 
		 //Items
		 //Reserved 10061 - 10080 
		 extrapaintingsIID = config.getItem("Extra Paintings", 10081).getInt(); 
		 ChainLoopIID = config.getItem("Chain Loop", 10079).getInt();
		 HammerIID = config.getItem("Hammer", 10078).getInt();
		 
		 config.save();
	 }
	
	 @Init 
	 public void load(FMLInitializationEvent event)
	 {
		ClientProxy.registerRenderInformation();
		blockCode();
		ItemCode();
		addNames();
		worldGenHandler();
		recipes();
		blockRegistry();
	 }

	private void blockRegistry() 
	{
		GameRegistry.registerBlock(snowblock, "snowblock");
		GameRegistry.registerBlock(redstoneBlock, "redstoneBlock");
		GameRegistry.registerBlock(chainladder, "chainladder");
		GameRegistry.registerItem(ChainLoop, "ChainLoop");
	}

	private void recipes() 
	{
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(RCC.ChainLoop,3,8), true, new Object[]{"XY ", "   ", "   ", Character.valueOf('X'), RCC.Hammer, Character.valueOf('Y'), "ingotSuperheatediron"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(RCC.ChainLoop,3,8), true, new Object[]{"   ", "XY ", "   ", Character.valueOf('X'), RCC.Hammer, Character.valueOf('Y'), "ingotSuperheatediron"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(RCC.ChainLoop,3,8), true, new Object[]{"   ", "   ", "XY ", Character.valueOf('X'), RCC.Hammer, Character.valueOf('Y'), "ingotSuperheatediron"}));
		GameRegistry.addRecipe(new ItemStack(Hammer, 1), new Object[]{"XXX", "XIX", " I ", Character.valueOf('I'), Item.stick, Character.valueOf('X'), Item.ingotIron});
		GameRegistry.addRecipe(new ItemStack(redstoneBlock, 1), new Object[]{ "DDD", "DDD", "DDD", Character.valueOf('D'), new ItemStack(Item.redstone),});
		GameRegistry.addRecipe(new ItemStack(RCC.chainladder, 2), new Object[] {"Y", "Y", "Y", 'Y', RCC.ChainLoop});
		GameRegistry.addShapelessRecipe(new ItemStack(RCC.ChainLoop, 3), new Object[]{RCC.chainladder,});
		GameRegistry.addRecipe(new ItemStack(snowblock, 1), new Object[]{ "DD ", "DD ", "   ", Character.valueOf('D'), Block.ice});
	}

	public void blockCode() 
	{
		chainladder = new BlockChainLadder(chainladderID, 98).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setBlockName("chainladder");
		snowblock = new BlockBasic(snowblockBlockID, 67).setHardness(3.0F).setResistance(5.0F).setBlockName("snowblock");
		redstoneBlock = new BlockRedstoneBlock(redstoneBlockID, 99).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setBlockName("RedStoneBlock");
	}

	public void worldGenHandler() 
	{
		GameRegistry.registerWorldGenerator(new WorldGenHandler());
	}

	public void ItemCode() 
	 {
		extrapaintings = new ItemPainting(extrapaintingsIID, ReactioncraftEntityPainting.class).setIconCoord(10, 1).setItemName("painting");
		ChainLoop = (new ItemBasic(ChainLoopIID)).setIconCoord(82, 0).setItemName("ChainLoop");
		Hammer = (new ItemContainer(HammerIID)).setMaxStackSize(1).setIconCoord(108, 0).setItemName("Hammer");
	 }

	public void addNames() 
	{
		LanguageRegistry.addName(extrapaintings, "Extra Paintings");
		LanguageRegistry.addName(snowblock, "Snow Block");
		LanguageRegistry.addName(redstoneBlock, "Redstone Block");
		LanguageRegistry.addName(chainladder, "chain ladder");
		LanguageRegistry.addName(ChainLoop, "Chain Loop");
		LanguageRegistry.addName(Hammer, "Hammer");
	}
	

	@PostInit
	 public void modsLoaded(FMLPostInitializationEvent evt)
	 {
	 
	 }	 
}

