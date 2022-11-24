package mods.vivaanmc.optimium.client.render.pipeline.context;

import mods.vivaanmc.optimium.client.model.light.LightPipelineProvider;
import mods.vivaanmc.optimium.client.model.light.cache.ArrayLightDataCache;
import mods.vivaanmc.optimium.client.model.quad.blender.ColorBlender;
import mods.vivaanmc.optimium.client.render.pipeline.BlockRenderer;
import mods.vivaanmc.optimium.client.render.pipeline.ChunkRenderCache;
import mods.vivaanmc.optimium.client.render.pipeline.FluidRenderer;
import mods.vivaanmc.optimium.client.world.WorldSlice;
import mods.vivaanmc.optimium.client.world.cloned.ChunkRenderContext;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.block.BlockModels;
import net.minecraft.world.World;

public class ChunkRenderCacheLocal extends ChunkRenderCache {
    private final ArrayLightDataCache lightDataCache;

    private final BlockRenderer blockRenderer;
    private final FluidRenderer fluidRenderer;

    private final BlockModels blockModels;
    private final WorldSlice worldSlice;

    public ChunkRenderCacheLocal(MinecraftClient client, World world) {
        this.worldSlice = new WorldSlice(world);
        this.lightDataCache = new ArrayLightDataCache(this.worldSlice);

        LightPipelineProvider lightPipelineProvider = new LightPipelineProvider(this.lightDataCache);
        ColorBlender colorBlender = this.createBiomeColorBlender();

        this.blockRenderer = new BlockRenderer(client, lightPipelineProvider, colorBlender);
        this.fluidRenderer = new FluidRenderer(lightPipelineProvider, colorBlender);

        this.blockModels = client.getBakedModelManager().getBlockModels();
    }

    public BlockModels getBlockModels() {
        return this.blockModels;
    }

    public BlockRenderer getBlockRenderer() {
        return this.blockRenderer;
    }

    public FluidRenderer getFluidRenderer() {
        return this.fluidRenderer;
    }

    public void init(ChunkRenderContext context) {
        this.lightDataCache.reset(context.getOrigin());
        this.worldSlice.copyData(context);
    }

    public WorldSlice getWorldSlice() {
        return this.worldSlice;
    }
}
