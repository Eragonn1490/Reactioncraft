package Reactioncraft.bookcase.common;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBookcasedoor extends BlockDoor
{
    protected BlockBookcasedoor(int par1, Material par2Material)
    {
        super(par1, par2Material);
        this.blockIndexInTexture = 33;
        this.disableStats();
        if (par2Material == Material.iron)
        {
            this.blockIndexInTexture = 33;
        }
    }
    
    /**
     * Disable statistics for the block, the block will no count for mined or placed.
     */
    public Block disableStats()
    {
        this.enableStats = false;
        return this;
    }
    
    @Override
    public String getTextureFile()
    {
        return "/Reactioncraft/images/bookcases.png";
    }

    @SideOnly(Side.CLIENT)

    /**
     * Retrieves the block texture to use based on the display side. Args: iBlockAccess, x, y, z, side
     */
    public int getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
        if (par5 != 0 && par5 != 1)
        {
            int var6 = this.getFullMetadata(par1IBlockAccess, par2, par3, par4);
            int var7 = this.blockIndexInTexture;

            if ((var6 & 8) != 0)
            {
                var7 -= 16;
            }

            int var8 = var6 & 3;
            boolean var9 = (var6 & 4) != 0;

            if (var9)
            {
                if (var8 == 0 && par5 == 2)
                {
                    var7 = -var7;
                }
                else if (var8 == 1 && par5 == 5)
                {
                    var7 = -var7;
                }
                else if (var8 == 2 && par5 == 3)
                {
                    var7 = -var7;
                }
                else if (var8 == 3 && par5 == 4)
                {
                    var7 = -var7;
                }
            }
            else
            {
                if (var8 == 0 && par5 == 5)
                {
                    var7 = -var7;
                }
                else if (var8 == 1 && par5 == 3)
                {
                    var7 = -var7;
                }
                else if (var8 == 2 && par5 == 4)
                {
                    var7 = -var7;
                }
                else if (var8 == 3 && par5 == 2)
                {
                    var7 = -var7;
                }

                if ((var6 & 16) != 0)
                {
                    var7 = -var7;
                }
            }

            return var7;
        }
        else
        {
            return this.blockIndexInTexture;
        }
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean getBlocksMovement(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        int var5 = this.getFullMetadata(par1IBlockAccess, par2, par3, par4);
        return (var5 & 4) != 0;
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
        return 7;
    }

    @SideOnly(Side.CLIENT)

    /**
     * Returns the bounding box of the wired rectangular prism to render.
     */
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
        return super.getSelectedBoundingBoxFromPool(par1World, par2, par3, par4);
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
        return super.getCollisionBoundingBoxFromPool(par1World, par2, par3, par4);
    }

    /**
     * Updates the blocks bounds based on its current state. Args: world, x, y, z
     */
    public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        this.setDoorRotation(this.getFullMetadata(par1IBlockAccess, par2, par3, par4));
    }

    /**
     * Returns 0, 1, 2 or 3 depending on where the hinge is.
     */
    public int getDoorOrientation(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        return this.getFullMetadata(par1IBlockAccess, par2, par3, par4) & 3;
    }

    public boolean isDoorOpen(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        return (this.getFullMetadata(par1IBlockAccess, par2, par3, par4) & 4) != 0;
    }

    private void setDoorRotation(int par1)
    {
        float var2 = 0.1875F;
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F);
        int var3 = par1 & 3;
        boolean var4 = (par1 & 4) != 0;
        boolean var5 = (par1 & 16) != 0;

        if (var3 == 0)
        {
            if (var4)
            {
                if (!var5)
                {
                    this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var2);
                }
                else
                {
                    this.setBlockBounds(0.0F, 0.0F, 1.0F - var2, 1.0F, 1.0F, 1.0F);
                }
            }
            else
            {
                this.setBlockBounds(0.0F, 0.0F, 0.0F, var2, 1.0F, 1.0F);
            }
        }
        else if (var3 == 1)
        {
            if (var4)
            {
                if (!var5)
                {
                    this.setBlockBounds(1.0F - var2, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
                }
                else
                {
                    this.setBlockBounds(0.0F, 0.0F, 0.0F, var2, 1.0F, 1.0F);
                }
            }
            else
            {
                this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var2);
            }
        }
        else if (var3 == 2)
        {
            if (var4)
            {
                if (!var5)
                {
                    this.setBlockBounds(0.0F, 0.0F, 1.0F - var2, 1.0F, 1.0F, 1.0F);
                }
                else
                {
                    this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var2);
                }
            }
            else
            {
                this.setBlockBounds(1.0F - var2, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            }
        }
        else if (var3 == 3)
        {
            if (var4)
            {
                if (!var5)
                {
                    this.setBlockBounds(0.0F, 0.0F, 0.0F, var2, 1.0F, 1.0F);
                }
                else
                {
                    this.setBlockBounds(1.0F - var2, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
                }
            }
            else
            {
                this.setBlockBounds(0.0F, 0.0F, 1.0F - var2, 1.0F, 1.0F, 1.0F);
            }
        }
    }

    /**
     * Called when the block is clicked by a player. Args: x, y, z, entityPlayer
     */
    public void onBlockClicked(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer) {}

    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        if (this.blockMaterial == Material.iron)
        {
            return false; //Allow items to interact with the door
        }
        else
        {
            int var10 = this.getFullMetadata(par1World, par2, par3, par4);
            int var11 = var10 & 7;
            var11 ^= 4;

            if ((var10 & 8) == 0)
            {
                par1World.setBlockMetadataWithNotify(par2, par3, par4, var11);
                par1World.markBlockRangeForRenderUpdate(par2, par3, par4, par2, par3, par4);
            }
            else
            {
                par1World.setBlockMetadataWithNotify(par2, par3 - 1, par4, var11);
                par1World.markBlockRangeForRenderUpdate(par2, par3 - 1, par4, par2, par3, par4);
            }

            par1World.playAuxSFXAtEntity(par5EntityPlayer, 1003, par2, par3, par4, 0);
            return true;
        }
    }

    /**
     * A function to open a door.
     */
    public void onPoweredBlockChange(World par1World, int par2, int par3, int par4, boolean par5)
    {
        int var6 = this.getFullMetadata(par1World, par2, par3, par4);
        boolean var7 = (var6 & 4) != 0;

        if (var7 != par5)
        {
            int var8 = var6 & 7;
            var8 ^= 4;

            if ((var6 & 8) == 0)
            {
                par1World.setBlockMetadataWithNotify(par2, par3, par4, var8);
                par1World.markBlockRangeForRenderUpdate(par2, par3, par4, par2, par3, par4);
            }
            else
            {
                par1World.setBlockMetadataWithNotify(par2, par3 - 1, par4, var8);
                par1World.markBlockRangeForRenderUpdate(par2, par3 - 1, par4, par2, par3, par4);
            }

            par1World.playAuxSFXAtEntity((EntityPlayer)null, 1003, par2, par3, par4, 0);
        }
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor blockID
     */
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
    {
        int var6 = par1World.getBlockMetadata(par2, par3, par4);

        if ((var6 & 8) == 0)
        {
            boolean var7 = false;

            if (par1World.getBlockId(par2, par3 + 1, par4) != this.blockID)
            {
                par1World.setBlockWithNotify(par2, par3, par4, 0);
                var7 = true;
            }

            if (!par1World.doesBlockHaveSolidTopSurface(par2, par3 - 1, par4))
            {
                par1World.setBlockWithNotify(par2, par3, par4, 0);
                var7 = true;

                if (par1World.getBlockId(par2, par3 + 1, par4) == this.blockID)
                {
                    par1World.setBlockWithNotify(par2, par3 + 1, par4, 0);
                }
            }

            if (var7)
            {
                if (!par1World.isRemote)
                {
                    this.dropBlockAsItem(par1World, par2, par3, par4, var6, 0);
                }
            }
            else
            {
                boolean var8 = par1World.isBlockIndirectlyGettingPowered(par2, par3, par4) || par1World.isBlockIndirectlyGettingPowered(par2, par3 + 1, par4);

                if ((var8 || par5 > 0 && Block.blocksList[par5].canProvidePower()) && par5 != this.blockID)
                {
                    this.onPoweredBlockChange(par1World, par2, par3, par4, var8);
                }
            }
        }
        else
        {
            if (par1World.getBlockId(par2, par3 - 1, par4) != this.blockID)
            {
                par1World.setBlockWithNotify(par2, par3, par4, 0);
            }

            if (par5 > 0 && par5 != this.blockID)
            {
                this.onNeighborBlockChange(par1World, par2, par3 - 1, par4, par5);
            }
        }
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return (par1 & 8) != 0 ? 0 : (this.blockMaterial == Material.iron ? RCBB.IronBookcasedoor.itemID : RCBB.WoodenBookcasedoor.itemID);
    }

    @SideOnly(Side.CLIENT)

    /**
     * only called by clickMiddleMouseButton , and passed to inventory.setCurrentItem (along with isCreative)
     */
    public int idPicked(World par1World, int par2, int par3, int par4)
    {
        return this.blockMaterial == Material.iron ? RCBB.IronBookcasedoor.itemID : RCBB.WoodenBookcasedoor.itemID;
    }

    /**
     * Called when the block is attempted to be harvested
     */
    public void onBlockHarvested(World par1World, int par2, int par3, int par4, int par5, EntityPlayer par6EntityPlayer)
    {
        if (par6EntityPlayer.capabilities.isCreativeMode && (par5 & 8) != 0 && par1World.getBlockId(par2, par3 - 1, par4) == this.blockID)
        {
            par1World.setBlockWithNotify(par2, par3 - 1, par4, 0);
        }
    }
}