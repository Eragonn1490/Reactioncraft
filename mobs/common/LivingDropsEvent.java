package Reactioncraft.mobs.common;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.item.Item;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

public class LivingDropsEvent 
{

@ForgeSubscribe
public void playerKilledSheep(LivingDeathEvent event)
{
	if(event.entityLiving instanceof EntitySheep)
 		{
	 		event.entityLiving.dropItem(Item.porkRaw.itemID, 1);
 		}
	}
}