package task2.factories;

import task2.*;
import task2.balaxy.*;

public class BalaxyFactory implements DeviceFactory {
    public Laptop createLaptop() {
        return new BalaxyLaptop();
    }

    public Netbook createNetbook() {
        return new BalaxyNetbook();
    }

    public EBook createEBook() {
        return new BalaxyEBook();
    }

    public Smartphone createSmartphone() {
        return new BalaxySmartphone();
    }
}
