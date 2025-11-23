package net.rustic.effect.custom;

import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class TomatoBleedEffect extends MobEffect {

    public TomatoBleedEffect() {
        super(MobEffectCategory.NEUTRAL, 0xD96650);
    }

    @Override
    public boolean isDurationEffectTick(final int duration, final int amplifier) {
        return duration % 20 == 0;
    }

    @Override
    public void applyEffectTick(final LivingEntity entity, final int amplifier) {
        if (entity.level().isClientSide()) {
            ItemStack stack = new ItemStack(Items.RED_CONCRETE_POWDER);

            for (int i = 0; i < 5; i++) {
                entity.level().addParticle(
                        new ItemParticleOption(ParticleTypes.ITEM, stack),
                        entity.getRandomX(0.5),
                        entity.getY() + 1.0,
                        entity.getRandomZ(0.5),
                        0.0, -0.2, 0.0
                );
            }
            entity.playSound(SoundEvents.HONEY_BLOCK_BREAK, 0.3F, 1.2F);
        }

        super.applyEffectTick(entity, amplifier);
    }
}
