package net.nathan.frights_and_foliage.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.nathan.frights_and_foliage.FrightsAndFoliage;
import net.nathan.frights_and_foliage.blocks.ModBlocks;
import net.nathan.frights_and_foliage.world.tree.custom.AcerFoliagePlacer;


public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> RED_ACER_KEY = registerKey("red_acer");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORANGE_ACER_KEY = registerKey("orange_acer");
    public static final RegistryKey<ConfiguredFeature<?, ?>> YELLOW_ACER_KEY = registerKey("yellow_acer");


    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {

        register(context, RED_ACER_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.ACER_LOG),
                new StraightTrunkPlacer(5, 2, 3),
                BlockStateProvider.of(ModBlocks.RED_ACER_LEAVES),
                new AcerFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1), 2),
                new TwoLayersFeatureSize(1, 0, 2)).build());
        register(context, ORANGE_ACER_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.ACER_LOG),
                new StraightTrunkPlacer(5, 2, 3),
                BlockStateProvider.of(ModBlocks.ORANGE_ACER_LEAVES),
                new AcerFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1), 2),
                new TwoLayersFeatureSize(1, 0, 2)).build());
        register(context, YELLOW_ACER_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.ACER_LOG),
                new StraightTrunkPlacer(5, 2, 3),
                BlockStateProvider.of(ModBlocks.YELLOW_ACER_LEAVES),
                new AcerFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1), 2),
                new TwoLayersFeatureSize(1, 0, 2)).build());
    }


    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(FrightsAndFoliage.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}