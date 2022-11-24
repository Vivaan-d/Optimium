package mods.vivaanmc.optimium.client.render.chunk.data;

import mods.vivaanmc.optimium.client.gl.buffer.IndexedVertexData;
import mods.vivaanmc.optimium.client.gl.util.ElementRange;
import mods.vivaanmc.optimium.client.model.quad.properties.ModelQuadFacing;

import java.util.Map;

public class ChunkMeshData {
    private final Map<ModelQuadFacing, ElementRange> parts;
    private final IndexedVertexData vertexData;

    public ChunkMeshData(IndexedVertexData vertexData, Map<ModelQuadFacing, ElementRange> parts) {
        this.parts = parts;
        this.vertexData = vertexData;
    }

    public Map<ModelQuadFacing, ElementRange> getParts() {
        return this.parts;
    }

    public IndexedVertexData getVertexData() {
        return this.vertexData;
    }
}
