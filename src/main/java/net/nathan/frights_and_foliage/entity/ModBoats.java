package net.nathan.frights_and_foliage.entity;

import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.nathan.frights_and_foliage.FrightsAndFoliage;
import net.nathan.frights_and_foliage.blocks.ModBlocks;
import net.nathan.frights_and_foliage.item.ModItems;

public class ModBoats {
    public static final Identifier ACER_BOAT_ID = Identifier.of(FrightsAndFoliage.MOD_ID, "acer_boat");
    public static final Identifier ACER_CHEST_BOAT_ID = Identifier.of(FrightsAndFoliage.MOD_ID, "acer_chest_boat");

    public static final RegistryKey<TerraformBoatType> ACER_BOAT_KEY = TerraformBoatTypeRegistry.createKey(ACER_BOAT_ID);

    public static void registerBoats() {
        TerraformBoatType gildedOakBoat = new TerraformBoatType.Builder()
                .item(ModItems.ACER_BOAT)
                .chestItem(ModItems.ACER_CHEST_BOAT)
                .planks(ModBlocks.ACER_PLANKS.asItem())
                .build();

        Registry.register(TerraformBoatTypeRegistry.INSTANCE, ACER_BOAT_KEY, gildedOakBoat);
    }
}