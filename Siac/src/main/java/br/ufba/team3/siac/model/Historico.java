package br.ufba.team3.siac.model;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Historico implements Imprimir{
    private List<DisciplinaCursada> disciplinaCursadasObrigatoria;
    private List<DisciplinaCursada> disciplinaCursadaOptativa;
    private Aluno aluno;

    public Historico(Aluno aluno) {
        this.disciplinaCursadasObrigatoria = new ArrayList<>();
        this.disciplinaCursadaOptativa = new ArrayList<>();
        this.aluno = aluno;
    }

    public void addDisciplinaCursada(DisciplinaCursada disciplinaCursada) {
        if (disciplinaCursada.getDisciplinaCurso().getNatureza() == Natureza.OBRIGATORIO) {
            this.disciplinaCursadasObrigatoria.add(disciplinaCursada);
        } else {
            this.disciplinaCursadaOptativa.add(disciplinaCursada);
        }
    }

    private Integer cargaHorariaTotal() {
        Integer total = 0;
        total += this.disciplinaCursadasObrigatoria.stream()
                .reduce(0, (resultado, disciplina) ->
                        resultado + disciplina.getDisciplinaCurso().getDisciplina().getCargaHoraria(), Integer::sum);
        total += this.disciplinaCursadaOptativa.stream()
                .reduce(0, (resultado, disciplina) ->
                        resultado + disciplina.getDisciplinaCurso().getDisciplina().getCargaHoraria(), Integer::sum);
        return total;
    }

    private double CR() {
        Double CR = 0.0;
        CR += this.disciplinaCursadasObrigatoria.stream().map(disciplinaCursada ->
            (disciplinaCursada.getConceito() == Conceito.APROVADO || disciplinaCursada.getConceito() == Conceito.REPROVADOPORNOTA) ? disciplinaCursada.getNota() : 0.0
        ).reduce(0.00,(a,b) -> a+b);
        CR += this.disciplinaCursadaOptativa.stream().map(disciplinaCursada ->
                (disciplinaCursada.getConceito() == Conceito.APROVADO || disciplinaCursada.getConceito() == Conceito.REPROVADOPORNOTA) ? disciplinaCursada.getNota() : 0.0
        ).reduce(0.00,(a,b) -> a+b);
       return CR/(this.disciplinaCursadaOptativa.size()+this.disciplinaCursadasObrigatoria.size());
    }

    public String conteudoTXT() {
        Collections.sort(this.disciplinaCursadasObrigatoria);
        StringBuilder dados = new StringBuilder("");
        dados.append("Matricula: " + this.aluno.getMatricula() + "\r\n");
        dados.append( "Nome: " + this.aluno.getNome() + "\r\n");
        dados.append( "Curso: " + this.aluno.getCurso().getNome() + "\r\n");
        dados.append( "CR: " + this.CR() + "\r\n");
        dados.append( "Carga Horária Total: " + this.cargaHorariaTotal() + "\r\n");
        dados.append("Semestre|Natureza|Carga Horária|Nome da Disciplina|Nota|Resultado\r\n");
        dados.append(this.disciplinaCursadasObrigatoria.stream().map(disciplinaCursada ->
            disciplinaCursada.getSemestre() + " - " +
                    disciplinaCursada.getDisciplinaCurso().getDisciplina().getNomeDisciplina() + " - " +
                    disciplinaCursada.getDisciplinaCurso().getNatureza().getTexto() + " " +
                    disciplinaCursada.getDisciplinaCurso().getDisciplina().getCargaHoraria() + " " +
                    (disciplinaCursada.getNota() != null ? disciplinaCursada.getNota() : "--") + " " +
                    disciplinaCursada.getConceito().getTexto() + " \r\n"
        ).collect(Collectors.joining("")));
        dados.append( this.disciplinaCursadaOptativa.stream().map(disciplinaCursada ->
                "  - " +
                        disciplinaCursada.getDisciplinaCurso().getDisciplina().getNomeDisciplina() + " - " +
                        disciplinaCursada.getDisciplinaCurso().getNatureza().getTexto() + " " +
                        disciplinaCursada.getDisciplinaCurso().getDisciplina().getCargaHoraria() + " " +
                        (disciplinaCursada.getNota() != null ? disciplinaCursada.getNota() : "--") + " " +
                        disciplinaCursada.getConceito().getTexto() + " \r\n"
        ).collect(Collectors.joining("")));
        return dados.toString();
    }

    public String conteudoHTML() {
        Collections.sort(this.disciplinaCursadasObrigatoria);
        String htmlString = "";
        try {
            File templateHTML = new File("./src/main/resources/utils/templateHistorico.html");
            htmlString = FileUtils.readFileToString(templateHTML, "UTF-8");
            String matricula = aluno.getMatricula();
            String nome = aluno.getNome();
            String curso = aluno.getCurso().getNome();
            String cr = Double.toString(this.CR());
            String cargaHorariaTotal = Integer.toString(this.cargaHorariaTotal());
            StringBuilder dados = new StringBuilder("");
            dados.append(this.disciplinaCursadasObrigatoria.stream().map(disciplinaCursada ->
                    "<tr>" +
                            "<td class=\"text-center\">" + disciplinaCursada.getSemestre() + "</td>" +
                            "<td>" + disciplinaCursada.getDisciplinaCurso().getDisciplina().getNomeDisciplina() + "</td>" +
                            "<td class=\"text-center\">" + disciplinaCursada.getDisciplinaCurso().getNatureza().getTexto() + "</td>" +
                            "<td class=\"text-center\">" + disciplinaCursada.getDisciplinaCurso().getDisciplina().getCargaHoraria() + "</td>" +
                            "<td class=\"text-center\">" + (disciplinaCursada.getNota() != null ? disciplinaCursada.getNota() : "--") + "</td>" +
                            "<td class=\"text-center\">" + disciplinaCursada.getConceito().getTexto() + "</td></tr>"
            ).collect(Collectors.joining("")));
            dados.append( this.disciplinaCursadaOptativa.stream().map(disciplinaCursada ->
                    "<tr>" +
                            "<td>" + " " + "</td>" +
                            "<td>" + disciplinaCursada.getDisciplinaCurso().getDisciplina().getNomeDisciplina() + "</td>" +
                            "<td class=\"text-center\">" + disciplinaCursada.getDisciplinaCurso().getNatureza().getTexto() + "</td>" +
                            "<td class=\"text-center\">" + disciplinaCursada.getDisciplinaCurso().getDisciplina().getCargaHoraria() + "</td>" +
                            "<td class=\"text-center\">" + (disciplinaCursada.getNota() != null ? disciplinaCursada.getNota() : "--") + "</td>" +
                            "<td class=\"text-center\">" + disciplinaCursada.getConceito().getTexto() + "</td></tr>"
            ).collect(Collectors.joining("")));
            htmlString = htmlString.replace("$matricula", matricula);
            htmlString = htmlString.replace("$nome", nome);
            htmlString = htmlString.replace("$curso", curso);
            htmlString = htmlString.replace("$cr", cr);
            htmlString = htmlString.replace("$matricula", matricula);
            htmlString = htmlString.replace("$cargaHorariaTotal", cargaHorariaTotal);
            htmlString = htmlString.replace("$dados", dados.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return htmlString;
    }
}
