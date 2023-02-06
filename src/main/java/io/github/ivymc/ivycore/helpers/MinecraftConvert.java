package io.github.ivymc.ivycore.helpers;

public interface MinecraftConvert {
    static net.minecraft.util.Identifier convert(Identifier id) {
        return new net.minecraft.util.Identifier(id.getNamespace(), id.getPath());
    }
}
