package com.ambergrove.client;

import com.ambergrove.registry.ModEntities;
import com.ambergrove.registry.ModParticles;
import com.ambergrove.registry.ModSounds;
import com.ambergrove.util.ModConstants;
import com.ambergrove.worldgen.ModBiomes;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.particle.v1.ParticleProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.biome.Biome;

public class AmbergroveClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModConstants.LOGGER.info("Initializing " + ModConstants.MOD_NAME + " Client Ambient Systems...");

        EntityRendererRegistry.register(ModEntities.KEHRIBAR_BOAT, context -> new BoatRenderer(context, ModelLayers.OAK_BOAT));
        EntityRendererRegistry.register(ModEntities.KEHRIBAR_CHEST_BOAT, context -> new BoatRenderer(context, ModelLayers.OAK_CHEST_BOAT));

        ParticleProviderRegistry.getInstance().register(ModParticles.FALLING_AMBER_LEAF, FlameParticle.Provider::new);
        ParticleProviderRegistry.getInstance().register(ModParticles.DRIFTING_AMBER_LEAF, FlameParticle.Provider::new);

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.level != null && client.player != null && !client.isPaused()) {
                BlockPos pos = client.player.blockPosition();
                Holder<Biome> biomeHolder = client.level.getBiome(pos);

                if (biomeHolder.is(ModBiomes.AMBER_GROVE)) {
                    RandomSource random = client.level.getRandom();
                    boolean isDay = (client.level.getGameTime() % 24000L) < 12000L;

                    // 1. Soft wind ambience
                    if (random.nextInt(600) == 0) {
                        client.level.playLocalSound(pos, ModSounds.AMBIENT_WIND, SoundSource.AMBIENT, 0.35F, 0.9F + random.nextFloat() * 0.2F, false);
                    }

                    // 2. Leaf rustle sounds
                    if (random.nextInt(400) == 0) {
                        client.level.playLocalSound(pos, ModSounds.AMBIENT_LEAF_RUSTLE, SoundSource.AMBIENT, 0.3F, 1.0F + random.nextFloat() * 0.2F, false);
                    }

                    // 3. Distant bird ambience (daytime only)
                    if (isDay && random.nextInt(800) == 0) {
                        client.level.playLocalSound(pos, ModSounds.AMBIENT_BIRDS, SoundSource.AMBIENT, 0.25F, 1.2F + random.nextFloat() * 0.3F, false);
                    }

                    // 4. Drifting ambient leaf particles around player in Amber Grove biome
                    if (random.nextInt(3) == 0) {
                        double px = pos.getX() + (random.nextDouble() - 0.5D) * 20.0D;
                        double py = pos.getY() + random.nextDouble() * 6.0D + 1.5D;
                        double pz = pos.getZ() + (random.nextDouble() - 0.5D) * 20.0D;

                        double vx = (random.nextDouble() - 0.5D) * 0.05D;
                        double vy = -0.01D - random.nextDouble() * 0.01D;
                        double vz = (random.nextDouble() - 0.5D) * 0.05D;

                        client.level.addParticle(ModParticles.DRIFTING_AMBER_LEAF, px, py, pz, vx, vy, vz);
                    }
                }
            }
        });
    }
}