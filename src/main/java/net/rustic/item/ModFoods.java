package net.rustic.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {

    public static final FoodProperties OLIVES = new FoodProperties.Builder()
            .fast()
            .nutrition(1)
            .saturationMod(0.4f).effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 200), 1).build();
}
