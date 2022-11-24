package mods.vivaanmc.optimium.mixin.core.pipeline;

import mods.vivaanmc.optimium.client.gl.attribute.BufferVertexFormat;
import net.minecraft.client.render.VertexFormat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(VertexFormat.class)
public abstract class MixinVertexFormat implements BufferVertexFormat {

    @Shadow
    public abstract int getVertexSizeByte();

    @Override
    public int getStride() {
        return this.getVertexSizeByte();
    }
}
