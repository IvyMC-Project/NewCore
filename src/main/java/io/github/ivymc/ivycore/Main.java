package io.github.ivymc.ivycore;

import io.github.ivymc.ivycore.registry.RegistryManager;
import net.fabricmc.api.ModInitializer;

public class Main implements ModInitializer {
    @Override
    public void onInitialize() {
        PreMain.g.getLogger().info("Loading mods...");
        loadMods();
    }

    private void loadMods() {
        RegistryManager.MOD_REGISTRY.invoke(RegistryManager.MOD_REGISTRY.getEntries());
    }
}
