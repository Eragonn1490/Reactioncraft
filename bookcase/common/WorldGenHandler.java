package Reactioncraft.bookcase.common;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
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

	private void generateSurface(World world, Random random, int blockX, int blockZ) 
	{
		//(new WorldGenWizimLibary()).generate(world, random, blockX + random.nextInt(16), random.nextInt(256), random.nextInt(16));
	}

	private void generateNether(World world, Random random, int blockX, int blockZ) 
	{

	}
	
	private void generateEnd(World world, Random random, int blockX, int blockZ) 
	{
		
	}
	
}
