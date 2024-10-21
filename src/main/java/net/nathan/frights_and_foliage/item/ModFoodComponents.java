package net.nathan.frights_and_foliage.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent WARPED_PUMPKIN_PIE = new FoodComponent.Builder().hunger(8).saturationModifier(4.8f).build();
    public static final FoodComponent CRIMSON_PUMPKIN_PIE = new FoodComponent.Builder().hunger(8).saturationModifier(4.8f).build();

    public static final FoodComponent ASERIA_SYRUP_BOTTLE = new FoodComponent.Builder().hunger(8).saturationModifier(4.8f).build();

    public static final FoodComponent RAW_VENISON = new FoodComponent.Builder().hunger(1).saturationModifier(1f).build();
    public static final FoodComponent COOKED_VENISON = new FoodComponent.Builder().hunger(1).saturationModifier(1f).build();

    public static final FoodComponent STUFFED_PUMPKIN = new FoodComponent.Builder().hunger(1).saturationModifier(1f).build();

    public static final FoodComponent SAFFROOT = new FoodComponent.Builder().hunger(1).saturationModifier(1f).build();
    public static final FoodComponent GAIZE = new FoodComponent.Builder().hunger(1).saturationModifier(1f).build();

    public static final FoodComponent NOX_BERRIES = new FoodComponent.Builder().hunger(1).saturationModifier(1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 100, 0), 1.0F).build();


}
