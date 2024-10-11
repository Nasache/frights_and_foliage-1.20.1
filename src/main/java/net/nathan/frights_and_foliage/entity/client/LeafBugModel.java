package net.nathan.frights_and_foliage.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.nathan.frights_and_foliage.entity.client.animation.LeafBugAnimations;
import net.nathan.frights_and_foliage.entity.client.animation.StalkAnimations;
import net.nathan.frights_and_foliage.entity.custom.LeafBugEntity;

public class LeafBugModel<T extends LeafBugEntity> extends SinglePartEntityModel<T> {
    private final ModelPart leafbug;

    public LeafBugModel(ModelPart root) {
        this.leafbug = root.getChild("bug");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData bug = modelPartData.addChild("bug", ModelPartBuilder.create(), ModelTransform.pivot(-1.5F, 24.0F, 0.5F));

        ModelPartData body = bug.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData legs = body.addChild("legs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData rleg1 = legs.addChild("rleg1", ModelPartBuilder.create().uv(20, 17).cuboid(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.5F, -2.0F, -2.5F));

        ModelPartData rleg2 = legs.addChild("rleg2", ModelPartBuilder.create().uv(16, 20).cuboid(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.5F, -2.0F, -0.5F));

        ModelPartData rleg3 = legs.addChild("rleg3", ModelPartBuilder.create().uv(20, 14).cuboid(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.5F, -2.0F, 1.5F));

        ModelPartData lleg1 = legs.addChild("lleg1", ModelPartBuilder.create().uv(20, 0).cuboid(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(2.5F, -2.0F, -2.5F));

        ModelPartData lleg2 = legs.addChild("lleg2", ModelPartBuilder.create().uv(20, 3).cuboid(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(2.5F, -2.0F, -0.5F));

        ModelPartData lleg3 = legs.addChild("lleg3", ModelPartBuilder.create().uv(12, 20).cuboid(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(2.5F, -2.0F, 1.5F));

        ModelPartData leaf = body.addChild("leaf", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -3.0F, -3.5F, 5.0F, 1.0F, 5.0F, new Dilation(0.0F))
                .uv(20, 23).cuboid(1.0F, -2.0F, -6.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(4, 23).cuboid(3.0F, -3.0F, -4.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(8, 23).cuboid(-1.0F, -3.0F, -4.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(18, 12).cuboid(-2.0F, -4.0F, -4.5F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(6, 19).cuboid(3.0F, -4.0F, -4.5F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 6).cuboid(0.0F, -3.0F, 1.5F, 3.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(14, 14).cuboid(1.0F, -3.0F, 3.5F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(14, 14).cuboid(1.0F, -4.0F, 4.5F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(20, 20).cuboid(1.0F, -6.0F, 5.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(20, 20).cuboid(1.0F, -7.0F, 4.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(20, 20).cuboid(1.0F, -8.0F, 3.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 12).cuboid(1.0F, -8.0F, 0.5F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F))
                .uv(0, 9).cuboid(0.0F, -8.0F, 1.5F, 3.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(8, 14).cuboid(1.0F, -9.0F, 1.5F, 1.0F, 3.0F, 2.0F, new Dilation(0.0F))
                .uv(0, 16).cuboid(3.0F, -2.0F, 2.5F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(14, 17).cuboid(-1.0F, -2.0F, 2.5F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(10, 6).cuboid(4.0F, -3.0F, -2.5F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F))
                .uv(18, 6).cuboid(5.0F, -3.0F, -1.5F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(6, 21).cuboid(6.0F, -2.0F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(16, 23).cuboid(5.0F, -2.0F, 0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 19).cuboid(-3.0F, -3.0F, -1.5F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(10, 10).cuboid(-2.0F, -3.0F, -2.5F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F))
                .uv(0, 22).cuboid(-4.0F, -2.0F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(12, 23).cuboid(-3.0F, -2.0F, 0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(18, 9).cuboid(1.0F, -3.0F, -5.5F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 32, 32);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        leafbug.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart getPart() {
        return leafbug;
    }

    @Override
    public void setAngles(LeafBugEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);

        this.animateMovement(LeafBugAnimations.WALK, limbSwing, limbSwingAmount, 2f, 2.5f);

    }
}
