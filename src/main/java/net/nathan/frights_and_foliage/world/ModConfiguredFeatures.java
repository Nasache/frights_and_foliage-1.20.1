package net.nathan.frights_and_foliage.world;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerbedBlock;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.noise.DoublePerlinNoiseSampler;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.NoiseBlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.nathan.frights_and_foliage.FrightsAndFoliage;
import net.nathan.frights_and_foliage.blocks.ModBlocks;
import net.nathan.frights_and_foliage.world.tree.custom.AcerFoliagePlacer;

import java.util.Iterator;
import java.util.List;

import static net.minecraft.world.gen.feature.ConfiguredFeatures.createRandomPatchFeatureConfig;


public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> RED_ACER_KEY = registerKey("red_acer");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORANGE_ACER_KEY = registerKey("orange_acer");
    public static final RegistryKey<ConfiguredFeature<?, ?>> YELLOW_ACER_KEY = registerKey("yellow_acer");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FALLEN_LEAVES_KEY = registerKey("fallen_leaves");
    public static final RegistryKey<ConfiguredFeature<?, ?>> AUTUMN_ROCK_KEY = registerKey("autumn_rock");
    public static final RegistryKey<ConfiguredFeature<?, ?>> AUTUMN_PUMPKIN_KEY = registerKey("autumn_pumpkin");
    public static final RegistryKey<ConfiguredFeature<?, ?>> AUTUMN_FLOWER_KEY = registerKey("autumn_flower");


    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {

        register(context, RED_ACER_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.ACER_LOG),
                new StraightTrunkPlacer(8, 2, 3),
                BlockStateProvider.of(ModBlocks.RED_ACER_LEAVES),
                new AcerFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1), 2),
                new TwoLayersFeatureSize(1, 0, 2)).build());
        register(context, ORANGE_ACER_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.ACER_LOG),
                new StraightTrunkPlacer(8, 2, 3),
                BlockStateProvider.of(ModBlocks.ORANGE_ACER_LEAVES),
                new AcerFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1), 2),
                new TwoLayersFeatureSize(1, 0, 2)).build());
        register(context, YELLOW_ACER_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.ACER_LOG),
                new StraightTrunkPlacer(8, 2, 3),
                BlockStateProvider.of(ModBlocks.YELLOW_ACER_LEAVES),
                new AcerFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1), 2),
                new TwoLayersFeatureSize(1, 0, 2)).build());


        DataPool.Builder<BlockState> builder = DataPool.builder();
        for(int i = 1; i <= 4; ++i) {
            Iterator var35 = Direction.Type.HORIZONTAL.iterator();

            while(var35.hasNext()) {
                Direction direction = (Direction)var35.next();
                builder.add((BlockState)((BlockState) ModBlocks.ACER_LEAVES.getDefaultState().with(FlowerbedBlock.FLOWER_AMOUNT, i))
                        .with(FlowerbedBlock.FACING, direction), 1);
            }
        }
        ConfiguredFeatures.register(context, FALLEN_LEAVES_KEY, Feature.FLOWER,
                new RandomPatchFeatureConfig(96, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(new WeightedBlockStateProvider(builder)))));

        ConfiguredFeatures.register(context, AUTUMN_ROCK_KEY, Feature.FOREST_ROCK, new SingleStateFeatureConfig(Blocks.MOSSY_COBBLESTONE.getDefaultState()));

        ConfiguredFeatures.register(context, AUTUMN_PUMPKIN_KEY, Feature.RANDOM_PATCH,
                createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(Blocks.PUMPKIN)), List.of(Blocks.GRASS_BLOCK)));

        ConfiguredFeatures.register(context, AUTUMN_FLOWER_KEY, Feature.FLOWER,
                new RandomPatchFeatureConfig(96, 3, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(new NoiseBlockStateProvider(2345L,
                                new DoublePerlinNoiseSampler.NoiseParameters(0, 1.0, new double[0]), 0.020833334F,
                                List.of(Blocks.DANDELION.getDefaultState(),
                                        Blocks.POPPY.getDefaultState(),
                                        Blocks.RED_TULIP.getDefaultState(),
                                        Blocks.ORANGE_TULIP.getDefaultState(),
                                        Blocks.LILY_OF_THE_VALLEY.getDefaultState()))))));


    }


    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(FrightsAndFoliage.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}