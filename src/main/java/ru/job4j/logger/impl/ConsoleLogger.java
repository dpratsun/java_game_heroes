package ru.job4j.logger.impl;

import ru.job4j.logger.Logger;

public class ConsoleLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println(message);
    }
}
