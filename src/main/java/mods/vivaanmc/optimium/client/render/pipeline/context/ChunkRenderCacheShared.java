package mods.vivaanmc.optimium.client.render.pipeline.context;

import it.unimi.dsi.fastutil.objects.Reference2ObjectOpenHashMap;
import mods.vivaanmc.optimium.client.model.light.LightPipelineProvider;
import mods.vivaanmc.optimium.client.model.light.cache.HashLightDataCache;
import mods.vivaanmc.optimium.client.model.quad.blender.ColorBlender;
import mods.vivaanmc.optimium.client.render.pipeline.BlockRenderer;
import mods.vivaanmc.optimium.client.render.pipeline.ChunkRenderCache;
import net.minecraft.client.MinecraftClient;
import net.minecraft.world.BlockRenderView;

import java.util.Map;

public class ChunkRenderCacheShared extends ChunkRenderCache {
    private static final Map<BlockRenderView, ChunkRenderCacheShared> INSTANCES = new Reference2ObjectOpenHashMap<>();

    private final BlockRenderer blockRenderer;
    private final HashLightDataCache lightCache;

    private ChunkRenderCacheShared(BlockRenderView world) {
        MinecraftClient client = MinecraftClient.getInstance();

        this.lightCache = new HashLightDataCache(world);

        ColorBlender colorBlender = this.createBiomeColorBlender();
        LightPipelineProvider lightPipelineProvider = new LightPipelineProvider(this.lightCache);

        this.blockRenderer = new BlockRenderer(client, lightPipelineProvider, colorBlender);
    }

    public BlockRenderer getBlockRenderer() {
        return this.blockRenderer;
    }

    private void resetCache() {
        this.lightCache.clearCache();
    }

    public static ChunkRenderCacheShared getInstance(BlockRenderView world) {
        ChunkRenderCacheShared instance = INSTANCES.get(world);

        if (instance == null) {
            throw new IllegalStateException("No global renderer exists");
        }

        return instance;
    }

    public static void destroyRenderContext(BlockRenderView world) {
        if (INSTANCES.remove(world) == null) {
            throw new IllegalStateException("No render context exists for world: " + world);
        }
    }

    public static void createRenderContext(BlockRenderView world) {
        if (INSTANCES.containsKey(world)) {
            throw new IllegalStateException("Render context already exists for world: " + world);
        }

        INSTANCES.put(world, new ChunkRenderCacheShared(world));
    }

    public static void resetCaches() {
        for (ChunkRenderCacheShared context : INSTANCES.values()) {
            context.resetCache();
        }
    }
}
