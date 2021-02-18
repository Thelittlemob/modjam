package modjam.the_little_mob.biomadventure.common.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class CustomBlock extends BaseHorizontalBlock{

	public CustomBlock(Properties properties) {
		super(properties);
	}
	
	public CustomBlock(Properties properties, VoxelShape voxelShape) {
		super(properties);
		runCalculation(voxelShape);
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPES.get(this).get(state.get(HORIZONTAL_FACING));
	}
}
