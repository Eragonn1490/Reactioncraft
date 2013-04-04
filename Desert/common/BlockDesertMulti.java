package Reactioncraft.Desert.common;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import Reactioncraft.base.common.RCB;

public class BlockDesertMulti extends Block
{
    public BlockDesertMulti(int i, Material material)
    {
        super(i, material);
        this.setCreativeTab(RCB.Reactioncraft);
    }


    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int i, Random random, int j)
    {
        switch (i)
        {
            default:
                return RCBDM.DesertBlockMulti.blockID;

            case 1:
                return blockID;

            case 2:
                return blockID;

            case 3:
                return blockID;

            case 4:
                return blockID;

            case 5:
                return blockID;

            case 6:
                return blockID;
        }
    }

    public int quantityDropped(int i, int j, Random random)
    {
        switch (i)
        {
            default:
                return 1;

            case 1:
                return 1;

            case 2:
                return 1;

            case 3:
                return 1;

            case 4:
                return 1;

            case 5:
                return 1;

            case 6:
                return 1;
        }
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int i)
    {
        switch (i)
        {
            default:
                return 0;

            case 1:
                return 1;

            case 2:
                return 1;

            case 3:
                return 4;

            case 4:
                return 4;

            case 5:
                return 5;

            case 6:
                return 6;
                
//            case 7:
//                return 7;
        }
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
        switch (j)
        {
            case 0:
                return 138;

            case 1:
                return 95;

            case 2:
                return 137;

            case 3:
                return 139;

            case 4:
                return 62;

            case 5:
                return 79;

//            case 6:
//                return 215;
//
//            case 7:
//                return 76;
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
//    	list.add(new ItemStack(i,1,6));
//    	list.add(new ItemStack(i,1,7));
//    	list.add(new ItemStack(i,1,8));
//    	list.add(new ItemStack(i,1,9));
//    	list.add(new ItemStack(i,1,10));
//    	list.add(new ItemStack(i,1,11));
//    	list.add(new ItemStack(i,1,12));
//    	list.add(new ItemStack(i,1,13));
//    	list.add(new ItemStack(i,1,14));
//    	list.add(new ItemStack(i,1,15));
    }
    
    public String getTextureFile()
    {
        return "/Reactioncraft/images/Blocks.png";
    }
}
