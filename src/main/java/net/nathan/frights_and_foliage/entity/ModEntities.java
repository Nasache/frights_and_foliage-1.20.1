package net.nathan.frights_and_foliage.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.nathan.frights_and_foliage.FrightsAndFoliage;
import net.nathan.frights_and_foliage.entity.custom.WispEntity;

public class ModEntities {

    public static final EntityType<WispEntity> WISP = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(FrightsAndFoliage.MOD_ID, "wisp"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, WispEntity::new).dimensions(EntityDimensions.fixed(0.6f, 0.6f)).build());


    public static void registerModEntities() {
        FrightsAndFoliage.LOGGER.info("Registering Mod Entities for " + FrightsAndFoliage.MOD_ID);
    }
}
