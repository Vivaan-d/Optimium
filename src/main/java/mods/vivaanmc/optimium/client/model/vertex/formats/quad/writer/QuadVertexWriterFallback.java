package mods.vivaanmc.optimium.client.model.vertex.formats.quad.writer;

import mods.vivaanmc.optimium.client.model.vertex.fallback.VertexWriterFallback;
import mods.vivaanmc.optimium.client.model.vertex.formats.quad.QuadVertexSink;
import mods.vivaanmc.optimium.client.util.Norm3b;
import mods.vivaanmc.optimium.client.util.color.ColorABGR;
import net.minecraft.client.render.VertexConsumer;

public class QuadVertexWriterFallback extends VertexWriterFallback implements QuadVertexSink {
    public QuadVertexWriterFallback(VertexConsumer consumer) {
        super(consumer);
    }

    @Override
    public void writeQuad(float x, float y, float z, int color, float u, float v, int light, int overlay, int normal) {
        VertexConsumer consumer = this.consumer;
        consumer.vertex(x, y, z);
        consumer.color(ColorABGR.unpackRed(color), ColorABGR.unpackGreen(color), ColorABGR.unpackBlue(color), ColorABGR.unpackAlpha(color));
        consumer.texture(u, v);
        consumer.overlay(overlay);
        consumer.light(light);
        consumer.normal(Norm3b.unpackX(normal), Norm3b.unpackY(normal), Norm3b.unpackZ(normal));
        consumer.next();
    }
}
