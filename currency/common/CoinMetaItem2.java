package Reactioncraft.currency.common;

import java.util.List;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import Reactioncraft.base.common.RCB;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


public class CoinMetaItem2 extends Item 
{
	public CoinMetaItem2(int par1) 
	{
		super(par1); //Returns super constructor: par1 is ID
		setTextureFile("/Reactioncraft/images/Items.png"); //Sets the item texture file
		setItemName("CoinMetaItem2"); //Sets the incode name of the item, make sure it doesn't clash with other items, weird stuff happens
		setCreativeTab(RCB.Reactioncraft); //Tells the game what creative mode tab it goes in
		setHasSubtypes(true); //Marks item as having metadata
		setMaxDamage(0);
	}

	@SideOnly(Side.CLIENT) //Marks a method as client side only, typically for graphics and rendering
	public int getIconFromDamage(int i)
	{
		switch(i)
		{ 	//Checks what the damage is (texture)
			case 0:return 57;//Silver Coin
			case 1:return 172;//Silver Coins
			case 2:return 54;//Silver Stack
			
			case 3:
				setContainerItem(RCCM.Sack);
				return 49;//Silver Sack
			
			case 4:
				setContainerItem(RCCM.Bag);
				return 143;//Silver Bag
			
				
		    //Bronze Coins
			case 5:
				
				return 56;//Bronze Coin
			
			case 6:
				
				return 173;//Bronze Coins
			
			
			case 7:return 55;//Bronze Stack
			
			case 8:
				setContainerItem(RCCM.Sack);
				return 48;//Bronze Sack
			
			case 9:
				setContainerItem(RCCM.Bag);
				return 139;//Bronze Bag
				
			case 10:return 174;//Copper Coin
			
			
//			case 11:return 58;//Gold Coin
//			case 12:return 171;//Gold Coins
//			case 13:return 53;//Gold Stack
//			
//			case 14:
//				setContainerItem(RCCM.Sack);
//				return 50;//Gold Sack
//			
//			case 15:
//				setContainerItem(RCCM.Bag);
//				return 140;//Gold Bag
		}

		return 0; //If icon not already returned, just return 0
}

public String getItemNameIS(ItemStack is)
{ 
	//Gets the metadata sensitive item name
	switch(is.getItemDamage())
	{ //Checks what damage is
		case 0:return "Silver Coin"; //If damage is one, return name
		case 1:return "Silver Coins"; //^
		case 2:return "Silver Stack"; //^
		case 3:return "Silver Sack"; //^
		case 4:return "Silver Bag";//^
		case 5:return "Bronze Coin";//^
		case 6:return "Bronze Coins"; //^
		case 7:return "Bronze Stack";//^
		case 8:return "Bronze Sack";//^
		case 9:return "Bronze Bag"; //^
		case 10:return "Copper Coin"; //^
//		case 11:return "Gold Coin"; //^
//		case 12:return "Gold Coins"; //^
//		case 13:return "Gold Stack"; //^
//		case 14:return "Gold Sack"; //^
//		case 15:return "Gold Bag"; //^
	}
		return "itemUnknown";
}

	@SideOnly(Side.CLIENT)
	public void getSubItems(int itemID, CreativeTabs tab, List itemList) //Adds the metadata items to the creative inventory
	{
		for(int i=0;i<11;i++)
		//to add all 15 metas copy whats below
		//for(int i=0;i<15;i++)
		{
			itemList.add(new ItemStack(itemID,1,i)); //Adds all the metadatas
		}
	}
}