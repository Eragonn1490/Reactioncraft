package Reactioncraft.basic.common;

import net.minecraft.item.Item;
import Reactioncraft.base.common.RCB;

public class ItemBasic extends Item
{
	
	public ItemBasic(int i)
	{
		super(i);
		this.setCreativeTab(RCB.Reactioncraft);
		//this.setCreativeTab(CreativeTabs.tabRedstone);
	}
	
	@Override
	public String getTextureFile()
	{
		return "/Reactioncraft/images/Items.png";
	}
}
