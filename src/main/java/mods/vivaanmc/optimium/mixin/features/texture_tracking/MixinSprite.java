package mods.vivaanmc.optimium.mixin.features.texture_tracking;

import mods.vivaanmc.optimium.client.render.texture.SpriteExtended;
import net.minecraft.client.texture.Sprite;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Sprite.class)
public abstract class MixinSprite implements SpriteExtended {
    private boolean active;

    @Override
    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean isActive() {
        return this.active;
    }
}
