package task5;

public class HeroBuilder implements CharacterBuilder {
    protected Character character;

    public HeroBuilder() {
        this.character = new Character();
        character.setAlignment("Good");
    }

    public HeroBuilder doDeed(String deed) {
        character.addDeed("Good: " + deed);
        return this;
    }

    @Override
    public HeroBuilder setName(String name) {
        character.setName(name);
        return this;
    }

    @Override
    public HeroBuilder setHeight(int height) {
        character.setHeight(height);
        return this;
    }

    @Override
    public HeroBuilder setBodyType(String bodyType) {
        character.setBodyType(bodyType);
        return this;
    }

    @Override
    public HeroBuilder setHairColor(String hairColor) {
        character.setHairColor(hairColor);
        return this;
    }

    @Override
    public HeroBuilder setEyeColor(String eyeColor) {
        character.setEyeColor(eyeColor);
        return this;
    }

    @Override
    public HeroBuilder setClothing(String clothing) {
        character.setClothing(clothing);
        return this;
    }

    @Override
    public HeroBuilder addItem(String item) {
        character.addItem(item);
        return this;
    }

    @Override
    public Character build() {
        return character;
    }
}
