package io.github.ivymc.ivycore.registry;

import com.google.gson.JsonObject;
import io.github.ivymc.ivycore.PreMain;
import io.github.ivymc.ivycore.events.impl.ConfigEvent;
import io.github.ivymc.ivycore.events.impl.ItemUseEvent;
import io.github.ivymc.ivycore.events.impl.ModLoadingEvent;
import io.github.ivymc.ivycore.utils.JsonHelper;
import io.github.ivymc.ivycore.utils.ThrowingConsumer;
import net.fabricmc.loader.api.FabricLoader;
import oshi.util.tuples.Pair;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

class RegistryFunctions {
    private RegistryFunctions() {}
    static void onModLoadingInvoke(Iterable<Map.Entry<String, ThrowingConsumer<ModLoadingEvent>>> entries) {
        PreMain.mod.getLogger().info("Loading mods...");
        for (var entry : entries) {
            var key = entry.getKey();
            try {
                entry.getValue().accept(new ModLoadingEvent(key));
                PreMain.mod.getLogger().info("Loaded mod: " + key);
            } catch (Exception err) {
                PreMain.mod.getLogger().error("Failed to load mod: " + key);
                err.printStackTrace();
            }
        }
    }

    static void onItemUseInvoke(Pair<List<Consumer<ItemUseEvent>>, ItemUseEvent> pair) {
        var entries = pair.getA();
        var itemEvent = pair.getB();

        for (var entry : entries) {
            entry.accept(itemEvent);
        }
    }

    public static void onConfigInvoke(Iterable<Map.Entry<Pair<ModLoadingEvent, Optional<Class<?>>>, ThrowingConsumer<ConfigEvent>>> entries) throws Exception {
        var configPath = FabricLoader.getInstance().getConfigDir();
        for (var entry : entries) {
            var modEvent = entry.getKey().getA();
            var defaultClass = entry.getKey().getB();
            var modConfigPath = configPath.resolve(modEvent.name()+".json");
            JsonObject configObject = null;

            if (Files.notExists(modConfigPath)) {
                Files.createFile(modConfigPath);
                if (defaultClass.isPresent()) {
                    configObject = JsonHelper.writeJsonObject(defaultClass.get().getConstructor().newInstance(), modConfigPath);
                } else {
                    PreMain.mod.getLogger().info("No default config found for mod: " + modEvent.name());
                    configObject = JsonHelper.writeJsonObject(new JsonObject(), modConfigPath);
                }
            }

            if (configObject == null) {
                configObject = JsonHelper.readJsonObject(modConfigPath);
            }

            entry.getValue().accept(new ConfigEvent(configObject));
        }
    }
}
