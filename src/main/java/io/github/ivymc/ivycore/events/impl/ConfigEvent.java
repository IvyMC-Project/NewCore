package io.github.ivymc.ivycore.events.impl;

import com.google.gson.JsonObject;
import io.github.ivymc.ivycore.events.Event;

public record ConfigEvent(JsonObject config) implements Event {
    @Override
    public Class<ConfigEvent> getType() {
        return ConfigEvent.class;
    }
}
