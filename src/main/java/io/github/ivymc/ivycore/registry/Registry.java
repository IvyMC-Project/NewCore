package io.github.ivymc.ivycore.registry;

import io.github.ivymc.ivycore.helpers.ThrowingConsumer;
import io.github.ivymc.ivycore.registry.impl.SimpleMapRegistry;
import io.github.ivymc.ivycore.registry.impl.SimpleSetRegistry;
import io.github.ivymc.ivycore.registry.impl.SimpleTreeMapRegistry;

import java.util.List;
import java.util.Optional;

public interface Registry <V,T> {
    Iterable<V> getValues();
    List<V> getListValues();
    Optional<V> getRandomValue();
    void invoke(T value);
    static <V,T> MapRegistry<V,T> ofMap(ThrowingConsumer<T> invoke) {
        return new SimpleMapRegistry<>(invoke);
    }

    static <V,T> MapRegistry<V,T> ofTreeMap(ThrowingConsumer<T> invoke) {
        return new SimpleTreeMapRegistry<>(invoke);
    }

    static <V,T> SetRegistry<V,T> ofSet(ThrowingConsumer<T> invoke) {
        return new SimpleSetRegistry<>(invoke);
    }
}
