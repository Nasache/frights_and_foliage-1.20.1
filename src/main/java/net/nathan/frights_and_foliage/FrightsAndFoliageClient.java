package net.nathan.frights_and_foliage;

import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.block.entity.HangingSignBlockEntityRenderer;
import net.minecraft.client.render.block.entity.SignBlockEntityRenderer;
import net.nathan.frights_and_foliage.blocks.ModBlocks;
import net.nathan.frights_and_foliage.blocks.entity.ModBlockEntities;
import net.nathan.frights_and_foliage.entity.ModBoats;
import net.nathan.frights_and_foliage.particle.ModParticles;
import net.nathan.frights_and_foliage.particle.OrangeAcerParticles;
import net.nathan.frights_and_foliage.particle.RedAcerParticles;
import net.nathan.frights_and_foliage.particle.YellowAcerParticles;
import net.nathan.frights_and_foliage.util.ModWoodTypes;

public class FrightsAndFoliageClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        //BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ACER_SAPLING, RenderLayer.getCutout());
        //BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_ACER_SAPLING, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ACER_LEAVES, RenderLayer.getCutout());


        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RED_ACER_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.YELLOW_ACER_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ORANGE_ACER_LEAVES, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ACER_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ACER_TRAPDOOR, RenderLayer.getCutout());

        BlockEntityRendererFactories.register(ModBlockEntities.MOD_SIGN_BLOCK_ENTITY, SignBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.MOD_HANGING_SIGN_BLOCK_ENTITY, HangingSignBlockEntityRenderer::new);

        TexturedRenderLayers.SIGN_TYPE_TEXTURES.put(ModWoodTypes.ACER, TexturedRenderLayers.getSignTextureId(ModWoodTypes.ACER));

        assert ModBoats.ACER_BOAT_ID != null;
        TerraformBoatClientHelper.registerModelLayers(ModBoats.ACER_BOAT_ID, false);

        ParticleFactoryRegistry.getInstance().register(ModParticles.RED_ACER_PARTICLE, RedAcerParticles.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.ORANGE_ACER_PARTICLE, OrangeAcerParticles.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.YELLOW_ACER_PARTICLE, YellowAcerParticles.Factory::new);


    }
}
