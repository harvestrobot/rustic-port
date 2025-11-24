package net.rustic.network;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

import static net.rustic.client.EventHandlerUtils.launchFireball;

public class LaunchFireballPacket {

    public LaunchFireballPacket() {
    }

    public static void encode(LaunchFireballPacket pkt, FriendlyByteBuf buf) {

    }

    public static LaunchFireballPacket decode(FriendlyByteBuf buf) {
        return new LaunchFireballPacket();
    }


    public static void handle(LaunchFireballPacket pkt, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayer player = ctx.get().getSender();
            if (player != null) {
                Level level = player.serverLevel();
                if (level instanceof ServerLevel serverLevel) {
                    launchFireball(player, serverLevel);
                }
            }
        });
        ctx.get().setPacketHandled(true);
    }
}