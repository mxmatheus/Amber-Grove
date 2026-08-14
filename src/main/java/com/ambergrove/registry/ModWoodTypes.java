package com.ambergrove.registry;

import com.ambergrove.util.ModConstants;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModWoodTypes {

    public static final BlockSetType KEHRIBAR_BLOCK_SET_TYPE = new BlockSetType(ModConstants.id("kehribar").toString());

    public static final WoodType KEHRIBAR_WOOD_TYPE = new WoodType(ModConstants.id("kehribar").toString(), KEHRIBAR_BLOCK_SET_TYPE);

    public static void registerWoodTypes() {
        ModConstants.LOGGER.info("Registering ModWoodTypes for " + ModConstants.MOD_NAME);
    }
}
