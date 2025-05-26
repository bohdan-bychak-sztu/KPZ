package task3;

public final class Core {
    private static Core instance;
    private Core() {
        System.out.println("Core constructor");
    }
    public static synchronized Core getInstance() {
        if (instance == null) {
            instance = new Core();
        }
        return instance;
    }
    public void execute(String command) {
        System.out.println("Executing command: " + command);
    }
}
