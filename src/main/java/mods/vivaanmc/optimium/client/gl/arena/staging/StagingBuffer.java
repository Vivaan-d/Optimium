package mods.vivaanmc.optimium.client.gl.arena.staging;

import mods.vivaanmc.optimium.client.gl.buffer.GlBuffer;
import mods.vivaanmc.optimium.client.gl.device.CommandList;

import java.nio.ByteBuffer;

public interface StagingBuffer {
    void enqueueCopy(CommandList commandList, ByteBuffer data, GlBuffer dst, long writeOffset);

    void flush(CommandList commandList);

    void delete(CommandList commandList);

    void flip();
}
