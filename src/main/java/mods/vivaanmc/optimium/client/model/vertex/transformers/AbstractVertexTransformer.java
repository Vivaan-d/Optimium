package mods.vivaanmc.optimium.client.model.vertex.transformers;

import mods.vivaanmc.optimium.client.model.vertex.VertexSink;

/**
 * A vertex transformer wraps an {@link VertexSink} interface to modify incoming vertex data, delegating any
 * actual logic to the inner sink.
 * @param <T> The {@link VertexSink} interface this transformer wraps
 */
public abstract class AbstractVertexTransformer<T extends VertexSink> implements VertexSink {
    protected final T delegate;

    protected AbstractVertexTransformer(T delegate) {
        this.delegate = delegate;
    }

    @Override
    public void ensureCapacity(int count) {
        this.delegate.ensureCapacity(count);
    }

    @Override
    public void flush() {
        this.delegate.flush();
    }

    @Override
    public int getVertexCount() {
        return this.delegate.getVertexCount();
    }
}
