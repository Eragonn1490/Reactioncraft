package Reactioncraft.currency.common;

import java.util.List;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import Reactioncraft.base.common.RCB;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


public class CoinMetaItem extends Item 
{
	public CoinMetaItem(int par1) 
	{
		super(par1); //Returns super constructor: par1 is ID
		setTextureFile("/Reactioncraft/images/Items.png"); //Sets the item texture file
		setItemName("CoinMetaItem"); //Sets the incode name of the item, make sure it doesn't clash with other items, weird stuff happens
		setCreativeTab(RCB.Reactioncraft); //Tells the game what creative mode tab it goes in
		setHasSubtypes(true); //Marks item as having metadata
		setMaxDamage(0);
	}

	@SideOnly(Side.CLIENT) //Marks a method as client side only, typically for graphics and rendering
	public int getIconFromDamage(int i)
	{
		switch(i)
		{ 	//Checks what the damage is (texture)
			case 0:return 61;//Silver Ingot
			case 1:return 60;//Bronze Ingot
			case 2:return 62;//Refined Gold Ingot
			
			case 3:
				setContainerItem(Item.bucketEmpty);
				return 201;//Molten Gold
			
			case 4:
				setContainerItem(Item.bucketEmpty);
				return 200;//Molten Silver //needs Texture
			
			case 5:
				setContainerItem(Item.bucketEmpty);
				return 199;//Molten Bronze //needs Texture
			
			case 6:
				setContainerItem(Item.bucketEmpty);
				return 198;//Molten Copper //needs Texture
			
			
			case 7:return 206;//Gold Ingot Bucket //needs Texture //206 is right after obsidian bucket
			case 8:return 207;//Silver Ingot Bucket //needs Texture 
			case 9:return 209;//Bronze Ingot Bucket //needs Texture //after the special pick
			case 10:return 210;//Copper Ingot Bucket //needs Texture //2 after the special pick
			
			
			case 11:return 58;//Gold Coin
			case 12:return 171;//Gold Coins
			case 13:return 53;//Gold Stack
			
			case 14:
				setContainerItem(RCCM.Sack);
				return 50;//Gold Sack
			
			case 15:
				setContainerItem(RCCM.Bag);
				return 140;//Gold Bag
		}

		return 0; //If icon not already returned, just return 0
}

public String getItemNameIS(ItemStack is)
{ 
	//Gets the metadata sensitive item name
	switch(is.getItemDamage())
	{ //Checks what damage is
		case 0:return "Silver Ingot"; //If damage is one, return name
		case 1:return "Bronze Ingot"; //^
		case 2:return "Refined Gold Ingot"; //^
		case 3:return "Molten Gold"; //^
		case 4:return "Molten Silver";//^
		case 5:return "Molten Bronze";//^
		case 6:return "Molten Copper"; //^
		case 7:return "Bucket with Gold Ingot";//going to be dragonstone shard //^
		case 8:return "Bucket with Silver Ingot";//going to be carved dragonstone shard //^
		case 9:return "Bucket with Bronze Ingot"; //^
		case 10:return "Bucket with Copper Ingot"; //^
		case 11:return "Gold Coin"; //^
		case 12:return "Gold Coins"; //^
		case 13:return "Gold Stack"; //^
		case 14:return "Gold Sack"; //^
		case 15:return "Gold Bag"; //^
	}
		return "itemUnknown";
}

	@SideOnly(Side.CLIENT)
	public void getSubItems(int itemID, CreativeTabs tab, List itemList) //Adds the metadata items to the creative inventory
	{
		for(int i=0;i<16;i++)
		{
			itemList.add(new ItemStack(itemID,1,i)); //Adds all the metadatas
		}
	}
}