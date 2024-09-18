import java.util.Scanner;

public class Aeroporto {
    public String nome;
    public String sigla;
    public String cidade;
    public String estado;
    public String pais;

    public void cadastraAeroporto() {
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
        
        sc.close();
    }
}