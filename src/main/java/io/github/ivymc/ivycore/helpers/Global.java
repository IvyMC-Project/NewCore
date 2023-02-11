package io.github.ivymc.ivycore.helpers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("unused")
public class Global {
    private final String id;
    private final Logger logger;

    public Global(String id) {
        this.id = id;
        this.logger = LoggerFactory.getLogger(id);
    }

    public Identifier idOf(String path) {
        return Identifier.of(id, path);
    }

    public Logger getLogger() {
        return logger;
    }
}
