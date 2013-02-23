package Reactioncraft.NetMod.Common;

import Reactioncraft.basic.common.PacketHandler;
import Reactioncraft.basic.common.ClientProxy;
import Reactioncraft.basic.common.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.src.BaseMod;
import net.minecraft.src.ModLoader;
import net.minecraftforge.common.Configuration;

@Mod( modid = "RCN", name="Reactioncraft Netting", version="[1.4.7] Reactioncraft Version 7.0")
@NetworkMod(channels = { "RCN" }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)


public class RCN extends BaseMod 
{
	@SidedProxy(clientSide = "Reactioncraft.basic.common.ClientProxy", serverSide = "Reactioncraft.basic.common.CommonProxy")
	
	public static CommonProxy proxy;
	
	@Instance("RCN")
	public static RCN instance;
	
	//config	
	public static int caughtID;

	public static int hiltID;

	public static int netID;

	public static int completeNetID;
	
	//Items

	public static Item hilt;

	public static Item net;

	public static Item completeNet;

	public static Item caught;

	 @PreInit
	 public void preInit(FMLPreInitializationEvent evt)
	 {
	 //This is new! put stuff here that you want to happen before the mods are loaded
		 Configuration config = new Configuration(evt.getSuggestedConfigurationFile());

         config.load();
         
         caughtID = config.getItem("Caught", 17000).getInt();
         hiltID = config.getItem("Hilt Item", 17001).getInt();
         netID = config.getItem("Net Item", 17002).getInt();
         completeNetID = config.getItem("Complete Item", 17003).getInt();

         config.save();
	 }
	 
	 @Init
	 public void load(FMLInitializationEvent event)
	 {
	 	//the meat of the mod
		ClientProxy.registerRenderInformation();
		itemCode();
		itemRegistry();
	    names();
	    recipes();
	 }
	    
	 public void itemRegistry() 
	 {
		//GameRegistry.registerItem(hilt, "");
		//GameRegistry.registerItem(net, "");
		//GameRegistry.registerItem(completeNet, "");
		//GameRegistry.registerItem(caught, "");
	 }

	public void recipes() 
	 {
		 Object[] levels = new Object[] { Block.planks, Item.leather, Item.ingotIron, Item.ingotGold, Item.diamond };
			for (int i = 0; i < levels.length; i++) 
			{
				Object[] hiltRec = new Object[] { " XI", "XIX", "IX ", 'X', Item.stick, 'I', levels[i] };
				Object[] netRec = new Object[] { "IXI", "XIX", "IXI", 'X', Item.silk, 'I', levels[i] };
				ItemStack hiltIs = new ItemStack(hilt);
				ItemStack netIs = new ItemStack(net);
				hiltIs.stackTagCompound = new NBTTagCompound();
				netIs.stackTagCompound = new NBTTagCompound();
				hiltIs.stackTagCompound.setByte("str", (byte) (i + 1));
				netIs.stackTagCompound.setByte("str", (byte) (i + 1));
				ModLoader.addRecipe(hiltIs, hiltRec);
				ModLoader.addRecipe(netIs, netRec);
			}
	 }

	public void names() 
	 {
		
	 }

	public void itemCode() 
	 {
		 hilt = new ItemPieceHilt(hiltID).setIconCoord(5, 3);
		 net = new ItemPieceNet(netID).setIconCoord(250, 0);
		 completeNet = new ItemNetCatcher(completeNetID).setIconCoord(250, 0);
		 caught = new ItemCaughtEntity(caughtID).setIconCoord(249, 0);
	 }

//	@Override
//	 public void load() {
//		hilt = new ItemPieceHilt(hiltID).setIconCoord(5, 3);
//		net = new ItemPieceNet(netID).setIconIndex(netIcon);
//		completeNet = new ItemNetCatcher(completeNetID).setIconIndex(completeNetIcon);
//		caught = new ItemCaughtEntity(caughtID).setIconIndex(caughtIcon);
//		ModLoader.addShapelessRecipe(new ItemStack(completeNet), new Object[] { hilt, net });
//		Object[] levels = new Object[] { Block.planks, Item.leather, Item.ingotIron, Item.ingotGold, Item.diamond };
//		for (int i = 0; i < levels.length; i++) {
//			Object[] hiltRec = new Object[] { " XI", "XIX", "IX ", 'X', Item.stick, 'I', levels[i] };
//			Object[] netRec = new Object[] { "IXI", "XIX", "IXI", 'X', Item.silk, 'I', levels[i] };
//			ItemStack hiltIs = new ItemStack(hilt);
//			ItemStack netIs = new ItemStack(net);
//			hiltIs.stackTagCompound = new NBTTagCompound();
//			netIs.stackTagCompound = new NBTTagCompound();
//			hiltIs.stackTagCompound.setByte("str", (byte) (i + 1));
//			netIs.stackTagCompound.setByte("str", (byte) (i + 1));
//			ModLoader.addRecipe(hiltIs, hiltRec);
//			ModLoader.addRecipe(netIs, netRec);
//		}
//	}
//
//	public static int override(String s) {
//		return ModLoader.addOverride("/gui/items.png", new StringBuilder().append("/Reactioncraft/NetMod/icons/").append(s).toString());
//	}

	@Override
	public void takenFromCrafting(EntityPlayer player, ItemStack item, IInventory matrix) {
		if (item.getItem() == completeNet) {
			item.stackTagCompound = new NBTTagCompound();
			ItemStack hilt = null;
			ItemStack net = null;
			boolean hasHilt;
			boolean hasNet;
			for (int i = 0; i < matrix.getSizeInventory(); i++) {
				ItemStack is = matrix.getStackInSlot(i);
				if (is != null)
					if (is.getItem() == this.hilt)
						hilt = is;
					else
						net = is;
			}
			if (hilt != null && net != null) {
				item.stackTagCompound.setByte("hilt", hilt.stackTagCompound.getByte("str"));
				item.stackTagCompound.setByte("net", net.stackTagCompound.getByte("str"));
			}
		}
	}
	
	@Deprecated
	//@Override
	public String getVersion() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Deprecated
	//@Override
	public void load() {
		// TODO Auto-generated method stub
		
	}
}
