package br.ufba.team3.siac.model;

import java.util.List;

public class Turma {
    private Professor professor;
    private List<Aluno> alunos;
    private Semestre semestre;
    private Disciplina disciplina;

    public Turma() {
    }

    public Turma(Professor professor, Semestre semestre, Disciplina disciplina) {
        this.professor = professor;
        this.semestre = semestre;
        this.disciplina = disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(Aluno aluno) {
        this.alunos.add(aluno);
    }

    public Semestre getSemestre() {
        return semestre;
    }

    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
}
