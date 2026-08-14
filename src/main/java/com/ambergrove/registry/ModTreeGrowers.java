package com.ambergrove.registry;

import com.ambergrove.worldgen.ModConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower KEHRIBAR = new TreeGrower(
            "kehribar",
            0.2F,
            Optional.of(ModConfiguredFeatures.KEHRIBAR_TREE_LARGE),
            Optional.empty(),
            Optional.of(ModConfiguredFeatures.KEHRIBAR_TREE),
            Optional.of(ModConfiguredFeatures.KEHRIBAR_TREE_LARGE),
            Optional.empty(),
            Optional.empty()
    );
}
