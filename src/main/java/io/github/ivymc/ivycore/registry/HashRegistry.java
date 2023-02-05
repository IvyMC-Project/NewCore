package io.github.ivymc.ivycore.registry;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface HashRegistry<K, V, T> extends Registry<V, T> {
    V register(K id, V value);
    V getEntry(K id);

    V getEntryOrDefault(K key, V defaultValue);

    Iterable<Map.Entry<K, V>> getEntries();

    List<Map.Entry<K, V>> getListEntries();

    Optional<V> getOptionalEntry(K id);

    Optional<Map.Entry<K,V>> getRandomEntry();
}
