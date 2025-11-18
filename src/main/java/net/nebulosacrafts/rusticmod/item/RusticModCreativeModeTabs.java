package net.nebulosacrafts.rusticmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.nebulosacrafts.rusticmod.RusticMod;
import net.nebulosacrafts.rusticmod.block.ModBlocks;

public class RusticModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister
                    .create(Registries.CREATIVE_MODE_TAB, RusticMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> RUSTIC_MOD =
            CREATIVE_MODE_TABS.register("rustic_tab",
                    () -> CreativeModeTab.builder().icon(
                    () -> new ItemStack())
                            .title(Component.translatable("creativetab.rustic_tab"))
                            .displayItems((pParameters, pOutput) -> {

                                pOutput.accept(ModBlocks.TEMPORAL_BEACON.get());
                                /*
                                Para poner todos los objetos de ModItems en la misma Tab ->
                                .displayItems((pParameters, pOutput) -> {
                                    for(RegistryObject<Item> item : ModItems.ITEMS.getEntries()) {
                                        pOutput.accept(item.get());
                                    }
                                })
                                 */
                            })
                            .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
