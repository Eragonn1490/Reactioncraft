package Reactioncraft.tools.common;

import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.ShapedOreRecipe;
import Reactioncraft.basic.common.BasicSword;
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
        
        config.save();
    }

    @Init
    public void init(FMLInitializationEvent var1)
    {
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
        
        
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(ObbySword, true, new Object[]{" I ", " I ", " X ", Character.valueOf('I'), "ingotObsidian", Character.valueOf('X'), "goldRod"}));
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(ObbyPick, true, new Object[]{"III", " X ", " X ", Character.valueOf('I'), "ingotObsidian", Character.valueOf('X'), "goldRod"}));
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(ObbyShovel, true, new Object[]{" I ", " X ", " X ", Character.valueOf('I'), "ingotObsidian", Character.valueOf('X'), "goldRod"}));
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(ObbyAxe, true, new Object[]{"II ", "IX ", " X ", Character.valueOf('I'), "ingotObsidian", Character.valueOf('X'), "goldRod"}));
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(ObbyHoe, true, new Object[]{"II ", " X ", " X ", Character.valueOf('I'), "ingotObsidian", Character.valueOf('X'), "goldRod"}));
    	CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(BloodstoneSword, true, new Object[]{" I ", " I ", " X ", Character.valueOf('I'), "ingotBloodstone", Character.valueOf('X'), "goldRod"}));
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(BloodstonePick, true, new Object[]{"III", " X ", " X ", Character.valueOf('I'), "ingotBloodstone", Character.valueOf('X'), "goldRod"}));
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(BloodstoneShovel, true, new Object[]{" I ", " X ", " X ", Character.valueOf('I'), "ingotBloodstone", Character.valueOf('X'), "goldRod"}));
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(BloodstoneAxe, true, new Object[]{"II ", "IX ", " X ", Character.valueOf('I'), "ingotBloodstone", Character.valueOf('X'), "goldRod"}));
        CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(BloodstoneHoe, true, new Object[]{"II ", " X ", " X ", Character.valueOf('I'), "ingotBloodstone", Character.valueOf('X'), "goldRod"}));
        
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
        
        MinecraftForge.setToolClass(RCW.ObbyPick,    "pickaxe", 4); 
        MinecraftForge.setToolClass(RCW.ObbyShovel,  "pickaxe", 4);
        MinecraftForge.setToolClass(RCW.ObbyAxe,     "pickaxe", 3);
        
        MinecraftForge.setToolClass(RCW.BloodstonePick,    "pickaxe", 5);
        MinecraftForge.setToolClass(RCW.BloodstoneShovel,  "pickaxe", 5);
        MinecraftForge.setToolClass(RCW.BloodstoneAxe,     "pickaxe", 3);
        
        proxy.registerRenderInformation();
    }

    @PostInit
    public static void postInit(FMLPostInitializationEvent var0) {}
}
