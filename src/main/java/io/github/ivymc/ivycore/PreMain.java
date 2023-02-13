package io.github.ivymc.ivycore;

import com.llamalad7.mixinextras.MixinExtrasBootstrap;
import io.github.ivymc.ivycore.events.impl.ModLoadingEvent;
import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;

public class PreMain implements PreLaunchEntrypoint {
    public static final ModLoadingEvent mod = new ModLoadingEvent("ivycore");
    @Override
    public void onPreLaunch() {
        MixinExtrasBootstrap.init();
        mod.getLogger().info("-------------------------------------------------------------");
        mod.getLogger().info("Thanks for installing our mod!");
        mod.getLogger().info("Created by IvyMC project");
        mod.getLogger().info("Check our other projects at https://github.com/IvyMC-Project/");
        mod.getLogger().info("-------------------------------------------------------------");
    }
}
