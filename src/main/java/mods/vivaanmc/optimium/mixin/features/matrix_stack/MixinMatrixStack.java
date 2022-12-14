package mods.vivaanmc.optimium.mixin.features.matrix_stack;

import mods.vivaanmc.optimium.client.util.math.Matrix3fExtended;
import mods.vivaanmc.optimium.client.util.math.Matrix4fExtended;
import mods.vivaanmc.optimium.client.util.math.MatrixUtil;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Quaternion;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Deque;

@Mixin(MatrixStack.class)
public class MixinMatrixStack {
    @Shadow
    @Final
    private Deque<MatrixStack.Entry> stack;

    /**
     * @reason Use our faster specialized function
     * @author JellySquid
     */
    @Overwrite
    public void translate(double x, double y, double z) {
        MatrixStack.Entry entry = this.stack.getLast();

        Matrix4fExtended mat = MatrixUtil.getExtendedMatrix(entry.getPositionMatrix());
        mat.translate((float) x, (float) y, (float) z);
    }

    /**
     * @reason Use our faster specialized function
     * @author JellySquid
     */
    @Overwrite
    public void multiply(Quaternion q) {
        MatrixStack.Entry entry = this.stack.getLast();

        Matrix4fExtended mat4 = MatrixUtil.getExtendedMatrix(entry.getPositionMatrix());
        mat4.rotate(q);

        Matrix3fExtended mat3 = MatrixUtil.getExtendedMatrix(entry.getNormalMatrix());
        mat3.rotate(q);
    }
}
