package org.kavyansh.hackcraft1.hackcraft.Hackcraft.item;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.kavyansh.hackcraft1.hackcraft.Hackcraft.Main;

import java.util.Objects;

public class HackpadItem extends Item {
    public HackpadItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        if (world.isClient()) {
            MinecraftClient.getInstance().setScreen(
                new HackpadGUI(Text.empty(), stack)
            );
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }
}
