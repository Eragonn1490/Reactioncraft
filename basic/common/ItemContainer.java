package Reactioncraft.basic.common;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import Reactioncraft.base.common.RCB;

public class ItemContainer extends Item
{
	
	public ItemContainer(int i)
	{
		super(i);
		this.setCreativeTab(RCB.Reactioncraft);
		this.maxStackSize = 1;
		this.setContainerItem(this);
	}

    /**
     * If this returns true, after a recipe involving this item is crafted the container item will be added to the
     * player's inventory instead of remaining in the crafting grid.
     */
    public boolean doesContainerItemLeaveCraftingGrid(ItemStack par1ItemStack)
    {
        return true;
    }
	
	@Override
	public String getTextureFile()
	{
		return "/Reactioncraft/images/Items.png";
	}
}
