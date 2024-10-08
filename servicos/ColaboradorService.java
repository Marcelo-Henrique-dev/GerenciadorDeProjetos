package servicos;

import java.util.ArrayList;
import java.util.Scanner;

import entidades.Colaborador;
import interfaces.IColaboradoresServicos;
import repositorios.ColaboradorRepositorio;

public class ColaboradorService implements IColaboradoresServicos {

    private Scanner scanner = new Scanner(System.in);
    private ColaboradorRepositorio colaboradores = new ColaboradorRepositorio();
    private ArrayList<Colaborador> repositorio = colaboradores.repositorio();

    @Override
    public void cadastrarColaborador() {
        System.out.println("Qual o nome do colaborador?");
        String nome = scanner.nextLine();
        System.out.println("Qual o cargo ele ocupa?");
        String cargo = scanner.nextLine();
        System.out.println("Quantos anos de experiência ele tem?");
        int anosExperiencia = scanner.nextInt();
        scanner.nextLine();
        repositorio.add(criarColaborador(nome, cargo, anosExperiencia));
        System.out.println("Colaborador " + nome + " cadastrado com sucesso!");
    }

    private Colaborador criarColaborador(String nome, String cargo, int anosExperiencia) {
        return new Colaborador(nome, cargo, anosExperiencia);
    }

    @Override
    public void listarColaboradores() {
        for (int i = 0; i < repositorio.size(); i++) {
            Colaborador colaborador = repositorio.get(i);
            System.out.println("Id: " + i + " | Nome: " + colaborador.getNome() + " | Cargo: " + colaborador.getCargo()
                    + " | Anos de Experiência: " + colaborador.getAnosExperiencia());
        }
        System.out.println("Deseja editar algum colaborador?");
        System.out.println("| 1 - SIM | 2 - NÃO |");
        int opc = scanner.nextInt();
        scanner.nextLine();
        switch (opc) {
            case 1:
                editarColaborador();
                break;
            case 2:
                System.out.println("Deseja apagar algum colaborador?");
                System.out.println("| 1 - SIM | 2 - NÃO |");
                int opcDelete = scanner.nextInt();
                scanner.nextLine();
                switch (opcDelete) {
                    case 1:
                        apagarColaborador();
                        break;
                    case 2:
                        System.out.println("OK saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
    }

    @Override
    public void editarColaborador() {
        System.out.println("Escolha o colaborador pelo id:");
        int opc = scanner.nextInt();
        scanner.nextLine();
        if (opc > repositorio.size()) {
            System.out.println("Escolha um id válido");
            editarColaborador();
        } else {
            Colaborador colaboradorEscolhido = repositorio.get(opc);
            if (repositorio.contains(colaboradorEscolhido)) {
                System.out.println("Qual o novo nome?");
                String novoNome = scanner.nextLine();
                colaboradorEscolhido.setNome(novoNome);
                System.out.println("Qual o novo cargo?");
                String novoCargo = scanner.nextLine();
                colaboradorEscolhido.setCargo(novoCargo);
                System.out.println("Quantos anos de Experiência ele tem?");
                int novoAnosExperiencia = scanner.nextInt();
                colaboradorEscolhido.setAnosExperiencia(novoAnosExperiencia);
                System.out.println("Colaborador editado com sucesso!");
            }else{
                System.out.println("Colaborador não encontrado");
            }
        }
    }

    @Override
    public void apagarColaborador() {
        System.out.println("Escolha o colaborador pelo id:");
        int opc = scanner.nextInt();
        scanner.nextLine();
        if(opc > repositorio.size()){
            System.out.println("Escolha um id válido");
            apagarColaborador();
        }else{
            Colaborador colaboradorEscolhido = repositorio.get(opc);
            if(repositorio.contains(colaboradorEscolhido)){
                repositorio.remove(colaboradorEscolhido);
                System.out.println("Colaborador removido com sucesso");
            }else{
                System.out.println("Colaborador não encontrado");
            }
        }
    }

}
