package io.github.ivymc.ivycore.registry;

import io.github.ivymc.ivycore.PreMain;
import io.github.ivymc.ivycore.events.impl.ItemUseEvent;
import io.github.ivymc.ivycore.events.impl.ModLoadingEvent;
import io.github.ivymc.ivycore.utils.Global;
import io.github.ivymc.ivycore.utils.ThrowingConsumer;
import oshi.util.tuples.Pair;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class RegistryManager {
    private RegistryManager() {}
    public static final MapRegistry<
            String,
            ThrowingConsumer<ModLoadingEvent>,
            Iterable<Map.Entry<String, ThrowingConsumer<ModLoadingEvent>>>
        > MOD_REGISTRY = Registry.ofTreeMap(entries -> {
            PreMain.g.getLogger().info("Loading mods...");
            for (var entry : entries) {
            var key = entry.getKey();
            try {
                entry.getValue().acceptThrows(new ModLoadingEvent(new Global(key)));
                PreMain.g.getLogger().info("Loaded mod: " + key);
            } catch (Exception err) {
                PreMain.g.getLogger().error("Failed to load mod: " + key);
                err.printStackTrace();
            }
        }
    });

    public static final SetRegistry<
            Consumer<ItemUseEvent>,
            Pair<List<Consumer<ItemUseEvent>>,ItemUseEvent>
        > ITEM_USE_REGISTRY = Registry.ofSet(pair -> {
            var entries = pair.getA();
            var itemEvent = pair.getB();

            for (var entry : entries) {
                entry.accept(itemEvent);
            }
    });
}