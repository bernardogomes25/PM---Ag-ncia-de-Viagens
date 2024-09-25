package main.java.agencia;
import java.util.ArrayList;
import java.util.List;

public class Aeroporto {
    public String nome;
    public String sigla;
    public String cidade;
    public String estado;
    public String pais;

    private static List<Aeroporto> aeroportosCadastrados = new ArrayList<>();

    
    public Aeroporto(String nome, String sigla, String cidade, String estado, String pais) {
        this.nome = nome;
        this.sigla = sigla;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }

    public boolean cadastraAeroporto() {
        if (aeroportoJaCadastrado(this)) {
            System.out.println("Aeroporto já cadastrado!");
            return false;
        } else {
            aeroportosCadastrados.add(this);
            System.out.println("Aeroporto cadastrado com sucesso!");
            return true;
        }
    }

    // Método para verificar se o aeroporto já está cadastrado
    private boolean aeroportoJaCadastrado(Aeroporto novoAeroporto) {
        for (Aeroporto aeroporto : aeroportosCadastrados) {
            if (aeroporto.sigla.equalsIgnoreCase(novoAeroporto.sigla)) {
                return true;
            }
        }
        return false;
    }
}
