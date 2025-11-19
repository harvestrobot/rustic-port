package net.rustic.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.rustic.RusticMod;
import net.rustic.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, RusticMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.OLIVES);
        simpleItem(ModItems.IRONBERRIES);
        simpleItem(ModItems.TOMATO);
        simpleItem(ModItems.CHILI_PEPPER);
        simpleItem(ModItems.GHOST_PEPPER);
        simpleItem(ModItems.WILDBERRIES);
        simpleItem(ModItems.GRAPES);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                        ResourceLocation.fromNamespaceAndPath(RusticMod.MOD_ID, "item/"+item.getId().getPath()));
    }
}
