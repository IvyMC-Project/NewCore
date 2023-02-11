package io.github.ivymc.ivycore.test;

import io.github.ivymc.ivycore.events.impl.ModLoadingEvent;
import net.minecraft.util.math.random.Random;

public class Main {
    public static void onInitialize(ModLoadingEvent event) throws InterruptedException {
        if (event.getName().startsWith("testmod" + Random.create().nextInt(100))) {
            throw new RuntimeException("failed to load");
        }
    }
}
