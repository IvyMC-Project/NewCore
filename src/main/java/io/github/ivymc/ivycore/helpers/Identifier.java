package io.github.ivymc.ivycore.helpers;

import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
public class Identifier implements Comparable<Identifier> {
    private final String namespace;
    private final String path;

    private Identifier(String namespace, String path) {
        this.namespace = namespace;
        this.path = path;
    }

    private Identifier(String path) {
        this.namespace = "ivycore";
        this.path = path;
    }

    public String getNamespace() {
        return namespace;
    }

    public String getPath() {
        return path;
    }

    public String toString() {
        return namespace + ":" + path;
    }

    public static Identifier of(String namespace, String path) {
        return new Identifier(namespace, path);
    }

    public static Identifier of(String path) {
        return new Identifier(path);
    }

    @Override
    public int compareTo(@NotNull Identifier o) {
        return this.toString().compareTo(o.toString());
    }
}
