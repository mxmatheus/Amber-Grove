package com.ambergrove.client;

import com.ambergrove.registry.ModEntities;
import com.ambergrove.util.ModConstants;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.BoatRenderer;

public class AmbergroveClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModConstants.LOGGER.info("Initializing " + ModConstants.MOD_NAME + " Client...");

        EntityRendererRegistry.register(ModEntities.KEHRIBAR_BOAT, context -> new BoatRenderer(context, ModelLayers.OAK_BOAT));
        EntityRendererRegistry.register(ModEntities.KEHRIBAR_CHEST_BOAT, context -> new BoatRenderer(context, ModelLayers.OAK_CHEST_BOAT));
    }
}