package io.github.ivymc.ivycore;

import com.llamalad7.mixinextras.MixinExtrasBootstrap;
import io.github.ivymc.ivycore.events.impl.ModLoadingEvent;
import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;

public class PreMain implements PreLaunchEntrypoint {
    public static final ModLoadingEvent mod = new ModLoadingEvent("ivycore");

    private static final String[] LOGO = {
            "\u001b[35m╔══════════════════════════════════════════════════════════════╗",
            "\u001b[35m║                Thanks for installing our mod!                ║",
            "\u001b[35m║                   Created by IvyMC project                   ║",
            "\u001b[35m║ Check our other projects at https://github.com/IvyMC-Project ║",
            "\u001b[35m╚══════════════════════════════════════════════════════════════╝"
    };
    @Override
    public void onPreLaunch() {
        MixinExtrasBootstrap.init();
        for (String s : LOGO) {
            mod.getLogger().info(s);
        }
    }
}
