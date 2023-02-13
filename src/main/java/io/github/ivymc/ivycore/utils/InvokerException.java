package io.github.ivymc.ivycore.utils;

import io.github.ivymc.ivycore.events.impl.ModLoadingEvent;

public class InvokerException extends RuntimeException {
    public InvokerException(ModLoadingEvent modLoadingEvent, String message) {
        super(message, new Throwable(modLoadingEvent.name()));
    }

}
