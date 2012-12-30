package Reactioncraft.plants.common;

import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.BonemealEvent;

public class RCPMBonemealProvider 
{
	@ForgeSubscribe
    public void onUseBonemeal(BonemealEvent event)
    {
            if (event.ID == RCPM.CocoCrop.blockID)
            {       
                    if (!event.world.isRemote)
                    {
                        ((BlockCocoPlant)RCPM.CocoCrop).fertilize(event.world, event.X, event.Y, event.Z);
                        //--par1ItemStack.stackSize;
                    }

                    return;
            }
            
            if (event.ID == RCPM.AncientPlant.blockID)
            {       
                    if (!event.world.isRemote)
                    {
                        ((BlockAncientPlant)RCPM.AncientPlant).fertilize(event.world, event.X, event.Y, event.Z);
                        //--par1ItemStack.stackSize;
                    }

                    return;
            }
    }
}
