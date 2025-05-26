package task4;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Virus grandParent = new Virus(0.8, 5, "Alpha", "RNA");
        Virus parent1 = new Virus(0.5, 3, "Beta", "RNA");
        Virus parent2 = new Virus(0.6, 3, "Gamma", "DNA");
        Virus child1 = new Virus(0.2, 1, "Delta", "RNA");
        Virus child2 = new Virus(0.25, 1, "Epsilon", "DNA");

        parent1.addChild(child1);
        parent2.addChild(child2);
        grandParent.addChild(parent1);
        grandParent.addChild(parent2);

        System.out.println("=== Оригінальний вірус ===");
        grandParent.print();

        Virus clone = grandParent.clone();

        System.out.println("\n=== Клонований вірус ===");
        clone.print();

        Virus newChild = new Virus(0.3, 2, "Zeta", "RNA");
        parent1.addChild(newChild);

        System.out.println("\n=== Після додавання нового нащадка до оригіналу ===");
        System.out.println("--- Оригінал ---");
        grandParent.print();
        System.out.println("--- Клон ---");
        clone.print();
    }
}
