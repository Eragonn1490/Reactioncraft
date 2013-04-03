package Reactioncraft.plantz.common;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import Reactioncraft.basic.common.CommonProxy;
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
//import Reactioncraft.plantz.common.ClientProxy;
//import Reactioncraft.plantz.common.CommonProxy;


@Mod( modid = "RCP", name="Reactioncraft Plantz", version="[1.4.7] Reactioncraft Version 7.0")
@NetworkMod(channels = { "RCP" }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)

public class RcPlantz
{
	//@SidedProxy(clientSide = "Reactioncraft.plantz.common.ClientProxy", serverSide = "Reactioncraft.plantz.common.CommonProxy")
	@SidedProxy(clientSide = "Reactioncraft.basic.common.ClientProxy", serverSide = "Reactioncraft.basic.common.CommonProxy")
	
	public static CommonProxy proxy;
	
	@Instance("RCP")
	public static RcPlantz instance;
	
	
	//config block
	public static int wildkushID;
    public static int orangekushID;     	
    public static int blueberryyyID; 
	public static int lemonkushID;     	
	public static int bluedreamID; 
	public static int fireID; 	
	public static int crystalID;
	public static int WildKPID;
	
	//config item
	public static int BlueDreamSeedIID;
	public static int BYYSeedIID;
	public static int CrystalSeedIID;
	public static int FireSeedIID;
	public static int LKSeedIID;
	public static int OKSeedIID;
	public static int WildKSeedIID;
	public static int BlueDreamBudIID;
	public static int BYYBudIID;
	public static int CrystalBudIID;
	public static int FireBudIID;
	public static int LKBudIID;
	public static int OKBudIID;
	public static int TokeIID;
	
	
	//Blocks
	public static Block WildKush;
    public static Block OrangeKush;     	
    public static Block Blueberryyy; 
	public static Block LemonKush;     	
	public static Block BlueDream; 
	public static Block Fire; 	
	public static Block Crystal;
	public static Block WildKushPlant;
	
	//Items
	
	//Seeds
    public static Item BlueDreamSeed;
    public static Item BYYSeed;
    public static Item CrystalSeed;
    public static Item FireSeed;
    public static Item LKSeed;
    public static Item OKSeed;
    public static Item WildKSeed;
    
    
    //Leaves
    public static Item BlueDreamBud;
    public static Item BYYBud;
    public static Item CrystalBud;
    public static Item FireBud;
    public static Item LKBud;
    public static Item OKBud;
    public static Item Toke;
    
