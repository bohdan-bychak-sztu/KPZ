package task2;

public class Main {
    public static void main(String[] args) {
        Hero warrior = new Warrior();
        warrior = new Weapon(warrior);
        warrior = new Armor(warrior);
        warrior = new Artifact(warrior);

        System.out.println("Hero: " + warrior.getDescription());
        System.out.println("Total Power: " + warrior.getPower());

        Hero mage = new Mage();
        mage = new Artifact(mage);
        mage = new Weapon(mage);

        System.out.println("\nHero: " + mage.getDescription());
        System.out.println("Total Power: " + mage.getPower());
    }
}
