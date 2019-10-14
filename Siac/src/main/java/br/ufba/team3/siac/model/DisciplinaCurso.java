package br.ufba.team3.siac.model;

import java.util.HashSet;
import java.util.Set;

public class DisciplinaCurso {
    private Disciplina disciplina;
    private int semestre;
    private HashSet<Disciplina> preRequisitos;
    private Natureza natureza;

    public DisciplinaCurso(Disciplina disciplina, int semestre, HashSet<Disciplina> preRequisitos, Natureza natureza) {
        this.disciplina = disciplina;
        this.semestre = semestre;
        this.preRequisitos = preRequisitos;
        this.natureza = natureza;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public int getSemestre() {
        return semestre;
    }

    public Set<Disciplina> getPreRequisitos() {
        return preRequisitos;
    }

    public Natureza getNatureza() {
        return natureza;
    }
}
