package net.nathan.frights_and_foliage.entity.client;

import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.nathan.frights_and_foliage.FrightsAndFoliage;

public class ModEntityModelLayers {
    public static final EntityModelLayer STALK =
            new EntityModelLayer(Identifier.of(FrightsAndFoliage.MOD_ID, "stalk"), "main");

    public static final EntityModelLayer LEAFBUG =
            new EntityModelLayer(Identifier.of(FrightsAndFoliage.MOD_ID, "leaf_bug"), "main");

    public static final EntityModelLayer FUMKIN =
            new EntityModelLayer(Identifier.of(FrightsAndFoliage.MOD_ID, "fumkin"), "main");
}
