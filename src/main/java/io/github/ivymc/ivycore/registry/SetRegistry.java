package io.github.ivymc.ivycore.registry;

/**
 * @param <V> Value type
 * @param <T> Invoke argument type
 */
public interface SetRegistry<V,T> extends Registry<V,T> {
    V register(V value);
}
