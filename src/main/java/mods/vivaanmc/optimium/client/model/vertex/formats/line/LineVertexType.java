package mods.vivaanmc.optimium.client.model.vertex.formats.line;

import mods.vivaanmc.optimium.client.model.vertex.buffer.VertexBufferView;
import mods.vivaanmc.optimium.client.model.vertex.formats.line.writer.LineVertexBufferWriterNio;
import mods.vivaanmc.optimium.client.model.vertex.formats.line.writer.LineVertexBufferWriterUnsafe;
import mods.vivaanmc.optimium.client.model.vertex.formats.line.writer.LineVertexWriterFallback;
import mods.vivaanmc.optimium.client.model.vertex.type.BlittableVertexType;
import mods.vivaanmc.optimium.client.model.vertex.type.VanillaVertexType;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexFormat;

public class LineVertexType implements VanillaVertexType<LineVertexSink>, BlittableVertexType<LineVertexSink> {
    @Override
    public LineVertexSink createBufferWriter(VertexBufferView buffer, boolean direct) {
        return direct ? new LineVertexBufferWriterUnsafe(buffer) : new LineVertexBufferWriterNio(buffer);
    }

    @Override
    public LineVertexSink createFallbackWriter(VertexConsumer consumer) {
        return new LineVertexWriterFallback(consumer);
    }

    @Override
    public VertexFormat getVertexFormat() {
        return LineVertexSink.VERTEX_FORMAT;
    }

    @Override
    public BlittableVertexType<LineVertexSink> asBlittable() {
        return this;
    }
}
