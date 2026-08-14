package com.ambergrove.registry;

import com.ambergrove.util.ModConstants;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;

public class ModBiomes {

    public static final ResourceKey<Biome> AMBER_GROVE = ResourceKey.create(
            Registries.BIOME,
            ModConstants.id("amber_grove")
    );

    public static void registerBiomes() {
        ModConstants.LOGGER.info("Registering ModBiomes for " + ModConstants.MOD_NAME);
    }
}
