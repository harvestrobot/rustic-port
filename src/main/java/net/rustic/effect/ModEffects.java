package net.rustic.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rustic.RusticMod;
import net.rustic.effect.custom.TomatoBleedEffect;

public class ModEffects {

    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, RusticMod.MOD_ID);


    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, RusticMod.MOD_ID);

    public static final RegistryObject<MobEffect> TOMATO_BLEED_EFFECT = MOB_EFFECTS.register("tomato_bleed_effect",
            TomatoBleedEffect::new);

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }

}
