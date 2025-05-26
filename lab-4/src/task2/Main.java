package task2;

public class Main {
    public static void main(String[] args) {
        CommandCentre centre = new CommandCentre();

        Runway r1 = new Runway();
        Runway r2 = new Runway();
        centre.registerRunway(r1);
        centre.registerRunway(r2);

        Aircraft a1 = new Aircraft("Boeing 737", centre);
        Aircraft a2 = new Aircraft("Airbus A320", centre);

        a1.requestLanding();
        a2.requestLanding();

        a1.requestTakeOff();
        a2.requestTakeOff();
    }
}
