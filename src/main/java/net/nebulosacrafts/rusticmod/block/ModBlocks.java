package net.nebulosacrafts.rusticmod.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nebulosacrafts.rusticmod.RusticMod;
import net.nebulosacrafts.rusticmod.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, RusticMod.MOD_ID);

    public static final RegistryObject<Block> TEMPORAL_BEACON = registerBlock(
            "temporal_beacon", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noLootTable()));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> blockToRegister){
        RegistryObject<T> blockToReturn = BLOCKS.register(name, blockToRegister);
        registerBlockItem(name, blockToReturn);
        return blockToReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }

}
