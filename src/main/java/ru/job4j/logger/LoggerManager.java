package ru.job4j.logger;

public interface LoggerManager {
    void subscribe(Logger logger);
    void log(String message);
}
