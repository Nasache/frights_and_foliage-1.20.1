package net.nathan.frights_and_foliage.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.nathan.frights_and_foliage.blocks.ModBlocks;
import net.nathan.frights_and_foliage.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
   public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
       super(output, registriesFuture);
   }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.ACER_PLANKS,
                        ModBlocks.ACER_STAIRS,
                        ModBlocks.ACER_SLAB,
                        ModBlocks.ACER_BUTTON,
                        ModBlocks.ACER_PRESSURE_PLATE,
                        ModBlocks.ACER_FENCE,
                        ModBlocks.ACER_FENCE_GATE,
                        ModBlocks.ACER_DOOR,
                        ModBlocks.ACER_TRAPDOOR,
                        ModBlocks.ACER_LOG,
                        ModBlocks.ACER_WOOD,
                        ModBlocks.STRIPPED_ACER_LOG,
                        ModBlocks.STRIPPED_ACER_WOOD,
                        ModBlocks.ACER_HANGING_SIGN,
                        ModBlocks.ACER_SIGN,
                        ModBlocks.ACER_WALL_SIGN,
                        ModBlocks.ACER_WALL_HANGING_SIGN);


        getOrCreateTagBuilder(BlockTags.PLANKS)
                .add(ModBlocks.ACER_PLANKS);

        getOrCreateTagBuilder(BlockTags.LEAVES)
                .add(ModBlocks.RED_ACER_LEAVES,
                        ModBlocks.YELLOW_ACER_LEAVES);

        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.ACER_FENCE);

        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.ACER_FENCE_GATE);

        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.ACER_LOG,
                        ModBlocks.ACER_WOOD,
                        ModBlocks.STRIPPED_ACER_LOG,
                        ModBlocks.STRIPPED_ACER_WOOD);

        getOrCreateTagBuilder(ModTags.Blocks.ACER_LOGS)
                .add(ModBlocks.ACER_LOG, ModBlocks.ACER_WOOD, ModBlocks.STRIPPED_ACER_LOG, ModBlocks.STRIPPED_ACER_WOOD);

        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric","needs_tool_level_4")));
    }
}
