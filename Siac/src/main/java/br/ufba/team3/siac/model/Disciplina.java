package br.ufba.team3.siac.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Long id;
    private String nome;
    private String codigoDisc;
    private Integer cargaHorariaTotal;
    private String objetivo;
    private String conteudo;
    private String bibliografia;
//    @OneToMany
////    private List<Turma> turmas;

    private Disciplina(){
        this.id = null;
    }

    public Disciplina(String nome, String codigoDisc, Integer cargaHorariaTotal) {
        this();
        this.nome = nome;
        this.codigoDisc = codigoDisc;
        this.cargaHorariaTotal = cargaHorariaTotal;
//        this.turmas = new ArrayList<Turma>();
    }

    public String getCodigoDisc() {
        return codigoDisc;
    }

    public void setCodigoDisc(String codigoDisc) {
        this.codigoDisc = codigoDisc;
    }

    public Integer getCargaHorariaTotal() {
        return cargaHorariaTotal;
    }

    public void setCargaHorariaTotal(Integer cargaHorariaTotal) {
        this.cargaHorariaTotal = cargaHorariaTotal;
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


    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getBibliografia() {
        return bibliografia;
    }

    public void setBibliografia(String bibliografia) {
        this.bibliografia = bibliografia;
    }

//    public List<Turma> getTurmas() {
//        return turmas;
//    }
//
//    public void addTurmas(Turma turma) {
//        this.turmas.add(turma);
//    }

}
