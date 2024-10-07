package net.nathan.frights_and_foliage.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.nathan.frights_and_foliage.blocks.ModBlocks;


public class ModBlockLootTableGenerator extends FabricBlockLootTableProvider {
    public ModBlockLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.ACER_PLANKS);
        addDrop(ModBlocks.ACER_LOG);
        addDrop(ModBlocks.ACER_WOOD);
        addDrop(ModBlocks.STRIPPED_ACER_LOG);
        addDrop(ModBlocks.STRIPPED_ACER_WOOD);
        addDrop(ModBlocks.RED_ACER_LEAVES, leavesDrops(ModBlocks.RED_ACER_LEAVES, ModBlocks.RED_ACER_SAPLING, .05f));
        addDrop(ModBlocks.ORANGE_ACER_LEAVES, leavesDrops(ModBlocks.ORANGE_ACER_LEAVES, ModBlocks.ORANGE_ACER_SAPLING, .05f));
        addDrop(ModBlocks.YELLOW_ACER_LEAVES, leavesDrops(ModBlocks.YELLOW_ACER_LEAVES, ModBlocks.YELLOW_ACER_SAPLING, .05f));
        addDrop(ModBlocks.ACER_STAIRS);
        addDrop(ModBlocks.ACER_SLAB, slabDrops(ModBlocks.ACER_SLAB));
        addDrop(ModBlocks.ACER_BUTTON);
        addDrop(ModBlocks.ACER_PRESSURE_PLATE);
        addDrop(ModBlocks.ACER_FENCE);
        addDrop(ModBlocks.ACER_FENCE_GATE);
        addDrop(ModBlocks.ACER_DOOR, doorDrops(ModBlocks.ACER_DOOR));
        addDrop(ModBlocks.ACER_TRAPDOOR);
        addDrop(ModBlocks.ACER_SIGN);
        addDrop(ModBlocks.ACER_WALL_SIGN);
        addDrop(ModBlocks.ACER_HANGING_SIGN);
        addDrop(ModBlocks.ACER_WALL_HANGING_SIGN);
        addDrop(ModBlocks.RED_ACER_SAPLING);
        addDrop(ModBlocks.POTTED_RED_ACER_SAPLING, pottedPlantDrops(ModBlocks.RED_ACER_SAPLING));
        addDrop(ModBlocks.ORANGE_ACER_SAPLING);
        addDrop(ModBlocks.POTTED_ORANGE_ACER_SAPLING, pottedPlantDrops(ModBlocks.ORANGE_ACER_SAPLING));
        addDrop(ModBlocks.YELLOW_ACER_SAPLING);
        addDrop(ModBlocks.POTTED_YELLOW_ACER_SAPLING, pottedPlantDrops(ModBlocks.YELLOW_ACER_SAPLING));

        addDrop(ModBlocks.ACER_LEAVES, flowerbedDrops(ModBlocks.ACER_LEAVES));

    }
}
