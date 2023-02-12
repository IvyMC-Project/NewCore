package io.github.ivymc.ivycore.test;

import io.github.ivymc.ivycore.events.impl.ModLoadingEvent;
import io.github.ivymc.ivycore.registry.RegistryManager;
import io.github.ivymc.ivycore.utils.Global;
import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;

public class PreMain implements PreLaunchEntrypoint {
    @Override
    public void onPreLaunch() {
        var a = RegistryManager.MOD_REGISTRY.register("testmod", Main::onInitialize);
        try {
            a.accept(new ModLoadingEvent(new Global("testmod")));
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
