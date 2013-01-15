package Reactioncraft.machines.common;

import forestry.api.fuels.EngineBronzeFuel;
import ic2.api.Ic2Recipes;
import ic2.api.Items;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.liquids.LiquidContainerRegistry;
import net.minecraftforge.liquids.LiquidDictionary;
import net.minecraftforge.liquids.LiquidStack;
import railcraft.common.api.crafting.RailcraftCraftingManager;

public class Integration 
{	
	public static void loadRailCraft()
	{
		RailcraftCraftingManager.blastFurnace.addRecipe(RCMM.ObsidianBucket.itemID, 1280, new ItemStack(Item.bucketLava, 1));
	}
}
