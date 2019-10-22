package br.ufba.team3.siac.model;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private final String codigo;
    private final String nome;
    private final List<DisciplinaCurso> disciplinasCurso;
    private Curriculo curriculo;

    public Curso(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
        this.disciplinasCurso = new ArrayList<>();
    }

    public Curriculo getCurriculo() {
        return this.curriculo;
    }

    public void setCurriculo(Curriculo curriculo) {
        this.curriculo = curriculo;
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

    public DisciplinaCurso findDisciplinaCurso(String codigoDisciplina) {
        for (DisciplinaCurso disciplinaCurso : this.disciplinasCurso) {
            if (disciplinaCurso.getDisciplina().getCodigoDisciplina().equals(codigoDisciplina)) {
                return disciplinaCurso;
            }
        }
        return null;
    }
}
