package mods.vivaanmc.optimium.client.model.vertex.formats.screen_quad.writer;

import mods.vivaanmc.optimium.client.model.vertex.VanillaVertexTypes;
import mods.vivaanmc.optimium.client.model.vertex.buffer.VertexBufferView;
import mods.vivaanmc.optimium.client.model.vertex.buffer.VertexBufferWriterUnsafe;
import mods.vivaanmc.optimium.client.model.vertex.formats.screen_quad.BasicScreenQuadVertexSink;
import org.lwjgl.system.MemoryUtil;

public class BasicScreenQuadVertexBufferWriterUnsafe extends VertexBufferWriterUnsafe implements BasicScreenQuadVertexSink {
    public BasicScreenQuadVertexBufferWriterUnsafe(VertexBufferView backingBuffer) {
        super(backingBuffer, VanillaVertexTypes.BASIC_SCREEN_QUADS);
    }

    @Override
    public void writeQuad(float x, float y, float z, int color) {
        long i = this.writePointer;

        MemoryUtil.memPutFloat(i, x);
        MemoryUtil.memPutFloat(i + 4, y);
        MemoryUtil.memPutFloat(i + 8, z);
        MemoryUtil.memPutInt(i + 12, color);

        this.advance();
    }
}
