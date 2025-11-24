package net.rustic.item.custom.food;

import lombok.NonNull;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class GhostPepperFoodItem extends Item {

    public GhostPepperFoodItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public @NotNull ItemStack finishUsingItem(@NonNull final ItemStack stack, @NonNull final Level level,
                                              @NonNull final LivingEntity entity) {

        ItemStack result = super.finishUsingItem(stack, level, entity);
        entity.setSecondsOnFire(2);

        return result;
    }
}
