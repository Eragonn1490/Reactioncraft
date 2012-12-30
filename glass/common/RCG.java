package Reactioncraft.glass.common;

import Reactioncraft.glass.common.ClientProxy;
import Reactioncraft.glass.common.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import Reactioncraft.basic.common.*;

@Mod( modid = "RCG", name="Reactioncraft Glass", version="[1.4.5] Reactioncraft Version 5.0")
@NetworkMod(channels = { "RCG" }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)

public class RCG
{
	//@SidedProxy(clientSide = "Reactioncraft.basic.common.ClientProxy", serverSide = "Reactioncraft.basic.common.CommonProxy")
	@SidedProxy(clientSide = "Reactioncraft.glass.common.ClientProxy", serverSide = "Reactioncraft.glass.common.CommonProxy")
	
	public static CommonProxy proxy;
	
	@Instance("RCG")
	public static RCG instance;
	
	//config
	public static int glassID;
	//public static int glasspaneID;
	
	//Scroll Shelf
	public static Block GlassGlassMulti;
	//public static Block glasspane;
	
	 @PreInit
	 public void preInit(FMLPreInitializationEvent evt)
	 {
	 //This is new! put stuff here that you want to happen before the mods are loaded
		 Configuration config = new Configuration(evt.getSuggestedConfigurationFile());

         config.load();
         
         //Block IDs 3061 - 3065
         glassID = config.getBlock("Glass Meta", 3061).getInt();
         //glasspaneID = config.getBlock("Glass Pane Meta", 3062).getInt();

         config.save();
	 }
	 

	 @Init
	 public void load(FMLInitializationEvent event)
	 {
	 	//the meat of the mod
		ClientProxy.registerRenderInformation();
		
		GlassGlassMulti = new BlockGlassMulti(glassID, Material.glass).setHardness(0.3F).setBlockName("GlassGlassMulti");
		//glasspane = new BlockGlassPaneMulti(glasspaneID, Material.glass).setHardness(0.3F).setBlockName("GlassGlassMulti");
		
		GameRegistry.registerBlock(GlassGlassMulti, ItemMulti.class);
		//GameRegistry.registerBlock(glasspane, ItemMulti.class);
		
		LanguageRegistry.addName(new ItemStack(GlassGlassMulti, 1), "Yellow StainedGlass");
        LanguageRegistry.addName(new ItemStack(GlassGlassMulti, 1, 1), "Red StainedGlass");
        LanguageRegistry.addName(new ItemStack(GlassGlassMulti, 1, 2), "Black StainedGlass");
        LanguageRegistry.addName(new ItemStack(GlassGlassMulti, 1, 3), "Blue StainedGlass");
        LanguageRegistry.addName(new ItemStack(GlassGlassMulti, 1, 4), "Brown StainedGlass");
        LanguageRegistry.addName(new ItemStack(GlassGlassMulti, 1, 5), "Cyan StainedGlass");
        LanguageRegistry.addName(new ItemStack(GlassGlassMulti, 1, 6), "Gray StainedGlass");
        LanguageRegistry.addName(new ItemStack(GlassGlassMulti, 1, 7), "Green StainedGlass");
        LanguageRegistry.addName(new ItemStack(GlassGlassMulti, 1, 8), "Lightblue StainedGlass");
        LanguageRegistry.addName(new ItemStack(GlassGlassMulti, 1, 9), "Lightgray StainedGlass");
        LanguageRegistry.addName(new ItemStack(GlassGlassMulti, 1, 10), "Limegreen StainedGlass");
        LanguageRegistry.addName(new ItemStack(GlassGlassMulti, 1, 11), "Magenta StainedGlass");
        LanguageRegistry.addName(new ItemStack(GlassGlassMulti, 1, 12), "Orange StainedGlass");
        LanguageRegistry.addName(new ItemStack(GlassGlassMulti, 1, 13), "Pink StainedGlass");
        LanguageRegistry.addName(new ItemStack(GlassGlassMulti, 1, 14), "Purple StainedGlass");
        LanguageRegistry.addName(new ItemStack(GlassGlassMulti, 1, 15), "White StainedGlass");
        
        //Stained Glass
        	GameRegistry.addShapelessRecipe(new ItemStack(GlassGlassMulti, 1, 1), new Object[] {
            Block.glass, new ItemStack(Item.dyePowder, 1, 1)
        });
        	GameRegistry.addShapelessRecipe(new ItemStack(GlassGlassMulti, 1), new Object[] {
            Block.glass, new ItemStack(Item.dyePowder, 1, 11)
        });
        	GameRegistry.addShapelessRecipe(new ItemStack(GlassGlassMulti, 1, 2), new Object[] {
        	new ItemStack(Item.dyePowder, 1, 0), Block.glass 
        });
    		GameRegistry.addShapelessRecipe(new ItemStack(GlassGlassMulti, 1, 3), new Object[] {
        	new ItemStack(Item.dyePowder, 1, 4), Block.glass
        });
    		GameRegistry.addShapelessRecipe(new ItemStack(GlassGlassMulti, 1, 4), new Object[] {
        	new ItemStack(Item.dyePowder, 1, 3), Block.glass
        });
    		GameRegistry.addShapelessRecipe(new ItemStack(GlassGlassMulti, 1, 5), new Object[] {
        	new ItemStack(Item.dyePowder, 1, 6), Block.glass
        });
    		GameRegistry.addShapelessRecipe(new ItemStack(GlassGlassMulti, 1, 6), new Object[] {
        	new ItemStack(Item.dyePowder, 1, 8), Block.glass
        });
    		GameRegistry.addShapelessRecipe(new ItemStack(GlassGlassMulti, 1, 7), new Object[] {
        	new ItemStack(Item.dyePowder, 1, 2), Block.glass
        });
    		GameRegistry.addShapelessRecipe(new ItemStack(GlassGlassMulti, 1, 8), new Object[] {
    		new ItemStack(Item.dyePowder, 1, 12), Block.glass
        });
    		GameRegistry.addShapelessRecipe(new ItemStack(GlassGlassMulti, 1, 9), new Object[] {
        	new ItemStack(Item.dyePowder, 1, 7), Block.glass
        });
    		GameRegistry.addShapelessRecipe(new ItemStack(GlassGlassMulti, 1, 10), new Object[] {
        	new ItemStack(Item.dyePowder, 1, 10), Block.glass
        });
    		GameRegistry.addShapelessRecipe(new ItemStack(GlassGlassMulti, 1, 11), new Object[] {
        	new ItemStack(Item.dyePowder, 1, 13), Block.glass
        });
    		GameRegistry.addShapelessRecipe(new ItemStack(GlassGlassMulti, 1, 12), new Object[] {
        	new ItemStack(Item.dyePowder, 1, 14), Block.glass
        });
    		GameRegistry.addShapelessRecipe(new ItemStack(GlassGlassMulti, 1, 13), new Object[] {
        	new ItemStack(Item.dyePowder, 1, 9), Block.glass
        });
    		GameRegistry.addShapelessRecipe(new ItemStack(GlassGlassMulti, 1, 14), new Object[] {
        	new ItemStack(Item.dyePowder, 1, 5), Block.glass
        });
    		GameRegistry.addShapelessRecipe(new ItemStack(GlassGlassMulti, 1, 15), new Object[] {
        	new ItemStack(Item.dyePowder, 1, 15), Block.glass
        });
		
	 }
	 

	  @PostInit
	  public void modsLoaded(FMLPostInitializationEvent evt)
	  {
		  //new as well! How about that stuff after the mods are loaded/initialized?
	  } 
}
