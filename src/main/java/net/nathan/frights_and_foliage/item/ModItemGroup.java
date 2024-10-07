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
                    .icon(() -> new ItemStack(ModItems.ACER_BOAT)).entries((displayContext, entries) -> {

                        entries.add(ModBlocks.ACER_LOG);
                        entries.add(ModBlocks.ACER_WOOD);
                        entries.add(ModBlocks.STRIPPED_ACER_LOG);
                        entries.add(ModBlocks.STRIPPED_ACER_WOOD);
                        entries.add(ModBlocks.ACER_PLANKS);
                        entries.add(ModBlocks.ACER_STAIRS);
                        entries.add(ModBlocks.ACER_SLAB);
                        entries.add(ModBlocks.ACER_PRESSURE_PLATE);
                        entries.add(ModBlocks.ACER_BUTTON);
                        entries.add(ModBlocks.ACER_FENCE);
                        entries.add(ModBlocks.ACER_FENCE_GATE);
                        entries.add(ModBlocks.ACER_DOOR);
                        entries.add(ModBlocks.ACER_TRAPDOOR);
                        entries.add(ModItems.ACER_SIGN);
                        entries.add(ModItems.ACER_HANGING_SIGN);
                        entries.add(ModBlocks.RED_ACER_SAPLING);
                        entries.add(ModBlocks.ORANGE_ACER_SAPLING);
                        entries.add(ModBlocks.YELLOW_ACER_SAPLING);
                        entries.add(ModBlocks.RED_ACER_LEAVES);
                        entries.add(ModBlocks.ORANGE_ACER_LEAVES);
                        entries.add(ModBlocks.YELLOW_ACER_LEAVES);
                        entries.add(ModBlocks.ACER_LEAVES);

                        entries.add(ModItems.ACER_BOAT);
                        entries.add(ModItems.ACER_CHEST_BOAT);
                    }).build());

    public static void registerItemGroups() {
    }
}
