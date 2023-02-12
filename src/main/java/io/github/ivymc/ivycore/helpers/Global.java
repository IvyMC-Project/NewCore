package io.github.ivymc.ivycore.helpers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("unused")
public record Global(String id) {
    public Identifier idOf(String path) {
        return Identifier.of(id, path);
    }

    public Logger getLogger() {
        return LoggerFactory.getLogger(id);
    }
}
