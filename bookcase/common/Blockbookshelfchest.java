package Reactioncraft.bookcase.common;

import java.util.Iterator;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryLargeChest;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import Reactioncraft.base.common.RCB;



public class Blockbookshelfchest extends BlockContainer
{
    private Random random = new Random();

    public Blockbookshelfchest(int var1)
    {
        super(var1, Material.wood);
        this.blockIndexInTexture = 2;
        this.setCreativeTab(RCB.Reactioncraft);
    }

    public String getTextureFile()
    {
        return "/Reactioncraft/images/bookcases.png";
    }

    /**
     * Returns the block texture based on the side being looked at.  Args: side
     */
    public int getBlockTextureFromSide(int var1)
    {
        switch (var1)
        {
            case 0:
                return this.blockIndexInTexture;

            case 1:
                return this.blockIndexInTexture;

            default:
                return 0;
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

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
        return true;
    }

    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return 0;
    }

    /**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */
    public void onBlockAdded(World var1, int var2, int var3, int var4)
    {
        super.onBlockAdded(var1, var2, var3, var4);
        this.unifyAdjacentChests(var1, var2, var3, var4);
        int var5 = var1.getBlockId(var2, var3, var4 - 1);
        int var6 = var1.getBlockId(var2, var3, var4 + 1);
        int var7 = var1.getBlockId(var2 - 1, var3, var4);
        int var8 = var1.getBlockId(var2 + 1, var3, var4);

        if (var5 == this.blockID)
        {
            this.unifyAdjacentChests(var1, var2, var3, var4 - 1);
        }

        if (var6 == this.blockID)
        {
            this.unifyAdjacentChests(var1, var2, var3, var4 + 1);
        }

        if (var7 == this.blockID)
        {
            this.unifyAdjacentChests(var1, var2 - 1, var3, var4);
        }

        if (var8 == this.blockID)
        {
            this.unifyAdjacentChests(var1, var2 + 1, var3, var4);
        }
    }

