package io.github.ivymc.ivycore.registry;

@SuppressWarnings("unused")
public interface SetRegistry<V,T> extends Registry<V,T> {
    V register(V value);
}
