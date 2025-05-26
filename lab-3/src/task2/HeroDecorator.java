package task2;

public class HeroDecorator implements Hero {
    protected Hero hero;

    public HeroDecorator(Hero hero) {
        this.hero = hero;
    }

    @Override
    public String getDescription() {
        return hero.getDescription();
    }

    @Override
    public int getPower() {
        return hero.getPower();
    }
}
