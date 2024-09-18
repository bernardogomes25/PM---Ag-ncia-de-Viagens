import java.util.List;
import java.time.LocalDate;

public class Voo {
    public LocalDate horario;
    public String codVoo;
    public double tarifaBasica;
    public double tarifaPremium;
    public double tarifaBusiness;
    public int bagagem;
    public String moeda;

    public boolean verificaAeroportoCadastrado(List<Aeroporto> aeroportos, String siglaAeroporto) {
        for (Aeroporto aeroporto : aeroportos) {
            if (aeroporto.sigla.equalsIgnoreCase(siglaAeroporto)) {
                return true;
            }
        }
        return false;
    }

}