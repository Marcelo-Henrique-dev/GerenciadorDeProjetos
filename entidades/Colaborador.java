package entidades;

public class Colaborador {
    private int idColaborador;
    private String nome;
    private String cargo;
    private int anosExperiencia;

    public Colaborador(String nome, String cargo, int anosExperiencia){
        this.nome = nome;
        this.cargo = cargo;
        this.anosExperiencia = anosExperiencia;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }
    public void setCargo(String cargo){
        this.cargo = cargo;
    }
    public String getCargo(){
        return this.cargo;
    }
    public void setAnosExperiencia(int anosExperiencia){
        this.anosExperiencia = anosExperiencia;
    }
    public int getAnosExperiencia(){
        return this.anosExperiencia;
    }
    public void setIdColaborador(int idColaborador){
        this.idColaborador = idColaborador;
    }
    public int getId(){
        return this.idColaborador;
    }

}
