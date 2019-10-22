package br.ufba.team3.siac.model;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Historico {
    private List<DisciplinaCursada> disciplinaCursadasObrigatoria;
    private List<DisciplinaCursada> disciplinaCursadaOptativa;

    public Historico() {
        this.disciplinaCursadasObrigatoria = new ArrayList<>();
        this.disciplinaCursadaOptativa = new ArrayList<>();
    }

    public void addDisciplinaCursada(DisciplinaCursada disciplinaCursada) {
        if (disciplinaCursada.getDisciplinaCurso().getNatureza() == Natureza.OBRIGATORIO) {
            this.disciplinaCursadasObrigatoria.add(disciplinaCursada);
        } else {
            this.disciplinaCursadaOptativa.add(disciplinaCursada);
        }
    }

    private Integer cargaHorariaTotal() {
        int cargaHoraria = 0;
        for (DisciplinaCursada disciplinaCursada : disciplinaCursadasObrigatoria
        ) {
            cargaHoraria += disciplinaCursada.getDisciplinaCurso().getDisciplina().getCargaHoraria();
        }
        for (DisciplinaCursada disciplinaCursada : disciplinaCursadaOptativa
        ) {
            cargaHoraria += disciplinaCursada.getDisciplinaCurso().getDisciplina().getCargaHoraria();
        }
        return cargaHoraria;
    }

    private double CR() {
        Double CR = 0.0;
        for (DisciplinaCursada disciplinaCursada : disciplinaCursadasObrigatoria
        ) {
            if (disciplinaCursada.getConceito() == Conceito.APROVADO || disciplinaCursada.getConceito() == Conceito.REPROVADOPORNOTA) {
                CR += disciplinaCursada.getNota();
            }
        }
        for (DisciplinaCursada disciplinaCursada : disciplinaCursadaOptativa
        ) {
            if (disciplinaCursada.getConceito() == Conceito.APROVADO || disciplinaCursada.getConceito() == Conceito.REPROVADOPORNOTA) {
                CR += disciplinaCursada.getNota();
            }
        }
        return (CR / (disciplinaCursadasObrigatoria.size() + disciplinaCursadaOptativa.size()));
    }

    public String imprimirTXT(Aluno aluno) {
        Collections.sort(this.disciplinaCursadasObrigatoria);
        String dados = "";
        dados += "Matricula: " + aluno.getMatricula() + "\r\n";
        dados += "Nome: " + aluno.getNome() + "\r\n";
        dados += "Curso: " + aluno.getCurso().getNome() + "\r\n";
        dados += "CR: " + this.CR() + "\r\n";
        dados += "Carga Horária Total: " + this.cargaHorariaTotal() + "\r\n";
        dados += "Semestre|Natureza|Carga Horária|Nome da Disciplina|Nota|Resultado\r\n";
        for (DisciplinaCursada disciplinaCursada : this.disciplinaCursadasObrigatoria) {
            dados += disciplinaCursada.getSemestre() + " - " +
                    disciplinaCursada.getDisciplinaCurso().getDisciplina().getNomeDisciplina() + " - " +
                    disciplinaCursada.getDisciplinaCurso().getNatureza().getTexto() + " " +
                    disciplinaCursada.getDisciplinaCurso().getDisciplina().getCargaHoraria() + " " +
                    (disciplinaCursada.getNota() != null ? disciplinaCursada.getNota() : "--") + " " +
                    disciplinaCursada.getConceito().getTexto() + " ";
            dados += "\r\n";
        }
        for (DisciplinaCursada disciplinaCursada : this.disciplinaCursadaOptativa) {
            dados += "  - " +
                    disciplinaCursada.getDisciplinaCurso().getDisciplina().getNomeDisciplina() + " - " +
                    disciplinaCursada.getDisciplinaCurso().getNatureza().getTexto() + " " +
                    disciplinaCursada.getDisciplinaCurso().getDisciplina().getCargaHoraria() + " " +
                    (disciplinaCursada.getNota() != null ? disciplinaCursada.getNota() : "--") + " " +
                    disciplinaCursada.getConceito().getTexto() + " ";
            dados += "\r\n";
        }
        return dados;
    }

    public String imprimirHTML(Aluno aluno) {
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
            String dados = "";
            for (DisciplinaCursada disciplinaCursada : this.disciplinaCursadasObrigatoria) {
                dados += "<tr>" +
                        "<td class=\"text-center\">" + disciplinaCursada.getSemestre() + "</td>" +
                        "<td>" + disciplinaCursada.getDisciplinaCurso().getDisciplina().getNomeDisciplina() + "</td>" +
                        "<td class=\"text-center\">" + disciplinaCursada.getDisciplinaCurso().getNatureza().getTexto() + "</td>" +
                        "<td class=\"text-center\">" + disciplinaCursada.getDisciplinaCurso().getDisciplina().getCargaHoraria() + "</td>" +
                        "<td class=\"text-center\">" + (disciplinaCursada.getNota() != null ? disciplinaCursada.getNota() : "--") + "</td>" +
                        "<td class=\"text-center\">" + disciplinaCursada.getConceito().getTexto() + "</td>";
                dados += "</tr>";
            }
            for (DisciplinaCursada disciplinaCursada : this.disciplinaCursadaOptativa) {
                dados += "<tr>" +
                        "<td>" + " " + "</td>" +
                        "<td>" + disciplinaCursada.getDisciplinaCurso().getDisciplina().getNomeDisciplina() + "</td>" +
                        "<td class=\"text-center\">" + disciplinaCursada.getDisciplinaCurso().getNatureza().getTexto() + "</td>" +
                        "<td class=\"text-center\">" + disciplinaCursada.getDisciplinaCurso().getDisciplina().getCargaHoraria() + "</td>" +
                        "<td class=\"text-center\">" + (disciplinaCursada.getNota() != null ? disciplinaCursada.getNota() : "--") + "</td>" +
                        "<td class=\"text-center\">" + disciplinaCursada.getConceito().getTexto() + "</td>";
                dados += "</tr>";
            }
            htmlString = htmlString.replace("$matricula", matricula);
            htmlString = htmlString.replace("$nome", nome);
            htmlString = htmlString.replace("$curso", curso);
            htmlString = htmlString.replace("$cr", cr);
            htmlString = htmlString.replace("$matricula", matricula);
            htmlString = htmlString.replace("$cargaHorariaTotal", cargaHorariaTotal);
            htmlString = htmlString.replace("$dados", dados);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return htmlString;
    }
}
