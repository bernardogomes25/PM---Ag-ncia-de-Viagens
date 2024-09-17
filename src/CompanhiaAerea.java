public class CompanhiaAerea {
    private String nome;
    private int codCompanhia;
    private String razaoSocial;
    private String CNPJ;
    private double primeiraBagagem;
    private double bagagemAdicional;

    public static void main(String[] args) {
        CompanhiaAerea companhia = new CompanhiaAerea("Airline", 123, "Airline S.A.", "00.000.000/0001-00", 50.0, 30.0);

        companhia.definePrimeiraBagagem(60.0);
        companhia.defineBagagemAdicional(40.0);

        System.out.println("Nome: " + companhia.getNome());
        System.out.println("Código da Companhia: " + companhia.getCodCompanhia());
        System.out.println("Razão Social: " + companhia.razaoSocial);
        System.out.println("CNPJ: " + companhia.CNPJ);

        double valorTotalBagagens = companhia.defineValorBagagens();
        System.out.println("Valor Total das Bagagens: " + valorTotalBagagens);
    }

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