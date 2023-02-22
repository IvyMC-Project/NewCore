package io.github.ivymc.ivycore.registry;

import java.util.Set;

/**
 * @param <V> Value type
 * @param <T> Invoke argument type
 */
public interface SetRegistry<V,T> extends Registry<V,T> {
    V register(V value);

    default boolean contains(V value) {
        return ((Set<V>)value).contains(value);
    }
}
