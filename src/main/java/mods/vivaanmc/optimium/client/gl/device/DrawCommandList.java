package mods.vivaanmc.optimium.client.gl.device;

import mods.vivaanmc.optimium.client.gl.tessellation.GlIndexType;
import org.lwjgl.PointerBuffer;

import java.nio.IntBuffer;

public interface DrawCommandList extends AutoCloseable {
    void multiDrawElementsBaseVertex(PointerBuffer pointer, IntBuffer count, IntBuffer baseVertex, GlIndexType indexType);

    void endTessellating();

    void flush();

    @Override
    default void close() {
        this.flush();
    }
}
