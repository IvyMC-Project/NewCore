package io.github.ivymc.ivycore.registry;

import net.minecraft.util.Util;
import net.minecraft.util.math.random.Random;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class SimpleRegistry <K, V> implements Registry <K, V>{
    private final ConcurrentMap<K, V> registry = new ConcurrentHashMap<>();
    private final Random random = Random.create();
    private final V defaultValue;

    public SimpleRegistry(V defaultValue) {
        this.defaultValue = defaultValue;
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
    public V getDefaultValue() {
        return defaultValue;
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
    public Optional<Map.Entry<K,V>> getRandom() {
        return Util.getRandomOrEmpty(getListEntries(), random);
    }
}
