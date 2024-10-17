package net.nathan.frights_and_foliage.util;


import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.ComposterBlock;
import net.nathan.frights_and_foliage.blocks.ModBlocks;
import net.nathan.frights_and_foliage.entity.ModEntities;
import net.nathan.frights_and_foliage.entity.custom.FumkinEntity;
import net.nathan.frights_and_foliage.entity.custom.LephidEntity;
import net.nathan.frights_and_foliage.entity.custom.StalkEntity;
import net.nathan.frights_and_foliage.item.ModItems;

public class ModRegistries {
    public static void registerModStuffs() {
        registerFuels();
        registerModCompostables();
        registerStrippables();
        registerFlammables();
        registerAttributes();
    }

    private static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(ModEntities.STALK, StalkEntity.createStalkAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.LEPHID, LephidEntity.createLephidAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.FUMKIN, FumkinEntity.createFumkinAttributes());
    }

    private static void registerArthropods() {

    }

    private static void registerFuels() {
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(ModBlocks.ASERIA_PLANKS, 300);
        registry.add(ModBlocks.ASERIA_LOG, 300);
        registry.add(ModBlocks.STRIPPED_ASERIA_LOG, 300);
        registry.add(ModBlocks.ASERIA_WOOD, 300);
        registry.add(ModBlocks.STRIPPED_ASERIA_WOOD, 300);
        registry.add(ModBlocks.ASERIA_STAIRS, 300);
        registry.add(ModBlocks.ASERIA_SLAB, 300);
        registry.add(ModBlocks.ASERIA_BUTTON, 300);
        registry.add(ModBlocks.ASERIA_PRESSURE_PLATE, 300);
        registry.add(ModBlocks.ASERIA_FENCE, 300);
        registry.add(ModBlocks.ASERIA_FENCE_GATE, 300);
        registry.add(ModBlocks.ASERIA_DOOR, 300);
        registry.add(ModBlocks.ASERIA_TRAPDOOR, 300);
        registry.add(ModItems.ASERIA_BOAT, 300);
        registry.add(ModItems.ASERIA_CHEST_BOAT, 300);
        registry.add(ModItems.ASERIA_SIGN, 300);
        registry.add(ModItems.ASERIA_HANGING_SIGN, 300);
        registry.add(ModBlocks.RED_ASERIA_SAPLING, 300);
        registry.add(ModBlocks.ORANGE_ASERIA_SAPLING, 300);
        registry.add(ModBlocks.YELLOW_ASERIA_SAPLING, 300);
        registry.add(ModBlocks.RED_ASERIA_LEAVES, 300);
        registry.add(ModBlocks.ORANGE_ASERIA_LEAVES, 300);
        registry.add(ModBlocks.YELLOW_ASERIA_LEAVES, 300);
    }

    private static void registerModCompostables () {
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.RED_ASERIA_SAPLING, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.ORANGE_ASERIA_SAPLING, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.YELLOW_ASERIA_SAPLING, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.RED_ASERIA_LEAVES, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.ORANGE_ASERIA_LEAVES, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.YELLOW_ASERIA_LEAVES, 0.3f);

        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.CRIMSON_PUMPKIN_SEEDS, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.CRIMSON_PUMPKIN.asItem(), 0.65f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.CARVED_CRIMSON_PUMPKIN.asItem(), 0.65f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.CRIMSON_PUMPKIN_PIE, 1f);

        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.WARPED_PUMPKIN_SEEDS, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.WARPED_PUMPKIN.asItem(), 0.65f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.CARVED_WARPED_PUMPKIN.asItem(), 0.65f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.WARPED_PUMPKIN_PIE, 1f);
    }

    private static void registerFlammables() {
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ASERIA_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ASERIA_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_ASERIA_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_ASERIA_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ASERIA_PLANKS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ASERIA_SLAB, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ASERIA_STAIRS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ASERIA_PLANKS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.RED_ASERIA_LEAVES, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ORANGE_ASERIA_LEAVES, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.YELLOW_ASERIA_LEAVES, 30, 60);

        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MARNOR_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MARNOR_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_MARNOR_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_MARNOR_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MARNOR_PLANKS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MARNOR_SLAB, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MARNOR_STAIRS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MARNOR_PLANKS, 5, 20);
        //FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MARNOR_LEAVES, 30, 60);
    }

    private static void registerStrippables() {
        StrippableBlockRegistry.register(ModBlocks.ASERIA_LOG, ModBlocks.STRIPPED_ASERIA_LOG);
        StrippableBlockRegistry.register(ModBlocks.ASERIA_SYRUP_LOG, ModBlocks.STRIPPED_ASERIA_LOG);
        StrippableBlockRegistry.register(ModBlocks.ASERIA_WOOD, ModBlocks.STRIPPED_ASERIA_WOOD);

        StrippableBlockRegistry.register(ModBlocks.MARNOR_LOG, ModBlocks.STRIPPED_MARNOR_LOG);
        StrippableBlockRegistry.register(ModBlocks.MARNOR_WOOD, ModBlocks.STRIPPED_MARNOR_WOOD);
    }
}
