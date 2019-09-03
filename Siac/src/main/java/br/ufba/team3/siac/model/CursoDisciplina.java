package br.ufba.team3.siac.model;

import java.util.List;

public class CursoDisciplina {
    private Long id;
    private int semestre;
    private String natureza;
    private String nome;
    private Disciplina disciplina;
    private List<Disciplina> preRequisitos;
    private boolean isObrigatoria;
}
