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
import net.nathan.frights_and_foliage.item.custom.SyrupBottleItem;

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

    public static final Item ACER_SYRUP_BOTTLE = registerItem("acer_syrup_bottle",
            new SyrupBottleItem(new FabricItemSettings().food(ModFoodComponents.ACER_SYRUP_BOTTLE).maxCount(16)));

    public static final Item STALK_SPAWN_EGG = registerItem("stalk_spawn_egg",
            new SpawnEggItem(ModEntities.STALK, 0x745a36, 0xc29d62, new Item.Settings()));
    public static final Item LEAFBUG_SPAWN_EGG = registerItem("leafbug_spawn_egg",
            new SpawnEggItem(ModEntities.LEAFBUG, 0x745a36, 0xc29d62, new Item.Settings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(FrightsAndFoliage.MOD_ID, name), item);
    }

    public static void registerModItems() {
        FrightsAndFoliage.LOGGER.info("Registering Mod Items for " + FrightsAndFoliage.MOD_ID);

    }
}
