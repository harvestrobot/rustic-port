package net.rustic.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rustic.RusticMod;
import net.rustic.entity.custom.TomatoProjectileEntity;

public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, RusticMod.MOD_ID);


    public static final RegistryObject<EntityType<TomatoProjectileEntity>> TOMATO_PROJECTILE_ENTITY =
            ENTITY_TYPES.register("tomato_projectile", () -> EntityType.Builder.<TomatoProjectileEntity>of(TomatoProjectileEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build("tomato_projectile"));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }



}
