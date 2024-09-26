package main.java.agencia;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PassagemAerea {

    private Aeroporto aeroportoOrigem;
    private Aeroporto aeroportoDestino;
    private LocalDate dataHoraVoo;
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

    // Construtor
    public PassagemAerea(Aeroporto aeroportoOrigem, Aeroporto aeroportoDestino, LocalDate dataHoraVoo, 
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

    public static List<PassagemAerea> getPassagensCadastradas() {
        return passagensCadastradas;
    }

    public static void setPassagensCadastradas(List<PassagemAerea> passagensCadastradas) {
        PassagemAerea.passagensCadastradas = passagensCadastradas;
    }

    public static List<PassagemAerea> pesquisarPassagens(Aeroporto aeroportoOrigem, Aeroporto aeroportoDestino, String dataVoo) {
        List<PassagemAerea> resultadoPesquisa = new ArrayList<>();

        for (PassagemAerea passagem : passagensCadastradas) {
            if (passagem.getAeroportoOrigem().getSigla().equalsIgnoreCase(aeroportoOrigem.getSigla()) &&
                passagem.getAeroportoDestino().getSigla().equalsIgnoreCase(aeroportoDestino.getSigla()) &&
                passagem.getDataHoraVoo().toString().startsWith(dataVoo)) { 
                resultadoPesquisa.add(passagem);
            }
        }
        return resultadoPesquisa;
    }

    public Aeroporto getAeroportoOrigem() { return aeroportoOrigem; }
    public void setAeroportoOrigem(Aeroporto aeroportoOrigem) { this.aeroportoOrigem = aeroportoOrigem; }

    public Aeroporto getAeroportoDestino() { return aeroportoDestino; }
    public void setAeroportoDestino(Aeroporto aeroportoDestino) { this.aeroportoDestino = aeroportoDestino; }

    public LocalDate getDataHoraVoo() { return dataHoraVoo; }
    public void setDataHoraVoo(LocalDate dataHoraVoo) { this.dataHoraVoo = dataHoraVoo; }

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
            case "basica":
                return tarifaBasica + TAXA_AGENCIA;
            case "business":
                return tarifaBusiness + TAXA_AGENCIA;
            case "premium":
                return tarifaPremium + TAXA_AGENCIA;
            default:
                throw new IllegalArgumentException("Classe inválida: " + classe);
        }
    }

    public double calcularTarifaTotalComBagagens(String classe, int quantidadeBagagens) {
        double tarifaTotal = calcularTarifaTotal(classe);
        if (quantidadeBagagens > 1) {
            tarifaTotal += valorPrimeiraBagagem + (quantidadeBagagens - 1) * valorBagagensAdicionais;
        } else if (quantidadeBagagens == 1) {
            tarifaTotal += valorPrimeiraBagagem;
        }
        return tarifaTotal;
    }

    public double calcularRemuneracaoAgencia() {
        return TAXA_AGENCIA;
    }
}