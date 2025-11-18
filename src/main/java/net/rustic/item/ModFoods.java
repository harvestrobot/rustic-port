package net.rustic.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {

    public static final FoodProperties OLIVES = new FoodProperties.Builder()
            .fast()
            .nutrition(1)
            .saturationMod(0.4f).effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 200), 1).build();

    //TODO hay que crear el efecto Fullmetal para las ironberries
    public static final FoodProperties IRONBERRIES = new FoodProperties.Builder()
            .fast()
            .alwaysEat()
            .nutrition(2)
            .saturationMod(0.4f).effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 300), 1).build();

    //TODO si haces clic derecho con el tomate en la mano, lo debería lanzar
    public static final FoodProperties TOMATO = new FoodProperties.Builder()
            .nutrition(4)
            .saturationMod(0.4f).build();

    //TODO hay que poner que haya 1/24 probabilidades de que salgas ardiendo 1 corazón
    public static final FoodProperties CHILI_PEPPER = new FoodProperties.Builder()
            .nutrition(3)
            .saturationMod(0.4f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400), 1)
            .build();

    //TODO hay que poner que salgas ardiendo 2 corazones
    //TODO hay que poner que tenga (new PotionEffect(PotionsRustic.FIRE_POWER_POTION, 1200, 0));
    public static final FoodProperties GHOST_PEPPER = new FoodProperties.Builder()
            .nutrition(4)
            .saturationMod(0.7f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400), 1)
            .build();

    public static final FoodProperties WILDBERRIES = new FoodProperties.Builder()
            .fast()
            .nutrition(2)
            .saturationMod(0.5f).effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 200), 1).build();

    public static final FoodProperties GRAPES = new FoodProperties.Builder()
            .fast()
            .nutrition(3)
            .saturationMod(0.3f).effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 200), 1).build();

}
