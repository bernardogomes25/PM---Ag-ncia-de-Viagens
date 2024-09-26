package main.java.agencia;
public class FuncionariosAgencia {

    private String nome;
    private String cpf;
    private String email;
    private String login;
    private String senha;

    public FuncionariosAgencia() {

    }

    public FuncionariosAgencia(String nome, String cpf, String email, String login, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.login = login;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean cadastraFuncionario() {
        if (nome == null || nome.isEmpty()) {
            System.out.println("Erro: O nome é obrigatório.");
            return false;
        }

        if (cpf == null || cpf.isEmpty()) {
            System.out.println("Erro: O CPF é obrigatório.");
            return false;
        }
        if (email == null || email.isEmpty()) {
            System.out.println("Erro: O email é obrigatório.");
            return false;
        }

        System.out.println("Funcionario cadastrado com sucesso!");
        return true;
    }

    public boolean cadastraUsuario() {
        if (login == null || login.isEmpty()) {
            System.out.println("Erro: O login é obrigatorio.");
            return false;
        }
        if (senha == null || senha.isEmpty()) {
            System.out.println("Erro: A senha é obrigatoria. ");
            return false;
        }

        System.out.println("Usuario cadastrado com sucesso!");
        return true;

    }

    /*
     * O sistema deve permitir que usuários funcionários da agência de viagem aces-
     * sem o sistema através de login e senha
     */
    public boolean acessaSistema(String login, String senha) {

        if (this.login.equals(login) && this.senha.equals(senha)) {
            System.out.println("Sistema acessado com  sucesso!");
            return true;
        }

        System.out.println("Erro: Login ou senha incorretos.");
        return false;

    }

}
