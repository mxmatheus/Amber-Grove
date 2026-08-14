package com.ambergrove.worldgen.feature;

import com.ambergrove.registry.ModBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class HollowKehribarTreeFeature extends Feature<NoneFeatureConfiguration> {

    public HollowKehribarTreeFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel level = context.level();
        BlockPos origin = context.origin();
        RandomSource random = context.random();

        if (!level.getBlockState(origin.below()).isSolid()) {
            return false;
        }

        int height = 10 + random.nextInt(5);
        BlockState logState = ModBlocks.KEHRIBAR_LOG.defaultBlockState();
        BlockState strippedState = ModBlocks.STRIPPED_KEHRIBAR_LOG.defaultBlockState();

        for (int y = 0; y < height; y++) {
            for (int x = -1; x <= 1; x++) {
                for (int z = -1; z <= 1; z++) {
                    if (x == 0 && z == 0) {
                        level.setBlock(origin.offset(x, y, z), Blocks.AIR.defaultBlockState(), 3);
                    } else {
                        BlockPos trunkPos = origin.offset(x, y, z);
                        BlockState stateToPlace = (y > 3 && random.nextFloat() < 0.3F) ? strippedState : logState;
                        level.setBlock(trunkPos, stateToPlace, 3);
                    }
                }
            }
        }

        BlockPos canopyCenter = origin.above(height - 2);
        int radius = 4;
        BlockState[] leafStates = new BlockState[]{
                ModBlocks.KEHRIBAR_LEAVES.defaultBlockState(),
                ModBlocks.ALTIN_LEAVES.defaultBlockState(),
                ModBlocks.KIZIL_LEAVES.defaultBlockState()
        };

        for (int x = -radius; x <= radius; x++) {
            for (int z = -radius; z <= radius; z++) {
                for (int y = -1; y <= 2; y++) {
                    if (x * x + z * z <= radius * radius + random.nextInt(3)) {
                        BlockPos leafPos = canopyCenter.offset(x, y, z);
                        if (level.getBlockState(leafPos).canBeReplaced()) {
                            BlockState leaf = leafStates[random.nextInt(leafStates.length)];
                            level.setBlock(leafPos, leaf, 3);
                        }
                    }
                }
            }
        }

        return true;
    }
}
