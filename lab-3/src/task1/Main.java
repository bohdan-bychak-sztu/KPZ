package task1;

public class Main {
    public static void main(String[] args) {
        Logger consoleLogger = new Logger();
        consoleLogger.log("Це звичайне повідомлення");
        consoleLogger.warn("Це попередження");
        consoleLogger.error("Це помилка");

        Logger fileLogger = new FileLoggerAdapter("log.txt", true);
        fileLogger.log("Файл: звичайне повідомлення");
        fileLogger.warn("Файл: попередження");
        fileLogger.error("Файл: помилка");

        System.out.println("\nФайл логів записано у файл 'log.txt'.");
    }
}
