package interfaces;

import exceptions.InvalidProjetoTypeException;
import exceptions.ProjetoNotFoundException;

public interface IProjetosServicos {
    public void cadastrarProjeto();
    public void listarProjetos() throws ProjetoNotFoundException, InvalidProjetoTypeException;
    public void editarProjeto() throws ProjetoNotFoundException, InvalidProjetoTypeException;
    public void apagarProjeto();
}
