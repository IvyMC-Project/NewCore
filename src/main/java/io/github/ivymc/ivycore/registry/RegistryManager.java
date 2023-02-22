package io.github.ivymc.ivycore.registry;

import io.github.ivymc.ivycore.PreMain;
import io.github.ivymc.ivycore.events.impl.ConfigEvent;
import io.github.ivymc.ivycore.events.impl.ItemUseEvent;
import io.github.ivymc.ivycore.events.impl.ModLoadingEvent;
import io.github.ivymc.ivycore.utils.ThrowingConsumer;
import oshi.util.tuples.Pair;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

public class RegistryManager {
    private RegistryManager() {
    }

    public static final MapRegistry<
            String,
            ThrowingConsumer<ModLoadingEvent>,
            Iterable<Map.Entry<String, ThrowingConsumer<ModLoadingEvent>>>
            > MOD_REGISTRY = Registry.ofTreeMap(RegistryFunctions::onModLoadingInvoke);

    public static final SetRegistry<
            Consumer<ItemUseEvent>,
            Pair<List<Consumer<ItemUseEvent>>,ItemUseEvent>
            > ITEM_USE_REGISTRY = Registry.ofSet(RegistryFunctions::onItemUseInvoke);

    public static final MapRegistry<
            Pair<ModLoadingEvent, Optional<Class<?>>>,
            ThrowingConsumer<ConfigEvent>,
            Iterable<Map.Entry<Pair<ModLoadingEvent, Optional<Class<?>>>, ThrowingConsumer<ConfigEvent>>>
            > CONFIG_REGISTRY = Registry.ofMap(RegistryFunctions::onConfigInvoke);
}