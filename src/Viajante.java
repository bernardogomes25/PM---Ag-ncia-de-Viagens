public class Viajante {

    private String nome;
    private String cpf;
    private String email;
    private String rg;
    private String passaporte;

    public Viajante() {

    }

    public Viajante(String nome, String cpf, String email, String rg, String passaporte) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.rg = rg;
        this.passaporte = passaporte;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getPassaporte() {
        return passaporte;
    }

    public void setPassaporte(String passaporte) {
        this.passaporte = passaporte;
    }

    public boolean cadastraViajante() {
        
        if (nome == null || nome.isEmpty()) {
            System.out.println("Erro: O nome é obrigatório.");
            return false;
        }
        if (cpf == null || cpf.isEmpty()) {
            System.out.println("Erro: O CPF é obrigatório.");
            return false;
        }
        if (email == null || email.isEmpty()) {
            System.out.println("Erro: O email é obrigatório.");
            return false;
        }
        if (rg == null || rg.isEmpty()) {
            System.out.println("Erro: O RG é obrigatório.");
            return false;
        }
        if (passaporte == null || passaporte.isEmpty()) {
            System.out.println("Erro: O passaporte é obrigatório.");
            return false;
        }
    
       
        System.out.println("Viajante cadastrado com sucesso!");
        return true;
    }
    
}
