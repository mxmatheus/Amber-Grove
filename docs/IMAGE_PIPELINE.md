# IMAGE_PIPELINE.md

## Texture Workflow

All textures are generated with **Gemini ImageGen**.

## Resolution

**32×32 pixels**

No exceptions.

## Pipeline

Concept

↓

Gemini Prompt

↓

Generation

↓

Manual Pixel Cleanup

↓

Seam Check

↓

In-Game Validation

↓

Commit

## File Naming

Lowercase only.

Use underscores.

Examples:

- kehribar_log
- amber_resin
- polished_amber_block

## Folder Layout

textures/block/

textures/item/

textures/entity/boat/

textures/entity/chest_boat/

textures/entity/signs/

textures/entity/signs/hanging/

## Validation Checklist

- Tiles seamlessly
- No isolated noisy pixels
- Readable from inventory
- Readable from world view
- Matches vanilla contrast
- Matches neighboring textures
- Correct transparency
- Correct alpha edges

## Version Control

Each texture update must be committed separately when possible.

Example:

feat(textures): improve amber leaf contrast

## Forbidden

- AI-generated glow
- Photo textures
- 3D renders
- Gradients that break pixel readability
- Inconsistent lighting direction

## Acceptance Standard

A texture should look believable beside:

- oak
- spruce
- birch
- dark oak
- cherry
- mangrove
- pale oak

in Minecraft **26.2**.
