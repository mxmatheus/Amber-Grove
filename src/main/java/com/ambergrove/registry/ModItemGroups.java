package com.ambergrove.registry;

import com.ambergrove.util.ModConstants;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ModItemGroups {

    public static final CreativeModeTab AMBER_GROVE_TAB = Registry.register(
            BuiltInRegistries.CREATIVE_MODE_TAB,
            ModConstants.id("amber_grove_tab"),
            FabricCreativeModeTab.builder()
                    .icon(() -> new ItemStack(Items.OAK_LOG))
                    .title(Component.translatable("itemGroup.ambergrove.amber_grove_tab"))
                    .displayItems((displayContext, entries) -> {
                        // Items will be added here in future phases
                    })
                    .build()
    );

    public static void registerItemGroups() {
        ModConstants.LOGGER.info("Registering ModItemGroups for " + ModConstants.MOD_NAME);
    }
}
