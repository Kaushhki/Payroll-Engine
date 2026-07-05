import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PayrollTest {

    @Test
    void salariedEmployeePaysExactMonthlyAmount() throws InvalidSalaryException {
        SalariedEmployee emp = new SalariedEmployee("Test User", "T1", 50000);
        assertEquals(50000, emp.calculatePay(), 0.01);
    }

    @Test
    void hourlyEmployeeWithinNormalHoursPaysFlatRate() throws InvalidSalaryException {
        HourlyEmployee emp = new HourlyEmployee("Test User", "T2", 500, 40);
        assertEquals(20000, emp.calculatePay(), 0.01); // 40 * 500
    }

    @Test
    void hourlyEmployeeOvertimeGetsOnePointFiveX() throws InvalidSalaryException {
        HourlyEmployee emp = new HourlyEmployee("Test User", "T3", 500, 45); // 5 hrs overtime
        // 40*500 + 5*500*1.5 = 20000 + 3750 = 23750
        assertEquals(23750, emp.calculatePay(), 0.01);
    }

    @Test
    void negativeSalaryThrowsInvalidSalaryException() {
        assertThrows(InvalidSalaryException.class, () -> {
            new SalariedEmployee("Bad Data", "T4", -1000);
        });
    }

    @Test
    void negativeHourlyRateThrowsInvalidSalaryException() {
        assertThrows(InvalidSalaryException.class, () -> {
            new HourlyEmployee("Bad Data", "T5", -50, 40);
        });
    }
}
