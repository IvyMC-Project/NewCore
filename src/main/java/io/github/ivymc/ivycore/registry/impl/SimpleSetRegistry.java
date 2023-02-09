package io.github.ivymc.ivycore.registry.impl;

import io.github.ivymc.ivycore.helpers.ThrowingConsumer;
import io.github.ivymc.ivycore.registry.SetRegistry;
import net.minecraft.util.Util;
import net.minecraft.util.math.random.Random;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class SimpleSetRegistry<V,T> implements SetRegistry<V,T> {
    private final Set<V> registry = new HashSet<>();
    private final Random random = Random.create();
    private final ThrowingConsumer<T> invokeFunction;

    public SimpleSetRegistry(ThrowingConsumer<T> invokeFunction) {
        this.invokeFunction = invokeFunction;
    }

    @Override
    public Iterable<V> getValues() {
        return List.copyOf(registry);
    }

    @Override
    public List<V> getListValues() {
        return List.copyOf(registry);
    }

    @Override
    public Optional<V> getRandomValue() {
        return Util.getRandomOrEmpty(getListValues(), random);
    }

    @Override
    public void invoke(T value) {
        invokeFunction.accept(value);
    }

    @Override
    public V register(V value) {
        return registry.add(value) ? value : null;
    }
}
