package repositorios;

import java.util.ArrayList;

import interfaces.IProjetos;
import entidades.Projeto;

public class ProjetosRepositorio implements IProjetos {
    private ArrayList<Projeto> projetos = new ArrayList<Projeto>();

    public Projeto buscarProjetoPorIndice(int index){
        if(index>=0 && index<projetos.size()){
            return projetos.get(index);
        }
        return null;
    }
    
    @Override
    public ArrayList<Projeto> listarProjetos(){
        return projetos;
    }


    @Override
    public void cadastrarProjeto(Projeto projeto) {
        projetos.add(projeto);
    }
}
// CRUD