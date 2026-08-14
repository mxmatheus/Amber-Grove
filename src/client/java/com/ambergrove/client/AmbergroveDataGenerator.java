package com.ambergrove.client;

import com.ambergrove.datagen.ModBlockTagProvider;
import com.ambergrove.datagen.ModItemTagProvider;
import com.ambergrove.datagen.ModLanguageProvider;
import com.ambergrove.datagen.ModLootTableProvider;
import com.ambergrove.datagen.ModModelProvider;
import com.ambergrove.datagen.ModRecipeProvider;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class AmbergroveDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ModLanguageProvider::new);
        pack.addProvider(ModModelProvider::new);
        pack.addProvider(ModRecipeProvider::new);
        pack.addProvider(ModLootTableProvider::new);
        ModBlockTagProvider blockTagProvider = pack.addProvider(ModBlockTagProvider::new);
        pack.addProvider((output, registries) -> new ModItemTagProvider(output, registries, blockTagProvider));
    }
}
