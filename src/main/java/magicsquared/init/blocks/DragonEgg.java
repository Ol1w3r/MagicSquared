package magicsquared.init.blocks;

import java.util.Random;
import java.util.UUID;

import org.apache.logging.log4j.Level;

import magicsquared.util;
import magicsquared.init.blocks.blockentities.DragonEggBlockEntity;
import magicsquared.init.entities.DragonEntity;
import magicsquared.init.entities.ModEntities;
import magicsquared.interfaces.IGem;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class DragonEgg extends Block implements BlockEntityProvider, IGem {

	public static final IntProperty HATCH;
	private GemType type;
	
	public DragonEgg(GemType type) {
		super(FabricBlockSettings.of(Material.STONE).ticksRandomly().build());
		this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()));
		this.type = type;
		
	}
	
	@Override
	public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
		util.LOGGER.log(Level.WARN, "scheduledTicket: {}", type.getName());
//		if (this.shouldHatchProgress(world) && this.isOnGem(world, pos)) {
//			int i = (Integer)state.get(HATCH);
//			if (i < 2) {
//				world.playSound((PlayerEntity)null, pos, SoundEvents.ENTITY_TURTLE_EGG_CRACK, SoundCategory.BLOCKS, 0.7F, 0.9F + random.nextFloat() * 0.2F);
//				world.setBlockState(pos, (BlockState)state.with(HATCH, i + 1), 2);
//				util.LOGGER.log(Level.WARN, "hatch: {}", HATCH);
//			} else {
//				world.playSound((PlayerEntity)null, pos, SoundEvents.ENTITY_TURTLE_EGG_HATCH, SoundCategory.BLOCKS, 0.7F, 0.9F + random.nextFloat() * 0.2F);
//				world.removeBlock(pos, false);
//				
//				world.playLevelEvent(2001, pos, Block.getRawIdFromState(state));
				DragonEntity dragonEntity = (DragonEntity)ModEntities.entityMap.get("dragon_" + this.type.getName()).create(world);
				dragonEntity.refreshPositionAndAngles((double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), 0.0F, 0.0F);
				DragonEggBlockEntity be = (DragonEggBlockEntity)world.getBlockEntity(pos);
				if(be != null) {
					UUID uuid = be.getPlacer();
					dragonEntity.setOwnerUuid(uuid);
				}
//				world.spawnEntity(dragonEntity);
//				util.LOGGER.log(Level.WARN, "dragon hatched");
//			}
//		}
	}
	
	private boolean shouldHatchProgress(World world) {			
			return world.random.nextInt(20) == 0;
	}

	private boolean isOnGem(BlockView world, BlockPos pos) {
		String name;
		Block block = world.getBlockState(pos.down()).getBlock();
		for(GemType type: GemType.values()) {
			name = type.getName() + "_block";
			if(block == ModBlocks.blockMap.get(name)) {
				return true;
			}
		}
		return world.getBlockState(pos.down()).getBlock() == Blocks.SAND;
	}


	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(HATCH);
	}
	
	static {
		HATCH = Properties.HATCH;
	}

	@Override
	public BlockEntity createBlockEntity(BlockView view) {
		return new DragonEggBlockEntity(this.type);
	}

	@Override
	public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
		super.onPlaced(world, pos, state, placer, itemStack);
		if(!world.isClient)
			System.out.println();
		if(placer instanceof PlayerEntity)
			((DragonEggBlockEntity)world.getBlockEntity(pos)).SetOwner(placer.getUuid());
	}
	
	@Override
	public GemType getGemType() {
		return this.type;
	}
}
