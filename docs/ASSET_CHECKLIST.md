# ASSET_CHECKLIST.md

## Goal

Prevent **pink/black texture errors** and ensure every asset functions correctly in Minecraft **26.2**.

## Every Block

Texture

Block model

Item model

Blockstate

Loot table

Recipe

Language entry

Tags

Mining tags

## Every Wood Asset

Normal log

Horizontal log

Wood

Stripped log

Stripped wood

Planks

Stairs

Slab

Fence

Fence gate

Door

Trapdoor

Pressure plate

Button

Sign

Hanging sign

Boat

Chest boat

## Entity Assets

textures/entity/boat/

textures/entity/chest_boat/

textures/entity/signs/

textures/entity/signs/hanging/

## Registration

WoodType

SignType

Boat entity

Chest boat entity

Creative tab

Fuel values

Flammability

Composting

## Blockstate Verification

Door:

- facing
- open
- half
- hinge

Trapdoor:

- facing
- open
- half

Fence:

- north
- south
- east
- west

Fence Gate:

- facing
- open
- in_wall

Log:

- axis x
- axis y
- axis z

## Runtime Validation

Inventory icon

Placed block

Horizontal log

Door animation

Trapdoor animation

Fence connection

Fence gate connection

Boat in water

Chest boat in water

Sign placement

Hanging sign placement

Leaf decay

Sapling growth

Structure generation

Biome generation

## Data Generation

Recipes generated

Loot tables generated

Tags generated

Models generated

Blockstates generated

Language files generated

## Final Release Check

Compile

runClient

Create new world

Locate biome

Chop tree

Craft full wood set

Place every block

Use boat

Use signs

Verify no missing texture warnings

Verify no console asset errors

Only after every item passes may a release be tagged.
