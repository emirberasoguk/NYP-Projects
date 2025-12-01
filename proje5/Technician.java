public class Technician extends Employee {
    private int experienceYears;

    public Technician(String name, String email, String employeeId, int experienceYears) {
        super(name, email, employeeId);
        this.experienceYears = experienceYears;
    }

    public void maintenanceReport() {
        System.out.println("Maintenance report generated");
    }

    public void maintenanceReport(boolean includeTimestamp) {
        if (includeTimestamp) {
            System.out.println("Maintenance report generated at: " + new java.util.Date());
        } else {
            maintenanceReport();
        }
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    @Override
    public String describe() {
        return super.describe() + ", Experience: " + experienceYears + " years";
    }
}
