package mods.vivaanmc.optimium.client.render.chunk.shader;

import mods.vivaanmc.optimium.client.gl.shader.uniform.GlUniform;
import mods.vivaanmc.optimium.client.gl.shader.uniform.GlUniformBlock;

import java.util.function.IntFunction;

public interface ShaderBindingContext {
    <U extends GlUniform<?>> U bindUniform(String name, IntFunction<U> factory);

    GlUniformBlock bindUniformBlock(String name, int bindingPoint);
}
