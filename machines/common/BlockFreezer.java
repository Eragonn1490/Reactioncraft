package Reactioncraft.machines.common;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockFreezer extends BlockContainer
{
    /**
     * Is the random generator used by furnace to drop the inventory contents in random directions.
     */
    private Random furnaceRand = new Random();

    /** True if this is an active furnace, false if idle */
    private final boolean isActive;

    /**
     * This flag is used to prevent the furnace inventory to be dropped upon block removal, is used internally when the
     * furnace block changes from idle to active and vice-versa.
     */
    private static boolean keepFurnaceInventory = false;
    
    private final int frontIdleTexture;
    private final int frontActiveTexture;

    protected BlockFreezer(int par1, boolean par2)
    {
        super(par1, Material.rock);
        this.isActive = par2;
        this.blockIndexInTexture = 14;
        this.frontActiveTexture = 13;
        this.frontIdleTexture = 13;
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return RCMM.FreezerIdle.blockID;
    }

    /**
     * Returns the block texture based on the side being looked at.  Args: side
     */
    public int getBlockTextureFromSide(int i)
    {
        switch (i)
        {
            case 0:
                return 14;

            case 1:
                return 14;

            case 2:
                return 13;

            case 3:
                return 14;

            case 4:
                return 14;

            case 5:
                return 14;
        }

        return 15;
    }

    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        if (par1World.isRemote)
        {
            return true;
        }
        else
        {
            TileEntityFreezer var10 = (TileEntityFreezer)par1World.getBlockTileEntity(par2, par3, par4);

            if (var10 != null)
            {
            	par5EntityPlayer.openGui(RCMM.instance, 0, par1World, par2, par3, par4);
            }

            return true;
        }
    }

    /**
     * Update which block ID the furnace is using depending on whether or not it is burning
     */
    public static void updateFurnaceBlockState(boolean par0, World par1World, int par2, int par3, int par4)
    {
        int var5 = par1World.getBlockMetadata(par2, par3, par4);
        TileEntity var6 = par1World.getBlockTileEntity(par2, par3, par4);
        keepFurnaceInventory = true;

        if (par0)
        {
            par1World.setBlockWithNotify(par2, par3, par4, RCMM.FreezerActive.blockID);
        }
        else
        {
            par1World.setBlockWithNotify(par2, par3, par4, RCMM.FreezerIdle.blockID);
        }

        keepFurnaceInventory = false;
        par1World.setBlockMetadataWithNotify(par2, par3, par4, var5);

        if (var6 != null)
        {
            var6.validate();
            par1World.setBlockTileEntity(par2, par3, par4, var6);
        }
    }

    /**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     */
    public TileEntity createNewTileEntity(World par1World)
    {
        return new TileEntityFreezer();
    }

    /**
     * Called when the block is placed in the world.
     */
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving)
    {
        int var6 = MathHelper.floor_double((double)(par5EntityLiving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (var6 == 0)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 2);
        }

        if (var6 == 1)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 5);
        }

        if (var6 == 2)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 3);
        }

        if (var6 == 3)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 4);
        }
    }

    /**
     * ejects contained items into the world, and notifies neighbours of an update, as appropriate
     */
    public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
    {
        if (!keepFurnaceInventory)
        {
            TileEntityFreezer var7 = (TileEntityFreezer)par1World.getBlockTileEntity(par2, par3, par4);

            if (var7 != null)
            {
                for (int var8 = 0; var8 < var7.getSizeInventory(); ++var8)
                {
                    ItemStack var9 = var7.getStackInSlot(var8);

                    if (var9 != null)
                    {
                        float var10 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
                        float var11 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
                        float var12 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;

                        while (var9.stackSize > 0)
                        {
                            int var13 = this.furnaceRand.nextInt(21) + 10;

                            if (var13 > var9.stackSize)
                            {
                                var13 = var9.stackSize;
                            }

                            var9.stackSize -= var13;
                            EntityItem var14 = new EntityItem(par1World, (double)((float)par2 + var10), (double)((float)par3 + var11), (double)((float)par4 + var12), new ItemStack(var9.itemID, var13, var9.getItemDamage()));

                            if (var9.hasTagCompound())
                            {
                                var14.getEntityItem().setTagCompound((NBTTagCompound)var9.getTagCompound().copy());
                            }

                            float var15 = 0.05F;
                            var14.motionX = (double)((float)this.furnaceRand.nextGaussian() * var15);
                            var14.motionY = (double)((float)this.furnaceRand.nextGaussian() * var15 + 0.2F);
                            var14.motionZ = (double)((float)this.furnaceRand.nextGaussian() * var15);
                            par1World.spawnEntityInWorld(var14);
                        }
                    }
                }
            }
        }

        super.breakBlock(par1World, par2, par3, par4, par5, par6);
    }

    public String getTextureFile()
    {
        return "/Reactioncraft/images/guitextures.png";
    }
    
    @Override
    public void onBlockAdded(World world, int i, int j, int k)
    {
        super.onBlockAdded(world, i, j, k);
        setDefaultDirection(world, i, j, k);
    }

    private void setDefaultDirection(World world, int i, int j, int k)
    {
        if(!world.isRemote)
        {
            return;
        }
        int l = world.getBlockId(i, j, k - 1);
        int i1 = world.getBlockId(i, j, k + 1);
        int j1 = world.getBlockId(i - 1, j, k);
        int k1 = world.getBlockId(i + 1, j, k);
        byte byte0 = 3;
        if(Block.opaqueCubeLookup[l] && !Block.opaqueCubeLookup[i1])
        {
            byte0 = 3;
        }
        if(Block.opaqueCubeLookup[i1] && !Block.opaqueCubeLookup[l])
        {
            byte0 = 2;
        }
        if(Block.opaqueCubeLookup[j1] && !Block.opaqueCubeLookup[k1])
        {
            byte0 = 5;
        }
        if(Block.opaqueCubeLookup[k1] && !Block.opaqueCubeLookup[j1])
        {
            byte0 = 4;
        }
        world.setBlockMetadataWithNotify(i, j, k, byte0);
    }

    public int getBlockTexture(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        int i1 = iblockaccess.getBlockMetadata(i, j, k);
        int meta = i1 > 8 ? i1 - 8 : i1; 
        if(l != meta)
        {
            return blockIndexInTexture;
        }
        if(i1 > 8)
        {
            return frontActiveTexture;
        } else
        {
            return frontIdleTexture;
        }
    }

    public void randomDisplayTick(World world, int i, int j, int k, Random random)
    {
        super.randomDisplayTick(world, i, j, k, random);
    }

    @Override
    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
        if(i == 3)
        {
        	if(j > 8)
        		return frontActiveTexture;
        	else
        		return frontIdleTexture;
        } else
        {
            return blockIndexInTexture;
        }
    }
}
