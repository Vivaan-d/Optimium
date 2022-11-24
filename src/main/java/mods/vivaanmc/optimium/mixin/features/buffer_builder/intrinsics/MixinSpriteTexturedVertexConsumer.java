package mods.vivaanmc.optimium.mixin.features.buffer_builder.intrinsics;

import mods.vivaanmc.optimium.client.model.vertex.VanillaVertexTypes;
import mods.vivaanmc.optimium.client.model.vertex.VertexDrain;
import mods.vivaanmc.optimium.client.model.vertex.VertexSink;
import mods.vivaanmc.optimium.client.model.vertex.transformers.SpriteTexturedVertexTransformer;
import mods.vivaanmc.optimium.client.model.vertex.type.VertexType;
import net.minecraft.client.render.SpriteTexturedVertexConsumer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.texture.Sprite;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(SpriteTexturedVertexConsumer.class)
public abstract class MixinSpriteTexturedVertexConsumer implements VertexDrain {
    @Shadow
    @Final
    private Sprite sprite;

    @Shadow
    @Final
    private VertexConsumer parent;

    @SuppressWarnings("unchecked")
    @Override
    public <T extends VertexSink> T createSink(VertexType<T> type) {
        if (type == VanillaVertexTypes.QUADS) {
            return (T) new SpriteTexturedVertexTransformer.Quad(VertexDrain.of(this.parent)
                    .createSink(VanillaVertexTypes.QUADS), this.sprite);
        } else if (type == VanillaVertexTypes.PARTICLES) {
            return (T) new SpriteTexturedVertexTransformer.Particle(VertexDrain.of(this.parent)
                    .createSink(VanillaVertexTypes.PARTICLES), this.sprite);
        } else if (type == VanillaVertexTypes.GLYPHS) {
            return (T) new SpriteTexturedVertexTransformer.Glyph(VertexDrain.of(this.parent)
                    .createSink(VanillaVertexTypes.GLYPHS), this.sprite);
        }

        return type.createFallbackWriter((VertexConsumer) this);
    }
}
