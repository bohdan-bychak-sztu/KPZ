package task5;

public class EnemyBuilder implements CharacterBuilder {
    protected Character character;

    public EnemyBuilder() {
        this.character = new Character();
        character.setAlignment("Evil");
    }

    public EnemyBuilder doDeed(String deed) {
        character.addDeed("Evil: " + deed);
        return this;
    }

    @Override
    public EnemyBuilder setName(String name) {
        character.setName(name);
        return this;
    }

    @Override
    public EnemyBuilder setHeight(int height) {
        character.setHeight(height);
        return this;
    }

    @Override
    public EnemyBuilder setBodyType(String bodyType) {
        character.setBodyType(bodyType);
        return this;
    }

    @Override
    public EnemyBuilder setHairColor(String hairColor) {
        character.setHairColor(hairColor);
        return this;
    }

    @Override
    public EnemyBuilder setEyeColor(String eyeColor) {
        character.setEyeColor(eyeColor);
        return this;
    }

    @Override
    public EnemyBuilder setClothing(String clothing) {
        character.setClothing(clothing);
        return this;
    }

    @Override
    public EnemyBuilder addItem(String item) {
        character.addItem(item);
        return this;
    }

    @Override
    public Character build() {
        return character;
    }
}
