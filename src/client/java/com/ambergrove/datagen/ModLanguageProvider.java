package com.ambergrove.datagen;

import com.ambergrove.registry.ModBlocks;
import com.ambergrove.registry.ModItems;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class ModLanguageProvider extends FabricLanguageProvider {
    public ModLanguageProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(packOutput, registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider registryLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add("itemGroup.ambergrove.amber_grove_tab", "Amber Grove");
        translationBuilder.add("biome.ambergrove.amber_grove", "Amber Grove");

        translationBuilder.add(ModBlocks.KEHRIBAR_LOG, "Kehribar Log");
        translationBuilder.add(ModBlocks.STRIPPED_KEHRIBAR_LOG, "Stripped Kehribar Log");
        translationBuilder.add(ModBlocks.KEHRIBAR_WOOD, "Kehribar Wood");
        translationBuilder.add(ModBlocks.STRIPPED_KEHRIBAR_WOOD, "Stripped Kehribar Wood");
        translationBuilder.add(ModBlocks.KEHRIBAR_PLANKS, "Kehribar Planks");
        translationBuilder.add(ModBlocks.KEHRIBAR_STAIRS, "Kehribar Stairs");
        translationBuilder.add(ModBlocks.KEHRIBAR_SLAB, "Kehribar Slab");
        translationBuilder.add(ModBlocks.KEHRIBAR_FENCE, "Kehribar Fence");
        translationBuilder.add(ModBlocks.KEHRIBAR_FENCE_GATE, "Kehribar Fence Gate");
        translationBuilder.add(ModBlocks.KEHRIBAR_DOOR, "Kehribar Door");
        translationBuilder.add(ModBlocks.KEHRIBAR_TRAPDOOR, "Kehribar Trapdoor");
        translationBuilder.add(ModBlocks.KEHRIBAR_PRESSURE_PLATE, "Kehribar Pressure Plate");
        translationBuilder.add(ModBlocks.KEHRIBAR_BUTTON, "Kehribar Button");
        translationBuilder.add(ModItems.KEHRIBAR_SIGN, "Kehribar Sign");
        translationBuilder.add(ModItems.KEHRIBAR_HANGING_SIGN, "Kehribar Hanging Sign");
        translationBuilder.add(ModItems.KEHRIBAR_BOAT, "Kehribar Boat");
        translationBuilder.add(ModItems.KEHRIBAR_CHEST_BOAT, "Kehribar Boat with Chest");
    }
}
