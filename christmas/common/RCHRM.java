package Reactioncraft.christmas.common;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import Reactioncraft.base.common.RCB;
import Reactioncraft.basic.common.ItemBasic;
import Reactioncraft.basic.common.ItemMulti;
import Reactioncraft.basic.common.PacketHandler;
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
import Reactioncraft.christmas.common.ClientProxy;
import Reactioncraft.christmas.common.CommonProxy;

@Mod
(
        modid = "RCHRM",
        name = "Reactioncraft Christmas Mod",
        version = "[1.4.5] Reactioncraft Version 5.0"
)
@NetworkMod
(
        channels = {"RCHRM"},
        clientSideRequired = true,
        serverSideRequired = false,
        packetHandler = PacketHandler.class
)
public class RCHRM
{
    @SidedProxy
    (
         clientSide = "Reactioncraft.christmas.common.ClientProxy",
         serverSide = "Reactioncraft.christmas.common.CommonProxy"
    )
    public static CommonProxy proxy;
    
    @Instance("RCHRM")
    public static RCHRM instance;
    
    //item config
    public static int presentID;
    public static int StarID;
    public static int ChristmasleavesID;
    public static int GingerplantID;
    public static int GingerbreadmanIID;
    public static int CanycaneIID;
    public static int GingerRootIID;
    public static int cardboardIID;
    public static int BoxItemIID;
    public static int wrappingpaperIID;
    public static int BowIID;
    public static int clearchristmaslightIID;
    public static int ChristmaslightmetaIID;
    
    
    //Blocks - Items
    public static Block present;
    public static Block star;
    public static Block Christmasleaves;
    public static Block Gingerplant;
    public static Item Gingerbreadman;
    public static Item Candycane;
    public static Item GingerRoot;
    public static Item Cardboard;
    public static Item BoxItem;
    public static Item wrappingpaper;
    public static Item Bow;
    public static Item clearchristmaslight;
    public static Item Christmaslightmeta;

    @PreInit
    public void preInit(FMLPreInitializationEvent var1)
    {
        Configuration var2 = new Configuration(var1.getSuggestedConfigurationFile());
        var2.load();
        
        presentID = var2.getBlock("present", 3008).getInt();
        StarID = var2.getBlock("Star", 3013).getInt();
        ChristmasleavesID = var2.getBlock("Christmas Leaves", 3015).getInt();
        GingerplantID = var2.getBlock("Ginger Plant", 3016).getInt();
        
        
        //10041-10060
        CanycaneIID = var2.getItem("Candy Cane", 10041).getInt();
        GingerbreadmanIID = var2.getItem("Ginger Bread Man", 10042).getInt();
        GingerRootIID = var2.getItem("Ginger Root", 10043).getInt();        
        cardboardIID = var2.getItem("Cardboard", 10044).getInt();
        BoxItemIID = var2.getItem("Box Item", 12300).getInt();
        wrappingpaperIID = var2.getItem("Wraping Paper", 10046).getInt();
        BowIID = var2.getItem("Bow Item", 10047).getInt();
        ChristmaslightmetaIID = var2.getItem("Christmas Light Meta", 10048).getInt();
        clearchristmaslightIID = var2.getItem("Clear christmas light", 10049).getInt();
        
        var2.save();
    }

    @Init
    public void load(FMLInitializationEvent var1)
    {
        ClientProxy.registerRenderInformation();
        this.blockcode();
        this.itemcode();
        this.blockregistry();
        this.recipes();
        this.worldgen();
        this.languageregistry();
    }
    
    public void worldgen() 
    {
		
	}

