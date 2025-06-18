public class AtividadeComum extends Atividade{

    public AtividadeComum(){

    }

    public AtividadeComum(String titulo, String descricao, String usuario) {
        super(titulo, descricao, usuario);
    }

    @Override
    public String toString() {
        return super.toString() + " | Tipo: Comum";
    }

    @Override
    public String verificar() {
        return super.verificar();
    }
}
