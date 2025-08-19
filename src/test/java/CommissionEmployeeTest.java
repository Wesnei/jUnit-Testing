import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CommissionEmployeeTest {
    
    private CommissionEmployee employee;
    private static final String FIRST_NAME = "João";
    private static final String LAST_NAME = "Silva";
    private static final String SOCIAL_SECURITY_NUMBER = "123-45-6789";
    private static final double GROSS_SALES = 10000.0;
    private static final double COMMISSION_RATE = 0.15;
    
    /**
     * Método executado antes de cada teste
     * Inicializa as variáveis necessárias para os testes
     */
    @Before
    public void setUp() {
        employee = new CommissionEmployee(FIRST_NAME, LAST_NAME, SOCIAL_SECURITY_NUMBER, GROSS_SALES, COMMISSION_RATE);
    }
    
    /**
     * Testa o construtor da classe
     * Verifica se todos os valores são corretamente atribuídos
     */
    @Test
    public void testConstrutor() {
        CommissionEmployee novoEmployee = new CommissionEmployee("Maria", "Santos", "987-65-4321", 5000.0, 0.10);
        
        assertEquals("Maria", novoEmployee.getFirstName());
        assertEquals("Santos", novoEmployee.getLastName());
        assertEquals("987-65-4321", novoEmployee.getSocialSecurityNumber());
        assertEquals(5000.0, novoEmployee.getGrossSales(), 0.001);
        assertEquals(0.10, novoEmployee.getCommissionRate(), 0.001);
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
    }
    
    /**
     * Testa todos os métodos set da classe
     * Verifica se os valores são corretamente alterados
     */
    @Test
    public void testMetodosSet() {
        // Testa setFirstName
        employee.setFirstName("Pedro");
        assertEquals("Pedro", employee.getFirstName());
        
        // Testa setLastName
        employee.setLastName("Oliveira");
        assertEquals("Oliveira", employee.getLastName());
        
        // Testa setSocialSecurityNumber
        employee.setSocialSecurityNumber("111-22-3333");
        assertEquals("111-22-3333", employee.getSocialSecurityNumber());
        
        // Testa setGrossSales com valor válido
        employee.setGrossSales(15000.0);
        assertEquals(15000.0, employee.getGrossSales(), 0.001);
        
        // Testa setCommissionRate com valor válido
        employee.setCommissionRate(0.20);
        assertEquals(0.20, employee.getCommissionRate(), 0.001);
    }
    
    /**
     * Testa o método earnings
     * Verifica se o cálculo da comissão está correto
     */
    @Test
    public void testEarnings() {
        // Testa com os valores padrão (10000.0 * 0.15 = 1500.0)
        assertEquals(1500.0, employee.earnings(), 0.001);
        
        // Testa com novos valores
        employee.setGrossSales(20000.0);
        employee.setCommissionRate(0.25);
        assertEquals(5000.0, employee.earnings(), 0.001); // 20000.0 * 0.25 = 5000.0
    }
    
    /**
     * Testa validação de setGrossSales com valor negativo
     * Deve lançar IllegalArgumentException
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetGrossSalesNegativo() {
        employee.setGrossSales(-1000.0);
    }
    
    /**
     * Testa validação de setCommissionRate com valor negativo
     * Deve lançar IllegalArgumentException
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetCommissionRateNegativo() {
        employee.setCommissionRate(-0.10);
    }
    
    /**
     * Testa validação de setCommissionRate com valor >= 1.0
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
        String expected = String.format("commission employee: %s %s%nsocial security number: %s%ngross sales: %.2f%ncommission rate: %.2f", 
                                      FIRST_NAME, LAST_NAME, SOCIAL_SECURITY_NUMBER, GROSS_SALES, COMMISSION_RATE);
        assertEquals(expected, employee.toString());
    }
}
