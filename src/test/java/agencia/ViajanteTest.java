package test.java.agencia;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

import main.java.agencia.Viajante;

public class ViajanteTest {

    @Test 
    public void CadastraViajanteTest(){
        Viajante viajante = new Viajante("Bernardo", "151998112", "Gomescabeludo@gmail.com", "MG18318991", "123441");
        assertTrue(viajante.cadastraViajante());
    }

    
    
}
