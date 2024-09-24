package main.java.agencia;


public class PassagemAerea {

    private String aeroportoOrigem;
    private String aeroportoDestino;
    private String dataHoraVoo;
    private String codigoVoo;
    private String companhiaAerea;
    private double tarifaBasica;
    private double tarifaBusiness;
    private double tarifaPremium;
    private double valorPrimeiraBagagem;
    private double valorBagagensAdicionais;
    private String moeda;
    

    private static final double TAXA_AGENCIA = 50.0; 

    public PassagemAerea(String aeroportoOrigem, String aeroportoDestino, String dataHoraVoo, 
                         String codigoVoo, String companhiaAerea, double tarifaBasica, 
                         double tarifaBusiness, double tarifaPremium, double valorPrimeiraBagagem, 
                         double valorBagagensAdicionais, String moeda) {
        this.aeroportoOrigem = aeroportoOrigem;
        this.aeroportoDestino = aeroportoDestino;
        this.dataHoraVoo = dataHoraVoo;
        this.codigoVoo = codigoVoo;
        this.companhiaAerea = companhiaAerea;
        this.tarifaBasica = tarifaBasica;
        this.tarifaBusiness = tarifaBusiness;
        this.tarifaPremium = tarifaPremium;
        this.valorPrimeiraBagagem = valorPrimeiraBagagem;
        this.valorBagagensAdicionais = valorBagagensAdicionais;
        this.moeda = moeda;
    }

    public String getAeroportoOrigem() { return aeroportoOrigem; }
    public void setAeroportoOrigem(String aeroportoOrigem) { this.aeroportoOrigem = aeroportoOrigem; }
    
    public String getAeroportoDestino() { return aeroportoDestino; }
    public void setAeroportoDestino(String aeroportoDestino) { this.aeroportoDestino = aeroportoDestino; }
    
    public String getDataHoraVoo() { return dataHoraVoo; }
    public void setDataHoraVoo(String dataHoraVoo) { this.dataHoraVoo = dataHoraVoo; }
    
    public String getCodigoVoo() { return codigoVoo; }
    public void setCodigoVoo(String codigoVoo) { this.codigoVoo = codigoVoo; }
    
    public String getCompanhiaAerea() { return companhiaAerea; }
    public void setCompanhiaAerea(String companhiaAerea) { this.companhiaAerea = companhiaAerea; }
    
    public double getTarifaBasica() { return tarifaBasica; }
    public void setTarifaBasica(double tarifaBasica) { this.tarifaBasica = tarifaBasica; }
    
    public double getTarifaBusiness() { return tarifaBusiness; }
    public void setTarifaBusiness(double tarifaBusiness) { this.tarifaBusiness = tarifaBusiness; }
    
    public double getTarifaPremium() { return tarifaPremium; }
    public void setTarifaPremium(double tarifaPremium) { this.tarifaPremium = tarifaPremium; }
    
    public double getValorPrimeiraBagagem() { return valorPrimeiraBagagem; }
    public void setValorPrimeiraBagagem(double valorPrimeiraBagagem) { this.valorPrimeiraBagagem = valorPrimeiraBagagem; }
    
    public double getValorBagagensAdicionais() { return valorBagagensAdicionais; }
    public void setValorBagagensAdicionais(double valorBagagensAdicionais) { this.valorBagagensAdicionais = valorBagagensAdicionais; }
    
    public String getMoeda() { return moeda; }
    public void setMoeda(String moeda) { this.moeda = moeda; }


    public double calcularTarifaTotal(String classe) {
        switch (classe.toLowerCase()) {
            case "basica" -> {
                return tarifaBasica;
            }
            case "business" -> {
                return tarifaBusiness;
            }
            case "premium" -> {
                return tarifaPremium;
            }
            default -> throw new IllegalArgumentException("Classe inválida.");
            }
        }

    public double calcularTarifaTotalComBagagens(String classe, int numBagagensAdicionais) {
        double tarifa = calcularTarifaTotal(classe);
        return tarifa + valorPrimeiraBagagem + valorBagagensAdicionais * numBagagensAdicionais;
    }
    

    public double calcularRemuneracaoAgencia() {
        return TAXA_AGENCIA;
    }
    

    @Override
    public String toString() {
        return "PassagemAerea{" +
                "aeroportoOrigem='" + aeroportoOrigem + '\'' +
                ", aeroportoDestino='" + aeroportoDestino + '\'' +
                ", dataHoraVoo='" + dataHoraVoo + '\'' +
                ", codigoVoo='" + codigoVoo + '\'' +
                ", companhiaAerea='" + companhiaAerea + '\'' +
                ", tarifaBasica=" + tarifaBasica +
                ", tarifaBusiness=" + tarifaBusiness +
                ", tarifaPremium=" + tarifaPremium +
                ", valorPrimeiraBagagem=" + valorPrimeiraBagagem +
                ", valorBagagensAdicionais=" + valorBagagensAdicionais +
                ", moeda='" + moeda + '\'' +
                '}';
    }

    public static void main(String[] args) {
        PassagemAerea passagem = new PassagemAerea("GRU", "SFO", "2024-10-01T15:30:00", "AA1234", "American Airlines",
                1500.00, 3000.00, 4500.00, 100.00, 50.00, "BRL");
        
        System.out.println(passagem);
        System.out.println("Tarifa Básica: " + passagem.calcularTarifaTotal("basica"));
        System.out.println("Tarifa Business com 2 bagagens adicionais: " + passagem.calcularTarifaTotalComBagagens("business", 2));
        System.out.println("Remuneração da Agência: " + passagem.calcularRemuneracaoAgencia());
    }

    public static double getTaxaAgencia() {
        return TAXA_AGENCIA;
    }
} 
