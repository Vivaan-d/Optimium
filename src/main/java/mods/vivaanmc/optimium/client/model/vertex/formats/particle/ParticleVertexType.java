package mods.vivaanmc.optimium.client.model.vertex.formats.particle;

import mods.vivaanmc.optimium.client.model.vertex.buffer.VertexBufferView;
import mods.vivaanmc.optimium.client.model.vertex.formats.particle.writer.ParticleVertexBufferWriterNio;
import mods.vivaanmc.optimium.client.model.vertex.formats.particle.writer.ParticleVertexBufferWriterUnsafe;
import mods.vivaanmc.optimium.client.model.vertex.formats.particle.writer.ParticleVertexWriterFallback;
import mods.vivaanmc.optimium.client.model.vertex.type.BlittableVertexType;
import mods.vivaanmc.optimium.client.model.vertex.type.VanillaVertexType;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexFormat;

public class ParticleVertexType implements VanillaVertexType<ParticleVertexSink>, BlittableVertexType<ParticleVertexSink> {
    @Override
    public ParticleVertexSink createBufferWriter(VertexBufferView buffer, boolean direct) {
        return direct ? new ParticleVertexBufferWriterUnsafe(buffer) : new ParticleVertexBufferWriterNio(buffer);
    }

    @Override
    public ParticleVertexSink createFallbackWriter(VertexConsumer consumer) {
        return new ParticleVertexWriterFallback(consumer);
    }

    @Override
    public BlittableVertexType<ParticleVertexSink> asBlittable() {
        return this;
    }

    @Override
    public VertexFormat getVertexFormat() {
        return ParticleVertexSink.VERTEX_FORMAT;
    }
}
