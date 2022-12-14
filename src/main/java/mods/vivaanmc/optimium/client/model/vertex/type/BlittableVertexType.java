package mods.vivaanmc.optimium.client.model.vertex.type;

import mods.vivaanmc.optimium.client.optimiumClientMod;
import mods.vivaanmc.optimium.client.model.vertex.VertexSink;
import mods.vivaanmc.optimium.client.model.vertex.buffer.VertexBufferView;

public interface BlittableVertexType<T extends VertexSink> extends BufferVertexType<T> {
    /**
     * Creates a {@link VertexSink} which writes into a {@link VertexBufferView}. This allows for specialization
     * when the memory storage is known.
     *
     * @param buffer The backing vertex buffer
     * @param direct True if direct memory access is allowed, otherwise false
     */
    T createBufferWriter(VertexBufferView buffer, boolean direct);

    default T createBufferWriter(VertexBufferView buffer) {
        return this.createBufferWriter(buffer, optimiumClientMod.isDirectMemoryAccessEnabled());
    }
}
