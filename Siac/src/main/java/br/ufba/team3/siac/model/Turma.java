package br.ufba.team3.siac.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Long id;
    private Professor professor;
    @OneToMany(targetEntity = Aluno.class, fetch=FetchType.EAGER)
    private List<Aluno> alunos;
    private Semestre semestre;


    public Turma() {
        this.id = null;
    }

    public Turma(Professor professor, Semestre semestre) {
        this();
        this.professor = professor;
        this.semestre = semestre;

        this.alunos = new ArrayList<Aluno>();
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

}
