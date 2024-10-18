package net.nathan.frights_and_foliage.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import net.nathan.frights_and_foliage.blocks.ModBlocks;
import net.nathan.frights_and_foliage.item.ModItems;
import net.nathan.frights_and_foliage.util.ModTags;

import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerPlanksRecipe(exporter, ModBlocks.ASERIA_PLANKS, ModTags.Items.ASERIA_LOGS, 4);

        offerBarkBlockRecipe(exporter, ModBlocks.ASERIA_WOOD, ModBlocks.ASERIA_LOG);
        offerBarkBlockRecipe(exporter, ModBlocks.STRIPPED_ASERIA_WOOD, ModBlocks.STRIPPED_ASERIA_LOG);

        createStairsRecipe(ModBlocks.ASERIA_STAIRS, Ingredient.ofItems(ModBlocks.ASERIA_PLANKS))
                .criterion(hasItem(ModBlocks.ASERIA_PLANKS), conditionsFromItem(ModBlocks.ASERIA_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ASERIA_STAIRS)));
        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ASERIA_SLAB, Ingredient.ofItems(ModBlocks.ASERIA_PLANKS))
                .criterion(hasItem(ModBlocks.ASERIA_PLANKS), conditionsFromItem(ModBlocks.ASERIA_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ASERIA_SLAB)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.ASERIA_BUTTON)
                .input(ModBlocks.ASERIA_PLANKS)
                .criterion(hasItem(ModBlocks.ASERIA_PLANKS), conditionsFromItem(ModBlocks.ASERIA_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ASERIA_BUTTON)));

        createFenceRecipe(ModBlocks.ASERIA_FENCE, Ingredient.ofItems(ModBlocks.ASERIA_PLANKS))
                .criterion(hasItem(ModBlocks.ASERIA_PLANKS), conditionsFromItem(ModBlocks.ASERIA_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ASERIA_FENCE)));
        createFenceGateRecipe(ModBlocks.ASERIA_FENCE_GATE, Ingredient.ofItems(ModBlocks.ASERIA_PLANKS))
                .criterion(hasItem(ModBlocks.ASERIA_PLANKS), conditionsFromItem(ModBlocks.ASERIA_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ASERIA_FENCE_GATE)));

        createDoorRecipe(ModBlocks.ASERIA_DOOR, Ingredient.ofItems(ModBlocks.ASERIA_PLANKS))
                .criterion(hasItem(ModBlocks.ASERIA_PLANKS), conditionsFromItem(ModBlocks.ASERIA_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ASERIA_DOOR)));
        createTrapdoorRecipe(ModBlocks.ASERIA_TRAPDOOR, Ingredient.ofItems(ModBlocks.ASERIA_PLANKS))
                .criterion(hasItem(ModBlocks.ASERIA_PLANKS), conditionsFromItem(ModBlocks.ASERIA_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ASERIA_TRAPDOOR)));

        offerPressurePlateRecipe(exporter, ModBlocks.ASERIA_PRESSURE_PLATE, ModBlocks.ASERIA_PLANKS);

        offerHangingSignRecipe(exporter, ModItems.ASERIA_HANGING_SIGN, ModBlocks.STRIPPED_ASERIA_LOG);
        createSignRecipe(ModItems.ASERIA_SIGN, Ingredient.ofItems(ModBlocks.ASERIA_PLANKS))
                .criterion(hasItem(ModBlocks.ASERIA_PLANKS), conditionsFromItem(ModBlocks.ASERIA_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ASERIA_SIGN)));

        offerBoatRecipe(exporter, ModItems.ASERIA_BOAT, ModBlocks.ASERIA_PLANKS);
        offerChestBoatRecipe(exporter, ModItems.ASERIA_CHEST_BOAT, ModItems.ASERIA_BOAT);


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

        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(new ItemConvertible[]{ModItems.RAW_VENISON}), RecipeCategory.FOOD, ModItems.COOKED_VENISON, 0.35F, 200).criterion("has_raw_venison", conditionsFromItem(ModItems.RAW_VENISON)).offerTo(exporter);
        offerFoodCookingRecipe(exporter, "smoking", RecipeSerializer.SMOKING, 100, ModItems.RAW_VENISON, ModItems.COOKED_VENISON, 0.35f);
        offerFoodCookingRecipe(exporter, "campfire_cooking", RecipeSerializer.CAMPFIRE_COOKING, 600, ModItems.RAW_VENISON, ModItems.COOKED_VENISON, 0.35f);

    }
}
