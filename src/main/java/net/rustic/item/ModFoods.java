package net.rustic.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.rustic.effect.ModEffects;

import static net.rustic.Config.TICKS_IN_MINUTE;

public class ModFoods {

    public static final FoodProperties OLIVES = new FoodProperties.Builder()
            .fast()
            .nutrition(1)
            .saturationMod(0.4f)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 200), 1).build();

    public static final FoodProperties IRONBERRIES = new FoodProperties.Builder()
            .fast()
            .alwaysEat()
            .nutrition(2)
            .saturationMod(0.4f)
            .effect(() -> new MobEffectInstance(ModEffects.FULLMETAL_EFFECT.get(), 300), 1).build();

    public static final FoodProperties TOMATO = new FoodProperties.Builder()
            .nutrition(4)
            .saturationMod(0.4f).build();

    public static final FoodProperties CHILI_PEPPER = new FoodProperties.Builder()
            .nutrition(3)
            .saturationMod(0.4f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400), 1)
            .alwaysEat()
            .build();

    public static final FoodProperties GHOST_PEPPER = new FoodProperties.Builder()
            .nutrition(4)
            .saturationMod(0.7f)
            .effect(() -> new MobEffectInstance(ModEffects.FIRE_POWER_EFFECT.get(), TICKS_IN_MINUTE), 1)
            .alwaysEat()
            .build();

    public static final FoodProperties GRAPES = new FoodProperties.Builder()
            .fast()
            .nutrition(3)
            .saturationMod(0.3f).build();

}
