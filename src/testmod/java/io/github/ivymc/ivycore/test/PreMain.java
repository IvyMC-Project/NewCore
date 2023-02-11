package io.github.ivymc.ivycore.test;

import io.github.ivymc.ivycore.registry.RegistryManager;
import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;

public class PreMain implements PreLaunchEntrypoint {
    @Override
    public void onPreLaunch() {
        RegistryManager.MOD_REGISTRY.register("testmod", Main::onInitialize);
    }
}
