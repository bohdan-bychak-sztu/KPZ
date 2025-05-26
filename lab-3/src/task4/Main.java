package task4;

import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        String allowedFile = "example.txt";
        String deniedFile = "secret.txt";

        try (PrintWriter writer = new PrintWriter(allowedFile)) {
            writer.println("Hello");
            writer.println("World!");
        } catch (Exception ignored) {}

        System.out.println("\n=== Using SmartTextChecker ===");
        SmartTextReader checker = new SmartTextChecker();
        try {
            checker.readTextFile(allowedFile);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n=== Using SmartTextReaderLocker ===");
        SmartTextReader locker = new SmartTextReaderLocker(".*secret.*");

        try {
            locker.readTextFile(deniedFile);
            locker.readTextFile(allowedFile);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
