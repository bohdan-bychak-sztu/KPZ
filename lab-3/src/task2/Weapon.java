package task2;

public class Weapon extends HeroDecorator{
    public Weapon(Hero hero) {
        super(hero);
    }

    @Override
    public String getDescription() {
        return hero.getDescription() + " with Weapon";
    }

    @Override
    public int getPower() {
        return hero.getPower() + 5;
    }
}
