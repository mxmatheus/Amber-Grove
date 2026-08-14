package com.ambergrove.registry;

import com.ambergrove.util.ModConstants;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;

public class ModSounds {

    public static final SoundEvent AMBIENT_WIND = registerSound("ambient.wind");
    public static final SoundEvent AMBIENT_LEAF_RUSTLE = registerSound("ambient.leaf_rustle");
    public static final SoundEvent AMBIENT_BIRDS = registerSound("ambient.birds");

    private static SoundEvent registerSound(String name) {
        Identifier id = ModConstants.id(name);
        return Registry.register(BuiltInRegistries.SOUND_EVENT, id, SoundEvent.createVariableRangeEvent(id));
    }

    public static void registerSounds() {
        ModConstants.LOGGER.info("Registering ModSounds for " + ModConstants.MOD_NAME);
    }
}
