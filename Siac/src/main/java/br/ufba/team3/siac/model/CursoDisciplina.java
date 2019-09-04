package br.ufba.team3.siac.model;

import java.util.List;

public class CursoDisciplina {
    private Long id;
    private int semestre;
    private String natureza;
    private String nome;
    private Disciplina disciplina;
    private List<Disciplina> preRequisitos;
    private boolean isObrigatoria = false;

    public CursoDisciplina(String natureza, String nome, Disciplina disciplina) {
        this.natureza = natureza;
        this.nome = nome;
        this.disciplina = disciplina;
    }

    public CursoDisciplina(int semestre, String natureza, String nome) {
        this.semestre = semestre;
        this.natureza = natureza;
        this.nome = nome;
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

    public String getNatureza() {
        return natureza;
    }

    public String getNome() {
        return nome;
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
}
