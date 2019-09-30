package br.ufba.team3.siac.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class CursoDisciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Long id;
    private int semestre = -1;
    private Disciplina disciplina;
    @OneToMany
    private List<Disciplina> preRequisitos;
    private boolean isObrigatoria = false;

    public CursoDisciplina() {
        this.id = null;
    }

    public CursoDisciplina(Disciplina disciplina) {
        this();
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
        String str = "CursoDisciplina{";
        if(isObrigatoria){
            str += "semestre = " + semestre + ", ";
        }
        str += " disciplina=" + disciplina +
                ", isObrigatoria=" + isObrigatoria +
                '}';
        return str;
    }


}
