package task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandCentre {
    private List<Runway> runways = new ArrayList<>();
    private List<Aircraft> aircrafts = new ArrayList<>();

    public void registerRunway(Runway runway) {
        runways.add(runway);
    }

    public void registerAircraft(Aircraft aircraft) {
        aircrafts.add(aircraft);
    }

    public void requestLanding(Aircraft aircraft) {
        System.out.println("Aircraft " + aircraft.getName() + " requesting to land.");
        for (Runway runway : runways) {
            if (runway.isAvailable()) {
                System.out.println("Landing granted on runway " + runway.getId());
                runway.occupy(aircraft);
                return;
            }
        }
        System.out.println("No available runway for landing.");
    }

    public void requestTakeOff(Aircraft aircraft) {
        System.out.println("Aircraft " + aircraft.getName() + " requesting to take off.");
        for (Runway runway : runways) {
            if (runway.getCurrentAircraft() == aircraft) {
                runway.release();
                System.out.println("Aircraft " + aircraft.getName() + " has taken off.");
                return;
            }
        }
        System.out.println("Aircraft " + aircraft.getName() + " is not assigned to any runway.");
    }
}
