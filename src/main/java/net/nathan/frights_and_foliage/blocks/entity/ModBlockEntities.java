package net.nathan.frights_and_foliage.blocks.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.CampfireBlockEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.nathan.frights_and_foliage.FrightsAndFoliage;
import net.nathan.frights_and_foliage.blocks.ModBlocks;

public class ModBlockEntities {
    public static final BlockEntityType<ModSignBlockEntity> MOD_SIGN_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE,
            new Identifier(FrightsAndFoliage.MOD_ID, "mod_sign_entity"),
            FabricBlockEntityTypeBuilder.create(ModSignBlockEntity::new,
                    ModBlocks.ASERIA_SIGN, ModBlocks.ASERIA_WALL_SIGN,
                    ModBlocks.MARNOR_SIGN, ModBlocks.MARNOR_WALL_SIGN).build());

    public static final BlockEntityType<ModHangingSignBlockEntity> MOD_HANGING_SIGN_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE,
            new Identifier(FrightsAndFoliage.MOD_ID, "mod_hanging_sign_entity"),
            FabricBlockEntityTypeBuilder.create(ModHangingSignBlockEntity::new,
                    ModBlocks.ASERIA_HANGING_SIGN, ModBlocks.ASERIA_WALL_HANGING_SIGN,
                    ModBlocks.MARNOR_HANGING_SIGN, ModBlocks.MARNOR_WALL_HANGING_SIGN).build());

    public static final BlockEntityType<ModCampfireBlockEntity> MOD_CAMPFIRE_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE,
            new Identifier(FrightsAndFoliage.MOD_ID, "mod_campfire_block_entity"),
            FabricBlockEntityTypeBuilder.create(ModCampfireBlockEntity::new,
                    ModBlocks.SPOOKY_CAMPFIRE).build());

    public static void registerBlockEntities() {
        FrightsAndFoliage.LOGGER.info("Registering Block Entities for " + FrightsAndFoliage.MOD_ID);
    }
}
