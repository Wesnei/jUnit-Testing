import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CommissionEmployeeTest {

    private CommissionEmployee employee;
    private static String FIRST_NAME;
    private static String LAST_NAME;
    private static String SSN;
    private static double GROSS_SALES;
    private static double COMMISSION_RATE;

    @BeforeClass
    public static void init() {
        // Inicializa constantes uma vez para toda a classe
        FIRST_NAME = "João";
        LAST_NAME = "Silva";
        SSN = "123-45-6789";
        GROSS_SALES = 10000.0;
        COMMISSION_RATE = 0.15;
    }

    @Before
    public void setUp() {
        // Inicializa antes de cada teste
        employee = new CommissionEmployee(FIRST_NAME, LAST_NAME, SSN, GROSS_SALES, COMMISSION_RATE);
    }

    @Test
    public void testGetters() {
        assertEquals(FIRST_NAME, employee.getFirstName());
        assertEquals(LAST_NAME, employee.getLastName());
        assertEquals(SSN, employee.getSocialSecurityNumber());
        assertEquals(GROSS_SALES, employee.getGrossSales(), 0.001);
        assertEquals(COMMISSION_RATE, employee.getCommissionRate(), 0.001);
    }

    @Test
    public void testSetters() {
        employee.setFirstName("Pedro");
        assertEquals("Pedro", employee.getFirstName());
        employee.setLastName("Oliveira");
        assertEquals("Oliveira", employee.getLastName());

        employee.setSocialSecurityNumber("111-22-3333");
        assertEquals("111-22-3333", employee.getSocialSecurityNumber());

        employee.setGrossSales(15000.0);
        assertEquals(15000.0, employee.getGrossSales(), 0.001);

        employee.setCommissionRate(0.20);
        assertEquals(0.20, employee.getCommissionRate(), 0.001);
    }

    @Test
    public void testEarnings() {
        assertEquals(GROSS_SALES * COMMISSION_RATE, employee.earnings(), 0.001);

        employee.setGrossSales(20000.0);
        employee.setCommissionRate(0.25);
        assertEquals(20000.0 * 0.25, employee.earnings(), 0.001);
    }
}
