public abstract class Employee implements Payable {
    protected String name;
    protected String employeeId;

    public Employee(String name, String employeeId) {
        this.name = name;
        this.employeeId = employeeId;
    }

    

    public abstract double calculatePay();

    public String getName() {
        return name;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    @Override
    public String toString() {
        return String.format("%s (ID: %s)", name, employeeId);
    }
}
