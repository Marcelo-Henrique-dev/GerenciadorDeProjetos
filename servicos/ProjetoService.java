package servicos;

import java.util.ArrayList;
import java.util.Scanner;

import entidades.Colaborador;
import entidades.Projeto;
import entidades.ProjetoDesenvolvimento;
import entidades.ProjetoPesquisa;
import entidades.enums.EnumProjetoException;
import entidades.enums.TipoProjeto;
import exceptions.InvalidProjetoTypeException;
import exceptions.ProjetoNotFoundException;
import repositorios.ProjetosRepositorio;

public class ProjetoService {
    private Scanner scanner = new Scanner(System.in);
    private ProjetosRepositorio projetoRepositorio = new ProjetosRepositorio();

    public void adicionarProjeto(String nome, int orcamento, TipoProjeto tipoProjeto, String linguagemPrincipal,
            String framework, String areaPesquisa, String instituicaoFinanciadora, Colaborador[] colaboradoresArray)
            throws InvalidProjetoTypeException {
        Projeto projeto = criarProjeto(nome, orcamento, tipoProjeto, linguagemPrincipal, framework, areaPesquisa,
                instituicaoFinanciadora);
        for (Colaborador colaborador : colaboradoresArray) {
            projeto.cadastrarColaborador(colaborador);
        }
        if (projeto != null) {
            projetoRepositorio.cadastrarProjeto(projeto);
            System.out.println("Projeto cadastrado com sucesso!");
        } else {
            throw new InvalidProjetoTypeException(EnumProjetoException.TipoProjetoInvalido.toString());
        }
    }

    private Projeto criarProjeto(String nome, int orcamento, TipoProjeto tipoProjeto, String linguagemPrincipal,
            String framework, String areaPesquisa, String instituicaoFinanciadora) {
        switch (tipoProjeto) {
            case DESENVOLVIMENTO:
                return new ProjetoDesenvolvimento(nome, orcamento, linguagemPrincipal, framework);
            case PESQUISA:
                return new ProjetoPesquisa(nome, orcamento, areaPesquisa, instituicaoFinanciadora);
            default:
                return null;
        }
    }

    public void apagarProjeto(int index) {
        ArrayList<Projeto> projetos = projetoRepositorio.listarProjetos();
        Projeto projetoSelecionado = projetos.get(index);
        projetos.remove(projetoSelecionado);
    }

    public void listarProjetos() throws ProjetoNotFoundException, InvalidProjetoTypeException {
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
                    detalhes = "Linguagem: " + projetoDev.getLinguagemPrincipal() + " | Framework: "
                            + projetoDev.getFramework();
                } else if (p instanceof ProjetoPesquisa) {
                    ProjetoPesquisa projetoPesquisa = (ProjetoPesquisa) p;
                    detalhes = "Área de Pesquisa: " + projetoPesquisa.getAreaPesquisa() + " | Financiadora: "
                            + projetoPesquisa.getInstituicaoFinanciadora();
                }
                System.out.println(i + ". " + p.getNome() + " | Orçamento: " + p.getOrcamento() + " | Tipo: "
                        + tipoProjeto + " | " + detalhes);
            }
            System.out.println("Deseja editar algum projeto?");
            System.out.println("| 1 - SIM |");
            System.out.println("| 2 - NÃO |");
            int opc = scanner.nextInt();
            scanner.nextLine();
            switch (opc) {
                case 1:
                    System.out.println("Digite qual projeto pelo id:");
                    int pindex = scanner.nextInt();
                    scanner.nextLine();
                    editarProjeto(pindex);
                    break;
                case 2:
                    System.out.println("Deseja Apagar algum projeto?");
                    System.out.println("| 1 - SIM |");
                    System.out.println("| 2 - NÃO |");
                    int deletar = scanner.nextInt();
                    scanner.nextLine();
                    if (deletar == 1) {
                        System.out.println("Escolha pelo id:");
                        int escolhaDelete = scanner.nextInt();
                        scanner.nextLine();
                        apagarProjeto(escolhaDelete);
                    } else {
                        System.out.println("OK saindo...");
                    }
                    break;
                default:
                    System.out.println("Opção Inválida...");
            }
        }
    }

    public void editarProjeto(int index) throws ProjetoNotFoundException, InvalidProjetoTypeException {
        ArrayList<Projeto> projetos = projetoRepositorio.listarProjetos();
        Projeto projetoEscolhido = projetos.get(index);
        if (projetos.contains(projetoEscolhido)) {
            System.out.println("Mudar Nome:");
            String novoNome = scanner.nextLine();
            System.out.println("Novo Orçamento:");
            int novoOrcamento = scanner.nextInt();
            scanner.nextLine();
            projetoEscolhido.setNome(novoNome);
            projetoEscolhido.setOrcamento(novoOrcamento);
            if (projetoEscolhido instanceof ProjetoDesenvolvimento) {
                ProjetoDesenvolvimento projetoDev = (ProjetoDesenvolvimento) projetoEscolhido;
                System.out.println("Nova Linguagem:");
                String novaLinguagem = scanner.nextLine();
                projetoDev.setLinguagemPrincipal(novaLinguagem);
                System.out.println("Vai usar framework?");
                System.out.println("| 1 - SIM |");
                System.out.println("| 2 - NÃO |");
                int opc = scanner.nextInt();
                scanner.nextLine();
                if (opc == 1) {
                    System.out.println("Qual o novo framework?");
                    String novoFrame = scanner.nextLine();
                    projetoDev.setFramework(novoFrame);
                } else {
                    projetoDev.setFramework("Sem framework");
                }
                System.out.println("Dados atualizados com sucesso!");
            } else if (projetoEscolhido instanceof ProjetoPesquisa) {
                ProjetoPesquisa projetoPesquisa = (ProjetoPesquisa) projetoEscolhido;
                System.out.println("Nova Área de pesquisa:");
                String novaArea = scanner.nextLine();
                System.out.println("Nova instituição financiadora:");
                String novaInsti = scanner.nextLine();
                projetoPesquisa.setAreaPesquisa(novaArea);
                projetoPesquisa.setInstituicaoFinanciadora(novaInsti);
                System.out.println("Dados atualizados com sucesso!");
            } else {
                throw new InvalidProjetoTypeException(EnumProjetoException.TipoProjetoInvalido.toString());
            }
        } else {
            throw new ProjetoNotFoundException(EnumProjetoException.ProjetoNaoEncontrado.toString());
        }
    }

    public void listarColaboradores(int index) {
        ArrayList<Projeto> projetos = projetoRepositorio.listarProjetos();
        Projeto projeto = projetos.get(index);
        ArrayList<Colaborador> colaboradores = projeto.listarColaboradores();

        if (colaboradores.isEmpty()) {
            System.out.println("Nenhum colaborador encontrado.");
        } else {
            for (int i = 0; i < colaboradores.size(); i++) {
                Colaborador c = colaboradores.get(i);
                String nome = c.getNome();
                String cargo = c.getCargo();
                int anosExp = c.getAnosExperiencia();

                System.out.println(
                        (i + 1) + "| Colaborador: " + nome + " | Cargo: " + cargo + " | Anos de Exp: " + anosExp);

            }
        }

    }

}
