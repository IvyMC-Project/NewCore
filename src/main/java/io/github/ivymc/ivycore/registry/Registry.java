package io.github.ivymc.ivycore.registry;

import io.github.ivymc.ivycore.utils.ListHelper;
import io.github.ivymc.ivycore.utils.ThrowingConsumer;
import io.github.ivymc.ivycore.registry.impl.SimpleMapRegistry;
import io.github.ivymc.ivycore.registry.impl.SimpleSetRegistry;
import io.github.ivymc.ivycore.registry.impl.SimpleTreeMapRegistry;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;

@SuppressWarnings("unused")
public interface Registry <V,T> {
    List<V> getListValues();

    void invoke(T value);

    default Optional<V> getRandomValue() {
        return ListHelper.getRandomOrEmpty(getListValues());
    }

    default Iterable<V> getValues() {
        return Set.copyOf(getListValues());
    }

    static <K extends Comparable<?>,
            V extends Consumer<?>,
            T
            > MapRegistry<K,V,T> ofTreeMap(ThrowingConsumer<T> invoke) {
        return new SimpleTreeMapRegistry<>(invoke);
    }

    static <V extends Consumer<?>,T> SetRegistry<V,T> ofSet(ThrowingConsumer<T> invoke) {
        return new SimpleSetRegistry<>(invoke);
    }

    static <
            K extends Comparable<?>,
            V extends Consumer<?>,
            T
            > MapRegistry<K,V,T> ofMap(ThrowingConsumer<T> invoke) {
        return new SimpleMapRegistry<>(invoke);
    }
}
