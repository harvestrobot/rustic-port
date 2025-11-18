package net.nebulosacrafts.rusticmod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nebulosacrafts.rusticmod.RusticMod;
import net.nebulosacrafts.rusticmod.item.custom.rustic.*;

public class ModItems {

    // Deferred register es una lista de algo, en este caso Item
    // Cuando añadamos aquí los items se registarán en un momento específico para que Forge los inyecte
    // Al mod
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RusticMod.MOD_ID);

    // Método estático para poder acceder a registrar los elementos en el eventBus que habrá en la clase main
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
