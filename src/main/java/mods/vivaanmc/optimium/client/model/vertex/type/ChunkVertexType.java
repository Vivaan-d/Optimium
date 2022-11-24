package mods.vivaanmc.optimium.client.model.vertex.type;

import mods.vivaanmc.optimium.client.render.chunk.format.ChunkMeshAttribute;
import mods.vivaanmc.optimium.client.render.chunk.format.ModelVertexSink;

public interface ChunkVertexType extends BlittableVertexType<ModelVertexSink>, CustomVertexType<ModelVertexSink, ChunkMeshAttribute> {
    /**
     * @return The scale to be applied to vertex coordinates
     */
    float getPositionScale();

    /**
     * @return The translation to be applied to vertex coordinates
     */
    float getPositionOffset();

    /**
     * @return The scale to be applied to texture coordinates
     */
    float getTextureScale();
}
