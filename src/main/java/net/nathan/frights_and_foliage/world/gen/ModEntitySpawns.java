package net.nathan.frights_and_foliage.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;
import net.nathan.frights_and_foliage.entity.ModEntities;

public class ModEntitySpawns {
    public static void addSpawns() {
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST, BiomeKeys.DARK_FOREST),
                SpawnGroup.CREATURE, ModEntities.VIRE, 10, 2, 4);

        SpawnRestriction.register(ModEntities.VIRE, SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING, AnimalEntity::isValidNaturalSpawn);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST,
                        BiomeKeys.BIRCH_FOREST, BiomeKeys.OLD_GROWTH_BIRCH_FOREST, BiomeKeys.DARK_FOREST,
                        BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA, BiomeKeys.OLD_GROWTH_PINE_TAIGA, BiomeKeys.TAIGA),
                SpawnGroup.CREATURE, ModEntities.FUMKIN, 12, 2, 5);

        SpawnRestriction.register(ModEntities.FUMKIN, SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);
    }
}
