package io.github.ivymc.ivycore.helpers;

import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
public record Identifier(String namespace, String path) implements Comparable<Identifier> {
    @Override
    public String toString() {
        return namespace + ":" + path;
    }

    public static Identifier of(String namespace, String path) {
        return new Identifier(namespace, path);
    }

    public static Identifier of(String path) {
        return new Identifier("ivycore",path);
    }

    @Override
    public int compareTo(@NotNull Identifier o) {
        return equals(o) ? 0 : toString().compareTo(o.toString());
    }
}
