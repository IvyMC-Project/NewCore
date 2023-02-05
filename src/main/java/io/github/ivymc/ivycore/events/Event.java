package io.github.ivymc.ivycore.events;

public interface Event {
    default Class<? extends Event> getType() {
        return Event.class;
    }
}
