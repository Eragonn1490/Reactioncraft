package Reactioncraft.core.common;

import net.minecraft.block.BlockFlowing;
import net.minecraft.block.material.Material;

public class BlockMagmaLiquidStill extends BlockFlowing
{
	public BlockMagmaLiquidStill(int par1) 
	{
		super(par1, Material.lava);
		this.blockHardness = 100.0F;
		this.setLightOpacity(3);
	}
	public String getTextureFile()
	{
		return "/Reactioncraft/images/Liquids.png";
	}
}
