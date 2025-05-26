package task4;

import java.io.IOException;
import java.util.regex.Pattern;

public class SmartTextReaderLocker extends SmartTextReader {
    private final Pattern denyPattern;

    public SmartTextReaderLocker(String regex) {
        this.denyPattern = Pattern.compile(regex);
    }

    @Override
    public char[][] readTextFile(String filename) throws IOException {
        if (denyPattern.matcher(filename).matches()) {
            System.out.println("Access denied!");
            return new char[0][0];
        } else {
            return super.readTextFile(filename);
        }
    }
}
