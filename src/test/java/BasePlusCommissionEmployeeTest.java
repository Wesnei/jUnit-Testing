import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class BasePlusCommissionEmployeeTest {

    private BasePlusCommissionEmployee employee;
    private static String FIRST_NAME;
    private static String LAST_NAME;
    private static String SSN;
    private static double GROSS_SALES;
    private static double COMMISSION_RATE;
    private static double BASE_SALARY;

    @BeforeClass
    public static void init() {
        FIRST_NAME = "Ana";
        LAST_NAME = "Costa";
        SSN = "456-78-9012";
        GROSS_SALES = 8000.0;
        COMMISSION_RATE = 0.12;
        BASE_SALARY = 2000.0;
    }

    @Before
    public void setUp() {
        employee = new BasePlusCommissionEmployee(FIRST_NAME, LAST_NAME, SSN, GROSS_SALES, COMMISSION_RATE, BASE_SALARY);
    }

    @Test
    public void testGetters() {
        assertEquals(FIRST_NAME, employee.getFirstName());
        assertEquals(LAST_NAME, employee.getLastName());
        assertEquals(SSN, employee.getSocialSecurityNumber());
        assertEquals(GROSS_SALES, employee.getGrossSales(), 0.001);
        assertEquals(COMMISSION_RATE, employee.getCommissionRate(), 0.001);
        assertEquals(BASE_SALARY, employee.getBaseSalary(), 0.001);
    }

    @Test
    public void testSetters() {
        employee.setFirstName("Roberto");
        assertEquals("Roberto", employee.getFirstName());

        employee.setLastName("Ferreira");
        assertEquals("Ferreira", employee.getLastName());

        employee.setSocialSecurityNumber("222-33-4444");
        assertEquals("222-33-4444", employee.getSocialSecurityNumber());

        employee.setGrossSales(15000.0);
        assertEquals(15000.0, employee.getGrossSales(), 0.001);

        employee.setCommissionRate(0.20);
        assertEquals(0.20, employee.getCommissionRate(), 0.001);

        employee.setBaseSalary(3500.0);
        assertEquals(3500.0, employee.getBaseSalary(), 0.001);
    }

    @Test
    public void testEarnings() {
        double expectedEarnings = BASE_SALARY + GROSS_SALES * COMMISSION_RATE;
        assertEquals(expectedEarnings, employee.earnings(), 0.001);

        employee.setGrossSales(10000.0);
        employee.setCommissionRate(0.15);
        employee.setBaseSalary(2500.0);
        double newExpected = 2500.0 + 10000.0 * 0.15;
        assertEquals(newExpected, employee.earnings(), 0.001);
    }
}
