package org.kavyansh.hackcraft1.hackcraft.Hackcraft.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import org.kavyansh.hackcraft1.hackcraft.Hackcraft.Main;

public class ModItems {
    public static final Item HACKPAD = registerItem("hackpad", new Item(
            new Item.Settings()
                    .translationKey("item."+Main.MOD_ID+".hackpad")
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Main.MOD_ID, "hackpad")))
    ));
    public static final Item HACKPAD_MCU = registerItem("hackpad_mcu", new Item(
            new Item.Settings()
                    .translationKey("item."+Main.MOD_ID+".hackpad_mcu")
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Main.MOD_ID, "hackpad_mcu")))
    ));
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Main.MOD_ID, name), item);
    }


    public static void registerModItems() {
        Main.LOGGER.info("Registering mod items for " + Main.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
           entries.add(HACKPAD);
           entries.add(HACKPAD_MCU);
        });
    }
}
