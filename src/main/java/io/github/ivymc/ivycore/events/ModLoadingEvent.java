package io.github.ivymc.ivycore.events;

import io.github.ivymc.ivycore.helpers.Global;

public class ModLoadingEvent implements Event {
    private final String name;
    private final Global g;

    public ModLoadingEvent(String name) {
        this.name = name;
        this.g = new Global(name);
    }
    @Override
    public Class<? extends Event> getType() {
        return ModLoadingEvent.class;
    }

    public Global getGlobal() {
        return g;
    }

    public String getName() {
        return name;
    }
}
