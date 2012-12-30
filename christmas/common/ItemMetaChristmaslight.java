package Reactioncraft.christmas.common;

import java.util.List;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import Reactioncraft.base.common.RCB;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


public class ItemMetaChristmaslight extends Item 
{
	public ItemMetaChristmaslight(int par1) 
	{
		super(par1); //Returns super constructor: par1 is ID
		setTextureFile("/Reactioncraft/images/ChristmasItems.png"); //Sets the item texture file
		setItemName("ChristmasLight"); //Sets the incode name of the item, make sure it doesn't clash with other items, weird stuff happens
		setCreativeTab(RCB.Reactioncraft); //Tells the game what creative mode tab it goes in
		setHasSubtypes(true); //Marks item as having metadata
		setMaxDamage(0);
	}

	@SideOnly(Side.CLIENT) //Marks a method as client side only, typically for graphics and rendering
	public int getIconFromDamage(int i)
	{
		switch(i)
		{ //Checks what the damage is
		case 0:return 1; //If damage equals 0 then return second icon
		case 1:return 2; //^
		case 2:return 3; //^
		case 3:return 4;
		case 4:return 5;
		case 5:return 6;
		case 6:return 7;
		case 7:return 8;
		case 8:return 9;
		case 9:return 10;
		case 10:return 11;
		case 11:return 12;
		case 12:return 13;
		case 13:return 14;
		case 14:return 15;
		case 15:return 16;
		}

		return 0; //If icon not already returned, just return 0
}

public String getItemNameIS(ItemStack is)
{ 
		//Gets the metadata sensitive item name
		switch(is.getItemDamage()){ //Checks what damage is
		case 0:return "White light"; //If damage is one, return name
		case 1:return "Orange light"; //^
		case 2:return "Purple light"; //^
		case 3:return "Lightblue light"; //^
		case 4:return "Yellow light"; //^
		case 5:return "Lightgreen light"; //^
		case 6:return "Pink light"; //^
		case 7:return "Gray light"; //^
		case 8:return "Black light"; //^
		case 9:return "Red light"; //^
		case 10:return "Darkgreen light"; //^
		case 11:return "Brown light"; //^
		case 12:return "Blue light"; //^
		case 13:return "Magenta light"; //^
		case 14:return "Cyan light"; //^
		case 15:return "Lightgray light"; //^
	}
		return "itemUnknown";
}

@SideOnly(Side.CLIENT)
	public void getSubItems(int itemID, CreativeTabs tab, List itemList) //Adds the metadata items to the creative inventory
	{
		for(int i=0;i<15;i++)
		{
			itemList.add(new ItemStack(itemID,1,i)); //Adds all the metadatas
		}
		}
}