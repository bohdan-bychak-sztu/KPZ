package task1;

public class Main {
    public static void main(String[] args) {
        SupportHandler level1 = new Level1Support();
        SupportHandler level2 = new Level2Support();
        SupportHandler level3 = new Level3Support();
        SupportHandler level4 = new Level4Support();

        level1.setNextHandler(level2);
        level2.setNextHandler(level3);
        level3.setNextHandler(level4);

        while (true) {
            System.out.println("\n=== Система підтримки користувачів ===");
            boolean handled = level1.handle();
            if (handled) break;
        }

        System.out.println("Дякуємо за звернення!");
    }
}
