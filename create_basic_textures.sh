#!/bin/bash

# Create very basic placeholder textures for Vapour mod

TARGET_ITEM_DIR="/home/seamu/IdeaProjects/Vapour/common/src/main/resources/assets/vapour/textures/item"
TARGET_BLOCK_DIR="/home/seamu/IdeaProjects/Vapour/common/src/main/resources/assets/vapour/textures/block"

# Ensure target directories exist
mkdir -p "$TARGET_ITEM_DIR"
mkdir -p "$TARGET_BLOCK_DIR"

# Function to create a simple colored texture
create_colored_texture() {
    convert -size 16x16 xc:$1 "$2"
}

# Create item textures
create_colored_texture "#FFFFFF" "$TARGET_ITEM_DIR/cigarette.png"
create_colored_texture "#F5DEB3" "$TARGET_ITEM_DIR/tobacco_seeds.png"
create_colored_texture "#8B4513" "$TARGET_ITEM_DIR/tobacco_leaf.png"
create_colored_texture "#A9A9A9" "$TARGET_ITEM_DIR/lighter.png"
create_colored_texture "#C0C0C0" "$TARGET_ITEM_DIR/vape_pen.png"
create_colored_texture "#FFD700" "$TARGET_ITEM_DIR/e_liquid.png"
create_colored_texture "#228B22" "$TARGET_ITEM_DIR/cannabis_seeds.png"
create_colored_texture "#006400" "$TARGET_ITEM_DIR/cannabis_leaf.png"
create_colored_texture "#FFFFFF" "$TARGET_ITEM_DIR/cart.png"
create_colored_texture "#1E90FF" "$TARGET_ITEM_DIR/energy_drink.png"

# Create crop textures
for i in {0..7}; do
    stage_opacity=$(echo "scale=2; 0.3 + $i * 0.1" | bc)
    create_colored_texture "#8B4513$stage_opacity" "$TARGET_BLOCK_DIR/tobacco_crop_stage$i.png"
    create_colored_texture "#006400$stage_opacity" "$TARGET_BLOCK_DIR/cannabis_crop_stage$i.png"
done

echo "Basic placeholder textures created successfully!"
