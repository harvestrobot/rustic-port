package net.rustic.entity.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.rustic.entity.ModEntities;
import net.rustic.item.ModItems;

public class TomatoProjectileEntity extends ThrowableItemProjectile {

    public TomatoProjectileEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public TomatoProjectileEntity(Level pLevel) {
        super(ModEntities.TOMATO_PROJECTILE_ENTITY.get(), pLevel);
    }

    public TomatoProjectileEntity(Level pLevel, LivingEntity livingEntity) {
        super(ModEntities.TOMATO_PROJECTILE_ENTITY.get(), livingEntity, pLevel);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.TOMATO.get();
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        if (!this.level().isClientSide()) {
            this.level().broadcastEntityEvent(this, (byte) 3);
            //TODO this.entity? para ponerle el sangrado tomatero
            Entity targetedEntity = pResult.getEntity();
            if (targetedEntity instanceof LivingEntity living) {
                living.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED));
            }
        }
        super.onHitEntity(pResult);
    }
}
