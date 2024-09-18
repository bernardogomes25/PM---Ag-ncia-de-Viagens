import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aeroporto {
    public String nome;
    public String sigla;
    public String cidade;
    public String estado;
    public String pais;

    private static List<Aeroporto> aeroportosCadastrados = new ArrayList<>();

    public boolean cadastraAeroporto() {
        Scanner sc = new Scanner(System.in);

        System.out.print("DIGITE O NOME: ");
        this.nome = sc.nextLine();

        System.out.print("DIGITE A SIGLA: ");
        this.sigla = sc.nextLine();

        System.out.print("DIGITE A CIDADE: ");
        this.cidade = sc.nextLine();

        System.out.print("DIGITE O ESTADO: ");
        this.estado = sc.nextLine();

        System.out.print("DIGITE O PAÍS: ");
        this.pais = sc.nextLine();

        
        if (aeroportoJaCadastrado(this)) {
            System.out.println("Aeroporto já cadastrado!");
            sc.close();
            return false;
        } else {
            aeroportosCadastrados.add(this);
            System.out.println("Aeroporto cadastrado com sucesso!");
            sc.close();
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
