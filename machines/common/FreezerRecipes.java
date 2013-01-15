package Reactioncraft.machines.common;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Reactioncraft.api.common.FreezerRecipesInterface;
import Reactioncraft.machines.common.*;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

public class FreezerRecipes implements FreezerRecipesInterface
{
    private static final FreezerRecipesInterface smeltingBase = new FreezerRecipes();

    /** The list of smelting results. */
    private Map smeltingList = new HashMap();
    private Map experienceList = new HashMap();
    private HashMap<List<Integer>, ItemStack> metaSmeltingList = new HashMap<List<Integer>, ItemStack>();
    private HashMap<List<Integer>, Float> metaExperience = new HashMap<List<Integer>, Float>();

    /**
     * Used to call methods addSmelting and getSmeltingResult.
     */
    public static final FreezerRecipesInterface smelting()
    {
        return smeltingBase;
    }

    private FreezerRecipes()
    {
        this.addSmelting(Item.bucketEmpty.itemID, new ItemStack(RCMM.IceBucket), 0.7F);
    }

    /* (non-Javadoc)
	 * @see Reactioncraft.machines.common.FreezerRecipesInterface#addSmelting(int, net.minecraft.item.ItemStack, float)
	 */
    @Override
	public void addSmelting(int par1, ItemStack par2ItemStack, float par3)
    {
        this.smeltingList.put(Integer.valueOf(par1), par2ItemStack);
        this.experienceList.put(Integer.valueOf(par2ItemStack.itemID), Float.valueOf(par3));
    }

    /* (non-Javadoc)
	 * @see Reactioncraft.machines.common.FreezerRecipesInterface#getSmeltingResult(int)
	 */
    @Override
	@Deprecated
    public ItemStack getSmeltingResult(int par1)
    {
        return (ItemStack)this.smeltingList.get(Integer.valueOf(par1));
    }

    /* (non-Javadoc)
	 * @see Reactioncraft.machines.common.FreezerRecipesInterface#getSmeltingList()
	 */
    @Override
	public Map getSmeltingList()
    {
        return this.smeltingList;
    }

    /* (non-Javadoc)
	 * @see Reactioncraft.machines.common.FreezerRecipesInterface#getExperience(int)
	 */
    @Override
	@Deprecated //In favor of ItemStack sensitive version
    public float getExperience(int par1)
    {
        return this.experienceList.containsKey(Integer.valueOf(par1)) ? ((Float)this.experienceList.get(Integer.valueOf(par1))).floatValue() : 0.0F;
    }

    /* (non-Javadoc)
	 * @see Reactioncraft.machines.common.FreezerRecipesInterface#addSmelting(int, int, net.minecraft.item.ItemStack)
	 */
    @Override
	@Deprecated //In favor of the exp version, will remove next major MC version.
    public void addSmelting(int itemID, int metadata, ItemStack itemstack)
    {
        addSmelting(itemID, metadata, itemstack, 0.0f);
    }

    /* (non-Javadoc)
	 * @see Reactioncraft.machines.common.FreezerRecipesInterface#addSmelting(int, int, net.minecraft.item.ItemStack, float)
	 */
    @Override
	public void addSmelting(int itemID, int metadata, ItemStack itemstack, float experience)
    {
        metaSmeltingList.put(Arrays.asList(itemID, metadata), itemstack);
        metaExperience.put(Arrays.asList(itemID, metadata), experience);
    }

    /* (non-Javadoc)
	 * @see Reactioncraft.machines.common.FreezerRecipesInterface#getSmeltingResult(net.minecraft.item.ItemStack)
	 */
    @Override
	public ItemStack getSmeltingResult(ItemStack item) 
    {
        if (item == null)
        {
            return null;
        }
        ItemStack ret = (ItemStack)metaSmeltingList.get(Arrays.asList(item.itemID, item.getItemDamage()));
        if (ret != null) 
        {
            return ret;
        }
        return (ItemStack)smeltingList.get(Integer.valueOf(item.itemID));
    }

    /* (non-Javadoc)
	 * @see Reactioncraft.machines.common.FreezerRecipesInterface#getExperience(net.minecraft.item.ItemStack)
	 */
    @Override
	public float getExperience(ItemStack item)
    {
        if (item == null || item.getItem() == null)
        {
            return 0;
        }
        float ret = item.getItem().getSmeltingExperience(item);
        if (ret < 0 && metaExperience.containsKey(Arrays.asList(item.itemID, item.getItemDamage())))
        {
            ret = metaExperience.get(Arrays.asList(item.itemID, item.getItemDamage()));
        }
        if (ret < 0 && experienceList.containsKey(item.itemID))
        {
            ret = ((Float)experienceList.get(item.itemID)).floatValue();
        }
        return (ret < 0 ? 0 : ret);
    }
}
