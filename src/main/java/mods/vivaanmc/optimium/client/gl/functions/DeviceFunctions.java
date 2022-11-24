package mods.vivaanmc.optimium.client.gl.functions;

import mods.vivaanmc.optimium.client.gl.device.RenderDevice;

public class DeviceFunctions {
    private final BufferStorageFunctions bufferStorageFunctions;

    public DeviceFunctions(RenderDevice device) {
        this.bufferStorageFunctions = BufferStorageFunctions.pickBest(device);
    }

    public BufferStorageFunctions getBufferStorageFunctions() {
        return bufferStorageFunctions;
    }
}
