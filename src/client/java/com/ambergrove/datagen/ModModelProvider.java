package com.ambergrove.datagen;

import com.ambergrove.registry.ModBlocks;
import com.ambergrove.registry.ModItems;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.BlockFamily;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricPackOutput packOutput) {
        super(packOutput);
    }

    public static final BlockFamily KEHRIBAR_FAMILY = new BlockFamily.Builder(ModBlocks.KEHRIBAR_PLANKS)
            .button(ModBlocks.KEHRIBAR_BUTTON)
            .fence(ModBlocks.KEHRIBAR_FENCE)
            .fenceGate(ModBlocks.KEHRIBAR_FENCE_GATE)
            .door(ModBlocks.KEHRIBAR_DOOR)
            .trapdoor(ModBlocks.KEHRIBAR_TRAPDOOR)
            .slab(ModBlocks.KEHRIBAR_SLAB)
            .stairs(ModBlocks.KEHRIBAR_STAIRS)
            .pressurePlate(ModBlocks.KEHRIBAR_PRESSURE_PLATE)
            .getFamily();

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        BlockModelGenerators.WoodProvider wood = blockStateModelGenerator.woodProvider(ModBlocks.KEHRIBAR_LOG);
        wood.logWithHorizontal(ModBlocks.KEHRIBAR_LOG);
        wood.wood(ModBlocks.KEHRIBAR_WOOD);

        BlockModelGenerators.WoodProvider strippedWood = blockStateModelGenerator.woodProvider(ModBlocks.STRIPPED_KEHRIBAR_LOG);
        strippedWood.logWithHorizontal(ModBlocks.STRIPPED_KEHRIBAR_LOG);
        strippedWood.wood(ModBlocks.STRIPPED_KEHRIBAR_WOOD);

        blockStateModelGenerator.family(ModBlocks.KEHRIBAR_PLANKS).generateFor(KEHRIBAR_FAMILY);

        blockStateModelGenerator.createParticleOnlyBlock(ModBlocks.KEHRIBAR_SIGN, ModBlocks.KEHRIBAR_PLANKS);
        blockStateModelGenerator.createParticleOnlyBlock(ModBlocks.KEHRIBAR_WALL_SIGN, ModBlocks.KEHRIBAR_PLANKS);
        blockStateModelGenerator.createParticleOnlyBlock(ModBlocks.KEHRIBAR_HANGING_SIGN, ModBlocks.STRIPPED_KEHRIBAR_LOG);
        blockStateModelGenerator.createParticleOnlyBlock(ModBlocks.KEHRIBAR_WALL_HANGING_SIGN, ModBlocks.STRIPPED_KEHRIBAR_LOG);

        blockStateModelGenerator.createTrivialCube(ModBlocks.KEHRIBAR_LEAVES);
        blockStateModelGenerator.createTrivialCube(ModBlocks.ALTIN_LEAVES);
        blockStateModelGenerator.createTrivialCube(ModBlocks.KIZIL_LEAVES);

        blockStateModelGenerator.createCrossBlockWithDefaultItem(ModBlocks.KEHRIBAR_SAPLING, BlockModelGenerators.PlantType.NOT_TINTED);
        blockStateModelGenerator.createCrossBlockWithDefaultItem(ModBlocks.AMBER_MUSHROOM, BlockModelGenerators.PlantType.NOT_TINTED);
        blockStateModelGenerator.createCrossBlockWithDefaultItem(ModBlocks.AMBER_FERN, BlockModelGenerators.PlantType.NOT_TINTED);
        blockStateModelGenerator.createTrivialCube(ModBlocks.FALLEN_AMBER_LEAVES);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        itemModelGenerator.generateFlatItem(ModItems.KEHRIBAR_SIGN, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.KEHRIBAR_HANGING_SIGN, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.KEHRIBAR_BOAT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.KEHRIBAR_CHEST_BOAT, ModelTemplates.FLAT_ITEM);
    }
}
