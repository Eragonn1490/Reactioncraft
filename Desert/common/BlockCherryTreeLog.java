package Reactioncraft.Desert.common;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import Reactioncraft.base.common.RCB;
import Reactioncraft.basic.common.BlockBasic;

public class BlockCherryTreeLog extends BlockBasic
{

	public BlockCherryTreeLog(int par1, int par2) 
	{
		super(par1, par2);
		this.setCreativeTab(RCB.Reactioncraft);
	}
	
	
	@Override
	public String getTextureFile()
    {
        return "/Reactioncraft/images/Blocks.png";
    }
	
    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        par3List.add(new ItemStack(par1, 1, 0));
    }
    
    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int par1)
    {
        return blockID;
    }
	
	/**
     * Returns the block texture based on the side being looked at.  Args: side
     */
    @Override
    public int getBlockTextureFromSide(int i)
    {
        switch (i)
        {
            case 0:
                return 244;

            case 1:
                return blockIndexInTexture;

            case 2:
                return 243;

            case 3:
                return 243;

            case 4:
                return 243;

            case 5:
                return 243;
        }

        return 15;
    }
    
    
    @Override
    //sustains leaves
    public boolean canSustainLeaves(World world, int x, int y, int z)
    {
        return true;
    }

    @Override
    //tells minecraft that this block is wood. 
    public boolean isWood(World world, int x, int y, int z)
    {
        return true;
    }

}
