package br.ufba.team3.siac.model;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private Long id;
    private String nome;
    private Turno turno;
    private double duracaoMinima;
    private double duracaoMaxima;
    private String periodo;
    private String baseLegal;
    private String descricaoProfissional;
    private List<CursoDisciplina> disciplinas;

    public Curso(String nome, Turno turno, double duracaoMinima, double duracaoMaxima, String periodo, String baseLegal, String descricaoProfissional) {
        this.nome = nome;
        this.turno = turno;
        this.duracaoMinima = duracaoMinima;
        this.duracaoMaxima = duracaoMaxima;
        this.periodo = periodo;
        this.baseLegal = baseLegal;
        this.descricaoProfissional = descricaoProfissional;
        this.disciplinas = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public double getDuracaoMinima() {
        return duracaoMinima;
    }

    public void setDuracaoMinima(double duracaoMinima) {
        this.duracaoMinima = duracaoMinima;
    }

    public double getDuracaoMaxima() {
        return duracaoMaxima;
    }

    public void setDuracaoMaxima(double duracaoMaxima) {
        this.duracaoMaxima = duracaoMaxima;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getBaseLegal() {
        return baseLegal;
    }

    public void setBaseLegal(String baseLegal) {
        this.baseLegal = baseLegal;
    }

    public String getDescricaoProfissional() {
        return descricaoProfissional;
    }

    public void setDescricaoProfissional(String descricaoProfissional) {
        this.descricaoProfissional = descricaoProfissional;
    }

    public List<CursoDisciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplina(CursoDisciplina cursoDisciplina){
        this.disciplinas.add(cursoDisciplina);
    }

    @Override
    public String toString() {
        return "Curso{" +
                "nome='" + nome + '\'' +
                ", disciplinas=" + disciplinas +
                '}';
    }
}
