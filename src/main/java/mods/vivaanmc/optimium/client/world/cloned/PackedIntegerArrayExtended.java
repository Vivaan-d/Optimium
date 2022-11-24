package mods.vivaanmc.optimium.client.world.cloned;

import mods.vivaanmc.optimium.client.world.cloned.palette.ClonedPalette;

public interface PackedIntegerArrayExtended {
    <T> void copyUsingPalette(T[] out, ClonedPalette<T> palette);
}
