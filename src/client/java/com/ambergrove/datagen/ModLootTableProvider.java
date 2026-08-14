package com.ambergrove.datagen;

import com.ambergrove.registry.ModBlocks;
import com.ambergrove.registry.ModItems;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootSubProvider {
    public ModLootTableProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(packOutput, registryLookup);
    }

    @Override
    public void generate() {
        add(ModBlocks.KEHRIBAR_LOG, this::createLogWithResinDrops);
        add(ModBlocks.STRIPPED_KEHRIBAR_LOG, this::createLogWithResinDrops);
        add(ModBlocks.KEHRIBAR_WOOD, this::createLogWithResinDrops);
        add(ModBlocks.STRIPPED_KEHRIBAR_WOOD, this::createLogWithResinDrops);

        dropSelf(ModBlocks.KEHRIBAR_PLANKS);
        dropSelf(ModBlocks.KEHRIBAR_STAIRS);
        add(ModBlocks.KEHRIBAR_SLAB, this::createSlabItemTable);
        dropSelf(ModBlocks.KEHRIBAR_FENCE);
        dropSelf(ModBlocks.KEHRIBAR_FENCE_GATE);
        add(ModBlocks.KEHRIBAR_DOOR, this::createDoorTable);
        dropSelf(ModBlocks.KEHRIBAR_TRAPDOOR);
        dropSelf(ModBlocks.KEHRIBAR_PRESSURE_PLATE);
        dropSelf(ModBlocks.KEHRIBAR_BUTTON);

        add(ModBlocks.KEHRIBAR_LEAVES, block -> createKehribarLeavesDrops(block, ModBlocks.KEHRIBAR_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES));
        add(ModBlocks.ALTIN_LEAVES, block -> createKehribarLeavesDrops(block, ModBlocks.KEHRIBAR_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES));
        add(ModBlocks.KIZIL_LEAVES, block -> createKehribarLeavesDrops(block, ModBlocks.KEHRIBAR_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES));

        dropSelf(ModBlocks.KEHRIBAR_SAPLING);
        dropSelf(ModBlocks.AMBER_MUSHROOM);
        dropSelf(ModBlocks.AMBER_FERN);
        dropSelf(ModBlocks.AMBER_BLOSSOM);
        dropSelf(ModBlocks.FALLEN_AMBER_LEAVES);

        add(ModBlocks.KEHRIBAR_SIGN, block -> createSingleItemTable(ModItems.KEHRIBAR_SIGN));
        add(ModBlocks.KEHRIBAR_WALL_SIGN, block -> createSingleItemTable(ModItems.KEHRIBAR_SIGN));
        add(ModBlocks.KEHRIBAR_HANGING_SIGN, block -> createSingleItemTable(ModItems.KEHRIBAR_HANGING_SIGN));
        add(ModBlocks.KEHRIBAR_WALL_HANGING_SIGN, block -> createSingleItemTable(ModItems.KEHRIBAR_HANGING_SIGN));
    }

    protected LootTable.Builder createLogWithResinDrops(Block logBlock) {
        Holder<Enchantment> fortune = registries.lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE);
        return createSingleItemTable(logBlock)
                .withPool(
                        LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ModItems.AMBER_RESIN)
                                        .when(BonusLevelTableCondition.bonusLevelFlatChance(fortune, 0.08F, 0.12F, 0.16F, 0.20F)))
                );
    }

    protected LootTable.Builder createKehribarLeavesDrops(Block leafBlock, Block saplingBlock, float... saplingChances) {
        Holder<Enchantment> fortune = registries.lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE);
        return createLeavesDrops(leafBlock, saplingBlock, saplingChances)
                .withPool(
                        LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .when(doesNotHaveShearsOrSilkTouch())
                                .add(LootItem.lootTableItem(ModItems.AMBER_RESIN)
                                        .when(BonusLevelTableCondition.bonusLevelFlatChance(fortune, 0.03F, 0.05F, 0.08F, 0.12F)))
                );
    }
}
