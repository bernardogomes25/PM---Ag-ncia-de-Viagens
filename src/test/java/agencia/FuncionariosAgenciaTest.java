package test.java.agencia;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import main.java.agencia.FuncionariosAgencia;

public class FuncionariosAgenciaTest {

    @Test
    public void CadastraFuncionarioTest(){
        FuncionariosAgencia fna = new FuncionariosAgencia("Joao", "53904413617", "JoaoReidelas@gmaill.com", "Abacate123", "amarelo123");
        assertTrue(fna.cadastraFuncionario());
    }

    @Test
    public void CadastraUsuarioTest(){
        FuncionariosAgencia fna = new FuncionariosAgencia("Joao", "53904413617", "JoaoReidelas@gmaill.com", "Abacate123", "amarelo123");
        assertTrue(fna.cadastraUsuario());


    }

    @Test
    public void AcessaSistemaTest(){
        FuncionariosAgencia fna = new FuncionariosAgencia("Joao", "53904413617", "JoaoReidelas@gmaill.com", "Abacate123", "amarelo123");
        assertTrue(fna.acessaSistema("Abacate123", "amarelo123"));
    }

    
}
