package io.github.ivymc.ivycore.registry;

import io.github.ivymc.ivycore.utils.ListHelper;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * @param <K> Key type (must be comparable)
 * @param <V> Value type
 * @param <T> Invoke argument type
 */
public interface MapRegistry<
        K,
        V,
        T
        > extends Registry<V, T> {
    V register(K id, V value);
    V getEntry(K id);

    List<Map.Entry<K, V>> getListEntries();

    default V getEntryOrDefault(K key, V defaultValue) {
        return getOptionalEntry(key).orElse(defaultValue);
    }

    default Optional<V> getOptionalEntry(K id) {
        return Optional.ofNullable(getEntry(id));
    }

    default Optional<Map.Entry<K,V>> getRandomEntry() {
        return ListHelper.getRandomOrEmpty(getListEntries());
    }

    default Iterable<Map.Entry<K, V>> getEntries() {
        return Set.copyOf(getListEntries());
    }
}
