package com.ambergrove.registry;

import com.ambergrove.util.ModConstants;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.BoatItem;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.level.block.Block;

public class ModItems {

    private static Item.Properties props(String name) {
        return new Item.Properties().setId(ResourceKey.create(Registries.ITEM, ModConstants.id(name)));
    }

    public static final Item AMBER_RESIN = registerItem("amber_resin",
            new Item(props("amber_resin")));

    public static final Item KEHRIBAR_BOAT = registerItem("kehribar_boat",
            new BoatItem(ModEntities.KEHRIBAR_BOAT, props("kehribar_boat").stacksTo(1)));

    public static final Item KEHRIBAR_CHEST_BOAT = registerItem("kehribar_chest_boat",
            new BoatItem(ModEntities.KEHRIBAR_CHEST_BOAT, props("kehribar_chest_boat").stacksTo(1)));

    public static Item KEHRIBAR_SIGN;
    public static Item KEHRIBAR_HANGING_SIGN;

    public static BlockItem registerBlockItem(String name, Block block) {
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, ModConstants.id(name));
        return Registry.register(BuiltInRegistries.ITEM, key,
                new BlockItem(block, new Item.Properties().setId(key)));
    }

    public static Item registerItem(String name, Item item) {
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, ModConstants.id(name));
        return Registry.register(BuiltInRegistries.ITEM, key, item);
    }

    public static void registerModItems() {
        ModConstants.LOGGER.info("Registering ModItems for " + ModConstants.MOD_NAME);

        registerBlockItem("kehribar_log", ModBlocks.KEHRIBAR_LOG);
        registerBlockItem("stripped_kehribar_log", ModBlocks.STRIPPED_KEHRIBAR_LOG);
        registerBlockItem("kehribar_wood", ModBlocks.KEHRIBAR_WOOD);
        registerBlockItem("stripped_kehribar_wood", ModBlocks.STRIPPED_KEHRIBAR_WOOD);
        registerBlockItem("kehribar_planks", ModBlocks.KEHRIBAR_PLANKS);
        registerBlockItem("kehribar_stairs", ModBlocks.KEHRIBAR_STAIRS);
        registerBlockItem("kehribar_slab", ModBlocks.KEHRIBAR_SLAB);
        registerBlockItem("kehribar_fence", ModBlocks.KEHRIBAR_FENCE);
        registerBlockItem("kehribar_fence_gate", ModBlocks.KEHRIBAR_FENCE_GATE);
        registerBlockItem("kehribar_door", ModBlocks.KEHRIBAR_DOOR);
        registerBlockItem("kehribar_trapdoor", ModBlocks.KEHRIBAR_TRAPDOOR);
        registerBlockItem("kehribar_pressure_plate", ModBlocks.KEHRIBAR_PRESSURE_PLATE);
        registerBlockItem("kehribar_button", ModBlocks.KEHRIBAR_BUTTON);
        registerBlockItem("kehribar_sapling", ModBlocks.KEHRIBAR_SAPLING);
        registerBlockItem("kehribar_leaves", ModBlocks.KEHRIBAR_LEAVES);
        registerBlockItem("altin_leaves", ModBlocks.ALTIN_LEAVES);
        registerBlockItem("kizil_leaves", ModBlocks.KIZIL_LEAVES);
        registerBlockItem("amber_mushroom", ModBlocks.AMBER_MUSHROOM);
        registerBlockItem("amber_fern", ModBlocks.AMBER_FERN);
        registerBlockItem("amber_blossom", ModBlocks.AMBER_BLOSSOM);
        registerBlockItem("fallen_amber_leaves", ModBlocks.FALLEN_AMBER_LEAVES);
        registerBlockItem("amber_lantern", ModBlocks.AMBER_LANTERN);
        registerBlockItem("amber_block", ModBlocks.AMBER_BLOCK);
        registerBlockItem("polished_amber_block", ModBlocks.POLISHED_AMBER_BLOCK);
        registerBlockItem("amber_tile", ModBlocks.AMBER_TILE);

        KEHRIBAR_SIGN = registerItem("kehribar_sign",
                new SignItem(ModBlocks.KEHRIBAR_SIGN, ModBlocks.KEHRIBAR_WALL_SIGN, props("kehribar_sign").stacksTo(16)));
        KEHRIBAR_HANGING_SIGN = registerItem("kehribar_hanging_sign",
                new HangingSignItem(ModBlocks.KEHRIBAR_HANGING_SIGN, ModBlocks.KEHRIBAR_WALL_HANGING_SIGN, props("kehribar_hanging_sign").stacksTo(16)));
    }
}
