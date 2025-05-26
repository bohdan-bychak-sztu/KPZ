package task2.factories;

import task2.*;
import task2.kiaomi.*;

public class KiaomiFactory implements DeviceFactory {
    public Laptop createLaptop() {
        return new KiaomiLaptop();
    }

    public Netbook createNetbook() {
        return new KiaomiNetbook();
    }

    public EBook createEBook() {
        return new KiaomiEBook();
    }

    public Smartphone createSmartphone() {
        return new KiaomiSmartphone();
    }
}
