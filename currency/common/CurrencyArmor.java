package Reactioncraft.currency.common;

import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;
import Reactioncraft.base.common.RCB;

// This Is Your Class For Your Armor, Your Have To Extend ItemArmor For Minecraft To Register(Have The Required Methods And Values) This As Armor
// Then You Need To Implement IArmorTextureProvider For It To Be Able To Render
public class CurrencyArmor extends ItemArmor implements IArmorTextureProvider{
// This Is Your Constructor, The First Param Is Item ID, The Second Is Its Material, The Third Is The Rendering ID, and The Final Is The Type (i.e. Helmet, Plate, Boots, Legs)
public CurrencyArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4)
	{
		super(par1, par2EnumArmorMaterial, par3, par4);
		this.setCreativeTab(RCB.Reactioncraft);
	}

// This Sets What The Armor Is Supposed To Render Like
@Override
public String getArmorTextureFile(ItemStack stack){
	if(stack.itemID == RCCM.Crown.itemID || stack.itemID == RCCM.KinglyChest.itemID || stack.itemID == RCCM.KinglyBoots.itemID)
	{
		return "/Reactioncraft/images/armor/goldcrown_1.png";
	}

if(stack.itemID == RCCM.KinglyLegs.itemID)
	{
	return "/Reactioncraft/images/armor/kingspants2.png";
	}
	return "/Reactioncraft/images/armor/goldcrown_1.png";
}

  //This Sets The Icon For The Item Inside The Inventory
 	@Override
	public String getTextureFile()
	{
		return "/Reactioncraft/images/Items.png";
	}
}