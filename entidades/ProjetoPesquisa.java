package entidades;

import entidades.enums.TipoProjeto;

public class ProjetoPesquisa extends Projeto {
    public ProjetoPesquisa(String nome, int orcamento){
        super(nome, orcamento, TipoProjeto.PESQUISA);
    }
}
