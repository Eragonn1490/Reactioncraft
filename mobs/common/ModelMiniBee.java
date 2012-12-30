package Reactioncraft.mobs.common;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelMiniBee extends ModelBase
{
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;

    public ModelMiniBee()
    {
        textureWidth = 64;
        textureHeight = 32;
        Shape1 = new ModelRenderer(this, 0, 0);
        Shape1.addBox(0.0F, 0.0F, 0.0F, 2, 2, 4);
        Shape1.setRotationPoint(0.0F, 0.0F, 0.0F);
        Shape1.setTextureSize(64, 32);
        Shape1.mirror = true;
        setRotation(Shape1, 0.0F, 0.0F, 0.0F);
        Shape2 = new ModelRenderer(this, 0, 0);
        Shape2.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2);
        Shape2.setRotationPoint(2.0F, 0.0F, 1.0F);
        Shape2.setTextureSize(64, 32);
        Shape2.mirror = true;
        setRotation(Shape2, 0.0F, 0.0F, 0.0F);
        Shape3 = new ModelRenderer(this, 0, 0);
        Shape3.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2);
        Shape3.setRotationPoint(-2F, 0.0F, 1.0F);
        Shape3.setTextureSize(64, 32);
        Shape3.mirror = true;
        setRotation(Shape3, 0.0F, 0.0F, 0.0F);
        Shape4 = new ModelRenderer(this, 0, 0);
        Shape4.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
        Shape4.setRotationPoint(2.0F, -1F, 4F);
        Shape4.setTextureSize(64, 32);
        Shape4.mirror = true;
        setRotation(Shape4, 0.0F, 0.0F, 0.0F);
        Shape5 = new ModelRenderer(this, 0, 0);
        Shape5.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
        Shape5.setRotationPoint(-1F, -1F, 4F);
        Shape5.setTextureSize(64, 32);
        Shape5.mirror = true;
        setRotation(Shape5, 0.0F, 0.0F, 0.0F);
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        Shape1.render(f5);
        Shape2.render(f5);
        Shape3.render(f5);
        Shape4.render(f5);
        Shape5.render(f5);
    }

    private void setRotation(ModelRenderer modelrenderer, float f, float f1, float f2)
    {
        modelrenderer.rotateAngleX = f;
        modelrenderer.rotateAngleY = f1;
        modelrenderer.rotateAngleZ = f2;
    }

    /**
     * Sets the models various rotation angles.
     */
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, EntityLiving entity)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        Shape2.rotateAngleY = (float)Math.sin(f2 * 0.25F) * 0.25F;
        Shape3.rotateAngleY = (float)Math.sin(f2 * 0.25F) * 0.25F;
    }
}
