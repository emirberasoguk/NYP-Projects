import java.util.ArrayList;

public class FleetControlCenter {
    private ArrayList<Vehicle> vehicles;
    private ArrayList<Employee> employees;
    private ArrayList<Mission> missions;

    public FleetControlCenter() {
        this.vehicles = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.missions = new ArrayList<>();
    }

    public void addVehicle(Vehicle v) {
        this.vehicles.add(v);
    }

    public void addEmployee(Employee e) {
        this.employees.add(e);
    }

    public void addMission(Mission m) {
        this.missions.add(m);
    }

    public ArrayList<Mission> searchMission(String keyword) {
        ArrayList<Mission> result = new ArrayList<>();
        for (Mission m : missions) {
            if (m.containsKeyword(keyword)) {
                result.add(m);
            }
        }
        return result;
    }

    public void listVehiclesByStatus() {
        for (Vehicle v : vehicles) {
            System.out.println(v.getStatus());
        }
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public ArrayList<Mission> getMissions() {
        return missions;
    }

    public void setMissions(ArrayList<Mission> missions) {
        this.missions = missions;
    }
}
