package task2;

public class Armor extends HeroDecorator{
    public Armor(Hero hero) {
        super(hero);
    }

    @Override
    public String getDescription() {
        return hero.getDescription() + " with Armor";
    }

    @Override
    public int getPower() {
        return hero.getPower() + 3;
    }
}
