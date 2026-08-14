package com.ambergrove;

import com.ambergrove.registry.ModBiomes;
import com.ambergrove.registry.ModBlocks;
import com.ambergrove.registry.ModEntities;
import com.ambergrove.registry.ModItemGroups;
import com.ambergrove.registry.ModItems;
import com.ambergrove.registry.ModParticles;
import com.ambergrove.registry.ModSounds;
import com.ambergrove.registry.ModStructures;
import com.ambergrove.registry.ModWoodTypes;
import com.ambergrove.registry.ModWorldGen;
import com.ambergrove.util.ModConstants;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelValueEvents;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;

public class Ambergrove implements ModInitializer {

    @Override
    public void onInitialize() {
        ModConstants.LOGGER.info("Initializing " + ModConstants.MOD_NAME + "...");

        ModWoodTypes.registerWoodTypes();
        ModEntities.registerEntities();
        ModItemGroups.registerItemGroups();
        ModBlocks.registerModBlocks();
        ModItems.registerModItems();
        ModSounds.registerSounds();
        ModParticles.registerParticles();
        ModStructures.registerStructures();
        ModBiomes.registerBiomes();
        ModWorldGen.registerWorldGen();

        registerStrippableBlocks();
        registerFlammableBlocks();
        registerFuelValues();

        ModConstants.LOGGER.info(ModConstants.MOD_NAME + " initialization complete.");
    }

    private void registerStrippableBlocks() {
        StrippableBlockRegistry.register(ModBlocks.KEHRIBAR_LOG, ModBlocks.STRIPPED_KEHRIBAR_LOG);
        StrippableBlockRegistry.register(ModBlocks.KEHRIBAR_WOOD, ModBlocks.STRIPPED_KEHRIBAR_WOOD);
    }

    private void registerFlammableBlocks() {
        FlammableBlockRegistry registry = FlammableBlockRegistry.getDefaultInstance();
        registry.add(ModBlocks.KEHRIBAR_LOG, 5, 5);
        registry.add(ModBlocks.STRIPPED_KEHRIBAR_LOG, 5, 5);
        registry.add(ModBlocks.KEHRIBAR_WOOD, 5, 5);
        registry.add(ModBlocks.STRIPPED_KEHRIBAR_WOOD, 5, 5);
        registry.add(ModBlocks.KEHRIBAR_PLANKS, 5, 20);
        registry.add(ModBlocks.KEHRIBAR_STAIRS, 5, 20);
        registry.add(ModBlocks.KEHRIBAR_SLAB, 5, 20);
        registry.add(ModBlocks.KEHRIBAR_FENCE, 5, 20);
        registry.add(ModBlocks.KEHRIBAR_FENCE_GATE, 5, 20);
        registry.add(ModBlocks.KEHRIBAR_LEAVES, 30, 60);
        registry.add(ModBlocks.ALTIN_LEAVES, 30, 60);
        registry.add(ModBlocks.KIZIL_LEAVES, 30, 60);

        net.minecraft.world.level.block.ComposterBlock.COMPOSTABLES.put(ModBlocks.KEHRIBAR_LEAVES.asItem(), 0.3F);
        net.minecraft.world.level.block.ComposterBlock.COMPOSTABLES.put(ModBlocks.ALTIN_LEAVES.asItem(), 0.3F);
        net.minecraft.world.level.block.ComposterBlock.COMPOSTABLES.put(ModBlocks.KIZIL_LEAVES.asItem(), 0.3F);
    }

    private void registerFuelValues() {
        FuelValueEvents.BUILD.register((builder, context) -> {
            builder.add(ModBlocks.KEHRIBAR_FENCE, 300);
            builder.add(ModBlocks.KEHRIBAR_FENCE_GATE, 300);
            builder.add(ModItems.KEHRIBAR_BOAT, 300);
            builder.add(ModItems.KEHRIBAR_CHEST_BOAT, 300);
        });
    }
}
