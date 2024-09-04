package entidades;

import java.util.ArrayList;

public class Colaborador {
    private String nome;
    private String cargo;
    private int anosExperiencia;
    private ArrayList<Tarefa> tarefas;

    public Colaborador(String nome, String cargo, int anosExperiencia){
        this.nome = nome;
        this.cargo = cargo;
        this.anosExperiencia = anosExperiencia;
        this.tarefas = new ArrayList<Tarefa>();
    }

    public void realizarTarefa(Tarefa tarefa){
        System.out.println("O colaborador "+nome+" está realizando a tarefa "+tarefa.getNome());
        tarefa.realizarTarefa();
    }

    public String getCargo(){
        return this.cargo;
    }
    public int getAnosExperiencia(){
        return this.anosExperiencia;
    }

    public void atribuirTarefa(Tarefa tarefa){
        tarefas.add(tarefa);
    }

}
