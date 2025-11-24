package net.rustic.item.custom.food;

import lombok.NonNull;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.rustic.entity.custom.TomatoProjectileEntity;
import org.jetbrains.annotations.NotNull;

public class TomatoProjectile extends Item {
    public TomatoProjectile(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NonNull final Level level, @NonNull final Player player, @NonNull final InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        // if player is crouching we shoot the tomato
        if (player.isShiftKeyDown()) {

            if (!player.getAbilities().instabuild) {
                stack.shrink(1);
            }

            level.playSound(null,
                    player.getX(),
                    player.getY(),
                    player.getZ(),
                    SoundEvents.SNOWBALL_THROW,
                    SoundSource.NEUTRAL,
                    0.5F,
                    0.4F / (player.getRandom().nextFloat() * 0.4F + 0.8F)
            );

            if (!level.isClientSide) {
                final TomatoProjectileEntity projectile = new TomatoProjectileEntity(level, player);
                projectile.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
                level.addFreshEntity(projectile);
            }

            player.awardStat(Stats.ITEM_USED.get(this));
            return InteractionResultHolder.success(stack);
        }

        // if player is not crouching then the tomato is eaten
        return super.use(level, player, hand);
    }
}
