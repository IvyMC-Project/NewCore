package io.github.ivymc.ivycore;

import io.github.ivymc.ivycore.helpers.Global;
import io.github.ivymc.ivycore.registry.RegistryManager;
import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;

public class PreMain implements PreLaunchEntrypoint {
    public static Global g = new Global("ivycore");
    @Override
    public void onPreLaunch() {
        RegistryManager.MOD_REGISTRY.register("ivycore", (event) -> {
            var g = event.getGlobal();
            g.getLogger().info("Hello, world!");
        });

        RegistryManager.MOD_REGISTRY.register("ivycore", (event) -> {
            var g = event.getGlobal();
            g.getLogger().info("Hmmm");
        });
    }
}
