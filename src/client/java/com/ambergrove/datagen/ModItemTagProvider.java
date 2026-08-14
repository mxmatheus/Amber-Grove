package com.ambergrove.datagen;

import com.ambergrove.registry.ModBlocks;
import com.ambergrove.registry.ModItems;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagsProvider.ItemTagsProvider {
    public ModItemTagProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture, BlockTagsProvider blockTagProvider) {
        super(packOutput, registriesFuture, blockTagProvider);
    }

    @Override
    protected void addTags(HolderLookup.Provider registryLookup) {
        tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.KEHRIBAR_LOG.asItem().builtInRegistryHolder().key())
                .add(ModBlocks.STRIPPED_KEHRIBAR_LOG.asItem().builtInRegistryHolder().key())
                .add(ModBlocks.KEHRIBAR_WOOD.asItem().builtInRegistryHolder().key())
                .add(ModBlocks.STRIPPED_KEHRIBAR_WOOD.asItem().builtInRegistryHolder().key());

        tag(ItemTags.PLANKS)
                .add(ModBlocks.KEHRIBAR_PLANKS.asItem().builtInRegistryHolder().key());

        tag(ItemTags.BOATS)
                .add(ModItems.KEHRIBAR_BOAT.builtInRegistryHolder().key())
                .add(ModItems.KEHRIBAR_CHEST_BOAT.builtInRegistryHolder().key());

        tag(ItemTags.SIGNS)
                .add(ModItems.KEHRIBAR_SIGN.builtInRegistryHolder().key());

        tag(ItemTags.HANGING_SIGNS)
                .add(ModItems.KEHRIBAR_HANGING_SIGN.builtInRegistryHolder().key());

        tag(ItemTags.LEAVES)
                .add(ModBlocks.KEHRIBAR_LEAVES.asItem().builtInRegistryHolder().key())
                .add(ModBlocks.ALTIN_LEAVES.asItem().builtInRegistryHolder().key())
                .add(ModBlocks.KIZIL_LEAVES.asItem().builtInRegistryHolder().key());

        tag(ItemTags.SAPLINGS)
                .add(ModBlocks.KEHRIBAR_SAPLING.asItem().builtInRegistryHolder().key());
    }
}
