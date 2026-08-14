# Amber Grove

![Minecraft 26.2](https://img.shields.io/badge/Minecraft-26.2-brightgreen)
![Loader](https://img.shields.io/badge/Loader-Fabric-blue)
![Resolution](https://img.shields.io/badge/Texture%20Resolution-32%C3%9732-orange)
![License](https://img.shields.io/badge/License-MIT-lightgrey)

**Amber Grove** is a production-quality Fabric biome expansion mod designed for **Minecraft 26.2**. It introduces a warm, golden autumn forest biome filled with custom dark walnut trees, vibrant amber/gold/red foliage, fallen leaf particles, unique vegetation, decorative blocks, and full wood/boat/sign sets — crafted to feel indistinguishable from an official Minecraft update.

---

## 🌲 Key Features

### 🍂 Amber Grove Biome (`ambergrove:amber_grove`)
- **Climate:** Warm amber atmosphere (Temp: `0.7`, Downfall: `0.5`).
- **Visual Identity:** Dark walnut trunks, golden and copper-red canopy, sparse sunlight, drifting ambient amber leaves.
- **Tree Generation:** Amber Trees (height 8–11) with curved trunks, upper branching, wide sparse canopy, hanging leaf clusters, hollow ancient trees, and fallen logs.
- **Rarity:** Integrated naturally into Overworld generation with rarity similar to Cherry Grove.

### 🪵 Kehribar Wood Set
- **Logs & Wood:** Kehribar Log, Stripped Kehribar Log, Kehribar Wood, Stripped Kehribar Wood.
- **Planks & Building:** Kehribar Planks, Stairs, Slabs, Fences, Fence Gates, Pressure Plates, Buttons.
- **Interactables:** Kehribar Doors, Trapdoors.
- **Signs & Transport:** Standing Signs, Hanging Signs, Boats, and Chest Boats (with custom entity textures).

### 🌿 Foliage & Decoration
- **Leaves:** `kehribar_leaves`, `altin_leaves`, `kizil_leaves`.
- **Ground Cover:** `fallen_amber_leaves`, `amber_fern`, `amber_mushroom`.
- **Resin & Amber Blocks:** `amber_resin`, `amber_lantern`, `amber_block`, `polished_amber_block`, `amber_tile`.

### 🏚️ Abandoned Autumn Cabin
- Rare structure (~1% spawn chance) containing books, maps, decorative blocks, and amber resin loot.

---

## 🎨 Texture & Asset Standards

- **32×32 Resolution:** High-detail, crisp pixel art compatible with vanilla Minecraft 26.2.
- **Gemini ImageGen Pipeline:** Textures are generated following strict pixel art guidelines with limited color palettes (Dark Walnut `#4B2F1F`, Amber Orange `#D97A1E`, Golden Yellow `#E8B94A`, Copper Red `#A84A1E`, Honey Wood `#C48A42`, Muted Olive `#6A7A3A`).
- **Complete Asset Guarantee:** Every block includes matching textures, blockstates, block models, item models, loot tables, recipes, tags, and localization.

---

## 📚 Specification Documents

Detailed technical specifications for the project are organized under `docs/`:

- 📋 [**MASTER_SPEC.md**](docs/MASTER_SPEC.md) — Core project rules, standards, architecture, and constraints.
- 🌍 [**WORLDGEN.md**](docs/WORLDGEN.md) — Biome climate, tree features, foliage distribution, ambient sound/particles, and structure gen.
- 🎨 [**IMAGE_PIPELINE.md**](docs/IMAGE_PIPELINE.md) — 32×32 texture creation workflow, naming conventions, and validation criteria.
- 🖌️ [**TEXTURE_PROMPTS.md**](docs/TEXTURE_PROMPTS.md) — Standardized prompts and color palette for Gemini ImageGen.
- ✅ [**ASSET_CHECKLIST.md**](docs/ASSET_CHECKLIST.md) — Runtime and compilation checklist preventing pink/black missing textures.
- 🗺️ [**ROADMAP.md**](ROADMAP.md) — Development phases and implementation milestones.
- 📜 [**CHANGELOG.md**](CHANGELOG.md) — Version history and build notes.

---

## 🛠️ Development & Building

### Requirements
- **JDK 21** or higher
- **Fabric Loader** for Minecraft 26.2

### Build Commands

```bash
# Run data generator (loot tables, recipes, models, tags)
./gradlew runDatagen

# Launch Minecraft client with mod loaded
./gradlew runClient

# Build production JAR
./gradlew build
```

---

## 🧱 Project Architecture & Foundation

The Amber Grove mod is organized using a clean, modular package structure targeting Minecraft 26.2 and Fabric:

```
com.ambergrove
├── Ambergrove.java             # Main Mod Initializer
├── client/
│   ├── AmbergroveClient.java   # Client Mod Initializer
│   └── AmbergroveDataGenerator.java # Datagen Entrypoint
├── datagen/                    # Fabric Data Generation Providers
│   ├── ModLanguageProvider.java
│   ├── ModModelProvider.java
│   ├── ModRecipeProvider.java
│   ├── ModLootTableProvider.java
│   ├── ModBlockTagProvider.java
│   └── ModItemTagProvider.java
├── registry/                   # Modular Registry System
│   ├── ModBlocks.java          # Block Registrations
│   ├── ModItems.java           # Item Registrations
│   ├── ModItemGroups.java      # Creative Mode Tab
│   ├── ModBiomes.java          # Biome Keys & Generation
│   ├── ModWorldGen.java        # Worldgen Features & Placements
│   ├── ModSounds.java          # Sound Event Registrations
│   ├── ModParticles.java       # Particle Type Registrations
│   └── ModStructures.java      # Structure Features & Pieces
└── util/
    └── ModConstants.java       # Identifiers & SLF4J Logger
```

---

## 📜 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
