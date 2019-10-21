package br.ufba.team3.siac.model;

import java.util.Objects;

public class Aluno {
    private final String matricula;
    private final String nome;
    private final String senha;
    private final Curso curso;
    private Historico historico;

    public Aluno(String matricula, String nome, String senha, Curso curso) {
        this.matricula = matricula;
        this.nome = nome;
        this.senha = senha;
        this.curso = curso;
        this.historico = new Historico();
    }

    public Curso getCurso() {
        return curso;
    }

    public Historico getHistorico() {
        return historico;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aluno)) return false;
        Aluno aluno = (Aluno) o;
        return getMatricula().equals(aluno.getMatricula());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMatricula());
    }

    public String getSenha() {
        return senha;
    }
}
