import java.util.ArrayList;

public class Mission {
    private String missionId;
    private String description;
    private ArrayList<Vehicle> assignedVehicles;
    private ArrayList<Employee> responsibleStaff;

    public Mission(String missionId, String description) {
        this.missionId = missionId;
        this.description = description;
        this.assignedVehicles = new ArrayList<>();
        this.responsibleStaff = new ArrayList<>();
    }

    public void assignVehicle(Vehicle v) {
        this.assignedVehicles.add(v);
    }

    public void assignEmployee(Employee e) {
        this.responsibleStaff.add(e);
    }

    public boolean containsKeyword(String keyword) {
        return description.toLowerCase().contains(keyword.toLowerCase());
    }

    public String getMissionId() {
        return missionId;
    }

    public void setMissionId(String missionId) {
        this.missionId = missionId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Vehicle> getAssignedVehicles() {
        return assignedVehicles;
    }

    public void setAssignedVehicles(ArrayList<Vehicle> assignedVehicles) {
        this.assignedVehicles = assignedVehicles;
    }

    public ArrayList<Employee> getResponsibleStaff() {
        return responsibleStaff;
    }

    public void setResponsibleStaff(ArrayList<Employee> responsibleStaff) {
        this.responsibleStaff = responsibleStaff;
    }
}
