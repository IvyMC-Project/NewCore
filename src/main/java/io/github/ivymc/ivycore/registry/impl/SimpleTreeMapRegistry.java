package io.github.ivymc.ivycore.registry.impl;

import io.github.ivymc.ivycore.helpers.ThrowingConsumer;
import io.github.ivymc.ivycore.helpers.Utils;
import io.github.ivymc.ivycore.registry.MapRegistry;

import java.util.*;

@SuppressWarnings("unused")
public class SimpleTreeMapRegistry<K extends Comparable<?>,V,T> implements MapRegistry<K,V,T> {
    private final Map<K, V> registry = new TreeMap<>();
    private final Random random = new Random();
    private final ThrowingConsumer<T> invokeFunction;
    public SimpleTreeMapRegistry(ThrowingConsumer<T> invokeFunction) {
        this.invokeFunction = invokeFunction;
    }


    @Override
    public V register(K id, V value) {
        return registry.put(id, value);
    }

    @Override
    public V getEntry(K id) {
        return registry.get(id);
    }

    @Override
    public V getEntryOrDefault(K key, V defaultValue) {
        return registry.getOrDefault(key, defaultValue);
    }

    @Override
    public Iterable<Map.Entry<K, V>> getEntries() {
        return registry.entrySet();
    }

    @Override
    public List<Map.Entry<K, V>> getListEntries() {
        return List.copyOf(registry.entrySet());
    }

    @Override
    public Optional<V> getOptionalEntry(K id) {
        return Optional.ofNullable(registry.get(id));
    }

    @Override
    public Optional<Map.Entry<K, V>> getRandomEntry() {
        return Utils.getRandomOrEmpty(getListEntries(), random);
    }

    @Override
    public Iterable<V> getValues() {
        return registry.values();
    }

    @Override
    public List<V> getListValues() {
        return List.copyOf(registry.values());
    }

    @Override
    public Optional<V> getRandomValue() {
        return Utils.getRandomOrEmpty(getListValues(), random);
    }

    @Override
    public void invoke(T value) {
        invokeFunction.accept(value);
    }
}