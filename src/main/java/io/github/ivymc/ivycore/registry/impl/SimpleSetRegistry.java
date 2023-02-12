package io.github.ivymc.ivycore.registry.impl;

import io.github.ivymc.ivycore.utils.ThrowingConsumer;
import io.github.ivymc.ivycore.registry.SetRegistry;

import java.util.*;

@SuppressWarnings("unused")
public class SimpleSetRegistry<V,T> implements SetRegistry<V,T> {
    private final Set<V> registry = new HashSet<>();
    private final ThrowingConsumer<T> invokeFunction;

    public SimpleSetRegistry(ThrowingConsumer<T> invokeFunction) {
        this.invokeFunction = invokeFunction;
    }

    @Override
    public V register(V value) {
        registry.add(value);
        return value;
    }

    @Override
    public List<V> getListValues() {
        return List.copyOf(registry);
    }

    @Override
    public void invoke(T value) {
        invokeFunction.accept(value);
    }
}
