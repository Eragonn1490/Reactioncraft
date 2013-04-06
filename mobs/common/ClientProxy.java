package Reactioncraft.mobs.common;

import net.minecraft.client.model.ModelCreeper;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ClientProxy extends CommonProxy
{
	@SideOnly(Side.CLIENT)
	public void registerRenderInformation()
	{
		MinecraftForgeClient.preloadTexture("/Reactioncraft/images/Blocks.png");
		MinecraftForgeClient.preloadTexture("/Reactioncraft/images/Items.png");
		MinecraftForgeClient.preloadTexture("/Reactioncraft/images/armor/goldcrown_1.png");
		MinecraftForgeClient.preloadTexture("/Reactioncraft/images/armor/kingspants2.png");
		MinecraftForgeClient.preloadTexture("/Reactioncraft/images/terrain.png");
		MinecraftForgeClient.preloadTexture("/Reactioncraft/images/plants.png");
		MinecraftForgeClient.preloadTexture("/Reactioncraft/images/bookcases.png");
		MinecraftForgeClient.preloadTexture("/Reactioncraft/images/cakes.png");
		
		
		//Mobs Below
		RenderingRegistry.instance().registerEntityRenderingHandler(EntityBee.class, new RenderBee(new ModelBee(), 0.5F));
		RenderingRegistry.instance().registerEntityRenderingHandler(EntityJellyfish.class, new RenderJellyfish(new ModelJellyfish(), 0.5F));
		RenderingRegistry.instance().registerEntityRenderingHandler(EntitySeaCreeper.class, new RenderSeaCreeper(new ModelSeaCreeper(), 0.5F));
		RenderingRegistry.instance().registerEntityRenderingHandler(EntityStalker.class, new RenderStalker(new ModelCreeper(), 0.5F));
		RenderingRegistry.instance().registerEntityRenderingHandler(EntityZombieCrawling.class, new RenderZombieCrawling(new ModelZombieCrawling(), 0.5F));
		RenderingRegistry.instance().registerEntityRenderingHandler(EntityCrawlingSkeleton.class, new RenderSkeletonCrawling(new ModelZombieCrawling(), 0.5F));
	}
	
	public int addArmor(String armorName)
	{
		return RenderingRegistry.addNewArmourRendererPrefix(armorName);
	}
}