package io.github.ivymc.ivycore.registry.impl;

import io.github.ivymc.ivycore.utils.ThrowingConsumer;
import io.github.ivymc.ivycore.registry.MapRegistry;

import java.util.*;

@SuppressWarnings("unused")
public class SimpleMapRegistry<K extends Comparable<?>,V,T> implements MapRegistry<K,V,T> {
    private final Map<K, V> registry = new HashMap<>();
    private final ThrowingConsumer<T> invokeFunction;

    public SimpleMapRegistry(ThrowingConsumer<T> invoke) {
        this.invokeFunction = invoke;
    }

    @Override
    public V register(K key, V value) {
        registry.putIfAbsent(key, value);
        return value;
    }

    @Override
    public V getEntry(K key) {
        return registry.get(key);
    }

    @Override
    public V getEntryOrDefault(K key, V defaultValue) {
        return registry.getOrDefault(key, defaultValue);
    }

    @Override
    public List<Map.Entry<K,V>> getListEntries() {
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
