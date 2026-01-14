public class GroundDrone extends Vehicle {
    private int sensorCount;

    public GroundDrone(String model, String serialNumber, int sensorCount) {
        super(model, serialNumber);
        this.sensorCount = sensorCount;
    }

    public void scan() {
        System.out.println("Basic scan completed");
    }

    public void scan(String mode) {
        System.out.println("Scanning in " + mode + " mode");
    }

    public int getSensorCount() {
        return sensorCount;
    }

    public void setSensorCount(int sensorCount) {
        this.sensorCount = sensorCount;
    }

    @Override
    public String getStatus() {
        return super.getStatus() + ", Sensors: " + sensorCount;
    }
}
