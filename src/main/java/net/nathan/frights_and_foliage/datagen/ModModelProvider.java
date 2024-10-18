package net.nathan.frights_and_foliage.datagen;


import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.util.Identifier;
import net.nathan.frights_and_foliage.blocks.ModBlocks;
import net.nathan.frights_and_foliage.item.ModItems;

import java.util.Optional;

import static net.minecraft.data.client.BlockStateModelGenerator.TintType.NOT_TINTED;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }
    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool aseriaPlanksTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ASERIA_PLANKS);
        aseriaPlanksTexturePool.stairs(ModBlocks.ASERIA_STAIRS);
        aseriaPlanksTexturePool.slab(ModBlocks.ASERIA_SLAB);
        aseriaPlanksTexturePool.button(ModBlocks.ASERIA_BUTTON);
        aseriaPlanksTexturePool.pressurePlate(ModBlocks.ASERIA_PRESSURE_PLATE);
        aseriaPlanksTexturePool.fence(ModBlocks.ASERIA_FENCE);
        aseriaPlanksTexturePool.fenceGate(ModBlocks.ASERIA_FENCE_GATE);
        blockStateModelGenerator.registerDoor(ModBlocks.ASERIA_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.ASERIA_TRAPDOOR);

        aseriaPlanksTexturePool.family(BlockFamilies.register(ModBlocks.ASERIA_PLANKS).sign(ModBlocks.ASERIA_SIGN, ModBlocks.ASERIA_WALL_SIGN).build());

        blockStateModelGenerator.registerHangingSign(ModBlocks.STRIPPED_ASERIA_LOG, ModBlocks.ASERIA_HANGING_SIGN, ModBlocks.ASERIA_WALL_HANGING_SIGN);

        blockStateModelGenerator.registerLog(ModBlocks.ASERIA_LOG).log(ModBlocks.ASERIA_LOG).wood(ModBlocks.ASERIA_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_ASERIA_LOG).log(ModBlocks.STRIPPED_ASERIA_LOG).wood(ModBlocks.STRIPPED_ASERIA_WOOD);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RED_ASERIA_LEAVES);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ORANGE_ASERIA_LEAVES);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.YELLOW_ASERIA_LEAVES);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.RED_ASERIA_SAPLING, ModBlocks.POTTED_RED_ASERIA_SAPLING, NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.ORANGE_ASERIA_SAPLING, ModBlocks.POTTED_ORANGE_ASERIA_SAPLING, NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.YELLOW_ASERIA_SAPLING, ModBlocks.POTTED_YELLOW_ASERIA_SAPLING, NOT_TINTED);

        BlockStateModelGenerator.BlockTexturePool marnorPlanksTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MARNOR_PLANKS);
        marnorPlanksTexturePool.stairs(ModBlocks.MARNOR_STAIRS);
        marnorPlanksTexturePool.slab(ModBlocks.MARNOR_SLAB);
        marnorPlanksTexturePool.button(ModBlocks.MARNOR_BUTTON);
        marnorPlanksTexturePool.pressurePlate(ModBlocks.MARNOR_PRESSURE_PLATE);
        marnorPlanksTexturePool.fence(ModBlocks.MARNOR_FENCE);
        marnorPlanksTexturePool.fenceGate(ModBlocks.MARNOR_FENCE_GATE);
        //blockStateModelGenerator.registerDoor(ModBlocks.ACER_DOOR);
        //blockStateModelGenerator.registerTrapdoor(ModBlocks.ACER_TRAPDOOR);

        marnorPlanksTexturePool.family(BlockFamilies.register(ModBlocks.MARNOR_PLANKS).sign(ModBlocks.MARNOR_SIGN, ModBlocks.MARNOR_WALL_SIGN).build());

        blockStateModelGenerator.registerHangingSign(ModBlocks.STRIPPED_MARNOR_LOG, ModBlocks.MARNOR_HANGING_SIGN, ModBlocks.MARNOR_WALL_HANGING_SIGN);

        blockStateModelGenerator.registerLog(ModBlocks.MARNOR_LOG).log(ModBlocks.MARNOR_LOG).wood(ModBlocks.MARNOR_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_MARNOR_LOG).log(ModBlocks.STRIPPED_MARNOR_LOG).wood(ModBlocks.STRIPPED_MARNOR_WOOD);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MARNOR_LEAVES);



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

        itemModelGenerator.register(ModItems.ASERIA_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.ASERIA_CHEST_BOAT, Models.GENERATED);

        itemModelGenerator.register(ModItems.MARNOR_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.MARNOR_CHEST_BOAT, Models.GENERATED);

        itemModelGenerator.register(ModItems.WARPED_PUMPKIN_PIE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CRIMSON_PUMPKIN_PIE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ASERIA_SYRUP_BOTTLE, Models.GENERATED);

        itemModelGenerator.register(ModItems.RAW_VENISON, Models.GENERATED);
        itemModelGenerator.register(ModItems.COOKED_VENISON, Models.GENERATED);
        itemModelGenerator.register(ModItems.FUMKIN_ANTLER, Models.GENERATED);

        itemModelGenerator.register(ModItems.STALK_SPAWN_EGG,
                new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));
        itemModelGenerator.register(ModItems.LEPHID_SPAWN_EGG,
                new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));
        itemModelGenerator.register(ModItems.FUMKIN_SPAWN_EGG,
                new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));
    }
}
