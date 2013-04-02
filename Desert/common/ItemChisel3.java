package Reactioncraft.Desert.common;

import Reactioncraft.base.common.RCB;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSword;

public class ItemChisel3 extends ItemChisel 
{

	public ItemChisel3(int par1) 
	{
		super(par1);
		this.setMaxStackSize(1);
		this.setMaxDamage(65);
		this.setItemName("Chisel");
		this.setCreativeTab(RCB.Reactioncraft);
	}
	
	@Override
    public String getTextureFile() 
    {
		return "/Reactioncraft/images/Items.png";
	}
}


