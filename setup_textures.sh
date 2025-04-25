#!/bin/bash

# Create placeholder textures for Vapour mod
# This script downloads vanilla textures from a reliable source

TARGET_ITEM_DIR="/home/seamu/IdeaProjects/Vapour/common/src/main/resources/assets/vapour/textures/item"
TARGET_BLOCK_DIR="/home/seamu/IdeaProjects/Vapour/common/src/main/resources/assets/vapour/textures/block"

# Ensure target directories exist
mkdir -p "$TARGET_ITEM_DIR"
mkdir -p "$TARGET_BLOCK_DIR"

# Create a temporary directory for downloads
TEMP_DIR="/tmp/mc_textures"
mkdir -p "$TEMP_DIR"

# Download vanilla textures from GitHub - these are stable links to MC textures
echo "Downloading vanilla textures..."

# Item textures
wget -q -O "$TEMP_DIR/paper.png" "https://raw.githubusercontent.com/InventivetalentDev/minecraft-assets/1.21/assets/minecraft/textures/item/paper.png"
wget -q -O "$TEMP_DIR/wheat_seeds.png" "https://raw.githubusercontent.com/InventivetalentDev/minecraft-assets/1.21/assets/minecraft/textures/item/wheat_seeds.png"
wget -q -O "$TEMP_DIR/kelp.png" "https://raw.githubusercontent.com/InventivetalentDev/minecraft-assets/1.21/assets/minecraft/textures/item/kelp.png"
wget -q -O "$TEMP_DIR/flint_and_steel.png" "https://raw.githubusercontent.com/InventivetalentDev/minecraft-assets/1.21/assets/minecraft/textures/item/flint_and_steel.png"
wget -q -O "$TEMP_DIR/end_rod.png" "https://raw.githubusercontent.com/InventivetalentDev/minecraft-assets/1.21/assets/minecraft/textures/item/end_rod.png"
wget -q -O "$TEMP_DIR/honey_bottle.png" "https://raw.githubusercontent.com/InventivetalentDev/minecraft-assets/1.21/assets/minecraft/textures/item/honey_bottle.png"
wget -q -O "$TEMP_DIR/beetroot_seeds.png" "https://raw.githubusercontent.com/InventivetalentDev/minecraft-assets/1.21/assets/minecraft/textures/item/beetroot_seeds.png"
wget -q -O "$TEMP_DIR/dried_kelp.png" "https://raw.githubusercontent.com/InventivetalentDev/minecraft-assets/1.21/assets/minecraft/textures/item/dried_kelp.png"
wget -q -O "$TEMP_DIR/glass_bottle.png" "https://raw.githubusercontent.com/InventivetalentDev/minecraft-assets/1.21/assets/minecraft/textures/item/glass_bottle.png"
wget -q -O "$TEMP_DIR/potion.png" "https://raw.githubusercontent.com/InventivetalentDev/minecraft-assets/1.21/assets/minecraft/textures/item/potion.png"

# Block textures - crop stages
for i in {0..3}; do
  wget -q -O "$TEMP_DIR/wheat_stage$i.png" "https://raw.githubusercontent.com/InventivetalentDev/minecraft-assets/1.21/assets/minecraft/textures/block/wheat_stage$i.png"
  wget -q -O "$TEMP_DIR/beetroots_stage$i.png" "https://raw.githubusercontent.com/InventivetalentDev/minecraft-assets/1.21/assets/minecraft/textures/block/beetroots_stage$i.png"
done

for i in {4..7}; do
  wget -q -O "$TEMP_DIR/wheat_stage$i.png" "https://raw.githubusercontent.com/InventivetalentDev/minecraft-assets/1.21/assets/minecraft/textures/block/wheat_stage3.png"
done

wget -q -O "$TEMP_DIR/carrots_stage2.png" "https://raw.githubusercontent.com/InventivetalentDev/minecraft-assets/1.21/assets/minecraft/textures/block/carrots_stage2.png"
wget -q -O "$TEMP_DIR/carrots_stage3.png" "https://raw.githubusercontent.com/InventivetalentDev/minecraft-assets/1.21/assets/minecraft/textures/block/carrots_stage3.png"
wget -q -O "$TEMP_DIR/potatoes_stage3.png" "https://raw.githubusercontent.com/InventivetalentDev/minecraft-assets/1.21/assets/minecraft/textures/block/potatoes_stage3.png"
wget -q -O "$TEMP_DIR/sweet_berry_bush_stage3.png" "https://raw.githubusercontent.com/InventivetalentDev/minecraft-assets/1.21/assets/minecraft/textures/block/sweet_berry_bush_stage3.png"

echo "Copying textures to mod directories..."

# Tobacco products - using paper and seeds textures
cp "$TEMP_DIR/paper.png" "$TARGET_ITEM_DIR/cigarette.png"
cp "$TEMP_DIR/wheat_seeds.png" "$TARGET_ITEM_DIR/tobacco_seeds.png"
cp "$TEMP_DIR/kelp.png" "$TARGET_ITEM_DIR/tobacco_leaf.png"
cp "$TEMP_DIR/flint_and_steel.png" "$TARGET_ITEM_DIR/lighter.png"

# Vaping devices - using stick and potion
cp "$TEMP_DIR/end_rod.png" "$TARGET_ITEM_DIR/vape_pen.png"
cp "$TEMP_DIR/honey_bottle.png" "$TARGET_ITEM_DIR/e_liquid.png"

# Cannabis products - using seeds and leaves
cp "$TEMP_DIR/beetroot_seeds.png" "$TARGET_ITEM_DIR/cannabis_seeds.png"
cp "$TEMP_DIR/dried_kelp.png" "$TARGET_ITEM_DIR/cannabis_leaf.png"
cp "$TEMP_DIR/glass_bottle.png" "$TARGET_ITEM_DIR/cart.png"

# Energy drinks - using potion texture
cp "$TEMP_DIR/potion.png" "$TARGET_ITEM_DIR/energy_drink.png"

# Crop textures for tobacco (wheat-based)
for i in {0..7}
do
  cp "$TEMP_DIR/wheat_stage$i.png" "$TARGET_BLOCK_DIR/tobacco_crop_stage$i.png"
done

# Crop textures for cannabis (using various stages from different crops for variety)
cp "$TEMP_DIR/beetroots_stage0.png" "$TARGET_BLOCK_DIR/cannabis_crop_stage0.png"
cp "$TEMP_DIR/beetroots_stage1.png" "$TARGET_BLOCK_DIR/cannabis_crop_stage1.png"
cp "$TEMP_DIR/beetroots_stage2.png" "$TARGET_BLOCK_DIR/cannabis_crop_stage2.png"
cp "$TEMP_DIR/beetroots_stage3.png" "$TARGET_BLOCK_DIR/cannabis_crop_stage3.png"
cp "$TEMP_DIR/carrots_stage2.png" "$TARGET_BLOCK_DIR/cannabis_crop_stage4.png"
cp "$TEMP_DIR/carrots_stage3.png" "$TARGET_BLOCK_DIR/cannabis_crop_stage5.png"
cp "$TEMP_DIR/potatoes_stage3.png" "$TARGET_BLOCK_DIR/cannabis_crop_stage6.png"
cp "$TEMP_DIR/sweet_berry_bush_stage3.png" "$TARGET_BLOCK_DIR/cannabis_crop_stage7.png"

# Clean up
rm -rf "$TEMP_DIR"

echo "Placeholder textures created successfully!"