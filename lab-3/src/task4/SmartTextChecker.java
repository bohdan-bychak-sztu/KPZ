package task4;

import javax.swing.*;
import java.io.IOException;

public class SmartTextChecker extends SmartTextReader {
    @Override
    public char[][] readTextFile(String filename) throws IOException {
        System.out.println("Opening file: " + filename);

        char[][] data = super.readTextFile(filename);

        System.out.println("Successfully read file: " + filename);
        System.out.println("Closing file: " + filename);

        int linesCount = data.length;
        int charCount = 0;
        for (char[] line : data) {
            charCount += line.length;
        }

        System.out.println("Total lines: " + linesCount);
        System.out.println("Total characters: " + charCount);

        return data;
    }
}
