package Reactioncraft.mobs.common;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;

import org.lwjgl.opengl.GL11;

public class RenderSeaCreeper extends RenderLiving
{
    public RenderSeaCreeper(ModelBase modelbase, float f)
    {
        super(modelbase, f);
    }

    public void renderSeaCreeper(EntitySeaCreeper entityseacreeper, double d, double d1, double d2, float f, float f1)
    {
        super.doRenderLiving(entityseacreeper, d, d1, d2, f, f1);
    }

    public void doRenderLiving(EntityLiving entityliving, double d, double d1, double d2, float f, float f1)
    {
        renderSeaCreeper((EntitySeaCreeper)entityliving, d, d1, d2, f, f1);
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(Entity entity, double d, double d1, double d2, float f, float f1)
    {
        renderSeaCreeper((EntitySeaCreeper)entity, d, d1, d2, f, f1);
    }

    protected void preRenderScale(EntitySeaCreeper entityseacreeper, float f)
    {
        GL11.glScalef(1.25F, 1.25F, 1.25F);
    }

    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityLiving entityliving, float f)
    {
        preRenderScale((EntitySeaCreeper)entityliving, f);
    }

    protected void rotateAnimal(EntityLiving entityliving)
    {
        GL11.glRotatef(90F, -1F, 0.0F, 0.0F);
    }
}
