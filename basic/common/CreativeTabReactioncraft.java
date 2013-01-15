package Reactioncraft.basic.common;

import net.minecraft.creativetab.CreativeTabs;
import Reactioncraft.base.common.RCB;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CreativeTabReactioncraft extends CreativeTabs
{
	public CreativeTabReactioncraft()
	{
		super("Reactioncraft");
	}

    @SideOnly(Side.CLIENT)
    
    @Override
    public int getTabIconItemIndex()
    {
        return RCB.Mask.itemID;
    }
    
    public String getTranslatedTabLabel()
    {
     return "Reactioncraft";
    }
}