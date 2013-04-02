package Reactioncraft.NetMod.Common;

import Reactioncraft.base.common.RCB;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagDouble;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;

public class ItemCaughtEntity extends Item 
{

	public ItemCaughtEntity(int par1) 
	{
		super(par1);
		this.setItemName("GenuineCaught");
		//this.setCreativeTab(RCB.Reactioncraft);
	}
	
	@Override
	public String getTextureFile()
	{
		return "/Reactioncraft/images/Items.png";
	}
	
	@Override
	public String getItemDisplayName(ItemStack itemStack) 
	{
		return "Caught " + itemStack.stackTagCompound.getString("entity"); //+ itemStack.stackTagCompound.getString("age");
	}

	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10) {
		Entity entity = EntityList.createEntityByName(itemStack.stackTagCompound.getString("entity"), world);
		NBTTagCompound nbt = itemStack.stackTagCompound.getCompoundTag("entityData");
		nbt.setTag("Pos", this.newDoubleNBTList(new double[] { player.posX, player.posY + (double) player.ySize, player.posZ }));
		nbt.setTag("Motion", this.newDoubleNBTList(new double[] { player.motionX, player.motionY, player.motionZ }));
		nbt.setTag("Rotation", this.newFloatNBTList(new float[] { player.rotationYaw, player.rotationPitch }));
		entity.readFromNBT(nbt);
		entity.setPosition(x + 0.5, y + 1, z + 0.5);
		if (!world.isRemote)
			world.spawnEntityInWorld(entity);
		itemStack.stackSize--;
		return true;
	}

	public static NBTTagList newDoubleNBTList(double... par1ArrayOfDouble) {
		NBTTagList var2 = new NBTTagList();
		double[] var3 = par1ArrayOfDouble;
		int var4 = par1ArrayOfDouble.length;
		for (int var5 = 0; var5 < var4; ++var5) {
			double var6 = var3[var5];
			var2.appendTag(new NBTTagDouble((String) null, var6));
		}
		return var2;
	}

	public static NBTTagList newFloatNBTList(float... par1ArrayOfFloat) {
		NBTTagList var2 = new NBTTagList();
		float[] var3 = par1ArrayOfFloat;
		int var4 = par1ArrayOfFloat.length;
		for (int var5 = 0; var5 < var4; ++var5) {
			float var6 = var3[var5];
			var2.appendTag(new NBTTagFloat((String) null, var6));
		}
		return var2;
	}
}
