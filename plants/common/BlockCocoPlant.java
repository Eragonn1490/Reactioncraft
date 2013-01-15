package Reactioncraft.plants.common;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
 
public class BlockCocoPlant extends BlockFlower
{
    protected BlockCocoPlant(int par1, int par2)
    {
        super(par1, par2);
        this.blockIndexInTexture = 225;
        this.setTickRandomly(true);
        float var3 = 0.5F;
        this.setBlockBounds(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, 0.25F, 0.5F + var3);
        this.setCreativeTab((CreativeTabs)null);
        this.setRequiresSelfNotify();
        this.setStepSound(Block.soundGrassFootstep);
    }
 
    /**
     * Gets passed in the blockID of the block below and supposed to return true if its allowed to grow on the type of
     * blockID passed in. Args: blockID
     */
    protected boolean canThisPlantGrowOnThisBlockID(int par1)
    {
        return par1 == Block.tilledField.blockID;
    }
   
    @Override
	public String getTextureFile() 
    {
		// TODO Auto-generated method stub
		return "/Reactioncraft/images/plants.png";
	}
   
    public int getBlockTextureFromSideAndMetadata(int par1, int par2)
    {
        {
            if(par2 == 0)
            {
            return blockIndexInTexture;
            }
            if(par2 == 1)
            {
            return blockIndexInTexture;
            }
            if(par2 == 2)
            {
            return blockIndexInTexture;
            }
            if(par2 == 3)
            {
            return blockIndexInTexture;
            }
            if(par2 == 4)
            {
            return blockIndexInTexture + 1;
            }
            if(par2 == 5)
            {
            return blockIndexInTexture + 1;
            }
            if(par2 == 6)
            {
            return blockIndexInTexture + 1;
            }
            if(par2 == 7)
            {
            return blockIndexInTexture + 2;
            }
            if(par2 == 8)
            {
            return blockIndexInTexture + 2;
            }
            return blockIndexInTexture;
            }
    }
 
    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        super.updateTick(par1World, par2, par3, par4, par5Random);
 
        if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9)
        {
            int var6 = par1World.getBlockMetadata(par2, par3, par4);
 
            if (var6 < 7)
            {
                float var7 = this.getGrowthRate(par1World, par2, par3, par4);
 
                if (par5Random.nextInt((int)(25.0F / var7) + 1) == 0)
                {
                    ++var6;
                    par1World.setBlockMetadataWithNotify(par2, par3, par4, var6);
                }
            }
        }
    }
 
    /**
     * Apply bonemeal to the crops.
     */
    public void fertilize(World par1World, int par2, int par3, int par4)
    {
        par1World.setBlockMetadataWithNotify(par2, par3, par4, 7);
    }
   
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
    ItemStack itemstack = par5EntityPlayer.inventory.getCurrentItem();
    if(itemstack != null && itemstack.itemID == Item.dyePowder.itemID)
    {
    if(itemstack.getItemDamage() == 15)
    {
    par1World.setBlockMetadataWithNotify(par2, par3, par4, 7);
    itemstack.stackSize--;
    par1World.notifyBlockChange(par2, par3, par4, 0);
    }
    }
    super.onBlockActivated(par1World, par2, par3, par4, par5EntityPlayer, par6, par7, par8, par9);
    return true;
    }
 
    /**
     * Gets the growth rate for the crop. Setup to encourage rows by halving growth rate if there is diagonals, crops on
     * different sides that aren't opposing, and by adding growth for every crop next to this one (and for crop below
     * this one). Args: x, y, z
     */
    private float getGrowthRate(World par1World, int par2, int par3, int par4)
    {
        float var5 = 1.0F;
        int var6 = par1World.getBlockId(par2, par3, par4 - 1);
        int var7 = par1World.getBlockId(par2, par3, par4 + 1);
        int var8 = par1World.getBlockId(par2 - 1, par3, par4);
        int var9 = par1World.getBlockId(par2 + 1, par3, par4);
        int var10 = par1World.getBlockId(par2 - 1, par3, par4 - 1);
        int var11 = par1World.getBlockId(par2 + 1, par3, par4 - 1);
        int var12 = par1World.getBlockId(par2 + 1, par3, par4 + 1);
        int var13 = par1World.getBlockId(par2 - 1, par3, par4 + 1);
        boolean var14 = var8 == this.blockID || var9 == this.blockID;
        boolean var15 = var6 == this.blockID || var7 == this.blockID;
        boolean var16 = var10 == this.blockID || var11 == this.blockID || var12 == this.blockID || var13 == this.blockID;
 
        for (int var17 = par2 - 1; var17 <= par2 + 1; ++var17)
        {
            for (int var18 = par4 - 1; var18 <= par4 + 1; ++var18)
            {
                int var19 = par1World.getBlockId(var17, par3 - 1, var18);
                float var20 = 0.0F;
 
                if (var19 == Block.tilledField.blockID)
                {
                    var20 = 1.0F;
 
                    if (par1World.getBlockMetadata(var17, par3 - 1, var18) > 0)
                    {
                        var20 = 3.0F;
                    }
                }
 
                if (var17 != par2 || var18 != par4)
                {
                    var20 /= 4.0F;
                }
 
                var5 += var20;
            }
        }
 
        if (var16 || var14 && var15)
        {
            var5 /= 2.0F;
        }
 
        return var5;
    }
 
    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return 1;
    }
 
    /**
     * Drops the block items with a specified chance of dropping the specified items
     */
    public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7)
    {
        super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, 0);
    }
       
    public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune)
    {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        if (metadata == 7)
        {
            ret.add(new ItemStack(RCPM.CocoSeed));
        }
 
        for (int n = 0; n < 1 + fortune; n++)
        {
 
            if (world.rand.nextInt(15) <= metadata)
            {
                //ret.add(new ItemStack(Pamcombinedmod.tomatoItem));
            }
        }
 
        return ret;
    }
   
    public void onBlockDestroyedByPlayer(World world, int par2, int par3, int par4, int par5)
    {
    if (!world.isRemote)
    {
    replantCrops(world, par2, par3, par4, 0, 0, 0, 0);
    }
 
    super.onBlockDestroyedByPlayer(world, par2, par3, par4, par5);
    }
 
 
    public static void replantCrops(World world, int i, int j, int k, int l, int i1, int j1, int k1)
    {
    world.editingBlocks = true;
    world.setBlockAndMetadata(i, j, k, RCPM.CocoCrop.blockID, 4);
    world.editingBlocks = false;
    }
 
    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return par1 == 7 ? RCPM.CocoSeed.itemID : -1;
    }
   
    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
        return 1;
    }
 
    @SideOnly(Side.CLIENT)
 
    /**
     * only called by clickMiddleMouseButton , and passed to inventory.setCurrentItem (along with isCreative)
     */
    public int idPicked(World par1World, int par2, int par3, int par4)
    {
        return RCPM.CocoSeed.itemID;
    }
}