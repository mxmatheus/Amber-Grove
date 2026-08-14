package com.ambergrove.mixin;

import com.ambergrove.worldgen.ModBiomes;
import com.mojang.datafixers.util.Pair;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.OverworldBiomeBuilder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;

@Mixin(OverworldBiomeBuilder.class)
public class OverworldBiomeBuilderMixin {

    @Inject(method = "addInlandBiomes", at = @At("TAIL"))
    private void addAmberGroveBiome(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper, CallbackInfo ci) {
        mapper.accept(Pair.of(
                Climate.parameters(
                        Climate.Parameter.span(0.55F, 0.85F),
                        Climate.Parameter.span(-0.3F, 0.3F),
                        Climate.Parameter.span(0.3F, 1.0F),
                        Climate.Parameter.span(-0.5F, 0.5F),
                        Climate.Parameter.span(0.0F, 0.0F),
                        Climate.Parameter.span(-0.5F, 0.5F),
                        0.0F
                ),
                ModBiomes.AMBER_GROVE
        ));
    }
}
