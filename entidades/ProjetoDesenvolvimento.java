package entidades;

import entidades.enums.TipoProjeto;

public class ProjetoDesenvolvimento extends Projeto {
    public ProjetoDesenvolvimento(String nome, int orcamento){
        super(nome, orcamento, TipoProjeto.DESENVOLVIMENTO);
    }
}
