package net.nathan.frights_and_foliage.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.nathan.frights_and_foliage.blocks.ModBlocks;
import net.nathan.frights_and_foliage.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        
        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.ACER_LOG.asItem(), ModBlocks.ACER_WOOD.asItem(),
                        ModBlocks.STRIPPED_ACER_LOG.asItem(), ModBlocks.STRIPPED_ACER_WOOD.asItem());

        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.ACER_PLANKS.asItem());

        getOrCreateTagBuilder(ModTags.Items.ACER_LOGS)
                .add(ModBlocks.ACER_LOG.asItem(), ModBlocks.ACER_WOOD.asItem(),
                        ModBlocks.STRIPPED_ACER_LOG.asItem(), ModBlocks.STRIPPED_ACER_WOOD.asItem());
    }
}
