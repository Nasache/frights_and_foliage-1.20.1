package net.nathan.frights_and_foliage.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.nathan.frights_and_foliage.FrightsAndFoliage;
import net.nathan.frights_and_foliage.entity.custom.FumkinEntity;
import net.nathan.frights_and_foliage.entity.custom.LephidEntity;
import net.nathan.frights_and_foliage.entity.custom.StalkEntity;

public class ModEntities {

    public static final EntityType<StalkEntity> STALK = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(FrightsAndFoliage.MOD_ID, "stalk"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, StalkEntity::new)
                    .dimensions(EntityDimensions.fixed(0.8f, 2.0f)).build());

    public static final EntityType<LephidEntity> LEPHID = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(FrightsAndFoliage.MOD_ID, "lephid"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, LephidEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.4f)).build());

    public static final EntityType<FumkinEntity> FUMKIN = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(FrightsAndFoliage.MOD_ID, "fumkin"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, FumkinEntity::new)
                    .dimensions(EntityDimensions.fixed(0.9f, 1.5f)).build());


    public static void registerModEntities() {
        FrightsAndFoliage.LOGGER.info("Registering Mod Entities for " + FrightsAndFoliage.MOD_ID);
    }
}
