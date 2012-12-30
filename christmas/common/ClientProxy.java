package Reactioncraft.christmas.common;

import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ClientProxy extends CommonProxy
{
    @SideOnly(Side.CLIENT)
    public static void registerRenderInformation()
    {
    	MinecraftForgeClient.preloadTexture("/Reactioncraft/images/ChristmasItems.png");
        MinecraftForgeClient.preloadTexture("/Reactioncraft/images/Items.png");
        MinecraftForgeClient.preloadTexture("/Reactioncraft/images/ChristmasBlocks.png");
    }

    public int addArmor(String var1)
    {
        return RenderingRegistry.addNewArmourRendererPrefix(var1);
    }
}
