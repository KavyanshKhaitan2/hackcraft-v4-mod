package org.kavyansh.hackcraft1.hackcraft.Hackcraft.mixin;

import net.minecraft.block.DirtPathBlock;
import net.minecraft.inventory.CraftingResultInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.AnvilScreenHandler;
import net.minecraft.screen.Property;
import org.kavyansh.hackcraft1.hackcraft.Hackcraft.component.ModComponents;
import org.kavyansh.hackcraft1.hackcraft.Hackcraft.item.HackpadItem;
import org.kavyansh.hackcraft1.hackcraft.Hackcraft.item.HackpadMCUItem;
import org.kavyansh.hackcraft1.hackcraft.Hackcraft.item.ModItems;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static org.kavyansh.hackcraft1.hackcraft.Hackcraft.Main.LOGGER;

@Mixin(AnvilScreenHandler.class)
public class AnvilScreenHandlerMixin {
    @Shadow
    @Final
    private static Logger LOGGER;

    @Shadow
    @Final
    private Property levelCost;

    @Inject(method = "updateResult", at = @At("HEAD"), cancellable = true)
    private void updateResultTail(CallbackInfo ci) {
        ForgingScreenHandlerAccessor accessor = (ForgingScreenHandlerAccessor)this;
        Inventory input = accessor.getInput();
        CraftingResultInventory output = accessor.getOutput();

        ItemStack leftInput = input.getStack(0);
        ItemStack rightInput = input.getStack(1);

        if (!leftInput.isEmpty() && !rightInput.isEmpty()) {
            if (leftInput.isOf(ModItems.HACKPAD) && rightInput.isOf(ModItems.HACKPAD_MCU)) {
                ItemStack output_hackpad = new ItemStack(ModItems.HACKPAD);

                output_hackpad.set(ModComponents.HACKPAD_BUTTON_0, rightInput.getOrDefault(ModComponents.HACKPAD_BUTTON_0, ""));
                output_hackpad.set(ModComponents.HACKPAD_BUTTON_1, rightInput.getOrDefault(ModComponents.HACKPAD_BUTTON_1, ""));
                output_hackpad.set(ModComponents.HACKPAD_BUTTON_2, rightInput.getOrDefault(ModComponents.HACKPAD_BUTTON_2, ""));
                output_hackpad.set(ModComponents.HACKPAD_BUTTON_3, rightInput.getOrDefault(ModComponents.HACKPAD_BUTTON_3, ""));
                output_hackpad.set(ModComponents.HACKPAD_BUTTON_4, rightInput.getOrDefault(ModComponents.HACKPAD_BUTTON_4, ""));
                output_hackpad.set(ModComponents.HACKPAD_BUTTON_5, rightInput.getOrDefault(ModComponents.HACKPAD_BUTTON_5, ""));
                output_hackpad.set(ModComponents.HACKPAD_BUTTON_6, rightInput.getOrDefault(ModComponents.HACKPAD_BUTTON_6, ""));
                output_hackpad.set(ModComponents.HACKPAD_BUTTON_7, rightInput.getOrDefault(ModComponents.HACKPAD_BUTTON_7, ""));
                output_hackpad.set(ModComponents.HACKPAD_BUTTON_8, rightInput.getOrDefault(ModComponents.HACKPAD_BUTTON_8, ""));
                output_hackpad.set(ModComponents.HACKPAD_BUTTON_9, rightInput.getOrDefault(ModComponents.HACKPAD_BUTTON_9, ""));
                output_hackpad.set(ModComponents.HACKPAD_BUTTON_10, rightInput.getOrDefault(ModComponents.HACKPAD_BUTTON_10, ""));
                output_hackpad.set(ModComponents.HACKPAD_BUTTON_11, rightInput.getOrDefault(ModComponents.HACKPAD_BUTTON_11, ""));
                output_hackpad.set(ModComponents.HACKPAD_BUTTON_12, rightInput.getOrDefault(ModComponents.HACKPAD_BUTTON_12, ""));
                output_hackpad.set(ModComponents.HACKPAD_BUTTON_13, rightInput.getOrDefault(ModComponents.HACKPAD_BUTTON_13, ""));
                output_hackpad.set(ModComponents.HACKPAD_BUTTON_14, rightInput.getOrDefault(ModComponents.HACKPAD_BUTTON_14, ""));
                output_hackpad.set(ModComponents.HACKPAD_BUTTON_15, rightInput.getOrDefault(ModComponents.HACKPAD_BUTTON_15, ""));


                output.setStack(0, output_hackpad);
                this.levelCost.set(1);
                ci.cancel();
            }
        }
    }
}
