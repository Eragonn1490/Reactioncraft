package Reactioncraft.base.common;

import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ClientProxy extends CommonProxy
{
	@SideOnly(Side.CLIENT)
	public static void registerRenderInformation()
	{
		TickRegistry.registerTickHandler(new ClientTickHandler(), Side.CLIENT);
		
		MinecraftForgeClient.preloadTexture("/Reactioncraft/images/Items.png");
		//These are the texture files with the item/block textures
	}
	
	@Override
	public int addArmor(String armorName)
	{
		return RenderingRegistry.addNewArmourRendererPrefix(armorName);
	}
}