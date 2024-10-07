package net.nathan.frights_and_foliage.world.gen;


import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.nathan.frights_and_foliage.world.ModPlacedFeatures;

public class ModFlowerGeneration {
    public static void generateFlowers() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.CRIMSON_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.PATCH_CRIMSON_PUMPKIN_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.WARPED_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.PATCH_WARPED_PUMPKIN_PLACED_KEY);
    }
}