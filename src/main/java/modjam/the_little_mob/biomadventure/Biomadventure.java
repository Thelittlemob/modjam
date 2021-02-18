package modjam.the_little_mob.biomadventure;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modjam.the_little_mob.biomadventure.core.init.BlockInit;
import modjam.the_little_mob.biomadventure.core.init.ItemInit;
import modjam.the_little_mob.biomadventure.core.setup.ClientProxy;
import modjam.the_little_mob.biomadventure.core.setup.IProxy;
import modjam.the_little_mob.biomadventure.core.setup.ServerProxy;
import modjam.the_little_mob.biomadventure.core.util.Config;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod(Biomadventure.MODID)
public class Biomadventure {
		
		public static final String MODID = "biomadventure";
		
	    public static final Logger LOGGER = LogManager.getLogger();

	    public static final ItemGroup BIOMADVENTURE_GROUP_BLOCKS = new BiomadventureGroupBlockitem("biomadventure_blocks", ItemInit.DESERT_ROSE_BLOCK);
	    public static final ItemGroup BIOMADVENTURE_GROUP_MATERIALS = new BiomadventureGroupItem("biomadventure_materials", ItemInit.AMETHYSTE);
	   

	    public static IProxy proxy;
	    
	    public Biomadventure() {
	    	
	    	proxy = DistExecutor.safeRunForDist(()->ClientProxy::new, ()->ServerProxy::new);
	    	
	    	IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
	        bus.addListener(this::setup);
	        
	        registerModAdditions(bus);
	        
	        MinecraftForge.EVENT_BUS.register(this);
	    }

	    private void setup(final FMLCommonSetupEvent event){
	    	registerConfigs();
	    	proxy.init();
	    	loadConfigs();
	    }
	    
	    private void registerConfigs() {
	    	ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.CLIENT_CONFIG);
	    	ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.SERVER_CONFIG);
	    }
	    
	    private void loadConfigs() {
	        Config.loadConfigFile(Config.CLIENT_CONFIG, FMLPaths.CONFIGDIR.get().resolve("biomadventure-client.toml").toString());
	        Config.loadConfigFile(Config.SERVER_CONFIG, FMLPaths.CONFIGDIR.get().resolve("biomadventure-server.toml").toString());
	    }
	    
	    private void registerModAdditions(IEventBus bus) {
	        ItemInit.ITEMS.register(bus);
	        BlockInit.BLOCKS.register(bus);
	    }
	    
	    //Pour les creatives tab
	    public static class BiomadventureGroupItem extends ItemGroup{

	    	public RegistryObject<Item> icon;

			public BiomadventureGroupItem(String label, RegistryObject<Item> icon) {
				super(label);
				this.icon = icon;
			}

			//Logo du creative tab
			public ItemStack createIcon() {
				return icon.get().getDefaultInstance();
			}
	    }

	    public static class BiomadventureGroupBlockitem extends ItemGroup{

	    	public RegistryObject<BlockItem> icon;

			public BiomadventureGroupBlockitem(String label, RegistryObject<BlockItem> icon) {
				super(label);
				this.icon = icon;
			}
			public ItemStack createIcon() {
				return icon.get().getDefaultInstance();
			}
	    }
}
