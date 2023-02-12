package io.github.ivymc.ivycore.test;

import io.github.ivymc.ivycore.events.impl.ModLoadingEvent;
import io.github.ivymc.ivycore.registry.RegistryManager;

import java.util.Arrays;

public class Main {
    private Main() {}
    public static void onInitialize(ModLoadingEvent event) {
        event.global().getLogger().info("Hello Fabric world!");
        var list = RegistryManager.MOD_REGISTRY.getListValues();
        event.global().getLogger().info(Arrays.deepToString(list.toArray()));
    }
}
