package Reactioncraft.basic.common;

import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSword;

public class BasicSword extends ItemSword
{
	public BasicSword(int i, EnumToolMaterial var2)
	{
		super(i, var2);
		this.setCreativeTab(Reactioncraft.base.common.RCB.Reactioncraft);
		//this.setCreativeTab(CreativeTabs.tabRedstone);
	}

	@Override
	public String getTextureFile()
	{
		return "/Reactioncraft/images/Items.png";
	}
}
