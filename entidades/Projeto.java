package entidades;

import java.util.ArrayList;

import entidades.enums.TipoProjeto;

public abstract class Projeto {
    private String nome;
    private int orcamento;
    private TipoProjeto tipoProjeto;
    private ArrayList<Colaborador> colaboradores;

    public Projeto(String nome, int orcamento, TipoProjeto tipoProjeto){
        this.nome = nome;
        this.orcamento = orcamento;
        this.tipoProjeto = tipoProjeto;
        this.colaboradores = new ArrayList<Colaborador>();
    }

    public String getNome(){
        return this.nome;
    }
    public int getOrcamento(){
        return this.orcamento;
    }
    public TipoProjeto getTipo(){
        return this.tipoProjeto;
    }
    public ArrayList<Colaborador> getColaboradores(){
        return this.colaboradores;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setOrcamento(int orcamento){
        this.orcamento = orcamento;
    }

    public void cadastrarColaborador(Colaborador colaborador){
        colaboradores.add(colaborador);
    }

    public ArrayList<Colaborador> listarColaboradores(){
        return colaboradores;
    }

}
