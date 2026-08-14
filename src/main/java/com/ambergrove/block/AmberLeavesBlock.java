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
        super(0.1F, properties);
        this.particle = particle;
    }

    @Override
    public MapCodec<AmberLeavesBlock> codec() {
        return CODEC;
    }

    @Override
    protected void spawnFallingLeavesParticle(Level level, BlockPos pos, RandomSource random) {
        if (particle != null && random.nextInt(6) == 0) {
            double x = pos.getX() + random.nextDouble();
            double y = pos.getY() - 0.05D;
            double z = pos.getZ() + random.nextDouble();
            // Floating autumn breeze motion: gentle slow fall + wide horizontal wind drift
            double vx = (random.nextDouble() - 0.5D) * 0.08D;
            double vy = -0.01D - random.nextDouble() * 0.01D;
            double vz = (random.nextDouble() - 0.5D) * 0.08D;
            level.addParticle(particle, x, y, z, vx, vy, vz);
        }
    }
}
