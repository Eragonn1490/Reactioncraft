package Reactioncraft.plantz.common;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenHandler implements IWorldGenerator
{
	@Override
	public void generate(Random random, int x, int z, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		TMPPlantGen gen = new TMPPlantGen();

		x *= 16;
		z *= 16;

		if (world.getWorldInfo().getTerrainType().equals(WorldType.FLAT))
		{
			return;
		}

		if (world.getBiomeGenForCoords(x, z).equals(BiomeGenBase.desert) || world.getBiomeGenForCoords(x, z).equals(BiomeGenBase.desertHills))
		{
			gen.plantBlockId = RcPlantz.WildKush.blockID;
			gen.limit = 1;
			for (int i = 0; i <= 2; i++)
			{
				gen.generate(world, random, x + 8, random.nextInt(170), z + 8);
			}
		}
		
		if (world.getBiomeGenForCoords(x, z).equals(BiomeGenBase.desert) || world.getBiomeGenForCoords(x, z).equals(BiomeGenBase.plains))
		{
			gen.plantBlockId = RcPlantz.WildKush.blockID;
			gen.limit = 1;
			for (int i = 0; i <= 2; i++)
			{
				gen.generate(world, random, x + 8, random.nextInt(170), z + 8);
			}
		}

		if (world.getBiomeGenForCoords(x, z).equals(BiomeGenBase.jungle) || world.getBiomeGenForCoords(x, z).equals(BiomeGenBase.jungleHills))
		{
			gen.plantBlockId = RcPlantz.WildKush.blockID;
			gen.limit = 1;
			gen.replace = Block.leaves.blockID;
			for (int i = 0; i <= 10; i++)
			{
				gen.generate(world, random, x + 8, random.nextInt(170), z + 8);
			}
		}

//		if (world.getSeed() == 40507131 && !world.getBiomeGenForCoords(x, z).equals(BiomeGenBase.ocean))
//		{
//			WorldGenMinable w = new WorldGenMinable(Block.oreDiamond.blockID, 25);
//			for (int i = 0; i <= 10; i++)
//			{
//				w.generate(world, random, x + random.nextInt(16), random.nextInt(25) + 30, z + random.nextInt(16));
//			}
//		}
	}

	class TMPPlantGen
	{
		public void generate(World world, Random random, int i, int j, int k)
		{
			if (replace != 0)
			{
				generateR(world, random, i, j, k);
				return;
			}
			int count = 0;
			for (int l = 0; l < 64; l++)
			{
				if (count >= limit)
				{
					return;
				}
				int i1 = (i + random.nextInt(8)) - random.nextInt(8);
				int j1 = (j + random.nextInt(4)) - random.nextInt(4);
				int k1 = (k + random.nextInt(8)) - random.nextInt(8);
				if ((world.isAirBlock(i1, j1, k1) || (world.getBlockId(i1, j1, k1) == Block.snow.blockID)) && (Block.blocksList[plantBlockId]).canBlockStay(world, i1, j1, k1))
				{
					world.setBlockAndMetadata(i1, j1, k1, plantBlockId, metadata);
					if (run != null)
					{
						run.run(world, i1, j1, k1);
					}
					count++;
					System.out.println("Generated a " + " at " + i1 + ", " + j1 + ", " + k1);
				}
			}
		}

		private void generateR(World world, Random random, int i, int j, int k)
		{
			int count = 0;
			for (int l = 0; l < 64; l++)
			{
				if (count > limit)
				{
					return;
				}
				int i1 = (i + random.nextInt(8)) - random.nextInt(8);
				int j1 = (j + random.nextInt(4)) - random.nextInt(4);
				int k1 = (k + random.nextInt(8)) - random.nextInt(8);
				if (world.getBlockId(i1, j1, k1) == replace && world.getBlockId(i1, j1 + 1, k1) == replace && (Block.blocksList[plantBlockId]).canBlockStay(world, i1, j1, k1))
				{
					world.setBlockAndMetadata(i1, j1, k1, plantBlockId, metadata);
					count++;
				}
			}
		}

		public int limit = 0;
		public int metadata = 0;
		public int replace = 0;
		public GenRunnable run;
		public int plantBlockId = 0;
	}
}
class GenRunnable
{
	public void run(World world, int i, int j, int k)
	{
	}
}