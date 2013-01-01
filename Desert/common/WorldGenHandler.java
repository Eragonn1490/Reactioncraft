package Reactioncraft.Desert.common;

import java.util.Random;

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
  }
 }

  

  private void generateSurface(World world, Random random, int blockX, int blockZ) 
 {
//	  for(int i = 0; i < 4; i++)
//		{
//          int randPosX = blockX + random.nextInt(16);
//          int randPosY = random.nextInt(128);
//          int randPosZ = blockZ + random.nextInt(16);
//          (new WorldGenMinable(RCBDM.CactusMulti.blockID, 4)).generate(world, random, randPosX, randPosY, randPosZ);
//		}
//	  
//	  for(int i = 0; i < 4; i++)
//		{
//        int randPosX = blockX + random.nextInt(16);
//        int randPosY = random.nextInt(128);
//        int randPosZ = blockZ + random.nextInt(16);
//        (new WorldGenMinable(RCBDM.CactusMulti.blockID, 4, 1)).generate(world, random, randPosX, randPosY, randPosZ);
//		}
//	  
//	  if((new Random()).nextFloat() < 2)
//	  {
//		  int Xcoord1 = blockX + random.nextInt(16);
//		  int Ycoord1 = random.nextInt(80);
//		  int Zcoord1 = blockZ + random.nextInt(16);
//		  (new WorldGenReactionCraftTree()).generate(world, random, Xcoord1, Ycoord1, Zcoord1);
//	  }
	  
//	  //Sphinx
//	  int Xcoord1 = blockX + random.nextInt(16);
//	  int Ycoord1 = random.nextInt(80);
//	  int Zcoord1 = blockZ + random.nextInt(16);
//	  (new WorldGenSphinx()).generate(world, random, Xcoord1, Ycoord1, Zcoord1);
	  
	  //Sphinx
//	  int Xcoord1 = blockX + random.nextInt(16);
//	  int Ycoord1 = random.nextInt(80);
//	  int Zcoord1 = blockZ + random.nextInt(16);  
//	  (new WorldGenSphinx()).generate(world, random, Xcoord1, Ycoord1, Zcoord1);
 }
 
 private void generateNether(World world, Random random, int blockX, int blockZ) 
 {
  //int Xcoord = blockX + random.nextInt(16);
  //int Ycoord = random.nextInt(60);
  //int Zcoord = blockZ + random.nextInt(16);
  
  //(new WorldGenMinableNether(Tutorial.oreblock.blockID, 1, 10)).generate(world, random, Xcoord, Ycoord, Zcoord);
 }

}
