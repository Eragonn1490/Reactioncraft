package Reactioncraft.basic.common;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import Reactioncraft.base.common.RCB;
 
public class BlockBasic extends Block
{
        public BlockBasic(int i, int j)
        {
                super(i, j, Material.rock);
                this.setCreativeTab(RCB.Reactioncraft);
        }
       
        /**
         * Disable statistics for the block, the block will no count for mined or placed.
         */
        public Block disableStats()
        {
            this.enableStats = false;
            return this;
        }
        
        public String getTextureFile()
        {
                return "/Reactioncraft/images/Blocks.png";
        }
       
        public int idDropped(int i, Random random)
        {
                return blockID;
        }
       
        public int quantityDropped(Random random)
        {
                return 1;
        }
}