package io.github.ivymc.ivycore.test;

import io.github.ivymc.ivycore.events.impl.ModLoadingEvent;

public class Main {
    public static void onInitialize(ModLoadingEvent event) throws InterruptedException {
        if (event.getName().startsWith("testmod")) {
            throw new RuntimeException("failed to load");
        }
    }
}
