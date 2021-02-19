package modjam.the_little_mob.biomadventure.world.gen;

import modjam.the_little_mob.biomadventure.core.init.BlockInit;
import net.minecraft.block.Block;

public enum OreType {

	DESERT_ROSE(BlockInit.DESERT_ROSE_BLOCK.get(), 8, 30, 100,64, 16),
	GEODE(BlockInit.GEODE_BLOCK.get(), 4, 10, 100,64, 15),
	FOSSIL(BlockInit.FOSSIL_BLOCK.get(), 4, 30, 80,64, 18),
	ICE(BlockInit.MYSTERY_ICE.get(), 4, 30, 80,64, 18),
	GARNET(BlockInit.GARNET_ORE.get(), 5, 15, 60,64, 15),
	DYE(BlockInit.DYE_ORE.get(), 5, 20, 100,64, 15),
	MUSHROOM(BlockInit.MUSHROOM_ORE.get(), 8, 20, 60,64, 20),
	SLIME(BlockInit.SLIME_ORE.get(), 6, 20, 50,64, 15);
	
	private final Block block;
	private final int maxVeinSize;
	private final int minHeight;
	private final int maxHeight;
	private final int range;
	private final int nbrVein;
	
	private OreType(Block block, int maxVeinSize, int minHeight, int maxHeight, int range, int nbrVein) {
		this.block = block;
		this.maxHeight = maxHeight;
		this.maxVeinSize = maxVeinSize;
		this.minHeight = minHeight;
		this.range = range;
		this.nbrVein = nbrVein;
	}

	public int getMaxHeight() {
		return maxHeight;
	}

	public int getMinHeight() {
		return minHeight;
	}

	public Block getBlock() {
		return block;
	}

	public int getMaxVeinSize() {
		return maxVeinSize;
	}

	public int getRange() {
		return range;
	}
	
	public int getNbrVein() {
		return nbrVein;
	}
	
	public static OreType get(Block block) {
		for(OreType ore : values()) {
			if(block == ore.block) {
				return ore;
			}
		}
		return null;
	}
}
