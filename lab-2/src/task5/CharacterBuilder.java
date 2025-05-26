package task5;

public interface CharacterBuilder {
    CharacterBuilder setName(String name);
    CharacterBuilder setHeight(int height);
    CharacterBuilder setBodyType(String bodyType);
    CharacterBuilder setHairColor(String hairColor);
    CharacterBuilder setEyeColor(String eyeColor);
    CharacterBuilder setClothing(String clothing);
    CharacterBuilder addItem(String item);
    CharacterBuilder doDeed(String deed);
    Character build();
}
