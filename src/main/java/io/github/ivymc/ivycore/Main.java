package io.github.ivymc.ivycore;

import io.github.ivymc.ivycore.events.ModLoadingEvent;
import io.github.ivymc.ivycore.registry.RegistryManager;
import net.fabricmc.api.ModInitializer;

public class Main implements ModInitializer {
    @Override
    public void onInitialize() {
        PreMain.g.getLogger().info("Loading mods...");
        loadMods();
    }

    private void loadMods() {
        for (var entry : RegistryManager.MOD_REGISTRY.getEntries()) {
            var key = entry.getKey();
            try {
                PreMain.g.getLogger().info("Loaded mod: " + key);
                entry.getValue().acceptThrows(new ModLoadingEvent(key));
            } catch (Exception err) {
                PreMain.g.getLogger().error("Failed to load mod: " + key + "\n" + err.getMessage());
            }
        }
    }
}
