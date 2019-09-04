package br.ufba.team3.siac.model;

import java.util.List;

public class Universidade {
    private String nome;
    private String sigla;
    private List<Curso> cursos;
    private List<Disciplina> disciplinas;

    public Universidade(String nome, String sigla) {
        this.nome = nome;
        this.sigla = sigla;
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

}
