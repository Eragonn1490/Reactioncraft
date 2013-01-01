package Reactioncraft.ore.common;

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
	public static void loadIndustrialCraft()
	{
		//Bloodstone block to bloodstone dust
		Ic2Recipes.addMaceratorRecipe(new ItemStack(RCORES.netherOres, 1, 0), new ItemStack(RCORES.OreItems, 3, 6));
		
		//Black Diamond Ore to Black Diamond
		Ic2Recipes.addMaceratorRecipe(new ItemStack(RCORES.netherOres, 1, 1), new ItemStack(RCORES.OreItems, 1, 2));

		//Dragonstone to Dragonstone Shard
		Ic2Recipes.addMaceratorRecipe(new ItemStack(RCORES.netherOres, 1, 2), new ItemStack(RCORES.OreItems, 3, 7));

		//Magmastone to magmastone flint
		Ic2Recipes.addMaceratorRecipe(new ItemStack(RCORES.surfaceOres, 1, 2), new ItemStack(RCORES.magmaflint, 10));

		//Iron Ingot to IronDust
		Ic2Recipes.addMaceratorRecipe(new ItemStack(Item.ingotIron, 1, 0), new ItemStack(RCORES.OreItems, 10));
	}
}
