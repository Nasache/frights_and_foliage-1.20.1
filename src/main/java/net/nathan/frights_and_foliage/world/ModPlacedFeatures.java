package net.nathan.frights_and_foliage.world;

import net.minecraft.block.Blocks;
import net.minecraft.predicate.BlockPredicate;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;
import net.nathan.frights_and_foliage.FrightsAndFoliage;
import net.nathan.frights_and_foliage.blocks.ModBlocks;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> RED_ACER_PLACED_KEY = registerKey("red_acer_placed");
    public static final RegistryKey<PlacedFeature> ORANGE_ACER_PLACED_KEY = registerKey("orange_acer_placed");
    public static final RegistryKey<PlacedFeature> YELLOW_ACER_PLACED_KEY = registerKey("yellow_acer_placed");
    public static final RegistryKey<PlacedFeature> FALLEN_LEAVES_PLACED_KEY = registerKey("fallen_leaves_placed");
    public static final RegistryKey<PlacedFeature> AUTUMN_ROCK_PLACED_KEY = registerKey("autumn_rock_placed");
    public static final RegistryKey<PlacedFeature> AUTUMN_PUMPKIN_PLACED_KEY = registerKey("autumn_pumpkin_placed");
    public static final RegistryKey<PlacedFeature> AUTUMN_FLOWER_PLACED_KEY = registerKey("autumn_flower_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, RED_ACER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.RED_ACER_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(2, 0.5f, 2), ModBlocks.RED_ACER_SAPLING));
        register(context, ORANGE_ACER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ORANGE_ACER_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(2, 0.5f, 2), ModBlocks.ORANGE_ACER_SAPLING));
        register(context, YELLOW_ACER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.YELLOW_ACER_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(2, 0.5f, 2), ModBlocks.YELLOW_ACER_SAPLING));

        PlacedFeatures.register(context, FALLEN_LEAVES_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.FALLEN_LEAVES_KEY),
                new PlacementModifier[]{NoiseThresholdCountPlacementModifier.of(-0.8, 5, 10),
                        SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()});

        PlacedFeatures.register(context, AUTUMN_ROCK_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.AUTUMN_ROCK_KEY),
                new PlacementModifier[]{RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(),
                        PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()});

        PlacedFeatures.register(context, AUTUMN_PUMPKIN_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.AUTUMN_PUMPKIN_KEY),
                new PlacementModifier[]{RarityFilterPlacementModifier.of(20), SquarePlacementModifier.of(),
                        PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()});

        PlacedFeatures.register(context, AUTUMN_FLOWER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.AUTUMN_FLOWER_KEY),
                new PlacementModifier[]{CountPlacementModifier.of(2), RarityFilterPlacementModifier.of(5),
                        SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of()});

    }


    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(FrightsAndFoliage.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}