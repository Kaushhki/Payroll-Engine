public class SalariedEmployee extends Employee {
    private double monthlySalary;

    public SalariedEmployee(String name, String employeeId, double monthlySalary) throws InvalidSalaryException {
        super(name, employeeId);
        if (monthlySalary < 0) {
            throw new InvalidSalaryException("Monthly salary cannot be negative for " + name);
        }
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculatePay() {
        return monthlySalary;
    }
}
