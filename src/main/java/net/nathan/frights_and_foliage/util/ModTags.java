package net.nathan.frights_and_foliage.util;


import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.nathan.frights_and_foliage.FrightsAndFoliage;

public class ModTags {
    public static class Blocks {

        public static final TagKey<Block> ACER_LOGS = TagKey.of(RegistryKeys.BLOCK, new Identifier("frights_and_foliage", "acer_logs"));

        private static TagKey<Block> createBlockTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(FrightsAndFoliage.MOD_ID, name));
        }

        private static TagKey<Block> createCommonBlockTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier("c", name));
        }
    }

    public static class Items {

        public static final TagKey<Item> ACER_LOGS = TagKey.of(RegistryKeys.ITEM, new Identifier("frights_and_foliage", "maple_logs"));

        private static TagKey<Item> createItemTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(FrightsAndFoliage.MOD_ID, name));
        }

        private static TagKey<Item> createCommonItemTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier("c", name));

        }
    }
}