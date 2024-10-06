package net.nathan.frights_and_foliage.util;

import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeRegistry;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.WoodType;
import net.minecraft.util.Identifier;
import net.nathan.frights_and_foliage.FrightsAndFoliage;

public class ModWoodTypes {
    public static final WoodType ACER = WoodTypeRegistry.register(new Identifier(FrightsAndFoliage.MOD_ID, "acer"), BlockSetType.OAK);
}