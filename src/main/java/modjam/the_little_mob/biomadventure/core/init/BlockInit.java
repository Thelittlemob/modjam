package modjam.the_little_mob.biomadventure.core.init;

import java.util.stream.Stream;

import modjam.the_little_mob.biomadventure.Biomadventure;
import modjam.the_little_mob.biomadventure.common.blocks.CustomBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Biomadventure.MODID);

	//ORE BLOCKS
	public static final RegistryObject<Block> DESERT_ROSE_BLOCK = BLOCKS
			.register("desert_rose_block", () -> new Block(AbstractBlock.Properties.create(Material.CLAY, MaterialColor.SAND)
					.harvestTool(ToolType.SHOVEL)
					.harvestLevel(1)
					.setRequiresTool()
					.hardnessAndResistance(2.0f, 3.0f)
					.sound(SoundType.LODESTONE)));
	

	public static final RegistryObject<Block> GEODE_BLOCK = BLOCKS
			.register("geode_block", () -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE)
					.harvestTool(ToolType.PICKAXE)
					.harvestLevel(1)
					.setRequiresTool()
					.hardnessAndResistance(3.0f, 3.0f)
					.sound(SoundType.STONE)));

	public static final RegistryObject<Block> FOSSIL_BLOCK = BLOCKS
			.register("fossil_block", () -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.SAND)
					.harvestTool(ToolType.PICKAXE)
					.harvestLevel(1)
					.setRequiresTool()
					.hardnessAndResistance(2.0f, 2.0f)
					.sound(SoundType.BONE)));

	public static final RegistryObject<Block> MYSTERY_ICE = BLOCKS
			.register("mystery_ice", () -> new Block(AbstractBlock.Properties.create(Material.ICE, MaterialColor.ICE)
					.harvestTool(ToolType.PICKAXE)
					.harvestLevel(2)
					.setRequiresTool()
					.hardnessAndResistance(4.0f, 6.0f)
					.sound(SoundType.GLASS)));
	
	//CUSTOM BLOCK
	public static final RegistryObject<CustomBlock> GEODE = BLOCKS
			.register("geode", () -> new CustomBlock(AbstractBlock.Properties.create(Material.ROCK)
					.harvestTool(ToolType.PICKAXE)
					.harvestLevel(2)
					.setRequiresTool()
					.hardnessAndResistance(4.0f, 8.0f)
					.sound(SoundType.STONE),
					Stream.of(
							Block.makeCuboidShape(5, 2, 5, 11, 3, 11),
							Block.makeCuboidShape(5, 15, 5, 11, 16, 11),
							Block.makeCuboidShape(4, 3, 4, 12, 4, 12),
							Block.makeCuboidShape(3, 4, 3, 13, 5, 13),
							Block.makeCuboidShape(3, 13, 3, 13, 14, 13),
							Block.makeCuboidShape(3, 5, 3, 4, 13, 13),
							Block.makeCuboidShape(12, 5, 3, 13, 13, 13),
							Block.makeCuboidShape(4, 14, 4, 12, 15, 12),
							Block.makeCuboidShape(2, 5, 4, 3, 13, 12),
							Block.makeCuboidShape(4, 5, 2, 12, 13, 3),
							Block.makeCuboidShape(4, 5, 13, 12, 13, 14),
							Block.makeCuboidShape(5, 6, 14, 11, 12, 15),
							Block.makeCuboidShape(5, 6, 1, 11, 12, 2),
							Block.makeCuboidShape(13, 5, 4, 14, 13, 12),
							Block.makeCuboidShape(14, 6, 5, 15, 12, 11),
							Block.makeCuboidShape(1, 6, 5, 2, 12, 11),
							Block.makeCuboidShape(0, 0, 0, 16, 2, 16)
							).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get()));

	public static final RegistryObject<CustomBlock> ICE_MONSTER = BLOCKS
			.register("ice_monster", () -> new CustomBlock(AbstractBlock.Properties.create(Material.ICE)
					.harvestTool(ToolType.PICKAXE)
					.harvestLevel(2)
					.setRequiresTool()
					.hardnessAndResistance(4.0f, 6.0f)
					.sound(SoundType.GLASS),
					Stream.of(
							Block.makeCuboidShape(11, 8, 7, 12, 11, 9),
							Block.makeCuboidShape(5, 4, 5, 11, 10, 11),
							Block.makeCuboidShape(4, 8, 7, 5, 11, 9),
							Block.makeCuboidShape(0, 0, 0, 16, 4, 16),
							Block.makeCuboidShape(1, 4, 6, 5, 5, 11),
							Block.makeCuboidShape(11, 4, 5, 13, 5, 11),
							Block.makeCuboidShape(5, 4, 2, 12, 5, 5),
							Block.makeCuboidShape(3, 4, 13, 14, 5, 15),
							Block.makeCuboidShape(12, 4, 10, 15, 11, 13),
							Block.makeCuboidShape(3, 4, 12, 7, 12, 14),
							Block.makeCuboidShape(1, 2, 11, 3, 16, 14),
							Block.makeCuboidShape(7, 4, 11, 11, 14, 16),
							Block.makeCuboidShape(1, 2, 1, 5, 8, 4),
							Block.makeCuboidShape(12, 2, 1, 15, 11, 4),
							Block.makeCuboidShape(7.049999999999999, 12, 12.5, 10.95, 15.5, 16),
							Block.makeCuboidShape(1.0500000000000003, 11.75, 4.1, 2.95, 13.95, 6.1),
							Block.makeCuboidShape(13.1, 10.05, 10.05, 15.250000000000002, 12.170000000000002, 12.950000000000001)
							).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get()));
}
