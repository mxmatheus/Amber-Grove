package com.ambergrove.datagen;

import com.ambergrove.registry.ModBlocks;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagsProvider.BlockTagsProvider {
    public ModBlockTagProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registryLookup) {
        tag(BlockTags.LOGS)
                .add(ModBlocks.KEHRIBAR_LOG.builtInRegistryHolder().key())
                .add(ModBlocks.STRIPPED_KEHRIBAR_LOG.builtInRegistryHolder().key())
                .add(ModBlocks.KEHRIBAR_WOOD.builtInRegistryHolder().key())
                .add(ModBlocks.STRIPPED_KEHRIBAR_WOOD.builtInRegistryHolder().key());

        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.KEHRIBAR_LOG.builtInRegistryHolder().key())
                .add(ModBlocks.STRIPPED_KEHRIBAR_LOG.builtInRegistryHolder().key())
                .add(ModBlocks.KEHRIBAR_WOOD.builtInRegistryHolder().key())
                .add(ModBlocks.STRIPPED_KEHRIBAR_WOOD.builtInRegistryHolder().key())
                .add(ModBlocks.KEHRIBAR_PLANKS.builtInRegistryHolder().key())
                .add(ModBlocks.KEHRIBAR_STAIRS.builtInRegistryHolder().key())
                .add(ModBlocks.KEHRIBAR_SLAB.builtInRegistryHolder().key())
                .add(ModBlocks.KEHRIBAR_FENCE.builtInRegistryHolder().key())
                .add(ModBlocks.KEHRIBAR_FENCE_GATE.builtInRegistryHolder().key())
                .add(ModBlocks.KEHRIBAR_DOOR.builtInRegistryHolder().key())
                .add(ModBlocks.KEHRIBAR_TRAPDOOR.builtInRegistryHolder().key())
                .add(ModBlocks.KEHRIBAR_PRESSURE_PLATE.builtInRegistryHolder().key())
                .add(ModBlocks.KEHRIBAR_BUTTON.builtInRegistryHolder().key())
                .add(ModBlocks.KEHRIBAR_SIGN.builtInRegistryHolder().key())
                .add(ModBlocks.KEHRIBAR_WALL_SIGN.builtInRegistryHolder().key())
                .add(ModBlocks.KEHRIBAR_HANGING_SIGN.builtInRegistryHolder().key())
                .add(ModBlocks.KEHRIBAR_WALL_HANGING_SIGN.builtInRegistryHolder().key());

        tag(BlockTags.PLANKS)
                .add(ModBlocks.KEHRIBAR_PLANKS.builtInRegistryHolder().key());

        tag(BlockTags.WOODEN_STAIRS)
                .add(ModBlocks.KEHRIBAR_STAIRS.builtInRegistryHolder().key());

        tag(BlockTags.WOODEN_SLABS)
                .add(ModBlocks.KEHRIBAR_SLAB.builtInRegistryHolder().key());

        tag(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.KEHRIBAR_FENCE.builtInRegistryHolder().key());

        tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.KEHRIBAR_FENCE_GATE.builtInRegistryHolder().key());

        tag(BlockTags.WOODEN_DOORS)
                .add(ModBlocks.KEHRIBAR_DOOR.builtInRegistryHolder().key());

        tag(BlockTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.KEHRIBAR_TRAPDOOR.builtInRegistryHolder().key());

        tag(BlockTags.WOODEN_BUTTONS)
                .add(ModBlocks.KEHRIBAR_BUTTON.builtInRegistryHolder().key());

        tag(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.KEHRIBAR_PRESSURE_PLATE.builtInRegistryHolder().key());

        tag(BlockTags.STANDING_SIGNS)
                .add(ModBlocks.KEHRIBAR_SIGN.builtInRegistryHolder().key());

        tag(BlockTags.WALL_SIGNS)
                .add(ModBlocks.KEHRIBAR_WALL_SIGN.builtInRegistryHolder().key());

        tag(BlockTags.CEILING_HANGING_SIGNS)
                .add(ModBlocks.KEHRIBAR_HANGING_SIGN.builtInRegistryHolder().key());

        tag(BlockTags.WALL_HANGING_SIGNS)
                .add(ModBlocks.KEHRIBAR_WALL_HANGING_SIGN.builtInRegistryHolder().key());
    }
}
