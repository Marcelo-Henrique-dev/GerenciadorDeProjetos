import java.util.Scanner;

import entidades.enums.TipoProjeto;
import exceptions.InvalidProjetoTypeException;
import servicos.ProjetoService;

public class Main{
    private static ProjetoService projetoService = new ProjetoService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opc;
        do{
            System.out.println("Menu: ");
            System.out.println("| 1 - Adicionar Projeto |");
            System.out.println("| 2 - Listar Projetos |");
            System.out.println("| 3 - Sair |");
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
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }

        }while(opc != 3);
    }

    public static void adicionarProjeto(){
        try{
            System.out.println("Nome do projeto: ");
            String nome = scanner.nextLine();
            System.out.println("Orçamento: ");
            int orcamento = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Tipo do Projeto: ");
            System.out.println("| 1 - Desenvolvimento |");
            System.out.println("| 2 - Pesquisa |");
            int tipoOpc = scanner.nextInt();
            scanner.nextLine();

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

            projetoService.adicionarProjeto(nome, orcamento, tipo);

        }catch(InvalidProjetoTypeException e){
            System.out.println("Erro: "+e.getMessage());
        }
    }

}