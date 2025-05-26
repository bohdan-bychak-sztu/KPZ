package task2;
import task2.factories.*;

public class Main {
    public static void main(String[] args) {
        testFactory(new IProneFactory());
        testFactory(new KiaomiFactory());
        testFactory(new BalaxyFactory());
    }

    public static void testFactory(DeviceFactory factory) {
        Laptop laptop = factory.createLaptop();
        Netbook netbook = factory.createNetbook();
        EBook ebook = factory.createEBook();
        Smartphone smartphone = factory.createSmartphone();

        System.out.println("Testing factory: " + factory.getClass().getSimpleName());
        laptop.info();
        netbook.info();
        ebook.info();
        smartphone.info();
        System.out.println("-----------------------------");
    }
}
