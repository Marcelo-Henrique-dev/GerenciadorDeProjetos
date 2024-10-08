package entidades;

public class Tarefa {
    private int idTarefa;
    private String nome;
    private String descicao;
    private int prioridade;

    public Tarefa(String nome, String descricao, int prioridade){
        this.nome = nome;
        this.descicao = descricao;
        this.prioridade = prioridade;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }
    public void setDescricao(String descicao){
        this.descicao = descicao;
    }
    public String getDescricao(){
        return this.descicao;
    }
    public void setPrioridade(int prioridade){
        this.prioridade = prioridade;
    }
    public int getPrioridade(){
        return this.prioridade;
    }
    public void setId(int id){
        this.idTarefa = id;
    }
    public int getId(){
        return this.idTarefa;
    }

}
