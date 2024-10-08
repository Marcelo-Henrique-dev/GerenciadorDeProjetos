package repositorios;

import java.util.ArrayList;

import entidades.Projeto;

public class ProjetosRepositorio {
    private ArrayList<Projeto> projetos = new ArrayList<Projeto>();

    public ArrayList<Projeto> repositorio(){
        return projetos;
    }
}