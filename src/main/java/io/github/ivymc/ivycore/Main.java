package io.github.ivymc.ivycore;

import io.github.ivymc.ivycore.registry.RegistryManager;
import net.fabricmc.api.ModInitializer;

import java.util.HashSet;
import java.util.Set;

public class Main implements ModInitializer {
    @Override
    public void onInitialize() {
        loadMods();
    }

    private void loadMods() {
        RegistryManager.MOD_REGISTRY.invoke(RegistryManager.MOD_REGISTRY.getEntries());
    }
}
