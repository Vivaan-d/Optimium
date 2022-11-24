package mods.vivaanmc.optimium.client.model.vertex.formats.screen_quad.writer;

import mods.vivaanmc.optimium.client.model.vertex.fallback.VertexWriterFallback;
import mods.vivaanmc.optimium.client.model.vertex.formats.screen_quad.BasicScreenQuadVertexSink;
import mods.vivaanmc.optimium.client.util.color.ColorABGR;
import net.minecraft.client.render.VertexConsumer;

public class BasicScreenQuadVertexWriterFallback extends VertexWriterFallback implements BasicScreenQuadVertexSink {
    public BasicScreenQuadVertexWriterFallback(VertexConsumer consumer) {
        super(consumer);
    }

    @Override
    public void writeQuad(float x, float y, float z, int color) {
        VertexConsumer consumer = this.consumer;
        consumer.vertex(x, y, z);
        consumer.color(ColorABGR.unpackRed(color), ColorABGR.unpackGreen(color), ColorABGR.unpackBlue(color), ColorABGR.unpackAlpha(color));
        consumer.next();
    }
}
