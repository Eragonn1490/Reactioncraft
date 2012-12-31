package Reactioncraft.core.common;

import net.minecraft.entity.item.EntityPainting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHangingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import Reactioncraft.basic.common.ClientProxy;
import Reactioncraft.basic.common.CommonProxy;
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
import cpw.mods.fml.common.registry.LanguageRegistry;
//import Reactioncraft.base.common.CommonProxy;
//import Reactioncraft.base.common.ClientProxy;

@Mod( modid = "RCC", name="Reactioncraft Core", version="[1.4.6] Reactioncraft Version 6.0.0")
@NetworkMod(channels = { "RCHRM" }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)

public class RCC
{
	//@SidedProxy(clientSide = "Reactioncraft.base.common.ClientProxy", serverSide = "Reactioncraft.base.common.CommonProxy")
	@SidedProxy(clientSide = "Reactioncraft.basic.common.ClientProxy", serverSide = "Reactioncraft.basic.common.CommonProxy")
	
	public static CommonProxy proxy;
	@Instance("RCC")
	
	public static RCC instance;
	
	//Config Code
	public static int extrapaintingsIID;
	
	
	//Item code
	public static Item extrapaintings;
	
	
	@PreInit
	 public void preInit(FMLPreInitializationEvent evt)
	 {
		 Configuration config = new Configuration(evt.getSuggestedConfigurationFile());
		 config.load();
		 
		 //Items
		 //Reserved 10061 - 10080 
		 extrapaintingsIID = config.getItem("Extra Paintings", 10081).getInt();
		 
		 config.save();
	 }
	
	 @Init 
	 public void load(FMLInitializationEvent event)
	 {
		ClientProxy.registerRenderInformation();
		ItemCode();
		addNames();
	 }

	public void ItemCode() 
	 {
		extrapaintings = new ItemPainting(extrapaintingsIID, ReactioncraftEntityPainting.class).setIconCoord(10, 1).setItemName("painting");
	 }

	public void addNames() 
	{
		LanguageRegistry.addName(extrapaintings, "Extra Paintings");
	}
	

	@PostInit
	 public void modsLoaded(FMLPostInitializationEvent evt)
	 {
	 
	 }
	 
	 
}

