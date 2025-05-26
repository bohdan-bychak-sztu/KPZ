package task1;

import java.util.Scanner;

class Level4Support extends SupportHandler {
    public boolean handle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("4. Чи маєте загальне питання? (так/ні)");
        String input = scanner.nextLine().trim().toLowerCase();

        if (input.equals("так")) {
            System.out.println("Level 4: Вас з'єднано з оператором загальної підтримки.");
            return true;
        } else {
            System.out.println("Не вдалося знайти відповідного оператора. Повторимо спробу.");
            return false;
        }
    }
}
