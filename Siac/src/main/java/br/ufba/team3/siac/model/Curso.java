package br.ufba.team3.siac.model;

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
}
