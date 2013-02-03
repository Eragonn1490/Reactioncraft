package net.minecraft.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;

public class ItemPieceHilt extends Item {

	public ItemPieceHilt(int par1) {
		super(par1);
		this.setItemName("pieceHilt");
	}

	@Override
	public String getItemDisplayName(ItemStack par1ItemStack) {
		return "Hilt Piece";
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
