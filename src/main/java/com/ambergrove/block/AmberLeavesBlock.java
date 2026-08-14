package com.ambergrove.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LeavesBlock;

public class AmberLeavesBlock extends LeavesBlock {
    public static final MapCodec<AmberLeavesBlock> CODEC = simpleCodec(props -> new AmberLeavesBlock(null, props));
    private final ParticleOptions particle;

    public AmberLeavesBlock(ParticleOptions particle, Properties properties) {
        super(0.3F, properties);
        this.particle = particle;
    }

    @Override
    public MapCodec<AmberLeavesBlock> codec() {
        return CODEC;
    }

    @Override
    protected void spawnFallingLeavesParticle(Level level, BlockPos pos, RandomSource random) {
        if (particle != null) {
            for (int i = 0; i < 3; i++) {
                double x = pos.getX() + random.nextDouble();
                double y = pos.getY() - 0.05D;
                double z = pos.getZ() + random.nextDouble();
                level.addParticle(particle, x, y, z, 0.0D, -0.05D, 0.0D);
            }
        }
    }
}
