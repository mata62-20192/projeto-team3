package br.ufba.team3.siac.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Semestre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String codigo;
    private Date inicioDoSemestre;
    private Date fimDoSemestre;
    private boolean isAtual;

    public Semestre(String codigo, Date inicioDoSemestre) {
        this.codigo = codigo;
        this.inicioDoSemestre = inicioDoSemestre;
    }

    public Semestre() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getInicioDoSemestre() {
        return inicioDoSemestre;
    }

    public void setInicioDoSemestre(Date inicioDoSemestre) {
        this.inicioDoSemestre = inicioDoSemestre;
    }

    public Date getFimDoSemestre() {
        return fimDoSemestre;
    }

    public void setFimDoSemestre(Date fimDoSemestre) {
        this.fimDoSemestre = fimDoSemestre;
    }

    public boolean isAtual() {
        return isAtual;
    }

    public void setAtual(boolean atual) {
        isAtual = atual;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
