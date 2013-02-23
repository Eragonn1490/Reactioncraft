package Reactioncraft.NetMod.Common;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import Reactioncraft.NetMod.ltd.genuine.database.ExclusionList;
import Reactioncraft.base.common.RCB;

public class ItemNetCatcher extends ItemTool {

	public ItemNetCatcher(int par1) {
		super(par1, 0, EnumToolMaterial.WOOD, new Block[] {});
		this.setItemName("completeNet");
		this.setCreativeTab(RCB.Reactioncraft);
	}
	
	@Override
	public String getTextureFile()
	{
		return "/Reactioncraft/images/Items.png";
	}
	
	@Override
	public String getItemDisplayName(ItemStack par1ItemStack) {
		return "Catching Net";
	}

	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
		if (entity == null || ExclusionList.instance.isExcluded(entity))
			return false;
		NBTTagCompound nbt = new NBTTagCompound();
		entity.writeToNBT(nbt);
		nbt.removeTag("Pos");
		nbt.removeTag("Motion");
		nbt.removeTag("Rotation");
		nbt.removeTag("Age");
		nbt.removeTag("Dimension");
		nbt.removeTag("PortalCooldown");
		nbt.removeTag("InLove");
		nbt.removeTag("HurtTime");
		nbt.removeTag("DeathTime");
		nbt.removeTag("AttackTime");
		ItemStack is = new ItemStack(RCN.caught);
		is.stackTagCompound = new NBTTagCompound();
		is.stackTagCompound.setString("entity", EntityList.getEntityString(entity));
		is.stackTagCompound.setCompoundTag("entityData", nbt);
		player.dropPlayerItem(is);
		stack.damageItem(1, player);
		entity.setDead();
		return true;
	}

	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
		if (itemStack.stackTagCompound != null) {
			list.add("Hilt: " + itemStack.stackTagCompound.getByte("hilt"));
			list.add("Net: " + itemStack.stackTagCompound.getByte("net"));
		} else
			list.add("Please craft to see results");
		super.addInformation(itemStack, player, list, par4);
	}
}
