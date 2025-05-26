package task1;

public class Logger {
    public void log(String message) {
        System.out.println("\u001B[32m[LOG] " + message + "\u001B[0m");
    }

    public void error(String message) {
        System.out.println("\u001B[31m[ERROR] " + message + "\u001B[0m");
    }

    public void warn(String message) {
        System.out.println("\u001B[33m[WARNING] " + message + "\u001B[0m");
    }
}
