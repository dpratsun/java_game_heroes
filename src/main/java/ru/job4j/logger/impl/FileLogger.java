package ru.job4j.logger.impl;

import ru.job4j.logger.Logger;

import java.io.FileOutputStream;
import java.io.PrintWriter;

public class FileLogger implements Logger {
    public final String file;

    public FileLogger(String file) {
        this.file = file;
    }

    @Override
    public void log(String message) {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(file, true))) {
            pw.println(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
