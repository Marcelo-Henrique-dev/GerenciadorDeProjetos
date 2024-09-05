package entidades;

import interfaces.IColaboracao;

public class Tarefa implements IColaboracao {
    private String nome;
    private int prioridade;
    private boolean tarefaFeita;

    public Tarefa(String nome, int prioridade){
        this.nome = nome;
        this.prioridade = prioridade;
        this.tarefaFeita = false;
    }

    public String getNome(){
        return this.nome;
    }

    public int getPrioridade(){
        return this.prioridade;
    }
    public boolean tarefaFeita(){
        return this.tarefaFeita;
    }

    @Override
    public void realizarTarefa() {
        this.tarefaFeita = true;
    }

}
