package mods.vivaanmc.optimium.client.model.vertex.formats.line.writer;

import mods.vivaanmc.optimium.client.model.vertex.VanillaVertexTypes;
import mods.vivaanmc.optimium.client.model.vertex.buffer.VertexBufferView;
import mods.vivaanmc.optimium.client.model.vertex.buffer.VertexBufferWriterUnsafe;
import mods.vivaanmc.optimium.client.model.vertex.formats.line.LineVertexSink;
import org.lwjgl.system.MemoryUtil;

public class LineVertexBufferWriterUnsafe extends VertexBufferWriterUnsafe implements LineVertexSink {
    public LineVertexBufferWriterUnsafe(VertexBufferView backingBuffer) {
        super(backingBuffer, VanillaVertexTypes.LINES);
    }

    @Override
    public void ensureCapacity(int count) {
        super.ensureCapacity(count * 2);
    }

    @Override
    public void vertexLine(float x, float y, float z, int color, int normal) {
        for (int i = 0; i < 2; i++) {
            this.vertexLine0(x, y, z, color, normal);
        }
    }

    private void vertexLine0(float x, float y, float z, int color, int normal) {
        long i = this.writePointer;

        MemoryUtil.memPutFloat(i, x);
        MemoryUtil.memPutFloat(i + 4, y);
        MemoryUtil.memPutFloat(i + 8, z);
        MemoryUtil.memPutInt(i + 12, color);
        MemoryUtil.memPutInt(i + 16, normal);

        this.advance();
    }
}
