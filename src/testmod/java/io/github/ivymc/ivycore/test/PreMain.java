package io.github.ivymc.ivycore.test;

import io.github.ivymc.ivycore.helpers.Identifier;
import io.github.ivymc.ivycore.registry.RegistryManager;
import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;

import java.util.TreeMap;

public class PreMain implements PreLaunchEntrypoint {
    private static final int AMOUNT = 1000;
    @Override
    public void onPreLaunch() {
        for (int i = 0; i < AMOUNT; i++) {
            RegistryManager.MOD_REGISTRY.register(Identifier.of("testmod" + i), Main::onInitialize);
        }
    }
}
