# MASTER_SPEC.md

## Project Identity

Project Name: Amber Grove

Mod ID: ambergrove

Target Version: **Minecraft 26.2**

Loader: Fabric

Texture Resolution: **32×32**

Image Generation: **Gemini ImageGen only**

## Primary Objective

Build a production-quality Fabric biome expansion mod that feels indistinguishable from an official Minecraft 26.2 update.

## AI Agent Operating Rules

The AI agent is responsible for implementation.

Before writing any code, the agent must read:

1. MASTER_SPEC.md
2. WORLDGEN.md
3. IMAGE_PIPELINE.md
4. TEXTURE_PROMPTS.md
5. ASSET_CHECKLIST.md

The agent may not ignore these documents.

## Code Standards

- Java
- Fabric API
- Loom
- Data Generation
- Modular architecture
- Dedicated registry classes
- No deprecated APIs
- No duplicated registration logic

## Asset Standards

Every block must include:

- block texture
- item texture
- block model
- item model
- blockstate
- loot table
- recipe
- language entry
- tags

Every wood asset must additionally include:

- stripped variants
- horizontal log model
- sign registration
- hanging sign registration
- boat registration
- chest boat registration
- entity textures
- wood type registration
- sign type registration

## Texture Policy

Textures must be generated through Gemini ImageGen.

Required format:

- 32×32
- pixel art
- vanilla compatible
- limited color palette
- no realism
- no glow overlays
- no AI artifacts

## GitHub Workflow

Repository: Amber-Grove

Branches:

- main
- dev

Commit format:

- feat:
- fix:
- refactor:
- chore:
- docs:

After every completed phase:

1. run datagen
2. compile
3. runClient validation
4. commit
5. push to dev

## Forbidden

- Placeholder textures
- Missing models
- Missing blockstates
- Missing recipes
- Missing loot tables
- Missing language entries
- Pink/black textures
- Manual recipe duplication
- Version references other than Minecraft **26.2**

## Required Project Structure

Amber-Grove/
README.md
CHANGELOG.md
ROADMAP.md
docs/
MASTER_SPEC.md
TEXTURE_PROMPTS.md
IMAGE_PIPELINE.md
WORLDGEN.md
ASSET_CHECKLIST.md
src/
.github/

## Success Criteria

The mod must compile, launch, generate naturally in survival worlds, contain zero missing texture warnings, and present a complete vanilla-quality gameplay loop.
