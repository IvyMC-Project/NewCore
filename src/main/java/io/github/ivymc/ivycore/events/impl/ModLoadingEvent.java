package io.github.ivymc.ivycore.events.impl;

import io.github.ivymc.ivycore.events.Event;
import io.github.ivymc.ivycore.utils.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public record ModLoadingEvent(String name) implements Event {
    @Override
    public Class<ModLoadingEvent> getType() {
        return ModLoadingEvent.class;
    }

    public Identifier idOf(String path) {
        return Identifier.of(name, path);
    }

    public Logger getLogger() {
        return LoggerFactory.getLogger(name);
    }
}
