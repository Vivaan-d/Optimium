package mods.vivaanmc.optimium.client.render.chunk.compile.buffers;

import mods.vivaanmc.optimium.client.model.IndexBufferBuilder;
import mods.vivaanmc.optimium.client.model.quad.properties.ModelQuadFacing;
import mods.vivaanmc.optimium.client.render.chunk.format.ModelVertexSink;
import net.minecraft.client.texture.Sprite;

public interface ChunkModelBuilder {
    ModelVertexSink getVertexSink();

    IndexBufferBuilder getIndexBufferBuilder(ModelQuadFacing facing);

    void addSprite(Sprite sprite);

    int getChunkId();
}
