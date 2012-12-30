package Reactioncraft.bookcase.common;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class FuelHandler implements IFuelHandler
{
	@Override
    public int getBurnTime(ItemStack var1)
    {
        return 
        		var1.itemID == Item.book.shiftedIndex ? 45 : 
        			(var1.itemID == Item.writableBook.shiftedIndex ? 50 : 
        				(var1.itemID == Item.writtenBook.shiftedIndex ? 55 :
        					(var1.itemID == Item.map.shiftedIndex ? 60 : 
        						(var1.itemID == Item.paper.shiftedIndex ? 20 : 
        							(var1.itemID == Item.sign.shiftedIndex ? 200 : 
        								(var1.itemID == Item.doorWood.shiftedIndex ? 200 : 
        									(var1.itemID == Block.bookShelf.blockID ? 300 : 
        										(var1.itemID == RCBB.WoodenBookcasedoor.shiftedIndex ? 300 : 
        											(var1.itemID == RCBB.Bookcasechest.blockID ? 300 : 
        												(var1.itemID == RCBB.bookcasemeta.blockID ? 300 : 
        													//(var1.itemID == RCBB.bookcasemeta.blockID, 1 ? 300 :
        														(var1.itemID == Block.fence.blockID ? 300 : 
        															(var1.itemID == Block.fenceGate.blockID ? 300 : 0))))))))))));
    }
}
