package mods.vivaanmc.optimium.client.gui.options.storage;

public interface OptionStorage<T> {
    T getData();

    void save();
}
