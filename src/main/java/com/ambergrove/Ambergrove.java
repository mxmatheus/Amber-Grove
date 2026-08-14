package com.ambergrove;

import com.ambergrove.registry.ModBiomes;
import com.ambergrove.registry.ModBlocks;
import com.ambergrove.registry.ModItemGroups;
import com.ambergrove.registry.ModItems;
import com.ambergrove.registry.ModParticles;
import com.ambergrove.registry.ModSounds;
import com.ambergrove.registry.ModStructures;
import com.ambergrove.registry.ModWorldGen;
import com.ambergrove.util.ModConstants;

import net.fabricmc.api.ModInitializer;

public class Ambergrove implements ModInitializer {

    @Override
    public void onInitialize() {
        ModConstants.LOGGER.info("Initializing " + ModConstants.MOD_NAME + " foundation...");

        ModItemGroups.registerItemGroups();
        ModBlocks.registerModBlocks();
        ModItems.registerModItems();
        ModSounds.registerSounds();
        ModParticles.registerParticles();
        ModStructures.registerStructures();
        ModBiomes.registerBiomes();
        ModWorldGen.registerWorldGen();

        ModConstants.LOGGER.info(ModConstants.MOD_NAME + " foundation initialization complete.");
    }
}
