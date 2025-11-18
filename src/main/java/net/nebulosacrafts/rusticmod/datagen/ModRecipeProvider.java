package net.nebulosacrafts.rusticmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.nebulosacrafts.rusticmod.block.ModBlocks;
import net.nebulosacrafts.rusticmod.item.ModItems;
import net.nebulosacrafts.rusticmod.util.ModTags;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

/**
 * Esta clase contiene las recetas.
 */
public class ModRecipeProvider extends RecipeProvider {

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> pWriter) {

        // Syringe
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SYRINGE.get(), 2)
                .pattern("  N")
                .pattern(" G ")
                .pattern("G  ")
                .define('N', Items.IRON_NUGGET)
                .define('G', Items.GLASS_PANE)
                .unlockedBy(getHasName(Items.IRON_NUGGET), has(Items.IRON_NUGGET))
                .save(pWriter);

        // Healing syringe
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.HEALING_SYRINGE.get(), 2)
                .requires(ModItems.SYRINGE.get())
                .requires(Items.GLISTERING_MELON_SLICE)
                .unlockedBy(getHasName(ModItems.SYRINGE.get()), has(ModItems.SYRINGE.get()))
                .save(pWriter);

        // Strange syringe
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.STRANGE_SYRINGE.get(), 2)
                .requires(ModItems.SYRINGE.get())
                .requires(ModTags.Items.MUSHROOMS)
                .unlockedBy(getHasName(ModItems.SYRINGE.get()), has(ModItems.SYRINGE.get()))
                .save(pWriter);

        // Propanolol syringe
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PROPANOLOL_SYRINGE.get())
                .requires(ModItems.SYRINGE.get())
                .requires(Items.SNOWBALL)
                .requires(ItemTags.FLOWERS)
                .unlockedBy(getHasName(ModItems.SYRINGE.get()), has(ModItems.SYRINGE.get()))
                .save(pWriter);

        // Amphetamine syringe
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.AMPHETAMINE_SYRINGE.get())
                .requires(ModItems.SYRINGE.get())
                .requires(Items.SUGAR)
                .requires(Items.SUGAR)
                .unlockedBy(getHasName(ModItems.SYRINGE.get()), has(ModItems.SYRINGE.get()))
                .save(pWriter);

        // DMT syringe
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.DMT_SYRINGE.get(), 2)
                .requires(ModItems.SYRINGE.get())
                .requires(Items.SUSPICIOUS_STEW)
                .unlockedBy(getHasName(ModItems.SYRINGE.get()), has(ModItems.SYRINGE.get()))
                .save(pWriter);

        //Temporal beacon
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TEMPORAL_BEACON.get(), 1)
                .pattern("III")
                .pattern("IRI")
                .pattern("IBI")
                .define('I', Items.IRON_INGOT)
                .define('R', Items.REDSTONE)
                .define('B', Items.IRON_BLOCK)
                .unlockedBy(getHasName(Items.REDSTONE), has(Items.REDSTONE))
                .save(pWriter);
    }
}
