package test.java.agencia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.agencia.Aeroporto;

public class AeroportoTest {

    private Aeroporto aeroporto1;
    private Aeroporto aeroporto2;
    private Aeroporto aeroportoDuplicado;

    @BeforeEach
    public void setUp() {
        aeroporto1 = new Aeroporto("Aeroporto Internacional de São Paulo", "GRU", "Guarulhos", "São Paulo", "Brasil");
        aeroporto2 = new Aeroporto("Aeroporto Internacional Tom Jobim", "GIG", "Rio de Janeiro", "Rio de Janeiro", "Brasil");
        aeroportoDuplicado = new Aeroporto("Aeroporto Internacional de São Paulo", "GRU", "Guarulhos", "São Paulo", "Brasil");
    }

    @Test
    public void testConstrutor() {
        assertEquals("Aeroporto Internacional de São Paulo", aeroporto1.nome);
        assertEquals("GRU", aeroporto1.sigla);
        assertEquals("Guarulhos", aeroporto1.cidade);
        assertEquals("São Paulo", aeroporto1.estado);
        assertEquals("Brasil", aeroporto1.pais);
    }

    @Test
    public void testCadastraAeroporto() {
        // Primeiro cadastro, deve retornar true
        assertTrue(aeroporto1.cadastraAeroporto());

        // Segundo cadastro, deve retornar true
        assertTrue(aeroporto2.cadastraAeroporto());

        // Tentativa de cadastrar um aeroporto já existente, deve retornar false
        assertFalse(aeroportoDuplicado.cadastraAeroporto());
    }

    @Test
    public void testAeroportoJaCadastrado() {
        // Cadastra o aeroporto1
        aeroporto1.cadastraAeroporto();
        
        // Verifica se o aeroporto duplicado é detectado como já cadastrado
        assertFalse(aeroportoDuplicado.cadastraAeroporto());
    }
}
