public class CargoBot extends Vehicle {
    private double maxLoadKg;
    private double currentLoad;

    public CargoBot(String model, String serialNumber, double maxLoadKg) {
        super(model, serialNumber);
        this.maxLoadKg = maxLoadKg;
        this.currentLoad = 0.0;
    }

    public void load(double kg) {
        if (currentLoad + kg <= maxLoadKg) {
            currentLoad += kg;
            System.out.println("Load successful: " + kg + " kg loaded. Current load: " + currentLoad + "/" + maxLoadKg + " kg");
        } else {
            System.out.println("Error: Cannot load " + kg + " kg. Would exceed maximum capacity of " + maxLoadKg + " kg");
        }
    }

    public void unload() {
        this.currentLoad = 0.0;
        System.out.println("Cargo unloaded successfully");
    }

    public double getMaxLoadKg() {
        return maxLoadKg;
    }

    public void setMaxLoadKg(double maxLoadKg) {
        this.maxLoadKg = maxLoadKg;
    }

    public double getCurrentLoad() {
        return currentLoad;
    }

    public void setCurrentLoad(double currentLoad) {
        this.currentLoad = currentLoad;
    }

    @Override
    public String getStatus() {
        return super.getStatus() + ", Load: " + currentLoad + "/" + maxLoadKg + " kg";
    }
}