    /**
     * Called when the block is placed in the world.
     */
    public void onBlockPlacedBy(World var1, int var2, int var3, int var4, EntityLiving var5)
    {
        int var6 = var1.getBlockId(var2, var3, var4 - 1);
        int var7 = var1.getBlockId(var2, var3, var4 + 1);
        int var8 = var1.getBlockId(var2 - 1, var3, var4);
        int var9 = var1.getBlockId(var2 + 1, var3, var4);
        byte var10 = 0;
        int var11 = MathHelper.floor_double((double)(var5.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (var11 == 0)
        {
            var10 = 2;
        }

        if (var11 == 1)
        {
            var10 = 5;
        }

        if (var11 == 2)
        {
            var10 = 3;
        }

        if (var11 == 3)
        {
            var10 = 4;
        }

        if (var6 != this.blockID && var7 != this.blockID && var8 != this.blockID && var9 != this.blockID)
        {
            var1.setBlockMetadataWithNotify(var2, var3, var4, var10);
        }
        else
        {
            if ((var6 == this.blockID || var7 == this.blockID) && (var10 == 4 || var10 == 5))
            {
                if (var6 == this.blockID)
                {
                    var1.setBlockMetadataWithNotify(var2, var3, var4 - 1, var10);
                }
                else
                {
                    var1.setBlockMetadataWithNotify(var2, var3, var4 + 1, var10);
                }

                var1.setBlockMetadataWithNotify(var2, var3, var4, var10);
            }

            if ((var8 == this.blockID || var9 == this.blockID) && (var10 == 2 || var10 == 3))
            {
                if (var8 == this.blockID)
                {
                    var1.setBlockMetadataWithNotify(var2 - 1, var3, var4, var10);
                }
                else
                {
                    var1.setBlockMetadataWithNotify(var2 + 1, var3, var4, var10);
                }

                var1.setBlockMetadataWithNotify(var2, var3, var4, var10);
            }
        }
    }

    public void unifyAdjacentChests(World var1, int var2, int var3, int var4)
    {
        if (!var1.isRemote)
        {
            int var5 = var1.getBlockId(var2, var3, var4 - 1);
            int var6 = var1.getBlockId(var2, var3, var4 + 1);
            int var7 = var1.getBlockId(var2 - 1, var3, var4);
            int var8 = var1.getBlockId(var2 + 1, var3, var4);
            boolean var9 = true;
            int var10;
            int var11;
            boolean var12;
            byte var13;
            int var14;

            if (var5 != this.blockID && var6 != this.blockID)
            {
                if (var7 != this.blockID && var8 != this.blockID)
                {
                    var13 = 3;

                    if (Block.opaqueCubeLookup[var5] && !Block.opaqueCubeLookup[var6])
                    {
                        var13 = 3;
                    }

                    if (Block.opaqueCubeLookup[var6] && !Block.opaqueCubeLookup[var5])
                    {
                        var13 = 2;
                    }

                    if (Block.opaqueCubeLookup[var7] && !Block.opaqueCubeLookup[var8])
                    {
                        var13 = 5;
                    }

                    if (Block.opaqueCubeLookup[var8] && !Block.opaqueCubeLookup[var7])
                    {
                        var13 = 4;
                    }
                }
                else
                {
                    var10 = var1.getBlockId(var7 == this.blockID ? var2 - 1 : var2 + 1, var3, var4 - 1);
                    var11 = var1.getBlockId(var7 == this.blockID ? var2 - 1 : var2 + 1, var3, var4 + 1);
                    var13 = 3;
                    var12 = true;

                    if (var7 == this.blockID)
                    {
                        var14 = var1.getBlockMetadata(var2 - 1, var3, var4);
                    }
                    else
                    {
                        var14 = var1.getBlockMetadata(var2 + 1, var3, var4);
                    }

                    if (var14 == 2)
                    {
                        var13 = 2;
                    }

                    if ((Block.opaqueCubeLookup[var5] || Block.opaqueCubeLookup[var10]) && !Block.opaqueCubeLookup[var6] && !Block.opaqueCubeLookup[var11])
                    {
                        var13 = 3;
                    }

                    if ((Block.opaqueCubeLookup[var6] || Block.opaqueCubeLookup[var11]) && !Block.opaqueCubeLookup[var5] && !Block.opaqueCubeLookup[var10])
                    {
                        var13 = 2;
                    }
                }
            }
            else
            {
                var10 = var1.getBlockId(var2 - 1, var3, var5 == this.blockID ? var4 - 1 : var4 + 1);
                var11 = var1.getBlockId(var2 + 1, var3, var5 == this.blockID ? var4 - 1 : var4 + 1);
                var13 = 5;
                var12 = true;

                if (var5 == this.blockID)
                {
                    var14 = var1.getBlockMetadata(var2, var3, var4 - 1);
                }
                else
                {
                    var14 = var1.getBlockMetadata(var2, var3, var4 + 1);
                }

                if (var14 == 4)
                {
                    var13 = 4;
                }

                if ((Block.opaqueCubeLookup[var7] || Block.opaqueCubeLookup[var10]) && !Block.opaqueCubeLookup[var8] && !Block.opaqueCubeLookup[var11])
                {
                    var13 = 5;
                }

                if ((Block.opaqueCubeLookup[var8] || Block.opaqueCubeLookup[var11]) && !Block.opaqueCubeLookup[var7] && !Block.opaqueCubeLookup[var10])
                {
                    var13 = 4;
                }
            }

            var1.setBlockMetadataWithNotify(var2, var3, var4, var13);
        }
    }

    /**
     * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
     */
    public boolean canPlaceBlockAt(World var1, int var2, int var3, int var4)
    {
        int var5 = 0;

        if (var1.getBlockId(var2 - 1, var3, var4) == this.blockID)
        {
            ++var5;
        }

        if (var1.getBlockId(var2 + 1, var3, var4) == this.blockID)
        {
            ++var5;
        }

        if (var1.getBlockId(var2, var3, var4 - 1) == this.blockID)
        {
            ++var5;
        }

        if (var1.getBlockId(var2, var3, var4 + 1) == this.blockID)
        {
            ++var5;
        }

        return var5 > 1 ? false : (this.isThereANeighborChest(var1, var2 - 1, var3, var4) ? false : (this.isThereANeighborChest(var1, var2 + 1, var3, var4) ? false : (this.isThereANeighborChest(var1, var2, var3, var4 - 1) ? false : !this.isThereANeighborChest(var1, var2, var3, var4 + 1))));
    }

    private boolean isThereANeighborChest(World var1, int var2, int var3, int var4)
    {
        return var1.getBlockId(var2, var3, var4) != this.blockID ? false : (var1.getBlockId(var2 - 1, var3, var4) == this.blockID ? true : (var1.getBlockId(var2 + 1, var3, var4) == this.blockID ? true : (var1.getBlockId(var2, var3, var4 - 1) == this.blockID ? true : var1.getBlockId(var2, var3, var4 + 1) == this.blockID)));
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor blockID
     */
    public void onNeighborBlockChange(World var1, int var2, int var3, int var4, int var5)
    {
        super.onNeighborBlockChange(var1, var2, var3, var4, var5);
        TileEntityBookcaseChest var6 = (TileEntityBookcaseChest)var1.getBlockTileEntity(var2, var3, var4);

        if (var6 != null)
        {
            var6.updateContainingBlockInfo();
        }
    }

    /**
     * ejects contained items into the world, and notifies neighbours of an update, as appropriate
     */
    public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
    {
        TileEntityBookcaseChest var7 = (TileEntityBookcaseChest)par1World.getBlockTileEntity(par2, par3, par4);

        if (var7 != null)
        {
            for (int var8 = 0; var8 < var7.getSizeInventory(); ++var8)
            {
                ItemStack var9 = var7.getStackInSlot(var8);

                if (var9 != null)
                {
                    float var10 = this.random.nextFloat() * 0.8F + 0.1F;
                    float var11 = this.random.nextFloat() * 0.8F + 0.1F;
                    EntityItem var14;

                    for (float var12 = this.random.nextFloat() * 0.8F + 0.1F; var9.stackSize > 0; par1World.spawnEntityInWorld(var14))
                    {
                        int var13 = this.random.nextInt(21) + 10;

                        if (var13 > var9.stackSize)
                        {
                            var13 = var9.stackSize;
                        }

                        var9.stackSize -= var13;
                        var14 = new EntityItem(par1World, (double)((float)par2 + var10), (double)((float)par3 + var11), (double)((float)par4 + var12), new ItemStack(var9.itemID, var13, var9.getItemDamage()));
                        float var15 = 0.05F;
                        var14.motionX = (double)((float)this.random.nextGaussian() * var15);
                        var14.motionY = (double)((float)this.random.nextGaussian() * var15 + 0.2F);
                        var14.motionZ = (double)((float)this.random.nextGaussian() * var15);

                        if (var9.hasTagCompound())
                        {
                            var14.func_92014_d().setTagCompound((NBTTagCompound)var9.getTagCompound().copy());
                        }
                    }
                }
            }
        }

        super.breakBlock(par1World, par2, par3, par4, par5, par6);
    }

    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World var1, int var2, int var3, int var4, EntityPlayer var5, int var6, float var7, float var8, float var9)
    {
        Object var10 = (TileEntityBookcaseChest)var1.getBlockTileEntity(var2, var3, var4);

        if (var10 == null)
        {
            return true;
        }
        else if (var1.isBlockSolidOnSide(var2, var3 + 1, var4, ForgeDirection.DOWN))
        {
            return true;
        }
        else if (isOcelotBlockingChest(var1, var2, var3, var4))
        {
            return true;
        }
        else if (var1.getBlockId(var2 - 1, var3, var4) == this.blockID && (var1.isBlockSolidOnSide(var2 - 1, var3 + 1, var4, ForgeDirection.DOWN) || isOcelotBlockingChest(var1, var2 - 1, var3, var4)))
        {
            return true;
        }
        else if (var1.getBlockId(var2 + 1, var3, var4) == this.blockID && (var1.isBlockSolidOnSide(var2 + 1, var3 + 1, var4, ForgeDirection.DOWN) || isOcelotBlockingChest(var1, var2 + 1, var3, var4)))
        {
            return true;
        }
        else if (var1.getBlockId(var2, var3, var4 - 1) == this.blockID && (var1.isBlockSolidOnSide(var2, var3 + 1, var4 - 1, ForgeDirection.DOWN) || isOcelotBlockingChest(var1, var2, var3, var4 - 1)))
        {
            return true;
        }
        else if (var1.getBlockId(var2, var3, var4 + 1) == this.blockID && (var1.isBlockSolidOnSide(var2, var3 + 1, var4 + 1, ForgeDirection.DOWN) || isOcelotBlockingChest(var1, var2, var3, var4 + 1)))
        {
            return true;
        }
        else
        {
            if (var1.getBlockId(var2 - 1, var3, var4) == this.blockID)
            {
                var10 = new InventoryLargeChest("Big Bookcasechest", (TileEntityBookcaseChest)var1.getBlockTileEntity(var2 - 1, var3, var4), (IInventory)var10);
            }

            if (var1.getBlockId(var2 + 1, var3, var4) == this.blockID)
            {
                var10 = new InventoryLargeChest("Big Bookcasechest", (IInventory)var10, (TileEntityBookcaseChest)var1.getBlockTileEntity(var2 + 1, var3, var4));
            }

            if (var1.getBlockId(var2, var3, var4 - 1) == this.blockID)
            {
                var10 = new InventoryLargeChest("Big Bookcasechest", (TileEntityBookcaseChest)var1.getBlockTileEntity(var2, var3, var4 - 1), (IInventory)var10);
            }

            if (var1.getBlockId(var2, var3, var4 + 1) == this.blockID)
            {
                var10 = new InventoryLargeChest("Big Bookcasechest", (IInventory)var10, (TileEntityBookcaseChest)var1.getBlockTileEntity(var2, var3, var4 + 1));
            }

            if (var1.isRemote)
            {
                return true;
            }
            else
            {
                var5.displayGUIChest((IInventory)var10);
                return true;
            }
        }
    }

    /**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     */
    public TileEntity createNewTileEntity(World var1)
    {
        return new TileEntityBookcaseChest();
    }

    public static boolean isOcelotBlockingChest(World var0, int var1, int var2, int var3)
    {
        Iterator var4 = var0.getEntitiesWithinAABB(EntityOcelot.class, AxisAlignedBB.getAABBPool().addOrModifyAABBInPool((double)var1, (double)(var2 + 1), (double)var3, (double)(var1 + 1), (double)(var2 + 2), (double)(var3 + 1))).iterator();

        while (var4.hasNext())
        {
            EntityOcelot var6 = (EntityOcelot)var4.next();

            if (var6.isSitting())
            {
                return true;
            }
        }

        return false;
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int var1, Random var2, int var3)
    {
        return RCBB.Bookcasechest.blockID;
    }
}
