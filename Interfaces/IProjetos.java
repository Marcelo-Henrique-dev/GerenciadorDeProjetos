package Interfaces;

import java.util.ArrayList;

import entidades.Projeto;

public interface IProjetos {
    public void cadastrarProjeto(Projeto projeto);
    public ArrayList<Projeto> listarProjetos();
}
