package test.java.agencia;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import main.java.agencia.CompanhiaAerea;

import org.junit.jupiter.api.BeforeEach;

public class CompanhiaAereaTest {

    private CompanhiaAerea companhia;

    @BeforeEach
    public void setUp() {
        companhia = new CompanhiaAerea("Airline", 123, "Airline S.A.", "00.000.000/0001-00", 50.0, 30.0);
    }

    @Test
    public void testConstrutor() {
        assertEquals("Airline", companhia.getNome());
        assertEquals(123, companhia.getCodCompanhia());
        assertEquals("Airline S.A.", companhia.getRazaoSocial());
        assertEquals("00.000.000/0001-00", companhia.getCNPJ());
        assertEquals(50.0, companhia.getPrimeiraBagagem());
        assertEquals(30.0, companhia.getBagagemAdicional());
    }

    @Test
    public void testDefinePrimeiraBagagem() {
        companhia.definePrimeiraBagagem(60.0);
        assertEquals(60.0, companhia.getPrimeiraBagagem());
    }

    @Test
    public void testDefineBagagemAdicional() {
        companhia.defineBagagemAdicional(40.0);
        assertEquals(40.0, companhia.getBagagemAdicional());
    }

    @Test
    public void testDefineValorBagagens() {
        double valorTotal = companhia.defineValorBagagens();
        assertEquals(80.0, valorTotal);
    }
}