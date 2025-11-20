package net.rustic.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rustic.RusticMod;
import net.rustic.item.custom.TomatoProjectile;

public class ModItems {

    // Deferred register es una lista de algo, en este caso Item
    // Cuando añadamos aquí los items se registarán en un momento específico para que Forge los inyecte
    // Al mod
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RusticMod.MOD_ID);

    //foods
    public static final RegistryObject<Item> OLIVES = ITEMS.register("olives", () -> new Item(new Item.Properties().food(ModFoods.OLIVES)));
    public static final RegistryObject<Item> IRONBERRIES = ITEMS.register("ironberries", () -> new Item(new Item.Properties().food(ModFoods.IRONBERRIES)));
    public static final RegistryObject<Item> TOMATO = ITEMS.register("tomato", () -> new TomatoProjectile(new Item.Properties().food(ModFoods.TOMATO)));
    public static final RegistryObject<Item> CHILI_PEPPER = ITEMS.register("chili_pepper", () -> new Item(new Item.Properties().food(ModFoods.CHILI_PEPPER)));
    public static final RegistryObject<Item> GHOST_PEPPER = ITEMS.register("ghost_pepper", () -> new Item(new Item.Properties().food(ModFoods.GHOST_PEPPER)));
    public static final RegistryObject<Item> WILDBERRIES = ITEMS.register("wildberries", () -> new Item(new Item.Properties().food(ModFoods.WILDBERRIES)));
    public static final RegistryObject<Item> GRAPES = ITEMS.register("grapes", () -> new Item(new Item.Properties().food(ModFoods.GRAPES)));

    // Método estático para poder acceder a registrar los elementos en el eventBus que habrá en la clase main
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
