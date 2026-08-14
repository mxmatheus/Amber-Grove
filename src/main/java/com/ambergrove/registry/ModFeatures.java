package com.ambergrove.registry;

import com.ambergrove.util.ModConstants;
import com.ambergrove.worldgen.feature.FallenKehribarLogFeature;
import com.ambergrove.worldgen.feature.HollowKehribarTreeFeature;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class ModFeatures {

    public static final Feature<NoneFeatureConfiguration> FALLEN_KEHRIBAR_LOG = Registry.register(
            BuiltInRegistries.FEATURE,
            ModConstants.id("fallen_kehribar_log"),
            new FallenKehribarLogFeature(NoneFeatureConfiguration.CODEC)
    );

    public static final Feature<NoneFeatureConfiguration> HOLLOW_KEHRIBAR_TREE = Registry.register(
            BuiltInRegistries.FEATURE,
            ModConstants.id("hollow_kehribar_tree"),
            new HollowKehribarTreeFeature(NoneFeatureConfiguration.CODEC)
    );

    public static void registerFeatures() {
        ModConstants.LOGGER.info("Registering ModFeatures for " + ModConstants.MOD_NAME);
    }
}
