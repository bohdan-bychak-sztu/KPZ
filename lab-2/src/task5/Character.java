package task5;

import java.util.ArrayList;
import java.util.List;

public class Character {
    private String name;
    private int height;
    private String bodyType;
    private String hairColor;
    private String eyeColor;
    private String clothing;
    private List<String> inventory = new ArrayList<>();
    private List<String> deeds = new ArrayList<>();
    private String alignment;

    public void setName(String name) { this.name = name; }
    public void setHeight(int height) { this.height = height; }
    public void setBodyType(String bodyType) { this.bodyType = bodyType; }
    public void setHairColor(String hairColor) { this.hairColor = hairColor; }
    public void setEyeColor(String eyeColor) { this.eyeColor = eyeColor; }
    public void setClothing(String clothing) { this.clothing = clothing; }
    public void setAlignment(String alignment) { this.alignment = alignment; }

    public void addItem(String item) { inventory.add(item); }
    public void addDeed(String deed) { deeds.add(deed); }

    @Override
    public String toString() {
        return "Character: " + name +
                "\nHeight: " + height + " cm" +
                "\nBody Type: " + bodyType +
                "\nHair Color: " + hairColor +
                "\nEye Color: " + eyeColor +
                "\nClothing: " + clothing +
                "\nAlignment: " + alignment +
                "\nInventory: " + inventory +
                "\nDeeds: " + deeds;
    }
}
