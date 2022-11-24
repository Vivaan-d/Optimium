package mods.vivaanmc.optimium.client.model.vertex.formats.quad;

import mods.vivaanmc.optimium.client.model.vertex.buffer.VertexBufferView;
import mods.vivaanmc.optimium.client.model.vertex.formats.quad.writer.QuadVertexBufferWriterNio;
import mods.vivaanmc.optimium.client.model.vertex.formats.quad.writer.QuadVertexBufferWriterUnsafe;
import mods.vivaanmc.optimium.client.model.vertex.formats.quad.writer.QuadVertexWriterFallback;
import mods.vivaanmc.optimium.client.model.vertex.type.BlittableVertexType;
import mods.vivaanmc.optimium.client.model.vertex.type.VanillaVertexType;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexFormat;

public class QuadVertexType implements VanillaVertexType<QuadVertexSink>, BlittableVertexType<QuadVertexSink> {
    @Override
    public QuadVertexSink createFallbackWriter(VertexConsumer consumer) {
        return new QuadVertexWriterFallback(consumer);
    }

    @Override
    public QuadVertexSink createBufferWriter(VertexBufferView buffer, boolean direct) {
        return direct ? new QuadVertexBufferWriterUnsafe(buffer) : new QuadVertexBufferWriterNio(buffer);
    }

    @Override
    public VertexFormat getVertexFormat() {
        return QuadVertexSink.VERTEX_FORMAT;
    }

    @Override
    public BlittableVertexType<QuadVertexSink> asBlittable() {
        return this;
    }
}
