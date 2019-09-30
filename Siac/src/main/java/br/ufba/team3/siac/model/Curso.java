package br.ufba.team3.siac.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Long id;
    private String codigo;
    private String nome;
    private Turno turno;
    private BigDecimal duracaoMinima;
    private BigDecimal duracaoMaxima;
    private String periodo;
    private String baseLegal;
    private String descricaoProfissional;
    @OneToMany(targetEntity = CursoDisciplina.class, fetch=FetchType.LAZY)
    private List<CursoDisciplina> disciplinas;

    public Curso(String nome, Turno turno, BigDecimal duracaoMinima, BigDecimal duracaoMaxima, String periodo, String baseLegal, String descricaoProfissional) {
        this();
        this.nome = nome;
        this.turno = turno;
        this.duracaoMinima = duracaoMinima;
        this.duracaoMaxima = duracaoMaxima;
        this.periodo = periodo;
        this.baseLegal = baseLegal;
        this.descricaoProfissional = descricaoProfissional;
        this.disciplinas = new ArrayList<>();
    }

    public Curso(String codigo, String nome) {
        this();
        this.codigo = codigo;
        this.nome = nome;
        this.disciplinas = new ArrayList<CursoDisciplina>();
    }

    public Curso() {
        this.id = null;
    }

    public Long getId() {
        return id;
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

    public BigDecimal getDuracaoMinima() {
        return duracaoMinima;
    }

    public void setDuracaoMinima(BigDecimal duracaoMinima) {
        this.duracaoMinima = duracaoMinima;
    }

    public BigDecimal getDuracaoMaxima() {
        return duracaoMaxima;
    }

    public void setDuracaoMaxima(BigDecimal duracaoMaxima) {
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
