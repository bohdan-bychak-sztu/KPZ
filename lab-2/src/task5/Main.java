package task5;

public class Main {
    public static void main(String[] args) {
        Director director = new Director(new HeroBuilder());
        Character hero = director.createDreamHero();
        director.changeCharacterBuilder(new EnemyBuilder());
        Character enemy = director.createUltimateEnemy();

        System.out.println("=== Hero ===");
        System.out.println(hero);
        System.out.println("\n=== Enemy ===");
        System.out.println(enemy);
    }
}
