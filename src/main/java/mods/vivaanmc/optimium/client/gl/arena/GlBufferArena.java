package mods.vivaanmc.optimium.client.gl.arena;

import mods.vivaanmc.optimium.client.gl.buffer.GlBuffer;
import mods.vivaanmc.optimium.client.gl.device.CommandList;

import java.util.stream.Stream;

public interface GlBufferArena {
    int getDeviceUsedMemory();

    int getDeviceAllocatedMemory();

    void free(GlBufferSegment entry);

    void delete(CommandList commands);

    boolean isEmpty();

    GlBuffer getBufferObject();

    boolean upload(CommandList commandList, Stream<PendingUpload> stream);
}
