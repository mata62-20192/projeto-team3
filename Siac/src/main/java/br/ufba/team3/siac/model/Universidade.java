package br.ufba.team3.siac.model;

import java.util.ArrayList;
import java.util.List;

public class Universidade {
    private final List<Curso> cursos;
    private final List<Disciplina> disciplinas;
    private final List<Aluno> alunos;
    private String nome;

    public Universidade() {
        this.cursos = new ArrayList<>();
        this.disciplinas = new ArrayList<>();
        this.alunos = new ArrayList<>();
    }

    public void addCurso(Curso curso) {
        curso.setCurriculo(new Curriculo(curso));
        this.cursos.add(curso);
    }

    public void addDisciplina(Disciplina disciplina) {
        this.disciplinas.add(disciplina);
    }

    public void addAluno(Aluno aluno) {
        this.alunos.add(aluno);
    }

    public Disciplina findDisciplina(String codigoDisciplina) {
        for (Disciplina disciplina : this.disciplinas) {
            if (disciplina.getCodigoDisciplina().equals(codigoDisciplina)) {
                return disciplina;
            }
        }
        return null;
    }

    public Aluno findAluno(String matricula) {
        for (Aluno aluno : this.alunos) {
            if (aluno.getMatricula().equals(matricula)) {
                return aluno;
            }
        }
        return null;
    }

    public Curso findCurso(String codigo) {
        for (Curso curso : this.cursos) {
            if (curso.getCodigo().equals(codigo)) {
                return curso;
            }
        }
        return null;
    }

    public String getNome() {
        return nome;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    @Override
    public String toString() {
        return "Universidade{" +
                "nome='" + nome + '\'' +
                ", cursos=" + cursos +
                ", disciplinas=" + disciplinas +
                '}';
    }
}
