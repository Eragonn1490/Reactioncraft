package Reactioncraft.plantz.common;

import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.BonemealEvent;

public class RcBonemealProvider 
{
	@ForgeSubscribe
    public void onUseBonemeal(BonemealEvent event)
    {       
            //Reactioncraft Plantz "Weed" mod
            if (event.ID == RcPlantz.OrangeKush.blockID)
            {       
                    if (!event.world.isRemote)
                    {
                        ((BlockOK)RcPlantz.OrangeKush).fertilize(event.world, event.X, event.Y, event.Z);
                        //--par1ItemStack.stackSize;
                    }

                    return;
            }
            if (event.ID == RcPlantz.Blueberryyy.blockID)
            {       
                    if (!event.world.isRemote)
                    {
                        ((BlockBbyyy)RcPlantz.Blueberryyy).fertilize(event.world, event.X, event.Y, event.Z);
                        //--par1ItemStack.stackSize;
                    }

                    return;
            }
            if (event.ID == RcPlantz.LemonKush.blockID)
            {       
                    if (!event.world.isRemote)
                    {
                        ((BlockLK)RcPlantz.LemonKush).fertilize(event.world, event.X, event.Y, event.Z);
                        //--par1ItemStack.stackSize;
                    }

                    return;
            }
            if (event.ID == RcPlantz.Crystal.blockID)
            {       
                    if (!event.world.isRemote)
                    {
                        ((BlockCK)RcPlantz.Crystal).fertilize(event.world, event.X, event.Y, event.Z);
                        //--par1ItemStack.stackSize;
                    }

                    return;
            }
            if (event.ID == RcPlantz.BlueDream.blockID)
            {       
                    if (!event.world.isRemote)
                    {
                        ((BlockBD)RcPlantz.BlueDream).fertilize(event.world, event.X, event.Y, event.Z);
                        //--par1ItemStack.stackSize;
                    }

                    return;
            }
            if (event.ID == RcPlantz.Fire.blockID)
            {       
                    if (!event.world.isRemote)
                    {
                        ((BlockKF)RcPlantz.Fire).fertilize(event.world, event.X, event.Y, event.Z);
                        //--par1ItemStack.stackSize;
                    }

                    return;
            }

    }
}
