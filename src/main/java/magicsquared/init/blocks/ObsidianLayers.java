package magicsquared.init.blocks;

import magicsquared.util;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class ObsidianLayers extends Block {

	private int layers;
	
	public ObsidianLayers(int layers) {
		super(FabricBlockSettings.copy(Blocks.OBSIDIAN).build());
		this.layers = layers;
		
	}

	@Override
	 public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, EntityContext ctx) {
		return VoxelShapes.cuboid(0f, 0f, 0f, 1f, (float)layers * 0.25f, 1.0f);
	 }
	
//	@Override
//	public boolean canReplace(BlockState state, ItemPlacementContext ctx) {
//		if(ctx.getStack().getItem() == ModBlocks.blockMap.get("block_obsidian_layers_1").asItem()) {
//			util.LOGGER.error("1");
//			BlockPos pos = ctx.getBlockPos();
//			if(state.getBlock() == ModBlocks.blockMap.get("block_obsidian_layers_3")) {
//				
//				ctx.getWorld().setBlockState(pos, Blocks.OBSIDIAN.getDefaultState());
//			}
//		}
//		return super.canReplace(state, ctx);
//	}
}
