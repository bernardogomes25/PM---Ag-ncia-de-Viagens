package test.java.agencia;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import main.java.agencia.Aeroporto;
import main.java.agencia.PassagemAerea;

import static org.junit.jupiter.api.Assertions.*;

public class PassagemAereaTest {

    private Aeroporto aeroportoOrigem;
    private Aeroporto aeroportoDestino;
    private PassagemAerea passagem;

    @BeforeEach
    public void setUp() {
        aeroportoOrigem = new Aeroporto("Aeroporto Internacional de Confins", "CNF", "Confins", "MG", "Brasil");
        aeroportoDestino = new Aeroporto("Aeroporto Internacional de Guarulhos", "GRU", "Guarulhos", "SP", "Brasil");
        passagem = new PassagemAerea(aeroportoOrigem, aeroportoDestino, LocalDate.of(2021, 10, 10), 
                                     "GOL1234", "GOL", 1000.0, 2000.0, 3000.0, 100.0, 50.0, "BRL");
    }

    @Test
    public void testConstrutor() {
        assertEquals(aeroportoOrigem, passagem.getAeroportoOrigem());
        assertEquals(aeroportoDestino, passagem.getAeroportoDestino());
        assertEquals(LocalDate.of(2021, 10, 10), passagem.getDataHoraVoo());
        assertEquals("GOL1234", passagem.getCodigoVoo());
        assertEquals("GOL", passagem.getCompanhiaAerea());
        assertEquals(1000.0, passagem.getTarifaBasica());
        assertEquals(2000.0, passagem.getTarifaBusiness());
        assertEquals(3000.0, passagem.getTarifaPremium());
        assertEquals(100.0, passagem.getValorPrimeiraBagagem());
        assertEquals(50.0, passagem.getValorBagagensAdicionais());
        assertEquals("BRL", passagem.getMoeda());
    }

    @Test
    public void testCalcularTarifaTotal() {
        assertEquals(1050.0, passagem.calcularTarifaTotal("basica"));
        assertEquals(2050.0, passagem.calcularTarifaTotal("business"));
        assertEquals(3050.0, passagem.calcularTarifaTotal("premium"));
    }


    @Test
    public void testCalcularRemuneracaoAgencia() {
        assertEquals(50.0, passagem.calcularRemuneracaoAgencia());
    }

    @Test
    public void testPesquisarPassagens() {
        List<PassagemAerea> resultado = PassagemAerea.pesquisarPassagens(aeroportoOrigem, aeroportoDestino, "2021-10-10");
        assertTrue(resultado.contains(passagem));
    }
}