package com.ambergrove.registry;

import com.ambergrove.util.ModConstants;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.level.block.UntintedParticleLeavesBlock;

public class ModBlocks {

    private static BlockBehaviour.Properties props(String name, Block base) {
        return BlockBehaviour.Properties.ofLegacyCopy(base).setId(ResourceKey.create(Registries.BLOCK, ModConstants.id(name)));
    }

    public static final Block KEHRIBAR_LOG = registerBlock("kehribar_log",
            new RotatedPillarBlock(props("kehribar_log", Blocks.OAK_LOG)));

    public static final Block STRIPPED_KEHRIBAR_LOG = registerBlock("stripped_kehribar_log",
            new RotatedPillarBlock(props("stripped_kehribar_log", Blocks.STRIPPED_OAK_LOG)));

    public static final Block KEHRIBAR_WOOD = registerBlock("kehribar_wood",
            new RotatedPillarBlock(props("kehribar_wood", Blocks.OAK_WOOD)));

    public static final Block STRIPPED_KEHRIBAR_WOOD = registerBlock("stripped_kehribar_wood",
            new RotatedPillarBlock(props("stripped_kehribar_wood", Blocks.STRIPPED_OAK_WOOD)));

    public static final Block KEHRIBAR_PLANKS = registerBlock("kehribar_planks",
            new Block(props("kehribar_planks", Blocks.OAK_PLANKS)));

    public static final Block KEHRIBAR_STAIRS = registerBlock("kehribar_stairs",
            new StairBlock(KEHRIBAR_PLANKS.defaultBlockState(), props("kehribar_stairs", Blocks.OAK_STAIRS)) {});

    public static final Block KEHRIBAR_SLAB = registerBlock("kehribar_slab",
            new SlabBlock(props("kehribar_slab", Blocks.OAK_SLAB)));

    public static final Block KEHRIBAR_FENCE = registerBlock("kehribar_fence",
            new FenceBlock(props("kehribar_fence", Blocks.OAK_FENCE)));

    public static final Block KEHRIBAR_FENCE_GATE = registerBlock("kehribar_fence_gate",
            new FenceGateBlock(ModWoodTypes.KEHRIBAR_WOOD_TYPE, props("kehribar_fence_gate", Blocks.OAK_FENCE_GATE)));

    public static final Block KEHRIBAR_DOOR = registerBlock("kehribar_door",
            new DoorBlock(ModWoodTypes.KEHRIBAR_BLOCK_SET_TYPE, props("kehribar_door", Blocks.OAK_DOOR)) {});

    public static final Block KEHRIBAR_TRAPDOOR = registerBlock("kehribar_trapdoor",
            new TrapDoorBlock(ModWoodTypes.KEHRIBAR_BLOCK_SET_TYPE, props("kehribar_trapdoor", Blocks.OAK_TRAPDOOR)) {});

    public static final Block KEHRIBAR_PRESSURE_PLATE = registerBlock("kehribar_pressure_plate",
            new PressurePlateBlock(ModWoodTypes.KEHRIBAR_BLOCK_SET_TYPE, props("kehribar_pressure_plate", Blocks.OAK_PRESSURE_PLATE)) {});

    public static final Block KEHRIBAR_BUTTON = registerBlock("kehribar_button",
            new ButtonBlock(ModWoodTypes.KEHRIBAR_BLOCK_SET_TYPE, 30, props("kehribar_button", Blocks.OAK_BUTTON)) {});

    public static final Block KEHRIBAR_SIGN = registerBlockWithoutItem("kehribar_sign",
            new StandingSignBlock(ModWoodTypes.KEHRIBAR_WOOD_TYPE, props("kehribar_sign", Blocks.OAK_SIGN)));

    public static final Block KEHRIBAR_WALL_SIGN = registerBlockWithoutItem("kehribar_wall_sign",
            new WallSignBlock(ModWoodTypes.KEHRIBAR_WOOD_TYPE, props("kehribar_wall_sign", Blocks.OAK_WALL_SIGN)));

