package Reactioncraft.Desert.common;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import Reactioncraft.base.common.RCB;

public class BlockColumnMulti extends Block
{
    public BlockColumnMulti(int i, Material material)
    {
        super(i, material);
        float f = 0.375F;
        setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 1.0F, 0.5F + f);
        this.setCreativeTab(RCB.Reactioncraft);
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube()
    {
        return false;
    }

    public float getHardness(int i)
    {
        switch (i)
        {
            default:
                return 3F;

            case 1:
                return 3F;

            case 2:
                return 70F;

            case 3:
                return 1.5F;

            case 4:
                return 2.0F;

            case 5:
                return 3F;

            case 6:
                return 0.8F;
        }
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int i, Random random, int j)
    {
        switch (i)
        {
            default:
                return RCBDM.ColumnMulti.blockID;

            case 1:
                return RCBDM.ColumnMulti.blockID;

            case 2:
                return RCBDM.ColumnMulti.blockID;

            case 3:
                return RCBDM.ColumnMulti.blockID;

            case 4:
                return RCBDM.ColumnMulti.blockID;

            case 5:
                return RCBDM.ColumnMulti.blockID;

            case 6:
                return RCBDM.ColumnMulti.blockID;
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
                return 2;

            case 3:
                return Block.cobblestone.blockID;

            case 4:
                return Block.cobblestone.blockID;

            case 5:
                return 5;

            case 6:
                return Block.sandStone.blockID;
                
            case 7:
                return Block.stoneBrick.blockID;
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
                return 92;

            case 1:
                return 164;

            case 2:
                return 84;

            case 3:
                return 53;

            case 4:
                return 54;

            case 5:
                return 214;

            case 6:
                return 215;

            case 7:
                return 78;
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
