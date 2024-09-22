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
        this.colaboradoresDesenvolvimento = new ArrayList<Colaborador>();
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

    public void adicionarColaboradorDesenvolvimento(Colaborador colaborador) {
        colaboradoresDesenvolvimento.add(colaborador);
    }

    public List<Colaborador> listarColaboradoresDesenvolvimento() {
        return colaboradoresDesenvolvimento;
    }
    public Colaborador buscarColaboradorPorId(int id) {
        for (Colaborador colaborador : colaboradoresDesenvolvimento) {
            if (colaborador.getId() == id) {
                return colaborador;
            }
        }
        System.out.println("Colaborador Não encontrado");
        return null;
    }
    
    public void atualizarColaborador(Colaborador colaborador) {
        for (int i = 0; i < colaboradoresDesenvolvimento.size(); i++) {
            if (colaboradoresDesenvolvimento.get(i).getId() == colaborador.getId()) {
                colaboradoresDesenvolvimento.set(i, colaborador);
                break;
            }
        }
    }

    public void removerColaborador(int id) {
        colaboradoresDesenvolvimento.removeIf(colaborador -> colaborador.getId() == id);
    }
    
}
