package net.minecraft.src;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemCaughtEntity;
import net.minecraft.item.ItemNetCatcher;
import net.minecraft.item.ItemPieceHilt;
import net.minecraft.item.ItemPieceNet;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class mod_NetCatcher extends BaseMod {

	public static int caughtID = 17450;

	public static int hiltID = 17451;

	public static int netID = 17452;

	public static int completeNetID = 17453;

	public static int hiltIcon;

	public static int netIcon;

	public static int completeNetIcon;

	public static int caughtIcon;

	public static Item hilt;

	public static Item net;

	public static Item completeNet;

	public static Item caught;

	public mod_NetCatcher() {
		netIcon = override("Net.png");
		completeNetIcon = override("Net.png");
		caughtIcon = override("PokeBall.png");
	}

	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public void load() {
		hilt = new ItemPieceHilt(hiltID).setIconCoord(5, 3);
		net = new ItemPieceNet(netID).setIconIndex(netIcon);
		completeNet = new ItemNetCatcher(completeNetID).setIconIndex(completeNetIcon);
		caught = new ItemCaughtEntity(caughtID).setIconIndex(caughtIcon);
		ModLoader.addShapelessRecipe(new ItemStack(completeNet), new Object[] { hilt, net });
		Object[] levels = new Object[] { Block.planks, Item.leather, Item.ingotIron, Item.ingotGold, Item.diamond };
		for (int i = 0; i < levels.length; i++) {
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

	private static int override(String s) {
		return ModLoader.addOverride("/gui/items.png", new StringBuilder().append("/icons/").append(s).toString());
	}

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
}
