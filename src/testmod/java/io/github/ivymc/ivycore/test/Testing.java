package io.github.ivymc.ivycore.test;

import io.github.ivymc.ivycore.PreMain;
import io.github.ivymc.ivycore.events.impl.ModLoadingEvent;
import io.github.ivymc.ivycore.registry.RegistryManager;
import io.github.ivymc.ivycore.utils.Identifier;
import io.github.ivymc.ivycore.utils.InvokerException;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class Testing {
    private Testing(ModLoadingEvent event) {
        this.event = event;
    }
    public static void onInitialize(ModLoadingEvent event) {
        var test = new Testing(event);

        event.getLogger().warn("Testing...");

        test.utilsTest();
        event.getLogger().warn("Utils test passed");
        RegistryManager.ITEM_USE_REGISTRY.register(e -> {
            var itemStack = e.itemStack();
            event.getLogger().warn("Used item: " + itemStack);
        });
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
    }

    private void eq(Object a, Object b, String message) {
        var bl =  Objects.equals(a, b);
        if (!bl) {
            throw new InvokerException(event,message);
        }
    }

//    private void eqNot(Object a, Object b, String message) {
//        var bl = Objects.equals(a, b);
//        if (bl) {
//            throw new InvokerException(event,message);
//        }
//    }
}
