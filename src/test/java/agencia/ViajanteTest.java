package test.java.agencia;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.java.agencia.Viajante;
import static org.junit.jupiter.api.Assertions.*;
public class ViajanteTest {
    private Viajante viajante;
    @BeforeEach
    public void setUp() {
        viajante = new Viajante();
    }
    @Test
    public void testCadastraViajanteComSucesso() {
        viajante.setNome("Maria");
        viajante.setCpf("12345678900");
        viajante.setEmail("maria@example.com");
        viajante.setRg("MG1234567");
        viajante.setPassaporte("BR123456789");
        assertTrue(viajante.cadastraViajante());
    }
    @Test
    public void testCadastraViajanteSemNome() {
        viajante.setCpf("12345678900");
        viajante.setEmail("maria@example.com");
        viajante.setRg("MG1234567");
        viajante.setPassaporte("BR123456789");
        assertFalse(viajante.cadastraViajante());
    }
    @Test
    public void testCadastraViajanteSemCpf() {
        viajante.setNome("Maria");
        viajante.setEmail("maria@example.com");
        viajante.setRg("MG1234567");
        viajante.setPassaporte("BR123456789");
        assertFalse(viajante.cadastraViajante());
    }
    @Test
    public void testCadastraViajanteSemEmail() {
        viajante.setNome("Maria");
        viajante.setCpf("12345678900");
        viajante.setRg("MG1234567");
        viajante.setPassaporte("BR123456789");
        assertFalse(viajante.cadastraViajante());
    }
    @Test
    public void testCadastraViajanteSemRg() {
        viajante.setNome("Maria");
        viajante.setCpf("12345678900");
        viajante.setEmail("maria@example.com");
        viajante.setPassaporte("BR123456789");
        assertFalse(viajante.cadastraViajante());
    }
    @Test
    public void testCadastraViajanteSemPassaporte() {
        viajante.setNome("Maria");
        viajante.setCpf("12345678900");
        viajante.setEmail("maria@example.com");
        viajante.setRg("MG1234567");
        assertFalse(viajante.cadastraViajante());
    }
    @Test
    public void testGetSetNome() {
        viajante.setNome("Maria");
        assertEquals("Maria", viajante.getNome());
    }
    @Test
    public void testGetSetCpf() {
        viajante.setCpf("12345678900");
        assertEquals("12345678900", viajante.getCpf());
    }
    @Test
    public void testGetSetEmail() {
        viajante.setEmail("maria@example.com");
        assertEquals("maria@example.com", viajante.getEmail());
    }
    @Test
    public void testGetSetRg() {
        viajante.setRg("MG1234567");
        assertEquals("MG1234567", viajante.getRg());
    }
    @Test
    public void testGetSetPassaporte() {
        viajante.setPassaporte("BR123456789");
        assertEquals("BR123456789", viajante.getPassaporte());
    }
}