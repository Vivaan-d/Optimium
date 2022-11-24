package mods.vivaanmc.optimium.client.render.pipeline;

import mods.vivaanmc.optimium.client.model.quad.blender.ColorBlender;
import mods.vivaanmc.optimium.client.model.quad.blender.FlatColorBlender;
import mods.vivaanmc.optimium.client.model.quad.blender.LinearColorBlender;
import net.minecraft.client.MinecraftClient;

public class ChunkRenderCache {
    protected ColorBlender createBiomeColorBlender() {
        return MinecraftClient.getInstance().options.getBiomeBlendRadius().getValue() <= 0 ? new FlatColorBlender() : new LinearColorBlender();
    }
}
