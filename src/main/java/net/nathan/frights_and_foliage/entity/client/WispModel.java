package net.nathan.frights_and_foliage.entity.client;


import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import net.nathan.frights_and_foliage.entity.client.animation.WispAnimations;
import net.nathan.frights_and_foliage.entity.custom.WispEntity;

public class WispModel<T extends WispEntity> extends SinglePartEntityModel<T> {
    private final ModelPart wisp;
    private final ModelPart head;


        public WispModel(ModelPart root) {
            this.wisp = root.getChild("wisp");
            this.head = wisp.getChild("body");
        }
        public static TexturedModelData getTexturedModelData() {
            ModelData modelData = new ModelData();
            ModelPartData modelPartData = modelData.getRoot();
            ModelPartData wisp = modelPartData.addChild("wisp", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 34.0F, 0.0F));

            ModelPartData body = wisp.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, new Dilation(0.0F))
                    .uv(0, 12).cuboid(-3.0F, -3.0F, -2.0F, 6.0F, 6.0F, 4.0F, new Dilation(-0.001F)), ModelTransform.pivot(0.0F, -13.0F, 0.0F));
            return TexturedModelData.of(modelData, 32, 32);
        }

    @Override
    public void setAngles(WispEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(entity, netHeadYaw, headPitch, ageInTicks);

        this.animateMovement(WispAnimations.WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, WispAnimations.IDLE, ageInTicks, 1f);
    }

    private void setHeadAngles(WispEntity entity, float headYaw, float headPitch, float animationProgress) {
        headYaw = MathHelper.clamp(headYaw, -10.0F, 30.0F);
        headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

        this.head.yaw = headYaw * 0.017453292F;
        this.head.pitch = headPitch * 0.017453292F;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        wisp.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart getPart() {
        return wisp;
    }
}