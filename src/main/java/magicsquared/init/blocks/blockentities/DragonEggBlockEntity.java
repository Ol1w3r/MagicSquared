package magicsquared.init.blocks.blockentities;

import java.util.UUID;

import magicsquared.interfaces.IGem;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.CompoundTag;

public class DragonEggBlockEntity extends BlockEntity implements IGem {

	private GemType type;
	
	private UUID placedByPlayer;
	
	public DragonEggBlockEntity(GemType type) {
		super(ModBlockEntities.blockEntityMap.get(type.getName() + "_egg"));
		this.type = type;
	}

	@Override
	public GemType getGemType() { return this.type; }
	
	public UUID getPlacer() { return this.placedByPlayer; }
	
	// Serialize the BlockEntity
  	public CompoundTag toTag(CompoundTag tag) {
  		super.toTag(tag);
 
	 	// Save the current value of the number to the tag
  		tag.putUuid("playeruuid", placedByPlayer);
 
  		return tag;
  	}
  	
  	// Deserialize the BlockEntity
  	public void fromTag(CompoundTag tag) {
  		super.fromTag(tag);
  		placedByPlayer = tag.getUuid("playeruuid");
  	}
  	
  	public void SetOwner(UUID uuid) {
  		placedByPlayer = uuid;
  		markDirty();
  	}
}
