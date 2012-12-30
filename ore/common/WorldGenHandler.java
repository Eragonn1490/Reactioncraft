package Reactioncraft.ore.common;

import java.util.Random;
import Reactioncraft.ore.common.*;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenHandler implements IWorldGenerator 
{
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		switch (world.provider.dimensionId)
		{
			case -1: generateNether(world, random, chunkX*16, chunkZ*16);
			case 0: generateSurface(world, random, chunkX*16, chunkZ*16);
			case 1: generateEnd(world, random, chunkX*16, chunkZ*16);
		}
	}

	public void generateSurface(World world, Random random, int blockX, int blockZ) 
	{
		//Silver
  		for(int i = 0; i < 4; i++)
  		{
            int randPosX = blockX + random.nextInt(16);
            int randPosY = random.nextInt(128);
            int randPosZ = blockZ + random.nextInt(16);
            (new WorldGenMinable(RCORES.surfaceOres.blockID, 0, 5)).generate(world, random, randPosX, randPosY, randPosZ);
		}
//  		for(int i = 0; i < 7; i++)
//  		{
//                int randPosX = blockX + random.nextInt(16);
//                int randPosY = random.nextInt(128);
//                int randPosZ = blockZ + random.nextInt(16);
//                (new WorldGenMinable(AliensVsPredator.oreDiamondShard.blockID, 4)).generate(world, random, randPosX, randPosY, randPosZ);
//  		}
//  		for(int i = 0; i < 9; i++)
//  		{
//                int randPosX1 = blockX + random.nextInt(16);
//                int randPosY1 = random.nextInt(128);
//                int randPosZ1 = blockZ + random.nextInt(16);
//                (new WorldGenMinable(AliensVsPredator.oreSilicon.blockID, 5)).generate(world, random, randPosX1, randPosY1, randPosZ1);
//  		}
//  		for(int i = 0; i < 10; i++)
//  		{
//                int randPosX2 = blockX + random.nextInt(16);
//                int randPosY2 = random.nextInt(128);
//                int randPosZ2 = blockZ + random.nextInt(16);
//                (new WorldGenMinable(AliensVsPredator.oreTitanium.blockID, 5)).generate(world, random, randPosX2, randPosY2, randPosZ2);
//  		}
	}

	public void generateNether(World world, Random random, int blockX, int blockZ) 
	{
		//Bloodstone
				for(int x = 0; x < 38; x++)
		        {
		            int Xcoord = blockX + random.nextInt(16);
		            int Ycoord = random.nextInt(128);
		            int Zcoord = blockZ + random.nextInt(16);
		            (new WorldGenNether(RCORES.netherOres.blockID, 0, 50)).generate(world, random, Xcoord, Ycoord, Zcoord);
		        }
				//Black Diamond
				for(int x = 0; x < 38; x++)
		        {
		            int Xcoord = blockX + random.nextInt(16);
		            int Ycoord = random.nextInt(128);
		            int Zcoord = blockZ + random.nextInt(16);
		            (new WorldGenNether(RCORES.netherOres.blockID, 1, 5)).generate(world, random, Xcoord, Ycoord, Zcoord);
		        }
				//
//				for(int x = 0; x < 38; x++)
//		        {
//		            int Xcoord = blockX + random.nextInt(16);
//		            int Ycoord = random.nextInt(128);
//		            int Zcoord = blockZ + random.nextInt(16);
//		            (new WorldGenNether(RCO.BlackDiamond.blockID, 0, 2)).generate(world, random, Xcoord, Ycoord, Zcoord);
//		        }
	}
	
	public void generateEnd(World world, Random random, int blockX, int blockZ) 
	{
		 (new WorldGenMinableEnd(RCORES.endOres.blockID, 0, 1)).generate(world, random, blockX + random.nextInt(20), random.nextInt(128), blockZ + random.nextInt(20));
		 //(new WorldGenMinableEnd(RCORES.endOres.blockID, 0, 20)).generate(world, random, blockX + random.nextInt(64), random.nextInt(128), blockZ + random.nextInt(64));
	}
	
}
