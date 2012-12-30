package Reactioncraft.plantz.common;

import net.minecraft.item.Item;
import Reactioncraft.base.common.RCB;

public class PlantzBasic extends Item
{
	public PlantzBasic(int i)
	{
		super(i);
		this.setCreativeTab(RCB.Reactioncraft);
		//this.setCreativeTab(CreativeTabs.tabRedstone);
	}

	public String getTextureFile()
	{
		return "/Reactioncraft/images/plant.png";
	}
}
