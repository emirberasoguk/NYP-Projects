public class Engineer extends Employee {
    private String specialty;

    public Engineer(String name, String email, String employeeId, String specialty) {
        super(name, email, employeeId);
        this.specialty = specialty;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    @Override
    public String describe() {
        return super.describe() + ", Specialty: " + specialty;
    }
}
