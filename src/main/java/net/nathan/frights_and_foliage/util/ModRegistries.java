package net.nathan.frights_and_foliage.util;


import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.ComposterBlock;
import net.nathan.frights_and_foliage.blocks.ModBlocks;
import net.nathan.frights_and_foliage.item.ModItems;

public class ModRegistries {
    public static void registerModStuffs() {
        registerFuels();
        registerModCompostables();
        registerStrippables();
        registerFlammables();
        //registerAttributes();
    }

    private static void registerAttributes() {
    }

    private static void registerFuels() {
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(ModBlocks.ACER_PLANKS, 300);
        registry.add(ModBlocks.ACER_STAIRS, 300);
        registry.add(ModBlocks.ACER_SLAB, 300);
        registry.add(ModBlocks.ACER_BUTTON, 300);
        registry.add(ModBlocks.ACER_PRESSURE_PLATE, 300);
        registry.add(ModBlocks.ACER_FENCE, 300);
        registry.add(ModBlocks.ACER_FENCE_GATE, 300);
        registry.add(ModBlocks.ACER_DOOR, 300);
        registry.add(ModBlocks.ACER_TRAPDOOR, 300);
        registry.add(ModItems.ACER_BOAT, 300);
        registry.add(ModItems.ACER_CHEST_BOAT, 300);
        registry.add(ModItems.ACER_SIGN, 300);
        registry.add(ModItems.ACER_HANGING_SIGN, 300);
        registry.add(ModBlocks.RED_ACER_SAPLING, 300);
        registry.add(ModBlocks.ORANGE_ACER_SAPLING, 300);
        registry.add(ModBlocks.YELLOW_ACER_SAPLING, 300);
        registry.add(ModBlocks.RED_ACER_LEAVES, 300);
        registry.add(ModBlocks.ORANGE_ACER_LEAVES, 300);
        registry.add(ModBlocks.YELLOW_ACER_LEAVES, 300);
    }

    private static void registerModCompostables () {
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.RED_ACER_SAPLING, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.ORANGE_ACER_SAPLING, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.YELLOW_ACER_SAPLING, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.RED_ACER_LEAVES, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.ORANGE_ACER_LEAVES, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModBlocks.YELLOW_ACER_LEAVES, 0.3f);

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
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ACER_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ACER_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_ACER_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_ACER_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ACER_PLANKS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ACER_SLAB, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ACER_STAIRS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ACER_PLANKS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.RED_ACER_LEAVES, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.ORANGE_ACER_LEAVES, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.YELLOW_ACER_LEAVES, 30, 60);
    }

    private static void registerStrippables() {
        StrippableBlockRegistry.register(ModBlocks.ACER_LOG, ModBlocks.STRIPPED_ACER_LOG);
        StrippableBlockRegistry.register(ModBlocks.ACER_WOOD, ModBlocks.STRIPPED_ACER_WOOD);
    }
}
