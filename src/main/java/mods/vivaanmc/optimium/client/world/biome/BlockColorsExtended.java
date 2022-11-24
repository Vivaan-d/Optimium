package mods.vivaanmc.optimium.client.world.biome;

import mods.vivaanmc.optimium.client.model.quad.blender.ColorSampler;
import net.minecraft.block.BlockState;

public interface BlockColorsExtended {
    ColorSampler<BlockState> getColorProvider(BlockState state);
}
