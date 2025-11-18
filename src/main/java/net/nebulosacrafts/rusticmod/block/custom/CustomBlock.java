package net.nebulosacrafts.rusticmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.nebulosacrafts.rusticmod.entity.custom.CustomBlockEntity;

import javax.annotation.Nullable;

public class CustomBlock extends Block implements EntityBlock {

        public CustomBlock(Properties properties) {
            super(properties);
        }

        @Nullable
        @Override
        public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
            return new CustomBlockEntity(pos, state);
        }

        @Nullable
        @Override
        public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
            return level.isClientSide ? null : (lvl, pos, st, be) -> {
                if (be instanceof CustomBlockEntity beacon) {
                    beacon.tick();
                }
            };
        }


}
