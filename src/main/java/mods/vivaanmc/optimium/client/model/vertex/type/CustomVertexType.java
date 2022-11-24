package mods.vivaanmc.optimium.client.model.vertex.type;

import mods.vivaanmc.optimium.client.gl.attribute.BufferVertexFormat;
import mods.vivaanmc.optimium.client.gl.attribute.GlVertexFormat;
import mods.vivaanmc.optimium.client.model.vertex.VertexSink;

public interface CustomVertexType<T extends VertexSink, A extends Enum<A>> extends BufferVertexType<T> {
    /**
     * @return The {@link GlVertexFormat} required for blitting (direct writing into buffers)
     */
    GlVertexFormat<A> getCustomVertexFormat();

    @Override
    default BufferVertexFormat getBufferVertexFormat() {
        return this.getCustomVertexFormat();
    }
}
