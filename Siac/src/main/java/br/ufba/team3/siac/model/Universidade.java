package br.ufba.team3.siac.model;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Universidade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Long id;
    private String nome;
    private String sigla;
    @OneToMany(targetEntity = Curso.class, fetch=FetchType.LAZY)
    private List<Curso> cursos;
    @OneToMany(targetEntity = Disciplina.class, fetch=FetchType.LAZY)
    private List<Disciplina> disciplinas;

    public Universidade(String nome, String sigla) {
        this();
        this.nome = nome;
        this.sigla = sigla;
        this.cursos = new ArrayList<Curso>();
        this.disciplinas = new ArrayList<Disciplina>();
    }

    public Universidade() {
        this.id = null;
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

    public void addCurso(Curso curso){
        this.cursos.add(curso);
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void addDisciplinas(Disciplina disciplina) {
        this.disciplinas.add(disciplina);
    }
}
