package test.java.agencia;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.agencia.PassagemAerea;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class PassagemAereaTest {

    @BeforeEach
    public void setUp() {
        // Limpar as passagens cadastradas antes de cada teste
        PassagemAerea.setPassagensCadastradas(null);

        // Adicionar passagens de exemplo para os testes
        new PassagemAerea("GRU", "JFK", "2024-10-05T10:00:00", "AA5678", "American Airlines",
                1800.00, 3200.00, 4600.00, 120.00, 60.00, "BRL");

        new PassagemAerea("GRU", "SFO", "2024-11-01T15:30:00", "DL1234", "Delta Airlines",
                1400.00, 2800.00, 4000.00, 110.00, 55.00, "BRL");
    }

    @Test
    public void testPesquisarPassagens() {
        // Testar busca por passagens que existem
        List<PassagemAerea> resultado = PassagemAerea.pesquisarPassagens("GRU", "SFO", "2024-11-01");
        assertFalse(resultado.isEmpty(), "A pesquisa deveria retornar uma passagem.");
        assertEquals(1, resultado.size(), "Deveria haver exatamente uma passagem correspondente.");
        assertEquals("DL1234", resultado.get(0).getCodigoVoo(), "O código do voo deve ser 'DL1234'.");

        // Testar busca por passagens que não existem
        resultado = PassagemAerea.pesquisarPassagens("GRU", "JFK", "2024-11-01");
        assertTrue(resultado.isEmpty(), "A pesquisa não deveria retornar nenhuma passagem.");
    }

    @Test
    public void testCalcularTarifaTotalComBagagens() {
        PassagemAerea passagem = new PassagemAerea("GRU", "JFK", "2024-10-05T10:00:00", "AA5678", "American Airlines",
                1800.00, 3200.00, 4600.00, 120.00, 60.00, "BRL");

        // Testar o cálculo da tarifa com bagagens
        double tarifaTotal = passagem.calcularTarifaTotalComBagagens("basica", 2);
        assertEquals(2040.00, tarifaTotal, 0.01, "O valor da tarifa total deveria ser 2040.00.");
    }
}