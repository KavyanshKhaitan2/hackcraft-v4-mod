package org.kavyansh.hackcraft1.hackcraft.Hackcraft;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.server.MinecraftServer;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.kavyansh.hackcraft1.hackcraft.Hackcraft.component.ModComponents;
import org.kavyansh.hackcraft1.hackcraft.Hackcraft.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class Main implements ModInitializer {
    public static final String MOD_ID = "hackcraft";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public record HackpadMCUPayload(String fieldTexts) implements CustomPayload {
        public static final Identifier HACKPAD_MCU_PAYLOAD_ID = Identifier.of(MOD_ID, "hackpad_mcu_packet");
        public static final CustomPayload.Id<HackpadMCUPayload> ID = new CustomPayload.Id<>(HACKPAD_MCU_PAYLOAD_ID);
        public static final PacketCodec<RegistryByteBuf, HackpadMCUPayload> CODEC = PacketCodec.tuple(PacketCodecs.STRING, HackpadMCUPayload::fieldTexts, HackpadMCUPayload::new);

        public Id<? extends CustomPayload> getId() {
            return ID;
        };
    }


    @Override
    public void onInitialize() {
        LOGGER.info("Loading HackCraft...");

        ModItems.registerModItems();
        ModComponents.initialize();

        PayloadTypeRegistry.playC2S().register(HackpadMCUPayload.ID, HackpadMCUPayload.CODEC);

        ServerPlayNetworking.registerGlobalReceiver(HackpadMCUPayload.ID, (buf, context) -> {
            MinecraftServer server = context.server();
            ItemStack item = context.player().getStackInHand(context.player().preferredHand);
            String data = buf.toString();
            server.execute(() -> {
                String[] fieldTexts = buf.fieldTexts.split(",");

                item.set(ModComponents.HACKPAD_BUTTON_0, fieldTexts[0]);
                item.set(ModComponents.HACKPAD_BUTTON_1, fieldTexts[1]);
                item.set(ModComponents.HACKPAD_BUTTON_2, fieldTexts[2]);
                item.set(ModComponents.HACKPAD_BUTTON_3, fieldTexts[3]);
                item.set(ModComponents.HACKPAD_BUTTON_4, fieldTexts[4]);
                item.set(ModComponents.HACKPAD_BUTTON_5, fieldTexts[5]);
                item.set(ModComponents.HACKPAD_BUTTON_6, fieldTexts[6]);
                item.set(ModComponents.HACKPAD_BUTTON_7, fieldTexts[7]);
                item.set(ModComponents.HACKPAD_BUTTON_8, fieldTexts[8]);
                item.set(ModComponents.HACKPAD_BUTTON_9, fieldTexts[9]);
                item.set(ModComponents.HACKPAD_BUTTON_10, fieldTexts[10]);
                item.set(ModComponents.HACKPAD_BUTTON_11, fieldTexts[11]);
                item.set(ModComponents.HACKPAD_BUTTON_12, fieldTexts[12]);
                item.set(ModComponents.HACKPAD_BUTTON_13, fieldTexts[13]);
                item.set(ModComponents.HACKPAD_BUTTON_14, fieldTexts[14]);
                item.set(ModComponents.HACKPAD_BUTTON_15, fieldTexts[15]);


            });
        });

        LOGGER.info("Successfully loaded HackCraft!");
    }
}
