package mods.vivaanmc.optimium.client.gui.options;

import mods.vivaanmc.optimium.client.gui.options.control.Control;
import mods.vivaanmc.optimium.client.gui.options.storage.OptionStorage;
import net.minecraft.text.Text;

import java.util.Collection;

public interface Option<T> {
    Text getName();

    Text getTooltip();

    OptionImpact getImpact();

    Control<T> getControl();

    T getValue();

    void setValue(T value);

    void reset();

    OptionStorage<?> getStorage();

    boolean isAvailable();

    boolean hasChanged();

    void applyChanges();

    Collection<OptionFlag> getFlags();
}
