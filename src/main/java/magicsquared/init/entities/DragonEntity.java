package magicsquared.init.entities;

import magicsquared.init.items.ModItems;
import magicsquared.interfaces.IGem;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.FleeEntityGoal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class DragonEntity extends AnimalEntity implements IGem {

	private GemType type;
    public float field_6741;
    public float field_6743;
    public float field_6738;
    public float field_6736;
    public float field_6737 = 1.0F;
    public int scaleDropTime;
	
    public DragonEntity(EntityType<AnimalEntity> entityType, World world, GemType type) {
		super(entityType, world);
		this.type = type;
	    this.scaleDropTime = this.random.nextInt(6000) + 6000;
	}
	
    public boolean handleFallDamage(float fallDistance, float damageMultiplier) {
    	return false;
    }
    
	@Override
	protected void initGoals() {
		
		this.goalSelector.add(0, new FleeEntityGoal<ChickenEntity>(this, ChickenEntity.class, 6.0F, 1.0D, 2.0D));
		this.goalSelector.add(1, new WanderAroundFarGoal(this, 1.0D));
		this.goalSelector.add(2, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
	    this.goalSelector.add(3, new LookAroundGoal(this));
	}
	

	@Override
	protected void initAttributes() {
		super.initAttributes();
	    this.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(16.0D);
	    this.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED).setBaseValue(0.15D);
	}
	
	public void tickMovement() {
	      super.tickMovement();
	      this.field_6736 = this.field_6741;
	      this.field_6738 = this.field_6743;
	      this.field_6743 = (float)((double)this.field_6743 + (double)(this.onGround ? -1 : 4) * 0.3D);
	      this.field_6743 = MathHelper.clamp(this.field_6743, 0.0F, 1.0F);
	      if (!this.onGround && this.field_6737 < 1.0F) {
	          this.field_6737 = 1.0F;
	      }

	      this.field_6737 = (float)((double)this.field_6737 * 0.9D);
	      Vec3d vec3d = this.getVelocity();
	      if (!this.onGround && vec3d.y < 0.0D) {
	          this.setVelocity(vec3d.multiply(1.0D, 0.6D, 1.0D));
	      }

	      this.field_6741 += this.field_6737 * 2.0F;
	      if (!this.world.isClient && this.isAlive() && !this.isBaby() && --this.scaleDropTime <= 0) {
	    	  this.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
	          this.dropItem(ModItems.gemItemMap.get(this.type.getName() + "_scale"));
	          this.scaleDropTime = this.random.nextInt(6000) + 6000;
	      }

	}

	public void readCustomDataFromTag(CompoundTag tag) {
		super.readCustomDataFromTag(tag);
		if (tag.contains("ScaleDropTime")) {
			this.scaleDropTime = tag.getInt("ScaleDropTime");
		}
    }

    public void writeCustomDataToTag(CompoundTag tag) {
	    super.writeCustomDataToTag(tag);
    	tag.putInt("ScaleDropTime", this.scaleDropTime);
    }
	
	@Override
	public PassiveEntity createChild(PassiveEntity mate) {
		return null;
	}

	@Override
	public GemType getGemType() {
		return type;
	}

}
