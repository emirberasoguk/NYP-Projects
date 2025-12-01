import java.util.ArrayList;

public class Manager extends Employee {
    private ArrayList<Employee> team;

    public Manager(String name, String email, String employeeId) {
        super(name, email, employeeId);
        this.team = new ArrayList<>();
    }

    public void addTeamMember(Employee e) {
        this.team.add(e);
    }

    public ArrayList<Employee> getTeam() {
        return team;
    }

    public void setTeam(ArrayList<Employee> team) {
        this.team = team;
    }

    @Override
    public String describe() {
        return super.describe() + ", Team Size: " + team.size();
    }
}
