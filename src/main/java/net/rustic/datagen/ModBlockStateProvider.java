package net.rustic.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.rustic.RusticMod;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, RusticMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
//        blockWithItem(ModBlocks.TEMPORAL_BEACON);
    }

    private void blockWithItem (RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
