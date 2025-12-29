package net.rustic.effect.custom;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;

public class FullmetalEffect extends MobEffect {

    public FullmetalEffect() {
        super(MobEffectCategory.NEUTRAL, 8220521);
    }

    @Override
    public boolean isDurationEffectTick(final int duration, final int amplifier) {
        return true;
    }

    @Override
    public void applyEffectTick(final LivingEntity entity, final int amplifier) {
        entity.setJumping(false);
        entity.setSprinting(false);

        if (entity.isPassenger()) {
            entity.stopRiding();
        }

        if (!entity.onGround() && !entity.isNoGravity()) {
            Vec3 motion = entity.getDeltaMovement();
            if (entity.isInWater() || entity.isInLava()) {
                entity.setDeltaMovement(motion.x, motion.y - (0.27 / 4), motion.z);
            } else if (entity.isFallFlying()) {
                entity.setDeltaMovement(motion.x, motion.y - (0.32 / 4), motion.z);
            } else {
                entity.setDeltaMovement(motion.x, motion.y - 0.07, motion.z);
            }
        }

        if (entity instanceof Player player) {
            player.getAbilities().flying = false;
            player.onUpdateAbilities();
        }
    }
}
