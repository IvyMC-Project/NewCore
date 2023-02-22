package io.github.ivymc.ivycore.registry.impl;

import io.github.ivymc.ivycore.utils.ThrowingConsumer;
import io.github.ivymc.ivycore.registry.MapRegistry;

import java.util.*;
import java.util.function.Consumer;

/**
 * @param <K> Key type (must be comparable)
 * @param <V> Value type
 * @param <T> Invoke argument type
 */
public class SimpleTreeMapRegistry<
        K extends Comparable<?>,
        V extends Consumer<?>,
        T
        > implements MapRegistry<K,V,T> {
    private final Map<K, V> registry = new TreeMap<>();

    private final ThrowingConsumer<T> invokeFunction;

    public SimpleTreeMapRegistry(ThrowingConsumer<T> invokeFunction) {
        this.invokeFunction = invokeFunction;
    }

    @Override
    public V register(K id, V value) {
        registry.put(id, value);
        return value;
    }

    @Override
    public V getEntry(K id) {
        return registry.get(id);
    }

    @Override
    public List<Map.Entry<K, V>> getListEntries() {
        return List.copyOf(registry.entrySet());
    }

    @Override
    public List<V> getListValues() {
        return List.copyOf(registry.values());
    }

    @Override
    public void invoke(T value) {
        invokeFunction.accept(value);
    }
}