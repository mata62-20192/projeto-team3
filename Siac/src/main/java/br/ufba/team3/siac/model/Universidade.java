package br.ufba.team3.siac.model;

import java.util.ArrayList;
import java.util.List;

public class Universidade {
    private String nome;
    private List<Curso> cursos;
    private List<Disciplina> disciplinas;

    public Universidade() {
        this.cursos = new ArrayList<Curso>();
        this.disciplinas = new ArrayList<Disciplina>();
    }

    public void addCurso(Curso curso) {
        this.cursos.add(curso);
    }

    public void addDisciplina(Disciplina disciplina) {
        this.disciplinas.add(disciplina);
    }

    public Disciplina findDisciplina(String codigoDisciplina){
        for (Disciplina disciplina: this.disciplinas) {
            if(disciplina.getCodigoDisciplina().equals(codigoDisciplina)){
                return disciplina;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Universidade{" +
                "nome='" + nome + '\'' +
                ", cursos=" + cursos +
                ", disciplinas=" + disciplinas +
                '}';
    }
}
