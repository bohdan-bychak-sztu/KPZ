package task2;

public class Artifact extends HeroDecorator {
    public Artifact(Hero hero) {
        super(hero);
    }

    @Override
    public String getDescription() {
        return hero.getDescription() + " with Artifact";
    }

    @Override
    public int getPower() {
        return hero.getPower() + 7;
    }
}
