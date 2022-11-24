package mods.vivaanmc.optimium.mixin.core.pipeline;

import mods.vivaanmc.optimium.client.model.vertex.VertexDrain;
import mods.vivaanmc.optimium.client.model.vertex.VertexSink;
import mods.vivaanmc.optimium.client.model.vertex.type.VertexType;
import net.minecraft.client.render.VertexConsumer;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(VertexConsumer.class)
public interface MixinVertexConsumer extends VertexDrain {
    @Override
    default <T extends VertexSink> T createSink(VertexType<T> factory) {
        return factory.createFallbackWriter((VertexConsumer) this);
    }
}
