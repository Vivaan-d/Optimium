package mods.vivaanmc.optimium.mixin.core.pipeline;

import mods.vivaanmc.optimium.client.model.quad.ModelQuadView;
import mods.vivaanmc.optimium.client.model.quad.properties.ModelQuadFlags;
import net.minecraft.client.render.model.BakedQuad;
import net.minecraft.client.texture.Sprite;
import net.minecraft.util.math.Direction;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static mods.vivaanmc.optimium.client.util.ModelQuadUtil.*;

@Mixin(BakedQuad.class)
public class MixinBakedQuad implements ModelQuadView {
    @Shadow
    @Final
    protected int[] vertexData;

    @Shadow
    @Final
    protected Sprite sprite;

    @Shadow
    @Final
    protected int colorIndex;

    private int cachedFlags;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void init(int[] vertexData, int colorIndex, Direction face, Sprite sprite, boolean shade, CallbackInfo ci) {
        this.cachedFlags = ModelQuadFlags.getQuadFlags((BakedQuad) (Object) this);
    }

    @Override
    public float getX(int idx) {
        return Float.intBitsToFloat(this.vertexData[vertexOffset(idx) + POSITION_INDEX]);
    }

    @Override
    public float getY(int idx) {
        return Float.intBitsToFloat(this.vertexData[vertexOffset(idx) + POSITION_INDEX + 1]);
    }

    @Override
    public float getZ(int idx) {
        return Float.intBitsToFloat(this.vertexData[vertexOffset(idx) + POSITION_INDEX + 2]);
    }

    @Override
    public int getColor(int idx) {
        return this.vertexData[vertexOffset(idx) + COLOR_INDEX];
    }

    @Override
    public Sprite getSprite() {
        return this.sprite;
    }

    @Override
    public float getTexU(int idx) {
        return Float.intBitsToFloat(this.vertexData[vertexOffset(idx) + TEXTURE_INDEX]);
    }

    @Override
    public float getTexV(int idx) {
        return Float.intBitsToFloat(this.vertexData[vertexOffset(idx) + TEXTURE_INDEX + 1]);
    }

    @Override
    public int getFlags() {
        return this.cachedFlags;
    }

    @Override
    public int getLight(int idx) {
        return this.vertexData[vertexOffset(idx) + LIGHT_INDEX];
    }

    @Override
    public int getNormal(int idx) {
        return this.vertexData[vertexOffset(idx) + NORMAL_INDEX];
    }

    @Override
    public int getColorIndex() {
        return this.colorIndex;
    }
}
