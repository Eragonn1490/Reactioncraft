package Reactioncraft.tools.common;

import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;
import Reactioncraft.base.common.RCB;

public class BasicPick extends ItemPickaxe
{
    public BasicPick(int var1, EnumToolMaterial var2)
    {
        super(var1, var2);
        this.setCreativeTab(RCB.Reactioncraft);
		//this.setCreativeTab(CreativeTabs.tabRedstone);
	}

	@Override
	public String getTextureFile()
	{
		return "/Reactioncraft/images/Items.png";
	}
}
