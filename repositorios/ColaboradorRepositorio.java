package repositorios;

import java.util.ArrayList;

import entidades.Colaborador;

public class ColaboradorRepositorio {
    private ArrayList<Colaborador> colaboradores = new ArrayList<Colaborador>();
    
    public ArrayList<Colaborador> repositorio(){
        return this.colaboradores;
    }

}
