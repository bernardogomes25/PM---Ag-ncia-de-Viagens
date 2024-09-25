package main.java.agencia;
public class CompanhiaAerea {
    private String nome;
    private int codCompanhia;
    private String razaoSocial;
    private String CNPJ;
    private double primeiraBagagem;
    private double bagagemAdicional;

    // Construtor
    public CompanhiaAerea(String nome, int codCompanhia, String razaoSocial, String CNPJ, double primeiraBagagem, double bagagemAdicional) {
        this.nome = nome;
        this.codCompanhia = codCompanhia;
        this.razaoSocial = razaoSocial;
        this.CNPJ = CNPJ;
        this.primeiraBagagem = primeiraBagagem;
        this.bagagemAdicional = bagagemAdicional;
    }

    public boolean cadastraCompanhia() {
        // Lógica para cadastrar a companhia
        // Retorna true se o cadastro for bem-sucedido
        return true;
    }

    public double defineValorBagagens() {
        // Lógica para definir o valor das bagagens
        // Retorna o valor total das bagagens
        return primeiraBagagem + bagagemAdicional;
    }

    public void definePrimeiraBagagem(double valor) {
        this.primeiraBagagem = valor;
    }
    
    public void defineBagagemAdicional(double valor) {
        this.bagagemAdicional = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodCompanhia() {
        return codCompanhia;
    }

    public void setCodCompanhia(int codCompanhia) {
        this.codCompanhia = codCompanhia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public double getPrimeiraBagagem() {
        return primeiraBagagem;
    }

    public void setPrimeiraBagagem(double primeiraBagagem) {
        this.primeiraBagagem = primeiraBagagem;
    }

    public double getBagagemAdicional() {
        return bagagemAdicional;
    }

    public void setBagagemAdicional(double bagagemAdicional) {
        this.bagagemAdicional = bagagemAdicional;
    }
}