package Reactioncraft.food.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.ICraftingHandler;

public class CraftingHandler implements ICraftingHandler 
{

	@Override
	public void onCrafting(EntityPlayer player, ItemStack item,
			IInventory craftMatrix) 
	{
		for(int w=0; w < craftMatrix.getSizeInventory(); w++) //Checks all the slots
		{               
			if(craftMatrix.getStackInSlot(w) != null) //If there is an item
			{
				ItemStack j = craftMatrix.getStackInSlot(w); //Gets the item
				if(j.getItem() != null && j.getItem() == RCF.Knfie) //If it's a Knife
				{
					ItemStack k = new ItemStack(RCF.Knfie, 2, (j.getItemDamage() + 1)); //Makes a new itemstack that's been damaged and has 2 items
					if(k.getItemDamage() >= k.getMaxDamage()){ //If it is destroyed
						k.stackSize--; //Removes the added item
					}
					craftMatrix.setInventorySlotContents(w, k); //Sets the slot to the new item
				}
			}
		}
	}

	@Override
	public void onSmelting(EntityPlayer player, ItemStack item) 
	{
		
	}

}
