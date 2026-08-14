package com.ambergrove.worldgen;

import com.ambergrove.registry.ModBlocks;
import com.ambergrove.registry.ModFeatures;
import com.ambergrove.util.ModConstants;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;

import net.minecraft.util.random.WeightedList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.CherryFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.BendingTrunkPlacer;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> KEHRIBAR_TREE = ResourceKey.create(Registries.CONFIGURED_FEATURE, ModConstants.id("kehribar_tree"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> KEHRIBAR_TREE_LARGE = ResourceKey.create(Registries.CONFIGURED_FEATURE, ModConstants.id("kehribar_tree_large"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> FALLEN_KEHRIBAR_LOG = ResourceKey.create(Registries.CONFIGURED_FEATURE, ModConstants.id("fallen_kehribar_log"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> HOLLOW_KEHRIBAR_TREE = ResourceKey.create(Registries.CONFIGURED_FEATURE, ModConstants.id("hollow_kehribar_tree"));

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        WeightedStateProvider mixedLeafProvider = new WeightedStateProvider(
                new WeightedList.Builder<BlockState>()
                        .add(ModBlocks.KEHRIBAR_LEAVES.defaultBlockState(), 5)
                        .add(ModBlocks.ALTIN_LEAVES.defaultBlockState(), 3)
                        .add(ModBlocks.KIZIL_LEAVES.defaultBlockState(), 2)
        );

        TreeConfiguration normalTreeConfig = new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.KEHRIBAR_LOG),
                new BendingTrunkPlacer(8, 2, 1, 3, UniformInt.of(1, 2)),
                mixedLeafProvider,
                new CherryFoliagePlacer(ConstantInt.of(4), ConstantInt.of(0), ConstantInt.of(5), 0.25F, 0.25F, 0.166F, 0.333F),
                new TwoLayersFeatureSize(1, 0, 1),
                BlockStateProvider.simple(Blocks.DIRT)
        ).build();

        TreeConfiguration largeTreeConfig = new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.KEHRIBAR_LOG),
                new BendingTrunkPlacer(11, 3, 2, 4, UniformInt.of(2, 3)),
                mixedLeafProvider,
                new CherryFoliagePlacer(ConstantInt.of(5), ConstantInt.of(0), ConstantInt.of(6), 0.3F, 0.3F, 0.2F, 0.4F),
                new TwoLayersFeatureSize(2, 0, 2),
                BlockStateProvider.simple(Blocks.DIRT)
        ).build();

        context.register(KEHRIBAR_TREE, new ConfiguredFeature<>(Feature.TREE, normalTreeConfig));
        context.register(KEHRIBAR_TREE_LARGE, new ConfiguredFeature<>(Feature.TREE, largeTreeConfig));
        context.register(FALLEN_KEHRIBAR_LOG, new ConfiguredFeature<>(ModFeatures.FALLEN_KEHRIBAR_LOG, NoneFeatureConfiguration.INSTANCE));
        context.register(HOLLOW_KEHRIBAR_TREE, new ConfiguredFeature<>(ModFeatures.HOLLOW_KEHRIBAR_TREE, NoneFeatureConfiguration.INSTANCE));
    }
}
