package io.github.ivymc.ivycore.test;

import io.github.ivymc.ivycore.events.impl.ModLoadingEvent;

public class Main {
    public static void onInitialize(ModLoadingEvent event) {
        System.out.println("Hello Fabric world!");
//        if (event.global().id().startsWith("testmod" + Random.create().nextInt(100))) {
//            throw new RuntimeException("failed to load");
//        }
    }
}
