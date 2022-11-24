package mods.vivaanmc.optimium.mixin.features.chunk_rendering;

import mods.vivaanmc.optimium.client.render.optimiumWorldRenderer;
import net.minecraft.client.world.ClientWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientWorld.class)
public class MixinClientWorld {
    @Inject(method = "markChunkRenderability", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/chunk/WorldChunk;setShouldRenderOnUpdate(Z)V", shift = At.Shift.AFTER))
    private void postLightUpdate(int chunkX, int chunkZ, CallbackInfo ci) {
        optimiumWorldRenderer.instance()
                .onChunkLightAdded(chunkX, chunkZ);
    }
}
