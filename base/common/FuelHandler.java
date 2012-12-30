package Reactioncraft.base.common;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class FuelHandler implements IFuelHandler {

	@Override
	public int getBurnTime(ItemStack fuel)
	{
		if(fuel.itemID == Item.book.shiftedIndex)
			return 45;
		else if(fuel.itemID == Item.writableBook.shiftedIndex)
			return 50;
		else if(fuel.itemID == Item.writtenBook.shiftedIndex)
			return 55;

		
		else
		return 0;
	}
}
