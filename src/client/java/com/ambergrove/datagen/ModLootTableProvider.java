package com.ambergrove.datagen;

import com.ambergrove.registry.ModBlocks;
import com.ambergrove.registry.ModItems;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootSubProvider {
    public ModLootTableProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(packOutput, registryLookup);
    }

    @Override
    public void generate() {
        dropSelf(ModBlocks.KEHRIBAR_LOG);
        dropSelf(ModBlocks.STRIPPED_KEHRIBAR_LOG);
        dropSelf(ModBlocks.KEHRIBAR_WOOD);
        dropSelf(ModBlocks.STRIPPED_KEHRIBAR_WOOD);
        dropSelf(ModBlocks.KEHRIBAR_PLANKS);
        dropSelf(ModBlocks.KEHRIBAR_STAIRS);
        add(ModBlocks.KEHRIBAR_SLAB, this::createSlabItemTable);
        dropSelf(ModBlocks.KEHRIBAR_FENCE);
        dropSelf(ModBlocks.KEHRIBAR_FENCE_GATE);
        add(ModBlocks.KEHRIBAR_DOOR, this::createDoorTable);
        dropSelf(ModBlocks.KEHRIBAR_TRAPDOOR);
        dropSelf(ModBlocks.KEHRIBAR_PRESSURE_PLATE);
        dropSelf(ModBlocks.KEHRIBAR_BUTTON);

        add(ModBlocks.KEHRIBAR_LEAVES, block -> createLeavesDrops(block, ModBlocks.KEHRIBAR_LEAVES, NORMAL_LEAVES_SAPLING_CHANCES));
        add(ModBlocks.ALTIN_LEAVES, block -> createLeavesDrops(block, ModBlocks.ALTIN_LEAVES, NORMAL_LEAVES_SAPLING_CHANCES));
        add(ModBlocks.KIZIL_LEAVES, block -> createLeavesDrops(block, ModBlocks.KIZIL_LEAVES, NORMAL_LEAVES_SAPLING_CHANCES));

        add(ModBlocks.KEHRIBAR_SIGN, block -> createSingleItemTable(ModItems.KEHRIBAR_SIGN));
        add(ModBlocks.KEHRIBAR_WALL_SIGN, block -> createSingleItemTable(ModItems.KEHRIBAR_SIGN));
        add(ModBlocks.KEHRIBAR_HANGING_SIGN, block -> createSingleItemTable(ModItems.KEHRIBAR_HANGING_SIGN));
        add(ModBlocks.KEHRIBAR_WALL_HANGING_SIGN, block -> createSingleItemTable(ModItems.KEHRIBAR_HANGING_SIGN));
    }
}
