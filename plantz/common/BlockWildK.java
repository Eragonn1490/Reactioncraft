package Reactioncraft.plantz.common;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import Reactioncraft.base.common.RCB;

public class BlockWildK extends BlockFlower
{
    public BlockWildK(int par1, int par2)
    {
    	super(par1, par2);
        this.blockIndexInTexture = par2;
        this.setHardness(0.0F);
        float var4 = 0.2F;
        this.setBlockBounds(0.5F - var4, 0.0F, 0.5F - var4, 0.5F + var4, var4 * 3.0F, 0.5F + var4);
        this.setCreativeTab(RCB.Reactioncraft);
    }
    
    //Start Eragonn V2.0 code
    
    /**
     * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
     */
    @Override
    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
    {
        return super.canPlaceBlockAt(par1World, par2, par3, par4) && canBlockStay(par1World, par2, par3, par4);
    }

    /**
     * Gets passed in the blockID of the block below and supposed to return true if its allowed to grow on the type of
     * blockID passed in. Args: blockID
     */
    public boolean canThisPlantGrowOnThisBlockID(int par1)
    {
        return par1 == Block.grass.blockID || par1 == Block.dirt.blockID || par1 == Block.tilledField.blockID || par1 == Block.sand.blockID;
    }
    
    

	/**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        return null;
    }
    
    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }
    
    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }
    
    @Override
    public String getTextureFile()
    {
  		return "/Reactioncraft/images/plants.png"; //return the block texture where the block texture is saved in
 	}
    //End Eragonn Code segment 2
    
    /**
     * The type of render function that is called for this block
     */
    @Override
    public int getRenderType()
    {
        return 1;
    }
    
    @Override
    public int idDropped(int par1, Random par2Random, int par3)
    {
       
            int w = par2Random.nextInt(60);
            if (w == 0)
            {
                return RcPlantz.Toke.itemID;
            }
            if (w == 15)
            {
                return RcPlantz.OKSeed.itemID;
            }
            if (w == 20)
            {
                return RcPlantz.LKSeed.itemID;
            }
            if (w == 35)
            {
                return RcPlantz.FireSeed.itemID;
            }
            if (w == 40)
            {
                return  RcPlantz.CrystalSeed.itemID;
            }
            if (w == 55)
            {
                return  RcPlantz.BYYSeed.itemID;
            }
            if (w == 60)
            {
                return  RcPlantz.BlueDreamSeed.itemID;
            }
            else
            {
                return RcPlantz.WildKSeed.itemID;
            }         
    }

    public int quantityDroppedWithBonus(int par1, Random par2Random)
    {
        return quantityDropped(par2Random) + par2Random.nextInt(par1 + 1);
    }

    public int quantityDropped(Random par1Random)
    {
        return 1 + par1Random.nextInt(2); //replace 1 to a higher number if you want to drop more
    }
}
