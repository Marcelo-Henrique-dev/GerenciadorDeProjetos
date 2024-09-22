package entidades;

import java.util.ArrayList;
import java.util.List;

import entidades.enums.TipoProjeto;

public class ProjetoDesenvolvimento extends Projeto {
    private String linguagemPrincipal;
    private String framework;
    private ArrayList<Colaborador> colaboradoresDesenvolvimento;

    public ProjetoDesenvolvimento(String nome, int orcamento, String linguagemPrincipal, String framework) {
        super(nome, orcamento, TipoProjeto.DESENVOLVIMENTO);
        this.linguagemPrincipal = linguagemPrincipal;
        this.framework = framework;
    }

    // Getters e Setters para os novos atributos
    public String getLinguagemPrincipal() {
        return linguagemPrincipal;
    }

    public void setLinguagemPrincipal(String linguagemPrincipal) {
        this.linguagemPrincipal = linguagemPrincipal;
    }

    public String getFramework() {
        return framework;
    }

    public void setFramework(String framework) {
        this.framework = framework;
    }
    
}
