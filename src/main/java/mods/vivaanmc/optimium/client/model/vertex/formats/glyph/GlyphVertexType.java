package mods.vivaanmc.optimium.client.model.vertex.formats.glyph;

import mods.vivaanmc.optimium.client.model.vertex.buffer.VertexBufferView;
import mods.vivaanmc.optimium.client.model.vertex.formats.glyph.writer.GlyphVertexBufferWriterNio;
import mods.vivaanmc.optimium.client.model.vertex.formats.glyph.writer.GlyphVertexBufferWriterUnsafe;
import mods.vivaanmc.optimium.client.model.vertex.formats.glyph.writer.GlyphVertexWriterFallback;
import mods.vivaanmc.optimium.client.model.vertex.type.BlittableVertexType;
import mods.vivaanmc.optimium.client.model.vertex.type.VanillaVertexType;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexFormat;

public class GlyphVertexType implements VanillaVertexType<GlyphVertexSink>, BlittableVertexType<GlyphVertexSink> {
    @Override
    public GlyphVertexSink createBufferWriter(VertexBufferView buffer, boolean direct) {
        return direct ? new GlyphVertexBufferWriterUnsafe(buffer) : new GlyphVertexBufferWriterNio(buffer);
    }

    @Override
    public GlyphVertexSink createFallbackWriter(VertexConsumer consumer) {
        return new GlyphVertexWriterFallback(consumer);
    }

    @Override
    public VertexFormat getVertexFormat() {
        return GlyphVertexSink.VERTEX_FORMAT;
    }

    @Override
    public BlittableVertexType<GlyphVertexSink> asBlittable() {
        return this;
    }
}
