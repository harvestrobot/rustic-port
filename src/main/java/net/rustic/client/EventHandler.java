package net.rustic.client;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.Input;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ComputeFovModifierEvent;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.earlydisplay.RenderElement;
import net.rustic.RusticMod;
import net.rustic.effect.ModEffects;
import net.rustic.network.LaunchFireballPacket;
import net.rustic.network.ModNetwork;

import static net.rustic.client.EventHandlerUtils.launchFireball;
import static net.rustic.client.EventHandlerUtils.playerHasFirePowerEffect;

@Mod.EventBusSubscriber(modid = RusticMod.MOD_ID, value = Dist.CLIENT)
public class EventHandler {

    public static ResourceLocation FULLMETAL_OVERLAY = ResourceLocation.parse(
            "rustic:textures/misc/fullmetal_overlay.png");


    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onFullmetalFov(ComputeFovModifierEvent event) {
        final Player player = event.getPlayer();
        if (player.hasEffect(ModEffects.FULLMETAL_EFFECT.get())) {

            float f = 1.0F;

            if (player.isUsingItem() && player.getUseItem().is(Items.BOW)) {

                int i = player.getUseItemRemainingTicks();
                float f1 = (float) i / 20.0F;

                if (f1 > 1.0F) {
                    f1 = 1.0F;
                } else {
                    f1 = f1 * f1;
                }

                f *= 1.0F - f1 * 0.15F;
            }

            event.setNewFovModifier(f);
        }
    }

    @SubscribeEvent
    public static void onPlayerInput(TickEvent.PlayerTickEvent event) {
        if (event.side != LogicalSide.CLIENT) return;

        final Player player = event.player;
        if (player.hasEffect(ModEffects.FULLMETAL_EFFECT.get())) {

            final Minecraft mc = Minecraft.getInstance();

            if (mc.player == player && player.hasEffect(ModEffects.FULLMETAL_EFFECT.get())) {
                Input input = mc.player.input;

                input.jumping = false;
                input.forwardImpulse = 0F;
                input.shiftKeyDown = false;
                input.leftImpulse = 0F;
                input.right = false;
                input.left = false;
            }
        }
    }

    //TODO this is bad idk what im doing help
    @SubscribeEvent
    public static void onRenderFullmetalOverlay(RenderHandEvent event) {
        final Minecraft mc = Minecraft.getInstance();
        final Player player = mc.player;
        if (player == null) return;

        if (!player.hasEffect(ModEffects.FULLMETAL_EFFECT.get())) return;

        event.setCanceled(true);

        final boolean flag = mc.getCameraEntity() instanceof LivingEntity living && living.isSleeping();

        final ItemRenderer heldRenderer = mc.getItemRenderer();

        final PoseStack poseStack = event.getPoseStack();
        final MultiBufferSource bufferSource = event.getMultiBufferSource();
        final RenderElement.DisplayContext displayContext;

        final ItemStack main = mc.player.getMainHandItem();

        if (mc.options.getCameraType().isFirstPerson() && !flag && !mc.options.hideGui && !mc.isPaused()) {
            mc.gameRenderer.lightTexture().turnOnLightLayer();
            //heldRenderer.render(main, null, false, poseStack, bufferSource, 1F, 1F, null);
            mc.gameRenderer.lightTexture().turnOffLightLayer();
        }

        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.disableDepthTest();
        RenderSystem.setShaderTexture(0, FULLMETAL_OVERLAY);

        final float baseAlpha = 0.9625F;
        float durationFade = 1.0F;
        final int effectDuration = player.getEffect(ModEffects.FULLMETAL_EFFECT.get()).getDuration();

        if (effectDuration < 100) {
            float dur = (effectDuration + event.getPartialTick()) * 2F;
            float j1 = 10 - (dur / 20);
            durationFade = 0.5F + Mth.clamp(dur / 400F, 0.0F, 0.9375F - 0.5F) +
                    Mth.cos((200 - dur) * (float) Math.PI / 200F * 9F) *
                            Mth.clamp(j1 / 10.0F * 0.25F, 0.0625F, 0.25F);
            durationFade = Mth.sqrt(durationFade);
            if (dur < 20) {
                durationFade *= Mth.sqrt(dur / 20F);
            }
        }

        //TODO ???
        RenderSystem.setShaderColor(0F, 0F, 0F, baseAlpha * durationFade);

        final BufferBuilder buffer = Tesselator.getInstance().getBuilder();
        buffer.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
        buffer.vertex(-1.0D, -1.0D, -0.5D).uv(1.5F, 1.5F).endVertex();
        buffer.vertex(1.0D, -1.0D, -0.5D).uv(-0.5F, 1.5F).endVertex();
        buffer.vertex(1.0D, 1.0D, -0.5D).uv(-0.5F, -0.5F).endVertex();
        buffer.vertex(-1.0D, 1.0D, -0.5D).uv(1.5F, -0.5F).endVertex();
        Tesselator.getInstance().end();

        RenderSystem.enableDepthTest();
        RenderSystem.disableBlend();
    }

    //TODO this is not working at all. when left clicking in the air it does not launch a fireball.
    @SubscribeEvent
    public static void onLeftClickAir(PlayerInteractEvent.LeftClickEmpty event) {
        final Player player = event.getEntity();
        final Level level = player.level();

        if (level.isClientSide()) return;

        if (playerHasFirePowerEffect(player, level)) {
            launchFireball(player, level);
        }
    }

    @SubscribeEvent
    public static void onLeftClickBlock(PlayerInteractEvent.LeftClickBlock event) {
        final Player player = event.getEntity();
        final Level level = player.level();

        if (playerHasFirePowerEffect(player, level)) {
            launchFireball(player, level);
        }
    }

    @SubscribeEvent
    public static void onAttackEntity(AttackEntityEvent event) {
        final Player player = event.getEntity();
        final Level level = player.level();

        if (playerHasFirePowerEffect(player, level)) {
            launchFireball(player, level);
        }
    }

//    @SubscribeEvent
//    public static void onLeftClickAirClient(PlayerInteractEvent.LeftClickEmpty event) {
//        final Player player = event.getEntity();
//        final Level level = player.level();
//
//        if (playerHasFirePowerEffect(player, level)) {
//            launchFireball(player, level);
//        }
//    }

    @SubscribeEvent
    public static void leftClickAir(final PlayerInteractEvent.LeftClickEmpty e) {
        final Player player = e.getEntity();
        final Level level = player.level();

        if (playerHasFirePowerEffect(player, level)) {
            ModNetwork.sendToServer(new LaunchFireballPacket());
        }
    }
}
