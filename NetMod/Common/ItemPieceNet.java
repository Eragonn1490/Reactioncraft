package Reactioncraft.NetMod.Common;

import java.util.List;

import Reactioncraft.base.common.RCB;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemPieceNet extends Item {

	public ItemPieceNet(int par1) {
		super(par1);
		this.setItemName("pieceNet");
		this.setCreativeTab(RCB.Reactioncraft);
	}
	
	@Override
	public String getTextureFile()
	{
		return "/Reactioncraft/images/Items.png";
	}

	@Override
	public String getItemDisplayName(ItemStack par1ItemStack) {
		return "Net Piece";
	}

	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
		if (itemStack.stackTagCompound != null)
			list.add("Level: " + itemStack.stackTagCompound.getByte("str"));
		else
			list.add("Please craft to see results");
		super.addInformation(itemStack, player, list, par4);
	}
}
