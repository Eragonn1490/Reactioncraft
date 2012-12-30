package Reactioncraft.machines.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class CommonProxy implements IGuiHandler
{
	public static void registerRenderInformation()
	{
		//No rendering for servers.
	}

	//returns an instance of the Container you made earlier
    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world,
                    int x, int y, int z) {
            TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
            if(tileEntity instanceof TileEntityFreezer){
                    return new ContainerFreezer(player.inventory, (TileEntityFreezer) tileEntity);
            }
            return null;
    }

    //returns an instance of the Gui you made earlier
    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world,
                    int x, int y, int z) {
            TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
            if(tileEntity instanceof TileEntityFreezer){
                    return new GuiFreezer(player.inventory, (TileEntityFreezer) tileEntity);
            }
            return null;
    }
	
	public int addArmor(String armorName)
	{
		return 0;
	}
}