package Reactioncraft.bookcase.common;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import Reactioncraft.base.common.RCB;

public class BlockBookcaseMulti extends Block
{
    public BlockBookcaseMulti(int var1, Material var2)
    {
        super(var1, var2);
        this.setCreativeTab(RCB.Reactioncraft);
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int var1, Random var2, int var3)
    {
        switch (var1)
        {
            case 0:
                return RCBB.bookcasemeta.blockID;

            case 1:
                return RCBB.bookcasemeta.blockID;

            case 2:
                return RCBB.bookcasemeta.blockID;

            case 3:
                return RCBB.bookcasemeta.blockID;

            case 4:
                return RCBB.bookcasemeta.blockID;

            case 5:
                return RCBB.bookcasemeta.blockID;

            case 6:
                return RCBB.bookcasemeta.blockID;

            case 7:
                return RCBB.bookcasemeta.blockID;

            case 8:
                return RCBB.bookcasemeta.blockID;

            case 9:
                return RCBB.bookcasemeta.blockID;

            case 10:
                return RCBB.bookcasemeta.blockID;

            case 11:
                return RCBB.bookcasemeta.blockID;

            case 12:
                return RCBB.bookcasemeta.blockID;

            case 13:
                return RCBB.bookcasemeta.blockID;

            case 14:
                return RCBB.bookcasemeta.blockID;

            case 15:
                return RCBB.bookcasemeta.blockID;

            default:
                return RCBB.bookcasemeta.blockID;
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
                        return 2;

                    case 1:
                        return 2;

                    case 2:
                        return 1;

                    case 3:
                        return 1;

                    case 4:
                        return 1;

                    case 5:
                        return 1;
                }

            case 1:
                switch (var1)
                {
                    case 0:
                        return 2;

                    case 1:
                        return 2;

                    case 2:
                        return 3;

                    case 3:
                        return 3;

                    case 4:
                        return 3;

                    case 5:
                        return 3;
                }

            case 2:
                switch (var1)
                {
                    case 0:
                        return 2;

                    case 1:
                        return 2;

                    case 2:
                        return 4;

                    case 3:
                        return 4;

                    case 4:
                        return 4;

                    case 5:
                        return 4;
                }

            case 3:
                switch (var1)
                {
                    case 0:
                        return 2;

                    case 1:
                        return 2;

                    case 2:
                        return 247;

                    case 3:
                        return 247;

                    case 4:
                        return 247;

                    case 5:
                        return 247;
                }

            case 4:
                switch (var1)
                {
                    case 0:
                        return 2;

                    case 1:
                        return 2;

                    case 2:
                        return 248;

                    case 3:
                        return 248;

                    case 4:
                        return 248;

                    case 5:
                        return 248;
                }

            case 5:
                switch (var1)
                {
                    case 0:
                        return 2;

                    case 1:
                        return 2;

                    case 2:
                        return 249;

                    case 3:
                        return 249;

                    case 4:
                        return 249;

                    case 5:
                        return 249;
                }

            case 6:
                switch (var1)
                {
                    case 0:
                        return 2;

                    case 1:
                        return 2;

                    case 2:
                        return 251;

                    case 3:
                        return 251;

                    case 4:
                        return 251;

                    case 5:
                        return 251;
                }

            case 7:
                switch (var1)
                {
                    case 0:
                        return 2;

                    case 1:
                        return 2;

                    case 2:
                        return 252;

                    case 3:
                        return 252;

                    case 4:
                        return 252;

                    case 5:
                        return 252;
                }

            case 8:
                switch (var1)
                {
                    case 0:
                        return 2;

                    case 1:
                        return 2;

                    case 2:
                        return 253;

                    case 3:
                        return 253;

                    case 4:
                        return 253;

                    case 5:
                        return 253;
                }

            case 9:
                switch (var1)
                {
                    case 0:
                        return 164;

                    case 1:
                        return 164;

                    case 2:
                        return 171;

                    case 3:
                        return 171;

                    case 4:
                        return 171;

                    case 5:
                        return 171;
                }

            case 10:
                switch (var1)
                {
                    case 0:
                        return 164;

                    case 1:
                        return 164;

                    case 2:
                        return 163;

                    case 3:
                        return 163;

                    case 4:
                        return 163;

                    case 5:
                        return 163;
                }

            case 11:
                switch (var1)
                {
                    case 0:
                        return 2;

                    case 1:
                        return 2;

                    case 2:
                        return 93;

                    case 3:
                        return 93;

                    case 4:
                        return 93;

                    case 5:
                        return 93;
                }

            case 12:
                return 164;

            case 13:
                switch (var1)
                {
                    case 0:
                        return 2;

                    case 1:
                        return 2;

                    case 2:
                        return 74;

                    case 3:
                        return 74;

                    case 4:
                        return 74;

                    case 5:
                        return 74;
                }

            case 14:
                switch (var1)
                {
                    case 0:
                        return 2;

                    case 1:
                        return 2;

                    case 2:
                        return 75;

                    case 3:
                        return 75;

                    case 4:
                        return 75;

                    case 5:
                        return 75;
                }

            case 15:
                switch (var1)
                {
                    case 0:
                        return 2;

                    case 1:
                        return 2;

                    case 2:
                        return 76;

                    case 3:
                        return 76;

                    case 4:
                        return 76;

                    case 5:
                        return 76;
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
    }

    public String getTextureFile()
    {
        return "/Reactioncraft/images/bookcases.png";
    }
}
