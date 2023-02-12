package io.github.ivymc.ivycore.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public record Global(String id) {
    public Identifier idOf(String path) {
        return Identifier.of(id, path);
    }

    public Logger getLogger() {
        return LoggerFactory.getLogger(id);
    }
}
