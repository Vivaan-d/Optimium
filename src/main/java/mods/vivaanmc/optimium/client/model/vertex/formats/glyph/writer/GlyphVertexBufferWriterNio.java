package mods.vivaanmc.optimium.client.model.vertex.formats.glyph.writer;

import mods.vivaanmc.optimium.client.model.vertex.VanillaVertexTypes;
import mods.vivaanmc.optimium.client.model.vertex.buffer.VertexBufferView;
import mods.vivaanmc.optimium.client.model.vertex.buffer.VertexBufferWriterNio;
import mods.vivaanmc.optimium.client.model.vertex.formats.glyph.GlyphVertexSink;

import java.nio.ByteBuffer;

public class GlyphVertexBufferWriterNio extends VertexBufferWriterNio implements GlyphVertexSink {
    public GlyphVertexBufferWriterNio(VertexBufferView backingBuffer) {
        super(backingBuffer, VanillaVertexTypes.GLYPHS);
    }

    @Override
    public void writeGlyph(float x, float y, float z, int color, float u, float v, int light) {
        int i = this.writeOffset;

        ByteBuffer buffer = this.byteBuffer;
        buffer.putFloat(i, x);
        buffer.putFloat(i + 4, y);
        buffer.putFloat(i + 8, z);
        buffer.putInt(i + 12, color);
        buffer.putFloat(i + 16, u);
        buffer.putFloat(i + 20, v);
        buffer.putInt(i + 24, light);

        this.advance();
    }
}
