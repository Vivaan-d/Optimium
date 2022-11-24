package mods.vivaanmc.optimium.client.render.chunk;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import mods.vivaanmc.optimium.client.gl.attribute.GlVertexFormat;
import mods.vivaanmc.optimium.client.gl.shader.*;
import mods.vivaanmc.optimium.client.gl.device.RenderDevice;
import mods.vivaanmc.optimium.client.gl.shader.*;
import mods.vivaanmc.optimium.client.model.vertex.type.ChunkVertexType;
import mods.vivaanmc.optimium.client.render.chunk.format.ChunkMeshAttribute;
import mods.vivaanmc.optimium.client.render.chunk.passes.BlockRenderPass;
import mods.vivaanmc.optimium.client.render.chunk.shader.ChunkFogMode;
import mods.vivaanmc.optimium.client.render.chunk.shader.ChunkShaderInterface;
import mods.vivaanmc.optimium.client.render.chunk.shader.ChunkShaderBindingPoints;
import mods.vivaanmc.optimium.client.render.chunk.shader.ChunkShaderOptions;
import net.minecraft.util.Identifier;

import java.util.Map;

public abstract class ShaderChunkRenderer implements ChunkRenderer {
    private final Map<ChunkShaderOptions, GlProgram<ChunkShaderInterface>> programs = new Object2ObjectOpenHashMap<>();

    protected final ChunkVertexType vertexType;
    protected final GlVertexFormat<ChunkMeshAttribute> vertexFormat;

    protected final RenderDevice device;

    protected GlProgram<ChunkShaderInterface> activeProgram;

    public ShaderChunkRenderer(RenderDevice device, ChunkVertexType vertexType) {
        this.device = device;
        this.vertexType = vertexType;
        this.vertexFormat = vertexType.getCustomVertexFormat();
    }

    protected GlProgram<ChunkShaderInterface> compileProgram(ChunkShaderOptions options) {
        GlProgram<ChunkShaderInterface> program = this.programs.get(options);

        if (program == null) {
            this.programs.put(options, program = this.createShader("blocks/block_layer_opaque", options));
        }

        return program;
    }

    private GlProgram<ChunkShaderInterface> createShader(String path, ChunkShaderOptions options) {
        ShaderConstants constants = options.constants();

        GlShader vertShader = ShaderLoader.loadShader(ShaderType.VERTEX,
                new Identifier("optimium", path + ".vsh"), constants);
        
        GlShader fragShader = ShaderLoader.loadShader(ShaderType.FRAGMENT,
                new Identifier("optimium", path + ".fsh"), constants);

        try {
            return GlProgram.builder(new Identifier("optimium", "chunk_shader"))
                    .attachShader(vertShader)
                    .attachShader(fragShader)
                    .bindAttribute("a_PosId", ChunkShaderBindingPoints.ATTRIBUTE_POSITION_ID)
                    .bindAttribute("a_Color", ChunkShaderBindingPoints.ATTRIBUTE_COLOR)
                    .bindAttribute("a_TexCoord", ChunkShaderBindingPoints.ATTRIBUTE_BLOCK_TEXTURE)
                    .bindAttribute("a_LightCoord", ChunkShaderBindingPoints.ATTRIBUTE_LIGHT_TEXTURE)
                    .bindFragmentData("fragColor", ChunkShaderBindingPoints.FRAG_COLOR)
                    .link((shader) -> new ChunkShaderInterface(shader, options));
        } finally {
            vertShader.delete();
            fragShader.delete();
        }
    }

    protected void begin(BlockRenderPass pass) {
        ChunkShaderOptions options = new ChunkShaderOptions(ChunkFogMode.SMOOTH, pass, this.vertexType);

        this.activeProgram = this.compileProgram(options);
        this.activeProgram.bind();
        this.activeProgram.getInterface()
                .setup(this.vertexType);
    }

    protected void end() {
        this.activeProgram.unbind();
        this.activeProgram = null;
    }

    @Override
    public void delete() {
        this.programs.values()
                .forEach(GlProgram::delete);
        this.programs.clear();
    }

    @Override
    public ChunkVertexType getVertexType() {
        return this.vertexType;
    }
}
