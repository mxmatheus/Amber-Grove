package com.ambergrove.registry;

import com.ambergrove.util.ModConstants;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModItemGroups {

    public static final CreativeModeTab AMBER_GROVE_TAB = Registry.register(
            BuiltInRegistries.CREATIVE_MODE_TAB,
            ModConstants.id("amber_grove_tab"),
            FabricCreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.KEHRIBAR_LOG))
                    .title(Component.translatable("itemGroup.ambergrove.amber_grove_tab"))
                    .displayItems((displayContext, entries) -> {
                        entries.accept(ModBlocks.KEHRIBAR_LOG);
                        entries.accept(ModBlocks.STRIPPED_KEHRIBAR_LOG);
                        entries.accept(ModBlocks.KEHRIBAR_WOOD);
                        entries.accept(ModBlocks.STRIPPED_KEHRIBAR_WOOD);
                        entries.accept(ModBlocks.KEHRIBAR_LEAVES);
                        entries.accept(ModBlocks.ALTIN_LEAVES);
                        entries.accept(ModBlocks.KIZIL_LEAVES);
                        entries.accept(ModBlocks.KEHRIBAR_SAPLING);
                        entries.accept(ModBlocks.KEHRIBAR_PLANKS);
                        entries.accept(ModBlocks.KEHRIBAR_STAIRS);
                        entries.accept(ModBlocks.KEHRIBAR_SLAB);
                        entries.accept(ModBlocks.KEHRIBAR_FENCE);
                        entries.accept(ModBlocks.KEHRIBAR_FENCE_GATE);
                        entries.accept(ModBlocks.KEHRIBAR_DOOR);
                        entries.accept(ModBlocks.KEHRIBAR_TRAPDOOR);
                        entries.accept(ModBlocks.KEHRIBAR_PRESSURE_PLATE);
                        entries.accept(ModBlocks.KEHRIBAR_BUTTON);
                        entries.accept(ModItems.KEHRIBAR_SIGN);
                        entries.accept(ModItems.KEHRIBAR_HANGING_SIGN);
                        entries.accept(ModItems.KEHRIBAR_BOAT);
                        entries.accept(ModItems.KEHRIBAR_CHEST_BOAT);
                    })
                    .build()
    );

    public static void registerItemGroups() {
        ModConstants.LOGGER.info("Registering ModItemGroups for " + ModConstants.MOD_NAME);
    }
}
