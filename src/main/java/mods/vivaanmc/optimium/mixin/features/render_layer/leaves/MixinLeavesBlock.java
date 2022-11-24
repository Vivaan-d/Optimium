package mods.vivaanmc.optimium.mixin.features.render_layer.leaves;

import mods.vivaanmc.optimium.client.optimiumClientMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.Material;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.Direction;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(LeavesBlock.class)
public class MixinLeavesBlock extends Block {
    public MixinLeavesBlock() {
        super(Settings.of(Material.AIR));
        throw new AssertionError("Mixin constructor called!");
    }

    @Override
    public boolean isSideInvisible(BlockState state, BlockState stateFrom, Direction direction) {
        if (optimiumClientMod.options().quality.leavesQuality.isFancy(MinecraftClient.getInstance().options.getGraphicsMode().getValue())) {
            return super.isSideInvisible(state, stateFrom, direction);
        } else {
            return stateFrom.getBlock() instanceof LeavesBlock || super.isSideInvisible(state, stateFrom, direction);
        }
    }
}
