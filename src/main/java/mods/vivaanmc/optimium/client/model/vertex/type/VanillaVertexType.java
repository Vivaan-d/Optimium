package mods.vivaanmc.optimium.client.model.vertex.type;

import mods.vivaanmc.optimium.client.gl.attribute.BufferVertexFormat;
import mods.vivaanmc.optimium.client.model.vertex.VertexSink;
import net.minecraft.client.render.VertexFormat;

public interface VanillaVertexType<T extends VertexSink> extends BufferVertexType<T> {
    default BufferVertexFormat getBufferVertexFormat() {
        return BufferVertexFormat.from(this.getVertexFormat());
    }

    VertexFormat getVertexFormat();
}
