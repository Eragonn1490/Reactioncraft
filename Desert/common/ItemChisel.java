package Reactioncraft.Desert.common;

import Reactioncraft.base.common.RCB;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSword;

public class ItemChisel extends ItemSword 
{

	public ItemChisel(int par1) 
	{
		super(par1, EnumToolMaterial.EMERALD);
		this.setMaxStackSize(1);
		this.setMaxDamage(10);
		this.setItemName("Chisel");
		this.setCreativeTab(RCB.Reactioncraft);
	}
	
	@Override
    public String getTextureFile() 
    {
		return "/Reactioncraft/images/Items.png";
	}
}


