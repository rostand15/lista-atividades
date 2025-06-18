import java.time.LocalDate;
import java.time.Period;

public class AtividadePrazo extends Atividade{

    public AtividadePrazo() {
        super();
    }

    public AtividadePrazo(String titulo, String descricao, String usuario, LocalDate prazo){
        super(titulo, descricao, usuario, prazo);

    }


    public String verificarPrazo(){

        LocalDate prazo = getPrazo();
        LocalDate hoje = LocalDate.now();

        Period periodo = Period.between(hoje, prazo);

        if (!prazo.isBefore(hoje)){
            return "Entregue dentro do prazo";
        } else{
            return "Entregue com atraso";
        }

    }

    @Override
    public String toString() {
        return super.toString() + " | Tipo: Com Prazo";
    }

    @Override
    public String verificar() {
        return super.verificar() + verificarPrazo();
    }
}
