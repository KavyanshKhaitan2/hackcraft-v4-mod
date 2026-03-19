package org.kavyansh.hackcraft1.hackcraft.Hackcraft.component;

import com.mojang.serialization.Codec;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.kavyansh.hackcraft1.hackcraft.Hackcraft.Main;

public class ModComponents {
    public static final ComponentType<String> HACKPAD_BUTTON_0 = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(Main.MOD_ID, "hackpad_button0"),
            ComponentType.<String>builder().codec(Codec.STRING).build()
    );

    public static final ComponentType<String> HACKPAD_BUTTON_1 = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(Main.MOD_ID, "hackpad_button1"),
            ComponentType.<String>builder().codec(Codec.STRING).build()
    );

    public static final ComponentType<String> HACKPAD_BUTTON_2 = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(Main.MOD_ID, "hackpad_button2"),
            ComponentType.<String>builder().codec(Codec.STRING).build()
    );

    public static final ComponentType<String> HACKPAD_BUTTON_3 = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(Main.MOD_ID, "hackpad_button3"),
            ComponentType.<String>builder().codec(Codec.STRING).build()
    );

    public static final ComponentType<String> HACKPAD_BUTTON_4 = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(Main.MOD_ID, "hackpad_button4"),
            ComponentType.<String>builder().codec(Codec.STRING).build()
    );

    public static final ComponentType<String> HACKPAD_BUTTON_5 = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(Main.MOD_ID, "hackpad_button5"),
            ComponentType.<String>builder().codec(Codec.STRING).build()
    );

    public static final ComponentType<String> HACKPAD_BUTTON_6 = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(Main.MOD_ID, "hackpad_button6"),
            ComponentType.<String>builder().codec(Codec.STRING).build()
    );

    public static final ComponentType<String> HACKPAD_BUTTON_7 = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(Main.MOD_ID, "hackpad_button7"),
            ComponentType.<String>builder().codec(Codec.STRING).build()
    );

    public static final ComponentType<String> HACKPAD_BUTTON_8 = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(Main.MOD_ID, "hackpad_button8"),
            ComponentType.<String>builder().codec(Codec.STRING).build()
    );

    public static final ComponentType<String> HACKPAD_BUTTON_9 = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(Main.MOD_ID, "hackpad_button9"),
            ComponentType.<String>builder().codec(Codec.STRING).build()
    );

    public static final ComponentType<String> HACKPAD_BUTTON_10 = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(Main.MOD_ID, "hackpad_button10"),
            ComponentType.<String>builder().codec(Codec.STRING).build()
    );

    public static final ComponentType<String> HACKPAD_BUTTON_11 = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(Main.MOD_ID, "hackpad_button11"),
            ComponentType.<String>builder().codec(Codec.STRING).build()
    );

    public static final ComponentType<String> HACKPAD_BUTTON_12 = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(Main.MOD_ID, "hackpad_button12"),
            ComponentType.<String>builder().codec(Codec.STRING).build()
    );

    public static final ComponentType<String> HACKPAD_BUTTON_13 = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(Main.MOD_ID, "hackpad_mcu"),
            ComponentType.<String>builder().codec(Codec.STRING).build()
    );

    public static final ComponentType<String> HACKPAD_BUTTON_14 = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(Main.MOD_ID, "hackpad_button14"),
            ComponentType.<String>builder().codec(Codec.STRING).build()
    );

    public static final ComponentType<String> HACKPAD_BUTTON_15 = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(Main.MOD_ID, "hackpad_button15"),
            ComponentType.<String>builder().codec(Codec.STRING).build()
    );
    public static final ComponentType<String> HACKPAD_NAME = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(Main.MOD_ID, "hackpad_name"),
            ComponentType.<String>builder().codec(Codec.STRING).build()
    );

    public static void initialize() {
        Main.LOGGER.info("Registering {} components", Main.MOD_ID);
    }
}
