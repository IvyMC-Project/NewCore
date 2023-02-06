package io.github.ivymc.ivycore.registry;

import io.github.ivymc.ivycore.PreMain;
import io.github.ivymc.ivycore.events.ModLoadingEvent;
import io.github.ivymc.ivycore.helpers.Identifier;
import io.github.ivymc.ivycore.helpers.ThrowingConsumer;

import java.util.Map;

public class RegistryManager {
    public static final HashRegistry<ThrowingConsumer<ModLoadingEvent>, Iterable<Map.Entry<Identifier, ThrowingConsumer<ModLoadingEvent>>>> MOD_REGISTRY = new SimpleHashRegistry<>((entries) -> {
        for (var entry : entries) {
            var key = entry.getKey().toString();
            try {
                entry.getValue().acceptThrows(new ModLoadingEvent(key));
                PreMain.g.getLogger().info("Loaded mod: " + key);
            } catch (Exception err) {
                PreMain.g.getLogger().error("Failed to load mod: " + key);
                err.printStackTrace();
            }
        }
    });
}
