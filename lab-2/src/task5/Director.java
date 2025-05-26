package task5;

public class Director {
    private CharacterBuilder characterBuilder;
    public Director(CharacterBuilder characterBuilder) {
        this.characterBuilder = characterBuilder;
    }

    public void changeCharacterBuilder(CharacterBuilder characterBuilder) {
        this.characterBuilder = characterBuilder;
    }

    public Character createDreamHero() {
        return characterBuilder
                .setName("Huo Yuhao")
                .setHeight(172)
                .setBodyType("Slim")
                .setHairColor("Dark Blue")
                .setEyeColor("Spirit Ice Blue")
                .setClothing("Shrek Academy Uniform")
                .addItem("Spirit Eyes")
                .addItem("Tang Sect Hidden Weapons")
                .doDeed("Mastered the Spirit Detection ability")
                .doDeed("Fought to protect Shrek Academy")
                .build();
    }

    public Character createUltimateEnemy() {
        return characterBuilder
                .setName("President Snow")
                .setHeight(180)
                .setBodyType("Thin")
                .setHairColor("White")
                .setEyeColor("Cold Blue")
                .setClothing("White Rose Suit")
                .addItem("Poisoned White Rose")
                .addItem("Symbol of the Capitol")
                .doDeed("Manipulated the Hunger Games")
                .doDeed("Ordered mass oppression of districts")
                .build();
    }
}
