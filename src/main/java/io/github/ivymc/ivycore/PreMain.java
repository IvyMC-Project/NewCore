package io.github.ivymc.ivycore;

import com.llamalad7.mixinextras.MixinExtrasBootstrap;
import io.github.ivymc.ivycore.utils.Global;
import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;

public class PreMain implements PreLaunchEntrypoint {
    public static final Global g = new Global("ivycore");
    @Override
    public void onPreLaunch() {
        MixinExtrasBootstrap.init();
        g.getLogger().info("-------------------------------------------------------------");
        g.getLogger().info("Thanks for installing our mod!");
        g.getLogger().info("Created by IvyMC project");
        g.getLogger().info("Check our other projects at https://github.com/IvyMC-Project/");
        g.getLogger().info("-------------------------------------------------------------");
    }
}
