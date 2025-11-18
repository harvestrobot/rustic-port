package net.nebulosacrafts.rusticmod.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.nebulosacrafts.rusticmod.entity.ModBlockEntities;

import java.util.List;

public class CustomBlockEntity extends BlockEntity {
    private int lifetime = 200; // 10 segundos (20 ticks * 10)

    public CustomBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.TEMPORAL_BEACON.get(), pos, state);
    }

    public void tick() {
        if (level == null || level.isClientSide) return;

        // Aplicar efecto a entidades cercanas
        AABB area = new AABB(worldPosition).inflate(5); // radio de 5 bloques
        List<LivingEntity> entities = level.getEntitiesOfClass(LivingEntity.class, area);
        for (LivingEntity entity : entities) {
            entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 40, 0, true, true));
        }

        // Reducir vida útil
        lifetime--;
        if (lifetime <= 0) {
            level.removeBlock(worldPosition, false);
        }
    }
}

