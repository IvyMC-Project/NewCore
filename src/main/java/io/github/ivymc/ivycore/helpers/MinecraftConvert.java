package io.github.ivymc.ivycore.helpers;

@SuppressWarnings("unused")
public interface MinecraftConvert {
    static net.minecraft.util.Identifier convert(Identifier id) {
        return new net.minecraft.util.Identifier(id.namespace(), id.path());
    }
}