    @PreInit
	 public void preInit(FMLPreInitializationEvent evt)
	 {
	 //This is new! put stuff here that you want to happen before the mods are loaded
		
		 MinecraftForge.EVENT_BUS.register(new RcBonemealProvider());
		 
		 Configuration config = new Configuration(evt.getSuggestedConfigurationFile());

        config.load();
        
        //Claimed IDs 3091 - 3120
        wildkushID = config.getBlock("WildKush", 3091).getInt();
        orangekushID = config.getBlock("Kush2", 3092).getInt();
        blueberryyyID = config.getBlock("Kush3", 3093).getInt();
        lemonkushID = config.getBlock("Kush4", 3094).getInt();
        bluedreamID = config.getBlock("Kush5", 3095).getInt();
        fireID = config.getBlock("Kush6", 3096).getInt();
        crystalID = config.getBlock("Kush7", 3097).getInt();
        WildKPID = config.getBlock("WildKush Plant", 3098).getInt();
        
        //Claimed Item IDS 10881 - 10920
        BlueDreamSeedIID = config.getItem("Blue Dream Seed", 10881).getInt();
        BYYSeedIID = config.getItem("Blueberry Yum Yum Seed", 10882).getInt();
        CrystalSeedIID = config.getItem("Crystal Seed", 10883).getInt();
        FireSeedIID = config.getItem("Fire Seed", 10884).getInt();
        LKSeedIID = config.getItem("Lemon Kush Seed", 10885).getInt();
        OKSeedIID = config.getItem("Orange Kush Seed", 10886).getInt();
        WildKSeedIID = config.getItem("Kush Seed", 10887).getInt();
        
        
        BlueDreamBudIID = config.getItem("Blue Dream Bud ", 10888).getInt();
        BYYBudIID = config.getItem("Blueberry Yum Yum Bud", 10889).getInt();
        CrystalBudIID = config.getItem("Crystal Bud ", 10890).getInt();
        FireBudIID = config.getItem("Fire Bud ", 10891).getInt();
        LKBudIID = config.getItem("Lemon Kush Bud", 10892).getInt();
        OKBudIID = config.getItem("Orange Kush Bud", 10893).getInt();
        TokeIID = config.getItem("Bud", 10894).getInt();
        
        config.save();
	 }
     
    
	 @Init
	 public void load(FMLInitializationEvent event)
	 {
	 	//the meat of the mod
		//Claimed Block Ids 3051 - 3099
		proxy.registerRenderInformation();
		
		WildKushPlant = new BlockWK(WildKPID, 8).setHardness(0.0F).setResistance(1.0F).setBlockName("WildKush");
		WildKush = new BlockWildK(wildkushID, 15).setResistance(1.0F).setBlockName("WildKush");
		OrangeKush = new BlockOK(orangekushID, 96).setHardness(0.0F).setResistance(1.0F).setBlockName("OrangeKush");
		Blueberryyy = new BlockBbyyy(blueberryyyID, 16).setHardness(0.0F).setResistance(1.0F).setBlockName("Blueberryyy");
		LemonKush = new BlockLK(lemonkushID, 32).setHardness(0.0F).setResistance(1.0F).setBlockName("LemonKush");
		BlueDream = new BlockBD(bluedreamID, 48).setHardness(0.0F).setResistance(1.0F).setBlockName("BlueDream");
		Fire = new BlockKF(fireID, 64).setHardness(0.0F).setResistance(1.0F).setBlockName("Fire");
		Crystal = new BlockCK(crystalID, 80).setHardness(0.0F).setResistance(1.0F).setBlockName("Crystal");
		
		BlueDreamSeed = (new PlantzSeed(BlueDreamSeedIID, RcPlantz.BlueDream.blockID, Block.tilledField.blockID)).setIconCoord(24, 0).setItemName("BlueDreamSeed");
        BYYSeed = (new PlantzSeed(BYYSeedIID, RcPlantz.Blueberryyy.blockID, Block.tilledField.blockID)).setIconCoord(24, 0).setItemName("BYYSeed");
        CrystalSeed = (new PlantzSeed(CrystalSeedIID, RcPlantz.Crystal.blockID, Block.tilledField.blockID)).setIconCoord(88, 0).setItemName("CrystalSeed");
        FireSeed = (new PlantzSeed(FireSeedIID, RcPlantz.Fire.blockID, Block.tilledField.blockID)).setIconCoord(72, 0).setItemName("FireSeed");
        LKSeed = (new PlantzSeed(LKSeedIID, RcPlantz.LemonKush.blockID, Block.tilledField.blockID)).setIconCoord(40, 0).setItemName("LKSeed");
        OKSeed = (new PlantzSeed(OKSeedIID, RcPlantz.OrangeKush.blockID, Block.tilledField.blockID)).setIconCoord(8, 0).setItemName("OKSeed");	
        WildKSeed = new PlantzSeed(WildKSeedIID, RcPlantz.WildKushPlant.blockID, Block.tilledField.blockID).setIconCoord(88, 0).setItemName("Toke");	
		
        BlueDreamBud = new PlantzBasic(BlueDreamBudIID).setIconCoord(25, 0).setItemName("BlueDreamBud");
        BYYBud = new PlantzBasic(BYYBudIID).setIconCoord(25, 0).setItemName("BYYBud");
        CrystalBud = new PlantzBasic(CrystalBudIID).setIconCoord(89, 0).setItemName("CrystalBud");
        FireBud = new PlantzBasic(FireBudIID).setIconCoord(73, 0).setItemName("FireBud");
        LKBud = new PlantzBasic(LKBudIID).setIconCoord(41, 0).setItemName("LKBud");
        OKBud = new PlantzBasic(OKBudIID).setIconCoord(9, 0).setItemName("OKBud");
        Toke = new PlantzBasic(TokeIID).setIconCoord(89, 0).setItemName("Bud");
        
		//Regular Weed Code
		GameRegistry.registerBlock(WildKush);
		GameRegistry.registerBlock(OrangeKush);
		GameRegistry.registerBlock(Blueberryyy);
		GameRegistry.registerBlock(LemonKush);
		GameRegistry.registerBlock(BlueDream);
		GameRegistry.registerBlock(Fire);
		GameRegistry.registerBlock(Crystal);
		GameRegistry.registerBlock(WildKushPlant);
		
		addNames();
		oreRegistration();
		addWorldGen();  
		}
	 
	 
	 private void addNames() 
	 {
		    // TODO Auto-generated method stub
		    LanguageRegistry.addName(WildKush, "WildKush");
			LanguageRegistry.addName(BlueDreamSeed, "BlueDream Seed");
			LanguageRegistry.addName(BYYSeed, "Blueberry Yum Yum Seed");
			LanguageRegistry.addName(CrystalSeed, "Crystal Seed");
			LanguageRegistry.addName(FireSeed, "Fire Seed");
			LanguageRegistry.addName(LKSeed, "Lemon Kush Seed");
			LanguageRegistry.addName(OKSeed, "Orange Kush Seed");
			LanguageRegistry.addName(WildKSeed, "Toke Seed");
			
			LanguageRegistry.addName(BlueDreamBud, "BlueDream Bud");
			LanguageRegistry.addName(BYYBud, "Blue Berry Yum Yum Bud");
			LanguageRegistry.addName(CrystalBud, "Crystal Bud");
			LanguageRegistry.addName(FireBud, "Fire Bud");
			LanguageRegistry.addName(LKBud, "Lemon Kush Bud");
			LanguageRegistry.addName(OKBud, "Orange Kush Bud");
			LanguageRegistry.addName(Toke, "Toke Bud");
	 }


	public void oreRegistration() 
	 {
		    //Whore Dictionary Code
			OreDictionary.registerOre("BlueDreamBud", new ItemStack(Blueberryyy));
			OreDictionary.registerOre("BYYBud", new ItemStack(BYYBud));
			OreDictionary.registerOre("CrystalBud", new ItemStack(CrystalBud));
			OreDictionary.registerOre("FireBud", new ItemStack(FireBud));
			OreDictionary.registerOre("LKBud", new ItemStack(LKBud));
			OreDictionary.registerOre("OKBud", new ItemStack(OKBud));
			OreDictionary.registerOre("Toke", new ItemStack(Toke));
	 }


	public void addWorldGen()
	 {
		    GameRegistry.registerWorldGenerator(new WorldGenHandler());
	 }
	 
	 
	 @PostInit
	 public void modsLoaded(FMLPostInitializationEvent evt)
	 {
	 
	 }
	 
	 
}
