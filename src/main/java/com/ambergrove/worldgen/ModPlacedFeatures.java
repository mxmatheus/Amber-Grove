package com.ambergrove.worldgen;

import com.ambergrove.registry.ModBlocks;
import com.ambergrove.util.ModConstants;

import net.minecraft.core.HolderGetter;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;

import net.minecraft.resources.ResourceKey;

import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;

public class ModPlacedFeatures {

    public static final ResourceKey<PlacedFeature> KEHRIBAR_TREE_CHECKED = ResourceKey.create(Registries.PLACED_FEATURE, ModConstants.id("kehribar_tree_checked"));
    public static final ResourceKey<PlacedFeature> KEHRIBAR_TREE_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, ModConstants.id("kehribar_tree_placed"));
    public static final ResourceKey<PlacedFeature> FALLEN_KEHRIBAR_LOG_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, ModConstants.id("fallen_kehribar_log_placed"));
    public static final ResourceKey<PlacedFeature> HOLLOW_KEHRIBAR_TREE_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, ModConstants.id("hollow_kehribar_tree_placed"));

    public static final ResourceKey<PlacedFeature> AMBER_MUSHROOM_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, ModConstants.id("amber_mushroom_placed"));
    public static final ResourceKey<PlacedFeature> AMBER_FERN_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, ModConstants.id("amber_fern_placed"));
    public static final ResourceKey<PlacedFeature> FALLEN_AMBER_LEAVES_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, ModConstants.id("fallen_amber_leaves_placed"));
    public static final ResourceKey<PlacedFeature> SMALL_STONE_CLUSTER_PLACED = ResourceKey.create(Registries.PLACED_FEATURE, ModConstants.id("small_stone_cluster_placed"));

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        context.register(
                KEHRIBAR_TREE_CHECKED,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(ModConfiguredFeatures.KEHRIBAR_TREE),
                        List.of(PlacementUtils.filteredByBlockSurvival(ModBlocks.KEHRIBAR_SAPLING))
                )
        );

        context.register(
                KEHRIBAR_TREE_PLACED,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(ModConfiguredFeatures.KEHRIBAR_TREE),
                        VegetationPlacements.treePlacement(PlacementUtils.countExtra(10, 0.1F, 1), ModBlocks.KEHRIBAR_SAPLING)
                )
        );

        context.register(
                FALLEN_KEHRIBAR_LOG_PLACED,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(ModConfiguredFeatures.FALLEN_KEHRIBAR_LOG),
                        VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.2F, 1), ModBlocks.KEHRIBAR_SAPLING)
                )
        );

        context.register(
                HOLLOW_KEHRIBAR_TREE_PLACED,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(ModConfiguredFeatures.HOLLOW_KEHRIBAR_TREE),
                        VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.05F, 1), ModBlocks.KEHRIBAR_SAPLING)
                )
        );

        context.register(
                AMBER_MUSHROOM_PLACED,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(ModConfiguredFeatures.AMBER_MUSHROOM_PATCH),
                        VegetationPlacements.worldSurfaceSquaredWithCount(2)
                )
        );

        context.register(
                AMBER_FERN_PLACED,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(ModConfiguredFeatures.AMBER_FERN_PATCH),
                        VegetationPlacements.worldSurfaceSquaredWithCount(4)
                )
        );

        context.register(
                FALLEN_AMBER_LEAVES_PLACED,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(ModConfiguredFeatures.FALLEN_AMBER_LEAVES_PATCH),
                        VegetationPlacements.worldSurfaceSquaredWithCount(6)
                )
        );

        context.register(
                SMALL_STONE_CLUSTER_PLACED,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(ModConfiguredFeatures.SMALL_STONE_CLUSTER),
                        VegetationPlacements.worldSurfaceSquaredWithCount(1)
                )
        );
    }
}
