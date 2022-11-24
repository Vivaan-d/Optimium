package mods.vivaanmc.optimium.mixin.features.options;

import mods.vivaanmc.optimium.client.optimiumClientMod;
import net.minecraft.client.gui.hud.InGameHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(InGameHud.class)
public class MixinInGameHud {
    @Redirect(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/MinecraftClient;isFancyGraphicsOrBetter()Z"))
    private boolean redirectFancyGraphicsVignette() {
        return optimiumClientMod.options().quality.enableVignette;
    }
}
