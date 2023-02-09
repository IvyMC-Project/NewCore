package io.github.ivymc.ivycore.registry.impl;

import io.github.ivymc.ivycore.helpers.Identifier;
import io.github.ivymc.ivycore.helpers.ThrowingConsumer;
import io.github.ivymc.ivycore.helpers.Utils;
import io.github.ivymc.ivycore.registry.MapRegistry;

import java.util.*;

public class SimpleMapRegistry<V, T> implements MapRegistry<V, T> {
    private final Map<Identifier, V> registry = new HashMap<>();
    private final Random random = new Random();
    private final ThrowingConsumer<T> invokeFunction;

    public SimpleMapRegistry(ThrowingConsumer<T> invoke) {
        this.invokeFunction = invoke;
    }

    @Override
    public V register(Identifier key, V value) {
        return registry.putIfAbsent(key, value);
    }

    @Override
    public V getEntry(Identifier key) {
        return registry.get(key);
    }

    @Override
    public V getEntryOrDefault(Identifier key, V defaultValue) {
        return registry.getOrDefault(key, defaultValue);
    }


    @Override
    public Iterable<Map.Entry<Identifier, V>> getEntries() {
        return registry.entrySet();
    }

    @Override
    public List<Map.Entry<Identifier,V>> getListEntries() {
        return List.copyOf(registry.entrySet());
    }

    @Override
    public Optional<V> getOptionalEntry(Identifier key) {
        return Optional.ofNullable(registry.get(key));
    }

    @Override
    public Optional<Map.Entry<Identifier,V>> getRandomEntry() {
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
