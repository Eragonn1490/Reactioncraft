package Reactioncraft.food.common;

import Reactioncraft.base.common.RCB;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSword;

public class ItemKnife extends ItemSword
{
	public ItemKnife(int i, EnumToolMaterial var2)
	{
		super(i, var2);
		this.setCreativeTab(RCB.Reactioncraft);
		this.setMaxStackSize(1);
		this.setMaxDamage(35);
	}

	@Override
	public String getTextureFile()
	{
		return "/Reactioncraft/images/Items.png";
	}
}
