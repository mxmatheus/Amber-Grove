package com.ambergrove.client;

import com.ambergrove.datagen.ModBlockTagProvider;
import com.ambergrove.datagen.ModItemTagProvider;
import com.ambergrove.datagen.ModLanguageProvider;
import com.ambergrove.datagen.ModLootTableProvider;
import com.ambergrove.datagen.ModModelProvider;
import com.ambergrove.datagen.ModRecipeProvider;
import com.ambergrove.datagen.ModWorldGenProvider;
import com.ambergrove.worldgen.ModBiomes;
import com.ambergrove.worldgen.ModConfiguredFeatures;
import com.ambergrove.worldgen.ModPlacedFeatures;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

public class AmbergroveDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ModLanguageProvider::new);
        pack.addProvider(ModModelProvider::new);
        pack.addProvider(ModRecipeProvider::new);
        pack.addProvider(ModLootTableProvider::new);
        pack.addProvider(ModWorldGenProvider::new);
        ModBlockTagProvider blockTagProvider = pack.addProvider(ModBlockTagProvider::new);
        pack.addProvider((output, registries) -> new ModItemTagProvider(output, registries, blockTagProvider));
    }

    @Override
    public void buildRegistry(RegistrySetBuilder registryBuilder) {
        registryBuilder.add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
        registryBuilder.add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap);
        registryBuilder.add(Registries.BIOME, ModBiomes::bootstrap);
    }
}
