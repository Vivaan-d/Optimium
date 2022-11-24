package mods.vivaanmc.optimium.client.model.vertex;

import mods.vivaanmc.optimium.client.model.vertex.formats.glyph.GlyphVertexSink;
import mods.vivaanmc.optimium.client.model.vertex.formats.glyph.GlyphVertexType;
import mods.vivaanmc.optimium.client.model.vertex.formats.line.LineVertexSink;
import mods.vivaanmc.optimium.client.model.vertex.formats.line.LineVertexType;
import mods.vivaanmc.optimium.client.model.vertex.formats.particle.ParticleVertexSink;
import mods.vivaanmc.optimium.client.model.vertex.formats.particle.ParticleVertexType;
import mods.vivaanmc.optimium.client.model.vertex.formats.quad.QuadVertexSink;
import mods.vivaanmc.optimium.client.model.vertex.formats.quad.QuadVertexType;
import mods.vivaanmc.optimium.client.model.vertex.formats.screen_quad.BasicScreenQuadVertexSink;
import mods.vivaanmc.optimium.client.model.vertex.formats.screen_quad.BasicScreenQuadVertexType;
import mods.vivaanmc.optimium.client.model.vertex.type.VanillaVertexType;

public class VanillaVertexTypes {
    public static final VanillaVertexType<QuadVertexSink> QUADS = new QuadVertexType();
    public static final VanillaVertexType<LineVertexSink> LINES = new LineVertexType();
    public static final VanillaVertexType<GlyphVertexSink> GLYPHS = new GlyphVertexType();
    public static final VanillaVertexType<ParticleVertexSink> PARTICLES = new ParticleVertexType();
    public static final VanillaVertexType<BasicScreenQuadVertexSink> BASIC_SCREEN_QUADS = new BasicScreenQuadVertexType();
}
