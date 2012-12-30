package Reactioncraft.christmas.common;

import java.util.Random;

import Reactioncraft.base.common.RCB;
import Reactioncraft.basic.common.BlockBasic;

public class BlockStar extends BlockBasic
{
    public BlockStar(int var1, int var2)
    {
        super(var1, var2);
        this.setCreativeTab(RCB.Reactioncraft);
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube()
    {
        return false;
    }

    public String getTextureFile()
    {
        return "/Reactioncraft/images/ChristmasBlocks.png";
    }

    public int idDropped(int var1, Random var2)
    {
        return blockID;
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random var1)
    {
        return 1;
    }

    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return 1;
    }
}
