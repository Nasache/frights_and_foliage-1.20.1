package net.nathan.frights_and_foliage.world.tree;

import net.minecraft.world.gen.foliage.FoliagePlacerType;
import net.nathan.frights_and_foliage.FrightsAndFoliage;
import net.nathan.frights_and_foliage.mixin.FoliagePlacerTypeInvoker;
import net.nathan.frights_and_foliage.world.tree.custom.AcerFoliagePlacer;

public class ModFoliagePlacerTypes {
    public static final FoliagePlacerType<?> ACER_FOLIAGE_PLACER = FoliagePlacerTypeInvoker.callRegister(
            "acer_foliage_placer", AcerFoliagePlacer.CODEC);

    public static void register() {
        FrightsAndFoliage.LOGGER.info("Registering the Foliage Placers for " + FrightsAndFoliage.MOD_ID);
    }
}