	public void recipes() 
    {
		//Christmas Leaves
		GameRegistry.addShapelessRecipe(new ItemStack(Christmasleaves, 1, 0), new Object[]{new ItemStack(Christmaslightmeta, 1, 12), new ItemStack(Christmaslightmeta, 1, 12), new ItemStack(Christmaslightmeta, 1, 10), Block.leaves});
		GameRegistry.addShapelessRecipe(new ItemStack(Christmasleaves, 1, 1), new Object[]{new ItemStack(Christmaslightmeta, 1, 2), new ItemStack(Christmaslightmeta, 1, 2), new ItemStack(Christmaslightmeta, 1, 3), Block.leaves});
		GameRegistry.addShapelessRecipe(new ItemStack(Christmasleaves, 1, 2), new Object[]{new ItemStack(Christmaslightmeta, 1, 13), new ItemStack(Christmaslightmeta, 1, 13), new ItemStack(Christmaslightmeta, 1, 10), Block.leaves});
		
		GameRegistry.addShapelessRecipe(new ItemStack(Christmasleaves, 1, 3), new Object[]{new ItemStack(Christmaslightmeta, 1, 3), new ItemStack(Christmaslightmeta, 1, 3), new ItemStack(Christmaslightmeta, 1, 4), Block.leaves});
		GameRegistry.addShapelessRecipe(new ItemStack(Christmasleaves, 1, 4), new Object[]{new ItemStack(Christmaslightmeta, 1, 4), new ItemStack(Christmaslightmeta, 1, 4), new ItemStack(Christmaslightmeta, 1, 2), Block.leaves});
		
		GameRegistry.addShapelessRecipe(new ItemStack(Christmasleaves, 1, 5), new Object[]{new ItemStack(Christmaslightmeta, 1, 10), new ItemStack(Christmaslightmeta, 1, 10), new ItemStack(Christmaslightmeta, 1, 10), Block.leaves});
		GameRegistry.addShapelessRecipe(new ItemStack(Christmasleaves, 1, 7), new Object[]{new ItemStack(Christmaslightmeta, 1, 9), new ItemStack(Christmaslightmeta, 1, 9), new ItemStack(Christmaslightmeta, 1, 9), Block.leaves});
		
		GameRegistry.addShapelessRecipe(new ItemStack(Christmasleaves, 1, 8), new Object[]{new ItemStack(Christmaslightmeta, 1, 12), new ItemStack(Christmaslightmeta, 1, 12), new ItemStack(Christmaslightmeta, 1, 12), Block.leaves});
		GameRegistry.addShapelessRecipe(new ItemStack(Christmasleaves, 1, 9), new Object[]{new ItemStack(Christmaslightmeta, 1, 1), new ItemStack(Christmaslightmeta, 1, 1), new ItemStack(Christmaslightmeta, 1, 1), Block.leaves});
		
		GameRegistry.addShapelessRecipe(new ItemStack(Christmasleaves, 1, 10), new Object[]{new ItemStack(Christmaslightmeta, 1, 2), new ItemStack(Christmaslightmeta, 1, 2), new ItemStack(Christmaslightmeta, 1, 2), Block.leaves});
		
		GameRegistry.addShapelessRecipe(new ItemStack(Christmasleaves, 1, 11), new Object[]{new ItemStack(Christmaslightmeta, 1, 13), new ItemStack(Christmaslightmeta, 1, 13), new ItemStack(Christmaslightmeta, 1, 13), Block.leaves});
		
		GameRegistry.addShapelessRecipe(new ItemStack(Christmasleaves, 1, 12), new Object[]{new ItemStack(Christmaslightmeta, 1, 12), new ItemStack(Christmaslightmeta, 1, 10), new ItemStack(Christmaslightmeta, 1, 1), Block.leaves});
		
		GameRegistry.addShapelessRecipe(new ItemStack(Christmasleaves, 1, 13), new Object[]{new ItemStack(Christmaslightmeta, 1, 0), new ItemStack(Christmaslightmeta, 1, 0), new ItemStack(Christmaslightmeta, 1, 0), Block.leaves});
		GameRegistry.addShapelessRecipe(new ItemStack(Christmasleaves, 1, 14), new Object[]{new ItemStack(Christmaslightmeta, 1, 0), new ItemStack(Christmaslightmeta, 1, 0), new ItemStack(Christmaslightmeta, 1, 0), Block.leaves});
		GameRegistry.addShapelessRecipe(new ItemStack(Christmasleaves, 1, 15), new Object[]{new ItemStack(Christmaslightmeta, 1, 0), new ItemStack(Christmaslightmeta, 1, 0), new ItemStack(Christmaslightmeta, 1, 0), Block.leaves});
		
		//Clear Glass
		GameRegistry.addShapelessRecipe(new ItemStack(Christmasleaves, 1, 6), new Object[]{clearchristmaslight, clearchristmaslight, clearchristmaslight, Block.leaves});
		
		
		//Christmas lights
		GameRegistry.addRecipe(new ItemStack(clearchristmaslight, 4), new Object[]{" G ", "G G", " I ", Character.valueOf('G'), Block.glass, Character.valueOf('I'), Item.ingotIron});
		//Metadata ones below
		GameRegistry.addRecipe(new ItemStack(Christmaslightmeta, 4, 15), new Object[]{" G ", "GDG", " I ", Character.valueOf('G'), Block.glass, Character.valueOf('I'), Item.ingotIron, Character.valueOf('D'), new ItemStack(Item.dyePowder, 1, 7)});
		GameRegistry.addRecipe(new ItemStack(Christmaslightmeta, 4, 0), new Object[]{" G ", "GDG", " I ", Character.valueOf('G'), Block.glass, Character.valueOf('I'), Item.ingotIron, Character.valueOf('D'), new ItemStack(Item.dyePowder, 1, 15)});
		GameRegistry.addRecipe(new ItemStack(Christmaslightmeta, 4, 1), new Object[]{" G ", "GDG", " I ", Character.valueOf('G'), Block.glass, Character.valueOf('I'), Item.ingotIron, Character.valueOf('D'), new ItemStack(Item.dyePowder, 1, 14)});
		GameRegistry.addRecipe(new ItemStack(Christmaslightmeta, 4, 2), new Object[]{" G ", "GDG", " I ", Character.valueOf('G'), Block.glass, Character.valueOf('I'), Item.ingotIron, Character.valueOf('D'), new ItemStack(Item.dyePowder, 1, 5)});
		GameRegistry.addRecipe(new ItemStack(Christmaslightmeta, 4, 3), new Object[]{" G ", "GDG", " I ", Character.valueOf('G'), Block.glass, Character.valueOf('I'), Item.ingotIron, Character.valueOf('D'), new ItemStack(Item.dyePowder, 1, 12)});
		GameRegistry.addRecipe(new ItemStack(Christmaslightmeta, 4, 4), new Object[]{" G ", "GDG", " I ", Character.valueOf('G'), Block.glass, Character.valueOf('I'), Item.ingotIron, Character.valueOf('D'), new ItemStack(Item.dyePowder, 1, 11)});
		GameRegistry.addRecipe(new ItemStack(Christmaslightmeta, 4, 5), new Object[]{" G ", "GDG", " I ", Character.valueOf('G'), Block.glass, Character.valueOf('I'), Item.ingotIron, Character.valueOf('D'), new ItemStack(Item.dyePowder, 1, 10)});
		GameRegistry.addRecipe(new ItemStack(Christmaslightmeta, 4, 6), new Object[]{" G ", "GDG", " I ", Character.valueOf('G'), Block.glass, Character.valueOf('I'), Item.ingotIron, Character.valueOf('D'), new ItemStack(Item.dyePowder, 1, 9)});
		GameRegistry.addRecipe(new ItemStack(Christmaslightmeta, 4, 7), new Object[]{" G ", "GDG", " I ", Character.valueOf('G'), Block.glass, Character.valueOf('I'), Item.ingotIron, Character.valueOf('D'), new ItemStack(Item.dyePowder, 1, 8)});
		GameRegistry.addRecipe(new ItemStack(Christmaslightmeta, 4, 8), new Object[]{" G ", "GDG", " I ", Character.valueOf('G'), Block.glass, Character.valueOf('I'), Item.ingotIron, Character.valueOf('D'), new ItemStack(Item.dyePowder, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(Christmaslightmeta, 4, 9), new Object[]{" G ", "GDG", " I ", Character.valueOf('G'), Block.glass, Character.valueOf('I'), Item.ingotIron, Character.valueOf('D'), new ItemStack(Item.dyePowder, 1, 1)});
		GameRegistry.addRecipe(new ItemStack(Christmaslightmeta, 4, 10), new Object[]{" G ", "GDG", " I ", Character.valueOf('G'), Block.glass, Character.valueOf('I'), Item.ingotIron, Character.valueOf('D'), new ItemStack(Item.dyePowder, 1, 2)});
		GameRegistry.addRecipe(new ItemStack(Christmaslightmeta, 4, 11), new Object[]{" G ", "GDG", " I ", Character.valueOf('G'), Block.glass, Character.valueOf('I'), Item.ingotIron, Character.valueOf('D'), new ItemStack(Item.dyePowder, 1, 3)});
		GameRegistry.addRecipe(new ItemStack(Christmaslightmeta, 4, 12), new Object[]{" G ", "GDG", " I ", Character.valueOf('G'), Block.glass, Character.valueOf('I'), Item.ingotIron, Character.valueOf('D'), new ItemStack(Item.dyePowder, 1, 4)});
		GameRegistry.addRecipe(new ItemStack(Christmaslightmeta, 4, 13), new Object[]{" G ", "GDG", " I ", Character.valueOf('G'), Block.glass, Character.valueOf('I'), Item.ingotIron, Character.valueOf('D'), new ItemStack(Item.dyePowder, 1, 13)});
		GameRegistry.addRecipe(new ItemStack(Christmaslightmeta, 4, 14), new Object[]{" G ", "GDG", " I ", Character.valueOf('G'), Block.glass, Character.valueOf('I'), Item.ingotIron, Character.valueOf('D'), new ItemStack(Item.dyePowder, 1, 6)});	
		
		
		//Candycane 
		GameRegistry.addRecipe(new ItemStack(Candycane, 3), new Object[]{"SR ", " S ", " R ", Character.valueOf('S'), Item.sugar, Character.valueOf('R'), new ItemStack(Item.dyePowder, 1, 1)});
		GameRegistry.addRecipe(new ItemStack(Gingerbreadman, 3), new Object[]{"WWW", "GGG", " M ", Character.valueOf('W'), Item.wheat, Character.valueOf('G'), GingerRoot, Character.valueOf('M'), Item.bucketMilk});	
		
		
    	//Present Gifts
    	GameRegistry.addShapelessRecipe(new ItemStack(Item.emerald, 3), new Object[]{new ItemStack(present, 1, 0),});
    	GameRegistry.addShapelessRecipe(new ItemStack(Item.diamond, 3), new Object[]{new ItemStack(present, 1, 1),});
    	GameRegistry.addShapelessRecipe(new ItemStack(Item.appleGold, 3), new Object[]{new ItemStack(present, 1, 2),});
    	GameRegistry.addShapelessRecipe(new ItemStack(Gingerbreadman, 5), new Object[]{new ItemStack(present, 1, 3),});
    	GameRegistry.addShapelessRecipe(new ItemStack(Candycane, 5), new Object[]{new ItemStack(present, 1, 4),});
    	GameRegistry.addShapelessRecipe(new ItemStack(Item.coal, 5), new Object[]{new ItemStack(present, 1, 5),});
    	
    	
    	//Present Recipes
    	GameRegistry.addRecipe(new ItemStack(Cardboard, 1), new Object[]{"###", "###", "###", Character.valueOf('#'), Item.paper});
    	GameRegistry.addRecipe(new ItemStack(BoxItem, 1), new Object[]{ "###", "# #", "###", Character.valueOf('#'), Cardboard});
    	GameRegistry.addRecipe(new ItemStack(wrappingpaper, 1), new Object[]{ "## ", "## ", "## ", Character.valueOf('#'), Item.paper});
    	GameRegistry.addRecipe(new ItemStack(Bow, 1), new Object[]{ "###", "# #", "   ", Character.valueOf('#'), Item.silk});
    	
    	
    	//Actual Presents..
    	GameRegistry.addRecipe(new ItemStack(present, 1, 0), new Object[]{"D#D", " B ", " W ", Character.valueOf('B'), BoxItem, Character.valueOf('W'), wrappingpaper, Character.valueOf('#'), Bow, Character.valueOf('D'), new ItemStack(Item.dyePowder, 1, 2)});
    	GameRegistry.addRecipe(new ItemStack(present, 1, 1), new Object[]{"D#D", " B ", " W ", Character.valueOf('B'), BoxItem, Character.valueOf('W'), wrappingpaper, Character.valueOf('#'), Bow, Character.valueOf('D'), new ItemStack(Item.dyePowder, 1, 4)});
    	GameRegistry.addRecipe(new ItemStack(present, 1, 2), new Object[]{"D#D", " B ", " W ", Character.valueOf('B'), BoxItem, Character.valueOf('W'), wrappingpaper, Character.valueOf('#'), Bow, Character.valueOf('D'), new ItemStack(Item.dyePowder, 1, 1)});
    	GameRegistry.addRecipe(new ItemStack(present, 1, 3), new Object[]{"D#D", " B ", " W ", Character.valueOf('B'), BoxItem, Character.valueOf('W'), wrappingpaper, Character.valueOf('#'), Bow, Character.valueOf('D'), new ItemStack(Item.dyePowder, 1, 14)});
    	GameRegistry.addRecipe(new ItemStack(present, 1, 4), new Object[]{"D#D", " B ", " W ", Character.valueOf('B'), BoxItem, Character.valueOf('W'), wrappingpaper, Character.valueOf('#'), Bow, Character.valueOf('D'), new ItemStack(Item.dyePowder, 1, 11)});
    	GameRegistry.addRecipe(new ItemStack(present, 1, 5), new Object[]{"D#D", " B ", " W ", Character.valueOf('B'), BoxItem, Character.valueOf('W'), wrappingpaper, Character.valueOf('#'), Bow, Character.valueOf('D'), new ItemStack(Item.dyePowder, 1, 0)});
    	
    	
    	//Star Recipe
    	GameRegistry.addRecipe(new ItemStack(star, 1), new Object[]{ " Y ", "Y#Y", " Y ", Character.valueOf('#'), Block.glowStone, Character.valueOf('Y'), Item.ingotGold});
	}

	public void blockcode()
    {
        present = (new BlockPresentMulti(presentID, Material.rock)).setHardness(1.0F).setResistance(1.0F).setBlockName("present");
        star = (new BlockStar(StarID, 16)).setHardness(1.0F).setLightValue(1.0F).setResistance(1.0F).setBlockName("star");
        Christmasleaves = (new BlockChristmas(ChristmasleavesID, Material.rock)).setLightValue(1.0F).setHardness(1.0F).setResistance(1.0F).setBlockName("Christmasleaves");
        Gingerplant = (new BlockGingerplant(GingerplantID, 2)).setHardness(1.0F).setResistance(1.0F).setBlockName("Gingerplant");
    }
    
    public void languageregistry()
    {
    	//Presents
        LanguageRegistry.addName(new ItemStack(present, 1, 0), "Present");
        LanguageRegistry.addName(new ItemStack(present, 1, 1), "Present");
        LanguageRegistry.addName(new ItemStack(present, 1, 2), "Present");
        LanguageRegistry.addName(new ItemStack(present, 1, 3), "Present");
        LanguageRegistry.addName(new ItemStack(present, 1, 4), "Present");
        LanguageRegistry.addName(new ItemStack(present, 1, 5), "Present");
        
        
        //Christmas Leaves
        LanguageRegistry.addName(new ItemStack(Christmasleaves, 1, 0), "Christmas Leaves");
        LanguageRegistry.addName(new ItemStack(Christmasleaves, 1, 1), "Christmas Leaves");
        LanguageRegistry.addName(new ItemStack(Christmasleaves, 1, 2), "Christmas Leaves");
        LanguageRegistry.addName(new ItemStack(Christmasleaves, 1, 3), "Christmas Leaves");
        LanguageRegistry.addName(new ItemStack(Christmasleaves, 1, 4), "Christmas Leaves");
        LanguageRegistry.addName(new ItemStack(Christmasleaves, 1, 5), "Christmas Leaves");
        LanguageRegistry.addName(new ItemStack(Christmasleaves, 1, 6), "Christmas Leaves");
        LanguageRegistry.addName(new ItemStack(Christmasleaves, 1, 7), "Christmas Leaves");
        LanguageRegistry.addName(new ItemStack(Christmasleaves, 1, 8), "Christmas Leaves");
        LanguageRegistry.addName(new ItemStack(Christmasleaves, 1, 9), "Christmas Leaves");
        LanguageRegistry.addName(new ItemStack(Christmasleaves, 1, 10), "Christmas Leaves");
        LanguageRegistry.addName(new ItemStack(Christmasleaves, 1, 11), "Christmas Leaves");
        LanguageRegistry.addName(new ItemStack(Christmasleaves, 1, 12), "Christmas Leaves");
        LanguageRegistry.addName(new ItemStack(Christmasleaves, 1, 13), "Christmas Leaves");
        LanguageRegistry.addName(new ItemStack(Christmasleaves, 1, 14), "Christmas Leaves");
        LanguageRegistry.addName(new ItemStack(Christmasleaves, 1, 15), "Christmas Leaves");
        
        
        //Regular Stuff
        LanguageRegistry.addName(star, "Star");
        LanguageRegistry.addName(Gingerplant, "Ginger Plant");
        LanguageRegistry.addName(Cardboard, "cardboard");
        LanguageRegistry.addName(BoxItem, "Box");
        LanguageRegistry.addName(wrappingpaper, "wrapping paper");
        LanguageRegistry.addName(Bow, "Bow");
        LanguageRegistry.addName(Candycane, "Candy Cane");
        LanguageRegistry.addName(Gingerbreadman, "Ginger Bread Man");
        LanguageRegistry.addName(GingerRoot, "Ginger Root");
        LanguageRegistry.addName(present, "Present");
        LanguageRegistry.addName(clearchristmaslight, "Christmas Light");
        
        
        //Metadata Items
        LanguageRegistry.addName(new ItemStack(RCHRM.Christmaslightmeta,1,0), "White light"); 
        LanguageRegistry.addName(new ItemStack(RCHRM.Christmaslightmeta,1,1), "Orange light"); 
        LanguageRegistry.addName(new ItemStack(RCHRM.Christmaslightmeta,1,2), "Purple light"); 
        LanguageRegistry.addName(new ItemStack(RCHRM.Christmaslightmeta,1,3), "Lightblue light"); 
        LanguageRegistry.addName(new ItemStack(RCHRM.Christmaslightmeta,1,4), "Yellow light"); 
        LanguageRegistry.addName(new ItemStack(RCHRM.Christmaslightmeta,1,5), "Lightgreen light"); 
        LanguageRegistry.addName(new ItemStack(RCHRM.Christmaslightmeta,1,6), "Pink light"); 
        LanguageRegistry.addName(new ItemStack(RCHRM.Christmaslightmeta,1,7), "Gray light");  
        LanguageRegistry.addName(new ItemStack(RCHRM.Christmaslightmeta,1,8), "Black light"); 
        LanguageRegistry.addName(new ItemStack(RCHRM.Christmaslightmeta,1,9), "Red light"); 
        LanguageRegistry.addName(new ItemStack(RCHRM.Christmaslightmeta,1,10), "Darkgreen light"); 
        LanguageRegistry.addName(new ItemStack(RCHRM.Christmaslightmeta,1,11), "Brown light"); 
        LanguageRegistry.addName(new ItemStack(RCHRM.Christmaslightmeta,1,12), "Blue light"); 
        LanguageRegistry.addName(new ItemStack(RCHRM.Christmaslightmeta,1,13), "Magenta light"); 
        LanguageRegistry.addName(new ItemStack(RCHRM.Christmaslightmeta,1,14), "Cyan light"); 
        LanguageRegistry.addName(new ItemStack(RCHRM.Christmaslightmeta,1,15), "Lightgray light"); 
    }

    public void blockregistry()
    {
        GameRegistry.registerBlock(present, ItemMulti.class);
        GameRegistry.registerBlock(star);
        GameRegistry.registerBlock(Christmasleaves, ItemMulti.class);
        GameRegistry.registerBlock(Gingerplant);
    }

    public void itemcode()
    {
        Gingerbreadman = (new ItemBasic(GingerbreadmanIID)).setIconCoord(190, 0).setItemName("Gingerbreadman");
        Candycane = (new ItemBasic(CanycaneIID)).setIconCoord(191, 0).setItemName("CandyCane");
        GingerRoot = (new ItemBasic(GingerRootIID)).setIconCoord(193, 0).setItemName("GingerRoot");
        Cardboard = (new ItemBasic(cardboardIID)).setIconCoord(193, 0).setItemName("Cardboard");
        BoxItem = new ItemBasic(BoxItemIID).setIconCoord(194, 0).setItemName("Item").setCreativeTab(RCB.Reactioncraft);
        wrappingpaper = (new ItemBasic(wrappingpaperIID)).setIconCoord(203, 0).setItemName("wrappingpaper");
        Bow = (new ItemBasic(BowIID)).setIconCoord(204, 0).setItemName("Bow");
        Christmaslightmeta = new ItemMetaChristmaslight(ChristmaslightmetaIID);
        clearchristmaslight = (new ItemChristmas(clearchristmaslightIID)).setIconCoord(0, 0).setItemName("clearchristmaslight");
    }


    @PostInit
    public void modsLoaded(FMLPostInitializationEvent var1)
    {
    	
    }
}
