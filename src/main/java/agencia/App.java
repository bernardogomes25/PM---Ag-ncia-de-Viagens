package main.java.agencia;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        Aeroporto confins = new Aeroporto("Confins", "CNF", "Belo Horizonte", "MG", "Brasil");
        confins.cadastraAeroporto();

        Voo voo = new Voo("CNF", "GRU", LocalDate.of(2021, 10, 10), "GOL", 1000.0, 2000.0, 3000.0, 100.0, 50.0, "BRL");
        System.out.println("Código do voo: " + voo.getCodigoVoo());
        System.out.println("Origem: " + voo.getOrigem());
        System.out.println("Destino: " + voo.getDestino());
        System.out.println("Data e Hora: " + voo.getDataHora());
        System.out.println("Companhia Aérea: " + voo.getCompanhiaAerea());
        System.out.println("Tarifa Básica: " + voo.getTarifaBasica());
        System.out.println("Tarifa Business: " + voo.getTarifaBusiness());
        System.out.println("Tarifa Premium: " + voo.getTarifaPremium());
        System.out.println("Valor Primeira Bagagem: " + voo.getValorPrimeiraBagagem());
        System.out.println("Valor Bagagens Adicionais: " + voo.getValorBagagensAdicionais());
        System.out.println("Moeda: " + voo.getMoeda());

        Aeroporto aeroportoOrigem = new Aeroporto("Confins", "CNF", "Belo Horizonte", "MG", "Brasil");
        Aeroporto aeroportoDestino = new Aeroporto("Guarulhos", "GRU", "São Paulo", "SP", "Brasil");

        PassagemAerea passagem = new PassagemAerea("CNF", "GRU", LocalDate.of(2021, 10, 10), "GOL", 1000.0, 2000.0, 3000.0, 100.0, 50.0, "BRL");

        System.out.println("Tarifa Total: " + passagem.calcularTarifaTotal("basica"));
        System.out.println("Tarifa Total com Bagagens: " + passagem.calcularTarifaTotalComBagagens("basica", 2));
        System.out.println("Remuneração da Agência: " + passagem.calcularRemuneracaoAgencia());

        CompanhiaAerea companhia = new CompanhiaAerea("Airline", 123, "Airline S.A.", "00.000.000/0001-00", 50.0, 30.0);

        companhia.definePrimeiraBagagem(60.0);
        companhia.defineBagagemAdicional(40.0);

        System.out.println("Nome: " + companhia.getNome());
        System.out.println("Código da Companhia: " + companhia.getCodCompanhia());
        System.out.println("Razão Social: " + companhia.getRazaoSocial());
        System.out.println("CNPJ: " + companhia.getCNPJ());

        double valorTotalBagagens = companhia.defineValorBagagens();
        System.out.println("Valor Total das Bagagens: " + valorTotalBagagens);

        Aeroporto aeroporto = new Aeroporto("Confins", "CNF", "Belo Horizonte", "MG", "Brasil");
        aeroporto.cadastraAeroporto();

        Voo voo1 = new Voo("São Paulo", "Rio de Janeiro", LocalDate.of(2024, 10, 1), "Companhia A", 200.0, 400.0, 600.0, 50.0, 30.0, "BRL");

        Voo voo2 = new Voo("Salvador", "Fortaleza", LocalDate.of(2024, 10, 2), "Companhia B", 150.0, 300.0, 450.0, 40.0, 20.0, "BRL");

        System.out.println("Código do Voo 1: " + voo1.getCodigoVoo());
        System.out.println("Código do Voo 2: " + voo2.getCodigoVoo());

        System.out.println("Tarifa Básica do Voo 1: " + voo1.calculaTarifa("basica"));
        System.out.println("Tarifa Business do Voo 1: " + voo1.calculaTarifa("business"));
        System.out.println("Tarifa Premium do Voo 1: " + voo1.calculaTarifa("premium"));
        
        System.out.println("Valor da Bagagem 1 do Voo 1: " + voo1.calculaBagagem(1));
        System.out.println("Valor da Bagagem 2 do Voo 1: " + voo1.calculaBagagem(2));

        System.out.println("Verifica Aeroporto de Origem do Voo 1: " + voo1.verificaAeroporto("São Paulo"));
        System.out.println("Verifica Aeroporto de Destino do Voo 1: " + voo1.verificaAeroporto("Rio de Janeiro"));
        System.out.println("Verifica Aeroporto Inexistente do Voo 1: " + voo1.verificaAeroporto("Brasília"));

        System.out.println("Verifica Companhia do Voo 1: " + voo1.verificaCompanhia("Companhia A"));
        System.out.println("Verifica Companhia Inexistente do Voo 1: " + voo1.verificaCompanhia("Companhia B"));

        System.out.println("Verifica Moeda do Voo 1: " + voo1.verificaMoeda("BRL"));
        System.out.println("Verifica Moeda Inexistente do Voo 1: " + voo1.verificaMoeda("USD"));

        Voo[] voos = { voo1, voo2 };
        Voo resultado = Voo.pesquisaVoo(voos, voo1.getCodigoVoo());
        System.out.println("Pesquisa Voo 1: " + resultado.getCodigoVoo());

        Voo resultadoInexistente = Voo.pesquisaVoo(voos, "inexistente");
        System.out.println("Pesquisa Voo Inexistente: " + resultadoInexistente);

        System.out.println("Fim da execução!");
    }
}