package Reactioncraft.plants.common;

import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ClientProxy extends CommonProxy
{
	@SideOnly(Side.CLIENT)
	public static void registerRenderInformation()
	{
		MinecraftForgeClient.preloadTexture("/Reactioncraft/images/Blocks.png");
		MinecraftForgeClient.preloadTexture("/Reactioncraft/images/Items.png");
		MinecraftForgeClient.preloadTexture("/Reactioncraft/images/armor/goldcrown_1.png");
		MinecraftForgeClient.preloadTexture("/Reactioncraft/images/armor/kingspants2.png");
		MinecraftForgeClient.preloadTexture("/Reactioncraft/images/terrain.png");
		MinecraftForgeClient.preloadTexture("/Reactioncraft/images/plants.png");
		MinecraftForgeClient.preloadTexture("/Reactioncraft/images/bookcases.png");
		//These are the texture files with the item/block textures
	}
	
	@Override
	public int addArmor(String armorName)
	{
		return RenderingRegistry.addNewArmourRendererPrefix(armorName);
	}
}