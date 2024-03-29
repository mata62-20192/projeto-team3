package br.ufba.team3.siac.model;

import java.util.Objects;

public final class Disciplina {
    private final String nomeDisciplina;
    private final String codigoDisciplina;
    private final int cargaHoraria;

    public Disciplina(String codigoDisciplina, String nomeDisciplina, int cargaHoraria) {
        this.nomeDisciplina = nomeDisciplina;
        this.codigoDisciplina = codigoDisciplina;
        this.cargaHoraria = cargaHoraria;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public String getCodigoDisciplina() {
        return codigoDisciplina;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Disciplina)) return false;
        Disciplina that = (Disciplina) o;
        return getCodigoDisciplina().equals(that.getCodigoDisciplina());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodigoDisciplina());
    }
}
