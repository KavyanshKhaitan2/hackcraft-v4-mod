package org.kavyansh.hackcraft1.hackcraft.Hackcraft.item;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import org.kavyansh.hackcraft1.hackcraft.Hackcraft.component.ModComponents;

import java.util.ArrayList;
import java.util.List;

public class HackpadMCUGUI extends Screen {
    HackpadMCUItem item;

    public HackpadMCUGUI(Text title, HackpadMCUItem item) {
        super(title);
        this.item = item;
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

        var saveButton = ButtonWidget.builder(Text.of("Write to flash"), (btn) -> {
            this.close();
            assert this.client.player != null;
            ArrayList<String> fieldTexts = new ArrayList<String>();
            for (TextFieldWidget textField : textFields) {
                String text = textField.getText();
                fieldTexts.add(text);
            }
            ItemStack stack = this.item.getDefaultStack();
            this.client.player.networkHandler.sendChatMessage(fieldTexts.get(0));
            stack.set(ModComponents.HACKPAD_BUTTON_0, fieldTexts.get(0));
            stack.set(ModComponents.HACKPAD_BUTTON_1, fieldTexts.get(1));
            stack.set(ModComponents.HACKPAD_BUTTON_2, fieldTexts.get(2));
            stack.set(ModComponents.HACKPAD_BUTTON_3, fieldTexts.get(3));
            stack.set(ModComponents.HACKPAD_BUTTON_4, fieldTexts.get(4));
            stack.set(ModComponents.HACKPAD_BUTTON_5, fieldTexts.get(5));
            stack.set(ModComponents.HACKPAD_BUTTON_6, fieldTexts.get(6));
            stack.set(ModComponents.HACKPAD_BUTTON_7, fieldTexts.get(7));
            stack.set(ModComponents.HACKPAD_BUTTON_8, fieldTexts.get(8));
            stack.set(ModComponents.HACKPAD_BUTTON_9, fieldTexts.get(9));
            stack.set(ModComponents.HACKPAD_BUTTON_10, fieldTexts.get(10));
            stack.set(ModComponents.HACKPAD_BUTTON_11, fieldTexts.get(11));
            stack.set(ModComponents.HACKPAD_BUTTON_12, fieldTexts.get(12));
            stack.set(ModComponents.HACKPAD_BUTTON_13, fieldTexts.get(13));
            stack.set(ModComponents.HACKPAD_BUTTON_14, fieldTexts.get(14));
            stack.set(ModComponents.HACKPAD_BUTTON_15, fieldTexts.get(15));

            this.client.player.sendMessage(Text.of("Flashing complete!"), true);
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
