package mods.vivaanmc.optimium.client.gui.options.storage;

import mods.vivaanmc.optimium.client.optimiumClientMod;
import mods.vivaanmc.optimium.client.gui.optimiumGameOptions;

import java.io.IOException;

public class OptimiumOptionsStorage implements OptionStorage<optimiumGameOptions> {
    private final optimiumGameOptions options;

    public OptimiumOptionsStorage() {
        this.options = optimiumClientMod.options();
    }

    @Override
    public optimiumGameOptions getData() {
        return this.options;
    }

    @Override
    public void save() {
        try {
            this.options.writeChanges();
        } catch (IOException e) {
            throw new RuntimeException("Couldn't save configuration changes", e);
        }

        optimiumClientMod.logger().info("Flushed changes to optimium configuration");
    }
}
