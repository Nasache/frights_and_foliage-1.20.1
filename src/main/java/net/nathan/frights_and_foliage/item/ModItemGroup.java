package net.nathan.frights_and_foliage.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.nathan.frights_and_foliage.FrightsAndFoliage;
import net.nathan.frights_and_foliage.blocks.ModBlocks;

public class ModItemGroup {

    public static final ItemGroup FRIGHTSANDFOLIAGE = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(FrightsAndFoliage.MOD_ID, "frights_and_foliage"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.frights_and_foliage"))
                    .icon(() -> new ItemStack(ModItems.ASERIA_BOAT)).entries((displayContext, entries) -> {

                        entries.add(ModBlocks.ASERIA_LOG);
                        entries.add(ModBlocks.ASERIA_WOOD);
                        entries.add(ModBlocks.STRIPPED_ASERIA_LOG);
                        entries.add(ModBlocks.STRIPPED_ASERIA_WOOD);
                        entries.add(ModBlocks.ASERIA_PLANKS);
                        entries.add(ModBlocks.ASERIA_STAIRS);
                        entries.add(ModBlocks.ASERIA_SLAB);
                        entries.add(ModBlocks.ASERIA_PRESSURE_PLATE);
                        entries.add(ModBlocks.ASERIA_BUTTON);
                        entries.add(ModBlocks.ASERIA_FENCE);
                        entries.add(ModBlocks.ASERIA_FENCE_GATE);
                        entries.add(ModBlocks.ASERIA_DOOR);
                        entries.add(ModBlocks.ASERIA_TRAPDOOR);
                        entries.add(ModItems.ASERIA_SIGN);
                        entries.add(ModItems.ASERIA_HANGING_SIGN);
                        entries.add(ModBlocks.RED_ASERIA_SAPLING);
                        entries.add(ModBlocks.ORANGE_ASERIA_SAPLING);
                        entries.add(ModBlocks.YELLOW_ASERIA_SAPLING);
                        entries.add(ModBlocks.RED_ASERIA_LEAVES);
                        entries.add(ModBlocks.ORANGE_ASERIA_LEAVES);
                        entries.add(ModBlocks.YELLOW_ASERIA_LEAVES);
                        entries.add(ModBlocks.FALLEN_LEAVES);

                        entries.add(ModItems.ASERIA_BOAT);
                        entries.add(ModItems.ASERIA_CHEST_BOAT);

                        entries.add(ModBlocks.ASERIA_SYRUP_LOG);

                        entries.add(ModBlocks.MARNOR_LOG);
                        entries.add(ModBlocks.MARNOR_WOOD);
                        entries.add(ModBlocks.STRIPPED_MARNOR_LOG);
                        entries.add(ModBlocks.STRIPPED_MARNOR_WOOD);
                        entries.add(ModBlocks.MARNOR_PLANKS);
                        entries.add(ModBlocks.MARNOR_STAIRS);
                        entries.add(ModBlocks.MARNOR_SLAB);
                        entries.add(ModBlocks.MARNOR_PRESSURE_PLATE);
                        entries.add(ModBlocks.MARNOR_BUTTON);
                        entries.add(ModBlocks.MARNOR_FENCE);
                        entries.add(ModBlocks.MARNOR_FENCE_GATE);
                        //entries.add(ModBlocks.MARNOR_DOOR);
                        //entries.add(ModBlocks.MARNOR_TRAPDOOR);
                        entries.add(ModItems.MARNOR_SIGN);
                        entries.add(ModItems.MARNOR_HANGING_SIGN);
                        //entries.add(ModBlocks.MARNOR_SAPLING);
                        //entries.add(ModBlocks.MARNOR_LEAVES);

                        entries.add(ModItems.MARNOR_BOAT);
                        entries.add(ModItems.MARNOR_CHEST_BOAT);

                        entries.add(ModBlocks.LEAFBUG_BLOCK);


                        entries.add(ModItems.WARPED_PUMPKIN_SEEDS);
                        entries.add(ModBlocks.WARPED_PUMPKIN);
                        entries.add(ModBlocks.CARVED_WARPED_PUMPKIN);
                        entries.add(ModBlocks.WARPED_JACK_O_LANTERN);
                        entries.add(ModItems.WARPED_PUMPKIN_PIE);

                        entries.add(ModItems.CRIMSON_PUMPKIN_SEEDS);
                        entries.add(ModBlocks.CRIMSON_PUMPKIN);
                        entries.add(ModBlocks.CARVED_CRIMSON_PUMPKIN);
                        entries.add(ModBlocks.CRIMSON_JACK_O_LANTERN);
                        entries.add(ModItems.CRIMSON_PUMPKIN_PIE);

                        entries.add(ModItems.STALK_SPAWN_EGG);
                        entries.add(ModItems.LEAFBUG_SPAWN_EGG);
                    }).build());

    public static void registerItemGroups() {
    }
}
