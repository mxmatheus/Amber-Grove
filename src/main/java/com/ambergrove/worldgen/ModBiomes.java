package com.ambergrove.worldgen;

import com.ambergrove.util.ModConstants;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.attribute.EnvironmentAttributes;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class ModBiomes {

    public static final ResourceKey<Biome> AMBER_GROVE = ResourceKey.create(Registries.BIOME, ModConstants.id("amber_grove"));

    public static void bootstrap(BootstrapContext<Biome> context) {
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        HolderGetter<ConfiguredWorldCarver<?>> worldCarvers = context.lookup(Registries.CONFIGURED_CARVER);

        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);

        // Vanilla base features
        BiomeDefaultFeatures.addDefaultCarversAndLakes(generationSettings);
        BiomeDefaultFeatures.addDefaultCrystalFormations(generationSettings);
        BiomeDefaultFeatures.addDefaultMonsterRoom(generationSettings);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(generationSettings);
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addDefaultFlowers(generationSettings);
        BiomeDefaultFeatures.addDefaultGrass(generationSettings);

        // Amber Grove vegetation & stone features
        generationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.KEHRIBAR_TREE_PLACED);
        generationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.FALLEN_KEHRIBAR_LOG_PLACED);
        generationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.HOLLOW_KEHRIBAR_TREE_PLACED);
        generationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.AMBER_MUSHROOM_PLACED);
        generationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.AMBER_FERN_PLACED);
        generationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.AMBER_BLOSSOM_PLACED);
        generationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.FALLEN_AMBER_LEAVES_PLACED);
        generationSettings.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.SMALL_STONE_CLUSTER_PLACED);
        generationSettings.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.COARSE_DIRT_PATCH_PLACED);
        generationSettings.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.MOSS_PATCH_PLACED);

        MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.farmAnimals(mobSpawnSettings);
        BiomeDefaultFeatures.commonSpawns(mobSpawnSettings);

        BiomeSpecialEffects specialEffects = new BiomeSpecialEffects.Builder()
                .waterColor(0xdf9c36)
                .foliageColorOverride(0xd97a1e)
                .dryFoliageColorOverride(0xb55e12)
                .grassColorOverride(0xd88a28)
                .build();

        Biome biome = new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .temperature(0.7F)
                .downfall(0.5F)
                .specialEffects(specialEffects)
                .setAttribute(EnvironmentAttributes.FOG_COLOR, 0xe69d45)
                .setAttribute(EnvironmentAttributes.SKY_COLOR, 0xd98638)
                .setAttribute(EnvironmentAttributes.WATER_FOG_COLOR, 0x995c17)
                .mobSpawnSettings(mobSpawnSettings.build())
                .generationSettings(generationSettings.build())
                .build();

        context.register(AMBER_GROVE, biome);
    }

    public static void registerBiomes() {
        ModConstants.LOGGER.info("Registering ModBiomes for " + ModConstants.MOD_NAME);
    }
}
