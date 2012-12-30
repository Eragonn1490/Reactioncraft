package Reactioncraft.Desert.common;

import java.util.List;
import java.util.Random;

import Reactioncraft.base.common.RCB;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class BlockCactusMulti extends BlockFlower
{
    public BlockCactusMulti(int i, Material material)
    {
        super(i, i, material);
        setTickRandomly(true);
        this.setCreativeTab(RCB.Reactioncraft);
        float f = 0.2F;
        setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 3F, 0.5F + f);
    }

    /**
     * Triggered whenever an entity collides with this block (enters into the block). Args: world, x, y, z, entity
     */
    public void onEntityCollidedWithBlock(World world, int i, int j, int k, Entity entity)
    {
        entity.attackEntityFrom(DamageSource.cactus, 1);
    }

    /**
     * Gets passed in the blockID of the block below and supposed to return true if its allowed to grow on the type of
     * blockID passed in. Args: blockID
     */
    protected boolean canThisPlantGrowOnThisBlockID(int i)
    {
        return i == Block.sandStone.blockID || i == Block.sand.blockID || i == Block.tilledField.blockID || i == RCBDM.DarkSand.blockID;
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
        return null;
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

    public float getHardness(int i)
    {
        switch (i)
        {
            case 0:
                return 0.1F;
        }

        return 0.1F;
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int i, Random random, int j)
    {
        switch (i)
        {
            case 0:
                return RCBDM.CactusMulti.blockID;

            case 1:
                return RCBDM.CactusMulti.blockID;
        }

        return RCBDM.CactusMulti.blockID;
    }

    public int quantityDropped(int i, int j, Random random)
    {
        switch (i)
        {
            case 0:
                return 1;

            case 1:
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
                return 0;

            case 1:
                return 1;
        }

        return i;
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
        switch (j)
        {
            case 0:
                return 46;

            case 1:
                return 45;
        }

        return j;
    }

    public void getSubBlocks(int i,CreativeTabs tab, List list)
    {
    	list.add(new ItemStack(i,1,0));
    	list.add(new ItemStack(i,1,1));
    }
    
    @Override
    public String getTextureFile()
    {
        return "/Reactioncraft/images/Blocks.png";
    }
}
