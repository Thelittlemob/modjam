package modjam.the_little_mob.biomadventure.core.init;

import modjam.the_little_mob.biomadventure.Biomadventure;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Biomadventure.MODID);

	//ITEMS
	public static final RegistryObject<Item> DESERT_ROSE = ITEMS
			.register("desert_rose", () -> new Item(new Item.Properties().group(Biomadventure.BIOMADVENTURE_GROUP_MATERIALS)));

	public static final RegistryObject<Item> AMETHYSTE = ITEMS
			.register("amethyste", () -> new Item(new Item.Properties().group(Biomadventure.BIOMADVENTURE_GROUP_MATERIALS)));

	public static final RegistryObject<Item> CITRINE = ITEMS
			.register("citrine", () -> new Item(new Item.Properties().group(Biomadventure.BIOMADVENTURE_GROUP_MATERIALS)));

	public static final RegistryObject<Item> NAUTILUS_FOSSIL = ITEMS
			.register("nautilus_fossil", () -> new Item(new Item.Properties().group(Biomadventure.BIOMADVENTURE_GROUP_MATERIALS)));

	public static final RegistryObject<Item> TRILOBITE_FOSSIL = ITEMS
			.register("trilobite_fossil", () -> new Item(new Item.Properties().group(Biomadventure.BIOMADVENTURE_GROUP_MATERIALS)));

	public static final RegistryObject<Item> GARNET = ITEMS
			.register("garnet", () -> new Item(new Item.Properties().group(Biomadventure.BIOMADVENTURE_GROUP_MATERIALS)));
	
	//BLOCKITEMS ORE
	public static final RegistryObject<BlockItem> DESERT_ROSE_BLOCK = ITEMS
			.register("desert_rose_block", () -> new BlockItem(BlockInit.DESERT_ROSE_BLOCK.get(), 
					new Item.Properties().group(Biomadventure.BIOMADVENTURE_GROUP_BLOCKS)));	

	public static final RegistryObject<BlockItem> GEODE_BLOCK = ITEMS
			.register("geode_block", () -> new BlockItem(BlockInit.GEODE_BLOCK.get(), 
					new Item.Properties().group(Biomadventure.BIOMADVENTURE_GROUP_BLOCKS)));

	public static final RegistryObject<BlockItem> FOSSIL_BLOCK = ITEMS
			.register("fossil_block", () -> new BlockItem(BlockInit.FOSSIL_BLOCK.get(), 
					new Item.Properties().group(Biomadventure.BIOMADVENTURE_GROUP_BLOCKS)));
	
	public static final RegistryObject<BlockItem> MYSTERY_ICE = ITEMS
			.register("mystery_ice", () -> new BlockItem(BlockInit.MYSTERY_ICE.get(), 
					new Item.Properties().group(Biomadventure.BIOMADVENTURE_GROUP_BLOCKS)));
	
	public static final RegistryObject<BlockItem> GARNET_ORE = ITEMS
			.register("garnet_ore", () -> new BlockItem(BlockInit.GARNET_ORE.get(), 
					new Item.Properties().group(Biomadventure.BIOMADVENTURE_GROUP_BLOCKS)));
	
	public static final RegistryObject<BlockItem> DYE_ORE = ITEMS
			.register("dye_ore", () -> new BlockItem(BlockInit.DYE_ORE.get(), 
					new Item.Properties().group(Biomadventure.BIOMADVENTURE_GROUP_BLOCKS)));
	
	public static final RegistryObject<BlockItem> MUSHROOM_ORE = ITEMS
			.register("mushroom_ore", () -> new BlockItem(BlockInit.MUSHROOM_ORE.get(), 
					new Item.Properties().group(Biomadventure.BIOMADVENTURE_GROUP_BLOCKS)));
	
	public static final RegistryObject<BlockItem> SLIME_ORE = ITEMS
			.register("slime_ore", () -> new BlockItem(BlockInit.SLIME_ORE.get(), 
					new Item.Properties().group(Biomadventure.BIOMADVENTURE_GROUP_BLOCKS)));
	
	//BLOCK ITEM
	
	public static final RegistryObject<BlockItem> BIOMULTI_BLOCK = ITEMS
			.register("biomulti_block", () -> new BlockItem(BlockInit.BIOMULTI_BLOCK.get(), 
					new Item.Properties().group(Biomadventure.BIOMADVENTURE_GROUP_BLOCKS)));
	
	//CUSTOM BLOCKS
	public static final RegistryObject<BlockItem> GEODE = ITEMS
			.register("geode", () -> new BlockItem(BlockInit.GEODE.get(),
					new Item.Properties().group(Biomadventure.BIOMADVENTURE_GROUP_BLOCKS).maxStackSize(1)));

	public static final RegistryObject<BlockItem> ICE_MONSTER = ITEMS
			.register("ice_monster", () -> new BlockItem(BlockInit.ICE_MONSTER.get(),
					new Item.Properties().group(Biomadventure.BIOMADVENTURE_GROUP_BLOCKS).maxStackSize(1)));
}