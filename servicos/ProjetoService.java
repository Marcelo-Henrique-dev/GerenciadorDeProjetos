package servicos;

import java.util.ArrayList;
import java.util.Scanner;

import entidades.Projeto;
import entidades.ProjetoDesenvolvimento;
import entidades.ProjetoPesquisa;
import entidades.enums.EnumProjetoException;
import entidades.enums.TipoProjeto;
import exceptions.InvalidProjetoTypeException;
import exceptions.ProjetoNotFoundException;
import interfaces.IProjetosServicos;
import repositorios.ProjetosRepositorio;

public class ProjetoService implements IProjetosServicos {
    private Scanner scanner = new Scanner(System.in);
    private ProjetosRepositorio projetoRepositorio = new ProjetosRepositorio();
    private ArrayList<Projeto> projetos = projetoRepositorio.repositorio();

    @Override
    public void cadastrarProjeto() {
        try{
            String linguagem = "Linguagem Padrão";
            String framework = "Sem framework";
            String area = "Área Padrão";
            String instituicao = "Instituição Padrão";

            System.out.println("Tipo do Projeto: ");
            System.out.println("| 1 - Desenvolvimento |");
            System.out.println("| 2 - Pesquisa |");
            int tipoOpc = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Nome do projeto: ");
            String nome = scanner.nextLine();
            System.out.println("Orçamento: ");
            int orcamento = scanner.nextInt();
            scanner.nextLine();
            if (tipoOpc == 1) {
                System.out.println("Qual a Linguagem Principal?");
                linguagem = scanner.nextLine();
                System.out.println("Está usando algum framework?");
                System.out.println("| 1 - Sim |");
                System.out.println("| 2 - Não |");
                int frameworkOpc = scanner.nextInt();
                scanner.nextLine();
                if (frameworkOpc == 1) {
                    System.out.println("Qual?");
                    framework = scanner.nextLine();
                }
            } else if (tipoOpc == 2) {
                System.out.println("Qual a área de pesquisa?");
                area = scanner.nextLine();
                System.out.println("Qual a instituição financiadora?");
                instituicao = scanner.nextLine();
            }
            TipoProjeto tipo = null;
            switch (tipoOpc) {
                case 1:
                    tipo = TipoProjeto.DESENVOLVIMENTO;
                    break;
                case 2:
                    tipo = TipoProjeto.PESQUISA;
                    break;
                default:
                    throw new InvalidProjetoTypeException("Tipo do projeto inválido!");
            }
            Projeto projeto = criarProjeto(nome, orcamento, tipo, linguagem, framework, area, instituicao);
            projetoRepositorio.repositorio().add(projeto);
            System.out.println("Projeto "+nome+"cadastrado com sucesso!");
        }catch(InvalidProjetoTypeException e){
            System.out.println("Erro: "+e.getMessage());
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

    @Override
    public void apagarProjeto() {
        System.out.println("Escolha pelo id:");
        int index = scanner.nextInt();
        scanner.nextLine();
        if(index > projetos.size()+1){
            System.out.println("Favor digite um id válido!");
            apagarProjeto();
        }else{
            Projeto projetoSelecionado = projetos.get(index);
            if(projetos.contains(projetoSelecionado)){
                projetos.remove(projetoSelecionado);
                System.out.println("Projeto removido com sucesso!");
            }else{
                System.out.println("Projeto não encontrado!");
            }
        }
    }

    @Override
    public void listarProjetos() throws ProjetoNotFoundException, InvalidProjetoTypeException {
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
                    editarProjeto();
                    break;
                case 2:
                    System.out.println("Deseja Apagar algum projeto?");
                    System.out.println("| 1 - SIM |");
                    System.out.println("| 2 - NÃO |");
                    int deletar = scanner.nextInt();
                    scanner.nextLine();
                    if (deletar == 1) {
                        apagarProjeto();
                    } else {
                        System.out.println("OK saindo...");
                    }
                    break;
                default:
                    System.out.println("Opção Inválida...");
            }
        }
    }

    @Override
    public void editarProjeto() throws ProjetoNotFoundException, InvalidProjetoTypeException {
        System.out.println("Escolher projeto pelo id:");
        int index = scanner.nextInt();
        scanner.nextLine();
        if(index > projetos.size()){
            System.out.println("Escolha um id válido");
            editarProjeto();
        }else{
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
    }

}
