package Reactioncraft.christmas.common;

import net.minecraft.item.Item;
import Reactioncraft.base.common.RCB;

public class ItemChristmas extends Item
{
	public ItemChristmas(int i)
	{
		super(i);
		this.setCreativeTab(RCB.Reactioncraft);
		//this.setCreativeTab(CreativeTabs.tabRedstone);
	}

	@Override
	public String getTextureFile()
	{
		return "/Reactioncraft/images/ChristmasItems.png";
	}
}
