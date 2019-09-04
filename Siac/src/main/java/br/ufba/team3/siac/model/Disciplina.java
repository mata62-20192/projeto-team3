package br.ufba.team3.siac.model;

public class Disciplina {
    private Long id;
    private String nome;
    private double cargaHorariaTeorica;
    private double cargaHorariaPratica;
    private double estagio;
    private String objetivo;
    private String conteudo;
    private String bibliografia;

    public Disciplina(String nome, double cargaHorariaTeorica, double cargaHorariaPratica, double estagio) {
        this.nome = nome;
        this.cargaHorariaTeorica = cargaHorariaTeorica;
        this.cargaHorariaPratica = cargaHorariaPratica;
        this.estagio = estagio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getCargaHorariaTeorica() {
        return cargaHorariaTeorica;
    }

    public void setCargaHorariaTeorica(double cargaHorariaTeorica) {
        this.cargaHorariaTeorica = cargaHorariaTeorica;
    }

    public double getCargaHorariaPratica() {
        return cargaHorariaPratica;
    }

    public void setCargaHorariaPratica(double cargaHorariaPratica) {
        this.cargaHorariaPratica = cargaHorariaPratica;
    }

    public double getEstagio() {
        return estagio;
    }

    public void setEstagio(double estagio) {
        this.estagio = estagio;
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

    @Override
    public String toString() {
        return "Disciplina{" +
                "nome='" + nome + '\'' +
                ", cargaHorariaTeorica=" + cargaHorariaTeorica +
                ", cargaHorariaPratica=" + cargaHorariaPratica +
                '}';
    }
}
