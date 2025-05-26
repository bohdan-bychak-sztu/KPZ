package task1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterWrapper {
    private final String filePath;
    private final boolean append;

    public FileWriterWrapper(String filePath, boolean append) {
        this.filePath = filePath;
        this.append = append;
    }

    public void write(String text) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, append))) {
            writer.write(text);
        }
    }

    public void writeLine(String text) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, append))) {
            writer.write(text);
            writer.newLine();
        }
    }
}
