package Reactioncraft.core.common;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import net.minecraft.entity.EntityHanging;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ReactioncraftEntityPainting extends EntityHanging
{
    public ReactioncraftEnumArt art;

    public ReactioncraftEntityPainting(World par1World)
    {
        super(par1World);
    }

    public ReactioncraftEntityPainting(World par1World, int par2, int par3, int par4, int par5)
    {
        super(par1World, par2, par3, par4, par5);
        ArrayList var6 = new ArrayList();
        ReactioncraftEnumArt[] var7 = ReactioncraftEnumArt.values();
        int var8 = var7.length;

        for (int var9 = 0; var9 < var8; ++var9)
        {
            ReactioncraftEnumArt var10 = var7[var9];
            this.art = var10;
            this.setDirection(par5);

            if (this.onValidSurface())
            {
                var6.add(var10);
            }
        }

        if (!var6.isEmpty())
        {
            this.art = (ReactioncraftEnumArt)var6.get(this.rand.nextInt(var6.size()));
        }

        this.setDirection(par5);
    }

    @SideOnly(Side.CLIENT)
    public ReactioncraftEntityPainting(World par1World, int par2, int par3, int par4, int par5, String par6Str)
    {
        this(par1World, par2, par3, par4, par5);
        ReactioncraftEnumArt[] var7 = ReactioncraftEnumArt.values();
        int var8 = var7.length;

        for (int var9 = 0; var9 < var8; ++var9)
        {
            ReactioncraftEnumArt var10 = var7[var9];

            if (var10.title.equals(par6Str))
            {
                this.art = var10;
                break;
            }
        }

        this.setDirection(par5);
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
    {
        par1NBTTagCompound.setString("Motive", this.art.title);
        super.writeEntityToNBT(par1NBTTagCompound);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        String var2 = par1NBTTagCompound.getString("Motive");
        ReactioncraftEnumArt[] var3 = ReactioncraftEnumArt.values();
        int var4 = var3.length;

        for (int var5 = 0; var5 < var4; ++var5)
        {
            ReactioncraftEnumArt var6 = var3[var5];

            if (var6.title.equals(var2))
            {
                this.art = var6;
            }
        }

        if (this.art == null)
        {
            this.art = ReactioncraftEnumArt.Kebab;
        }

        super.readEntityFromNBT(par1NBTTagCompound);
    }

    public int func_82329_d()
    {
        return this.art.sizeX;
    }

    public int func_82330_g()
    {
        return this.art.sizeY;
    }

    /**
     * Drop the item currently on this item frame.
     */
    public void dropItemStack()
    {
        this.entityDropItem(new ItemStack(RCC.extrapaintings), 0.0F);
    }
}
