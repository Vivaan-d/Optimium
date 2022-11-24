package mods.vivaanmc.optimium.client.gui.options.control;

import mods.vivaanmc.optimium.client.gui.options.Option;
import mods.vivaanmc.optimium.client.util.Dim2i;

public interface Control<T> {
    Option<T> getOption();

    ControlElement<T> createElement(Dim2i dim);

    int getMaxWidth();
}
