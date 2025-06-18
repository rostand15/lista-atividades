import java.time.LocalDate;

public abstract class Atividade {

    private String titulo;
    private String status;
    private String descricao;
    private String usuario;
    private LocalDate prazo;

    public Atividade() {
    }

    public Atividade(String titulo, String descricao, String usuario, LocalDate prazo) {
        this.titulo = titulo;
        this.status = "Pendente";
        this.descricao = descricao;
        this.usuario = usuario;
        this.prazo = prazo;
    }

    public Atividade(String titulo, String descricao, String usuario) {
        this.titulo = titulo;
        this.status = "Pendente";
        this.descricao = descricao;
        this.usuario = usuario;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getStatus(){
        return status;
    }

    public LocalDate getPrazo(){
     return prazo;}

    public String getUsuario(){
        return usuario;
    }


    public void atualizarDescricao(String novaDescricao) {
        this.descricao = novaDescricao;
    }

    public void atualizarUsuario(String novoUsuario) {
        this.usuario = novoUsuario;
    }


    public void iniciar(){
        if (status.equals("Pendente")) status = "Em andamento";
    }

    public void finalizar(){
        if (status.equals("Em andamento")) {
            status = "finalizada";
        }
    }

    public void atualizarTitulo(String novotitulo) {
        this.titulo = novotitulo;
    }

    public String toString() {
        return "Titulo: " + titulo + " Status:" + status + " Usuario:" + usuario;
    }

    public String verificar() {
        return "";
    }

}
