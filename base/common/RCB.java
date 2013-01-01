package Reactioncraft.base.common;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.common.MinecraftForge;
import Reactioncraft.basic.common.CreativeTabReactioncraft;
import Reactioncraft.basic.common.CreativeTabReactioncraftfood;
import Reactioncraft.basic.common.ItemBasic;
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
import Reactioncraft.base.common.ClientProxy;
import Reactioncraft.base.common.CommonProxy;
import Reactioncraft.base.common.FuelHandler;


@Mod( modid = "RCB", name="Reactioncraft Basic", version="[1.4.6] Reactioncraft Version 6.0.0")
@NetworkMod(channels = { "RCB" }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class, connectionHandler = ConnectionHandler.class)

public class RCB
{
	@SidedProxy(clientSide = "Reactioncraft.base.common.ClientProxy", serverSide = "Reactioncraft.base.common.CommonProxy")
	//@SidedProxy(clientSide = "Reactioncraft.basic.common.ClientProxy", serverSide = "Reactioncraft.basic.common.CommonProxy")
	
	public static CommonProxy proxy;
	@Instance("RCB")
	public static RCB instance;
	
	//Config Code
	public static int MaskIID;
	
	//Block code
	
	//Item Code
	public static Item Mask;
	
	// creative tab
	public static CreativeTabs Reactioncraft;
	public static CreativeTabs Reactioncraftfood;
	
	public boolean manualEnabled;
	   
	 public static RCB instance()
	 {
	        return instance;
	 }
	
	@PreInit
	 public void preInit(FMLPreInitializationEvent evt)
	 {
		 instance = this;
		 Configuration config = new Configuration(evt.getSuggestedConfigurationFile());
		 config.load();
		 
		 manualEnabled = config.get(config.CATEGORY_GENERAL, "manualEnabled", true).getBoolean(true);
		 MaskIID = config.getItem("MASK", 10000).getInt();
		 
		 MinecraftForge.EVENT_BUS.register(this);
		 
		 config.save();
	 }
	
	 @Init 
	 public void load(FMLInitializationEvent event)
	 {
		ClientProxy.registerRenderInformation();
		Mask = new ItemBasic(MaskIID).setIconCoord(109, 0).setItemName("Mask").setCreativeTab(RCB.Reactioncraft);
		// make creative tab.
		Reactioncraft = new CreativeTabReactioncraft();
		Reactioncraftfood = new CreativeTabReactioncraftfood();
		//DungeonHooks.addDungeonLoot(new ItemStack(Mask), 1, 1, 2);
		
		GameRegistry.addRecipe(new ItemStack(Block.rail, 8), new Object[] {"X X", "X#X", "X X", 'X', Item.ingotIron, '#', Item.stick});
		
		LanguageRegistry.addName(Mask, "Mask");
		
		GameRegistry.registerFuelHandler(new FuelHandler());
		 
		//ChestGenHooks.addItem(ChestGenHooks.VILLAGE_BLACKSMITH, new WeightedRandomChestContent(lootStack, minStackSize, maxStackSize, chance));
		ChestGenHooks.addItem(ChestGenHooks.PYRAMID_DESERT_CHEST, new WeightedRandomChestContent(new ItemStack(RCB.Mask), 1, 1, (int) 0.65));
		ChestGenHooks.addItem(ChestGenHooks.PYRAMID_JUNGLE_CHEST, new WeightedRandomChestContent(new ItemStack(RCB.Mask), 1, 1, (int) 0.65));
	 }

	 @PostInit
	 public void modsLoaded(FMLPostInitializationEvent evt)
	 {
	 
	 }
	 
	 public boolean getRCManualEnabled()
	 {
			return manualEnabled;
	 }
	 
}
