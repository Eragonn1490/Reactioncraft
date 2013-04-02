package Reactioncraft.core.common;

import net.minecraft.block.BlockStationary;
import net.minecraft.block.material.Material;

public class BlockMagmaLiquidFlowing extends BlockStationary
{
	public BlockMagmaLiquidFlowing(int par1) 
	{
		super(par1, Material.lava);
		this.blockHardness = 100.0F;
		this.setLightOpacity(3);
		this.disableStats();
		this.setRequiresSelfNotify();
	}
	
	public String getTextureFile()
	{
		return "/Reactioncraft/images/Liquids.png";
	}
}
