package mods.vivaanmc.optimium.client.model.vertex.formats.glyph.writer;

import mods.vivaanmc.optimium.client.model.vertex.VanillaVertexTypes;
import mods.vivaanmc.optimium.client.model.vertex.buffer.VertexBufferView;
import mods.vivaanmc.optimium.client.model.vertex.buffer.VertexBufferWriterUnsafe;
import mods.vivaanmc.optimium.client.model.vertex.formats.glyph.GlyphVertexSink;
import org.lwjgl.system.MemoryUtil;

public class GlyphVertexBufferWriterUnsafe extends VertexBufferWriterUnsafe implements GlyphVertexSink {
    public GlyphVertexBufferWriterUnsafe(VertexBufferView backingBuffer) {
        super(backingBuffer, VanillaVertexTypes.GLYPHS);
    }

    @Override
    public void writeGlyph(float x, float y, float z, int color, float u, float v, int light) {
        long i = this.writePointer;

        MemoryUtil.memPutFloat(i, x);
        MemoryUtil.memPutFloat(i + 4, y);
        MemoryUtil.memPutFloat(i + 8, z);
        MemoryUtil.memPutInt(i + 12, color);
        MemoryUtil.memPutFloat(i + 16, u);
        MemoryUtil.memPutFloat(i + 20, v);
        MemoryUtil.memPutInt(i + 24, light);

        this.advance();

    }
}
