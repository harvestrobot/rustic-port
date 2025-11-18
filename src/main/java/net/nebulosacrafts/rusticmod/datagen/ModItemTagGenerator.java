package net.nebulosacrafts.rusticmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.nebulosacrafts.rusticmod.RusticMod;
import net.nebulosacrafts.rusticmod.item.ModItems;
import net.nebulosacrafts.rusticmod.util.ModTags;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, RusticMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider) {
        this.tag(ModTags.Items.MUSHROOMS)
                .add(Items.RED_MUSHROOM)
                .add(Items.BROWN_MUSHROOM)
                .add(Items.WARPED_FUNGUS)
                .add(Items.CRIMSON_FUNGUS);

        this.tag(ModTags.Items.SYRINGES)
                .add(ModItems.SYRINGE.get())
                .add(ModItems.HEALING_SYRINGE.get())
                .add(ModItems.STRANGE_SYRINGE.get())
                .add(ModItems.DMT_SYRINGE.get())
                .add(ModItems.AMPHETAMINE_SYRINGE.get())
                .add(ModItems.PROPANOLOL_SYRINGE.get());
    }
}
