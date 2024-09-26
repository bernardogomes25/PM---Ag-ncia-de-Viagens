import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class PassagemAereaTest {

    @Before
    public void setUp() {
      
        PassagemAerea.setPassagensCadastradas(new ArrayList<>());

        new PassagemAerea("GRU", "JFK", "2024-10-05T10:00:00", "AA5678", "American Airlines",
                1800.00, 3200.00, 4600.00, 120.00, 60.00, "BRL");

        new PassagemAerea("GRU", "SFO", "2024-11-01T15:30:00", "DL1234", "Delta Airlines",
                1400.00, 2800.00, 4000.00, 110.00, 55.00, "BRL");

        new PassagemAerea("GRU", "SFO", "2024-10-01T15:30:00", "AA1234", "American Airlines",
                1500.00, 3000.00, 4500.00, 100.00, 50.00, "BRL");
    }

    @Test
    public void testPesquisarPassagemPorOrigemDestinoData() {
 
        List<PassagemAerea> resultadoPesquisa = PassagemAerea.pesquisarPassagens("GRU", "SFO", "2024-10-01");
        assertEquals(1, resultadoPesquisa.size());
        assertEquals("SFO", resultadoPesquisa.get(0).getAeroportoDestino());
        assertEquals("2024-10-01T15:30:00", resultadoPesquisa.get(0).getDataHoraVoo());
    }

    @Test
    public void testPesquisarPassagemSemResultados() {

        List<PassagemAerea> resultadoPesquisa = PassagemAerea.pesquisarPassagens("GRU", "LAX", "2024-10-01");
        assertTrue(resultadoPesquisa.isEmpty());
    }

    @Test
    public void testPesquisarPorVariasPassagens() {

        List<PassagemAerea> resultadoPesquisa = PassagemAerea.pesquisarPassagens("GRU", "SFO", "2024-11-01");
        assertEquals(1, resultadoPesquisa.size());
        assertEquals("SFO", resultadoPesquisa.get(0).getAeroportoDestino());
        assertEquals("2024-11-01T15:30:00", resultadoPesquisa.get(0).getDataHoraVoo());
    }

    @Test
    public void testCalcularTarifaTotalBasica() {
        PassagemAerea passagem = new PassagemAerea("GRU", "SFO", "2024-12-01T15:30:00", "AA1235", "American Airlines",
                1600.00, 3100.00, 4600.00, 100.00, 50.00, "BRL");

        double tarifa = passagem.calcularTarifaTotal("basica");
        assertEquals(1600.00, tarifa, 0.01);
    }

    @Test
    public void testCalcularTarifaTotalBusiness() {
        PassagemAerea passagem = new PassagemAerea("GRU", "SFO", "2024-12-01T15:30:00", "AA1235", "American Airlines",
                1600.00, 3100.00, 4600.00, 100.00, 50.00, "BRL");

        double tarifa = passagem.calcularTarifaTotal("business");
        assertEquals(3100.00, tarifa, 0.01);
    }

    @Test
    public void testCalcularTarifaTotalPremium() {
        PassagemAerea passagem = new PassagemAerea("GRU", "SFO", "2024-12-01T15:30:00", "AA1235", "American Airlines",
                1600.00, 3100.00, 4600.00, 100.00, 50.00, "BRL");

        double tarifa = passagem.calcularTarifaTotal("premium");
        assertEquals(4600.00, tarifa, 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalcularTarifaTotalClasseInvalida() {
        PassagemAerea passagem = new PassagemAerea("GRU", "SFO", "2024-12-01T15:30:00", "AA1235", "American Airlines",
                1600.00, 3100.00, 4600.00, 100.00, 50.00, "BRL");

   
        passagem.calcularTarifaTotal("economica");
    }

    @Test
    public void testCalcularTarifaTotalComBagagens() {
        PassagemAerea passagem = new PassagemAerea("GRU", "SFO", "2024-12-01T15:30:00", "AA1235", "American Airlines",
                1600.00, 3100.00, 4600.00, 100.00, 50.00, "BRL");


        double tarifaComBagagens = passagem.calcularTarifaTotalComBagagens("basica", 2);
        assertEquals(1800.00, tarifaComBagagens, 0.01);
    }

    @Test
    public void testCalcularTarifaTotalComBagagensBusiness() {
        PassagemAerea passagem = new PassagemAerea("GRU", "SFO", "2024-12-01T15:30:00", "AA1235", "American Airlines",
                1600.00, 3100.00, 4600.00, 100.00, 50.00, "BRL");


        double tarifaComBagagens = passagem.calcularTarifaTotalComBagagens("business", 3);
        assertEquals(3400.00, tarifaComBagagens, 0.01);
    }

    @Test
    public void testCalcularRemuneracaoAgencia() {
        PassagemAerea passagem = new PassagemAerea("GRU", "SFO", "2024-12-01T15:30:00", "AA1235", "American Airlines",
                1600.00, 3100.00, 4600.00, 100.00, 50.00, "BRL");


        double remuneracaoAgencia = passagem.calcularRemuneracaoAgencia();
        assertEquals(50.00, remuneracaoAgencia, 0.01);
    }
}
