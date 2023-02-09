package io.github.ivymc.ivycore.registry;

import io.github.ivymc.ivycore.helpers.Identifier;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface MapRegistry<V, T> extends Registry<V, T> {
    V register(Identifier id, V value);
    V getEntry(Identifier id);

    V getEntryOrDefault(Identifier key, V defaultValue);

    Iterable<Map.Entry<Identifier, V>> getEntries();

    List<Map.Entry<Identifier, V>> getListEntries();

    Optional<V> getOptionalEntry(Identifier id);

    Optional<Map.Entry<Identifier,V>> getRandomEntry();
}
