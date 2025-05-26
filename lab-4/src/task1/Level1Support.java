package task1;

import java.util.Scanner;

class Level1Support extends SupportHandler {
    public boolean handle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Чи маєте питання про оплату? (так/ні)");
        String input = scanner.nextLine().trim().toLowerCase();

        if (input.equals("так")) {
            System.out.println("Level 1: Вас з'єднано з відділом фінансів.");
            return true;
        } else if (nextHandler != null) {
            return nextHandler.handle();
        }
        return false;
    }
}
