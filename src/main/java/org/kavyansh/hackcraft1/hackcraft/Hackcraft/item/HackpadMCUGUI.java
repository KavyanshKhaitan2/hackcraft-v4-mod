package org.kavyansh.hackcraft1.hackcraft.Hackcraft.item;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import org.kavyansh.hackcraft1.hackcraft.Hackcraft.component.ModComponents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;
import io.netty.buffer.Unpooled;
import org.kavyansh.hackcraft1.hackcraft.Hackcraft.Main;

import java.util.ArrayList;
import java.util.List;

public class HackpadMCUGUI extends Screen {
    ItemStack stack;

    public HackpadMCUGUI(Text title, ItemStack stack) {
        super(title);
        this.stack = stack;
    }
    int grid_start_x;
    int grid_start_y;

    @Override
    protected void init() {
        List<TextFieldWidget> textFields = new ArrayList<>();

        int input_width = 120;
        int input_height = 20;

        grid_start_x = (int)(this.width / 2) - (input_width * 4 / 2);
        grid_start_y = (int)(this.height / 2) - (input_height * 4 / 2);

        for (int i = 0; i < 16; i++) {
            var x = i % 4;
            var y = (int)(i / 4);
            int finalI = i;
            var textField = new TextFieldWidget(this.textRenderer, input_width, input_height, Text.of(""));
            textField.setX(grid_start_x + (input_width * x));
            textField.setY(grid_start_y + (input_height * y));
            textFields.add(textField);
        }

        textFields.get(0).setText(stack.getOrDefault(ModComponents.HACKPAD_BUTTON_0, ""));
        textFields.get(1).setText(stack.getOrDefault(ModComponents.HACKPAD_BUTTON_1, ""));
        textFields.get(2).setText(stack.getOrDefault(ModComponents.HACKPAD_BUTTON_2, ""));
        textFields.get(3).setText(stack.getOrDefault(ModComponents.HACKPAD_BUTTON_3, ""));
        textFields.get(4).setText(stack.getOrDefault(ModComponents.HACKPAD_BUTTON_4, ""));
        textFields.get(5).setText(stack.getOrDefault(ModComponents.HACKPAD_BUTTON_5, ""));
        textFields.get(6).setText(stack.getOrDefault(ModComponents.HACKPAD_BUTTON_6, ""));
        textFields.get(7).setText(stack.getOrDefault(ModComponents.HACKPAD_BUTTON_7, ""));
        textFields.get(8).setText(stack.getOrDefault(ModComponents.HACKPAD_BUTTON_8, ""));
        textFields.get(9).setText(stack.getOrDefault(ModComponents.HACKPAD_BUTTON_9, ""));
        textFields.get(10).setText(stack.getOrDefault(ModComponents.HACKPAD_BUTTON_10, ""));
        textFields.get(11).setText(stack.getOrDefault(ModComponents.HACKPAD_BUTTON_11, ""));
        textFields.get(12).setText(stack.getOrDefault(ModComponents.HACKPAD_BUTTON_12, ""));
        textFields.get(13).setText(stack.getOrDefault(ModComponents.HACKPAD_BUTTON_13, ""));
        textFields.get(14).setText(stack.getOrDefault(ModComponents.HACKPAD_BUTTON_14, ""));
        textFields.get(15).setText(stack.getOrDefault(ModComponents.HACKPAD_BUTTON_15, ""));


        var saveButton = ButtonWidget.builder(Text.of("Write to flash"), (btn) -> {
            assert this.client.player != null;
            ArrayList<String> fieldTexts = new ArrayList<>();
            for (TextFieldWidget textField : textFields) {
                String text = textField.getText();
                fieldTexts.add(text);
            }

            Main.HackpadMCUPayload payload = new Main.HackpadMCUPayload(String.join(",", fieldTexts));
            ClientPlayNetworking.send(payload);

            this.close();
            this.client.player.sendMessage(Text.of("Flashing ROM..."), true);
        }).dimensions(grid_start_x + (input_width * 3), grid_start_y + (input_height * 4), input_width, input_height).build();
        this.addDrawableChild(saveButton);

        // Register the button widget.
        for (TextFieldWidget textField : textFields) {
            this.addDrawableChild(textField);
        }


    }

    @Override
    public void render(DrawContext graphics, int mouseX, int mouseY, float delta) {
        super.render(graphics, mouseX, mouseY, delta);

        // Minecraft doesn't have a "label" widget, so we'll have to draw our own text.
        // We'll subtract the font height from the Y position to make the text appear above the button.
        // Subtracting an extra 10 pixels will give the text some padding.
        // textRenderer, text, x, y, color, hasShadow
        graphics.drawTextWithShadow(this.textRenderer, "Program Hackpad Microcontroller", grid_start_x , grid_start_y - this.textRenderer.fontHeight - 10, 0xFFFFFFFF);
    }

}
