package mods.vivaanmc.optimium.mixin.features.options;

import mods.vivaanmc.optimium.client.optimiumClientMod;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.WorldRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(WorldRenderer.class)
public class MixinWorldRenderer {
    @Redirect(method = "renderWeather", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/MinecraftClient;isFancyGraphicsOrBetter()Z"))
    private boolean redirectGetFancyWeather() {
        return optimiumClientMod.options().quality.weatherQuality.isFancy(MinecraftClient.getInstance().options.getGraphicsMode().getValue());
    }
}