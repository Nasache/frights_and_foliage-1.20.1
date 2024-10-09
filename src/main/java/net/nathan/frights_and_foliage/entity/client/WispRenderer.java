package net.nathan.frights_and_foliage.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.passive.GlowSquidEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.nathan.frights_and_foliage.FrightsAndFoliage;
import net.nathan.frights_and_foliage.entity.custom.WispEntity;

public class WispRenderer extends MobEntityRenderer<WispEntity, WispModel<WispEntity>> {
    private static final Identifier TEXTURE = new Identifier(FrightsAndFoliage.MOD_ID, "textures/entity/wisps/wisp.png");

    public WispRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new WispModel(ctx.getPart(ModEntityModelLayers.WISP)), 0.6f);
    }

    @Override
    public Identifier getTexture(WispEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(WispEntity livingEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    protected int getBlockLight(WispEntity wispEntity, BlockPos blockPos) {
        return 15;
    }
}