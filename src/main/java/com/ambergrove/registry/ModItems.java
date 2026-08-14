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

    public static final Item KEHRIBAR_SIGN = registerItem("kehribar_sign",
            new SignItem(ModBlocks.KEHRIBAR_SIGN, ModBlocks.KEHRIBAR_WALL_SIGN, props("kehribar_sign").stacksTo(16)));

    public static final Item KEHRIBAR_HANGING_SIGN = registerItem("kehribar_hanging_sign",
            new HangingSignItem(ModBlocks.KEHRIBAR_HANGING_SIGN, ModBlocks.KEHRIBAR_WALL_HANGING_SIGN, props("kehribar_hanging_sign").stacksTo(16)));

    public static final Item KEHRIBAR_BOAT = registerItem("kehribar_boat",
            new BoatItem(ModEntities.KEHRIBAR_BOAT, props("kehribar_boat").stacksTo(1)));

    public static final Item KEHRIBAR_CHEST_BOAT = registerItem("kehribar_chest_boat",
            new BoatItem(ModEntities.KEHRIBAR_CHEST_BOAT, props("kehribar_chest_boat").stacksTo(1)));

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
    }
}
