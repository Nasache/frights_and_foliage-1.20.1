package net.nathan.frights_and_foliage.item;

import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.nathan.frights_and_foliage.FrightsAndFoliage;
import net.nathan.frights_and_foliage.blocks.ModBlocks;
import net.nathan.frights_and_foliage.entity.ModBoats;
import net.nathan.frights_and_foliage.entity.ModEntities;

public class ModItems {
    public static final Item ACER_SIGN = registerItem("acer_sign",
            new SignItem(new Item.Settings().maxCount(16), ModBlocks.ACER_SIGN, ModBlocks.ACER_WALL_SIGN));
    public static final Item ACER_HANGING_SIGN = registerItem("acer_hanging_sign",
            new HangingSignItem(ModBlocks.ACER_HANGING_SIGN, ModBlocks.ACER_WALL_HANGING_SIGN, new Item.Settings().maxCount(16)));

    public static final Item ACER_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.ACER_BOAT_ID, ModBoats.ACER_BOAT_KEY, false);
    public static final Item ACER_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.ACER_CHEST_BOAT_ID, ModBoats.ACER_BOAT_KEY, true);


    public static final Item WARPED_PUMPKIN_SEEDS = registerItem("warped_pumpkin_seeds",
            new AliasedBlockItem(ModBlocks.WARPED_PUMPKIN_STEM, new FabricItemSettings()));
    public static final Item CRIMSON_PUMPKIN_SEEDS = registerItem("crimson_pumpkin_seeds",
            new AliasedBlockItem(ModBlocks.CRIMSON_PUMPKIN_STEM, new FabricItemSettings()));

    public static final Item WARPED_PUMPKIN_PIE = registerItem("warped_pumpkin_pie",
            new Item(new FabricItemSettings().food(ModFoodComponents.WARPED_PUMPKIN_PIE)));
    public static final Item CRIMSON_PUMPKIN_PIE = registerItem("crimson_pumpkin_pie",
            new Item(new FabricItemSettings().food(ModFoodComponents.CRIMSON_PUMPKIN_PIE)));

    public static final Item BOTTLE_O_WISP = registerItem("bottle_o_wisp",
            new EntityBucketItem(ModEntities.WISP, Fluids.EMPTY, SoundEvents.ITEM_BOTTLE_EMPTY, (new Item.Settings()).maxCount(1)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(FrightsAndFoliage.MOD_ID, name), item);
    }

    public static void registerModItems() {
        FrightsAndFoliage.LOGGER.info("Registering Mod Items for " + FrightsAndFoliage.MOD_ID);

    }
}
