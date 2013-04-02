package Reactioncraft.ore.common;

import Reactioncraft.Desert.common.RCBDM;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import ic2.api.Ic2Recipes;

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

	public static void loadReactioncraft() 
	{
		GameRegistry.addShapelessRecipe(new ItemStack(RCORES.OreItems, 1, 8), new Object[]{new ItemStack(RCORES.OreItems,1,7),new ItemStack(RCBDM.FlintChisel,1,-1)});
		GameRegistry.addShapelessRecipe(new ItemStack(RCORES.OreItems, 1, 8), new Object[]{new ItemStack(RCORES.OreItems,1,7),new ItemStack(RCBDM.GoldChisel,1,-1)});
		GameRegistry.addShapelessRecipe(new ItemStack(RCORES.OreItems, 1, 8), new Object[]{new ItemStack(RCORES.OreItems,1,7),new ItemStack(RCBDM.CopperChisel,1,-1)});
		GameRegistry.addShapelessRecipe(new ItemStack(RCORES.OreItems, 1, 8), new Object[]{new ItemStack(RCORES.OreItems,1,7),new ItemStack(RCBDM.DiamondChisel,1,-1)});
		GameRegistry.addShapelessRecipe(new ItemStack(RCORES.OreItems, 1, 8), new Object[]{new ItemStack(RCORES.OreItems,1,7),new ItemStack(RCBDM.BloodstoneChisel,1,-1)});
	}
}
