import java.util.Scanner;

import entidades.enums.TipoProjeto;
import exceptions.InvalidProjetoTypeException;
import servicos.ProjetoService;

public class Main {
    private static ProjetoService projetoService = new ProjetoService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opc;
        do {
            System.out.println("Menu: ");
            System.out.println("| 1 - Adicionar Projeto |");
            System.out.println("| 2 - Listar Projetos |");
            System.out.println("| 3 - Adicionar Colaborador |");
            System.out.println("| 10 - Sair |");
            opc = scanner.nextInt();
            scanner.nextLine();

            switch (opc) {
                case 1:
                    adicionarProjeto();
                    break;
                case 2:
                    projetoService.listarProjetos();
                    break;
                case 3:
                    
                    break;
                case 10:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }

        } while (opc != 10);
    }

    public static void adicionarProjeto() {
        try {
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

            projetoService.adicionarProjeto(nome, orcamento, tipo, linguagem, framework, area, instituicao);

        } catch (InvalidProjetoTypeException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

}