package test.java.agencia;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.agencia.FuncionariosAgencia;

import static org.junit.jupiter.api.Assertions.*;

public class FuncionariosAgenciaTest {

    private FuncionariosAgencia funcionario;

    @BeforeEach
    public void setUp() {
        funcionario = new FuncionariosAgencia();
    }

    @Test
    public void testCadastraFuncionarioComSucesso() {
        funcionario.setNome("João");
        funcionario.setCpf("12345678900");
        funcionario.setEmail("joao@example.com");

        assertTrue(funcionario.cadastraFuncionario());
    }

    @Test
    public void testCadastraFuncionarioSemNome() {
        funcionario.setCpf("12345678900");
        funcionario.setEmail("joao@example.com");

        assertFalse(funcionario.cadastraFuncionario());
    }

    @Test
    public void testCadastraFuncionarioSemCpf() {
        funcionario.setNome("João");
        funcionario.setEmail("joao@example.com");

        assertFalse(funcionario.cadastraFuncionario());
    }

    @Test
    public void testCadastraFuncionarioSemEmail() {
        funcionario.setNome("João");
        funcionario.setCpf("12345678900");

        assertFalse(funcionario.cadastraFuncionario());
    }

    @Test
    public void testCadastraUsuarioComSucesso() {
        funcionario.setLogin("joaouser");
        funcionario.setSenha("senha123");

        assertTrue(funcionario.cadastraUsuario());
    }

    @Test
    public void testCadastraUsuarioSemLogin() {
        funcionario.setSenha("senha123");

        assertFalse(funcionario.cadastraUsuario());
    }

    @Test
    public void testCadastraUsuarioSemSenha() {
        funcionario.setLogin("joaouser");

        assertFalse(funcionario.cadastraUsuario());
    }

    @Test
    public void testAcessaSistemaComSucesso() {
        funcionario.setLogin("joaouser");
        funcionario.setSenha("senha123");

        assertTrue(funcionario.acessaSistema("joaouser", "senha123"));
    }

    @Test
    public void testAcessaSistemaLoginIncorreto() {
        funcionario.setLogin("joaouser");
        funcionario.setSenha("senha123");

        assertFalse(funcionario.acessaSistema("usererrado", "senha123"));
    }

    @Test
    public void testAcessaSistemaSenhaIncorreta() {
        funcionario.setLogin("joaouser");
        funcionario.setSenha("senha123");

        assertFalse(funcionario.acessaSistema("joaouser", "senhaerrada"));
    }
}
