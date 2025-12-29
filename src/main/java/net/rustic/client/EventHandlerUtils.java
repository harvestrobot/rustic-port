package net.rustic.client;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.rustic.effect.ModEffects;

/**
 * Class that contains common methods for both EventHandlerServer and EventHandlerClient
 */
public class EventHandlerUtils {

    public static boolean playerHasFirePowerEffect(final Player player, final Level level) {
        if (level.isClientSide) return false;

        return player.hasEffect(ModEffects.FIRE_POWER_EFFECT.get());
    }


    public static void launchFireball(final Player player, final Level level) {
        Vec3 look = player.getLookAngle();

        SmallFireball fireball = new SmallFireball(
                level,
                player,
                look.x * 0.5,
                look.y * 0.5,
                look.z * 0.5
        );

        fireball.setPos(
                player.getX() + look.x * 1.5,
                player.getEyeY() + look.y * 1.5,
                player.getZ() + look.z * 1.5
        );

        level.addFreshEntity(fireball);
    }
}
