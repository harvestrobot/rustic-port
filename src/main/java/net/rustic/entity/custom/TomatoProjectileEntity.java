package net.rustic.entity.custom;

import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.rustic.effect.ModEffects;
import net.rustic.entity.ModEntities;
import net.rustic.item.ModItems;

public class TomatoProjectileEntity extends ThrowableItemProjectile {

    public TomatoProjectileEntity(final EntityType<? extends ThrowableItemProjectile> pEntityType, final Level pLevel) {
        super(pEntityType, pLevel);
    }

    public TomatoProjectileEntity(final Level pLevel) {
        super(ModEntities.TOMATO_PROJECTILE_ENTITY.get(), pLevel);
    }

    public TomatoProjectileEntity(final Level pLevel, final LivingEntity livingEntity) {
        super(ModEntities.TOMATO_PROJECTILE_ENTITY.get(), livingEntity, pLevel);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.TOMATO.get();
    }

    @Override
    protected void onHitEntity(final EntityHitResult pResult) {
        if (!this.level().isClientSide()) {
            final Entity targetedEntity = pResult.getEntity();
            if (targetedEntity instanceof LivingEntity living) {
                living.addEffect(new MobEffectInstance(
                        ModEffects.TOMATO_BLEED_EFFECT.get(),
                        100,
                        0,
                        false,
                        false,
                        false
                ));

                ItemStack stack = new ItemStack(Items.RED_CONCRETE_POWDER);
                ItemParticleOption opt = new ItemParticleOption(ParticleTypes.ITEM, stack);

                ServerLevel sLevel = (ServerLevel) this.level();
                sLevel.sendParticles(
                        opt,                       // particle
                        living.getX(),             // x
                        living.getY() + 0.5,       // y
                        living.getZ(),             // z
                        12,                        // count
                        0.35, 0.5, 0.35,           // dx, dy, dz = spread
                        0.06                       // speed
                );

                this.playSound(SoundEvents.HONEY_BLOCK_BREAK);
            }
            this.level().broadcastEntityEvent(this, (byte) 3);
        }
        super.onHitEntity(pResult);
    }

    @Override
    public boolean isPickable() {
        return true;
    }
}
