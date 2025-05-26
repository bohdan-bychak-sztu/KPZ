package task2.factories;

import task2.*;
import task2.iprone.*;

public class IProneFactory implements DeviceFactory {
    public Laptop createLaptop() { return new IProneLaptop(); }
    public Netbook createNetbook() { return new IProneNetbook(); }
    public EBook createEBook() { return new IProneEBook(); }
    public Smartphone createSmartphone() { return new IProneSmartphone(); }
}
