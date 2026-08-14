package com.ambergrove.registry;

import com.ambergrove.util.ModConstants;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.vehicle.boat.Boat;
import net.minecraft.world.entity.vehicle.boat.ChestBoat;

public class ModEntities {

    public static final ResourceKey<EntityType<?>> KEHRIBAR_BOAT_KEY = ResourceKey.create(
            Registries.ENTITY_TYPE,
            ModConstants.id("kehribar_boat")
    );

    public static final ResourceKey<EntityType<?>> KEHRIBAR_CHEST_BOAT_KEY = ResourceKey.create(
            Registries.ENTITY_TYPE,
            ModConstants.id("kehribar_chest_boat")
    );

    public static final EntityType<Boat> KEHRIBAR_BOAT = Registry.register(
            BuiltInRegistries.ENTITY_TYPE,
            KEHRIBAR_BOAT_KEY,
            EntityType.Builder.<Boat>of(
                    (type, level) -> new Boat(type, level, () -> ModItems.KEHRIBAR_BOAT),
                    MobCategory.MISC
            ).sized(1.375F, 0.5625F).build(KEHRIBAR_BOAT_KEY)
    );

    public static final EntityType<ChestBoat> KEHRIBAR_CHEST_BOAT = Registry.register(
            BuiltInRegistries.ENTITY_TYPE,
            KEHRIBAR_CHEST_BOAT_KEY,
            EntityType.Builder.<ChestBoat>of(
                    (type, level) -> new ChestBoat(type, level, () -> ModItems.KEHRIBAR_CHEST_BOAT),
                    MobCategory.MISC
            ).sized(1.375F, 0.5625F).build(KEHRIBAR_CHEST_BOAT_KEY)
    );

    public static void registerEntities() {
        ModConstants.LOGGER.info("Registering ModEntities for " + ModConstants.MOD_NAME);
    }
}
