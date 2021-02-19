package modjam.the_little_mob.biomadventure.world.gen;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

import com.google.common.collect.Lists;

import modjam.the_little_mob.biomadventure.Biomadventure;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.DepthAverageConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = Biomadventure.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class OreGeneration {
	
	@SubscribeEvent
	public static void generateOres(FMLLoadCompleteEvent event) {
		System.out.println("GENERATION !!\n\n\n");
		for(OreType ore: OreType.values()) {
			OreFeatureConfig oreFeatureConfig = new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, ore.getBlock().getDefaultState(), ore.getMaxVeinSize());
			@SuppressWarnings("rawtypes")
			ConfiguredPlacement configuredPlacement = Placement.DEPTH_AVERAGE.configure(new DepthAverageConfig(ore.getMinHeight(), ore.getMaxHeight()));
			Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, ore.getBlock()
					.getRegistryName(), Feature.ORE
					.withConfiguration(oreFeatureConfig)
					.withPlacement(configuredPlacement)
					.range(ore.getRange())
					.square()
					.func_242731_b(ore.getNbrVein()));

			System.out.println("\n\nOre = "+ ore + "\n\n");
			for(Biome biome: ForgeRegistries.BIOMES) {
				if(!(biome.getCategory().equals(Biome.Category.NETHER) || biome.getCategory().equals(Biome.Category.THEEND))) {
					RegistryKey<Biome> key = RegistryKey.getOrCreateKey(Registry.BIOME_KEY, biome.getRegistryName());
					Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(key);

					System.out.println("Biome = "+ biome +" Category = "+biome.getCategory()+" KEY = "+ key +" TYPE = "+ types);
					if(ore == OreType.GEODE && (types.contains(BiomeDictionary.Type.MOUNTAIN) || biome.getCategory().equals(Biome.Category.EXTREME_HILLS))) {
						addFeatureToBiome(biome, GenerationStage.Decoration.UNDERGROUND_ORES, WorldGenRegistries.CONFIGURED_FEATURE.getOrDefault(ore.getBlock().getRegistryName()));
						System.out.println("\nGEODE !!\n");
					}
					else if(ore == OreType.DESERT_ROSE && biome.getCategory().equals(Biome.Category.DESERT)) {
						addFeatureToBiome(biome, GenerationStage.Decoration.UNDERGROUND_ORES, WorldGenRegistries.CONFIGURED_FEATURE.getOrDefault(ore.getBlock().getRegistryName()));
						System.out.println("\nROSE !!\n");
					}
					else if(ore == OreType.FOSSIL && biome.getCategory().equals(Biome.Category.FOREST)) {
						addFeatureToBiome(biome, GenerationStage.Decoration.UNDERGROUND_ORES, WorldGenRegistries.CONFIGURED_FEATURE.getOrDefault(ore.getBlock().getRegistryName()));
						System.out.println("\nFOSSIL !!\n");
					}
					else if(ore == OreType.ICE && (types.contains(BiomeDictionary.Type.SNOWY) || biome.getCategory().equals(Biome.Category.ICY))) {
						addFeatureToBiome(biome, GenerationStage.Decoration.UNDERGROUND_ORES, WorldGenRegistries.CONFIGURED_FEATURE.getOrDefault(ore.getBlock().getRegistryName()));
						System.out.println("\nICE !!\n");
					}
					else if(ore == OreType.GARNET && biome.getCategory().equals(Biome.Category.JUNGLE)) {
						addFeatureToBiome(biome, GenerationStage.Decoration.UNDERGROUND_ORES, WorldGenRegistries.CONFIGURED_FEATURE.getOrDefault(ore.getBlock().getRegistryName()));
						System.out.println("\nGARNET !!\n");
					}
					else if(ore == OreType.DYE && biome.getCategory().equals(Biome.Category.MESA)) {
						addFeatureToBiome(biome, GenerationStage.Decoration.UNDERGROUND_ORES, WorldGenRegistries.CONFIGURED_FEATURE.getOrDefault(ore.getBlock().getRegistryName()));
						System.out.println("\nDYE !!\n");
					}
					else if(ore == OreType.MUSHROOM && biome.getCategory().equals(Biome.Category.MUSHROOM)) {
						addFeatureToBiome(biome, GenerationStage.Decoration.UNDERGROUND_ORES, WorldGenRegistries.CONFIGURED_FEATURE.getOrDefault(ore.getBlock().getRegistryName()));
						System.out.println("\nMUSHROOM !!\n");
					}
					else if(ore == OreType.SLIME && biome.getCategory().equals(Biome.Category.SWAMP)) {
						addFeatureToBiome(biome, GenerationStage.Decoration.UNDERGROUND_ORES, WorldGenRegistries.CONFIGURED_FEATURE.getOrDefault(ore.getBlock().getRegistryName()));
						System.out.println("\nSLIME !!\n");
					}
				}
			}
		}
	}
	
	public static void addFeatureToBiome(Biome biome, GenerationStage.Decoration decoration, ConfiguredFeature<?, ?> configuredFeature) {
        List<List<Supplier<ConfiguredFeature<?, ?>>>> biomeFeatures = new ArrayList<>(
                biome.getGenerationSettings().getFeatures()
        );

        while (biomeFeatures.size() <= decoration.ordinal()) {
            biomeFeatures.add(Lists.newArrayList());
        }

        List<Supplier<ConfiguredFeature<?, ?>>> features = new ArrayList<>(biomeFeatures.get(decoration.ordinal()));
        features.add(() -> configuredFeature);
        biomeFeatures.set(decoration.ordinal(), features);

        /* Change field_242484_f that contains the Configured Features of the Biome*/
        ObfuscationReflectionHelper.setPrivateValue(BiomeGenerationSettings.class, biome.getGenerationSettings(),
                biomeFeatures, "field_242484_f");
    }
}
