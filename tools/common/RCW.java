package Reactioncraft.tools.common;

import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.ShapedOreRecipe;
import Reactioncraft.basic.common.BasicSword;
import Reactioncraft.basic.common.ItemBasic;
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

@Mod( modid = "RCW", name="Reactioncraft Weapons", version="[1.4.7] Reactioncraft Version 7.0")
@NetworkMod(channels = { "RCW" }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)

public class RCW
{
	@SidedProxy(clientSide = "Reactioncraft.tools.common.ClientProxy", serverSide = "Reactioncraft.tools.common.CommonProxy")
	
	public static CommonProxy proxy;
	@Instance("RCW")
	public static RCW instance;
	
    static EnumToolMaterial EnumToolMaterialObby = EnumHelper.addToolMaterial("Obby", 3, 2024, 7.0F, 2, 15);
    static EnumToolMaterial EnumToolMaterialBloodstone = EnumHelper.addToolMaterial("Bloodstone", 3, 4200, 7.0F, 2, 15);
    public int ObbyPickID;
    public int ObbySwordID;
    public int ObbyShovelID;
    public int ObbyAxeID;
    public int ObbyHoeID;
    public int BloodstonePickID;
    public int BloodstoneSwordID;
    public int BloodstoneShovelID;
    public int BloodstoneAxeID;
    public int BloodstoneHoeID;
    public int BloodstoneBladeIID;
    public int GoldenSwordFragmentIID;
    public int UnbindedSwordIID;
    public static Item ObbySword;
    public static Item ObbyPick;
    public static Item ObbyShovel;
    public static Item ObbyAxe;
    public static Item ObbyHoe;
    public static Item BloodstoneSword;
    public static Item BloodstonePick;
    public static Item BloodstoneShovel;
    public static Item BloodstoneAxe;
    public static Item BloodstoneHoe;
    public static Item BloodstoneBlade;
    public static Item GoldenSwordFragment;
    public static Item UnbindedSword;
    
    @PreInit
    public void preInit(FMLPreInitializationEvent var1)
    {
        Configuration config = new Configuration(var1.getSuggestedConfigurationFile());
        
        config.load();
        
        //Claimed Item IDS 10526 - 10600
        this.ObbyPickID = config.getItem("Obsidian Pick", 10526).getInt();
        this.ObbySwordID = config.getItem("Obsidian Sword", 10527).getInt();
        this.ObbyShovelID = config.getItem("Obsidian Shovel", 10528).getInt();
        this.ObbyAxeID = config.getItem("Obsidian Axe", 10529).getInt();
        this.ObbyHoeID = config.getItem("Obsidian Hoe", 10530).getInt();
        
    	this.BloodstonePickID = config.getItem("Bloodstone Pick", 10531).getInt();
        this.BloodstoneSwordID = config.getItem("Bloodstone Sword", 10532).getInt();
        this.BloodstoneShovelID = config.getItem("Bloodstone Shovel", 10533).getInt();
        this.BloodstoneAxeID = config.getItem("Bloodstone Axe", 10534).getInt();
        this.BloodstoneHoeID = config.getItem("Bloodstone Hoe", 10535).getInt();
        
        this.BloodstoneBladeIID = config.getItem("Bloodstone Blade", 10536).getInt();
        this.GoldenSwordFragmentIID = config.getItem("Golden Sword Fragment", 10537).getInt();
        this.UnbindedSwordIID = config.getItem("Unbinded Sword", 10538).getInt();
                
        config.save();
    }

