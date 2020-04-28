package magicsquared.init.client.rendering.entity.model;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.AnimalModel;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class DragonEntityModel<T extends Entity> extends AnimalModel<T> {
	
	   private final ModelPart head;
	   
	   private final ModelPart rEar;
	   private final ModelPart lEar;

	   private final ModelPart snute;

	   private final ModelPart body;
	   
	   private final ModelPart frFoot;
	   private final ModelPart frClaw;
	   
	   private final ModelPart flFoot;
	   private final ModelPart flClaw;
	   
	   private final ModelPart brFoot;
	   
	   private final ModelPart blFoot;

	   private final ModelPart rWing1;
	   private final ModelPart rWing2;
	   private final ModelPart rWing3;
	   
	   private final ModelPart lWing1;
	   private final ModelPart lWing2;
	   private final ModelPart lWing3;

	   private final ModelPart tail1;
	   private final ModelPart tail2;

	   public DragonEntityModel() {
		   

	      this.head = new ModelPart(this, 0, 0);
	      this.head.addCuboid(-2.0F, 18.0F, -5.0F, 4.0F, 3.0F, 3.0F);
		      
	   
	      this.rEar = new ModelPart(this, 0, 0);
	      this.rEar.addCuboid(-2.0F, 17.0F, -3.0F, 1.0F, 2.0F, 2.0F);
	      
	      this.lEar = new ModelPart(this, 0, 0);
	      this.lEar.addCuboid(1.0F, 17.0F, -3.0F, 1.0F, 2.0F, 2.0F);
	      
	      this.snute = new ModelPart(this, 0, 0);
	      this.snute.addCuboid(-1.0F, 20.0F, -6.0F, 2.0F, 1.0F, 1.0F);
	      
	      
	      this.body = new ModelPart(this, 0, 0);
	      this.body.addCuboid(-2.0F, 20.0F, -3.0F, 4.0F, 3.0F, 7.0F);
	      

	      this.frFoot = new ModelPart(this, 0, 0);
	      this.frFoot.addCuboid(-3.0F, 22.0F, -4.0F, 2.0F, 2.0F, 2.0F);
	      
	      this.frClaw = new ModelPart(this, 0, 0);
	      this.frClaw.addCuboid(-3.0F, 23.0F, -5.0F, 2.0F, 1.0F, 1.0F);
	      

	      this.flFoot = new ModelPart(this, 0, 0);
	      this.flFoot.addCuboid(1.0F, 22.0F, -4.0F, 2.0F, 2.0F, 2.0F);

	      this.flClaw = new ModelPart(this, 0, 0);
	      this.flClaw.addCuboid(1.0F, 23.0F, -5.0F, 2.0F, 1.0F, 1.0F);
	      
	      
	      this.brFoot = new ModelPart(this, 0, 0);
	      this.brFoot.addCuboid(-3.0F, 22.0F, 2.0F, 2.0F, 2.0F, 2.0F);
	      
	      this.blFoot = new ModelPart(this, 0, 0);
	      this.blFoot.addCuboid(1.0F, 22.0F, 2.0F, 2.0F, 2.0F, 2.0F);
	      
	      
	      this.rWing1 = new ModelPart(this, 0, 0);
	      this.rWing1.addCuboid(-3.0F, 19.0F, -1.0F, 1.0F, 3.0F, 2.0F);
	      this.rWing1.setPivot(0.0F, 0.0F, -1.0F);
	      
	      this.rWing2 = new ModelPart(this, 0, 0);
	      this.rWing2.addCuboid(-2.0F, 19.0F, -1.0F, 1.0F, 1.0F, 2.0F);
	      this.rWing2.setPivot(0.0F, 0.0F, -1.0F);
	      
	      this.rWing3 = new ModelPart(this, 0, 0);
	      this.rWing3.addCuboid(-3.0F, 19.0F, 1.0F, 1.0F, 2.0F, 1.0F);
	      this.rWing3.setPivot(0.0F, 0.0F, -1.0F);
	      
	      
	      this.lWing1 = new ModelPart(this, 0, 0);
	      this.lWing1.addCuboid(2.0F, 19.0F, -1.0F, 1.0F, 3.0F, 2.0F);
	      this.lWing1.setPivot(0.0F, 0.0F, -1.0F);

	      this.lWing2 = new ModelPart(this, 0, 0);
	      this.lWing2.addCuboid(1.0F, 19.0F, -1.0F, 1.0F, 1.0F, 2.0F);
	      this.lWing2.setPivot(0.0F, 0.0F, -1.0F);
	      
	      this.lWing3 = new ModelPart(this, 0, 0);
	      this.lWing3.addCuboid(2.0F, 19.0F, 1.0F, 1.0F, 2.0F, 1.0F);
	      this.lWing3.setPivot(0.0F, 0.0F, -1.0F);

	      
	      this.tail1 = new ModelPart(this, 0, 0);
	      this.tail1.addCuboid(0.0F, 20.0F, 4.0F, 0.0F, 1.0F, 3.0F);
	      
	      this.tail2 = new ModelPart(this, 0, 0);
	      this.tail2.addCuboid(0.0F, 18.0F, 7.0F, 0.0F, 2.0F, 1.0F);
	   }

	   protected Iterable<ModelPart> getHeadParts() {
	      return ImmutableList.of(this.head, this.snute, this.rEar, this.lEar);
	   }
	   
	   protected Iterable<ModelPart> getBodyParts() {
	      return ImmutableList.of(this.body, 
	    		  this.frFoot, this.frClaw, 
	    		  this.flFoot, this.flClaw,
	    		  this.blFoot, this.brFoot,
	    		  this.rWing1, this.rWing2, this.rWing3,
	    		  this.lWing1, this.lWing2, this.lWing3,
	    		  this.tail1, this.tail2);
	   }

	   public void setAngles(T entity, float limbAngle, float limbDistance, float customAngle, float headYaw, float headPitch) {
	      this.head.pitch = headPitch * 0.002F;
	      this.head.yaw = headYaw * 0.005F;
	      this.snute.pitch = this.head.pitch;
	      this.rEar.pitch = this.head.pitch;
	      this.lEar.pitch = this.head.pitch;
	      this.snute.yaw = this.head.yaw;
	      this.rEar.yaw = this.head.yaw;
	      this.lEar.yaw = this.head.yaw;

	      this.brFoot.pitch = MathHelper.cos(limbAngle * 0.6662F + 3.1415927F) * 0.2F * limbDistance;
	      this.frFoot.pitch = MathHelper.cos(limbAngle * 0.6662F) * 0.2F * limbDistance;
	      this.frClaw.pitch = MathHelper.cos(limbAngle * 0.6662F) * 0.2F * limbDistance;
	      this.blFoot.pitch = MathHelper.cos(limbAngle * 0.6662F) * 0.2F * limbDistance;
	      this.flFoot.pitch = MathHelper.cos(limbAngle * 0.6662F + 3.1415927F) * 0.2F * limbDistance;
	      this.flClaw.pitch = MathHelper.cos(limbAngle * 0.6662F + 3.1415927F) * 0.2F * limbDistance;
	      
	      this.rWing1.roll = customAngle * 0.1F;
	      this.rWing2.roll = customAngle * 0.1F;
	      this.rWing3.roll = customAngle * 0.1F;
	      
	      this.lWing1.roll = -customAngle * 0.1F;
	      this.lWing2.roll = -customAngle * 0.1F;
	      this.lWing3.roll = -customAngle * 0.1F;
	   }
}
