package Reactioncraft.Desert.common;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenRcDesert extends BiomeGenBase
{
    public BiomeGenRcDesert(int par1)
    {
        super(par1);
        this.spawnableCreatureList.clear();
        this.topBlock = (byte)RCBDM.DarkSand.blockID;
        this.fillerBlock = (byte)RCBDM.DarkSand.blockID;
    }
}
