package net.rustic.network;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;
import net.rustic.client.EventHandlerUtils;

import java.util.function.Supplier;

public class LaunchFireballPacket {

    public LaunchFireballPacket() {
    }

    //Decoder
    public LaunchFireballPacket(FriendlyByteBuf buf) {
    }

    //Encoder
    public void toBytes(FriendlyByteBuf buf) {
    }

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayer serverPlayerEntity = ctx.get().getSender();
            if (serverPlayerEntity != null) {
                EventHandlerUtils.launchFireball(serverPlayerEntity, serverPlayerEntity.level());
            }
        });
        ctx.get().setPacketHandled(true);
    }
}