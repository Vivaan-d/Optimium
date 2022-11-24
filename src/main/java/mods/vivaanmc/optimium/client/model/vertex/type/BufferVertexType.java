package mods.vivaanmc.optimium.client.model.vertex.type;

import mods.vivaanmc.optimium.client.gl.attribute.BufferVertexFormat;
import mods.vivaanmc.optimium.client.model.vertex.VertexSink;

/**
 * A blittable {@link VertexType} which supports direct copying into a {@link net.minecraft.client.render.BufferBuilder}
 * provided the buffer's vertex format matches that required by the {@link VertexSink}.
 *
 * @param <T> The {@link VertexSink} type this factory produces
 */
public interface BufferVertexType<T extends VertexSink> extends VertexType<T> {
    BufferVertexFormat getBufferVertexFormat();
}
