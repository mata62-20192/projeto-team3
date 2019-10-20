package br.ufba.team3.siac.model;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String codigo;
    private String nome;
    private List<DisciplinaCurso> disciplinasCurso;

    public Curso() {}

    public Curso(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
        this.disciplinasCurso = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void addDisciplinaCurso(DisciplinaCurso disciplinaCurso) {
        this.disciplinasCurso.add(disciplinaCurso);
    }

    public List<DisciplinaCurso> getDisciplinasCurso() {
        return disciplinasCurso;
    }
}
