package io.github.ivymc.ivycore.events.impl;

import io.github.ivymc.ivycore.events.Event;
import io.github.ivymc.ivycore.utils.Global;

public record ModLoadingEvent(Global global) implements Event {
    @Override
    public Class<? extends Event> getType() {
        return ModLoadingEvent.class;
    }
}
