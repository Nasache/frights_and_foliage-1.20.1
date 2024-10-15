package net.nathan.frights_and_foliage.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.nathan.frights_and_foliage.blocks.ModBlocks;
import net.nathan.frights_and_foliage.item.ModItems;


public class ModBlockLootTableGenerator extends FabricBlockLootTableProvider {
    public ModBlockLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.ASERIA_PLANKS);
        addDrop(ModBlocks.ASERIA_LOG);
        addDrop(ModBlocks.ASERIA_WOOD);
        addDrop(ModBlocks.STRIPPED_ASERIA_LOG);
        addDrop(ModBlocks.STRIPPED_ASERIA_WOOD);
        addDrop(ModBlocks.RED_ASERIA_LEAVES, leavesDrops(ModBlocks.RED_ASERIA_LEAVES, ModBlocks.RED_ASERIA_SAPLING, .05f));
        addDrop(ModBlocks.ORANGE_ASERIA_LEAVES, leavesDrops(ModBlocks.ORANGE_ASERIA_LEAVES, ModBlocks.ORANGE_ASERIA_SAPLING, .05f));
        addDrop(ModBlocks.YELLOW_ASERIA_LEAVES, leavesDrops(ModBlocks.YELLOW_ASERIA_LEAVES, ModBlocks.YELLOW_ASERIA_SAPLING, .05f));
        addDrop(ModBlocks.ASERIA_STAIRS);
        addDrop(ModBlocks.ASERIA_SLAB, slabDrops(ModBlocks.ASERIA_SLAB));
        addDrop(ModBlocks.ASERIA_BUTTON);
        addDrop(ModBlocks.ASERIA_PRESSURE_PLATE);
        addDrop(ModBlocks.ASERIA_FENCE);
        addDrop(ModBlocks.ASERIA_FENCE_GATE);
        addDrop(ModBlocks.ASERIA_DOOR, doorDrops(ModBlocks.ASERIA_DOOR));
        addDrop(ModBlocks.ASERIA_TRAPDOOR);
        addDrop(ModBlocks.ASERIA_SIGN);
        addDrop(ModBlocks.ASERIA_WALL_SIGN);
        addDrop(ModBlocks.ASERIA_HANGING_SIGN);
        addDrop(ModBlocks.ASERIA_WALL_HANGING_SIGN);
        addDrop(ModBlocks.RED_ASERIA_SAPLING);
        addDrop(ModBlocks.POTTED_RED_ASERIA_SAPLING, pottedPlantDrops(ModBlocks.RED_ASERIA_SAPLING));
        addDrop(ModBlocks.ORANGE_ASERIA_SAPLING);
        addDrop(ModBlocks.POTTED_ORANGE_ASERIA_SAPLING, pottedPlantDrops(ModBlocks.ORANGE_ASERIA_SAPLING));
        addDrop(ModBlocks.YELLOW_ASERIA_SAPLING);
        addDrop(ModBlocks.POTTED_YELLOW_ASERIA_SAPLING, pottedPlantDrops(ModBlocks.YELLOW_ASERIA_SAPLING));

        addDrop(ModBlocks.FALLEN_LEAVES, flowerbedDrops(ModBlocks.FALLEN_LEAVES));

        addDrop(ModBlocks.ASERIA_SYRUP_LOG, drops(ModBlocks.ASERIA_SYRUP_LOG, ModBlocks.ASERIA_LOG));

        addDrop(ModBlocks.MARNOR_PLANKS);
        addDrop(ModBlocks.MARNOR_LOG);
        addDrop(ModBlocks.MARNOR_WOOD);
        addDrop(ModBlocks.STRIPPED_MARNOR_LOG);
        addDrop(ModBlocks.STRIPPED_MARNOR_WOOD);
        //addDrop(ModBlocks.MARNOR_LEAVES, leavesDrops(ModBlocks.MARNOR_LEAVES, ModBlocks.MARNOR_SAPLING, .05f));
        addDrop(ModBlocks.MARNOR_STAIRS);
        addDrop(ModBlocks.MARNOR_SLAB, slabDrops(ModBlocks.MARNOR_SLAB));
        addDrop(ModBlocks.MARNOR_BUTTON);
        addDrop(ModBlocks.MARNOR_PRESSURE_PLATE);
        addDrop(ModBlocks.MARNOR_FENCE);
        addDrop(ModBlocks.MARNOR_FENCE_GATE);
        //addDrop(ModBlocks.MARNOR_DOOR, doorDrops(ModBlocks.MARNOR_DOOR));
        //addDrop(ModBlocks.MARNOR_TRAPDOOR);
        addDrop(ModBlocks.MARNOR_SIGN);
        addDrop(ModBlocks.MARNOR_WALL_SIGN);
        addDrop(ModBlocks.MARNOR_HANGING_SIGN);
        addDrop(ModBlocks.MARNOR_WALL_HANGING_SIGN);
        //addDrop(ModBlocks.MARNOR_SAPLING);
        //addDrop(ModBlocks.POTTED_MARNOR_SAPLING, pottedPlantDrops(ModBlocks.MARNOR_SAPLING));

        addDrop(ModBlocks.WARPED_PUMPKIN_STEM, attachedCropStemDrops(ModBlocks.WARPED_PUMPKIN_STEM,
                ModItems.WARPED_PUMPKIN_SEEDS));
        addDrop(ModBlocks.ATTACHED_WARPED_PUMPKIN_STEM, attachedCropStemDrops(ModBlocks.ATTACHED_WARPED_PUMPKIN_STEM,
                ModItems.WARPED_PUMPKIN_SEEDS));
        addDrop(ModBlocks.CRIMSON_PUMPKIN_STEM, attachedCropStemDrops(ModBlocks.CRIMSON_PUMPKIN_STEM,
                ModItems.CRIMSON_PUMPKIN_SEEDS));
        addDrop(ModBlocks.ATTACHED_CRIMSON_PUMPKIN_STEM, attachedCropStemDrops(ModBlocks.ATTACHED_CRIMSON_PUMPKIN_STEM,
                ModItems.CRIMSON_PUMPKIN_SEEDS));
        addDrop(ModBlocks.WARPED_PUMPKIN);
        addDrop(ModBlocks.CARVED_WARPED_PUMPKIN);
        addDrop(ModBlocks.WARPED_JACK_O_LANTERN);
        addDrop(ModBlocks.CRIMSON_PUMPKIN);
        addDrop(ModBlocks.CARVED_CRIMSON_PUMPKIN);
        addDrop(ModBlocks.CRIMSON_JACK_O_LANTERN);

    }
}
