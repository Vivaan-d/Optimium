package mods.vivaanmc.optimium.client.util.frustum;

public interface FrustumAdapter {
    Frustum optimium$createFrustum();

    static Frustum adapt(net.minecraft.client.render.Frustum frustum) {
        return ((FrustumAdapter) frustum).optimium$createFrustum();
    }
}
