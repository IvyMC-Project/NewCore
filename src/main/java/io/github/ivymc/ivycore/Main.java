package io.github.ivymc.ivycore;

import io.github.ivymc.ivycore.registry.RegistryManager;
import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.vehicle.BoatEntity;

public class Main implements ModInitializer {
    @Override
    public void onInitialize() {
        RegistryManager.MOD_REGISTRY.invoke(RegistryManager.MOD_REGISTRY.getEntries());
        RegistryManager.CONFIG_REGISTRY.invoke(RegistryManager.CONFIG_REGISTRY.getEntries());
    }
}
