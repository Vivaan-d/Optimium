package mods.vivaanmc.optimium.client.gl.tessellation;

import mods.vivaanmc.optimium.client.gl.device.CommandList;

public interface GlTessellation {
    void delete(CommandList commandList);

    void bind(CommandList commandList);

    void unbind(CommandList commandList);

    GlPrimitiveType getPrimitiveType();
}
