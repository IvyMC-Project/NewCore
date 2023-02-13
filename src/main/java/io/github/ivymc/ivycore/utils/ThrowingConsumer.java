package io.github.ivymc.ivycore.utils;

import java.util.function.Consumer;

@FunctionalInterface
public interface ThrowingConsumer<T> extends Consumer<T> {

    @Override
    default void accept(final T elem) {
        acceptThrows(elem);
    }

    void acceptThrows(T elem) throws InvokerException;

    static <T> ThrowingConsumer<T> getDefault() {
        return c -> {};
    }
}