package test.java.agencia;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.agencia.Aeroporto;
import main.java.agencia.PassagemAerea;

import static org.junit.jupiter.api.Assertions.*;

public class PassagemAereaTest {

    private PassagemAerea passagem;
    private Aeroporto aeroportoOrigem;
    private Aeroporto aeroportoDestino;

    @BeforeEach
    public void setUp() {
        aeroportoOrigem = new Aeroporto("GRU", "Aeroporto de Guarulhos", "São Paulo", null, null);
        aeroportoDestino = new Aeroporto("JFK", "Aeroporto John F. Kennedy", "Nova York", null, null);

        passagem = new PassagemAerea(
                aeroportoOrigem,
                aeroportoDestino,
                "2024-12-15 10:00",
                "AA1234",
                "American Airlines",
                1000.0, // tarifa básica
                2000.0, // tarifa business
                3000.0, // tarifa premium
                150.0,  // valor primeira bagagem
                100.0,  // valor bagagens adicionais
                "USD"
        );
    }

    @Test
    public void testCalcularTarifaTotalClasseBasica() {
        assertEquals(1000.0, passagem.calcularTarifaTotal("basica"));
    }

    @Test
    public void testCalcularTarifaTotalClasseBusiness() {
        assertEquals(2000.0, passagem.calcularTarifaTotal("business"));
    }

    @Test
    public void testCalcularTarifaTotalClassePremium() {
        assertEquals(3000.0, passagem.calcularTarifaTotal("premium"));
    }

    @Test
    public void testCalcularTarifaTotalClasseInvalida() {
        assertThrows(IllegalArgumentException.class, () -> passagem.calcularTarifaTotal("economica"));
    }

    @Test
    public void testCalcularTarifaTotalComBagagensClasseBasicaSemBagagensAdicionais() {
        assertEquals(1150.0, passagem.calcularTarifaTotalComBagagens("basica", 0));
    }

    @Test
    public void testCalcularTarifaTotalComBagagensClasseBusinessComBagagensAdicionais() {
        assertEquals(2250.0, passagem.calcularTarifaTotalComBagagens("business", 2));
    }

    @Test
    public void testCalcularRemuneracaoAgencia() {
        assertEquals(50.0, passagem.calcularRemuneracaoAgencia());
    }

    @Test
    public void testToString() {
        String expected = "PassagemAerea{" +
                "aeroportoOrigem='GRU'" +
                ", aeroportoDestino='JFK'" +
                ", dataHoraVoo='2024-12-15 10:00'" +
                ", codigoVoo='AA1234'" +
                ", companhiaAerea='American Airlines'" +
                ", tarifaBasica=1000.0" +
                ", tarifaBusiness=2000.0" +
                ", tarifaPremium=3000.0" +
                ", valorPrimeiraBagagem=150.0" +
                ", valorBagagensAdicionais=100.0" +
                ", moeda='USD'" +
                '}';
        assertEquals(expected, passagem.toString());
    }

    @Test
    public void testGetTaxaAgencia() {
        assertEquals(50.0, PassagemAerea.getTaxaAgencia());
    }
}
