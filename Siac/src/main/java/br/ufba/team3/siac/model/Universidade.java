package br.ufba.team3.siac.model;

import java.util.ArrayList;
import java.util.List;

public class Universidade {
    private String nome;
    private String sigla;
    private List<Curso> cursos;
    private List<Disciplina> disciplinas;

    public Universidade(String nome, String sigla) {
        this.nome = nome;
        this.sigla = sigla;
        this.cursos = new ArrayList<Curso>();
        this.disciplinas = new ArrayList<Disciplina>();
    }

    public Universidade() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCurso(Curso curso){
        this.cursos.add(curso);
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(Disciplina disciplina) {
        this.disciplinas.add(disciplina);
    }
}
