package Reactioncraft.mobs.common;

import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.world.World;

public class EntityStalker extends EntityCreeper
{
    public EntityStalker(World world)
    {
        super(world);
        texture = "/Reactioncraft/images/mobs/Stalker.png";
        moveSpeed = 0.23F;
    }

    public int getMaxHealth()
    {
        return 20;
    }
}