    public static final Block KEHRIBAR_HANGING_SIGN = registerBlockWithoutItem("kehribar_hanging_sign",
            new CeilingHangingSignBlock(ModWoodTypes.KEHRIBAR_WOOD_TYPE, props("kehribar_hanging_sign", Blocks.OAK_HANGING_SIGN)));

    public static final Block KEHRIBAR_LEAVES = registerBlock("kehribar_leaves",
            new com.ambergrove.block.AmberLeavesBlock(ParticleTypes.FALLING_HONEY, props("kehribar_leaves", Blocks.OAK_LEAVES)));

    public static final Block ALTIN_LEAVES = registerBlock("altin_leaves",
            new com.ambergrove.block.AmberLeavesBlock(ParticleTypes.FALLING_HONEY, props("altin_leaves", Blocks.OAK_LEAVES)));

    public static final Block KIZIL_LEAVES = registerBlock("kizil_leaves",
            new com.ambergrove.block.AmberLeavesBlock(ParticleTypes.FALLING_HONEY, props("kizil_leaves", Blocks.OAK_LEAVES)));

    public static final Block KEHRIBAR_SAPLING = registerBlock("kehribar_sapling",
            new net.minecraft.world.level.block.SaplingBlock(ModTreeGrowers.KEHRIBAR, props("kehribar_sapling", Blocks.OAK_SAPLING)));

    public static final Block AMBER_MUSHROOM = registerBlock("amber_mushroom",
            new com.ambergrove.block.AmberMushroomBlock(props("amber_mushroom", Blocks.RED_MUSHROOM)));

    public static final Block AMBER_FERN = registerBlock("amber_fern",
            new com.ambergrove.block.AmberFernBlock(props("amber_fern", Blocks.FERN)));

    public static final Block AMBER_BLOSSOM = registerBlock("amber_blossom",
            new com.ambergrove.block.AmberFernBlock(props("amber_blossom", Blocks.POPPY)));

    public static final Block FALLEN_AMBER_LEAVES = registerBlock("fallen_amber_leaves",
            new com.ambergrove.block.FallenAmberLeavesBlock(props("fallen_amber_leaves", Blocks.MOSS_CARPET).noOcclusion()));

    public static final Block AMBER_LANTERN = registerBlock("amber_lantern",
            new net.minecraft.world.level.block.LanternBlock(props("amber_lantern", Blocks.LANTERN).sound(net.minecraft.world.level.block.SoundType.LANTERN).strength(1.5F, 6.0F).lightLevel(state -> 15)));

    public static final Block AMBER_BLOCK = registerBlock("amber_block",
            new Block(props("amber_block", Blocks.GLASS).sound(net.minecraft.world.level.block.SoundType.AMETHYST).strength(2.0F, 6.0F).lightLevel(state -> 7)));

    public static final Block POLISHED_AMBER_BLOCK = registerBlock("polished_amber_block",
            new Block(props("polished_amber_block", Blocks.GLASS).sound(net.minecraft.world.level.block.SoundType.AMETHYST).strength(2.0F, 6.0F)));

    public static final Block AMBER_TILE = registerBlock("amber_tile",
            new Block(props("amber_tile", Blocks.GLASS).sound(net.minecraft.world.level.block.SoundType.AMETHYST).strength(2.0F, 6.0F)));

    public static final Block KEHRIBAR_WALL_HANGING_SIGN = registerBlockWithoutItem("kehribar_wall_hanging_sign",
            new WallHangingSignBlock(ModWoodTypes.KEHRIBAR_WOOD_TYPE, props("kehribar_wall_hanging_sign", Blocks.OAK_WALL_HANGING_SIGN)));

    private static Block registerBlock(String name, Block block) {
        return registerBlockWithoutItem(name, block);
    }

    public static Block registerBlockWithoutItem(String name, Block block) {
        ResourceKey<Block> key = ResourceKey.create(Registries.BLOCK, ModConstants.id(name));
        return Registry.register(BuiltInRegistries.BLOCK, key, block);
    }

    public static void registerModBlocks() {
        ModConstants.LOGGER.info("Registering ModBlocks for " + ModConstants.MOD_NAME);
    }
}
