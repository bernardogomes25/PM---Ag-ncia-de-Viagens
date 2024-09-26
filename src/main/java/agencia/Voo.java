package main.java.agencia;
import java.time.LocalDate;

public class Voo {
    private String codigoVoo;
    private String origem;
    private String destino;
    private LocalDate dataHora;
    private String companhiaAerea;
    private double tarifaBasica;
    private double tarifaBusiness;
    private double tarifaPremium;
    private double valorPrimeiraBagagem;
    private double valorBagagensAdicionais;
    private String moeda;

    public Voo(String origem, String destino, LocalDate dataHora, String companhiaAerea, double tarifaBasica,
            double tarifaBusiness, double tarifaPremium, double valorPrimeiraBagagem, double valorBagagensAdicionais,
            String moeda) {
        this.origem = origem;
        this.destino = destino;
        this.dataHora = dataHora;
        this.companhiaAerea = companhiaAerea;
        this.tarifaBasica = tarifaBasica;
        this.tarifaBusiness = tarifaBusiness;
        this.tarifaPremium = tarifaPremium;
        this.valorPrimeiraBagagem = valorPrimeiraBagagem;
        this.valorBagagensAdicionais = valorBagagensAdicionais;
        this.moeda = moeda;
        this.codigoVoo = geraCodigoVoo();
    }

    public String getCodigoVoo() {
        return codigoVoo;
    }

    public void setCodigoVoo(String codigoVoo) {
        this.codigoVoo = codigoVoo;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public LocalDate getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDate dataHora) {
        this.dataHora = dataHora;
    }

    public String getCompanhiaAerea() {
        return companhiaAerea;
    }

    public void setCompanhiaAerea(String companhiaAerea) {
        this.companhiaAerea = companhiaAerea;
    }

    public double getTarifaBasica() {
        return tarifaBasica;
    }

    public void setTarifaBasica(double tarifaBasica) {
        this.tarifaBasica = tarifaBasica;
    }

    public double getTarifaBusiness() {
        return tarifaBusiness;
    }

    public void setTarifaBusiness(double tarifaBusiness) {
        this.tarifaBusiness = tarifaBusiness;
    }

    public double getTarifaPremium() {
        return tarifaPremium;
    }

    public void setTarifaPremium(double tarifaPremium) {
        this.tarifaPremium = tarifaPremium;
    }

    public double getValorPrimeiraBagagem() {
        return valorPrimeiraBagagem;
    }

    public void setValorPrimeiraBagagem(double valorPrimeiraBagagem) {
        this.valorPrimeiraBagagem = valorPrimeiraBagagem;
    }

    public double getValorBagagensAdicionais() {
        return valorBagagensAdicionais;
    }

    public void setValorBagagensAdicionais(double valorBagagensAdicionais) {
        this.valorBagagensAdicionais = valorBagagensAdicionais;
    }

    public String getMoeda() {
        return moeda;
    }

    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }

    public double calculaTarifa(String classe) {
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
            default -> {
                return 0.0;
            }
        }
    }

    public double calculaBagagem(int quantidade) {
        if (quantidade == 1) {
            return valorPrimeiraBagagem;
        } else {
            return valorPrimeiraBagagem + (quantidade - 1) * valorBagagensAdicionais;
        }
    }

    public boolean verificaAeroporto(String aeroporto) {
        return aeroporto.equalsIgnoreCase(origem) || aeroporto.equalsIgnoreCase(destino);
    }

    public boolean verificaCompanhia(String companhia) {
        return companhia.equalsIgnoreCase(companhiaAerea);
    }

    public boolean verificaMoeda(String moeda) {
        return moeda.equalsIgnoreCase(this.moeda);
    }

    public String geraCodigoVoo() {
        return origem + "-" + destino + "-" + dataHora.toString();
    }

    public static Voo pesquisaVoo(Voo[] voos, String codigoVoo) {
        for (Voo voo : voos) {
            if (voo.codigoVoo.equalsIgnoreCase(codigoVoo)) {
                return voo;
            }
        }
        return null;
    }

}