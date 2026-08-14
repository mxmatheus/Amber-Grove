package com.ambergrove.client;

import com.ambergrove.util.ModConstants;

import net.fabricmc.api.ClientModInitializer;

public class AmbergroveClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModConstants.LOGGER.info("Initializing " + ModConstants.MOD_NAME + " Client...");
    }
}