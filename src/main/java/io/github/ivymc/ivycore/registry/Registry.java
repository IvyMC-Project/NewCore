package io.github.ivymc.ivycore.registry;

import io.github.ivymc.ivycore.helpers.ThrowingConsumer;

import java.util.List;
import java.util.Optional;

public interface Registry <V,T> {
    Iterable<V> getValues();
    List<V> getListValues();
    Optional<V> getRandomValue();
    void invoke(T value);
    static <V,T> HashRegistry<V,T> ofHash(ThrowingConsumer<T> invoke) {
        return new SimpleHashRegistry<>(invoke);
    }

    static <V,T> SetRegistry<V,T> ofSet(ThrowingConsumer<T> invoke) {
        return new SimpleSetRegistry<>(invoke);
    }
}
