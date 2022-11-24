package mods.vivaanmc.optimium.client.render.chunk;

import mods.vivaanmc.optimium.client.gl.arena.GlBufferSegment;
import mods.vivaanmc.optimium.client.gl.util.ElementRange;
import mods.vivaanmc.optimium.client.model.quad.properties.ModelQuadFacing;
import mods.vivaanmc.optimium.client.render.chunk.data.ChunkMeshData;
import org.apache.commons.lang3.Validate;

import java.util.Map;

public class ChunkGraphicsState {
    private final GlBufferSegment vertexSegment;
    private final GlBufferSegment indexSegment;

    private final ElementRange[] parts;

    public ChunkGraphicsState(GlBufferSegment vertexSegment, GlBufferSegment indexSegment, ChunkMeshData data) {
        Validate.notNull(vertexSegment);
        Validate.notNull(indexSegment);

        this.vertexSegment = vertexSegment;
        this.indexSegment = indexSegment;

        this.parts = new ElementRange[ModelQuadFacing.COUNT];

        for (Map.Entry<ModelQuadFacing, ElementRange> entry : data.getParts().entrySet()) {
            this.parts[entry.getKey().ordinal()] = entry.getValue();
        }
    }

    public void delete() {
        this.vertexSegment.delete();
        this.indexSegment.delete();
    }

    public ElementRange getModelPart(ModelQuadFacing facing) {
        return this.parts[facing.ordinal()];
    }

    public GlBufferSegment getVertexSegment() {
        return this.vertexSegment;
    }

    public GlBufferSegment getIndexSegment() {
        return this.indexSegment;
    }
}
