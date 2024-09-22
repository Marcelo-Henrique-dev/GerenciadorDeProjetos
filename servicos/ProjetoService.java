package servicos;

import java.util.ArrayList;

import entidades.Projeto;
import entidades.ProjetoDesenvolvimento;
import entidades.ProjetoPesquisa;
import entidades.enums.EnumProjetoException;
import entidades.enums.TipoProjeto;
import exceptions.InvalidProjetoTypeException;
import repositorios.ProjetosRepositorio;

public class ProjetoService {
    private ProjetosRepositorio projetoRepositorio = new ProjetosRepositorio();

    public void adicionarProjeto(String nome, int orcamento, TipoProjeto tipoProjeto, String linguagemPrincipal, String framework, String areaPesquisa, String instituicaoFinanciadora) throws InvalidProjetoTypeException {
        Projeto projeto = criarProjeto(nome, orcamento, tipoProjeto, linguagemPrincipal, framework, areaPesquisa, instituicaoFinanciadora);
        if(projeto != null){
            projetoRepositorio.cadastrarProjeto(projeto);
            System.out.println("Projeto cadastrado com sucesso!");
        }else{
            throw new InvalidProjetoTypeException(EnumProjetoException.TipoProjetoInvalido.toString());
        }
    }

    private Projeto criarProjeto(String nome, int orcamento, TipoProjeto tipoProjeto, String linguagemPrincipal, String framework, String areaPesquisa, String instituicaoFinanciadora){
        switch(tipoProjeto){
            case DESENVOLVIMENTO:
                return new ProjetoDesenvolvimento(nome, orcamento, linguagemPrincipal, framework);
            case PESQUISA:
                return new ProjetoPesquisa(nome, orcamento, areaPesquisa, instituicaoFinanciadora);
            default:
                return null;
        }
    }

    public void listarProjetos() {
        ArrayList<Projeto> projetos = projetoRepositorio.listarProjetos();
        if (projetos.isEmpty()) {
            System.out.println("Nenhum projeto encontrado.");
        } else {
            for (int i = 0; i < projetos.size(); i++) {
                Projeto p = projetos.get(i);
                String tipoProjeto = p.getTipo().toString();
                String detalhes = "";
    
                if (p instanceof ProjetoDesenvolvimento) {
                    ProjetoDesenvolvimento projetoDev = (ProjetoDesenvolvimento) p;
                    detalhes = "Linguagem: " + projetoDev.getLinguagemPrincipal() + " | Framework: " + projetoDev.getFramework();
                } else if (p instanceof ProjetoPesquisa) {
                    ProjetoPesquisa projetoPesquisa = (ProjetoPesquisa) p;
                    detalhes = "Área de Pesquisa: " + projetoPesquisa.getAreaPesquisa() + " | Financiadora: " + projetoPesquisa.getInstituicaoFinanciadora();
                }
                System.out.println((i + 1) + ". " + p.getNome() + " | Orçamento: " + p.getOrcamento() + " | Tipo: " + tipoProjeto + " | " + detalhes);
            }
        }
    }
    

}
