package net.nathan.frights_and_foliage.datagen;


import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.data.family.BlockFamilies;
import net.nathan.frights_and_foliage.blocks.ModBlocks;
import net.nathan.frights_and_foliage.item.ModItems;

import static net.minecraft.data.client.BlockStateModelGenerator.TintType.NOT_TINTED;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }
    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool acerPlanksTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ACER_PLANKS);
        acerPlanksTexturePool.stairs(ModBlocks.ACER_STAIRS);
        acerPlanksTexturePool.slab(ModBlocks.ACER_SLAB);
        acerPlanksTexturePool.button(ModBlocks.ACER_BUTTON);
        acerPlanksTexturePool.pressurePlate(ModBlocks.ACER_PRESSURE_PLATE);
        acerPlanksTexturePool.fence(ModBlocks.ACER_FENCE);
        acerPlanksTexturePool.fenceGate(ModBlocks.ACER_FENCE_GATE);
        blockStateModelGenerator.registerDoor(ModBlocks.ACER_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.ACER_TRAPDOOR);

        acerPlanksTexturePool.family(BlockFamilies.register(ModBlocks.ACER_PLANKS).sign(ModBlocks.ACER_SIGN, ModBlocks.ACER_WALL_SIGN).build());

        blockStateModelGenerator.registerHangingSign(ModBlocks.STRIPPED_ACER_LOG, ModBlocks.ACER_HANGING_SIGN, ModBlocks.ACER_WALL_HANGING_SIGN);

        blockStateModelGenerator.registerLog(ModBlocks.ACER_LOG).log(ModBlocks.ACER_LOG).wood(ModBlocks.ACER_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_ACER_LOG).log(ModBlocks.STRIPPED_ACER_LOG).wood(ModBlocks.STRIPPED_ACER_WOOD);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RED_ACER_LEAVES);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ORANGE_ACER_LEAVES);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.YELLOW_ACER_LEAVES);



        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.RED_ACER_SAPLING, ModBlocks.POTTED_RED_ACER_SAPLING, NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.ORANGE_ACER_SAPLING, ModBlocks.POTTED_ORANGE_ACER_SAPLING, NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.YELLOW_ACER_SAPLING, ModBlocks.POTTED_YELLOW_ACER_SAPLING, NOT_TINTED);


        blockStateModelGenerator.registerSingleton(ModBlocks.WARPED_PUMPKIN, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerGourd(ModBlocks.WARPED_PUMPKIN_STEM, ModBlocks.ATTACHED_WARPED_PUMPKIN_STEM);

        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.CARVED_WARPED_PUMPKIN);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WARPED_JACK_O_LANTERN);

        blockStateModelGenerator.registerSingleton(ModBlocks.CRIMSON_PUMPKIN, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerGourd(ModBlocks.CRIMSON_PUMPKIN_STEM, ModBlocks.ATTACHED_CRIMSON_PUMPKIN_STEM);

        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.CARVED_CRIMSON_PUMPKIN);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.CRIMSON_JACK_O_LANTERN);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        itemModelGenerator.register(ModItems.ACER_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.ACER_CHEST_BOAT, Models.GENERATED);

        itemModelGenerator.register(ModItems.WARPED_PUMPKIN_PIE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CRIMSON_PUMPKIN_PIE, Models.GENERATED);
    }
}
