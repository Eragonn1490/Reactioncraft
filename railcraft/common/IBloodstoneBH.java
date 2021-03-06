package Reactioncraft.railcraft.common;

import Reactioncraft.basic.common.ItemBasic;

public class IBloodstoneBH extends ItemBasic implements railcraft.common.api.carts.bore.IBoreHead
{
    public IBloodstoneBH(int i)
    {
        super(i);
        maxStackSize = 1;
        setMaxDamage(10000);
    }

    public String getBoreTexture()
    {
        return "/Reactioncraft/images/tunnel_bore_bloodstone.png";
    }

    public int getHarvestLevel()
    {
        return 3;
    }

    public float getDigModifier()
    {
        return 1.4F;
    }
}
