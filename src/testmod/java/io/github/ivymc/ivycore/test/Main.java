package io.github.ivymc.ivycore.test;

import io.github.ivymc.ivycore.events.ModLoadingEvent;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;

public class Main {
    public static void onInitialize(ModLoadingEvent event) {
        event.getGlobal().getLogger().info("Testing");
        ServerLifecycleEvents.SERVER_STARTED.register((server) -> event.getGlobal().getLogger().info("Server started"));
    }
}
