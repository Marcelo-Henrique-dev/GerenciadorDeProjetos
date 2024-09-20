package entidades;

import entidades.enums.TipoProjeto;

public class ProjetoPesquisa extends Projeto {
    private String areaPesquisa;
    private String instituicaoFinanciadora;

    public ProjetoPesquisa(String nome, int orcamento, String areaPesquisa, String instituicaoFinanciadora) {
        super(nome, orcamento, TipoProjeto.PESQUISA);
        this.areaPesquisa = areaPesquisa;
        this.instituicaoFinanciadora = instituicaoFinanciadora;
    }

    // Getters e Setters para os novos atributos
    public String getAreaPesquisa() {
        return areaPesquisa;
    }

    public void setAreaPesquisa(String areaPesquisa) {
        this.areaPesquisa = areaPesquisa;
    }

    public String getInstituicaoFinanciadora() {
        return instituicaoFinanciadora;
    }

    public void setInstituicaoFinanciadora(String instituicaoFinanciadora) {
        this.instituicaoFinanciadora = instituicaoFinanciadora;
    }
}
