package Reactioncraft.mobs.common;

import Reactioncraft.basic.common.ItemBasic;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "ModRCMM", name="Reactioncraft Mobs Mod", version="[1.4.7] Reactioncraft Version 7.0", dependencies="required-after:FML@[4.2.18,)")

@NetworkMod(channels = { "ModRCMM" }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)

public class ModRCMM 
{
	@SidedProxy(clientSide = "Reactioncraft.mobs.common.ClientProxy", serverSide = "Reactioncraft.mobs.common.CommonProxy")
	//@SidedProxy(clientSide = "Reactioncraft.basic.common.ClientProxy", serverSide = "Reactioncraft.basic.common.CommonProxy")
	
	public static CommonProxy proxy;
	
	@Instance("ModRCMM")
	public static ModRCMM instance;
	
	public static int JellyfishIID;
	public static int RcBeeIID;
	
	public static Item Jellyfish;
	public static Item RcBee;
	
	 @PreInit
	    public void preInit(FMLPreInitializationEvent var1)
	    {
	        Configuration var2 = new Configuration(var1.getSuggestedConfigurationFile());
	        var2.load();
	        
	        //10820 - 10840
	        JellyfishIID = var2.getItem("Jellyfish", 10820).getInt();
	        RcBeeIID = var2.getItem("Reactioncraft Bee", 10821).getInt();
	        
	        var2.save();
	    }

	@Init
	public void load(FMLInitializationEvent event)
	{
		MinecraftForge.EVENT_BUS.register(new LivingDropsEvent());
		proxy.registerRenderInformation();
		registerGlobal();
		registerEntities();
		addSpawn();
		items();
		langRegistry();
	}
	
	private void langRegistry() 
	{
		LanguageRegistry.addName(Jellyfish, "Jellyfish");
		LanguageRegistry.addName(RcBee, "Bee");
	}

	public void items() 
	{
		Jellyfish  = (new ItemBasic(JellyfishIID)).setIconCoord(193, 0).setItemName("Jellyfish");
		RcBee  = (new ItemBee(RcBeeIID)).setIconCoord(193, 0).setItemName("RcBee");
		OreDictionary.registerOre("jellyfish", new ItemStack(Jellyfish));
	}

	public void registerEntities()
	{
		EntityRegistry.registerGlobalEntityID(EntityBee.class, "Bee", EntityRegistry.findGlobalUniqueEntityId(), 0x333333, 0x999999);
		EntityRegistry.registerGlobalEntityID(EntityJellyfish.class, "Jellyfish", EntityRegistry.findGlobalUniqueEntityId(), 0x333333, 0x999999);
		EntityRegistry.registerGlobalEntityID(EntitySeaCreeper.class, "Sea Creeper", EntityRegistry.findGlobalUniqueEntityId(), 0x333333, 0x999999);
		EntityRegistry.registerGlobalEntityID(EntityStalker.class, "Stalker", EntityRegistry.findGlobalUniqueEntityId(), 0x333333, 0x999999);
		EntityRegistry.registerGlobalEntityID(EntityZombieCrawling.class, "Crawling Zombie", EntityRegistry.findGlobalUniqueEntityId(), 0x333333, 0x999999);
		EntityRegistry.registerGlobalEntityID(EntityCrawlingSkeleton.class, "Crawling Skeleton", EntityRegistry.findGlobalUniqueEntityId(), 0x333333, 0x999999);
	}

	public void registerGlobal()
	{
		LanguageRegistry.instance().addStringLocalization("entity.Bee.name", "en_US", "Bee");
		LanguageRegistry.instance().addStringLocalization("entity.Jellyfish.name", "en_US", "Jellyfish");
		LanguageRegistry.instance().addStringLocalization("entity.Sea Creeper.name", "en_US", "Seacreeper");
		LanguageRegistry.instance().addStringLocalization("entity.Stalker.name", "en_US", "Stalker");
		LanguageRegistry.instance().addStringLocalization("entity.Crawling Zombie.name", "en_US", "Crawling Zombie");
		LanguageRegistry.instance().addStringLocalization("entity.Crawling Skeleton.name", "en_US", "Crawling Skeleton");
	}
	
	public void addSpawn()
	{
		EntityRegistry.addSpawn(EntityBee.class, 5, 1, 2, EnumCreatureType.creature, new BiomeGenBase[]{BiomeGenBase.plains, BiomeGenBase.extremeHills, BiomeGenBase.desert});
		EntityRegistry.addSpawn(EntityJellyfish.class, 5, 1, 2, EnumCreatureType.waterCreature, new BiomeGenBase[]{BiomeGenBase.ocean});
		EntityRegistry.addSpawn(EntityStalker.class, 5, 1, 2, EnumCreatureType.monster, new BiomeGenBase[]{BiomeGenBase.plains, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.taiga});
		EntityRegistry.addSpawn(EntityZombieCrawling.class, 5, 1, 2, EnumCreatureType.monster, new BiomeGenBase[]{BiomeGenBase.plains, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.taiga});
		EntityRegistry.addSpawn(EntityCrawlingSkeleton.class, 5, 1, 2, EnumCreatureType.monster, new BiomeGenBase[]{BiomeGenBase.plains, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.taiga});
		EntityRegistry.addSpawn(EntitySeaCreeper.class, 5, 1, 2, EnumCreatureType.waterCreature, new BiomeGenBase[]{BiomeGenBase.ocean});
	}
}