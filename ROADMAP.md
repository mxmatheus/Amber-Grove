# ROADMAP.md - Amber Grove Development Plan

## Phase 1: Project Setup & Specification Base 🟢 (Current Phase)
- [x] Repository initialization & GitHub connection
- [x] Spec documents integration (`MASTER_SPEC`, `WORLDGEN`, `IMAGE_PIPELINE`, `TEXTURE_PROMPTS`, `ASSET_CHECKLIST`)
- [x] Production `README.md`, `ROADMAP.md`, `CHANGELOG.md`
- [ ] Dev branch setup (`dev`)

## Phase 2: Core Registries & Basic Wood Block Set 🪵
- [ ] Mod ID & Mod Initializer configuration (`ambergrove`)
- [ ] Block & Item Registries (`ModBlocks`, `ModItems`, `ModItemGroup`)
- [ ] Kehribar Log, Wood, Stripped Log, Stripped Wood, Planks
- [ ] Data Generators for Models, Blockstates, Loot Tables, Recipes, and Translations

## Phase 3: Extended Wood Architecture & Functional Blocks 🚪
- [ ] Kehribar Stairs, Slabs, Fences, Fence Gates
- [ ] Kehribar Doors, Trapdoors, Pressure Plates, Buttons
- [ ] Flammability, Fuel, and Composting Registrations
- [ ] WoodType & SignType registrations for Signs and Hanging Signs

## Phase 4: Foliage, Vegetation & Decorative Resources 🌿
- [ ] `kehribar_leaves`, `altin_leaves`, `kizil_leaves` with particle support and decay
- [ ] `fallen_amber_leaves`, `amber_mushroom`, `amber_fern`
- [ ] `amber_resin`, `amber_lantern`, `amber_block`, `polished_amber_block`, `amber_tile`

## Phase 5: Entities & Transport 🛶
- [ ] Custom entity registration for Kehribar Boat & Kehribar Chest Boat
- [ ] Entity models, renderers, and textures (`textures/entity/boat/`)

## Phase 6: Biome Generation, Trees & Structures 🌲
- [ ] Configured Features: Amber Trees (Normal, Large, Fallen Log, Hollow Ancient Tree)
- [ ] Placed Features & Vegetation distribution
- [ ] Surface rules & Biome registration (`ambergrove:amber_grove` - Climate: Temp 0.7, Downfall 0.5)
- [ ] Abandoned Autumn Cabin Structure (~1% spawn chance) with loot table

## Phase 7: Texture Generation & Validation Pipeline 🎨
- [ ] Gemini ImageGen 32×32 texture creation & pixel art validation
- [ ] Integration of all block, item, and entity textures
- [ ] Zero missing texture audit (no pink/black checkers)

## Phase 8: Final Runtime Verification & Release 🚀
- [ ] Full `./gradlew runDatagen`, `./gradlew build`, `./gradlew runClient` pass
- [ ] In-game survival test & biome distribution verification
