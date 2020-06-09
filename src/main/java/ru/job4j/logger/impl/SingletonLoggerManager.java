package ru.job4j.logger.impl;

import ru.job4j.logger.Logger;
import ru.job4j.logger.LoggerManager;

import java.util.ArrayList;
import java.util.List;

public class SingletonLoggerManager implements LoggerManager {
    private final List<Logger> listeners = new ArrayList<>();

    private SingletonLoggerManager() { }

    private static class Holder {
        private final static SingletonLoggerManager instance = new SingletonLoggerManager();
    }

    public static LoggerManager getInstance() {
        return Holder.instance;
    }

    @Override
    public void subscribe(Logger logger) {
        listeners.add(logger);
    }

    @Override
    public void log(String message) {
        listeners.forEach(l -> l.log(message));
    }
}
