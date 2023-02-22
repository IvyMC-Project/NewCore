package io.github.ivymc.ivycore.test;

import io.github.ivymc.ivycore.PreMain;
import io.github.ivymc.ivycore.events.impl.ModLoadingEvent;
import io.github.ivymc.ivycore.registry.MapRegistry;
import io.github.ivymc.ivycore.registry.Registry;
import io.github.ivymc.ivycore.registry.RegistryManager;
import io.github.ivymc.ivycore.utils.Identifier;
import io.github.ivymc.ivycore.utils.InvokerException;
import io.github.ivymc.ivycore.utils.ThrowingConsumer;
import org.slf4j.LoggerFactory;
import oshi.util.tuples.Pair;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

public class Testing {
    private Testing(ModLoadingEvent event) {
        this.event = event;
    }
    public static void onInitialize(ModLoadingEvent event) {
        RegistryManager.ITEM_USE_REGISTRY.register(e -> {
            var itemStack = e.itemStack();
            event.getLogger().warn("Used item: " + itemStack);
        });
        RegistryManager.CONFIG_REGISTRY.register(new Pair<>(event, Optional.of(TestClass.class)), e -> {
            var config = e.config();
            event.getLogger().warn("Config: " + config);
        });
        var test = new Testing(event);

        event.getLogger().warn("Testing...");
        test.utilsTest();
        event.getLogger().warn("Utils test passed");
        test.registryTest();
        event.getLogger().warn("Registry test passed");
    }

    private final ModLoadingEvent event;

    private void utilsTest() {
        final var name = event.name();
        final var ivycore = PreMain.mod.name();
        eq(
                event.getLogger(),
                LoggerFactory.getLogger(name),
                "Logger is not the same"
        );
        eq(
                event.idOf("test"),
                Identifier.of(name, "test"),
                "Test mod identifier is not the same"
        );
        eq(
                Identifier.of(ivycore, "test"),
                Identifier.of("test"),
                "Default identifier is not the same"
        );
        eq(
                Identifier.of(ivycore, "test").toMinecraft(),
                new net.minecraft.util.Identifier("ivycore", "test"),
                "Minecraft converted identifier is not the same"
        );
        eq(
                ThrowingConsumer.getDefault(),
                ThrowingConsumer.getDefault(),
                "Default ThrowingConsumer is not the same"
        );
    }

    private void registryTest() {
        final var name = event.name();
        var mapRegistry = RegistryManager.MOD_REGISTRY;
        var setRegistry = RegistryManager.ITEM_USE_REGISTRY;
        MapRegistry<
                String, Consumer<String>, Iterable<Map.Entry<String, Consumer<String>>>
                > map = Registry.ofMap(entries -> {
            for (var entry : entries) {
                entry.getValue().accept(entry.getKey());
            }
        });

        map.register("test", str -> eq(str, "test", "String is not \"test\""));
        map.register("test2", str -> notEq(str, "test0", "String is \"test2\""));

        eq(
                mapRegistry.getEntry("null"),
                null,
                "Map registry getEntry(\"null\") is not null"
        );
        notEq(
                mapRegistry.getEntry(name),
                null,
                "Map registry getEntry(\"testmod\") is null"
        );
        eq(
                mapRegistry.getEntryOrDefault("null", ThrowingConsumer.getDefault()),
                ThrowingConsumer.getDefault(),
                "Map registry getEntryOrDefault(\"null\") is not default"
        );
        eq(
                mapRegistry.getEntryOrDefault(name, ThrowingConsumer.getDefault()),
                mapRegistry.getEntry(name),
                "Map registry getEntryOrDefault(\"testmod\") is null"
        );
        eq(
                mapRegistry.getOptionalEntry("null"),
                Optional.empty(),
                "Map registry getEntryOrDefault(\"null\") is not default"
        );
        eq(
                mapRegistry.getOptionalEntry(name),
                Optional.of(mapRegistry.getEntry(name)),
                "Map registry getEntry(\"testmod\") is null"
        );
        notEq(
                mapRegistry.getRandomEntry(),
                Optional.empty(),
                "Map registry getRandomEntry() is empty"
        );
        notEq(
                setRegistry.getRandomValue(),
                Optional.empty(),
                "Set registry getRandomValue() is empty"
        );
        notEq(
                setRegistry.getValues(),
                null,
                "Set registry getValues() is null"
        );
        map.invoke(map.getEntries());
    }

    private <T> void eq(T a, T b, String message) {
        var bl =  Objects.equals(a, b);
        if (!bl) {
            throw new InvokerException(event,message);
        }
    }

    private <T> void notEq(T a, T b, String message) {
        var bl =  Objects.equals(a, b);
        if (bl) {
            throw new InvokerException(event,message);
        }
    }
}