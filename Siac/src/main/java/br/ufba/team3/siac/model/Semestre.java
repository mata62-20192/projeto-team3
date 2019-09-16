package br.ufba.team3.siac.model;

import java.sql.Date;

public class Semestre {
    private long id;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
