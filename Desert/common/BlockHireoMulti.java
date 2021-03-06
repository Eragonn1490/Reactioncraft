package Reactioncraft.Desert.common;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import Reactioncraft.base.common.RCB;

public class BlockHireoMulti extends Block
{
    public BlockHireoMulti(int i, Material material)
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
            case 0:
                return RCBDM.HireoMulti.blockID;

            case 1:
                return RCBDM.HireoMulti.blockID;

            case 2:
                return RCBDM.HireoMulti.blockID;

            case 3:
                return RCBDM.HireoMulti.blockID;

            case 4:
                return RCBDM.HireoMulti.blockID;

            case 5:
                return RCBDM.HireoMulti.blockID;

            case 6:
                return RCBDM.HireoMulti.blockID;

            case 7:
                return RCBDM.HireoMulti.blockID;

            case 8:
                return RCBDM.HireoMulti.blockID;

            case 9:
                return RCBDM.HireoMulti.blockID;

            case 10:
                return RCBDM.HireoMulti.blockID;

            case 11:
                return RCBDM.HireoMulti.blockID;

            case 12:
                return RCBDM.HireoMulti.blockID;

            case 13:
                return RCBDM.HireoMulti.blockID;
                
            case 14:
                return RCBDM.HireoMulti.blockID;
                
            case 15:
                return RCBDM.HireoMulti.blockID;
        }

        return RCBDM.HireoMulti.blockID;
    }

    public int quantityDropped(int i, int j, Random random)
    {
        switch (i)
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
        }

        return 1;
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int i)
    {
        switch (i)
        {
            case 0:
                return 11;

            case 1:
                return 11;

            case 2:
                return 11;

            case 3:
                return 11;

            case 4:
                return 11;

            case 5:
                return 11;

            case 6:
                return 11;

            case 7:
                return 11;

            case 8:
                return 11;

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
                switch (i)
                {
                    case 0:
                        return 138;

                    case 1:
                        return 138;

                    case 2:
                        return 145;

                    case 3:
                        return 145;

                    case 4:
                        return 145;

                    case 5:
                        return 145;
                }

            case 1:
                switch (i)
                {
                    case 0:
                        return 138;

                    case 1:
                        return 138;

                    case 2:
                        return 147;

                    case 3:
                        return 147;

                    case 4:
                        return 147;

                    case 5:
                        return 147;
                }

            case 2:
                switch (i)
                {
                    case 0:
                        return 138;

                    case 1:
                        return 138;

                    case 2:
                        return 148;

                    case 3:
                        return 148;

                    case 4:
                        return 148;

                    case 5:
                        return 148;
                }

            case 3:
                switch (i)
                {
                    case 0:
                        return 138;

                    case 1:
                        return 138;

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
                switch (i)
                {
                    case 0:
                        return 138;

                    case 1:
                        return 138;

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
                switch (i)
                {
                    case 0:
                        return 138;

                    case 1:
                        return 138;

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
                switch (i)
                {
                    case 0:
                        return 138;

                    case 1:
                        return 138;

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
                switch (i)
                {
                    case 0:
                        return 138;

                    case 1:
                        return 138;

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
                switch (i)
                {
                    case 0:
                        return 138;

                    case 1:
                        return 138;

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
                switch (i)
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
                switch (i)
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
                switch (i)
                {
                    case 0:
                        return 138;

                    case 1:
                        return 138;

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
                switch (i)
                {
                    case 0:
                        return 138;

                    case 1:
                        return 138;

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
                switch (i)
                {
                    case 0:
                        return 138;

                    case 1:
                        return 138;

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
                switch (i)
                {
                    case 0:
                        return 138;

                    case 1:
                        return 138;

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
                return j;
        }
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

    public boolean canMineBlock(World world, int i, int j, int k, EntityMinecart entityminecart, ItemStack itemstack)
    {
        return true;
    }
}
