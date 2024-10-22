package net.nathan.frights_and_foliage.item;

import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.nathan.frights_and_foliage.FrightsAndFoliage;
import net.nathan.frights_and_foliage.blocks.ModBlocks;
import net.nathan.frights_and_foliage.entity.ModBoats;
import net.nathan.frights_and_foliage.entity.ModEntities;
import net.nathan.frights_and_foliage.item.custom.AntlerMealItem;
import net.nathan.frights_and_foliage.item.custom.SyrupBottleItem;
import net.nathan.frights_and_foliage.item.custom.VireArrowItem;

public class ModItems {
    public static final Item ASERIA_SIGN = registerItem("aseria_sign",
            new SignItem(new Item.Settings().maxCount(16), ModBlocks.ASERIA_SIGN, ModBlocks.ASERIA_WALL_SIGN));
    public static final Item ASERIA_HANGING_SIGN = registerItem("aseria_hanging_sign",
            new HangingSignItem(ModBlocks.ASERIA_HANGING_SIGN, ModBlocks.ASERIA_WALL_HANGING_SIGN, new Item.Settings().maxCount(16)));

    public static final Item ASERIA_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.ASERIA_BOAT_ID, ModBoats.ASERIA_BOAT_KEY, false);
    public static final Item ASERIA_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.ASERIA_CHEST_BOAT_ID, ModBoats.ASERIA_BOAT_KEY, true);

    public static final Item MARNOR_SIGN = registerItem("marnor_sign",
            new SignItem(new Item.Settings().maxCount(16), ModBlocks.MARNOR_SIGN, ModBlocks.MARNOR_WALL_SIGN));
    public static final Item MARNOR_HANGING_SIGN = registerItem("marnor_hanging_sign",
            new HangingSignItem(ModBlocks.MARNOR_HANGING_SIGN, ModBlocks.MARNOR_WALL_HANGING_SIGN, new Item.Settings().maxCount(16)));

    public static final Item MARNOR_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.MARNOR_BOAT_ID, ModBoats.MARNOR_BOAT_KEY, false);
    public static final Item MARNOR_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.MARNOR_CHEST_BOAT_ID, ModBoats.MARNOR_BOAT_KEY, true);


    public static final Item WARPED_PUMPKIN_SEEDS = registerItem("warped_pumpkin_seeds",
            new AliasedBlockItem(ModBlocks.WARPED_PUMPKIN_STEM, new FabricItemSettings()));
    public static final Item CRIMSON_PUMPKIN_SEEDS = registerItem("crimson_pumpkin_seeds",
            new AliasedBlockItem(ModBlocks.CRIMSON_PUMPKIN_STEM, new FabricItemSettings()));

    public static final Item WARPED_PUMPKIN_PIE = registerItem("warped_pumpkin_pie",
            new Item(new FabricItemSettings().food(ModFoodComponents.WARPED_PUMPKIN_PIE)));
    public static final Item CRIMSON_PUMPKIN_PIE = registerItem("crimson_pumpkin_pie",
            new Item(new FabricItemSettings().food(ModFoodComponents.CRIMSON_PUMPKIN_PIE)));

    public static final Item ASERIA_SYRUP_BOTTLE = registerItem("aseria_syrup_bottle",
            new SyrupBottleItem(new FabricItemSettings().food(ModFoodComponents.ASERIA_SYRUP_BOTTLE)
                    .recipeRemainder(Items.GLASS_BOTTLE).maxCount(16)));

    public static final Item RAW_VENISON = registerItem("raw_venison",
            new Item(new FabricItemSettings().food(ModFoodComponents.RAW_VENISON)));
    public static final Item COOKED_VENISON = registerItem("cooked_venison",
            new Item(new FabricItemSettings().food(ModFoodComponents.COOKED_VENISON)));
    public static final Item FUMKIN_ANTLER = registerItem("fumkin_antler",
            new Item(new FabricItemSettings()));
    public static final Item ANTLERMEAL = registerItem("antlermeal",
            new AntlerMealItem(new FabricItemSettings()));

    public static final Item VIRE_FEATHER = registerItem("vire_feather",
            new Item(new FabricItemSettings()));
    public static final Item VIRE_FEATHER_ARROW = registerItem("vire_feather_arrow",
            new VireArrowItem(new FabricItemSettings()));

    public static final Item STUFFED_PUMPKIN = registerItem("stuffed_pumpkin",
            new Item(new FabricItemSettings().food(ModFoodComponents.STUFFED_PUMPKIN).maxCount(1)));

    public static final Item SAFFROOT = registerItem("saffroot",
            new AliasedBlockItem(ModBlocks.SAFFROOT_CROP, new FabricItemSettings().food(ModFoodComponents.SAFFROOT)));
    public static final Item GAIZE = registerItem("gaize",
            new Item(new FabricItemSettings().food(ModFoodComponents.GAIZE)));
    public static final Item GAIZE_BREAD = registerItem("gaize_bread",
            new Item(new FabricItemSettings().food(ModFoodComponents.GAIZE_BREAD)));
    public static final Item GAIZE_FRITTER = registerItem("gaize_fritter",
            new Item(new FabricItemSettings().food(ModFoodComponents.GAIZE_FRITTER)));
    public static final Item PEEPCORN = registerItem("peepcorn",
            new Item(new FabricItemSettings().food(ModFoodComponents.PEEPCORN)));

    public static final Item NOX_BERRIES = registerItem("nox_berries",
            new AliasedBlockItem(ModBlocks.NOX_BERRY_BUSH, new Item.Settings().food(ModFoodComponents.NOX_BERRIES)));

    public static final Item ASERIA_CANDY = registerItem("aseria_candy",
            new Item(new FabricItemSettings().food(ModFoodComponents.ASERIA_CANDY)));
    public static final Item ASERIA_WAFFLE = registerItem("aseria_waffle",
            new Item(new FabricItemSettings().food(ModFoodComponents.ASERIA_WAFFLE)));
    public static final Item ASERIA_SUGAR_COOKIE = registerItem("aseria_sugar_cookie",
            new Item(new FabricItemSettings().food(ModFoodComponents.ASERIA_SUGAR_COOKIE)));


    public static final Item STALK_EYE = registerItem("stalk_eye",
            new Item(new FabricItemSettings()));


    public static final Item STALK_SPAWN_EGG = registerItem("stalk_spawn_egg",
            new SpawnEggItem(ModEntities.STALK, 0x362141, 0x100d12, new Item.Settings()));
    public static final Item LEPHID_SPAWN_EGG = registerItem("lephid_spawn_egg",
            new SpawnEggItem(ModEntities.LEPHID, 0x382b3e, 0x694679, new Item.Settings()));
    public static final Item FUMKIN_SPAWN_EGG = registerItem("fumkin_spawn_egg",
            new SpawnEggItem(ModEntities.FUMKIN, 0xff6b2d, 0xfff8e1, new Item.Settings()));
    public static final Item VIRE_SPAWN_EGG = registerItem("vire_spawn_egg",
            new SpawnEggItem(ModEntities.VIRE, 0x1b1b1f, 0x1b1b1f, new Item.Settings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(FrightsAndFoliage.MOD_ID, name), item);
    }

    public static void registerModItems() {
        FrightsAndFoliage.LOGGER.info("Registering Mod Items for " + FrightsAndFoliage.MOD_ID);

    }
}
