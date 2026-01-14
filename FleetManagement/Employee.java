public class Employee {
    private String name;
    private String email;
    private String employeeId;

    public Employee(String name, String email, String employeeId) {
        this.name = name;
        this.email = email;
        this.employeeId = employeeId;
    }

    public Employee(String name, String email) {
        this.name = name;
        this.email = email;
        this.employeeId = "EMP" + (int) (Math.random() * 1000);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getNormalizedEmail() {
        return email.trim().toLowerCase();
    }

    public String describe() {
        return "Employee: " + name + ", Email: " + getNormalizedEmail() + ", ID: " + employeeId;
    }
}
