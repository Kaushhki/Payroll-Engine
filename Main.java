import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        try {
            employees.add(new SalariedEmployee("Priya Sharma", "E101", 65000));
            employees.add(new HourlyEmployee("Rahul Verma", "E102", 500, 45)); 
            employees.add(new SalariedEmployee("Ananya Iyer", "E103", 72000));
        } catch (InvalidSalaryException e) {
            System.out.println("Error creating employee: " + e.getMessage());
        }

        System.out.println("---- Payroll Run ----");
        double totalPayout = 0;

        for (Employee emp : employees) {
            double pay = emp.calculatePay();
            totalPayout += pay;
            System.out.printf("%s -> Pay: %.2f%n", emp, pay);
        }

        System.out.printf("Total payout: %.2f%n", totalPayout);

       

        System.out.println("\n---- Testing invalid input handling ----");
        try {
            Employee bad = new SalariedEmployee("Bad Data", "E999", -5000);
        } catch (InvalidSalaryException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }
    }
}
