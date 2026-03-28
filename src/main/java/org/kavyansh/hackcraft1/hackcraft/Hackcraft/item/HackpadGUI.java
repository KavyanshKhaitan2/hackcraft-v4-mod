package org.kavyansh.hackcraft1.hackcraft.Hackcraft.item;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.toast.SystemToast;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import org.kavyansh.hackcraft1.hackcraft.Hackcraft.Main;
import org.kavyansh.hackcraft1.hackcraft.Hackcraft.component.ModComponents;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class HackpadGUI extends Screen {
    ItemStack stack;

    public HackpadGUI(Text title, ItemStack stack) {
        super(title);
        this.stack = stack;
    }

    int grid_start_x;
    int grid_start_y;

    @Override
    protected void init() {
        List<ButtonWidget> buttons = new ArrayList<>();

        int button_width = 80;
        int button_height = 20;

        grid_start_x = (int)(this.width / 2) - (button_width * 4 / 2);
        grid_start_y = (int)(this.height / 2) - (button_height * 4 / 2);

        ArrayList<String> texts = new ArrayList<String>();

        texts.add(stack.getOrDefault(ModComponents.HACKPAD_BUTTON_0, ""));
        texts.add(stack.getOrDefault(ModComponents.HACKPAD_BUTTON_1, ""));
        texts.add(stack.getOrDefault(ModComponents.HACKPAD_BUTTON_2, ""));
        texts.add(stack.getOrDefault(ModComponents.HACKPAD_BUTTON_3, ""));
        texts.add(stack.getOrDefault(ModComponents.HACKPAD_BUTTON_4, ""));
        texts.add(stack.getOrDefault(ModComponents.HACKPAD_BUTTON_5, ""));
        texts.add(stack.getOrDefault(ModComponents.HACKPAD_BUTTON_6, ""));
        texts.add(stack.getOrDefault(ModComponents.HACKPAD_BUTTON_7, ""));
        texts.add(stack.getOrDefault(ModComponents.HACKPAD_BUTTON_8, ""));
        texts.add(stack.getOrDefault(ModComponents.HACKPAD_BUTTON_9, ""));
        texts.add(stack.getOrDefault(ModComponents.HACKPAD_BUTTON_10, ""));
        texts.add(stack.getOrDefault(ModComponents.HACKPAD_BUTTON_11, ""));
        texts.add(stack.getOrDefault(ModComponents.HACKPAD_BUTTON_12, ""));
        texts.add(stack.getOrDefault(ModComponents.HACKPAD_BUTTON_13, ""));
        texts.add(stack.getOrDefault(ModComponents.HACKPAD_BUTTON_14, ""));
        texts.add(stack.getOrDefault(ModComponents.HACKPAD_BUTTON_15, ""));


        for (int i = 0; i < 16; i++) {
            var x = i % 4;
            var y = (int)(i / 4);
            int finalI = i;
            var button = ButtonWidget.builder(Text.of(texts.get(finalI)), (btn) -> {
                this.close();
                assert this.client.player != null;
                this.client.player.networkHandler.sendChatMessage(texts.get(finalI));
                this.client.player.sendMessage(Text.of("Message sent!"), true);
            }).dimensions(grid_start_x + (button_width * x), grid_start_y + (button_height * y), button_width, button_height).build();

            button.active = !texts.get(finalI).isEmpty();

            buttons.add(button);
        }

        // Register the button widget.
        for (ButtonWidget button : buttons) {
            this.addDrawableChild(button);
        }

    }

    @Override
    public void render(DrawContext graphics, int mouseX, int mouseY, float delta) {
        super.render(graphics, mouseX, mouseY, delta);

        // Minecraft doesn't have a "label" widget, so we'll have to draw our own text.
        // We'll subtract the font height from the Y position to make the text appear above the button.
        // Subtracting an extra 10 pixels will give the text some padding.
        // textRenderer, text, x, y, color, hasShadow
        graphics.drawTextWithShadow(this.textRenderer, "Hackpad", grid_start_x , grid_start_y - this.textRenderer.fontHeight - 10, 0xFFFFFFFF);
    }

}
