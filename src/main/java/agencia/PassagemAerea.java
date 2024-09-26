package main.java.agencia;

import java.util.ArrayList;
import java.util.List;

public class PassagemAerea {

    public static List<PassagemAerea> getPassagensCadastradas() {
        return passagensCadastradas;
    }

    public static void setPassagensCadastradas(List<PassagemAerea> passagensCadastradas) {
        PassagemAerea.passagensCadastradas = passagensCadastradas;
    }

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

    private static List<PassagemAerea> passagensCadastradas = new ArrayList<>();

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


        passagensCadastradas.add(this);
    }


    public static List<PassagemAerea> pesquisarPassagens(String aeroportoOrigem, String aeroportoDestino, String dataVoo) {
        List<PassagemAerea> resultadoPesquisa = new ArrayList<>();

        for (PassagemAerea passagem : passagensCadastradas) {
 
            if (passagem.getAeroportoOrigem().equalsIgnoreCase(aeroportoOrigem) &&
                passagem.getAeroportoDestino().equalsIgnoreCase(aeroportoDestino) &&
                passagem.getDataHoraVoo().startsWith(dataVoo)) { 
                resultadoPesquisa.add(passagem);
            }
        }
        return resultadoPesquisa;
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
        return switch (classe.toLowerCase()) {
            case "basica" -> tarifaBasica;
            case "business" -> tarifaBusiness;
            case "premium" -> tarifaPremium;
            default -> throw new IllegalArgumentException("Classe inválida.");
        };
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

    public static void main(String[] args, PassagemAerea passagemAerea) {
  
    

        new PassagemAerea("GRU", "JFK", "2024-10-05T10:00:00", "AA5678", "American Airlines",
                1800.00, 3200.00, 4600.00, 120.00, 60.00, "BRL");

        new PassagemAerea("GRU", "SFO", "2024-11-01T15:30:00", "DL1234", "Delta Airlines",
                1400.00, 2800.00, 4000.00, 110.00, 55.00, "BRL");

 
        List<PassagemAerea> resultadoPesquisa = PassagemAerea.pesquisarPassagens("GRU", "SFO", "2024-10-01");
        
        if (!resultadoPesquisa.isEmpty()) {
            System.out.println("Passagens encontradas:");
            for (PassagemAerea passagem : resultadoPesquisa) {
                System.out.println(passagem);
            }
        } else {
            System.out.println("Nenhuma passagem encontrada.");
        }
    }
}



