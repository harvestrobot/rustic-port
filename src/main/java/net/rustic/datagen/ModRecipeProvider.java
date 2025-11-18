package net.rustic.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
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
//        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SYRINGE.get(), 2)
//                .pattern("  N")
//                .pattern(" G ")
//                .pattern("G  ")
//                .define('N', Items.IRON_NUGGET)
//                .define('G', Items.GLASS_PANE)
//                .unlockedBy(getHasName(Items.IRON_NUGGET), has(Items.IRON_NUGGET))
//                .save(pWriter);
    }
}
