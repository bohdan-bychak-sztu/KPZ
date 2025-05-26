package task1;

import java.io.FileWriter;
import java.io.IOException;

public class FileLoggerAdapter extends Logger {
    private final FileWriterWrapper fileWriter;

    public FileLoggerAdapter(String filePath, boolean append) {
        this.fileWriter = new FileWriterWrapper(filePath, append);
    }

    @Override
    public void log(String message) {
        try {
            fileWriter.writeLine("[LOG] " + message);
        } catch (IOException e) {
            System.out.println("Помилка при записі логів: " + e.getMessage());
        }
    }

    @Override
    public void error(String message) {
        try {
            fileWriter.writeLine("[ERROR] " + message);
        } catch (IOException e) {
            System.out.println("Помилка при записі логів: " + e.getMessage());
        }
    }

    @Override
    public void warn(String message) {
        try {
            fileWriter.writeLine("[WARNING] " + message);
        } catch (IOException e) {
            System.out.println("Помилка при записі логів: " + e.getMessage());
        }
    }
}
