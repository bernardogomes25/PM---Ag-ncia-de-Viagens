package test.java.agencia;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import main.java.agencia.Voo;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;

public class VooTest {
    private Voo voo1;
    private Voo voo2;

    @BeforeEach
    public void setUp() {
        // Criando instâncias de Voo antes de cada teste
        voo1 = new Voo("São Paulo", "Rio de Janeiro", LocalDate.of(2024, 10, 1), "Companhia A",
                200.0, 400.0, 600.0, 50.0, 30.0, "BRL");

        voo2 = new Voo("Salvador", "Fortaleza", LocalDate.of(2024, 10, 2), "Companhia B",
                150.0, 300.0, 450.0, 40.0, 20.0, "BRL");
    }

    @Test
    public void testGetCodigoVoo() {
        assertEquals("São Paulo-Rio de Janeiro-2024-10-01", voo1.getCodigoVoo());
    }

    @Test
    public void testCalcularTarifaBasica() {
        assertEquals(200.0, voo1.calculaTarifa("basica"));
    }

    @Test
    public void testCalcularTarifaBusiness() {
        assertEquals(400.0, voo1.calculaTarifa("business"));
    }

    @Test
    public void testCalcularValorBagagem() {
        assertEquals(50.0, voo1.calculaBagagem(1));
        assertEquals(80.0, voo1.calculaBagagem(2)); // 50 + 30
    }

    @Test
    public void testVerificaAeroporto() {
        assertTrue(voo1.verificaAeroporto("São Paulo"));
        assertTrue(voo1.verificaAeroporto("Rio de Janeiro"));
        assertFalse(voo1.verificaAeroporto("Brasília"));
    }

    @Test
    public void testVerificaCompanhia() {
        assertTrue(voo1.verificaCompanhia("Companhia A"));
        assertFalse(voo1.verificaCompanhia("Companhia B"));
    }

    @Test
    public void testVerificaMoeda() {
        assertTrue(voo1.verificaMoeda("BRL"));
        assertFalse(voo1.verificaMoeda("USD"));
    }

    @Test
    public void testPesquisaVoo() {
        Voo[] voos = { voo1, voo2 };
        Voo resultado = Voo.pesquisaVoo(voos, voo1.getCodigoVoo());
        assertNotNull(resultado);
        assertEquals(voo1.getCodigoVoo(), resultado.getCodigoVoo());
    }

    @Test
    public void testPesquisaVooInexistente() {
        Voo[] voos = { voo1, voo2 };
        Voo resultado = Voo.pesquisaVoo(voos, "inexistente");
        assertNull(resultado);
    }
}