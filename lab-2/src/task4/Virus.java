package task4;

import java.util.ArrayList;
import java.util.List;

public class Virus implements Cloneable {
    private double weight;
    private int age;
    private String name;
    private String type;
    private List<Virus> children;

    public Virus(double weight, int age, String name, String type) {
        this.weight = weight;
        this.age = age;
        this.name = name;
        this.type = type;
        this.children = new ArrayList<Virus>();
    }

    public void addChild(Virus child) {
        children.add(child);
    }

    public List<Virus> getChildren() {
        return children;
    }

    @Override
    protected Virus clone() throws CloneNotSupportedException {
        try {
            Virus clone = (Virus) super.clone();
            clone.children = new ArrayList<Virus>();
            for (Virus child : children) {
                clone.addChild(child.clone());
            }
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new CloneNotSupportedException();
        }
    }

    public void print(String indent) {
        System.out.println(indent + "Ім'я: " + name + ", Вага: " + weight + ", Вік: " + age + ", Вид: " + type);
        for (Virus child : children) {
            child.print(indent + "  ");
        }
    }

    public void print() {
        print("");
    }
}