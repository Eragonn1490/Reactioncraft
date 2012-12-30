package Reactioncraft.railcraft.common;

import Reactioncraft.basic.common.ItemBasic;

public class IBlackDiamondBH extends ItemBasic implements railcraft.common.api.carts.bore.IBoreHead
{
    public IBlackDiamondBH(int i)
    {
        super(i);
        maxStackSize = 1;
        setMaxDamage(6500);
    }

    public String getBoreTexture()
    {
        return "/Reactioncraft/images/tunnel_bore_blackdiamond.png";
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
