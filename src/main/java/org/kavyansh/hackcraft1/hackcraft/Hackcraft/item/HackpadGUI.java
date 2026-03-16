package org.kavyansh.hackcraft1.hackcraft.Hackcraft.item;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.toast.SystemToast;
import net.minecraft.text.Text;
import org.kavyansh.hackcraft1.hackcraft.Hackcraft.Main;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class HackpadGUI extends Screen {
    public HackpadGUI(Text title) {
        super(title);
    }

    @Override
    protected void init() {
        List<ButtonWidget> buttons = new ArrayList<>();

        int button_width = 80;
        int button_height = 20;

        int grid_start_x = (int)(this.width / 2) - (button_width * 4 / 2);
        int grid_start_y = (int)(this.height / 2) - (button_height * 4 / 2);

        for (int i = 0; i < 16; i++) {
            var x = i % 4;
            var y = (int)(i / 4);
            int finalI = i;
            var button = ButtonWidget.builder(Text.of("Button " + Integer.toString(i)), (btn) -> {
                this.close();
                assert this.client.player != null;
                this.client.player.networkHandler.sendChatMessage("I just clicked button "+Integer.toString(finalI)+"!");
                this.client.player.sendMessage(Text.of("Message sent!"), true);
//                this.client.getToastManager().add(
//                        SystemToast.create(this.client, SystemToast.Type.NARRATOR_TOGGLE, Text.of("Hello World!"), Text.of("This is a toast."))
//                );
            }).dimensions(grid_start_x + (button_width * x), grid_start_y + (button_height * y), button_width, button_height).build();
            button.active = true;
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
        graphics.drawTextWithShadow(this.textRenderer, "Hackpad", 40, 40 - this.textRenderer.fontHeight - 10, 0xFFFFFFFF);
    }

}
