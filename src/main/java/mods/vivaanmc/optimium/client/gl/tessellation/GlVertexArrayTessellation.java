package mods.vivaanmc.optimium.client.gl.tessellation;

import mods.vivaanmc.optimium.client.gl.array.GlVertexArray;
import mods.vivaanmc.optimium.client.gl.device.CommandList;

public class GlVertexArrayTessellation extends GlAbstractTessellation {
    private final GlVertexArray array;

    public GlVertexArrayTessellation(GlVertexArray array, GlPrimitiveType primitiveType, TessellationBinding[] bindings) {
        super(primitiveType, bindings);

        this.array = array;
    }

    public void init(CommandList commandList) {
        this.bind(commandList);
        this.bindAttributes(commandList);
        this.unbind(commandList);
    }

    @Override
    public void delete(CommandList commandList) {
        commandList.deleteVertexArray(this.array);
    }

    @Override
    public void bind(CommandList commandList) {
        commandList.bindVertexArray(this.array);
    }

    @Override
    public void unbind(CommandList commandList) {
        commandList.unbindVertexArray();
    }
}
