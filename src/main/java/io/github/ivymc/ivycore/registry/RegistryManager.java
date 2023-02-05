package io.github.ivymc.ivycore.registry;

import io.github.ivymc.ivycore.events.ModLoadingEvent;
import io.github.ivymc.ivycore.helpers.ThrowingConsumer;

public class RegistryManager {
    public static final Registry<String, ThrowingConsumer<ModLoadingEvent>> MOD_REGISTRY = new SimpleRegistry<>(ThrowingConsumer.getDefault(ModLoadingEvent.class));
}
