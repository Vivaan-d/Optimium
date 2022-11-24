package mods.vivaanmc.optimium.client.gui.options.storage;

import mods.vivaanmc.optimium.client.optimiumClientMod;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.GameOptions;

public class MinecraftOptionsStorage implements OptionStorage<GameOptions> {
    private final MinecraftClient client;

    public MinecraftOptionsStorage() {
        this.client = MinecraftClient.getInstance();
    }

    @Override
    public GameOptions getData() {
        return this.client.options;
    }

    @Override
    public void save() {
        this.getData().write();

        optimiumClientMod.logger().info("Flushed changes to Minecraft configuration");
    }
}
