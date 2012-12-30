package Reactioncraft.christmas.common;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import Reactioncraft.base.common.RCB;

public class BlockChristmas extends Block
{
    public BlockChristmas(int var1, Material var2)
    {
        super(var1, var2);
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

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int var1, Random var2, int var3)
    {
        switch (var1)
        {
            case 0:
                return RCHRM.Christmasleaves.blockID;

            case 1:
                return RCHRM.Christmasleaves.blockID;

            case 2:
                return RCHRM.Christmasleaves.blockID;

            case 3:
                return RCHRM.Christmasleaves.blockID;

            case 4:
                return RCHRM.Christmasleaves.blockID;

            case 5:
                return RCHRM.Christmasleaves.blockID;

            case 6:
                return RCHRM.Christmasleaves.blockID;

            case 7:
                return RCHRM.Christmasleaves.blockID;

            case 8:
                return RCHRM.Christmasleaves.blockID;

            case 9:
                return RCHRM.Christmasleaves.blockID;

            case 10:
                return RCHRM.Christmasleaves.blockID;

            case 11:
                return RCHRM.Christmasleaves.blockID;

            case 12:
                return RCHRM.Christmasleaves.blockID;

            case 13:
                return RCHRM.Christmasleaves.blockID;

            case 14:
                return RCHRM.Christmasleaves.blockID;

            case 15:
                return RCHRM.Christmasleaves.blockID;

            default:
                return RCHRM.Christmasleaves.blockID;
        }
    }

    public int quantityDropped(int var1, int var2, Random var3)
    {
        switch (var1)
        {
            case 0:
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

            case 7:
                return 1;

            case 8:
                return 1;

            case 9:
                return 1;

            case 10:
                return 1;

            case 11:
                return 1;

            case 12:
                return 1;

            case 13:
                return 1;

            case 14:
                return 1;

            case 15:
                return 1;

            default:
                return 1;
        }
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int var1)
    {
        switch (var1)
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

            default:
                return 0;
        }
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public int getBlockTextureFromSideAndMetadata(int var1, int var2)
    {
        switch (var2)
        {
            case 0:
                switch (var1)
                {
                    case 0:
                        return 28;

                    case 1:
                        return 28;

                    case 2:
                        return 28;

                    case 3:
                        return 28;

                    case 4:
                        return 28;

                    case 5:
                        return 28;
                }

            case 1:
                switch (var1)
                {
                    case 0:
                        return 20;

                    case 1:
                        return 20;

                    case 2:
                        return 20;

                    case 3:
                        return 20;

                    case 4:
                        return 20;

                    case 5:
                        return 20;
                }

            case 2:
                switch (var1)
                {
                    case 0:
                        return 21;

                    case 1:
                        return 21;

                    case 2:
                        return 21;

                    case 3:
                        return 21;

                    case 4:
                        return 21;

                    case 5:
                        return 21;
                }

            case 3:
                switch (var1)
                {
                    case 0:
                        return 22;

                    case 1:
                        return 22;

                    case 2:
                        return 22;

                    case 3:
                        return 22;

                    case 4:
                        return 22;

                    case 5:
                        return 22;
                }

            case 4:
                switch (var1)
                {
                    case 0:
                        return 23;

                    case 1:
                        return 23;

                    case 2:
                        return 23;

                    case 3:
                        return 23;

                    case 4:
                        return 23;

                    case 5:
                        return 23;
                }

            case 5:
                switch (var1)
                {
                    case 0:
                        return 24;

                    case 1:
                        return 24;

                    case 2:
                        return 24;

                    case 3:
                        return 24;

                    case 4:
                        return 24;

                    case 5:
                        return 24;
                }

            case 6:
                switch (var1)
                {
                    case 0:
                        return 29;

                    case 1:
                        return 29;

                    case 2:
                        return 29;

                    case 3:
                        return 29;

                    case 4:
                        return 29;

                    case 5:
                        return 29;
                }

            case 7:
                switch (var1)
                {
                    case 0:
                        return 30;

                    case 1:
                        return 30;

                    case 2:
                        return 30;

                    case 3:
                        return 30;

                    case 4:
                        return 30;

                    case 5:
                        return 30;
                }

            case 8:
                switch (var1)
                {
                    case 0:
                        return 31;

                    case 1:
                        return 31;

                    case 2:
                        return 31;

                    case 3:
                        return 31;

                    case 4:
                        return 31;

                    case 5:
                        return 31;
                }

            case 9:
                switch (var1)
                {
                    case 0:
                        return 32;

                    case 1:
                        return 32;

                    case 2:
                        return 32;

                    case 3:
                        return 32;

                    case 4:
                        return 32;

                    case 5:
                        return 32;
                }

            case 10:
                switch (var1)
                {
                    case 0:
                        return 33;

                    case 1:
                        return 33;

                    case 2:
                        return 33;

                    case 3:
                        return 33;

                    case 4:
                        return 33;

                    case 5:
                        return 33;
                }

            case 11:
                switch (var1)
                {
                    case 0:
                        return 34;

                    case 1:
                        return 34;

                    case 2:
                        return 34;

                    case 3:
                        return 34;

                    case 4:
                        return 34;

                    case 5:
                        return 34;
                }

            case 12:
                return 164;

            case 13:
                switch (var1)
                {
                    case 0:
                        return 35;

                    case 1:
                        return 35;

                    case 2:
                        return 35;

                    case 3:
                        return 35;

                    case 4:
                        return 35;

                    case 5:
                        return 35;
                }

            case 14:
                switch (var1)
                {
                    case 0:
                        return 36;

                    case 1:
                        return 36;

                    case 2:
                        return 36;

                    case 3:
                        return 36;

                    case 4:
                        return 36;

                    case 5:
                        return 36;
                }

            case 15:
                switch (var1)
                {
                    case 0:
                        return 38;

                    case 1:
                        return 38;

                    case 2:
                        return 38;

                    case 3:
                        return 38;

                    case 4:
                        return 38;

                    case 5:
                        return 38;
                }

            default:
                return var2;
        }
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    public void getSubBlocks(int var1, CreativeTabs var2, List var3)
    {
        var3.add(new ItemStack(var1, 1, 0));
        var3.add(new ItemStack(var1, 1, 1));
        var3.add(new ItemStack(var1, 1, 2));
        var3.add(new ItemStack(var1, 1, 3));
        var3.add(new ItemStack(var1, 1, 4));
        var3.add(new ItemStack(var1, 1, 5));
        var3.add(new ItemStack(var1, 1, 6));
        var3.add(new ItemStack(var1, 1, 7));
        var3.add(new ItemStack(var1, 1, 8));
        var3.add(new ItemStack(var1, 1, 9));
        var3.add(new ItemStack(var1, 1, 10));
        var3.add(new ItemStack(var1, 1, 11));
        var3.add(new ItemStack(var1, 1, 12));
        var3.add(new ItemStack(var1, 1, 13));
        var3.add(new ItemStack(var1, 1, 14));
        var3.add(new ItemStack(var1, 1, 15));
    }

    public String getTextureFile()
    {
        return "/Reactioncraft/images/ChristmasBlocks.png";
    }

    public boolean canMineBlock(World var1, int var2, int var3, int var4, EntityMinecart var5, ItemStack var6)
    {
        return true;
    }
}
