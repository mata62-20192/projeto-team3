package br.ufba.team3.siac.model;

import java.util.List;

public class CursoDisciplina {
    private Long id;
    private int semestre = -1;
    private Disciplina disciplina;
    private List<Disciplina> preRequisitos;
    private boolean isObrigatoria = false;

    public CursoDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public CursoDisciplina(Disciplina disciplina, int semestre) {
        this(disciplina);
        this.semestre = semestre;
        this.isObrigatoria = true;
    }

    public void setPreRequisitos(Disciplina disciplina){
        this.preRequisitos.add(disciplina);
    }

    public Long getId() {
        return id;
    }

    public int getSemestre() {
        return semestre;
    }


    public Disciplina getDisciplina() {
        return disciplina;
    }

    public List<Disciplina> getPreRequisitos() {
        return preRequisitos;
    }

    public boolean isObrigatoria() {
        return isObrigatoria;
    }

    @Override
    public String toString() {
        return "CursoDisciplina{" +
                "semestre=" + semestre + " º"+
                ", disciplina=" + disciplina +
                ", isObrigatoria=" + isObrigatoria +
                '}';
    }
}
