package task2;

public class Aircraft {
    private String name;
    private boolean isTakingOff;
    private CommandCentre commandCentre;

    public Aircraft(String name, CommandCentre commandCentre) {
        this.name = name;
        this.commandCentre = commandCentre;
        this.commandCentre.registerAircraft(this);
    }

    public void requestLanding() {
        commandCentre.requestLanding(this);
    }

    public void requestTakeOff() {
        commandCentre.requestTakeOff(this);
    }

    public String getName() {
        return name;
    }

    public boolean isTakingOff() {
        return isTakingOff;
    }

    public void setTakingOff(boolean takingOff) {
        isTakingOff = takingOff;
    }
}
