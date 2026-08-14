package com.ambergrove.datagen;

import com.ambergrove.registry.ModBlocks;
import com.ambergrove.registry.ModItems;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(packOutput, registryLookup);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registryLookup, RecipeOutput recipeOutput) {
        return new RecipeProvider(registryLookup, recipeOutput) {
            @Override
            public void buildRecipes() {
                planksFromLogs(ModBlocks.KEHRIBAR_PLANKS, ItemTags.LOGS_THAT_BURN, 4);

                woodFromLogs(ModBlocks.KEHRIBAR_WOOD, ModBlocks.KEHRIBAR_LOG);
                woodFromLogs(ModBlocks.STRIPPED_KEHRIBAR_WOOD, ModBlocks.STRIPPED_KEHRIBAR_LOG);

                stairBuilder(ModBlocks.KEHRIBAR_STAIRS, Ingredient.of(ModBlocks.KEHRIBAR_PLANKS))
                        .unlockedBy("has_planks", has(ModBlocks.KEHRIBAR_PLANKS))
                        .save(recipeOutput);

                slabBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.KEHRIBAR_SLAB, Ingredient.of(ModBlocks.KEHRIBAR_PLANKS))
                        .unlockedBy("has_planks", has(ModBlocks.KEHRIBAR_PLANKS))
                        .save(recipeOutput);

                shaped(RecipeCategory.DECORATIONS, ModBlocks.KEHRIBAR_FENCE, 3)
                        .define('#', Items.STICK)
                        .define('W', ModBlocks.KEHRIBAR_PLANKS)
                        .pattern("W#W")
                        .pattern("W#W")
                        .unlockedBy("has_planks", has(ModBlocks.KEHRIBAR_PLANKS))
                        .save(recipeOutput);

                shaped(RecipeCategory.REDSTONE, ModBlocks.KEHRIBAR_FENCE_GATE)
                        .define('#', Items.STICK)
                        .define('W', ModBlocks.KEHRIBAR_PLANKS)
                        .pattern("#W#")
                        .pattern("#W#")
                        .unlockedBy("has_planks", has(ModBlocks.KEHRIBAR_PLANKS))
                        .save(recipeOutput);

                doorBuilder(ModBlocks.KEHRIBAR_DOOR, Ingredient.of(ModBlocks.KEHRIBAR_PLANKS))
                        .unlockedBy("has_planks", has(ModBlocks.KEHRIBAR_PLANKS))
                        .save(recipeOutput);

                trapdoorBuilder(ModBlocks.KEHRIBAR_TRAPDOOR, Ingredient.of(ModBlocks.KEHRIBAR_PLANKS))
                        .unlockedBy("has_planks", has(ModBlocks.KEHRIBAR_PLANKS))
                        .save(recipeOutput);

                pressurePlate(ModBlocks.KEHRIBAR_PRESSURE_PLATE, ModBlocks.KEHRIBAR_PLANKS);

                shapeless(RecipeCategory.REDSTONE, ModBlocks.KEHRIBAR_BUTTON)
                        .requires(ModBlocks.KEHRIBAR_PLANKS)
                        .unlockedBy("has_planks", has(ModBlocks.KEHRIBAR_PLANKS))
                        .save(recipeOutput);

                shaped(RecipeCategory.DECORATIONS, ModItems.KEHRIBAR_SIGN, 3)
                        .define('#', Items.STICK)
                        .define('W', ModBlocks.KEHRIBAR_PLANKS)
                        .pattern("WWW")
                        .pattern("WWW")
                        .pattern(" # ")
                        .unlockedBy("has_planks", has(ModBlocks.KEHRIBAR_PLANKS))
                        .save(recipeOutput);

                hangingSignBuilder(ModItems.KEHRIBAR_HANGING_SIGN, Ingredient.of(ModBlocks.STRIPPED_KEHRIBAR_LOG))
                        .unlockedBy("has_stripped_log", has(ModBlocks.STRIPPED_KEHRIBAR_LOG))
                        .save(recipeOutput);

                woodenBoat(ModItems.KEHRIBAR_BOAT, ModBlocks.KEHRIBAR_PLANKS);
                chestBoat(ModItems.KEHRIBAR_CHEST_BOAT, ModItems.KEHRIBAR_BOAT);

                shaped(RecipeCategory.DECORATIONS, ModBlocks.AMBER_LANTERN, 1)
                        .define('R', ModItems.AMBER_RESIN)
                        .define('T', Items.TORCH)
                        .pattern("RRR")
                        .pattern("RTR")
                        .pattern("RRR")
                        .unlockedBy("has_amber_resin", has(ModItems.AMBER_RESIN))
                        .save(recipeOutput);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AMBER_BLOCK, 1)
                        .define('R', ModItems.AMBER_RESIN)
                        .pattern("RRR")
                        .pattern("RRR")
                        .pattern("RRR")
                        .unlockedBy("has_amber_resin", has(ModItems.AMBER_RESIN))
                        .save(recipeOutput);

                shapeless(RecipeCategory.MISC, ModItems.AMBER_RESIN, 9)
                        .requires(ModBlocks.AMBER_BLOCK)
                        .unlockedBy("has_amber_block", has(ModBlocks.AMBER_BLOCK))
                        .save(recipeOutput, "amber_resin_from_amber_block");

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_AMBER_BLOCK, 4)
                        .define('A', ModBlocks.AMBER_BLOCK)
                        .pattern("AA")
                        .pattern("AA")
                        .unlockedBy("has_amber_block", has(ModBlocks.AMBER_BLOCK))
                        .save(recipeOutput);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AMBER_TILE, 4)
                        .define('P', ModBlocks.POLISHED_AMBER_BLOCK)
                        .pattern("PP")
                        .pattern("PP")
                        .unlockedBy("has_polished_amber_block", has(ModBlocks.POLISHED_AMBER_BLOCK))
                        .save(recipeOutput);
            }
        };
    }

    @Override
    public String getName() {
        return "Amber Grove Recipes";
    }
}
