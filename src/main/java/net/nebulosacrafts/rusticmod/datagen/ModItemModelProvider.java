package net.nebulosacrafts.rusticmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.nebulosacrafts.rusticmod.RusticMod;
import net.nebulosacrafts.rusticmod.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, RusticMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.SYRINGE);
        simpleItem(ModItems.HEALING_SYRINGE);
        simpleItem(ModItems.STRANGE_SYRINGE);
        simpleItem(ModItems.DMT_SYRINGE);
        simpleItem(ModItems.AMPHETAMINE_SYRINGE);
        simpleItem(ModItems.PROPANOLOL_SYRINGE);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                        ResourceLocation.fromNamespaceAndPath(RusticMod.MOD_ID, "item/"+item.getId().getPath()));
    }
}
