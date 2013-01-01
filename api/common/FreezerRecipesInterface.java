package Reactioncraft.api.common;

import java.util.Map;

import net.minecraft.item.ItemStack;

/**
*
* @author Eragonn1490
* 
**/
public interface FreezerRecipesInterface 
{
	
	/**
	 * Adds a smelting recipe.
	 */
	public void addSmelting(int par1, ItemStack par2ItemStack,
			float par3);

	/**
	 * Returns the smelting result of an item.
	 * Deprecated in favor of a metadata sensitive version
	 */
	@Deprecated
	public ItemStack getSmeltingResult(int par1);

	public Map getSmeltingList();

	@Deprecated
	//In favor of ItemStack sensitive version
	public float getExperience(int par1);

	/**
	 * Add a metadata-sensitive furnace recipe
	 * @param itemID The Item ID
	 * @param metadata The Item Metadata
	 * @param itemstack The ItemStack for the result
	 */
	@Deprecated
	//In favor of the exp version, will remove next major MC version.
	public void addSmelting(int itemID, int metadata,
			ItemStack itemstack);

	/**
	 * A metadata sensitive version of adding a furnace recipe.
	 */
	public void addSmelting(int itemID, int metadata,
			ItemStack itemstack, float experience);

	/**
	 * Used to get the resulting ItemStack form a source ItemStack
	 * @param item The Source ItemStack
	 * @return The result ItemStack
	 */
	public ItemStack getSmeltingResult(ItemStack item);

	/**
	 * Grabs the amount of base experience for this item to give when pulled from the furnace slot.
	 */
	public float getExperience(ItemStack item);

}