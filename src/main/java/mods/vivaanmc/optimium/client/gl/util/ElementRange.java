package mods.vivaanmc.optimium.client.gl.util;

import mods.vivaanmc.optimium.client.gl.tessellation.GlIndexType;

public record ElementRange(int elementPointer, int elementCount, GlIndexType indexType, int baseVertex) {
}
