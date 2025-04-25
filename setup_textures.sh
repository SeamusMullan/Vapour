#!/bin/bash

# Create placeholder textures from vanilla textures for Vapour mod
# This script is a temporary solution until custom textures are created

VANILLA_ASSETS="/home/seamu/IdeaProjects/Vapour/common/run/resources/assets/minecraft/textures"
TARGET_DIR="/home/seamu/IdeaProjects/Vapour/common/src/main/resources/assets/vapour/textures/item"

# Ensure target directory exists
mkdir -p "$TARGET_DIR"

# Tobacco products - using paper and seeds textures
cp "$VANILLA_ASSETS/item/paper.png" "$TARGET_DIR/cigarette.png"
cp "$VANILLA_ASSETS/item/wheat_seeds.png" "$TARGET_DIR/tobacco_seeds.png"
cp "$VANILLA_ASSETS/item/kelp.png" "$TARGET_DIR/tobacco_leaf.png"
cp "$VANILLA_ASSETS/item/flint_and_steel.png" "$TARGET_DIR/lighter.png"

# Vaping devices - using stick and potion
cp "$VANILLA_ASSETS/item/end_rod.png" "$TARGET_DIR/vape_pen.png"
cp "$VANILLA_ASSETS/item/honey_bottle.png" "$TARGET_DIR/e_liquid.png"

# Cannabis products - using seeds and leaves
cp "$VANILLA_ASSETS/item/beetroot_seeds.png" "$TARGET_DIR/cannabis_seeds.png"
cp "$VANILLA_ASSETS/item/dried_kelp.png" "$TARGET_DIR/cannabis_leaf.png"
cp "$VANILLA_ASSETS/item/glass_bottle.png" "$TARGET_DIR/cart.png"

# Energy drinks - using potion texture
cp "$VANILLA_ASSETS/item/potion.png" "$TARGET_DIR/energy_drink.png"

echo "Placeholder textures created successfully!"