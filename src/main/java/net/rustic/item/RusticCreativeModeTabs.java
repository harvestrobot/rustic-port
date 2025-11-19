package net.rustic.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.rustic.RusticMod;

public class RusticCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister
                    .create(Registries.CREATIVE_MODE_TAB, RusticMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> RUSTIC_DECOR_TAB =
            CREATIVE_MODE_TABS.register("rustic_agriculture_tab",
                    () -> CreativeModeTab.builder().icon(
                    () -> new ItemStack(ModItems.OLIVES.get()))
                            .title(Component.translatable("itemGroup.rustic.agriculture"))
                            .displayItems((pParameters, pOutput) -> {
                                /*
                                Para poner todos los objetos de ModItems en la misma Tab ->
                                .displayItems((pParameters, pOutput) -> {
                                    for(RegistryObject<Item> item : ModItems.ITEMS.getEntries()) {
                                        pOutput.accept(item.get());
                                    }
                                })
                                 */
                                pOutput.accept(ModItems.OLIVES.get());
                                pOutput.accept(ModItems.GRAPES.get());
                                pOutput.accept(ModItems.CHILI_PEPPER.get());
                                pOutput.accept(ModItems.GHOST_PEPPER.get());
                                pOutput.accept(ModItems.WILDBERRIES.get());
                                pOutput.accept(ModItems.IRONBERRIES.get());
                                pOutput.accept(ModItems.TOMATO.get());
                            })
                            .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
