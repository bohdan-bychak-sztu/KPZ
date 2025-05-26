package task2;

import java.util.UUID;

public class Runway {
    private final UUID id = UUID.randomUUID();
    private Aircraft isBusyWithAircraft;

    public boolean isAvailable() {
        return isBusyWithAircraft == null;
    }

    public void occupy(Aircraft aircraft) {
        this.isBusyWithAircraft = aircraft;
        highlightRed();
    }

    public void release() {
        this.isBusyWithAircraft = null;
        highlightGreen();
    }

    public void highlightRed() {
        System.out.println("Runway " + id + " is busy!");
    }

    public void highlightGreen() {
        System.out.println("Runway " + id + " is free!");
    }

    public UUID getId() {
        return id;
    }

    public Aircraft getCurrentAircraft() {
        return isBusyWithAircraft;
    }
}
