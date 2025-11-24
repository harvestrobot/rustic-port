package net.rustic.network;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import net.rustic.RusticMod;

public class ModNetwork {
    private static int ID = 0;
    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            ResourceLocation.fromNamespaceAndPath(RusticMod.MOD_ID, "main"),
            () -> "1.0",
            s -> true,
            s -> true
    );

    public static void register() {
        INSTANCE.registerMessage(ID++, LaunchFireballPacket.class,
                LaunchFireballPacket::encode,
                LaunchFireballPacket::decode,
                LaunchFireballPacket::handle);
    }
}