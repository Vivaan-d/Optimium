package mods.vivaanmc.optimium.client.world.biome;

import net.minecraft.client.color.item.ItemColorProvider;
import net.minecraft.item.ItemStack;

public interface ItemColorsExtended {
    ItemColorProvider getColorProvider(ItemStack stack);
}
