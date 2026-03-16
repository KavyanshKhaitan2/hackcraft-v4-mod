package org.kavyansh.hackcraft1.hackcraft.Hackcraft.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.kavyansh.hackcraft1.hackcraft.Hackcraft.Main;

public class ModItems {
    public static final Item HACKPAD = registerItem("hackpad", new HackpadItem(
            new Item.Settings()
                    .translationKey("item."+Main.MOD_ID+".hackpad")
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Main.MOD_ID, "hackpad")))
                    .maxCount(1)
    ));
    public static final Item HACKPAD_MCU = registerItem("hackpad_mcu", new Item(
            new Item.Settings()
                    .translationKey("item."+Main.MOD_ID+".hackpad_mcu")
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Main.MOD_ID, "hackpad_mcu")))
                    .maxCount(1)
    ));
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Main.MOD_ID, name), item);
    }


    public static void registerModItems() {
        Main.LOGGER.info("Registering mod items for " + Main.MOD_ID);

//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
//           entries.add(HACKPAD);
//           entries.add(HACKPAD_MCU);
//        });
        Registry.register(Registries.ITEM_GROUP, CUSTOM_CREATIVE_TAB_KEY, CUSTOM_CREATIVE_TAB);

    }

    public static final RegistryKey<ItemGroup> CUSTOM_CREATIVE_TAB_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(Main.MOD_ID, "creative_tab"));
    public static final ItemGroup CUSTOM_CREATIVE_TAB = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.HACKPAD))
            .displayName(Text.translatable("itemGroup.hackcraft"))
            .entries((context, entries) -> {
                entries.add(ModItems.HACKPAD);
                entries.add(ModItems.HACKPAD_MCU);
            })
            .build();
}
