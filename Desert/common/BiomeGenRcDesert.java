package Reactioncraft.Desert.common;

import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenRcDesert extends BiomeGenBase
{
    public BiomeGenRcDesert(int i)
    {
        super(i);
        topBlock = (byte)RCBDM.DarkSand.blockID;
        fillerBlock = (byte)RCBDM.DarkSand.blockID;
        spawnableCreatureList.clear();
    }
}
