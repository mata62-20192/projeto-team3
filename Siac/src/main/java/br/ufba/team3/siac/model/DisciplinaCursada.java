package br.ufba.team3.siac.model;

import java.util.Objects;

public class DisciplinaCursada implements Comparable<Object> {
    private final Integer semestre;
    private final DisciplinaCurso disciplinaCurso;
    private Double nota;
    private Conceito conceito;

    public DisciplinaCursada(Integer semestre, DisciplinaCurso disciplinaCurso) {
        this.semestre = semestre;
        this.disciplinaCurso = disciplinaCurso;
    }

    public void setConceito(Conceito conceito) {
        this.conceito = conceito;
        if(conceito != Conceito.APROVADO && conceito != Conceito.REPROVADOPORNOTA){
            this.nota = null;
        }
    }

    public void setConceitoNota(Conceito conceito, Double nota){
        this.nota = nota;
        this.setConceito(conceito);
    }

    @Override
    public int compareTo(Object o) {
        DisciplinaCursada dc = (DisciplinaCursada) o;
        return this.semestre - dc.getSemestre();
    }

    public DisciplinaCurso getDisciplinaCurso() {
        return disciplinaCurso;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public Double getNota() {
        return nota;
    }


    public Conceito getConceito() {
        return conceito;
    }


    public void adicionarResultado(Conceito conceito, Double nota){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DisciplinaCursada)) return false;
        DisciplinaCursada that = (DisciplinaCursada) o;
        return getDisciplinaCurso().equals(that.getDisciplinaCurso()) &&
                getSemestre().equals(that.getSemestre()) &&
                Objects.equals(getNota(), that.getNota()) &&
                getConceito() == that.getConceito();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSemestre(), getDisciplinaCurso(), getNota(), getConceito());
    }


    @Override
    public String toString() {
        return "DisciplinaCursada{" +
                "semestre=" + semestre +
                ", disciplinaCurso=" + disciplinaCurso +
                ", nota=" + nota +
                ", conceito=" + conceito +
                '}';
    }
}
