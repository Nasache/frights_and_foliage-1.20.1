package net.nathan.frights_and_foliage.entity.client;


import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.nathan.frights_and_foliage.entity.client.animation.StalkAnimations;
import net.nathan.frights_and_foliage.entity.custom.StalkEntity;

public class StalkModel<T extends StalkEntity> extends SinglePartEntityModel<T> {
    private final ModelPart stalk;
    private final ModelPart head;

    public StalkModel(ModelPart root) {
        this.stalk = root.getChild("stalk");
        this.head = stalk.getChild("body").getChild("head");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData stalk = modelPartData.addChild("stalk", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData body = stalk.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(0, 20).cuboid(-4.0F, -12.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-5.0F, -13.0F, -5.0F, 10.0F, 10.0F, 10.0F, new Dilation(0.0F))
                .uv(24, 36).cuboid(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -48.0F, 0.0F));

        ModelPartData torso = body.addChild("torso", ModelPartBuilder.create().uv(40, 0).cuboid(-4.0F, -14.5F, -1.0F, 8.0F, 15.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -33.5F, 0.0F));

        ModelPartData larm = body.addChild("larm", ModelPartBuilder.create().uv(0, 36).cuboid(-1.0F, -17.0F, -1.0F, 2.0F, 34.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(5.0F, -30.0F, 0.0F));

        ModelPartData rarm = body.addChild("rarm", ModelPartBuilder.create().uv(32, 20).cuboid(-1.0F, -17.0F, -1.0F, 2.0F, 34.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-5.0F, -30.0F, 0.0F));

        ModelPartData lleg = body.addChild("lleg", ModelPartBuilder.create().uv(16, 36).cuboid(1.0F, -33.0F, -1.0F, 2.0F, 33.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData rleg = body.addChild("rleg", ModelPartBuilder.create().uv(8, 36).cuboid(-3.0F, -33.0F, -1.0F, 2.0F, 33.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 128, 128);
    }
    @Override
    public void setAngles(StalkEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(entity, netHeadYaw, headPitch, ageInTicks);

        this.animateMovement(StalkAnimations.WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, StalkAnimations.IDLE, ageInTicks, 1f);
    }

    private void setHeadAngles(StalkEntity entity, float headYaw, float headPitch, float animationProgress) {
        headYaw = MathHelper.clamp(headYaw, -10.0F, 30.0F);
        headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

        this.head.yaw = headYaw * 0.017453292F;
        this.head.pitch = headPitch * 0.017453292F;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        stalk.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart getPart() {
        return stalk;
    }
}