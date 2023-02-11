package io.github.ivymc.ivycore.events;

@SuppressWarnings("unused")
public interface Event {
    default Class<? extends Event> getType() {
        return Event.class;
    }
}
