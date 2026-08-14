package com.ambergrove.worldgen.feature;

import com.ambergrove.registry.ModBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class FallenKehribarLogFeature extends Feature<NoneFeatureConfiguration> {

    public FallenKehribarLogFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel level = context.level();
        BlockPos pos = context.origin();
        RandomSource random = context.random();

        if (!level.getBlockState(pos.below()).isSolid()) {
            return false;
        }

        Direction.Axis axis = random.nextBoolean() ? Direction.Axis.X : Direction.Axis.Z;
        int length = 4 + random.nextInt(3);
        BlockState logState = ModBlocks.KEHRIBAR_LOG.defaultBlockState().setValue(RotatedPillarBlock.AXIS, axis);

        for (int i = 0; i < length; i++) {
            BlockPos currentPos = axis == Direction.Axis.X ? pos.east(i) : pos.north(i);
            if (level.getBlockState(currentPos).canBeReplaced() && level.getBlockState(currentPos.below()).isSolid()) {
                level.setBlock(currentPos, logState, 3);

                if (random.nextFloat() < 0.3F) {
                    BlockPos topPos = currentPos.above();
                    if (level.getBlockState(topPos).canBeReplaced()) {
                        level.setBlock(topPos, ModBlocks.KEHRIBAR_LEAVES.defaultBlockState(), 3);
                    }
                }
            }
        }
        return true;
    }
}
