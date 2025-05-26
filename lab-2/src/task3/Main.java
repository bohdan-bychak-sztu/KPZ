package task3;

public class Main {
    public static void main(String[] args) {
        Runnable task = () -> {
            Core core = Core.getInstance();
            core.execute(Thread.currentThread().getName());
        };

        Thread t1 = new Thread(task, "Command-1");
        Thread t2 = new Thread(task, "Command-2");
        Thread t3 = new Thread(task, "Command-3");

        t1.start();
        t2.start();
        t3.start();
    }
}
