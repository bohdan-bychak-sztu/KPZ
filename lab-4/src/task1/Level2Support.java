package task1;

import java.util.Scanner;

class Level2Support extends SupportHandler {
    public boolean handle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("2. Чи маєте технічні проблеми? (так/ні)");
        String input = scanner.nextLine().trim().toLowerCase();

        if (input.equals("так")) {
            System.out.println("Level 2: Вас з'єднано з техпідтримкою.");
            return true;
        } else if (nextHandler != null) {
            return nextHandler.handle();
        }
        return false;
    }
}
