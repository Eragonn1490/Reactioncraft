package Reactioncraft.core.common;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import Reactioncraft.base.common.RCB;
import Reactioncraft.basic.common.BlockBasic;
import Reactioncraft.basic.common.ClientProxy;
import Reactioncraft.basic.common.CommonProxy;
import Reactioncraft.basic.common.ItemBasic;
import Reactioncraft.basic.common.ItemContainer;
import Reactioncraft.basic.common.PacketHandler;
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
	public static int snowblockBlockID;
	public static int chainladderID;
	public static int ChainLoopIID;
	public static int HammerIID;
	public static int spongeAbsorbtion;

	//block code
	public static Block newSponge; int newSpongeId;
    public static Block clearBlock; int clearBlockId;
    
	public static Block snowblock;
	public static Block chainladder;
	
	
	//Item code
	public static Item extrapaintings;
	public static Item ChainLoop;
	public static Item Hammer;
	
	public static boolean RCBDM() throws ClassNotFoundException 
	 {
			try
			{
				Class.forName("Reactioncraft.Desert.common.RCBDM");
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
		 Configuration config = new Configuration(evt.getSuggestedConfigurationFile());
		 config.load();
		 
		 
		 //Block 3020-3026
		 newSpongeId = config.getBlock("Dry Sponge", 3020).getInt();
		 spongeAbsorbtion = config.get("Settings", "Sponge absortion (blocks)", 4).getInt();
		 clearBlockId = config.getBlock("Clear Block", 3021).getInt();
		 snowblockBlockID = config.getBlock("Snow Block", 3022).getInt();
		 chainladderID = config.getBlock("chain ladder", 3023).getInt();
		 
		 //Items
		 //Reserved 10081 - 10090 
		 extrapaintingsIID = config.getItem("Extra Paintings", 10081).getInt(); 
		 ChainLoopIID = config.getItem("Chain Loop", 10082).getInt();
		 HammerIID = config.getItem("Hammer", 10083).getInt();
		 
		 config.save();
	 }
	
	 @Init 
	 public void load(FMLInitializationEvent event)
	 {
		ClientProxy.registerRenderInformation();
		
		//Andr3wrulz Code
		newSponge = new NewSponge(newSpongeId, spongeAbsorbtion);
		clearBlock = new ClearBlock(clearBlockId);
		//
		
		blockCode();
		blockRegistry();
		ItemCode();
		addNames();
		worldGenHandler();
		recipes();
		oreDictionary();
		//Reactioncraft integration
		try 
		{
			if(RCBDM())
			{
				Integration.loadReactioncraft();
				System.out.println("Reactioncraft Better Desert Mod enabled");
			}
		}
		catch (ClassNotFoundException e)	
		{
			System.out.println(" Reactioncraft Core did not find Reactioncraft Better Desert Mod, No Special Sand Generation Allowed");
		}
	 }

	public void oreDictionary() 
	{
		
	}

	public void blockRegistry() 
	{
		GameRegistry.registerBlock(snowblock, "snowblock");
		GameRegistry.registerBlock(chainladder, "chainladder");
		GameRegistry.registerBlock(newSponge, "newSponge");
		GameRegistry.registerBlock(clearBlock, "clearBlock");
	}

	public void recipes() 
	{
		GameRegistry.addSmelting(Block.sponge.blockID, new ItemStack(RCC.newSponge), 0.1F); 
		
		//
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(RCC.ChainLoop,3,8), true, new Object[]{"XY ", "   ", "   ", Character.valueOf('X'), RCC.Hammer, Character.valueOf('Y'), "ingotSuperheatediron"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(RCC.ChainLoop,3,8), true, new Object[]{"   ", "XY ", "   ", Character.valueOf('X'), RCC.Hammer, Character.valueOf('Y'), "ingotSuperheatediron"}));
		CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(RCC.ChainLoop,3,8), true, new Object[]{"   ", "   ", "XY ", Character.valueOf('X'), RCC.Hammer, Character.valueOf('Y'), "ingotSuperheatediron"}));
		GameRegistry.addRecipe(new ItemStack(Hammer, 1), new Object[]{"XXX", "XIX", " I ", Character.valueOf('I'), Item.stick, Character.valueOf('X'), Item.ingotIron});
		GameRegistry.addRecipe(new ItemStack(RCC.chainladder, 2), new Object[] {"Y", "Y", "Y", 'Y', RCC.ChainLoop});
		GameRegistry.addShapelessRecipe(new ItemStack(RCC.ChainLoop, 2), new Object[]{RCC.chainladder,});
		GameRegistry.addRecipe(new ItemStack(snowblock, 1), new Object[]{ "DD ", "DD ", "   ", Character.valueOf('D'), Block.ice});
	}

	public void blockCode() 
	{
		chainladder = new BlockChainLadder(chainladderID, 98).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setBlockName("chainladder");
		snowblock = new BlockBasic(snowblockBlockID, 67).setHardness(3.0F).setResistance(5.0F).setBlockName("snowblock");
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
		LanguageRegistry.addName(newSponge, "Sponge");
		LanguageRegistry.addName(clearBlock, "Clear Block");
		LanguageRegistry.addName(extrapaintings, "Extra Paintings");
		LanguageRegistry.addName(snowblock, "Snow Block");
		LanguageRegistry.addName(chainladder, "chain ladder");
		LanguageRegistry.addName(ChainLoop, "Chain Loop");
		LanguageRegistry.addName(Hammer, "Hammer");
	}
	

	@PostInit
	 public void modsLoaded(FMLPostInitializationEvent evt)
	 {
		FMLLog.info("Looks like Reactioncraft Has Fully Loaded!");
	 }	 
}

