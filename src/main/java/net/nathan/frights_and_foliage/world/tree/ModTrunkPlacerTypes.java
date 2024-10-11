package net.nathan.frights_and_foliage.world.tree;

import net.minecraft.world.gen.trunk.TrunkPlacerType;
import net.nathan.frights_and_foliage.FrightsAndFoliage;
import net.nathan.frights_and_foliage.mixin.TrunkPlacerTypeInvoker;
import net.nathan.frights_and_foliage.world.tree.custom.AcerTrunkPlacer;

public class ModTrunkPlacerTypes {
    public static final TrunkPlacerType<?> ACER_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("acer_trunk_placer",
            AcerTrunkPlacer.CODEC);

    public static void register() {
        FrightsAndFoliage.LOGGER.info("Registering Trunk Placer for " + FrightsAndFoliage.MOD_ID);
    }
}
