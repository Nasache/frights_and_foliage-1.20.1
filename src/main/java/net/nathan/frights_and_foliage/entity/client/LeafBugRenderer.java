package net.nathan.frights_and_foliage.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.nathan.frights_and_foliage.FrightsAndFoliage;
import net.nathan.frights_and_foliage.entity.custom.LeafBugEntity;
import net.nathan.frights_and_foliage.entity.custom.StalkEntity;

public class LeafBugRenderer extends MobEntityRenderer<LeafBugEntity, LeafBugModel<LeafBugEntity>> {
    private static final Identifier TEXTURE = new Identifier(FrightsAndFoliage.MOD_ID, "textures/entity/leaf_bug/leaf_bug.png");

    public LeafBugRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new LeafBugModel<>(ctx.getPart(ModEntityModelLayers.LEAFBUG)), 0.3f);
    }

    @Override
    public Identifier getTexture(LeafBugEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(LeafBugEntity livingEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