    @Init
    public void init(FMLInitializationEvent var1)
    {
    	//Tool Parts
    	BloodstoneBlade = (new ItemBasic(BloodstoneBladeIID)).setIconCoord(212, 0).setItemName("BloodstoneBlade");
    	GoldenSwordFragment = (new ItemBasic(GoldenSwordFragmentIID)).setIconCoord(211, 0).setItemName("GoldenSwordFragment");
    	UnbindedSword = (new ItemBasic(UnbindedSwordIID)).setIconCoord(5, 0).setItemName("UnbindedSword");
    	
    	//Obsidian
        ObbySword = (new BasicSword(this.ObbyPickID, EnumToolMaterialObby)).setItemName("ObbySword").setIconIndex(25);
        ObbyPick = (new BasicPick(this.ObbySwordID, EnumToolMaterialObby)).setItemName("ObbyPick").setIconIndex(24);
        ObbyShovel = (new BasicShovel(this.ObbyShovelID, EnumToolMaterialObby)).setItemName("ObbyShovel").setIconIndex(9);
        ObbyAxe = (new BasicAxe(this.ObbyAxeID, EnumToolMaterialObby)).setItemName("ObbyAxe").setIconIndex(18);
        ObbyHoe = (new BasicHoe(this.ObbyHoeID, EnumToolMaterialObby)).setItemName("ObbyHoe").setIconIndex(22);
        
        //Bloodstone
    	BloodstoneSword = (new BasicSword(this.BloodstonePickID, EnumToolMaterialBloodstone)).setItemName("BloodstoneSword").setIconIndex(5);
        BloodstonePick = (new BasicPick(this.BloodstoneSwordID, EnumToolMaterialBloodstone)).setItemName("BloodstonePick").setIconIndex(85);
        BloodstoneShovel = (new BasicShovel(this.BloodstoneShovelID, EnumToolMaterialBloodstone)).setItemName("BloodstoneShovel").setIconIndex(88);
        BloodstoneAxe = (new BasicAxe(this.BloodstoneAxeID, EnumToolMaterialBloodstone)).setItemName("BloodstoneAxe").setIconIndex(86);
        BloodstoneHoe = (new BasicHoe(this.BloodstoneHoeID, EnumToolMaterialBloodstone)).setItemName("BloodstoneHoe").setIconIndex(89);
        
        
        //Obsidian Tools
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(ObbySword, true, new Object[]{" I ", " I ", " X ", Character.valueOf('I'), "ingotObsidian", Character.valueOf('X'), "goldRod"}));
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(ObbyPick, true, new Object[]{"III", " X ", " X ", Character.valueOf('I'), "ingotObsidian", Character.valueOf('X'), "goldRod"}));
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(ObbyShovel, true, new Object[]{" I ", " X ", " X ", Character.valueOf('I'), "ingotObsidian", Character.valueOf('X'), "goldRod"}));
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(ObbyAxe, true, new Object[]{"II ", "IX ", " X ", Character.valueOf('I'), "ingotObsidian", Character.valueOf('X'), "goldRod"}));
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(ObbyHoe, true, new Object[]{"II ", " X ", " X ", Character.valueOf('I'), "ingotObsidian", Character.valueOf('X'), "goldRod"}));
    
        
        //Bloodstone Tools
        GameRegistry.addRecipe(new ItemStack(UnbindedSword,1), new Object[]{"   ", " B ", " F ", Character.valueOf('B'), BloodstoneBlade, Character.valueOf('F'), GoldenSwordFragment});
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(BloodstoneBlade, true, new Object[]{" X ", " X ", " X ", Character.valueOf('X'), "ingotBloodstone"}));
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(GoldenSwordFragment, true, new Object[]{" I ", "XIX", " X ", Character.valueOf('I'), "gemDragonstone", Character.valueOf('X'), "goldRod"}));
        
        //Bloodstone Tools
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(BloodstonePick, true, new Object[]{"III", " X ", " X ", Character.valueOf('I'), "ingotBloodstone", Character.valueOf('X'), "goldRod"}));
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(BloodstoneShovel, true, new Object[]{" I ", " X ", " X ", Character.valueOf('I'), "ingotBloodstone", Character.valueOf('X'), "goldRod"}));
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(BloodstoneAxe, true, new Object[]{"II ", "IX ", " X ", Character.valueOf('I'), "ingotBloodstone", Character.valueOf('X'), "goldRod"}));
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(BloodstoneHoe, true, new Object[]{"II ", " X ", " X ", Character.valueOf('I'), "ingotBloodstone", Character.valueOf('X'), "goldRod"}));
        
        GameRegistry.addSmelting(UnbindedSword.itemID, new ItemStack(BloodstoneSword.itemID, 1, 1), 0.5F);
        
        LanguageRegistry.addName(UnbindedSword, "UnBinded Sword");
        LanguageRegistry.addName(ObbySword, "Obsidian Sword");
        LanguageRegistry.addName(ObbyPick, "Obsidian Pickaxe");
        LanguageRegistry.addName(ObbyShovel, "Obsidian Shovel");
        LanguageRegistry.addName(ObbyAxe, "Obsidian Axe");
        LanguageRegistry.addName(ObbyHoe, "Obsidian Hoe");
    	LanguageRegistry.addName(BloodstoneSword, "Bloodstone Sword");
        LanguageRegistry.addName(BloodstonePick, "Bloodstone Pickaxe");
        LanguageRegistry.addName(BloodstoneShovel, "Bloodstone Shovel");
        LanguageRegistry.addName(BloodstoneAxe, "Bloodstone Axe");
        LanguageRegistry.addName(BloodstoneHoe, "Bloodstone Hoe");
        LanguageRegistry.addName(BloodstoneBlade, "Bloodstone Blade");
        LanguageRegistry.addName(GoldenSwordFragment, "Gold Sword Fragment");
        
        MinecraftForge.setToolClass(RCW.ObbyPick,    "pickaxe", 4); 
        MinecraftForge.setToolClass(RCW.ObbyShovel,  "shovel", 4);
        MinecraftForge.setToolClass(RCW.ObbyAxe,     "axe", 4);
        
        MinecraftForge.setToolClass(RCW.BloodstonePick,    "pickaxe", 5);
        MinecraftForge.setToolClass(RCW.BloodstoneShovel,  "shovel", 5);
        MinecraftForge.setToolClass(RCW.BloodstoneAxe,     "axe", 5);
        
        proxy.registerRenderInformation();
    }

    @PostInit
    public static void postInit(FMLPostInitializationEvent var0) {}
}
