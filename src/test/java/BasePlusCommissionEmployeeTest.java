import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BasePlusCommissionEmployeeTest {

    private BasePlusCommissionEmployee employee;
    private static final String FIRST_NAME = "Ana";
    private static final String LAST_NAME = "Costa";
    private static final String SOCIAL_SECURITY_NUMBER = "456-78-9012";
    private static final double GROSS_SALES = 8000.0;
    private static final double COMMISSION_RATE = 0.12;
    private static final double BASE_SALARY = 2000.0;

    /**
     * Método executado antes de cada teste
     * Inicializa as variáveis necessárias para os testes
     */
    @Before
    public void setUp() {
        employee = new BasePlusCommissionEmployee(FIRST_NAME, LAST_NAME, SOCIAL_SECURITY_NUMBER, GROSS_SALES, COMMISSION_RATE, BASE_SALARY);
    }

    /**
     * Testa o construtor da classe
     * Verifica se todos os valores são corretamente atribuídos
     */
    @Test
    public void testConstrutor() {
        BasePlusCommissionEmployee novoEmployee = new BasePlusCommissionEmployee("Carlos", "Lima", "654-32-1098", 12000.0, 0.18, 3000.0);

        assertEquals("Carlos", novoEmployee.getFirstName());
        assertEquals("Lima", novoEmployee.getLastName());
        assertEquals("654-32-1098", novoEmployee.getSocialSecurityNumber());
        assertEquals(12000.0, novoEmployee.getGrossSales(), 0.001);
        assertEquals(0.18, novoEmployee.getCommissionRate(), 0.001);
        assertEquals(3000.0, novoEmployee.getBaseSalary(), 0.001);
    }

    /**
     * Testa todos os métodos get da classe
     * Verifica se retornam os valores corretos
     */
    @Test
    public void testMetodosGet() {
        assertEquals("Primeiro nome deve ser igual", FIRST_NAME, employee.getFirstName());
        assertEquals("Último nome deve ser igual", LAST_NAME, employee.getLastName());
        assertEquals("Número de segurança social deve ser igual", SOCIAL_SECURITY_NUMBER, employee.getSocialSecurityNumber());
        assertEquals("Vendas brutas devem ser iguais", GROSS_SALES, employee.getGrossSales(), 0.001);
        assertEquals("Taxa de comissão deve ser igual", COMMISSION_RATE, employee.getCommissionRate(), 0.001);
        assertEquals("Salário base deve ser igual", BASE_SALARY, employee.getBaseSalary(), 0.001);
    }

    /**
     * Testa todos os métodos set da classe
     * Verifica se os valores são corretamente alterados
     */
    @Test
    public void testMetodosSet() {
        // Testa setFirstName (herdado da classe pai)
        employee.setFirstName("Roberto");
        assertEquals("Roberto", employee.getFirstName());

        // Testa setLastName (herdado da classe pai)
        employee.setLastName("Ferreira");
        assertEquals("Ferreira", employee.getLastName());

        // Testa setSocialSecurityNumber (herdado da classe pai)
        employee.setSocialSecurityNumber("222-33-4444");
        assertEquals("222-33-4444", employee.getSocialSecurityNumber());

        // Testa setGrossSales (herdado da classe pai) com valor válido
        employee.setGrossSales(15000.0);
        assertEquals(15000.0, employee.getGrossSales(), 0.001);

        // Testa setCommissionRate (herdado da classe pai) com valor válido
        employee.setCommissionRate(0.20);
        assertEquals(0.20, employee.getCommissionRate(), 0.001);

        // Testa setBaseSalary (método próprio da classe)
        employee.setBaseSalary(3500.0);
        assertEquals(3500.0, employee.getBaseSalary(), 0.001);
    }

    /**
     * Testa o método earnings
     * Verifica se o cálculo do salário total está correto
     */
    @Test
    public void testEarnings() {
        // Testa com os valores padrão:
        // Base salary: 2000.0
        // Commission: 8000.0 * 0.12 = 960.0
        // Total: 2000.0 + 960.0 = 2960.0
        assertEquals(2960.0, employee.earnings(), 0.001);

        // Testa com novos valores
        employee.setGrossSales(10000.0);
        employee.setCommissionRate(0.15);
        employee.setBaseSalary(2500.0);
        // Base salary: 2500.0
        // Commission: 10000.0 * 0.15 = 1500.0
        // Total: 2500.0 + 1500.0 = 4000.0
        assertEquals(4000.0, employee.earnings(), 0.001);
    }

    /**
     * Testa validação de setBaseSalary com valor negativo
     * Deve lançar IllegalArgumentException
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetBaseSalaryNegativo() {
        employee.setBaseSalary(-500.0);
    }

    /**
     * Testa validação de setBaseSalary com valor zero
     * Deve lançar IllegalArgumentException
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetBaseSalaryZero() {
        employee.setBaseSalary(0.0);
    }

    /**
     * Testa validação de setGrossSales com valor negativo (herdado da classe pai)
     * Deve lançar IllegalArgumentException
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetGrossSalesNegativo() {
        employee.setGrossSales(-1000.0);
    }

    /**
     * Testa validação de setCommissionRate com valor negativo (herdado da classe pai)
     * Deve lançar IllegalArgumentException
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetCommissionRateNegativo() {
        employee.setCommissionRate(-0.10);
    }

    /**
     * Testa validação de setCommissionRate com valor >= 1.0 (herdado da classe pai)
     * Deve lançar IllegalArgumentException
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetCommissionRateMaiorOuIgualA1() {
        employee.setCommissionRate(1.0);
    }

    /**
     * Testa o método toString
     * Verifica se a representação em string está correta
     */
    @Test
    public void testToString() {
        // O toString da classe filha é: "base-salaried " + super.toString() + "\nbase salary: " + baseSalary
        // Onde super.toString() retorna: "commission employee: Ana Costa\nsocial security number: 456-78-9012\ngross sales: 8000.00\ncommission rate: 0.12"
        // Resultado final: "base-salaried commission employee: Ana Costa\nsocial security number: 456-78-9012\ngross sales: 8000.00\ncommission rate: 0.12\nbase salary: 2000.00"

        // Vamos usar o método toString() real para construir a string esperada
        // Isso garante que a formatação seja exatamente igual
        CommissionEmployee parent = new CommissionEmployee(FIRST_NAME, LAST_NAME, SOCIAL_SECURITY_NUMBER, GROSS_SALES, COMMISSION_RATE);
        String expected = "base-salaried " + parent.toString() + "\nbase salary: " + String.format("%.2f", BASE_SALARY);

        Assert.assertEquals(expected, employee.toString());
    }

    /**
     * Testa se a herança está funcionando corretamente
     * Verifica se os métodos da classe pai ainda funcionam
     */
    @Test
    public void testHeranca() {
        // Verifica se é uma instância de CommissionEmployee
        assertTrue("Deve ser uma instância de CommissionEmployee", employee instanceof CommissionEmployee);

        // Verifica se os métodos herdados funcionam corretamente
        assertEquals(FIRST_NAME, employee.getFirstName());
        assertEquals(LAST_NAME, employee.getLastName());
        assertEquals(SOCIAL_SECURITY_NUMBER, employee.getSocialSecurityNumber());
        assertEquals(GROSS_SALES, employee.getGrossSales(), 0.001);
        assertEquals(COMMISSION_RATE, employee.getCommissionRate(), 0.001);
    }
}
