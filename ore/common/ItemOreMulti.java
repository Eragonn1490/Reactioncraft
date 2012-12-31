package Reactioncraft.ore.common;

import java.util.List;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import Reactioncraft.base.common.RCB;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


public class ItemOreMulti extends Item 
{
	public ItemOreMulti(int par1) 
	{
		super(par1); //Returns super constructor: par1 is ID
		setTextureFile("/Reactioncraft/images/Items.png"); //Sets the item texture file
		setItemName("OreItems"); //Sets the incode name of the item, make sure it doesn't clash with other items, weird stuff happens
		setCreativeTab(RCB.Reactioncraft); //Tells the game what creative mode tab it goes in
		setHasSubtypes(true); //Marks item as having metadata
		setMaxDamage(0);
	}

	@SideOnly(Side.CLIENT) //Marks a method as client side only, typically for graphics and rendering
	public int getIconFromDamage(int i)
	{
		switch(i)
		{ 	//Checks what the damage is (texture)
			case 0:return 0; //If damage equals 0 then return second icon
			case 1:return 23; //^
			case 2:return 97; //^
			case 3:return 6;
			case 4:return 61;
			case 5:return 0;//needs a texture
			case 6:return 1;
			
			//not currently used and need textures (unless noted)
			case 7:return 2;//dragonstone shard
			case 8:return 4;//carved dragonstone shard
			case 9:return 81;//Superhead Iron Ingot
			case 10:return 51;//Iron Dust
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
	switch(is.getItemDamage())
	{ //Checks what damage is
		case 0:return "Golden Rod"; //If damage is one, return name
		case 1:return "Obsidian Ingot"; //^
		case 2:return "Black Diamond"; //^
		case 3:return "Bloodstone Ingot"; //^
		case 4:return "Silver Ingot";//^
		case 5:return "End Gem";//^
		case 6:return "Bloodstone Dust"; //^
		case 7:return "Dragonstone Shard";//going to be dragonstone shard //^
		case 8:return "Carved Dragonstone";//going to be carved dragonstone shard //^
		case 9:return "Superheated Iron Ingot"; //^ 
		case 10:return "Iron Dust"; //^
		case 11:return "null"; //^
		case 12:return "null"; //^
		case 13:return "null"; //^
		case 14:return "null"; //^
		case 15:return "null"; //^
	}
		return "itemUnknown";
}

	@SideOnly(Side.CLIENT)
	public void getSubItems(int itemID, CreativeTabs tab, List itemList) //Adds the metadata items to the creative inventory
	{
		for(int i=0;i<15;i++)
		//to add all 15 metas copy whats below
		//for(int i=0;i<15;i++)
		{
			itemList.add(new ItemStack(itemID,1,i)); //Adds all the metadatas
		}
	}
}