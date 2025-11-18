package net.rusticmod.entity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.rusticmod.RusticMod;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, RusticMod.MOD_ID);

//    public static final RegistryObject<BlockEntityType<CustomBlockEntity>> TEMPORAL_BEACON =
//            BLOCK_ENTITIES.register("temporal_beacon",
//                    () -> BlockEntityType.Builder.of(
//                            CustomBlockEntity::new,
//                            ModBlocks.TEMPORAL_BEACON.get()
//                    ).build(null));

    public static void register(IEventBus eventBus){
        BLOCK_ENTITIES.register(eventBus);
    }



}
