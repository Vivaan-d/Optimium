package mods.vivaanmc.optimium.mixin.features.entity.fast_render;

import mods.vivaanmc.optimium.client.model.ModelCuboidAccessor;
import net.minecraft.client.model.ModelPart;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ModelPart.Cuboid.class)
public class MixinCuboid implements ModelCuboidAccessor {
    @Shadow
    @Final
    private ModelPart.Quad[] sides;

    @Override
    public ModelPart.Quad[] getQuads() {
        return this.sides;
    }
}
