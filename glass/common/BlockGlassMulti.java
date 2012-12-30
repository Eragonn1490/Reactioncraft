package Reactioncraft.glass.common;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import Reactioncraft.base.common.RCB;

public class BlockGlassMulti extends Block
{
    public BlockGlassMulti(int i, Material material)
    {
        super(i, material);
        this.setCreativeTab(RCB.Reactioncraft);
    }

    protected boolean func_50074_q()
    {
        return true;
    }

    /**
     * Returns which pass should this block be rendered on. 0 for solids and 1 for alpha
     */
    public int getRenderBlockPass()
    {
        return 1;
    }
    
    protected boolean canSilkHarvest()
    {
        return true;
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube()
    {
        return false;
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int i, Random random, int j)
    {
        switch (i)
        {
            case 0:
                return RCG.GlassGlassMulti.blockID;

            case 1:
                return RCG.GlassGlassMulti.blockID;

            case 2:
                return RCG.GlassGlassMulti.blockID;

            case 3:
                return RCG.GlassGlassMulti.blockID;

            case 4:
                return RCG.GlassGlassMulti.blockID;

            case 5:
                return RCG.GlassGlassMulti.blockID;

            case 6:
                return RCG.GlassGlassMulti.blockID;

            case 7:
                return RCG.GlassGlassMulti.blockID;

            case 8:
                return RCG.GlassGlassMulti.blockID;

            case 9:
                return RCG.GlassGlassMulti.blockID;

            case 10:
                return RCG.GlassGlassMulti.blockID;

            case 11:
                return RCG.GlassGlassMulti.blockID;

            case 12:
                return RCG.GlassGlassMulti.blockID;

            case 13:
                return RCG.GlassGlassMulti.blockID;

            case 14:
                return RCG.GlassGlassMulti.blockID;

            case 15:
                return RCG.GlassGlassMulti.blockID;
        }

        return RCG.GlassGlassMulti.blockID;
    }

    public int quantityDropped(int i, int j, Random random)
    {
        switch (i)
        {
            case 0:
                return 0;

            case 1:
                return 0;

            case 2:
                return 0;

            case 3:
                return 0;

            case 4:
                return 0;

            case 5:
                return 0;

            case 6:
                return 0;

            case 7:
                return 0;

            case 8:
                return 0;

            case 9:
                return 0;

            case 10:
                return 0;

            case 11:
                return 0;

            case 12:
                return 0;

            case 13:
                return 0;

            case 14:
                return 0;

            case 15:
                return 0;
        }

        return 0;
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int i)
    {
        switch (i)
        {
            case 0:
                return 0;

            case 1:
                return 1;

            case 2:
                return 2;

            case 3:
                return 3;

            case 4:
                return 4;

            case 5:
                return 5;

            case 6:
                return 6;

            case 7:
                return 7;

            case 8:
                return 8;

            case 9:
                return 9;

            case 10:
                return 10;

            case 11:
                return 11;

            case 12:
                return 12;

            case 13:
                return 13;

            case 14:
                return 14;

            case 15:
                return 15;
        }

        return 0;
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
        switch (j)
        {
            case 0:
                return 224;

            case 1:
                return 221;

            case 2:
                return 225;

            case 3:
                return 226;

            case 4:
                return 227;

            case 5:
                return 228;

            case 6:
                return 229;

            case 7:
                return 230;

            case 8:
                return 231;

            case 9:
                return 232;

            case 10:
                return 233;

            case 11:
                return 234;

            case 12:
                return 235;

            case 13:
                return 236;

            case 14:
                return 237;

            case 15:
                return 219;
        }

        return j;
    }

    public void getSubBlocks(int i,CreativeTabs tab, List list)
    {
    	list.add(new ItemStack(i,1,0));
    	list.add(new ItemStack(i,1,1));
    	list.add(new ItemStack(i,1,2));
    	list.add(new ItemStack(i,1,3));
    	list.add(new ItemStack(i,1,4));
    	list.add(new ItemStack(i,1,5));
    	list.add(new ItemStack(i,1,6));
    	list.add(new ItemStack(i,1,7));
    	list.add(new ItemStack(i,1,8));
    	list.add(new ItemStack(i,1,9));
    	list.add(new ItemStack(i,1,10));
    	list.add(new ItemStack(i,1,11));
    	list.add(new ItemStack(i,1,12));
    	list.add(new ItemStack(i,1,13));
    	list.add(new ItemStack(i,1,14));
    	list.add(new ItemStack(i,1,15));
    }

    public String getTextureFile()
    {
        return "/Reactioncraft/images/Blocks.png";
    }
}
