package entidades;

import entidades.enums.TipoProjeto;

public abstract class Projeto {
    private int idProjeto;
    private String nome;
    private int orcamento;
    private TipoProjeto tipoProjeto;

    public Projeto(String nome, int orcamento, TipoProjeto tipoProjeto){
        this.nome = nome;
        this.orcamento = orcamento;
        this.tipoProjeto = tipoProjeto;
    }

    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public int getOrcamento(){
        return this.orcamento;
    }
    public void setOrcamento(int orcamento){
        this.orcamento = orcamento;
    }
    public TipoProjeto getTipo(){
        return this.tipoProjeto;
    }
    public void setTipo(TipoProjeto tipoProjeto){
        this.tipoProjeto = tipoProjeto;
    }
    public int getIdProjeto(){
        return this.idProjeto;
    }
    public void setIdProjeto(int idProjeto){
        this.idProjeto = idProjeto;
    }
}
