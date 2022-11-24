package mods.vivaanmc.optimium.client.model.vertex.formats.line.writer;

import mods.vivaanmc.optimium.client.model.vertex.fallback.VertexWriterFallback;
import mods.vivaanmc.optimium.client.model.vertex.formats.line.LineVertexSink;
import mods.vivaanmc.optimium.client.util.Norm3b;
import mods.vivaanmc.optimium.client.util.color.ColorABGR;
import net.minecraft.client.render.VertexConsumer;

public class LineVertexWriterFallback extends VertexWriterFallback implements LineVertexSink {
    public LineVertexWriterFallback(VertexConsumer consumer) {
        super(consumer);
    }

    @Override
    public void vertexLine(float x, float y, float z, int color, int normal) {
        VertexConsumer consumer = this.consumer;
        consumer.vertex(x, y, z);
        consumer.color(ColorABGR.unpackRed(color), ColorABGR.unpackGreen(color), ColorABGR.unpackBlue(color), ColorABGR.unpackAlpha(color));
        consumer.normal(Norm3b.unpackX(normal), Norm3b.unpackY(normal), Norm3b.unpackZ(normal));
        consumer.next();
    }
}
