package mods.vivaanmc.optimium.client.gl.buffer;

import mods.vivaanmc.optimium.client.gl.GlObject;
import org.lwjgl.opengl.GL20C;

public abstract class GlBuffer extends GlObject {
    public static final int NULL_BUFFER_ID = 0;

    private GlBufferMapping activeMapping;

    protected GlBuffer() {
        this.setHandle(GL20C.glGenBuffers());
    }

    public GlBufferMapping getActiveMapping() {
        return this.activeMapping;
    }

    public void setActiveMapping(GlBufferMapping mapping) {
        this.activeMapping = mapping;
    }
}
