package net.nathan.frights_and_foliage.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent WARPED_PUMPKIN_PIE = new FoodComponent.Builder().hunger(8).saturationModifier(4.8f).build();
    public static final FoodComponent CRIMSON_PUMPKIN_PIE = new FoodComponent.Builder().hunger(8).saturationModifier(4.8f).build();

    public static final FoodComponent ASERIA_SYRUP_BOTTLE = new FoodComponent.Builder().hunger(1).saturationModifier(1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 100, 0), 1.0F).build();
    public static final FoodComponent APPLE_CIDER = new FoodComponent.Builder().hunger(1).saturationModifier(1f).build();

    public static final FoodComponent RAW_VENISON = new FoodComponent.Builder().hunger(1).saturationModifier(1f).build();
    public static final FoodComponent COOKED_VENISON = new FoodComponent.Builder().hunger(1).saturationModifier(1f).build();


    public static final FoodComponent SAFFROOT = new FoodComponent.Builder().hunger(1).saturationModifier(1f).build();
    public static final FoodComponent SAFFROOT_OMELETTE = new FoodComponent.Builder().hunger(1).saturationModifier(1f).build();
    public static final FoodComponent STARCH_SKEWER = new FoodComponent.Builder().hunger(1).saturationModifier(1f).build();
    public static final FoodComponent STUFFED_PUMPKIN = new FoodComponent.Builder().hunger(1).saturationModifier(1f).build();


    public static final FoodComponent GAIZE = new FoodComponent.Builder().hunger(1).saturationModifier(1f).build();

    public static final FoodComponent GAIZE_BREAD = new FoodComponent.Builder().hunger(1).saturationModifier(1f).build();
    public static final FoodComponent GAIZE_FRITTER = new FoodComponent.Builder().hunger(1).saturationModifier(1f).build();
    public static final FoodComponent PEEPCORN = new FoodComponent.Builder().snack().hunger(1).saturationModifier(1f).build();

    public static final FoodComponent ASERIA_CANDY = new FoodComponent.Builder().hunger(1).saturationModifier(1f).build();
    public static final FoodComponent ASERIA_WAFFLE = new FoodComponent.Builder().hunger(1).saturationModifier(1f).build();
    public static final FoodComponent ASERIA_SUGAR_COOKIE = new FoodComponent.Builder().hunger(1).saturationModifier(1f).build();

    public static final FoodComponent NOX_BERRIES = new FoodComponent.Builder().hunger(1).saturationModifier(1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 100, 0), 1.0F).build();
    public static final FoodComponent DRIED_NOX_BERRIES = new FoodComponent.Builder().hunger(1).saturationModifier(1f).build();
    public static final FoodComponent BERRY_BLEND = new FoodComponent.Builder().hunger(1).saturationModifier(1f).build();
    public static final FoodComponent NOX_BERRY_TRAIL_MIX = new FoodComponent.Builder().hunger(1).saturationModifier(1f).build();

    public static final FoodComponent STALK_EYE = new FoodComponent.Builder().hunger(0).saturationModifier(0f).alwaysEdible().snack()
            .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 12000, 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 12000, 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 12000, 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 12000, 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 12000, 1), 1.0F).build();


}
