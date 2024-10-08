import java.util.Scanner;

import exceptions.InvalidProjetoTypeException;
import exceptions.ProjetoNotFoundException;
import servicos.ColaboradorService;
import servicos.ProjetoService;

public class Main {
    private static ProjetoService projetoService = new ProjetoService();
    private static ColaboradorService colaboradorService = new ColaboradorService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws ProjetoNotFoundException, InvalidProjetoTypeException {
        int opc;
        do {
            System.out.println("Menu: ");
            System.out.println("| 1 - Adicionar Projeto |");
            System.out.println("| 2 - Listar Projetos |");
            System.out.println("| 3 - Cadastrar Colaboradores |");
            System.out.println("| 4 - Listar Colaboradores |");
            System.out.println("| 0 - Sair |");
            opc = scanner.nextInt();
            scanner.nextLine();

            switch (opc) {
                case 1:
                    projetoService.cadastrarProjeto();
                    break;
                case 2:
                    projetoService.listarProjetos();
                    break;
                case 3:
                    colaboradorService.cadastrarColaborador();
                    break;
                case 4:
                    colaboradorService.listarColaboradores();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }

        } while (opc != 0);
    }
}