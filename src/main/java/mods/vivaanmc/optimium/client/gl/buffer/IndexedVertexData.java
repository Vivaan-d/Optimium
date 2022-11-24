package mods.vivaanmc.optimium.client.gl.buffer;

import mods.vivaanmc.optimium.client.gl.attribute.GlVertexFormat;
import mods.vivaanmc.optimium.client.util.NativeBuffer;

/**
 * Helper type for tagging the vertex format alongside the raw buffer data.
 */
public record IndexedVertexData(GlVertexFormat<?> vertexFormat,
                                NativeBuffer vertexBuffer,
                                NativeBuffer indexBuffer) {
    public void delete() {
        this.vertexBuffer.free();
        this.indexBuffer.free();
    }
}
