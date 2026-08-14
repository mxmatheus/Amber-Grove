package com.ambergrove.registry;

import com.ambergrove.util.ModConstants;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.SimpleParticleType;

public class ModParticles {

    public static final SimpleParticleType FALLING_AMBER_LEAF = registerParticle("falling_amber_leaf", FabricParticleTypes.simple());
    public static final SimpleParticleType DRIFTING_AMBER_LEAF = registerParticle("drifting_amber_leaf", FabricParticleTypes.simple());

    private static SimpleParticleType registerParticle(String name, SimpleParticleType type) {
        return Registry.register(BuiltInRegistries.PARTICLE_TYPE, ModConstants.id(name), type);
    }

    public static void registerParticles() {
        ModConstants.LOGGER.info("Registering ModParticles for " + ModConstants.MOD_NAME);
    }
}
