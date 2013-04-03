package Reactioncraft.bookcase.common;

import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
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
		  //WizimLibrary
		  int Xcoord1 = blockX + random.nextInt(16);
		  int Ycoord1 = random.nextInt(1000);
		  int Zcoord1 = blockZ + random.nextInt(16);
		  (new WorldGenWizimLibary()).generate(world, random, Xcoord1, Ycoord1, Zcoord1);
	}

	public void generateNether(World world, Random random, int blockX, int blockZ) 
	{

	}
	
	public void generateEnd(World world, Random random, int blockX, int blockZ) 
	{
		
	}
	
}
