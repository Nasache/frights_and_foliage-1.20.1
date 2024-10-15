package net.nathan.frights_and_foliage.world.biome;

import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.nathan.frights_and_foliage.world.ModPlacedFeatures;

public class ModBiomeFeatures {

    public static void addAutumnalVegetation(GenerationSettings.LookupBackedBuilder builder) {
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.PATCH_GRASS_PLAIN);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.PATCH_TALL_GRASS);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.RED_ASERIA_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.ORANGE_ASERIA_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.YELLOW_ASERIA_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.FALLEN_LEAVES_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.AUTUMN_ROCK_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.AUTUMN_PUMPKIN_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.AUTUMN_FLOWER_PLACED_KEY);
    }
}
