package magicsquared.init.items;

import java.util.Random;

import magicsquared.init.blocks.ModBlocks;
import magicsquared.interfaces.IGem;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GemItem extends BasicItem implements IGem {

	private GemType type;
	
	public GemItem(GemType type) {
		
		super();
		
		this.type = type;
	}

	@Override
	public GemType getGemType() {
		return type;
	}
	
	@Override
	public ActionResult useOnBlock(ItemUsageContext context) {

		if(type.getHardness() > 6) {
			
			World w = context.getWorld();
			BlockPos pos = context.getBlockPos();
			BlockState bs = w.getBlockState(pos);
			Block b = bs.getBlock();
			
			double x = pos.getX();
			double y = pos.getY();
			double z = pos.getZ();
			
			if (b == Blocks.OBSIDIAN) {
				w.breakBlock(pos, false);
				w.setBlockState(pos, ModBlocks.blockMap.get("obsidian_layers_3").getDefaultState());

				drop(w, x, y, z);
			}
			else if (b == ModBlocks.blockMap.get("obsidian_layers_3")) {
				w.breakBlock(pos, false);
				w.setBlockState(pos, ModBlocks.blockMap.get("obsidian_layers_2").getDefaultState());
				
				drop(w, x, y, z);
			}
			else if (b == ModBlocks.blockMap.get("obsidian_layers_2")) {
				w.breakBlock(pos, false);
				w.setBlockState(pos, ModBlocks.blockMap.get("obsidian_layers_1").getDefaultState());
				
				drop(w, x, y, z);
			}
			else if (b == ModBlocks.blockMap.get("obsidian_layers_1")) {
				w.breakBlock(pos, false);
				
				drop(w, x, y, z);
			}
		}
		
		return super.useOnBlock(context);
	}
	
	private void drop(World w, double x, double y, double z) {
		Random random = new Random();
		int i = random.nextInt(5);

		ItemEntity itemEntity = new ItemEntity(w, x, y, z, new ItemStack(ModItems.basicItemMap.get("obsidian_shard"), i == 4 ? 2 : 1));
		
		switch(i) {
		case 0:
		case 1:
			break;
		case 2:
		case 3:
		case 4:
			w.spawnEntity(itemEntity);
		}
	}
}
