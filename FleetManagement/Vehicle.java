import java.util.ArrayList;

public class Vehicle {
    private String model;
    private String serialNumber;
    private double batteryLevel;
    private ArrayList<Module> modules;

    public Vehicle() {
        this.model = "Unknown";
        this.serialNumber = "Unknown";
        this.batteryLevel = 100.0;
        this.modules = new ArrayList<>();
    }

    public Vehicle(String model, String serialNumber) {
        this.model = model;
        this.serialNumber = serialNumber;
        this.batteryLevel = 100.0;
        this.modules = new ArrayList<>();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public double getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(double batteryLevel) {
        if (batteryLevel >= 0 && batteryLevel <= 100) {
            this.batteryLevel = batteryLevel;
        } else {
            System.out.println("Error: Battery level must be between 0 and 100.");
        }
    }

    public ArrayList<Module> getModules() {
        return modules;
    }

    public void setModules(ArrayList<Module> modules) {
        this.modules = modules;
    }

    public void addModule(Module m) {
        this.modules.add(m);
    }

    public void charge(double amount) {
        if (amount > 0) {
            this.batteryLevel = Math.min(100, this.batteryLevel + amount);
        }
    }

    public void charge() {
        this.batteryLevel = 100.0;
    }

    public String getStatus() {
        return "Model: " + model + ", Serial: " + serialNumber + ", Battery: " + batteryLevel + "%";
    }
}
