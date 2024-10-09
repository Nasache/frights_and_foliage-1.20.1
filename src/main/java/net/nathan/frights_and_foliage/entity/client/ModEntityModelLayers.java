package net.nathan.frights_and_foliage.entity.client;

import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.nathan.frights_and_foliage.FrightsAndFoliage;

public class ModEntityModelLayers {
    public static final EntityModelLayer WISP =
            new EntityModelLayer(Identifier.of(FrightsAndFoliage.MOD_ID, "wisp"), "main");
}
