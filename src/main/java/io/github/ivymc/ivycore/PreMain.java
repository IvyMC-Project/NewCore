package io.github.ivymc.ivycore;

import io.github.ivymc.ivycore.helpers.Global;
import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;

public class PreMain implements PreLaunchEntrypoint {
    public static final Global g = new Global("ivycore");
    @Override
    public void onPreLaunch() {
        g.getLogger().info("-------------------------------------------------------------");
        g.getLogger().info("Thanks for installing our mod!");
        g.getLogger().info("Created by IvyMC project");
        g.getLogger().info("Check our other projects at https://github.com/IvyMC-Project/");
        g.getLogger().info("-------------------------------------------------------------");
    }
}
