package Reactioncraft.Desert.common;

import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSword;

public class ItemChisel extends ItemSword {

	public ItemChisel(int par1) {
		super(par1, EnumToolMaterial.EMERALD);
		this.setMaxStackSize(1);
		this.setMaxDamage(10);
		this.setItemName("Chisel");
	}

	// A recharge method. My sword absorbs souls!!!
	//@Override
	//public boolean hitEntity(ItemStack itemStack, EntityLiving par2EntityLiving, EntityLiving par3EntityLiving) 
	//{
	//	if (itemStack.getItemDamage() > 0)
	//		itemStack.setItemDamage(itemStack.getItemDamage() - 1);
	//	return true;
	//}
}