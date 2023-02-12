package io.github.ivymc.ivycore.registry;

import io.github.ivymc.ivycore.utils.ListHelper;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@SuppressWarnings("unused")
public interface MapRegistry<K extends Comparable<?>, V, T> extends Registry<V, T> {
    V register(K id, V value);
    V getEntry(K id);

    V getEntryOrDefault(K key, V defaultValue);

    List<Map.Entry<K, V>> getListEntries();

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
