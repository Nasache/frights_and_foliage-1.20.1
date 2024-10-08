package net.nathan.frights_and_foliage.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;
import net.nathan.frights_and_foliage.blocks.ModBlocks;
import net.nathan.frights_and_foliage.item.ModItems;
import net.nathan.frights_and_foliage.util.ModTags;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerPlanksRecipe(exporter, ModBlocks.ACER_PLANKS, ModTags.Items.ACER_LOGS, 4);

        offerBarkBlockRecipe(exporter, ModBlocks.ACER_WOOD, ModBlocks.ACER_LOG);
        offerBarkBlockRecipe(exporter, ModBlocks.STRIPPED_ACER_WOOD, ModBlocks.STRIPPED_ACER_LOG);

        createStairsRecipe(ModBlocks.ACER_STAIRS, Ingredient.ofItems(ModBlocks.ACER_PLANKS))
                .criterion(hasItem(ModBlocks.ACER_PLANKS), conditionsFromItem(ModBlocks.ACER_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ACER_STAIRS)));
        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ACER_SLAB, Ingredient.ofItems(ModBlocks.ACER_PLANKS))
                .criterion(hasItem(ModBlocks.ACER_PLANKS), conditionsFromItem(ModBlocks.ACER_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ACER_SLAB)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.ACER_BUTTON)
                .input(ModBlocks.ACER_PLANKS)
                .criterion(hasItem(ModBlocks.ACER_PLANKS), conditionsFromItem(ModBlocks.ACER_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ACER_BUTTON)));

        createFenceRecipe(ModBlocks.ACER_FENCE, Ingredient.ofItems(ModBlocks.ACER_PLANKS))
                .criterion(hasItem(ModBlocks.ACER_PLANKS), conditionsFromItem(ModBlocks.ACER_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ACER_FENCE)));
        createFenceGateRecipe(ModBlocks.ACER_FENCE_GATE, Ingredient.ofItems(ModBlocks.ACER_PLANKS))
                .criterion(hasItem(ModBlocks.ACER_PLANKS), conditionsFromItem(ModBlocks.ACER_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ACER_FENCE_GATE)));

        createDoorRecipe(ModBlocks.ACER_DOOR, Ingredient.ofItems(ModBlocks.ACER_PLANKS))
                .criterion(hasItem(ModBlocks.ACER_PLANKS), conditionsFromItem(ModBlocks.ACER_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ACER_DOOR)));
        createTrapdoorRecipe(ModBlocks.ACER_TRAPDOOR, Ingredient.ofItems(ModBlocks.ACER_PLANKS))
                .criterion(hasItem(ModBlocks.ACER_PLANKS), conditionsFromItem(ModBlocks.ACER_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ACER_TRAPDOOR)));

        offerPressurePlateRecipe(exporter, ModBlocks.ACER_PRESSURE_PLATE, ModBlocks.ACER_PLANKS);

        offerHangingSignRecipe(exporter, ModItems.ACER_HANGING_SIGN, ModBlocks.STRIPPED_ACER_LOG);
        createSignRecipe(ModItems.ACER_SIGN, Ingredient.ofItems(ModBlocks.ACER_PLANKS))
                .criterion(hasItem(ModBlocks.ACER_PLANKS), conditionsFromItem(ModBlocks.ACER_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ACER_SIGN)));

        offerBoatRecipe(exporter, ModItems.ACER_BOAT, ModBlocks.ACER_PLANKS);
        offerChestBoatRecipe(exporter, ModItems.ACER_CHEST_BOAT, ModItems.ACER_BOAT);


        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.WARPED_PUMPKIN_SEEDS, 4)
                .group("pumpkin_seeds")
                .input(ModBlocks.WARPED_PUMPKIN)
                .criterion(hasItem(ModBlocks.WARPED_PUMPKIN), conditionsFromItem(ModBlocks.WARPED_PUMPKIN))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.WARPED_JACK_O_LANTERN)
                .group("jack_o_lanterns")
                .pattern("A")
                .pattern("B")
                .input('A', ModBlocks.CARVED_WARPED_PUMPKIN)
                .input('B', Blocks.SOUL_TORCH)
                .criterion(hasItem(ModBlocks.CARVED_WARPED_PUMPKIN), conditionsFromItem(ModBlocks.CARVED_WARPED_PUMPKIN))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.WARPED_PUMPKIN_PIE)
                .group("pumpkin_pies")
                .input(ModBlocks.WARPED_PUMPKIN)
                .input(Items.SUGAR)
                .input(Items.EGG)
                .criterion(hasItem(ModBlocks.WARPED_PUMPKIN), conditionsFromItem(ModBlocks.WARPED_PUMPKIN))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CRIMSON_PUMPKIN_SEEDS, 4)
                .group("pumpkin_seeds")
                .input(ModBlocks.CRIMSON_PUMPKIN)
                .criterion(hasItem(ModBlocks.CRIMSON_PUMPKIN), conditionsFromItem(ModBlocks.CRIMSON_PUMPKIN))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.CRIMSON_JACK_O_LANTERN)
                .group("jack_o_lanterns")
                .pattern("A")
                .pattern("B")
                .input('A', ModBlocks.CARVED_CRIMSON_PUMPKIN)
                .input('B', Blocks.SOUL_TORCH)
                .criterion(hasItem(ModBlocks.CARVED_CRIMSON_PUMPKIN), conditionsFromItem(ModBlocks.CARVED_CRIMSON_PUMPKIN))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CRIMSON_PUMPKIN_PIE)
                .group("pumpkin_pies")
                .input(ModBlocks.CRIMSON_PUMPKIN)
                .input(Items.SUGAR)
                .input(Items.EGG)
                .criterion(hasItem(ModBlocks.CRIMSON_PUMPKIN), conditionsFromItem(ModBlocks.CRIMSON_PUMPKIN))
                .offerTo(exporter);
    }
}
