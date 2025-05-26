package task2;

public class Warrior implements Hero {
    @Override
    public String getDescription() {
        return "Warrior";
    }

    @Override
    public int getPower() {
        return 10;
    }
}
