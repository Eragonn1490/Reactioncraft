// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package Reactioncraft.core.common;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import Reactioncraft.base.common.RCB;

//  Created by Abrar Syed
// Referenced classes of package net.minecraft.src:
//            Block, Material, World, AxisAlignedBB, 
//            Vec3D, MovingObjectPosition

public class BlockRedstoneBlock extends Block 
{

    public BlockRedstoneBlock(int i, int j)
    {
        super(i, j, Material.circuits);
        this.setCreativeTab(RCB.Reactioncraft);
    }
    
    @Override
	public String getTextureFile() 
	{
		return "/Reactioncraft/images/Blocks.png";
	}
    
}