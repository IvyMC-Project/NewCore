package io.github.ivymc.ivycore.registry;

import io.github.ivymc.ivycore.helpers.ThrowingConsumer;
import net.minecraft.util.Util;
import net.minecraft.util.math.random.Random;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class SimpleHashRegistry<K, V, T> implements HashRegistry<K, V, T> {
    private final ConcurrentMap<K, V> registry = new ConcurrentHashMap<>();
    private final Random random = Random.create();
    private final ThrowingConsumer<T> invokeFunction;

    public SimpleHashRegistry(ThrowingConsumer<T> invoke) {
        this.invokeFunction = invoke;
    }

    @Override
    public V register(K key, V value) {
        return registry.putIfAbsent(key, value);
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
    public Iterable<Map.Entry<K, V>> getEntries() {
        return registry.entrySet();
    }

    @Override
    public List<Map.Entry<K,V>> getListEntries() {
        return List.copyOf(registry.entrySet());
    }

    @Override
    public Optional<V> getOptionalEntry(K key) {
        return Optional.ofNullable(registry.get(key));
    }

    @Override
    public Optional<Map.Entry<K,V>> getRandomEntry() {
        return Util.getRandomOrEmpty(getListEntries(), random);
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
        return Util.getRandomOrEmpty(getListValues(), random);
    }

    @Override
    public void invoke(T value) {
        invokeFunction.accept(value);
    }
}
