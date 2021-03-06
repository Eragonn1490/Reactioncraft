package Reactioncraft.plants.common;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

public class BlockReed1 extends Block implements IPlantable
{
    public BlockReed1(int var1, int var2)
    {
        super(var1, Material.plants);
        float var3 = 0.375F;
        this.setBlockBounds(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, 1.0F, 0.5F + var3);
        this.setTickRandomly(true);
    }
    
   	public String getTextureFile() 
    {
   		return "/Reactioncraft/images/terrain.png";
   	}
    
    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public int getBlockTextureFromSideAndMetadata(int var1, int var2)
    {
        return 73;
    }

//    public int idDropped(int var1, int var2, Random var3)
//    {
//        return Item.reed.itemID;
//    }
//
//    public int idDropped(int var1, Random var2)
//    {
//    	return Item.reed.itemID;
//    }
//
//    /**
//     * Returns the ID of the items to drop on destruction.
//     */
//    public int idDropped(int var1, Random var2, int var3)
//    {
//    	return Item.reed.itemID;
//    }
    
    @Override
    public int idDropped(int par1, Random par2Random, int par3)
    {
       
            int w = par2Random.nextInt(65);
            if (w == 0)
            {
                return Item.reed.itemID;
            }
            if (w == 15)
            {
                return Item.reed.itemID;
            }
            if (w == 20)
            {
                return Item.reed.itemID;
            }
            if (w == 35)
            {
                return Item.reed.itemID;
            }
            if (w == 40)
            {
                return  Item.reed.itemID;
            }
            if (w == 55)
            {
                return  Item.reed.itemID;
            }
            if (w == 60)
            {
                return  RCPM.sugarcaneItem.itemID;
            }
            else
            {
                return Item.reed.itemID;
            }         
    }
    
    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random var1)
    {
        return 1;
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor blockID
     */
    public void onNeighborBlockChange(World var1, int var2, int var3, int var4, int var5)
    {
        this.checkBlockCoordValid(var1, var2, var3, var4);
    }

    protected final void checkBlockCoordValid(World var1, int var2, int var3, int var4)
    {
        if (!this.canBlockStay(var1, var2, var3, var4))
        {
            this.dropBlockAsItem_do(var1, var2, var3, var4, new ItemStack(Item.reed, 1));
            var1.setBlockWithNotify(var2, var3, var4, 0);
        }
    }

    /**
     * Can this block stay at this position.  Similar to canPlaceBlockAt except gets checked often with plants.
     */
    public boolean canBlockStay(World var1, int var2, int var3, int var4)
    {
        return this.canPlaceBlockAt(var1, var2, var3, var4);
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World var1, int var2, int var3, int var4)
    {
        return null;
    }

    /**
     * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
     */
    public boolean canPlaceBlockAt(World var1, int var2, int var3, int var4)
    {
        boolean var5 = false;
        int var6 = var1.getBlockId(var2, var3 - 1, var4);

        if (var6 == Block.grass.blockID || var6 == Block.dirt.blockID || var6 == Block.gravel.blockID || var6 == Block.sand.blockID || var6 == this.blockID)
        {
            var5 = true;
        }

        return var5;
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World var1, int var2, int var3, int var4, Random var5)
    {
        if (var1.isAirBlock(var2, var3 + 1, var4))
        {
            int var6;

            for (var6 = 1; var1.getBlockId(var2, var3 - var6, var4) == this.blockID; ++var6)
            {
                ;
            }

            if (var6 < 10)
            {
                int var7 = var1.getBlockMetadata(var2, var3, var4);

                if (var7 == 15)
                {
                    var1.setBlockWithNotify(var2, var3 + 1, var4, this.blockID);
                    var1.setBlockMetadataWithNotify(var2, var3, var4, 0);
                }
                else if (var1.getBlockLightValue(var2, var3 + 1, var4) >= 9 && this.nearWater(var1, var2, var3, var4))
                {
                    var1.setBlockMetadataWithNotify(var2, var3, var4, var7 + 1);
                }
            }
        }
    }

    public boolean nearWater(World var1, int var2, int var3, int var4)
    {
        boolean var5 = false;

        if (var1.getBlockId(var2, var3 - 1, var4) == this.blockID && this.nearWater(var1, var2, var3 - 1, var4))
        {
            var5 = true;
        }
        else if (var1.getBlockMaterial(var2 - 1, var3 - 1, var4) == Material.water)
        {
            var5 = true;
        }
        else if (var1.getBlockMaterial(var2 + 1, var3 - 1, var4) == Material.water)
        {
            var5 = true;
        }
        else if (var1.getBlockMaterial(var2, var3 - 1, var4 - 1) == Material.water)
        {
            var5 = true;
        }
        else if (var1.getBlockMaterial(var2, var3 - 1, var4 + 1) == Material.water)
        {
            var5 = true;
        }

        return var5;
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
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return 1;
    }

    @Override
    public EnumPlantType getPlantType(World world, int x, int y, int z)
    {
        return EnumPlantType.Beach;
    }

    @Override
    public int getPlantID(World world, int x, int y, int z)
    {
        return blockID;
    }

    @Override
    public int getPlantMetadata(World world, int x, int y, int z)
    {
        return world.getBlockMetadata(x, y, z);
    }
}
