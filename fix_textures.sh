#!/bin/bash

# Fix transparency issues in PNG textures
# Requires ImageMagick to be installed

TARGET_ITEM_DIR="/home/seamu/IdeaProjects/Vapour/common/src/main/resources/assets/vapour/textures/item"
TARGET_BLOCK_DIR="/home/seamu/IdeaProjects/Vapour/common/src/main/resources/assets/vapour/textures/block"

# Ensure directories exist
mkdir -p "$TARGET_ITEM_DIR"
mkdir -p "$TARGET_BLOCK_DIR"

# Function to fix transparency in PNG files
fix_transparency() {
    local dir=$1
    echo "Processing files in $dir..."
    
    for file in "$dir"/*.png; do
        if [ -f "$file" ]; then
            echo "Fixing transparency for $file"
            # Create a temporary file
            temp_file=$(mktemp)
            # Convert the image to have proper transparency
            convert "$file" -alpha set -background none "$temp_file"
            # Replace the original file
            mv "$temp_file" "$file"
        fi
    done
}

# Fix transparency in item textures
fix_transparency "$TARGET_ITEM_DIR"

# Fix transparency in block textures
fix_transparency "$TARGET_BLOCK_DIR"

echo "Texture transparency fixed successfully!"
chmod +x fix_textures.sh
