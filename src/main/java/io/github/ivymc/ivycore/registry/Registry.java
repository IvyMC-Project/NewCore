package io.github.ivymc.ivycore.registry;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface Registry <K, V> {
    V register(K id, V value);
    V getEntry(K id);

    V getEntryOrDefault(K key, V defaultValue);

    V getDefaultValue();

    Iterable<Map.Entry<K, V>> getEntries();

    List<Map.Entry<K, V>> getListEntries();

    Optional<V> getOptionalEntry(K id);

    Optional<Map.Entry<K,V>> getRandom();

    static <K,V> Registry<K,V> getInstance(Class<K> keyType, V defaultValue) {
        return new SimpleRegistry<>(defaultValue);
    }
}
