public class HourlyEmployee extends Employee {
    private double hourlyRate;
    private double hoursWorked;

    public HourlyEmployee(String name, String employeeId, double hourlyRate, double hoursWorked) throws InvalidSalaryException {
        super(name, employeeId);
        if (hourlyRate < 0) {
            throw new InvalidSalaryException("Hourly rate cannot be negative for " + name);
        }
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculatePay() {
        // Simple overtime rule: anything past 40 hours/week pays 1.5x —
        // shows a bit of real business logic, not just a flat multiply.
        double regularHours = Math.min(hoursWorked, 40);
        double overtimeHours = Math.max(0, hoursWorked - 40);
        return (regularHours * hourlyRate) + (overtimeHours * hourlyRate * 1.5);
    }
}
