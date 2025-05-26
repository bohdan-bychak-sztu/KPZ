package task1;

import java.util.Scanner;

class Level3Support extends SupportHandler {
    public boolean handle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("3. Чи маєте питання щодо підключення послуг? (так/ні)");
        String input = scanner.nextLine().trim().toLowerCase();

        if (input.equals("так")) {
            System.out.println("Level 3: Вас з'єднано з менеджером по підключенню послуг.");
            return true;
        } else if (nextHandler != null) {
            return nextHandler.handle();
        }
        return false;
    }
}
