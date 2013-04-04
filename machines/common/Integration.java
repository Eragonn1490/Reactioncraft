package Reactioncraft.machines.common;

import cpw.mods.fml.common.registry.GameRegistry;
import Reactioncraft.Desert.common.RCBDM;
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

	public static void loadReactioncraft() 
	{
		GameRegistry.addRecipe(new ItemStack(RCMM.BrickOvenIdle, 1), new Object[]{"XXX","X X", "XXX", Character.valueOf('X'), new ItemStack(RCBDM.DesertBlockMulti, 1, 3)});
		BrickOvenRecipes.smelting().addSmelting(RCBDM.DarkSand.blockID, new ItemStack(RCBDM.SandStonePaste, 4), 0.1F);
	}
}
