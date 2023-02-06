package io.github.ivymc.ivycore.test;

import io.github.ivymc.ivycore.helpers.Identifier;
import io.github.ivymc.ivycore.registry.RegistryManager;
import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;

public class PreMain implements PreLaunchEntrypoint {
    @Override
    public void onPreLaunch() {
        RegistryManager.MOD_REGISTRY.register(Identifier.of("test"), Main::onInitialize);
        RegistryManager.MOD_REGISTRY.register(Identifier.of("test1"), Main::onInitialize);
        RegistryManager.MOD_REGISTRY.register(Identifier.of("test2"), Main::onInitialize);
    }
}
