package universidade;

import java.util.ArrayList;

public class Aluno extends Pessoa {
    protected String matricula;
    protected Curso curso;
    protected String curriculo;
    protected ArrayList<CursoDisciplina> cursosCursados = new ArrayList<CursoDisciplina>();


    public Aluno(String nome, String cpf, String email, String matricula, Curso curso, String curriculo) {
        super(nome, cpf, email);
        this.curriculo = curriculo;
        this.curso = curso;
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getCurriculo() {
        return curriculo;
    }

    public void setCurriculo(String curriculo) {
        this.curriculo = curriculo;
    }

    public ArrayList<CursoDisciplina> getCursosCursados() {
        return cursosCursados;
    }

    public void setCursosCursados(ArrayList<CursoDisciplina> cursosCursados) {
        this.cursosCursados = cursosCursados;
    }
}
